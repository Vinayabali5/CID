package uk.ac.reigate.domain.admissions;

import org.junit.Test

import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*

public class CollegeFundPaymentTest {
    
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
    void testMethod_ToString() {
        CollegeFundPayment collegeFundPayment = new CollegeFundPayment()
        collegeFundPayment.payee = 'TEST'
        
        assertEquals(collegeFundPayment.payee, collegeFundPayment.toString())
    }
    
    @Test
    void testMethod_getStudentId() {
        Student student = createStudent()
        CollegeFundPayment collegeFundPayment = new CollegeFundPayment()
        collegeFundPayment.student = student
        
        assertEquals(collegeFundPayment.getStudentId(), student.id)
    }
}
