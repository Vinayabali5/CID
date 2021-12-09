package uk.ac.reigate.domain.admissions;

import static org.junit.Assert.*

import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.academic.Student

public class InterviewTest {
    
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
    
    
    @Test
    void testMethod_Student() {
        Student student = createStudent()
        
        Interview interview = new Interview(student)
        interview.student = student
        assertNotNull(interview)
        assertEquals(interview.student.id, student.id)
    }
}
