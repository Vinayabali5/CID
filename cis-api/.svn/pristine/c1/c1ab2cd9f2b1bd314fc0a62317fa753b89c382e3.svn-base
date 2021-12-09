package uk.ac.reigate.dto;


import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.exceptions.InvalidDataException

public class CollegeFundPaidDtoTest {
    
    private CollegeFundPaid collegeFundPaid1
    
    private CollegeFundPaid collegeFundPaid2
    
    private List<CollegeFundPaid> collegeFundPaids
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.collegeFundPaid1 = new CollegeFundPaid(
                id: 1,
                collegeFundPaid : 'Yes'
                );
        this.collegeFundPaid2 = new CollegeFundPaid(
                id: 1,
                collegeFundPaid : 'No'
                );
        this.collegeFundPaids = Arrays.asList(collegeFundPaid1,collegeFundPaid2);
    }
    
    @Test
    void testConstructor_collegeFundPaid() {
        CollegeFundPaidDto collegeFundPaidTest = new CollegeFundPaidDto( collegeFundPaid1 )
        assertEquals( collegeFundPaidTest.id, collegeFundPaid1.id );
        assertEquals( collegeFundPaidTest.collegeFundPaid, collegeFundPaid1.collegeFundPaid);
    }
    
    @Test
    public void testConstructor_NullCollegeFundPaid() {
        CollegeFundPaid collegeFundPaid = null
        CollegeFundPaidDto collegeFundPaidDto = new CollegeFundPaidDto(collegeFundPaid)
        assertEquals( collegeFundPaid, null );
    }
    
    @Test
    public void testMapFromCollegeFundPaidEntity(){
        CollegeFundPaidDto collegeFundPaidTest = CollegeFundPaidDto.mapFromEntity( collegeFundPaid1 )
        assertEquals( collegeFundPaidTest.id, collegeFundPaid1.id );
        assertEquals( collegeFundPaidTest.collegeFundPaid, collegeFundPaid1.collegeFundPaid);
    }
    
    @Test
    public void testMapFromCollegeFundPaidsEntities(){
        List<CollegeFundPaidDto> collegeFundPaidTest = CollegeFundPaidDto.mapFromList( this.collegeFundPaids )
        assertEquals( collegeFundPaidTest[0].id, collegeFundPaid1.id );
        assertEquals( collegeFundPaidTest[0].collegeFundPaid, collegeFundPaid1.collegeFundPaid );
        assertEquals( collegeFundPaidTest[1].id, collegeFundPaid2.id );
        assertEquals( collegeFundPaidTest[1].collegeFundPaid, collegeFundPaid2.collegeFundPaid );
    }
    
    @Test
    public void testEquals_Same() {
        CollegeFundPaidDto collegeFundPaidDto1 = new CollegeFundPaidDto(collegeFundPaid1)
        CollegeFundPaidDto collegeFundPaidDto2 = new CollegeFundPaidDto(collegeFundPaid1)
        assertEquals( collegeFundPaidDto1, collegeFundPaidDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CollegeFundPaidDto collegeFundPaidDto1 = new CollegeFundPaidDto(collegeFundPaid1)
        CollegeFundPaidDto collegeFundPaidDto2 = new CollegeFundPaidDto(collegeFundPaid2)
        assertNotEquals( collegeFundPaidDto1, collegeFundPaidDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CollegeFundPaidDto collegeFundPaidDto1 = new CollegeFundPaidDto(collegeFundPaid1)
        CollegeFundPaidDto collegeFundPaidDto2 = new CollegeFundPaidDto(collegeFundPaid1)
        assertEquals( collegeFundPaidDto1.hashCode(), collegeFundPaidDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CollegeFundPaidDto collegeFundPaidDto1 = new CollegeFundPaidDto(collegeFundPaid1)
        CollegeFundPaidDto collegeFundPaidDto2 = new CollegeFundPaidDto(collegeFundPaid2)
        assertNotEquals( collegeFundPaidDto1.hashCode(), collegeFundPaidDto2.hashCode())
    }
    
    @Test
    public void testConstructor_CollegeFundPaid() {
        CollegeFundPaidDto collegeFundPaidDto = new CollegeFundPaidDto(collegeFundPaid1)
        assertEquals( collegeFundPaidDto.id, collegeFundPaid1.id )
        assertEquals( collegeFundPaidDto.collegeFundPaid, collegeFundPaid1.collegeFundPaid)
    }
}
