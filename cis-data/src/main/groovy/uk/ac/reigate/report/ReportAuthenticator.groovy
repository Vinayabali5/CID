package uk.ac.reigate.report

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate


class ReportAuthenticator extends java.net.Authenticator {
    
    private String username = "KOFCRPT\\reporter";
    private String password = "reporter";
    
    public ReportAuthenticator() {}
    
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,(password.toCharArray()));
    }
}
