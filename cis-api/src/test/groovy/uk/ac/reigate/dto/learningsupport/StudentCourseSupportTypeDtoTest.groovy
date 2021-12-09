package uk.ac.reigate.dto.learningsupport;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.SupportType
import uk.ac.reigate.domain.learning_support.StudentCourseSupportType

public class StudentCourseSupportTypeDtoTest {
    
    private StudentCourseSupportType studentCourseSupportType1
    
    private StudentCourseSupportType studentCourseSupportType2
    
    private StudentCourseSupportType studentCourseSupportType3
    
    private List<StudentCourseSupportType> studentCourseSupportTypes
    
    @Before
    public void setup() {
        studentCourseSupportType1 = new StudentCourseSupportType(
                student: new Student(id: 200001),
                supportType: new SupportType(id:1),
                course: new Course(id:1),
                startDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        studentCourseSupportType2 = new StudentCourseSupportType(
                student: new Student(id: 200001),
                supportType: new SupportType(id:1),
                course: new Course(id:1),
                startDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        studentCourseSupportType3 = new StudentCourseSupportType(
                student: null,
                supportType:null,
                course: null,
                startDate:new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        studentCourseSupportTypes = Arrays.asList(studentCourseSupportType1, studentCourseSupportType2);
    }
    
    @Test
    public void testMapFromStudentCourseSupportTypeEntity(){
        StudentCourseSupportTypeDto studentCourseSupportTypeTest = StudentCourseSupportTypeDto.mapFromEntity( studentCourseSupportType1 )
        assertEquals( studentCourseSupportTypeTest.studentId, studentCourseSupportType1.student.id );
        assertEquals( studentCourseSupportTypeTest.supportTypeId, studentCourseSupportType1.supportType.id);
        assertEquals( studentCourseSupportTypeTest.startDate, studentCourseSupportType1.startDate);
    }
    
    @Test
    public void testConstructor() {
        StudentCourseSupportTypeDto studentCourseSupportTypeTest = new StudentCourseSupportTypeDto(studentCourseSupportType1)
        assertEquals( studentCourseSupportTypeTest.studentId, studentCourseSupportType1.student.id );
        assertEquals( studentCourseSupportTypeTest.supportTypeId, studentCourseSupportType1.supportType.id);
        assertEquals( studentCourseSupportTypeTest.startDate, studentCourseSupportType1.startDate);
    }
    
    @Test
    public void testMapFromStudentCourseSupportTypesEntities(){
        List<StudentCourseSupportTypeDto> studentCourseSupportTypesDtoTest = StudentCourseSupportTypeDto.mapFromList( studentCourseSupportTypes )
        assertEquals( studentCourseSupportTypesDtoTest[0].studentId, studentCourseSupportType1.student.id );
        assertEquals( studentCourseSupportTypesDtoTest[0].supportTypeId, studentCourseSupportType1.supportType.id);
        assertEquals( studentCourseSupportTypesDtoTest[0].startDate, studentCourseSupportType1.startDate);
        assertEquals( studentCourseSupportTypesDtoTest[1].studentId, studentCourseSupportType2.student.id );
        assertEquals( studentCourseSupportTypesDtoTest[1].supportTypeId, studentCourseSupportType2.supportType.id);
        assertEquals( studentCourseSupportTypesDtoTest[1].startDate, studentCourseSupportType2.startDate);
    }
    
    
    @Test
    public void testEquals_Different() {
        StudentCourseSupportTypeDto studentCourseSupportTypeDto1 = new StudentCourseSupportTypeDto(studentCourseSupportType1)
        StudentCourseSupportTypeDto studentCourseSupportTypeDto2 = new StudentCourseSupportTypeDto(studentCourseSupportType2)
        assertNotEquals(studentCourseSupportTypeDto1, studentCourseSupportTypeDto2)
    }
    
    @Test
    public void testHashCode_Different() {
        StudentCourseSupportTypeDto studentCourseSupportTypeDto1 = new StudentCourseSupportTypeDto(studentCourseSupportType1)
        StudentCourseSupportTypeDto studentCourseSupportTypeDto2 = new StudentCourseSupportTypeDto(studentCourseSupportType2)
        assertNotEquals(studentCourseSupportTypeDto1.hashCode(), studentCourseSupportTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentCourseSupportType() {
        StudentCourseSupportTypeDto studentCourseSupportTypeDto = new StudentCourseSupportTypeDto(studentCourseSupportType1)
        assertEquals( studentCourseSupportTypeDto.supportTypeId, studentCourseSupportType1.supportType.id )
        assertEquals( studentCourseSupportTypeDto.startDate, studentCourseSupportType1.startDate )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentCourseSupportTypeDto studentCourseSupportTypeDto = new StudentCourseSupportTypeDto(studentCourseSupportType3)
        assertEquals( studentCourseSupportTypeDto.supportTypeId, studentCourseSupportType3.supportType )
        assertEquals( studentCourseSupportTypeDto.startDate, studentCourseSupportType3.startDate )
    }
    
    @Test
    public void testConstructor_NullStudentCourseSupportType() {
        StudentCourseSupportType studentCourseSupportType = null
        StudentCourseSupportTypeDto studentCourseSupportTypeDto = new StudentCourseSupportTypeDto(studentCourseSupportType)
        assertEquals( studentCourseSupportType, null)
    }
    
    @Test
    public void testMethod_Get_SupportType() {
        StudentCourseSupportTypeDto studentCourseSupportTypeDto1 = new StudentCourseSupportTypeDto(studentCourseSupportType1)
        assertEquals(studentCourseSupportTypeDto1.supportType.support, studentCourseSupportTypeDto1.get_SupportType())
    }
}