package uk.ac.reigate.domain.academic;

import org.junit.Test

import uk.ac.reigate.domain.interimreport.InterimReport

import static org.junit.Assert.*

public class InterimReportTest {
    
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
        InterimReport interimReport = new InterimReport()
        interimReport.description = 'TEST'
        
        assertEquals(interimReport.description, interimReport.toString())
    }
}
