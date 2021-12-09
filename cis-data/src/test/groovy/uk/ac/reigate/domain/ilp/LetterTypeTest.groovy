package uk.ac.reigate.domain.ilp;

import org.junit.Test

import static org.junit.Assert.*


public class LetterTypeTest {
    
    @Test
    void testMethod_ToString() {
        LetterType correspondenceType = new LetterType()
        correspondenceType.type = 'TEST'
        
        assertEquals(correspondenceType.type, correspondenceType.toString())
    }
}
