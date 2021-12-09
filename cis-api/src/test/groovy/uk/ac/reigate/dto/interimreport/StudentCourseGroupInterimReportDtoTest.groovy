package uk.ac.reigate.dto.interimreport;

import org.junit.Test

import static org.junit.Assert.*
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.domain.interimreport.StudentInterimReport

public class StudentCourseGroupInterimReportDtoTest {
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Enrolment createEnrolment() {
        Enrolment enrolment = new Enrolment()
        enrolment.id = 1
        enrolment.student = new Student(id: 19001)
        return enrolment
    }
    
    @Test
    public void test_Constructor_Student()  {
        Student student = new Student(id:190001)
        CourseGroup courseGroup  = new CourseGroup (id:1)
        StudentInterimReport studentInterimReport = new StudentInterimReport(id: 1)
        StudentInterimReport studentPreviousInterimReport = new StudentInterimReport(id:1)
        StudentCourseGroupAttendance attendance = null
        StudentCourseGroupInterimReportDto studentCourseGroupInterimReportDto1 = new StudentCourseGroupInterimReportDto(student, courseGroup , studentInterimReport, studentPreviousInterimReport, attendance)
        StudentCourseGroupInterimReportDto studentCourseGroupInterimReportDto2 = new StudentCourseGroupInterimReportDto(student, courseGroup , studentInterimReport, studentPreviousInterimReport, attendance)
        assertNotEquals(studentCourseGroupInterimReportDto1, studentCourseGroupInterimReportDto2)
    }
    
    @Test
    public void test_Constructor_Enrolment()  {
        Enrolment enrolment = createEnrolment()
        CourseGroup courseGroup  = new CourseGroup (id:1)
        StudentInterimReport studentInterimReport = new StudentInterimReport(id: 1)
        StudentInterimReport studentPreviousInterimReport = new StudentInterimReport(id:1)
        StudentCourseGroupAttendance attendance = null
        StudentCourseGroupInterimReportDto studentCourseGroupInterimReportDto1 = new StudentCourseGroupInterimReportDto(enrolment, studentInterimReport, studentPreviousInterimReport, attendance)
        StudentCourseGroupInterimReportDto studentCourseGroupInterimReportDto2 = new StudentCourseGroupInterimReportDto(enrolment, studentInterimReport, studentPreviousInterimReport, attendance)
        assertNotEquals(studentCourseGroupInterimReportDto1, studentCourseGroupInterimReportDto2)
    }
}
