package uk.ac.reigate.domain.ilr;

import org.junit.Test

import static org.junit.Assert.*


public class CompletionStatusTest {
    
    @Test
    void testMethod_ToString() {
        CompletionStatus completionStatus = new CompletionStatus()
        completionStatus.description = 'TEST'
        
        assertEquals(completionStatus.description, completionStatus.toString())
    }
}
