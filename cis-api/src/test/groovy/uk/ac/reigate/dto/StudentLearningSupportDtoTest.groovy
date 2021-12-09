package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.domain.learning_support.StudentLearningSupport
import uk.ac.reigate.domain.learning_support.StudentReferralReason
import uk.ac.reigate.domain.learning_support.SupportType


public class StudentLearningSupportDtoTest {
    
    private StudentLearningSupport studentLearningSupport1
    
    private StudentLearningSupport studentLearningSupport2
    
    private StudentLearningSupport studentLearningSupport3
    
    private StudentLearningSupport studentLearningSupport4
    
    private List<StudentLearningSupport> studentLearningSupports
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        student.readingInitialAssessment = new InitialAssessmentLevel(id:1)
        student.writingInitialAssessment = new InitialAssessmentLevel(id:1)
        student.spellingInitialAssessment = new InitialAssessmentLevel(id:1)
        student.concessions = Arrays.asList(
                new StudentConcessionType(student: new Student(id: 190001)),
                new StudentConcessionType(student: new Student(id: 190003))
                )
        student.courseConcessions = Arrays.asList(
                new StudentCourseConcession(id:1),
                new StudentCourseConcession(id:2))
        student.referralReasons = Arrays.asList(
                new StudentReferralReason(id:1),
                new StudentReferralReason(id:2)
                )
        return student
    }
    
    Student createStudent2() {
        Student student = new Student()
        student.id = 2
        return student
    }
    
    SupportType createSupportType() {
        SupportType supportType = new SupportType()
    }
    
    @Before
    public void setup() {
        studentLearningSupport1 = new StudentLearningSupport(
                student: createStudent(),
                supportType:createSupportType(),
                supportNotes : 'test',
                previousConcession : 'test'
                );
        studentLearningSupport2 = new StudentLearningSupport(
                student: createStudent2(),
                supportType:createSupportType(),
                supportNotes : 'test',
                previousConcession : 'test'
                );
        studentLearningSupport3 = new StudentLearningSupport(
                student: null,
                supportType:null,
                supportNotes : 'test',
                previousConcession : 'test'
                );
        studentLearningSupport4 = new StudentLearningSupport(
                student: createStudent2(),
                supportType:null,
                supportNotes : 'test',
                previousConcession : 'test'
                );
        studentLearningSupports = Arrays.asList(studentLearningSupport1, studentLearningSupport2);
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(studentLearningSupport3)
        assertEquals( studentLearningSupportDto.supportTypeId, studentLearningSupport3.supportType )
        assertEquals( studentLearningSupportDto.previousConcession, studentLearningSupport3.previousConcession)
    }
    
    @Test
    public void testConstructor_NullStudentLearningSupport() {
        StudentLearningSupport studentLearningSupport = null
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(studentLearningSupport)
        assertEquals( studentLearningSupport, null )
    }
    
    @Test
    public void testConstructor_NullStudentObject() {
        StudentLearningSupport studentLearningSupport = null
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(createStudent(), studentLearningSupport1)
        assertEquals( studentLearningSupportDto.studentId, createStudent().id )
    }
    
    @Test
    public void testConstructor_StudentNullStudentLearningSupport() {
        StudentLearningSupport studentLearningSupport = null
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(createStudent(), studentLearningSupport)
        assertEquals( studentLearningSupportDto.studentId, null)
    }
    
    @Test
    public void testConstructor_Student_StudentLearningSupport() {
        StudentLearningSupport studentLearningSupport = null
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(createStudent2(), studentLearningSupport1)
        assertEquals( studentLearningSupportDto.studentId, createStudent().id )
    }
    
    @Test
    public void testConstructor_Student_NullSupportType() {
        StudentLearningSupport studentLearningSupport = null
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(createStudent2(), studentLearningSupport4)
        assertEquals( studentLearningSupportDto.studentId, createStudent2().id )
    }
    
    @Test
    public void testMapFromStudentLearningSupportEntity(){
        StudentLearningSupportDto studentLearningSupportTest = StudentLearningSupportDto.mapFromEntity( studentLearningSupport1 )
        assertEquals( studentLearningSupportTest.studentId, studentLearningSupport1.student.id );
        assertEquals( studentLearningSupportTest.supportTypeId, studentLearningSupport1.supportType.id);
        assertEquals( studentLearningSupportTest.previousConcession, studentLearningSupport1.previousConcession)
    }
    
    @Test
    public void testMapFromStudentLearningSupportsEntities(){
        List<StudentLearningSupportDto> studentLearningSupportsDtoTest = StudentLearningSupportDto.mapFromList( studentLearningSupports )
        assertEquals( studentLearningSupportsDtoTest[0].studentId, studentLearningSupport1.student.id );
        assertEquals( studentLearningSupportsDtoTest[0].supportTypeId, studentLearningSupport1.supportType.id);
        assertEquals( studentLearningSupportsDtoTest[1].studentId, studentLearningSupport2.student.id );
        assertEquals( studentLearningSupportsDtoTest[1].supportTypeId, studentLearningSupport2.supportType.id);
    }
    
    @Test
    public void testEquals_Different() {
        StudentLearningSupportDto studentLearningSupportDto1 = new StudentLearningSupportDto(studentLearningSupport1)
        StudentLearningSupportDto studentLearningSupportDto2 = new StudentLearningSupportDto(studentLearningSupport2)
        assertNotEquals(studentLearningSupportDto1, studentLearningSupportDto2)
    }
    
    @Test
    public void testHashCode_Different() {
        StudentLearningSupportDto studentLearningSupportDto1 = new StudentLearningSupportDto(studentLearningSupport1)
        StudentLearningSupportDto studentLearningSupportDto2 = new StudentLearningSupportDto(studentLearningSupport2)
        assertNotEquals(studentLearningSupportDto1.hashCode(), studentLearningSupportDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentLearningSupport() {
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(studentLearningSupport1)
        assertEquals( studentLearningSupportDto.supportTypeId, studentLearningSupport1.supportType.id )
        assertEquals( studentLearningSupportDto.previousConcession, studentLearningSupport1.previousConcession)
    }
    
    @Test
    public void testConstructor_StudentLearningSupportAndStudent() {
        StudentLearningSupportDto studentLearningSupportDto = new StudentLearningSupportDto(createStudent(), studentLearningSupport1)
        assertEquals( studentLearningSupportDto.supportTypeId, studentLearningSupport1.supportType.id )
        assertEquals( studentLearningSupportDto.previousConcession, studentLearningSupport1.previousConcession)
    }
    
    @Test
    public void testMethod_Get_NullSupportTypeDescription() {
        StudentLearningSupportDto studentLearningSupportDto1 = new StudentLearningSupportDto(studentLearningSupport3)
        assertEquals(studentLearningSupportDto1.supportType, studentLearningSupportDto1.get_SupportTypeDescription())
    }
    
    @Test
    public void testMethod_Get_SupportTypeDescription() {
        StudentLearningSupportDto studentLearningSupportDto1 = new StudentLearningSupportDto(studentLearningSupport1)
        assertEquals(studentLearningSupportDto1.supportType.support, studentLearningSupportDto1.get_SupportTypeDescription())
    }
}
