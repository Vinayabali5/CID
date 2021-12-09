package uk.ac.reigate.domain.academic;

import org.junit.Test

import static org.junit.Assert.*

public class HolidayTest {
    
    /**
     * Helper function to create a dummy academic year
     *
     * @return a dummy academic year
     */
    AcademicYear createAcademicYear() {
        AcademicYear year = new AcademicYear()
    }
    
    @Test
    void testMethod_ToString() {
        Holiday holiday = new Holiday()
        holiday.description = 'TEST'
        
        assertEquals(holiday.description, holiday.toString())
    }
}
