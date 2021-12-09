package uk.ac.reigate.domain.learning_support;

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*


public class LearningSupportCostTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    Staff createStaff() {
        Staff staff = new Staff()
    }
    
    LearningSupportCostCategory createLearningSupportCostCategory() {
        LearningSupportCostCategory CostCategory = new LearningSupportCostCategory()
    }
    
    @Test
    void testMethod_ToString() {
        LearningSupportCost learningSupportCoste = new LearningSupportCost()
        
        assertEquals(learningSupportCoste.description, learningSupportCoste.toString())
    }
}
