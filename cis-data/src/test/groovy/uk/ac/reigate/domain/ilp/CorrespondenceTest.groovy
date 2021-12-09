package uk.ac.reigate.domain.ilp;

import org.junit.Test

import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*


public class CorrespondenceTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    @Test
    void testMethod_ToString() {
        Correspondence correspondence = new Correspondence()
        Student student = createStudent()
        correspondence.student = student
        
        assertEquals(correspondence.student.id, correspondence.toString())
    }
}
