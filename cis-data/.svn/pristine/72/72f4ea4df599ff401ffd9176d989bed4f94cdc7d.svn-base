package uk.ac.reigate.report


import javax.servlet.*;
import javax.servlet.http.*;
import uk.ac.reigate.report.ReportAuthenticator


class GetReportItem extends HttpServlet {
    
    private final static boolean DEBUG = true;
    private final static String REPORT_SERVER_URL = "http://reports.coulsdon.ac.uk ";
    private final static int BUFFER_SIZE = 2048;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect HTTP POST requests to doGet.
        doGet(request, response);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Extract parameters from request
            String queryString = request.getQueryString();
            
            if(queryString.indexOf("cookie=") == -1)
            {
                // Bail out if no cookie is provided.
                System.out.println("\nGetReportItem - ERROR: No cookie parameter provided. Aborting.");
                return;
            }
            
            String cookie = queryString.substring(queryString.indexOf("cookie"), queryString.indexOf("&") + 1);
            
            queryString = queryString.replaceAll(cookie, "");
            cookie = cookie.substring(cookie.indexOf("=")+1, cookie.length()-1);
            
            String urlString = REPORT_SERVER_URL + "?" +queryString;
            
            if(DEBUG)
            {
                System.out.println("\nGetReportItem - Cookie: " + cookie);
                System.out.println("GetReportItem - Query String: " + queryString);
                System.out.println("GetReportItem - Send to URL: " + urlString);
            }
            
            if (queryString == null)
            {
                // Bail out if no parameters are received.
                ServletOutputStream responseErrorStream = response.getOutputStream();
                responseErrorStream.println("GetReportItem - ERROR: No parameters have been provided.");
                responseErrorStream.close();
                return;
            }
            
            // Establish HTTP GET connection to report server
            URL url = new URL(urlString);
            
            HttpURLConnection repCon = (HttpURLConnection)url.openConnection();
            
            Authenticator.setDefault(new ReportAuthenticator());
            
            repCon.setRequestMethod("GET");
            repCon.setRequestProperty("User-Agent", "Mozilla/5.0");
            repCon.setRequestProperty("Cookie", cookie);
            repCon.setUseCaches(false);
            repCon.setFollowRedirects(false);
            
            // Pipe Report Server's Output to the client using buffered streams.
            response.setContentType(repCon.getContentType());
            response.setHeader("Content-disposition", repCon.getHeaderField("Content-disposition"));
            
            InputStream repInStream = repCon.getInputStream();
            ServletOutputStream clientOutStream = response.getOutputStream();
            
            BufferedInputStream bis = new BufferedInputStream(repInStream);
            BufferedOutputStream bos = new BufferedOutputStream(clientOutStream);
            
            byte[] buff = new byte[BUFFER_SIZE];
            int bytesRead;
            
            while(-1 != (bytesRead = bis.read(buff, 0, BUFFER_SIZE)))
            {
                bos.write(buff, 0, bytesRead);
            }
            
            bis.close();
            bos.close();
            repInStream.close();
            clientOutStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
