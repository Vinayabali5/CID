package uk.ac.reigate.domain.academic;

import org.junit.Test

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.Subject

import static org.junit.Assert.*


public class CourseTest {
    
    Level createLevel() {
        Level level = new Level()
    }
    
    Subject createSubject() {
        Subject subject = new Subject()
    }
    
    ExamBoard createExamBoard() {
        ExamBoard examBoard = new ExamBoard()
    }
    
    AcademicYear createValidFrom() {
        AcademicYear validFrom = new AcademicYear()
    }
    
    AcademicYear createValidTo() {
        AcademicYear validTo = new AcademicYear()
    }
    
    @Test
    void testMethod_ToString() {
        Course course = new Course()
        course.spec = 'TEST'
        
        assertEquals(course.spec, course.toString())
    }
}
