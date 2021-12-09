package uk.ac.reigate.domain.ilr;

import org.junit.Test

import static org.junit.Assert.*


public class EnglishConditionOfFundingTest {
    
    @Test
    void testMethod_ToString() {
        EnglishConditionOfFunding englishConditionOfFunding = new EnglishConditionOfFunding()
        englishConditionOfFunding.description = 'TEST'
        
        assertEquals(englishConditionOfFunding.description, englishConditionOfFunding.toString())
    }
}
