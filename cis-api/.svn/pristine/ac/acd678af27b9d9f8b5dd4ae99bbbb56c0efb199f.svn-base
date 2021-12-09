package uk.ac.reigate.dto.ilr;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.PriorAttainment
import uk.ac.reigate.dto.ilr.PriorAttainmentDto

public class PriorAttainmentDtoTest {
    
    private PriorAttainment priorAttainment1
    
    private PriorAttainment priorAttainment2
    
    private List<PriorAttainment> priorAttainments
    
    @Before
    public void setup() {
        this.priorAttainment1 = new PriorAttainment(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.priorAttainment2 = new PriorAttainment(
                id: 2,
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.priorAttainments = Arrays.asList(this.priorAttainment1, this.priorAttainment2);
    }
    
    @Test
    public void testMapFromPriorAttainmentEntityTest() {
        PriorAttainmentDto priorAttainmentTest = PriorAttainmentDto.mapFromEntity( priorAttainment1 )
        assertEquals( priorAttainmentTest.id, priorAttainment1.id);
        assertEquals( priorAttainmentTest.code, priorAttainment1.code);
        assertEquals( priorAttainmentTest.description, priorAttainment1.description);
        assertEquals( priorAttainmentTest.shortDescription, priorAttainment1.shortDescription);
        assertEquals( priorAttainmentTest.validFrom, priorAttainment1.validFrom);
        assertEquals( priorAttainmentTest.validTo, priorAttainment1.validTo);
    }
    
    @Test
    public void testMapFromPriorAttainmentsEntitiesTest(){
        List<PriorAttainmentDto> priorAttainmentsDtoTest = PriorAttainmentDto.mapFromList( this.priorAttainments )
        assertEquals( priorAttainmentsDtoTest[0].id, priorAttainment1.id );
        assertEquals( priorAttainmentsDtoTest[0].code, priorAttainment1.code );
        assertEquals( priorAttainmentsDtoTest[0].description, priorAttainment1.description);
        assertEquals( priorAttainmentsDtoTest[0].shortDescription, priorAttainment1.shortDescription);
        assertEquals( priorAttainmentsDtoTest[0].validFrom, priorAttainment1.validFrom);
        assertEquals( priorAttainmentsDtoTest[0].validTo, priorAttainment1.validTo);
        assertEquals( priorAttainmentsDtoTest[1].id, priorAttainment2.id );
        assertEquals( priorAttainmentsDtoTest[1].code, priorAttainment2.code );
        assertEquals( priorAttainmentsDtoTest[1].description, priorAttainment2.description);
        assertEquals( priorAttainmentsDtoTest[1].shortDescription, priorAttainment2.shortDescription);
        assertEquals( priorAttainmentsDtoTest[1].validFrom, priorAttainment2.validFrom);
        assertEquals( priorAttainmentsDtoTest[1].validTo, priorAttainment2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        PriorAttainmentDto priorAttainmentDto1 = new PriorAttainmentDto(priorAttainment1)
        PriorAttainmentDto priorAttainmentDto2 = new PriorAttainmentDto(priorAttainment1)
        assertEquals(priorAttainmentDto1, priorAttainmentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        PriorAttainmentDto priorAttainmentDto1 = new PriorAttainmentDto(priorAttainment1)
        PriorAttainmentDto priorAttainmentDto2 = new PriorAttainmentDto(priorAttainment2)
        assertNotEquals(priorAttainmentDto1, priorAttainmentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        PriorAttainmentDto priorAttainmentDto1 = new PriorAttainmentDto(priorAttainment1)
        PriorAttainmentDto priorAttainmentDto2 = new PriorAttainmentDto(priorAttainment1)
        assertEquals(priorAttainmentDto1.hashCode(), priorAttainmentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        PriorAttainmentDto priorAttainmentDto1 = new PriorAttainmentDto(priorAttainment1)
        PriorAttainmentDto priorAttainmentDto2 = new PriorAttainmentDto(priorAttainment2)
        assertNotEquals(priorAttainmentDto1.hashCode(), priorAttainmentDto2.hashCode())
    }
    
    @Test
    public void testConstructor_PriorAttainment() {
        PriorAttainmentDto priorAttainmentDto = new PriorAttainmentDto(priorAttainment1)
        assertEquals( priorAttainmentDto.code, priorAttainment1.code )
        assertEquals( priorAttainmentDto.description, priorAttainment1.description )
        assertEquals( priorAttainmentDto.shortDescription, priorAttainment1.shortDescription )
        assertEquals( priorAttainmentDto.validFrom, priorAttainment1.validFrom )
        assertEquals( priorAttainmentDto.validTo, priorAttainment1.validTo )
    }
    
    @Test
    public void testConstructor_NullPriorAttainment() {
        PriorAttainment priorAttainment = null
        PriorAttainmentDto priorAttainmentDto = new PriorAttainmentDto(priorAttainment)
        assertEquals( priorAttainment, null)
    }
}

