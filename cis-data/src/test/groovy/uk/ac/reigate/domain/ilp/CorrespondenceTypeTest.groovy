package uk.ac.reigate.domain.ilp;

import org.junit.Test

import static org.junit.Assert.*

public class CorrespondenceTypeTest {
    
    @Test
    void testMethod_ToString() {
        CorrespondenceType correspondenceType = new CorrespondenceType()
        correspondenceType.type = 'TEST'
        
        assertEquals(correspondenceType.type, correspondenceType.toString())
    }
}
