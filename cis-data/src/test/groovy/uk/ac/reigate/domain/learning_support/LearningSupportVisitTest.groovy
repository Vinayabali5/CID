package uk.ac.reigate.domain.learning_support;

import org.junit.Test

import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*


public class LearningSupportVisitTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    @Test
    void testMethod_ToString() {
        LearningSupportVisit learningSupportVisite = new LearningSupportVisit()
        assertEquals(learningSupportVisite.student, learningSupportVisite.toString())
    }
}
