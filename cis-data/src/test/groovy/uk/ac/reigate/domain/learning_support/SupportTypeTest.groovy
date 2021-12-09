package uk.ac.reigate.domain.learning_support;

import static org.junit.Assert.*

import org.junit.Test


public class SupportTypeTest {
    
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        String support = 'TEST'
        
        SupportType supportType = new SupportType( support)
        
        assertNotNull(supportType)
        assertEquals(supportType.support, support)
    }
    
    @Test
    void testConstructor_AllFieldsWithId() {
        Integer id = 1
        String supportTypel = 'T'
        String support = 'TEST'
        
        SupportType supportType = new SupportType(id, support)
        
        assertNotNull(supportType)
        assertEquals(supportType.id, id)
        assertEquals(supportType.support, support)
    }
    
    @Test
    void testMethod_ToString() {
        SupportType supportType = new SupportType()
        supportType.support = 'TEST'
        
        assertEquals(supportType.support, supportType.toString())
    }
}
