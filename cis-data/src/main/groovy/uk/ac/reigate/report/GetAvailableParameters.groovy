package uk.ac.reigate.report

import java.sql.Connection
import java.sql.*;


class GetAvailableParameters {
    
    public static ArrayList getParameters() {
        ArrayList params = new ArrayList();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CID; Driver={SQL Server}");
            
            //            Connection conn = DriverManager.getConnection("jdbc:odbc:SourceType=SQL; Server=KofCrpt; database=OFFICERS; Driver={SQL Server}",
            //                                                         "officers",
            //                                                         "officers");
            
            Statement s = conn.createStatement();
            String sql = "SELECT rpt_param_name         " +
                    "  FROM report_parameter          " +
                    " WHERE rpt_param_available = 1";
            
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next())
            {
                params.add(rs.getString(1));
            }
            
            rs.close();
            s.close();
            conn.close();
            
        }
        catch (ClassNotFoundException e1)
        {
            // JDBC driver class not found, print error message to the console
            System.out.println("\nGetAvailableParameters - Class Error:" + e1.toString());
        }
        catch (SQLException e2)
        {
            // Exception when executing java.sql related commands, print error message to the console
            System.out.println("\nGetAvailableParameters - SQL Error:" + e2.toString());
        }
        catch (Exception e3)
        {
            // other unexpected exception, print error message to the console
            System.out.println("\nGetAvailableParameters - General Error:" + e3.toString());
        }
        
        return params;
    }
    
}
