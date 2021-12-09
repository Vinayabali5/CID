package uk.ac.reigate.domain.lookup;

import org.junit.Test

import static org.junit.Assert.*


public class StaffTypeTest {
    
    @Test
    void testMethod_ToString() {
        StaffType staffType = new StaffType()
        staffType.description = 'TEST'
        
        assertEquals(staffType.description, staffType.toString())
    }
}
