package uk.ac.reigate.domain.ilp;

import org.junit.Test

import static org.junit.Assert.*


public class ILPInterviewTypeTest {
    
    @Test
    void testMethod_ToString() {
        ILPInterviewType iLPInterviewType = new ILPInterviewType()
        iLPInterviewType.type = 'TEST'
        
        assertEquals(iLPInterviewType.type, iLPInterviewType.toString())
    }
}
