package uk.ac.reigate.domain.security;

import org.junit.Test

import static org.junit.Assert.*


public class RoleTest {
    
    @Test
    void testMethod_ToString() {
        Role role = new Role()
        role.roleName = 'TEST'
        
        assertEquals(role.roleName, role.toString())
    }
}
