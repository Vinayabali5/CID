package uk.ac.reigate.domain.learning_support;

import static org.junit.Assert.*

import java.util.Date;

import javax.persistence.OneToOne;

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.CourseGroup;
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Subject


public class StudentConcessionTypeTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    ConcessionType createConcessionType() {
        ConcessionType concessionType = new ConcessionType()
    }
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        
        Student student = createStudent()
        ConcessionType concessionType = createConcessionType()
        Integer extraTimePercentage = 2
        
        StudentConcessionType studentConcessionType = new StudentConcessionType(student, concessionType, extraTimePercentage)
        
        assertNotNull(studentConcessionType)
        assertEquals(studentConcessionType.student.id, student.id)
        assertEquals(studentConcessionType.extraTimePercentage, extraTimePercentage)
        assertEquals(studentConcessionType.concessionType.id, concessionType.id)
    }
    
    @Test
    void testMethod_ToString() {
        StudentConcessionType studentConcessionTypee = new StudentConcessionType()
        assertEquals(studentConcessionTypee.student, studentConcessionTypee.toString())
    }
}
