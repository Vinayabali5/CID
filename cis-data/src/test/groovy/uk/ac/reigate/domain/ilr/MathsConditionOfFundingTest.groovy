package uk.ac.reigate.domain.ilr;

import org.junit.Test

import static org.junit.Assert.*


public class MathsConditionOfFundingTest {
    
    @Test
    void testMethod_ToString() {
        MathsConditionOfFunding mathsConditionOfFunding = new MathsConditionOfFunding()
        mathsConditionOfFunding.description = 'TEST'
        
        assertEquals(mathsConditionOfFunding.description, mathsConditionOfFunding.toString())
    }
}
