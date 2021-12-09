package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class YearGroupTest {
    
    @Test
    void testMethod_ToString() {
        YearGroup yearGroup = new YearGroup()
        yearGroup.description = 'TEST'
        
        assertEquals(yearGroup.description, yearGroup.toString())
    }
}
