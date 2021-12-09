package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.domain.lookup.PunctualityMonitoring

public class StudentWarningDtoTest {
    
    private StudentYear studentYear1
    
    private StudentYear studentYear2
    
    private StudentYear studentYear3
    
    private List<StudentYear> studentYears
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.studentYear1 = new StudentYear(
                student: new Student(id:190001),
                year: new AcademicYear(id:18),
                attendanceMonitoring: new AttendanceMonitoring(id:1, code: 'P', description: 'Present'),
                punctualityMonitoring : new PunctualityMonitoring(id:1, code: 'W', description: 'warning'),
                attendanceMonitorable: true,
                punctualityMonitorable: true
                );
        this.studentYear2 = new StudentYear(
                student: new Student(id:190003),
                year: new AcademicYear(id:18),
                attendanceMonitoring: new AttendanceMonitoring(id:1),
                punctualityMonitoring : new PunctualityMonitoring(id:1),
                attendanceMonitorable: true,
                punctualityMonitorable: true
                );
        this.studentYear3 = new StudentYear(
                student: null,
                year: null,
                attendanceMonitoring: null,
                punctualityMonitoring : null,
                attendanceMonitorable: true,
                punctualityMonitorable: true
                );
        this.studentYears = Arrays.asList(studentYear1, studentYear2);
    }
    
    @Test
    void testConstructor_student() {
        StudentWarningDto studentWarningDto = new StudentWarningDto( studentYear1 )
        assertEquals( studentWarningDto.studentId, studentYear1.student.id);
    }
    
    @Test
    void testConstructor_Nullstudent() {
        StudentWarningDto studentWarningDto = new StudentWarningDto( studentYear3 )
        assertEquals( studentWarningDto.studentId, studentYear3.student);
    }
    
    @Test
    void testConstructor_NullstudentYear() {
        StudentYear studentYear = null
        StudentWarningDto studentWarningDto = new StudentWarningDto( studentYear )
        assertEquals( studentYear, null);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        StudentWarningDto studentTest = StudentWarningDto.mapFromEntity( studentYear1 )
        assertEquals( studentTest.studentId, studentYear1.student.id );
    }
    
    @Test
    public void testEquals_Same() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        StudentWarningDto studentWarningDto2 = new StudentWarningDto(studentYear1)
        assertEquals(studentWarningDto1, studentWarningDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        StudentWarningDto studentWarningDto2 = new StudentWarningDto(studentYear2)
        assertNotEquals(studentWarningDto1, studentWarningDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        StudentWarningDto studentWarningDto2 = new StudentWarningDto(studentYear1)
        assertEquals(studentWarningDto1.hashCode(), studentWarningDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        StudentWarningDto studentWarningDto2 = new StudentWarningDto(studentYear2)
        assertNotEquals(studentWarningDto1.hashCode(), studentWarningDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullAttendanceMonitoringeCode() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear3)
        assertEquals(studentWarningDto1.attendanceMonitoring, studentWarningDto1.get_AttendanceMonitoringeCode())
    }
    
    @Test
    public void testMethod_Get_AttendanceMonitoringeCode() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        assertEquals(studentWarningDto1.attendanceMonitoring.code, studentWarningDto1.get_AttendanceMonitoringeCode())
    }
    
    @Test
    public void testMethod_Get_NullAttendanceMonitoringeDescription() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear3)
        assertEquals(studentWarningDto1.attendanceMonitoring, studentWarningDto1.get_AttendanceMonitoringeDescription())
    }
    
    @Test
    public void testMethod_Get_AttendanceMonitoringeDescription() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        assertEquals(studentWarningDto1.attendanceMonitoring.description, studentWarningDto1.get_AttendanceMonitoringeDescription())
    }
    
    @Test
    public void testMethod_Get_NullPunctualityMonitoringeCode() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear3)
        assertEquals(studentWarningDto1.punctualityMonitoring, studentWarningDto1.get_PunctualityMonitoringeCode())
    }
    
    @Test
    public void testMethod_Get_PunctualityMonitoringeCode() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        assertEquals(studentWarningDto1.punctualityMonitoring.code, studentWarningDto1.get_PunctualityMonitoringeCode())
    }
    
    @Test
    public void testMethod_Get_NullPunctualityMonitoringeDescription() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear3)
        assertEquals(studentWarningDto1.punctualityMonitoring, studentWarningDto1.get_PunctualityMonitoringeDescription())
    }
    
    @Test
    public void testMethod_Get_PunctualityMonitoringeDescription() {
        StudentWarningDto studentWarningDto1 = new StudentWarningDto(studentYear1)
        assertEquals(studentWarningDto1.punctualityMonitoring.description, studentWarningDto1.get_PunctualityMonitoringeDescription())
    }
}