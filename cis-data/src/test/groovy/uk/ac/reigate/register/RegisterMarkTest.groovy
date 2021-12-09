package uk.ac.reigate.register;

import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.register.AttendanceCode;
import uk.ac.reigate.domain.register.Register;
import uk.ac.reigate.domain.register.RegisterMark

import static org.junit.Assert.*


public class RegisterMarkTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    Course createCourse() {
        Course course = new Course()
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
    }
    
    Register createRegister() {
        Register register = new Register()
    }
    
    AttendanceCode createAttendanceCode() {
        AttendanceCode attendanceCode = new AttendanceCode()
    }
    
    @Test
    void testMethod_ToString() {
        RegisterMark registerMark = new RegisterMark()
        Register register = createRegister()
        registerMark.register = register
        
        assertEquals(registerMark.register.id, registerMark.toString())
    }
}
