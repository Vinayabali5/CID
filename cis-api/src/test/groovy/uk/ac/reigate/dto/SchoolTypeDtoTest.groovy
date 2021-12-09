package uk.ac.reigate.dto;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.SchoolType;
import uk.ac.reigate.dto.lookup.SchoolTypeDto

import static org.junit.Assert.*

public class SchoolTypeDtoTest {
    
    private SchoolType schoolType1
    
    private SchoolType schoolType2
    
    private List<SchoolType> schoolTypes
    
    @Before
    public void setup() {
        schoolType1 = new SchoolType(
                id: 1,
                code:'SL',
                description:'south London'
                );
        schoolType2 = new SchoolType(
                id: 2,
                code:'S',
                description:'sutton'
                );
        schoolTypes = Arrays.asList(schoolType1, schoolType2);
    }
    
    @Test
    public void testMapFromSchoolTypeEntity(){
        SchoolTypeDto schoolTypeTest = SchoolTypeDto.mapFromEntity( schoolType1 )
        assertEquals( schoolTypeTest.id, schoolType1.id );
        assertEquals( schoolTypeTest.code, schoolType1.code);
        assertEquals( schoolTypeTest.description, schoolType1.description);
    }
    
    @Test
    public void testMapFromSchoolTypesEntities(){
        List<SchoolTypeDto> schoolTypesDtoTest = SchoolTypeDto.mapFromList( schoolTypes )
        assertEquals( schoolTypesDtoTest[0].id, schoolType1.id );
        assertEquals( schoolTypesDtoTest[0].code, schoolType1.code);
        assertEquals( schoolTypesDtoTest[0].description, schoolType1.description);
        assertEquals( schoolTypesDtoTest[1].id, schoolType2.id );
        assertEquals( schoolTypesDtoTest[1].code, schoolType2.code);
        assertEquals( schoolTypesDtoTest[1].description, schoolType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        SchoolTypeDto schoolTypeDto1 = new SchoolTypeDto(schoolType1)
        SchoolTypeDto schoolTypeDto2 = new SchoolTypeDto(schoolType1)
        assertEquals(schoolTypeDto1, schoolTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        SchoolTypeDto schoolTypeDto1 = new SchoolTypeDto(schoolType1)
        SchoolTypeDto schoolTypeDto2 = new SchoolTypeDto(schoolType2)
        assertNotEquals(schoolTypeDto1, schoolTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        SchoolTypeDto schoolTypeDto1 = new SchoolTypeDto(schoolType1)
        SchoolTypeDto schoolTypeDto2 = new SchoolTypeDto(schoolType1)
        assertEquals(schoolTypeDto1.hashCode(), schoolTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        SchoolTypeDto schoolTypeDto1 = new SchoolTypeDto(schoolType1)
        SchoolTypeDto schoolTypeDto2 = new SchoolTypeDto(schoolType2)
        assertNotEquals(schoolTypeDto1.hashCode(), schoolTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_SchoolType() {
        SchoolTypeDto schoolTypeDto = new SchoolTypeDto(schoolType1)
        assertEquals( schoolTypeDto.code, schoolType1.code )
        assertEquals( schoolTypeDto.description, schoolType1.description )
    }
}
