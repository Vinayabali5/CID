package uk.ac.reigate.domain.cristal;

import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.register.AttendanceCode;;

import static org.junit.Assert.*


public class MasterRegisterTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    AttendanceCode createAttendanceCode() {
        AttendanceCode attendance = new AttendanceCode()
    }
    
    @Test
    void testMethod_ToString() {
        MasterRegister masterRegister = new MasterRegister()
        Student student = createStudent()
        masterRegister.student = student
        assertEquals(masterRegister.student.id, masterRegister.toString())
    }
}
