package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before;
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.lookup.TextLookup
import uk.ac.reigate.exceptions.InvalidDataException

public class TextLookUpDtoTest {
    
    private TextLookup textLookup1
    
    private TextLookup textLookup2
    
    private List<TextLookup> textLookups
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.textLookup1 = new TextLookup(
                id: 1,
                name:'T',
                description:'Test'
                );
        this.textLookup2 = new TextLookup(
                id: 2,
                name:'T1',
                description:'Test1'
                );
        this.textLookups = Arrays.asList(this.textLookup1, this.textLookup2);
    }
    
    @Test
    void testConstructor_textLookup() {
        TextLookUpDto textLookupTest = new TextLookUpDto( textLookup1 )
        assertEquals( textLookupTest.id, textLookup1.id );
        assertEquals( textLookupTest.name, textLookup1.name);
        assertEquals( textLookupTest.description, textLookup1.description);
    }
    
    @Test
    public void testConstructor_NullCollegeFundPaid() {
        TextLookup textLookUp = null
        TextLookUpDto textLookUpDto = new TextLookUpDto(textLookUp)
        assertEquals( textLookUp, null)
    }
    
    @Test
    public void testMapFromTextLookupsEntities(){
        List<TextLookUpDto> textLookUpDtoTest = TextLookUpDto.mapFromEntityList( this.textLookups )
        assertEquals( textLookUpDtoTest[0].id, textLookup1.id );
        assertEquals( textLookUpDtoTest[0].name, textLookup1.name);
        assertEquals( textLookUpDtoTest[0].description, textLookup1.description);
        assertEquals( textLookUpDtoTest[1].id, textLookup2.id);
        assertEquals( textLookUpDtoTest[1].name, textLookup2.name );
        assertEquals( textLookUpDtoTest[1].description, textLookup2.description);
    }
    
    @Test
    public void testEquals_Same() {
        TextLookUpDto textLookUpDto1 = new TextLookUpDto(textLookup1)
        TextLookUpDto textLookUpDto2 = new TextLookUpDto(textLookup1)
        assertEquals(textLookUpDto1, textLookUpDto2)
    }
    
    @Test
    public void testEquals_Different() {
        TextLookUpDto textLookUpDto1 = new TextLookUpDto(textLookup1)
        TextLookUpDto textLookUpDto2 = new TextLookUpDto(textLookup2)
        assertNotEquals(textLookUpDto1, textLookUpDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        TextLookUpDto textLookUpDto1 = new TextLookUpDto(textLookup1)
        TextLookUpDto textLookUpDto2 = new TextLookUpDto(textLookup1)
        assertEquals(textLookUpDto1.hashCode(), textLookUpDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        TextLookUpDto textLookUpDto1 = new TextLookUpDto(textLookup1)
        TextLookUpDto textLookUpDto2 = new TextLookUpDto(textLookup2)
        assertNotEquals(textLookUpDto1.hashCode(), textLookUpDto2.hashCode())
    }
}
