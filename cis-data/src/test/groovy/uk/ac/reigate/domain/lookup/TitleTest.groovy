package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class TitleTest {
    
    @Test
    void testMethod_ToString() {
        Title title = new Title()
        title.description = 'TEST'
        
        assertEquals(title.description, title.toString())
    }
}
