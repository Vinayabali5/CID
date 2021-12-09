package uk.ac.reigate.domain;

import org.junit.Test

import static org.junit.Assert.*


public class NoteTypeTest {
    
    @Test
    void testMethod_ToString() {
        NoteType noteType = new NoteType()
        noteType.description = 'TEST'
        
        assertEquals(noteType.description, noteType.toString())
    }
}
