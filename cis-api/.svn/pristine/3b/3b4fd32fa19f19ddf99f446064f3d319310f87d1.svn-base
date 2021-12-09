package uk.ac.reigate.filters

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper

import uk.ac.reigate.services.audit.AuditService

@Component
class AuditFilter extends OncePerRequestFilter {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Audit Filter Log");
    
    @Value("\${audit.enabled:true}")
    Boolean enabled
    
    @Value("\${audit.consoleLog:true}")
    Boolean consoleLog
    
    @Value("\${audit.databaseLog:true}")
    Boolean databaseLog
    
    @Autowired
    AuditService auditService
    
    private int maxPayloadLength = 10000;
    
    private String getContentAsString(byte[] buf, int maxLength, String charsetName) {
        if (buf == null || buf.length == 0) return "";
        int length = Math.min(buf.length, this.maxPayloadLength);
        try {
            return new String(buf, 0, length, charsetName);
        } catch (UnsupportedEncodingException ex) {
            return "Unsupported Encoding";
        }
    }
    /**
     * Log each request and response with full Request URI, content payload and duration of the request in ms.
     * 
     * @param request the request
     * @param response the response
     * @param filterChain chain of filters
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Only run filter if enabled
        if (enabled) {
            long startTime = System.currentTimeMillis()
            
            // Retrieve the User details
            SecurityContext context = SecurityContextHolder.getContext()
            Authentication auth = context.getAuthentication()
            UserDetails user = auth.getPrincipal() != 'anonymousUser' ? (UserDetails) auth.getPrincipal() : null
            String username
            if (user != null) {
                username = user.username
            } else {
                username = 'ANNOYMOUS'
            }
            
            // Retrieve URL details
            String uri = request.requestURI
            String method = request.method
            
            // Wrap the Request and Response objects
            ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request)
            ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response)
            
            // Perform the request
            filterChain.doFilter(wrappedRequest, wrappedResponse)
            
            // Calculate duration
            long duration = System.currentTimeMillis() - startTime
            
            // Retrieve Request details
            Map<String, String[]> params = wrappedRequest.getParameterMap()
            String queryString = wrappedRequest.getQueryString()
            String remoteHost = wrappedRequest.getRemoteHost()
            
            // Get Remote IP Address
            String ipAddress = request.getHeader("X-FORWARDED-FOR");
            
            // Retrieve Request Content
            String content = this.getContentAsString(wrappedRequest.getContentAsByteArray(), this.maxPayloadLength, request.getCharacterEncoding())
            
            // Log the request
            if (consoleLog) LOGGER.info("$username accessed $method $uri from Remote Host: $remoteHost, IP Address: $ipAddress, Duration: $duration Params: $params, Query String: $queryString, Content: $content")
            if (databaseLog) auditService.logApiAccess(username, ipAddress, method, uri, params.toString(), content)
            
            // Finish off the response
            wrappedResponse.copyBodyToResponse()
        } else {
            // Skip the audit filter
            filterChain.doFilter(request, response)
        }
    }
}
