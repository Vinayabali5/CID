package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class PossibleGradeSetTest {
    
    @Test
    void testMethod_ToString() {
        PossibleGradeSet possibleGradeSet = new PossibleGradeSet()
        possibleGradeSet.description = 'TEST'
        
        assertEquals(possibleGradeSet.description, possibleGradeSet.toString())
    }
}
