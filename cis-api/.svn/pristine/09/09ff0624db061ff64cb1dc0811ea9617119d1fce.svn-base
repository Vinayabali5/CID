package uk.ac.reigate.dto.attendance;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.attendance.StudentAttendance


public class StudentAttendanceDtoTest {
    
    private StudentAttendance studentAttendance1
    
    private StudentAttendance studentAttendance2
    
    private List<StudentAttendance> studentAttendances
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Staff createStaff() {
        Staff staff = new Staff()
        staff.id = 1
        return staff
    }
    
    AcademicYear createAcademicYear() {
        AcademicYear academicYear = new AcademicYear()
        academicYear.id = 1
        return academicYear
    }
    
    Course createCourse() {
        Course course = new Course()
        course.id = 1
        return course
    }
    
    @Before
    public void setup() {
        studentAttendance1 = new StudentAttendance(
                course: createCourse(),
                student: createStudent(),
                academicYear:createAcademicYear(),
                sumOfPeriods: 1,
                sumOfAbsences: 2,
                sumOfAdjAbs: 3,
                sumOfLates : 3
                );
        studentAttendance2 = new StudentAttendance(
                course: createCourse(),
                student: createStudent(),
                academicYear:createAcademicYear(),
                sumOfPeriods: 1,
                sumOfAbsences: 2,
                sumOfAdjAbs: 3,
                sumOfLates : 3
                );
        studentAttendances = Arrays.asList(studentAttendance1, studentAttendance2);
    }
    
    @Test
    public void testMapFromStudentAttendanceEntity(){
        StudentAttendanceDto studentAttendanceTest = StudentAttendanceDto.mapFromEntity( studentAttendance1 )
        assertEquals( studentAttendanceTest.studentId, studentAttendance1.student.id );
        assertEquals( studentAttendanceTest.courseId, studentAttendance1.course.id);
        assertEquals( studentAttendanceTest.academicYearId, studentAttendance1.academicYear.id);
        assertEquals( studentAttendanceTest.sumOfPeriods, studentAttendance1.sumOfPeriods)
        assertEquals( studentAttendanceTest.sumOfAbsences, studentAttendance1.sumOfAbsences)
        assertEquals( studentAttendanceTest.sumOfAdjAbs, studentAttendance1.sumOfAdjAbs)
        assertEquals( studentAttendanceTest.sumOfLates, studentAttendance1.sumOfLates)
    }
    
    @Test
    public void testMapFromStudentAttendancesEntities(){
        List<StudentAttendanceDto> studentAttendancesDtoTest = StudentAttendanceDto.mapFromList( studentAttendances )
        assertEquals( studentAttendancesDtoTest[0].studentId, studentAttendance1.student.id );
        assertEquals( studentAttendancesDtoTest[0].courseId, studentAttendance1.course.id);
        assertEquals( studentAttendancesDtoTest[0].academicYearId, studentAttendance1.academicYear.id);
        assertEquals( studentAttendancesDtoTest[0].sumOfPeriods, studentAttendance1.sumOfPeriods)
        assertEquals( studentAttendancesDtoTest[0].sumOfAbsences, studentAttendance1.sumOfAbsences)
        assertEquals( studentAttendancesDtoTest[0].sumOfAdjAbs, studentAttendance1.sumOfAdjAbs)
        assertEquals( studentAttendancesDtoTest[0].sumOfLates, studentAttendance1.sumOfLates)
        assertEquals( studentAttendancesDtoTest[1].studentId, studentAttendance2.student.id );
        assertEquals( studentAttendancesDtoTest[1].courseId, studentAttendance2.course.id);
        assertEquals( studentAttendancesDtoTest[1].academicYearId, studentAttendance2.academicYear.id);
        assertEquals( studentAttendancesDtoTest[1].sumOfPeriods, studentAttendance2.sumOfPeriods)
        assertEquals( studentAttendancesDtoTest[1].sumOfAbsences, studentAttendance2.sumOfAbsences)
        assertEquals( studentAttendancesDtoTest[1].sumOfAdjAbs, studentAttendance2.sumOfAdjAbs)
        assertEquals( studentAttendancesDtoTest[1].sumOfLates, studentAttendance2.sumOfLates)
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentAttendanceDto studentAttendanceDto1 = new StudentAttendanceDto(studentAttendance1)
        StudentAttendanceDto studentAttendanceDto2 = new StudentAttendanceDto(studentAttendance1)
        assertEquals(studentAttendanceDto1, studentAttendanceDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentAttendanceDto studentAttendanceDto1 = new StudentAttendanceDto(studentAttendance1)
        StudentAttendanceDto studentAttendanceDto2 = new StudentAttendanceDto(studentAttendance1)
        assertEquals(studentAttendanceDto1.hashCode(), studentAttendanceDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentAttendance() {
        StudentAttendanceDto studentAttendanceTest = new StudentAttendanceDto(studentAttendance1)
        assertEquals( studentAttendanceTest.studentId, studentAttendance1.student.id);
        assertEquals( studentAttendanceTest.courseId, studentAttendance1.course.id);
        assertEquals( studentAttendanceTest.academicYearId, studentAttendance1.academicYear.id);
        assertEquals( studentAttendanceTest.sumOfPeriods, studentAttendance1.sumOfPeriods)
        assertEquals( studentAttendanceTest.sumOfAbsences, studentAttendance1.sumOfAbsences)
        assertEquals( studentAttendanceTest.sumOfAdjAbs, studentAttendance1.sumOfAdjAbs)
        assertEquals( studentAttendanceTest.sumOfLates, studentAttendance1.sumOfLates)
    }
}
