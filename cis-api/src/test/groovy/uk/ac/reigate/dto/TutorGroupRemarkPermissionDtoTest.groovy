package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.exceptions.InvalidDataException

public class TutorGroupRemarkPermissionDtoTest {
    
    private StudentYear studentYear1
    
    private StudentYear studentYear2
    
    private StudentYear studentYear3
    
    private List<StudentYear> studentYears
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        student.person = new Person()
        student.person.firstName = 'vinaya'
        student.person.surname = 'bali'
        student.studentRemarkPermission = new StudentRemarkPermission(id:2)
        return student
    }
    
    Student createStudent1() {
        Student student = new Student()
        student.id = 1
        student.person = null
        student.studentRemarkPermission = null
        return student
    }
    
    @Before
    public void setup() {
        this.studentYear1 = new StudentYear(
                student: createStudent(),
                year: new AcademicYear(id:18),
                tutorGroup: new TutorGroup(id:1),
                candidateNo : 1,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2016/06/30')
                );
        this.studentYear2 = new StudentYear(
                student: createStudent1(),
                year: new AcademicYear(id:18),
                tutorGroup: new TutorGroup(id:1),
                candidateNo : 1,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2016/06/30')
                );
        this.studentYear3 = new StudentYear(
                student: new Student(id: 20004),
                year: null,
                tutorGroup: null,
                candidateNo : 1,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2016/06/30')
                );
        this.studentYears = Arrays.asList(studentYear1, studentYear2);
    }
    
    @Test
    void testConstructor_student() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto = new TutorGroupRemarkPermissionDto( studentYear1 )
        assertEquals( tutorGroupRemarkPermissionDto.studentId, studentYear1.student.id);
    }
    
    
    @Test
    public void testConstructor_NullStudentYear() {
        StudentYear studentYear = null
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto = new TutorGroupRemarkPermissionDto(studentYear)
        assertEquals( studentYear, null)
    }
    
    @Test
    void testConstructor_NullStudentRemarkPermission() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto = new TutorGroupRemarkPermissionDto( studentYear3 )
        assertEquals( tutorGroupRemarkPermissionDto.studentId, studentYear3.student.id);
        assertEquals( tutorGroupRemarkPermissionDto.student.studentRemarkPermissionId, null);
        assertEquals( tutorGroupRemarkPermissionDto.tutorGroupId, null);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        TutorGroupRemarkPermissionDto studentTest = TutorGroupRemarkPermissionDto.mapFromStudentEntity( studentYear1 )
        assertEquals( studentTest.studentId, studentYear1.student.id );
        assertEquals( studentTest.candidateNo, studentYear1.candidateNo );
        assertEquals( studentTest.tutorGroupId, studentYear1.tutorGroup.id );
        assertEquals( studentTest._startDate, studentYear1.startDate );
        assertEquals( studentTest._endDate, studentYear1.endDate );
    }
    
    @Test
    public void testMapFromStudentsEntities(){
        List<TutorGroupRemarkPermissionDto> studentTest = TutorGroupRemarkPermissionDto.mapFromStudentsEntities( studentYears )
        assertEquals( studentTest[0].studentId, studentYear1.student.id );
        assertEquals( studentTest[0].candidateNo, studentYear1.candidateNo );
        assertEquals( studentTest[0].tutorGroupId, studentYear1.tutorGroup.id );
        assertEquals( studentTest[0]._startDate, studentYear1.startDate );
        assertEquals( studentTest[0]._endDate, studentYear1.endDate );
        assertEquals( studentTest[1].studentId, studentYear2.student.id );
        assertEquals( studentTest[1].candidateNo, studentYear2.candidateNo );
        assertEquals( studentTest[1].tutorGroupId, studentYear2.tutorGroup.id );
        assertEquals( studentTest[1]._startDate, studentYear2.startDate );
        assertEquals( studentTest[1]._endDate, studentYear2.endDate );
    }
    
    @Test
    public void testMethod_Get_NullTutorGroupCode() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear3)
        assertEquals(tutorGroupRemarkPermissionDto1.tutorGroup, tutorGroupRemarkPermissionDto1.get_TutorGroupCode())
    }
    
    @Test
    public void testMethod_Get_TutorGroupCode() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear1)
        assertEquals(tutorGroupRemarkPermissionDto1.tutorGroup.code, tutorGroupRemarkPermissionDto1.get_TutorGroupCode())
    }
    
    @Test
    public void testMethod_Get_NullPersonFirstName() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear2)
        assertEquals(tutorGroupRemarkPermissionDto1.student.person, tutorGroupRemarkPermissionDto1.get_FirstName())
    }
    
    @Test
    public void testMethod_Get_FirstName() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear1)
        assertEquals(tutorGroupRemarkPermissionDto1.student.person.firstName, tutorGroupRemarkPermissionDto1.get_FirstName())
    }
    
    @Test
    public void testMethod_Get_PersonNullSurname() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear2)
        assertEquals(tutorGroupRemarkPermissionDto1.student.person, tutorGroupRemarkPermissionDto1.get_Surname())
    }
    
    @Test
    public void testMethod_Get_Surname() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear1)
        assertEquals(tutorGroupRemarkPermissionDto1.student.person.surname, tutorGroupRemarkPermissionDto1.get_Surname())
    }
    
    @Test
    public void testMethod_Get_NullStudentRemarkPermissionDecription() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear3)
        assertEquals(tutorGroupRemarkPermissionDto1.studentRemarkPermission, tutorGroupRemarkPermissionDto1.get_StudentRemarkPermissionDecription())
    }
    
    @Test
    public void testMethod_Get_StudentRemarkPermissionDecription() {
        TutorGroupRemarkPermissionDto tutorGroupRemarkPermissionDto1 = new TutorGroupRemarkPermissionDto(studentYear1)
        assertEquals(tutorGroupRemarkPermissionDto1.studentRemarkPermission.description, tutorGroupRemarkPermissionDto1.get_StudentRemarkPermissionDecription())
    }
}