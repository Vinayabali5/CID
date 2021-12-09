package uk.ac.reigate.domain.learning_support;

import org.junit.Test

import static org.junit.Assert.*


public class LearningSupportCostCategoryTest {
    
    @Test
    void testMethod_ToString() {
        LearningSupportCostCategory learningSupportCostCategory = new LearningSupportCostCategory()
        learningSupportCostCategory.category = 'TEST'
        
        assertEquals(learningSupportCostCategory.category, learningSupportCostCategory.toString())
    }
}
