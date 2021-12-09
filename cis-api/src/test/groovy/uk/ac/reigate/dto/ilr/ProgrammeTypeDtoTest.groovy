package uk.ac.reigate.dto.ilr;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.ProgrammeType
import uk.ac.reigate.dto.ilr.ProgrammeTypeDto

public class ProgrammeTypeDtoTest {
    
    private ProgrammeType programmeType1
    
    private ProgrammeType programmeType2
    
    private List<ProgrammeType> programmeTypes
    
    @Before
    public void setup() {
        this.programmeType1 = new ProgrammeType(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.programmeType2 = new ProgrammeType(
                id: 2,
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        programmeTypes = Arrays.asList(this.programmeType1, this.programmeType2);
    }
    
    @Test
    public void testMapFromProgrammeTypeEntityTest() {
        ProgrammeTypeDto programmeTypeTest = ProgrammeTypeDto.mapFromEntity( programmeType1 )
        assertEquals( programmeTypeTest.id, programmeType1.id);
        assertEquals( programmeTypeTest.code, programmeType1.code);
        assertEquals( programmeTypeTest.description, programmeType1.description);
        assertEquals( programmeTypeTest.shortDescription, programmeType1.shortDescription);
        assertEquals( programmeTypeTest.validFrom, programmeType1.validFrom);
        assertEquals( programmeTypeTest.validTo, programmeType1.validTo);
    }
    
    @Test
    public void testMapFromProgrammeTypesEntitiesTest(){
        List<ProgrammeTypeDto> programmeTypesDtoTest = ProgrammeTypeDto.mapFromList( this.programmeTypes)
        assertEquals( programmeTypesDtoTest[0].id, programmeType1.id );
        assertEquals( programmeTypesDtoTest[0].code, programmeType1.code );
        assertEquals( programmeTypesDtoTest[0].description, programmeType1.description);
        assertEquals( programmeTypesDtoTest[0].shortDescription, programmeType1.shortDescription);
        assertEquals( programmeTypesDtoTest[0].validFrom, programmeType1.validFrom);
        assertEquals( programmeTypesDtoTest[0].validTo, programmeType1.validTo);
        assertEquals( programmeTypesDtoTest[1].id, programmeType2.id );
        assertEquals( programmeTypesDtoTest[1].code, programmeType2.code );
        assertEquals( programmeTypesDtoTest[1].description, programmeType2.description);
        assertEquals( programmeTypesDtoTest[1].shortDescription, programmeType2.shortDescription);
        assertEquals( programmeTypesDtoTest[1].validFrom, programmeType2.validFrom);
        assertEquals( programmeTypesDtoTest[1].validTo, programmeType2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        ProgrammeTypeDto programmeTypeDto1 = new ProgrammeTypeDto(programmeType1)
        ProgrammeTypeDto programmeTypeDto2 = new ProgrammeTypeDto(programmeType1)
        assertEquals(programmeTypeDto1, programmeTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ProgrammeTypeDto programmeTypeDto1 = new ProgrammeTypeDto(programmeType1)
        ProgrammeTypeDto programmeTypeDto2 = new ProgrammeTypeDto(programmeType2)
        assertNotEquals(programmeTypeDto1, programmeTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ProgrammeTypeDto programmeTypeDto1 = new ProgrammeTypeDto(programmeType1)
        ProgrammeTypeDto programmeTypeDto2 = new ProgrammeTypeDto(programmeType1)
        assertEquals(programmeTypeDto1.hashCode(), programmeTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ProgrammeTypeDto programmeTypeDto1 = new ProgrammeTypeDto(programmeType1)
        ProgrammeTypeDto programmeTypeDto2 = new ProgrammeTypeDto(programmeType2)
        assertNotEquals(programmeTypeDto1.hashCode(), programmeTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_ProgrammeType() {
        ProgrammeTypeDto programmeTypeDto = new ProgrammeTypeDto(programmeType1)
        assertEquals( programmeTypeDto.code, programmeType1.code )
        assertEquals( programmeTypeDto.description, programmeType1.description )
        assertEquals( programmeTypeDto.shortDescription, programmeType1.shortDescription )
        assertEquals( programmeTypeDto.validFrom, programmeType1.validFrom )
        assertEquals( programmeTypeDto.validTo, programmeType1.validTo )
    }
    
    @Test
    public void testConstructor_NullProgrammeType() {
        ProgrammeType programmeType = null
        ProgrammeTypeDto programmeTypeDto = new ProgrammeTypeDto(programmeType)
        assertEquals( programmeType, null )
    }
}
