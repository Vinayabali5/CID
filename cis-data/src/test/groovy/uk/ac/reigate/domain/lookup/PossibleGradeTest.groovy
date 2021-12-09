package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*



public class PossibleGradeTest {
    
    PossibleGradeSet createPossibleGradeSet() {
        PossibleGradeSet gradeSet = new PossibleGradeSet()
    }
    
    @Test
    void testMethod_ToString() {
        PossibleGrade possibleGrade = new PossibleGrade()
        possibleGrade.description = 'TEST'
        
        assertEquals(possibleGrade.description, possibleGrade.toString())
    }
}
