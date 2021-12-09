package uk.ac.reigate.report

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.servlet.*;
import javax.servlet.http.*;


class ReportRequest extends HttpServlet {
    
    private final static boolean DEBUG = true;
    private final static String REPORT_SERVER_URL = "http://reports.coulsdon.ac.uk ";
    private final static String REPORT_PATH = "%2fCoulsdon+College+Reports%2f";
    private final static String REPORT_ITEM_SERVLET_URL = "http://localhost:10101/Coulsdon/GetReportItem";
    private final static int BUFFER_SIZE = 2048;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if(DEBUG) {
                System.out.println("\nInitializing Report Request");
                System.out.println("---------------------------");
            }
            
            Authenticator.setDefault(new ReportAuthenticator());
            
            // Generate parameter string from request
            String parameterString = "rs:Command=Render&rc:Toolbar=false";
            
            // Get the list of parameters that can be defined by the user.
            ArrayList availableParams = GetAvailableParameters.getParameters();
            
            Enumeration paramEnum = request.getParameterNames();
            
            String currentParam;
            while(paramEnum.hasMoreElements())
            {
                currentParam = (String)paramEnum.nextElement();
                if(availableParams.contains(currentParam))
                {
                    // If parameter is available, add it to the string.
                    parameterString += "&" + currentParam + "=" + request.getParameter(currentParam);
                }
            }
            
            String reportName = request.getParameter("reportName");
            
            if(DEBUG)
            {
                System.out.println("ReportRequest - Parameter String: " + parameterString);
                System.out.println("ReportRequest - Report retrieved: " + reportName);
            }
            
            if (reportName == null)
            {
                // Bail out if no report name is found.
                ServletOutputStream responseErrorStream = response.getOutputStream();
                responseErrorStream.println("ERROR: No report name specified");
                responseErrorStream.close();
                return;
            }
            
            // Establish HTTP POST connection to report server
            String urlString = REPORT_SERVER_URL + "?" + REPORT_PATH + reportName;
            URL url = new URL(urlString);
            
            HttpURLConnection repCon = (HttpURLConnection)url.openConnection();
            
            repCon.setRequestMethod("POST");
            repCon.setDoOutput(true);
            repCon.setUseCaches(false);
            repCon.setFollowRedirects(false);
            repCon.setRequestProperty("User-Agent", "Mozilla/5.0");
            repCon.setRequestProperty("Content-type", "application/x-www-form-urlencoded" );
            repCon.setRequestProperty("Content-length", Integer.toString(parameterString.length()));
            
            // Send parameter string to report server
            PrintWriter repOutStream = new PrintWriter(repCon.getOutputStream());
            
            repOutStream.println(parameterString);
            repOutStream.close();
            
            // Pipe Report Server's Output to the client
            forwardResponse(repCon, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            
            // Alert the client there has been an error.
            ServletOutputStream responseErrorStream = response.getOutputStream();
            responseErrorStream.println("There has been an error.  Please check the system log for details.");
            responseErrorStream.close();
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Redirect HTTP GET requests to doPost.
        doPost(request, response);
    }
    
    private void forwardResponse(HttpURLConnection reportCon, HttpServletResponse clientResponse) throws ServletException, IOException
    {
        // Take the report server's response and forward it to the client.
        
        String cookie = reportCon.getHeaderField("Set-Cookie");
        
        if(cookie == null)
        {
            System.out.println("ReportRequest - ERROR: No cookie provided by report server.  Aborting.");
            return;
        }
        
        if(cookie.indexOf(";") != -1)
        {
            cookie = cookie.substring(0,cookie.indexOf(";"));
        }
        if(DEBUG)
        {
            System.out.println("ReportRequest - Cookie: " + cookie);
        }
        
        String contentType = reportCon.getContentType();
        
        clientResponse.setContentType(contentType);
        clientResponse.setHeader("Content-disposition", reportCon.getHeaderField("Content-disposition"));
        
        InputStream repInStream = reportCon.getInputStream();
        ServletOutputStream clientOutStream = clientResponse.getOutputStream();
        
        if(!contentType.equals("text/html"))
        {
            // Use a buffered stream to send all binary formats.
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
        }
        else
        {
            /*
             * Use a character stream to send HTML to the client, replacing
             * references to the reporting server with the GetReportItem
             * servlet.
             */
            
            String currentWindow = "";
            int itemsFound = 0;
            
            for(int ch;(ch = repInStream.read()) != -1;)
            {
                if(currentWindow.length() < REPORT_SERVER_URL.length())
                {
                    currentWindow += (char)ch;
                }
                else if(currentWindow.equalsIgnoreCase(REPORT_SERVER_URL) && (char)ch == '?')
                {
                    itemsFound++;
                    
                    clientOutStream.print(REPORT_ITEM_SERVLET_URL + "?cookie=" + cookie + "&");
                    currentWindow = "";
                }
                else
                {
                    clientOutStream.print(currentWindow.charAt(0));
                    currentWindow = currentWindow.substring(1) + (char)ch;
                }
            }
            clientOutStream.print(currentWindow);
            
            if(DEBUG)
            {
                System.out.println("ReportRequest - " + itemsFound + " references to the report server found.");
            }
        }
        
        repInStream.close();
        clientOutStream.close();
    }
    
}
