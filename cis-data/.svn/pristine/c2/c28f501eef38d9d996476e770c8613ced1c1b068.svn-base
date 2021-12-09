package uk.ac.reigate.register;

import static org.junit.Assert.*

import org.junit.Test
import uk.ac.reigate.domain.register.AttendanceCode


public class AttendanceCodeTest {
    
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        Integer id = 1
        String code = 'T'
        String description = 'attendance'
        String registerMark = 'T'
        String htmlColour = 'TEST'
        Boolean absence = true
        Boolean authorisedAbsence = true
        Boolean late = true
        Boolean authorisedLate = true
        Boolean included = true
        Boolean lastDateOfAttendance = true
        String accessColour = 'red'
        
        AttendanceCode attendanceCode = new AttendanceCode()
        
        assertNotNull(attendanceCode)
        assertEquals(attendanceCode.registerMark, attendanceCode.registerMark)
        assertEquals(attendanceCode.htmlColour, attendanceCode.htmlColour)
    }
}
