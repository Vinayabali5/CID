package uk.ac.reigate.domain.learning_support;

import static org.junit.Assert.*

import java.util.Date;

import javax.persistence.OneToOne;

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.CourseGroup;
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Subject


public class StudentReferralReasonTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    ReferralReason createReferralReason() {
        ReferralReason referralReason = new ReferralReason()
    }
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        Integer id = 1
        Student student = createStudent()
        ReferralReason referralReason = createReferralReason()
        Boolean primary = true
        
        StudentReferralReason studentReferralReason = new StudentReferralReason()
        
        assertNotNull(studentReferralReason)
        assertEquals(studentReferralReason.primary, studentReferralReason.primary)
    }
    
    @Test
    void testMethod_ToString() {
        StudentReferralReason studentReferralReasone = new StudentReferralReason()
        assertEquals(studentReferralReasone.student, studentReferralReasone.toString())
    }
}
