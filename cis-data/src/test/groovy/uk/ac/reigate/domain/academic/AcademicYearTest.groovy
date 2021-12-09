package uk.ac.reigate.domain.academic;

import org.junit.Test

import static org.junit.Assert.*


public class AcademicYearTest {
    
    @Test
    void testMethod_ToString() {
        AcademicYear academicYear = new AcademicYear()
        academicYear.code = 'T'
        academicYear.description = 'TEST'
        
        assertEquals(academicYear.description + ' (' + academicYear.code + ')', academicYear.toString())
    }
}
