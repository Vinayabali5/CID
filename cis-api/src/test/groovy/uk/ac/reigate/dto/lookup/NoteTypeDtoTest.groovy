package uk.ac.reigate.dto.lookup;

import static org.junit.Assert.*

import java.util.List;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.NoteType
import uk.ac.reigate.dto.lookup.NoteTypeDto

public class NoteTypeDtoTest {
    
    private NoteType noteType1
    
    private NoteType noteType2
    
    private List<NoteType> noteTypes
    
    @Before
    public void setup() {
        noteType1 = new NoteType(
                id: 1,
                code:'GEN',
                description:'General NoteType'
                );
        noteType2 = new NoteType(
                id: 2,
                code:'PER',
                description:'Permanent NoteType'
                );
        noteTypes = Arrays.asList(noteType1, noteType2);
    }
    
    @Test
    public void testMapFromNoteTypeEntity(){
        NoteTypeDto noteTypeTest = NoteTypeDto.mapFromEntity( noteType1 )
        assertEquals( noteTypeTest.id, noteType1.id );
        assertEquals( noteTypeTest.code, noteType1.code);
        assertEquals( noteTypeTest.description, noteType1.description);
    }
    
    @Test
    public void testMapFromNoteTypesEntities(){
        List<NoteTypeDto> noteTypeDtoTest = NoteTypeDto.mapFromList( noteTypes )
        assertEquals( noteTypeDtoTest[0].id, noteType1.id );
        assertEquals( noteTypeDtoTest[0].code, noteType1.code);
        assertEquals( noteTypeDtoTest[0].description, noteType1.description);
        assertEquals( noteTypeDtoTest[1].id, noteType2.id );
        assertEquals( noteTypeDtoTest[1].code, noteType2.code);
        assertEquals( noteTypeDtoTest[1].description, noteType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        NoteTypeDto noteTypeDto1 = new NoteTypeDto(noteType1)
        NoteTypeDto noteTypeDto2 = new NoteTypeDto(noteType1)
        assertEquals(noteTypeDto1, noteTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        NoteTypeDto noteTypeDto1 = new NoteTypeDto(noteType1)
        NoteTypeDto noteTypeDto2 = new NoteTypeDto(noteType2)
        assertNotEquals(noteTypeDto1, noteTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        NoteTypeDto noteTypeDto1 = new NoteTypeDto(noteType1)
        NoteTypeDto noteTypeDto2 = new NoteTypeDto(noteType1)
        assertEquals(noteTypeDto1.hashCode(), noteTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        NoteTypeDto noteTypeDto1 = new NoteTypeDto(noteType1)
        NoteTypeDto noteTypeDto2 = new NoteTypeDto(noteType2)
        assertNotEquals(noteTypeDto1.hashCode(), noteTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_NoteType() {
        NoteTypeDto noteTypeDto = new NoteTypeDto(noteType1)
        assertEquals( noteTypeDto.code, noteType1.code )
        assertEquals( noteTypeDto.description, noteType1.description )
    }
    
    @Test
    public void testConstructor_NullObject() {
        NoteType noteType = null
        NoteTypeDto noteTypeDto = new NoteTypeDto(noteType)
        assertEquals( noteType, null )
    }
}
