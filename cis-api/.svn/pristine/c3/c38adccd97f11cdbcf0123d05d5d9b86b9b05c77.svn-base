package uk.ac.reigate.dto.ilr;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.AimType
import uk.ac.reigate.dto.ilr.AimTypeDto

import static org.junit.Assert.*

public class AimTypeDtoTest {
    
    private AimType aimType1
    
    private AimType aimType2
    
    private List<AimType> aimTypes
    
    @Before
    public void setup() {
        this.aimType1 = new AimType(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.aimType2 = new AimType(
                id: 2,
                code: 'EU',
                description: 'European Ecconomic Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.aimTypes = Arrays.asList(aimType1, aimType2);
    }
    
    @Test
    void testNoArgConstructor() {
        assertNotNull(new AimTypeDto())
    }
    
    @Test
    void testConstructor_NullObject() {
        AimType aimType = null
        AimTypeDto aimTypeTest = new AimTypeDto( aimType )
        assertEquals( aimType, null)
    }
    
    @Test
    void testConstructor_aimType() {
        AimTypeDto aimTypeTest = new AimTypeDto( aimType1 )
        assertEquals( aimTypeTest.id, aimType1.id);
        assertEquals( aimTypeTest.code, aimType1.code);
        assertEquals( aimTypeTest.description, aimType1.description);
        assertEquals( aimTypeTest.shortDescription, aimType1.shortDescription);
        assertEquals( aimTypeTest.validFrom, aimType1.validFrom);
        assertEquals( aimTypeTest.validTo, aimType1.validTo);
    }
    
    @Test
    public void testMapFromAimTypeEntityTest() {
        AimTypeDto aimTypeTest = AimTypeDto.mapFromEntity( aimType1 )
        assertEquals( aimTypeTest.id, aimType1.id);
        assertEquals( aimTypeTest.code, aimType1.code);
        assertEquals( aimTypeTest.description, aimType1.description);
        assertEquals( aimTypeTest.shortDescription, aimType1.shortDescription);
        assertEquals( aimTypeTest.validFrom, aimType1.validFrom);
        assertEquals( aimTypeTest.validTo, aimType1.validTo);
    }
    
    @Test
    public void testMapFromAimTypesEntitiesTest(){
        List<AimTypeDto> aimTypesDtoTest = AimTypeDto.mapFromList( this.aimTypes )
        assertEquals( aimTypesDtoTest[0].id, aimType1.id );
        assertEquals( aimTypesDtoTest[0].code, aimType1.code );
        assertEquals( aimTypesDtoTest[0].description, aimType1.description);
        assertEquals( aimTypesDtoTest[0].shortDescription, aimType1.shortDescription);
        assertEquals( aimTypesDtoTest[0].validFrom, aimType1.validFrom);
        assertEquals( aimTypesDtoTest[0].validTo, aimType1.validTo);
        assertEquals( aimTypesDtoTest[1].id, aimType2.id );
        assertEquals( aimTypesDtoTest[1].code, aimType2.code );
        assertEquals( aimTypesDtoTest[1].description, aimType2.description);
        assertEquals( aimTypesDtoTest[1].shortDescription, aimType2.shortDescription);
        assertEquals( aimTypesDtoTest[1].validFrom, aimType2.validFrom);
        assertEquals( aimTypesDtoTest[1].validTo, aimType2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        AimTypeDto aimTypeDto1 = new AimTypeDto(aimType1)
        AimTypeDto aimTypeDto2 = new AimTypeDto(aimType1)
        assertEquals( aimTypeDto1, aimTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        AimTypeDto aimTypeDto1 = new AimTypeDto(aimType1)
        AimTypeDto aimTypeDto2 = new AimTypeDto(aimType2)
        assertNotEquals( aimTypeDto1, aimTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        AimTypeDto aimTypeDto1 = new AimTypeDto(aimType1)
        AimTypeDto aimTypeDto2 = new AimTypeDto(aimType1)
        assertEquals( aimTypeDto1.hashCode(), aimTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        AimTypeDto aimTypeDto1 = new AimTypeDto(aimType1)
        AimTypeDto aimTypeDto2 = new AimTypeDto(aimType2)
        assertNotEquals( aimTypeDto1.hashCode(), aimTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_AimType() {
        AimTypeDto aimTypeDto = new AimTypeDto(aimType1)
        assertEquals( aimTypeDto.id, aimType1.id );
        assertEquals( aimTypeDto.code, aimType1.code);
        assertEquals( aimTypeDto.description, aimType1.description);
        assertEquals( aimTypeDto.shortDescription, aimType1.shortDescription);
        assertEquals( aimTypeDto.validFrom, aimType1.validFrom);
        assertEquals( aimTypeDto.validTo, aimType1.validTo);
    }
}
