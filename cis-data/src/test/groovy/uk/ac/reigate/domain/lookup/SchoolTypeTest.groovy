package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class SchoolTypeTest {
    
    @Test
    void testMethod_ToString() {
        SchoolType schoolType = new SchoolType()
        schoolType.code = 'T'
        
        assertEquals(schoolType.code, schoolType.toString())
    }
}
