package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Note
import uk.ac.reigate.domain.NoteType
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Title


public class NoteDtoTest {
    
    private Note note1
    
    private Note note2
    
    private Note note3
    
    private List<Note> notes
    
    @Before
    public void setupTests() {
        this.note1 = new Note(
                id: 1,
                person: new Person(id:1),
                note:'A',
                type: new NoteType()
                );
        this.note2 = new Note(
                id: 2,
                person: new Person(id:1),
                note:'A',
                type: new NoteType()
                );
        this.note3 = new Note(
                id: 2,
                person: null,
                note:'A',
                type: null
                );
        this.notes = Arrays.asList(note1, note2);
    }
    
    NoteDto generateNoteDto() {
        return generateNote1Dto()
    }
    
    NoteDto generateNote1Dto() {
        return new NoteDto(note1)
    }
    
    NoteDto generateNote2Dto() {
        return new NoteDto(note2)
    }
    
    @Test
    public void testConstructor_NullNote() {
        Note note = null
        NoteDto noteDto = new NoteDto(note)
        assertEquals( note, null );
    }
    
    @Test
    public void testConstructor_NullOject(){
        NoteDto noteTest = NoteDto.mapFromEntity( note3 )
        assertEquals( noteTest.id, note3.id );
        assertEquals( noteTest.personId, note3.person );
        assertEquals( noteTest.note, note3.note);
        assertEquals( noteTest.typeId, note3.type);
    }
    
    @Test
    public void testMapFromNoteEntityTest(){
        NoteDto noteTest = NoteDto.mapFromEntity( note1 )
        assertEquals( noteTest.id, note1.id );
        assertEquals( noteTest.personId, note1.person.id );
        assertEquals( noteTest.note, note1.note);
        assertEquals( noteTest.typeId, note1.type.id);
    }
    
    @Test
    public void testMapFromNotesEntitiesTest(){
        List<NoteDto> noteTest = NoteDto.mapFromList( notes )
        assertEquals( noteTest[0].id, note1.id );
        assertEquals( noteTest[0].personId, note1.person.id);
        assertEquals( noteTest[0].note, note1.note);
        assertEquals( noteTest[0].typeId, note1.type.id);
        assertEquals( noteTest[1].id, note2.id );
        assertEquals( noteTest[1].personId, note2.person.id );
        assertEquals( noteTest[1].note, note2.note);
        assertEquals( noteTest[1].typeId, note2.type.id);
    }
    
    @Test
    public void testEquals_Same() {
        NoteDto noteDto1 = new NoteDto(note1)
        NoteDto noteDto2 = new NoteDto(note1)
        assertEquals(noteDto1, noteDto2)
    }
    
    @Test
    public void testEquals_Different() {
        NoteDto noteDto1 = new NoteDto(note1)
        NoteDto noteDto2 = new NoteDto(note2)
        assertNotEquals(noteDto1, noteDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        NoteDto noteDto1 = new NoteDto(note1)
        NoteDto noteDto2 = new NoteDto(note1)
        assertEquals(noteDto1.hashCode(), noteDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        NoteDto noteDto1 = new NoteDto(note1)
        NoteDto noteDto2 = new NoteDto(note2)
        assertNotEquals(noteDto1.hashCode(), noteDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullTypeDescription() {
        NoteDto noteDto1 = new NoteDto(note3)
        assertEquals(noteDto1.type, noteDto1.get_TypeDescription())
    }
    
    @Test
    public void testMethod_Get_TypeDescription() {
        NoteDto noteDto1 = new NoteDto(note1)
        assertEquals(noteDto1.type.description, noteDto1.get_TypeDescription())
    }
}
