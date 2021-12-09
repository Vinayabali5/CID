package uk.ac.reigate.domain.admissions;

import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*

public class RequestTest {
    
    /**
     * Helper function to create a dummy student
     * 
     * @return a dummy student
     */
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    /**
     * Helper function to create a dummy academic year
     *
     * @return a dummy academic year
     */
    AcademicYear createAcademicYear() {
        AcademicYear year = new AcademicYear()
    }
    
    @Test
    void testMethod_ToString() {
        Request request = new Request()
        request.request = 'TEST'
        
        assertEquals(request.request, request.toString())
    }
    
    @Test
    void testMethod_getApplicationId() {
        Student student = createStudent()
        Request request = new Request()
        request.student = student
        
        assertEquals(request.getApplicationId(), student.id)
    }
}
