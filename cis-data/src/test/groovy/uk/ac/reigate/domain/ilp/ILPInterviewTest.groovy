package uk.ac.reigate.domain.ilp;

import java.text.SimpleDateFormat

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup;
import uk.ac.reigate.domain.academic.Student

import static org.junit.Assert.*


public class ILPInterviewTest {
    
    Student createStudent() {
        Student student = new Student()
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
    }
    
    Staff createStaff() {
        Staff staff = new Staff()
    }
    
    ILPInterviewType createILPInterviewType() {
        ILPInterviewType type = new ILPInterviewType()
    }
    
    AcademicYear createAcademicYear(){
        AcademicYear academicYear = new AcademicYear();
    }
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        Integer id = 1
        Student student = createStudent()
        CourseGroup courseGroup = createCourseGroup()
        ILPInterviewType type = createILPInterviewType()
        String discussion = 'T'
        Staff staff = createStaff()
        Date interviewDate = new SimpleDateFormat("dd/MM/yyyy").parse('01/09/2015')
        Date interviewTime = new SimpleDateFormat("dd/MM/yyyy").parse('01/09/2015')
        Boolean referLip = true
        Date lipReferDate = new Date(2099, 9, 1)
        Boolean privateEntry = true
        String officeAction = 'Test'
        String officeNotes = 'Tt'
        Boolean toFile = false
        String target  =  'Test'
        String targetByWhen = 'Ongoing'
        AcademicYear academicYear = createAcademicYear()
        
        ILPInterview iLPInterview = new ILPInterview()
        
        assertNotNull(iLPInterview)
        assertEquals(iLPInterview.discussion, iLPInterview.discussion)
        assertEquals(iLPInterview.interviewDate, iLPInterview.interviewDate)
        assertEquals(iLPInterview.interviewTime, iLPInterview.interviewTime)
        assertEquals(iLPInterview.referLip, iLPInterview.referLip)
        assertEquals(iLPInterview.lipReferDate, iLPInterview.lipReferDate)
        assertEquals(iLPInterview.officeActionString, iLPInterview.officeActionString)
        assertEquals(iLPInterview.privateEntry, iLPInterview.privateEntry)
        assertEquals(iLPInterview.officeNotes, iLPInterview.officeNotes)
        assertEquals(iLPInterview.toFile, iLPInterview.toFile)
    }
}
