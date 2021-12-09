package uk.ac.reigate.dto;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.dto.lookup.StudentTypeDto

import static org.junit.Assert.*

public class StudentTypeDtoTest {
    
    private StudentType studentType1
    
    private StudentType studentType2
    
    private List<StudentType> studentTypes
    
    @Before
    public void setup() {
        studentType1 = new StudentType(
                id: 1,
                code:'L',
                description:'Lower'
                );
        studentType2 = new StudentType(
                id: 2,
                code:'U',
                description:'Upper'
                );
        studentTypes = Arrays.asList(studentType1, studentType2);
    }
    
    @Test
    public void testMapFromStudentTypeEntity(){
        StudentTypeDto studentTypeTest = StudentTypeDto.mapFromEntity( studentType1 )
        assertEquals( studentTypeTest.id, studentType1.id );
        assertEquals( studentTypeTest.code, studentType1.code);
        assertEquals( studentTypeTest.description, studentType1.description);
    }
    
    @Test
    public void testMapFromStudentTypesEntities(){
        List<StudentTypeDto> studentTypesDtoTest = StudentTypeDto.mapFromList( studentTypes )
        assertEquals( studentTypesDtoTest[0].id, studentType1.id );
        assertEquals( studentTypesDtoTest[0].code, studentType1.code);
        assertEquals( studentTypesDtoTest[0].description, studentType1.description);
        assertEquals( studentTypesDtoTest[1].id, studentType2.id );
        assertEquals( studentTypesDtoTest[1].code, studentType2.code);
        assertEquals( studentTypesDtoTest[1].description, studentType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        StudentTypeDto studentTypeDto1 = new StudentTypeDto(studentType1)
        StudentTypeDto studentTypeDto2 = new StudentTypeDto(studentType1)
        assertEquals(studentTypeDto1, studentTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentTypeDto studentTypeDto1 = new StudentTypeDto(studentType1)
        StudentTypeDto studentTypeDto2 = new StudentTypeDto(studentType2)
        assertNotEquals(studentTypeDto1, studentTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentTypeDto studentTypeDto1 = new StudentTypeDto(studentType1)
        StudentTypeDto studentTypeDto2 = new StudentTypeDto(studentType1)
        assertEquals(studentTypeDto1.hashCode(), studentTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentTypeDto studentTypeDto1 = new StudentTypeDto(studentType1)
        StudentTypeDto studentTypeDto2 = new StudentTypeDto(studentType2)
        assertNotEquals(studentTypeDto1.hashCode(), studentTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentType() {
        StudentTypeDto studentTypeDto = new StudentTypeDto(studentType1)
        assertEquals( studentTypeDto.code, studentType1.code )
        assertEquals( studentTypeDto.description, studentType1.description )
    }
}
