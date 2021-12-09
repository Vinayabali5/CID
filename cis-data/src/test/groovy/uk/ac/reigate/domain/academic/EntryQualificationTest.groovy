package uk.ac.reigate.domain.academic;

import org.junit.Test

import static org.junit.Assert.*

public class EntryQualificationTest {
    
    /**
     * Helper function to create a dummy student
     * 
     * @return a dummy student
     */
    EntryQualificationType createEntryQualificationType() {
        EntryQualificationType type = new EntryQualificationType()
    }
    
    @Test
    void testMethod_ToString() {
        EntryQualification entryQualification = new EntryQualification()
        EntryQualificationType type = createEntryQualificationType()
        entryQualification.title = 'TEST'
        
        assertEquals(entryQualification.type + " " + entryQualification.title, entryQualification.toString())
    }
}
