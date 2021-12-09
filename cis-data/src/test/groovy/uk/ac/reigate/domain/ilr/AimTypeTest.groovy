package uk.ac.reigate.domain.ilr;

import org.junit.Test

import static org.junit.Assert.*


public class AimTypeTest {
    
    @Test
    void testMethod_ToString() {
        AimType aimType = new AimType()
        aimType.description = 'TEST'
        
        assertEquals(aimType.description, aimType.toString())
    }
}
