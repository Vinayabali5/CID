package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.academic.StudentEntryQualification
import uk.ac.reigate.domain.exams.ExamBoard


public class StudentEntryQualificationDtoTest {
    
    private StudentEntryQualification studentEntryQualification1
    
    private StudentEntryQualification studentEntryQualification2
    
    private StudentEntryQualification studentEntryQualification3
    
    private List<StudentEntryQualification> studentEntryQualifications
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    EntryQualification createEntryQualification() {
        EntryQualification qualification = new EntryQualification(
                type: new EntryQualificationType(id:1 )
                )
        qualification.id = 1
        return qualification
    }
    
    @Before
    public void setup() {
        studentEntryQualification1 = new StudentEntryQualification(
                id: 1,
                student: createStudent(),
                qualification:createEntryQualification(),
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                grade: 'A',
                checked : true,
                examBoard: new ExamBoard(id:1)
                );
        studentEntryQualification2 = new StudentEntryQualification(
                id: 2,
                student: createStudent(),
                qualification:createEntryQualification(),
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                grade: 'A',
                checked : true,
                examBoard: new ExamBoard(id:1)
                );
        studentEntryQualification3 = new StudentEntryQualification(
                id: 3,
                student: null,
                qualification:null,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                grade: 'A',
                checked : true,
                examBoard: null
                );
        studentEntryQualifications = Arrays.asList(studentEntryQualification1, studentEntryQualification2);
    }
    
    @Test
    public void testMapFromStudentEntryQualificationEntity(){
        StudentEntryQualificationDto studentEntryQualificationTest = StudentEntryQualificationDto.mapFromEntity( studentEntryQualification1 )
        assertEquals( studentEntryQualificationTest.studentId, studentEntryQualification1.student.id );
        assertEquals( studentEntryQualificationTest.entryQualificationId, studentEntryQualification1.qualification.id);
        assertEquals( studentEntryQualificationTest.date, studentEntryQualification1.date);
        assertEquals( studentEntryQualificationTest.grade, studentEntryQualification1.grade)
        assertEquals( studentEntryQualificationTest.checked, studentEntryQualification1.checked)
    }
    
    @Test
    public void testMapFromStudentEntryQualificationsEntities(){
        List<StudentEntryQualificationDto> studentEntryQualificationsDtoTest = StudentEntryQualificationDto.mapFromList( studentEntryQualifications )
        assertEquals( studentEntryQualificationsDtoTest[0].studentId, studentEntryQualification1.student.id );
        assertEquals( studentEntryQualificationsDtoTest[0].entryQualificationId, studentEntryQualification1.qualification.id);
        assertEquals( studentEntryQualificationsDtoTest[0].date, studentEntryQualification1.date);
        assertEquals( studentEntryQualificationsDtoTest[1].studentId, studentEntryQualification2.student.id );
        assertEquals( studentEntryQualificationsDtoTest[1].entryQualificationId, studentEntryQualification2.qualification.id);
        assertEquals( studentEntryQualificationsDtoTest[1].date, studentEntryQualification2.date);
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentEntryQualificationDto studentEntryQualificationDto1 = new StudentEntryQualificationDto(studentEntryQualification1)
        StudentEntryQualificationDto studentEntryQualificationDto2 = new StudentEntryQualificationDto(studentEntryQualification1)
        assertEquals(studentEntryQualificationDto1, studentEntryQualificationDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentEntryQualificationDto studentEntryQualificationDto1 = new StudentEntryQualificationDto(studentEntryQualification1)
        StudentEntryQualificationDto studentEntryQualificationDto2 = new StudentEntryQualificationDto(studentEntryQualification2)
        assertNotEquals(studentEntryQualificationDto1, studentEntryQualificationDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentEntryQualificationDto studentEntryQualificationDto1 = new StudentEntryQualificationDto(studentEntryQualification1)
        StudentEntryQualificationDto studentEntryQualificationDto2 = new StudentEntryQualificationDto(studentEntryQualification1)
        assertEquals(studentEntryQualificationDto1.hashCode(), studentEntryQualificationDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentEntryQualificationDto studentEntryQualificationDto1 = new StudentEntryQualificationDto(studentEntryQualification1)
        StudentEntryQualificationDto studentEntryQualificationDto2 = new StudentEntryQualificationDto(studentEntryQualification2)
        assertNotEquals(studentEntryQualificationDto1.hashCode(), studentEntryQualificationDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentEntryQualification() {
        StudentEntryQualificationDto studentEntryQualificationDto = new StudentEntryQualificationDto(studentEntryQualification1)
        assertEquals( studentEntryQualificationDto.entryQualificationId, studentEntryQualification1.qualification.id )
        assertEquals( studentEntryQualificationDto.date, studentEntryQualification1.date )
        assertEquals( studentEntryQualificationDto.grade, studentEntryQualification1.grade)
        assertEquals( studentEntryQualificationDto.checked, studentEntryQualification1.checked)
    }
    
    @Test
    public void testConstructor_NullEntryQualification() {
        StudentEntryQualificationDto studentEntryQualificationDto = new StudentEntryQualificationDto(studentEntryQualification3)
        assertEquals( studentEntryQualificationDto.entryQualificationId, studentEntryQualification3.qualification )
        assertEquals( studentEntryQualificationDto.date, studentEntryQualification3.date )
        assertEquals( studentEntryQualificationDto.grade, studentEntryQualification3.grade)
        assertEquals( studentEntryQualificationDto.checked, studentEntryQualification3.checked)
    }
    
    @Test
    public void testConstructor_NullStudentEntryQualification() {
        StudentEntryQualification studentEntryQualification = null
        StudentEntryQualificationDto studentEntryQualificationDto = new StudentEntryQualificationDto(studentEntryQualification)
        assertEquals( studentEntryQualification, null )
    }
    
    @Test
    public void testMethod_Get_NullExamBoardName() {
        StudentEntryQualificationDto studentEntryQualificationDto1 = new StudentEntryQualificationDto(studentEntryQualification3)
        assertEquals(studentEntryQualificationDto1.examBoard, studentEntryQualificationDto1.get_ExamBoardName())
    }
    
    @Test
    public void testMethod_Get_ExamBoardName() {
        StudentEntryQualificationDto studentEntryQualificationDto1 = new StudentEntryQualificationDto(studentEntryQualification1)
        assertEquals(studentEntryQualificationDto1.examBoard.name, studentEntryQualificationDto1.get_ExamBoardName())
    }
}
