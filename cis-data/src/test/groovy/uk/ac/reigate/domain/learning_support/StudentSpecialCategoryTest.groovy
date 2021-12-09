package uk.ac.reigate.domain.learning_support;

import java.text.SimpleDateFormat

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.SpecialCategory;
import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*


public class StudentSpecialCategoryTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    SpecialCategory createSpecialCategory() {
        SpecialCategory specialCategory = new SpecialCategory()
    }
    
    Staff createStaffRequesting() {
        Staff staffRequesting = new Staff()
    }
    
    Staff createRiskAssessmentToBeCompletedBy() {
        Staff riskAssessmentToBeCompletedBy  = new Staff()
    }
    
    Staff createStaffConcerned() {
        Staff staffConcerned  = new Staff()
    }
    
    
    Staff createRiskAssessmentRaisedBy() {
        Staff riskAssessmentRaisedBy  = new Staff()
    }
    
    Staff createRiskAssessmentCarriedOutBy() {
        Staff riskAssessmentCarriedOutBy  = new Staff()
    }
    
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        Integer id = 1
        Student student = createStudent()
        Date requestDate = new SimpleDateFormat("yyyy/MM/dd").parse('2015/08/01')
        SpecialCategory specialCategory = createSpecialCategory()
        Boolean specialConfirmed = true
        Date classificationDate = new SimpleDateFormat("yyyy/MM/dd").parse('2015/08/01')
        Date closedDate = new SimpleDateFormat("yyyy/MM/dd").parse('2015/08/01')
        String monitoringNotes = 'Testing'
        Staff staffRequesting = createStaffRequesting()
        Boolean riskAssessmentRequired = true
        Staff riskAssessmentToBeCompletedBy = createRiskAssessmentToBeCompletedBy()
        Boolean informationConfidential = true
        Boolean writtenEvidence = true
        Boolean passToStaffConcerned = true
        Staff staffConcerned = createStaffConcerned()
        String riskToStudentOrOthers = 't'
        String emergencyContactNos = '234324'
        String outsideAgenciesInvolved = '2'
        String toBeInformedPotentialRisks = 'test'
        Staff riskAssessmentRaisedBy = createRiskAssessmentRaisedBy()
        Date riskAssessmentRaisedDate = new SimpleDateFormat("yyyy/MM/dd").parse('2015/08/01')
        Staff riskAssessmentCarriedOutBy = createRiskAssessmentCarriedOutBy()
        Date riskAssessmentCarriedOutDate = new SimpleDateFormat("yyyy/MM/dd").parse('2015/08/01')
        String inEventEmergency = 'testt'
        StudentSpecialCategory studentSpecialCategory = new StudentSpecialCategory()
        
        assertNotNull(studentSpecialCategory)
    }
    
    @Test
    void testMethod_ToString() {
        StudentSpecialCategory studentSpecialCategorye = new StudentSpecialCategory()
        assertEquals(studentSpecialCategorye.student, studentSpecialCategorye.toString())
    }
}
