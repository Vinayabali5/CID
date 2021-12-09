package uk.ac.reigate.config.security;

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import com.fasterxml.jackson.databind.ObjectMapper

import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint

public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    ObjectMapper objectMapper = new ObjectMapper()
    
    RestAuthenticationEntryPoint() {}
    
    RestAuthenticationEntryPoint(String realmName) {
        this.realmName = realmName
    }
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) {
        response.setContentType("application/json");
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", Calendar.getInstance().getTime());
        String message = authenticationException.getMessage()
        data.put("error", message);
        if (authenticationException instanceof BadCredentialsException) {
            data.put("message", "The username and password supplied are invalid.")
        }
        if (authenticationException instanceof InternalAuthenticationServiceException) {
            data.put("message", "There was a problem communicating with the LDAP server. Please try again. If the problem persists then contact IT Support.")
        }
        response.getOutputStream().println(objectMapper.writeValueAsString(data))
    }
}