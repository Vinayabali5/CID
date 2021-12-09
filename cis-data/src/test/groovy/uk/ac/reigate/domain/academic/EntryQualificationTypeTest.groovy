package uk.ac.reigate.domain.academic;

import org.junit.Test

import static org.junit.Assert.*


public class EntryQualificationTypeTest {
    
    @Test
    void testMethod_ToString() {
        EntryQualificationType entryQualificationType = new EntryQualificationType()
        entryQualificationType.description = 'TEST'
        
        assertEquals(entryQualificationType.description, entryQualificationType.toString())
    }
}
