package uk.ac.reigate.domain.ilr;

import org.junit.Test

import static org.junit.Assert.*


public class PriorAttainmentTest {
    
    @Test
    void testMethod_ToString() {
        PriorAttainment priorAttainment = new PriorAttainment()
        priorAttainment.description = 'TEST'
        
        assertEquals(priorAttainment.description, priorAttainment.toString())
    }
}
