package uk.ac.reigate.dto.learningsupport;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.domain.learning_support.StudentCourseConcession

public class StudentCourseConcessionDtoTest {
    
    private StudentCourseConcession studentCourseConcession1
    
    private StudentCourseConcession studentCourseConcession2
    
    private StudentCourseConcession studentCourseConcession3
    
    private List<StudentCourseConcession> studentCourseConcessions
    
    @Before
    public void setup() {
        studentCourseConcession1 = new StudentCourseConcession(
                student: new Student(id: 200001),
                concessionType: new ConcessionType(id:1),
                course: new Course(id:1),
                extraTimePercentage:2
                );
        studentCourseConcession2 = new StudentCourseConcession(
                student: new Student(id: 200001),
                concessionType: new ConcessionType(id:1),
                course: new Course(id:1),
                extraTimePercentage:'F'
                );
        studentCourseConcession3 = new StudentCourseConcession(
                student: null,
                concessionType:null,
                course: null,
                extraTimePercentage:'F'
                );
        studentCourseConcessions = Arrays.asList(studentCourseConcession1, studentCourseConcession2);
    }
    
    @Test
    public void testMapFromStudentCourseConcessionEntity(){
        StudentCourseConcessionDto studentCourseConcessionTest = StudentCourseConcessionDto.mapFromEntity( studentCourseConcession1 )
        assertEquals( studentCourseConcessionTest.studentId, studentCourseConcession1.student.id );
        assertEquals( studentCourseConcessionTest.concessionTypeId, studentCourseConcession1.concessionType.id);
        assertEquals( studentCourseConcessionTest.extraTimePercentage, studentCourseConcession1.extraTimePercentage);
    }
    
    @Test
    public void testConstructor() {
        StudentCourseConcessionDto studentCourseConcessionTest = new StudentCourseConcessionDto(studentCourseConcession1)
        assertEquals( studentCourseConcessionTest.studentId, studentCourseConcession1.student.id );
        assertEquals( studentCourseConcessionTest.concessionTypeId, studentCourseConcession1.concessionType.id);
        assertEquals( studentCourseConcessionTest.extraTimePercentage, studentCourseConcession1.extraTimePercentage);
    }
    
    @Test
    public void testMapFromStudentCourseConcessionsEntities(){
        List<StudentCourseConcessionDto> studentCourseConcessionsDtoTest = StudentCourseConcessionDto.mapFromList( studentCourseConcessions )
        assertEquals( studentCourseConcessionsDtoTest[0].studentId, studentCourseConcession1.student.id );
        assertEquals( studentCourseConcessionsDtoTest[0].concessionTypeId, studentCourseConcession1.concessionType.id);
        assertEquals( studentCourseConcessionsDtoTest[0].extraTimePercentage, studentCourseConcession1.extraTimePercentage);
        assertEquals( studentCourseConcessionsDtoTest[1].studentId, studentCourseConcession2.student.id );
        assertEquals( studentCourseConcessionsDtoTest[1].concessionTypeId, studentCourseConcession2.concessionType.id);
        assertEquals( studentCourseConcessionsDtoTest[1].extraTimePercentage, studentCourseConcession2.extraTimePercentage);
    }
    
    
    @Test
    public void testEquals_Different() {
        StudentCourseConcessionDto studentCourseConcessionDto1 = new StudentCourseConcessionDto(studentCourseConcession1)
        StudentCourseConcessionDto studentCourseConcessionDto2 = new StudentCourseConcessionDto(studentCourseConcession2)
        assertNotEquals(studentCourseConcessionDto1, studentCourseConcessionDto2)
    }
    
    @Test
    public void testHashCode_Different() {
        StudentCourseConcessionDto studentCourseConcessionDto1 = new StudentCourseConcessionDto(studentCourseConcession1)
        StudentCourseConcessionDto studentCourseConcessionDto2 = new StudentCourseConcessionDto(studentCourseConcession2)
        assertNotEquals(studentCourseConcessionDto1.hashCode(), studentCourseConcessionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentCourseConcession() {
        StudentCourseConcessionDto studentCourseConcessionDto = new StudentCourseConcessionDto(studentCourseConcession1)
        assertEquals( studentCourseConcessionDto.concessionTypeId, studentCourseConcession1.concessionType.id )
        assertEquals( studentCourseConcessionDto.extraTimePercentage, studentCourseConcession1.extraTimePercentage )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentCourseConcessionDto studentCourseConcessionDto = new StudentCourseConcessionDto(studentCourseConcession3)
        assertEquals( studentCourseConcessionDto.concessionTypeId, studentCourseConcession3.concessionType )
        assertEquals( studentCourseConcessionDto.extraTimePercentage, studentCourseConcession3.extraTimePercentage )
    }
    
    @Test
    public void testConstructor_NullStudentCourseConcession() {
        StudentCourseConcession studentCourseConcession = null
        StudentCourseConcessionDto studentCourseConcessionDto = new StudentCourseConcessionDto(studentCourseConcession)
        assertEquals( studentCourseConcession, null)
    }
    
    @Test
    public void testMethod_Get_ConcessionCode() {
        StudentCourseConcessionDto studentCourseConcessionDto1 = new StudentCourseConcessionDto(studentCourseConcession1)
        assertEquals(studentCourseConcessionDto1.concessionType.code, studentCourseConcessionDto1.get_ConcessionCode())
    }
    
    @Test
    public void testMethod_Get_ConcessionDescription() {
        StudentCourseConcessionDto studentCourseConcessionDto1 = new StudentCourseConcessionDto(studentCourseConcession1)
        assertEquals(studentCourseConcessionDto1.concessionType.description, studentCourseConcessionDto1.get_ConcessionDescription())
    }
}