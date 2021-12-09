package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class NationalityTest {
    
    @Test
    void testMethod_ToString() {
        Nationality nationality = new Nationality()
        nationality.description = 'TEST'
        
        assertEquals(nationality.description, nationality.toString())
    }
}
