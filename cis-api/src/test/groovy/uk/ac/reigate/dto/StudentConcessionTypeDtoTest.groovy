package uk.ac.reigate.dto;

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionType

public class StudentConcessionTypeDtoTest {
    
    private StudentConcessionType studentConcessionType1
    
    private StudentConcessionType studentConcessionType2
    
    private StudentConcessionType studentConcessionType3
    
    private List<StudentConcessionType> studentConcessionTypes
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    ConcessionType createConcessionType() {
        ConcessionType concessionType = new ConcessionType()
        concessionType.id = 1
        concessionType.code = 'T'
        concessionType.description = 'Test'
        return concessionType
    }
    
    @Before
    public void setup() {
        studentConcessionType1 = new StudentConcessionType(
                student: createStudent(),
                concessionType:createConcessionType(),
                extraTimePercentage:2
                );
        studentConcessionType2 = new StudentConcessionType(
                student: createStudent(),
                concessionType:createConcessionType(),
                extraTimePercentage:'F'
                );
        studentConcessionType3 = new StudentConcessionType(
                student: null,
                concessionType:null,
                extraTimePercentage:'F'
                );
        studentConcessionTypes = Arrays.asList(studentConcessionType1, studentConcessionType2);
    }
    
    @Test
    public void testMapFromStudentConcessionTypeEntity(){
        StudentConcessionTypeDto studentConcessionTypeTest = StudentConcessionTypeDto.mapFromEntity( studentConcessionType1 )
        assertEquals( studentConcessionTypeTest.studentId, studentConcessionType1.student.id );
        assertEquals( studentConcessionTypeTest.concessionTypeId, studentConcessionType1.concessionType.id);
        assertEquals( studentConcessionTypeTest.extraTimePercentage, studentConcessionType1.extraTimePercentage);
    }
    
    @Test
    public void testConstructor() {
        StudentConcessionTypeDto studentConcessionTypeTest = new StudentConcessionTypeDto(studentConcessionType1)
        assertEquals( studentConcessionTypeTest.studentId, studentConcessionType1.student.id );
        assertEquals( studentConcessionTypeTest.concessionTypeId, studentConcessionType1.concessionType.id);
        assertEquals( studentConcessionTypeTest.extraTimePercentage, studentConcessionType1.extraTimePercentage);
    }
    
    @Test
    public void testMapFromStudentConcessionTypesEntities(){
        List<StudentConcessionTypeDto> studentConcessionTypesDtoTest = StudentConcessionTypeDto.mapFromList( studentConcessionTypes )
        assertEquals( studentConcessionTypesDtoTest[0].studentId, studentConcessionType1.student.id );
        assertEquals( studentConcessionTypesDtoTest[0].concessionTypeId, studentConcessionType1.concessionType.id);
        assertEquals( studentConcessionTypesDtoTest[0].extraTimePercentage, studentConcessionType1.extraTimePercentage);
        assertEquals( studentConcessionTypesDtoTest[1].studentId, studentConcessionType2.student.id );
        assertEquals( studentConcessionTypesDtoTest[1].concessionTypeId, studentConcessionType2.concessionType.id);
        assertEquals( studentConcessionTypesDtoTest[1].extraTimePercentage, studentConcessionType2.extraTimePercentage);
    }
    
    @Test
    public void testEquals_Same() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType1)
        StudentConcessionTypeDto studentConcessionTypeDto2 = new StudentConcessionTypeDto(studentConcessionType1)
        assertEquals(studentConcessionTypeDto1, studentConcessionTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType1)
        StudentConcessionTypeDto studentConcessionTypeDto2 = new StudentConcessionTypeDto(studentConcessionType2)
        assertNotEquals(studentConcessionTypeDto1, studentConcessionTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType1)
        StudentConcessionTypeDto studentConcessionTypeDto2 = new StudentConcessionTypeDto(studentConcessionType1)
        assertEquals(studentConcessionTypeDto1.hashCode(), studentConcessionTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType1)
        StudentConcessionTypeDto studentConcessionTypeDto2 = new StudentConcessionTypeDto(studentConcessionType2)
        assertNotEquals(studentConcessionTypeDto1.hashCode(), studentConcessionTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentConcessionType() {
        StudentConcessionTypeDto studentConcessionTypeDto = new StudentConcessionTypeDto(studentConcessionType1)
        assertEquals( studentConcessionTypeDto.concessionTypeId, studentConcessionType1.concessionType.id )
        assertEquals( studentConcessionTypeDto.extraTimePercentage, studentConcessionType1.extraTimePercentage )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentConcessionTypeDto studentConcessionTypeDto = new StudentConcessionTypeDto(studentConcessionType3)
        assertEquals( studentConcessionTypeDto.concessionTypeId, studentConcessionType3.concessionType)
        assertEquals( studentConcessionTypeDto.extraTimePercentage, studentConcessionType3.extraTimePercentage )
    }
    
    @Test
    public void testConstructor_NullStudentConcessionType() {
        StudentConcessionType studentConcessionType = null
        StudentConcessionTypeDto studentConcessionTypeDto = new StudentConcessionTypeDto(studentConcessionType)
        assertEquals( studentConcessionType, null)
    }
    
    @Test
    public void testMethod_Get_NullConcessionCode() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType3)
        assertEquals(studentConcessionTypeDto1.concessionType, studentConcessionTypeDto1.get_ConcessionCode())
    }
    
    @Test
    public void testMethod_Get_ConcessionCode() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType1)
        assertEquals(studentConcessionTypeDto1.concessionType.code, studentConcessionTypeDto1.get_ConcessionCode())
    }
    
    @Test
    public void testMethod_Get_NullConcessionDescription() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType3)
        assertEquals(studentConcessionTypeDto1.concessionType, studentConcessionTypeDto1.get_ConcessionDescription())
    }
    
    @Test
    public void testMethod_Get_ConcessionDescription() {
        StudentConcessionTypeDto studentConcessionTypeDto1 = new StudentConcessionTypeDto(studentConcessionType1)
        assertEquals(studentConcessionTypeDto1.concessionType.description, studentConcessionTypeDto1.get_ConcessionDescription())
    }
}