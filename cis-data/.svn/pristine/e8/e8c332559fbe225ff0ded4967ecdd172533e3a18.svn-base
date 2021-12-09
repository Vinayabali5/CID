package uk.ac.reigate.model.attendance

import groovy.transform.Canonical

import java.text.DateFormat
import java.time.LocalDate

import javax.swing.text.DateFormatter;

/**
 * The SessionRange object is used to specify a range of sesions using the sessions references. 
 * A session reference is formed as the follows: 
 *      
 * SessionRef: YYYYMMDDPP (YYYY = year, MM = month, DD = day, PP = period)
 * 
 * @author Michael Horgan
 *
 */
//@Canonical
class SessionRange {
    
    /**
     * The session reference to use as the start of the range
     */
    int startSessionRef
    
    /**
     * The session reference to use as the end of the range
     */
    int endSessionRef
    
    /**
     * This custom constructor is used to create a SessionRange using a start date and period plus an 
     * end date and period.
     * 
     * @param startDate
     * @param startPeriod
     * @param endDate
     * @param endPeriod
     */
    SessionRange(Date startDate, int startPeriod, Date endDate, int endPeriod) {
        this.startSessionRef = (int) (startDate.format("yyyyMMdd") + ("00" + startPeriod.toString())[-2..-1]);
        this.endSessionRef = (int) (endDate.format("yyyyMMdd") + ("00" + endPeriod.toString())[-2..-1]);
    }
}
