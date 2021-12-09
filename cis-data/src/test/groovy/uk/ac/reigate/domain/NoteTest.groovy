package uk.ac.reigate.domain;

import org.junit.Test

import static org.junit.Assert.*


public class NoteTest {
    
    Person createPerson() {
        Person person = new Person()
    }
    
    NoteType createNoteType() {
        NoteType type = new NoteType()
    }
    
    @Test
    void testMethod_ToString() {
        Note contacte = new Note()
        
        assertEquals(contacte.note, contacte.toString())
    }
}
