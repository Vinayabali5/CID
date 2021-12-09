package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.SchoolReportStatus

public class StudentAdmissionDtoTest {
    
    private Student student1
    
    private Student student2
    
    private Student student3
    
    private List<Student> students
    
    @Before
    public void setup() {
        student1 = new Student(
                id: 1,
                admissionsNotes: 'test',
                refRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                refReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewer: new Staff(id:1, knownAs: 'Vinaya'),
                received: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                reportReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                reportRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                schoolReportStatus : new SchoolReportStatus(id:1, description: 'Test'),
                blueCard: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                learningSupportOnIntro: true,
                cannotAttendIntro: true,
                cannotAttendInduction: true,
                inductionDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                enrolmentInterviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                enrolmentInterviewTime: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                acceptanceReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                ehcp: false,
                lookedAfterChildOrAdopted: true,
                childrenServicesInvolvedAtSchool: true,
                otherSocialSupportIssues: false,
                restrictedUseIndicator: new RestrictedUseIndicator(id:1, description: 'Test' ),
                contactByPost: false,
                contactByEmail: true,
                lrsOptOut: false,
                collegeFundPaid: new CollegeFundPaid(id:1),
                collegeFundPaidYears: 1,
                ethnicity: new Ethnicity(id:1, shortDescription: 'Indian'),
                possibleAspire: true,
                schoolReportNotSeen: false,
                freeMealsWhileAtSchool: false,
                parentsUniversityEducated: true,
                status: new ApplicationStatus(id:1, description: 'Test'),
                offerType : new OfferType(id:1, description: 'Test')
                
                );
        student2 = new Student(
                id: 2,
                admissionsNotes: 'test',
                refRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                refReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewer: new Staff(id:1),
                received: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                reportReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                reportRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                schoolReportStatus : new SchoolReportStatus(id:1),
                blueCard: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                learningSupportOnIntro: true,
                cannotAttendIntro: true,
                cannotAttendInduction: true,
                inductionDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                enrolmentInterviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                enrolmentInterviewTime: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                acceptanceReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                ehcp: false,
                lookedAfterChildOrAdopted: true,
                childrenServicesInvolvedAtSchool: true,
                otherSocialSupportIssues: false,
                restrictedUseIndicator: new RestrictedUseIndicator(id:1 ),
                contactByPost: false,
                contactByEmail: true,
                lrsOptOut: false,
                collegeFundPaid: new CollegeFundPaid(id:1),
                collegeFundPaidYears: 1,
                ethnicity: new Ethnicity(id:1),
                possibleAspire: true,
                schoolReportNotSeen: false,
                freeMealsWhileAtSchool: false,
                parentsUniversityEducated: true,
                status: new ApplicationStatus(id:1),
                offerType : new OfferType(id:1)
                );
        student3 = new Student(
                id: 2,
                admissionsNotes: 'test',
                refRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                refReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewer: null,
                received: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                reportReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                reportRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                schoolReportStatus : null,
                blueCard: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                learningSupportOnIntro: true,
                cannotAttendIntro: true,
                cannotAttendInduction: true,
                inductionDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                enrolmentInterviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                enrolmentInterviewTime: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                acceptanceReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                ehcp: false,
                lookedAfterChildOrAdopted: true,
                childrenServicesInvolvedAtSchool: true,
                otherSocialSupportIssues: false,
                restrictedUseIndicator: null,
                contactByPost: false,
                contactByEmail: true,
                lrsOptOut: false,
                collegeFundPaid: null,
                collegeFundPaidYears: 1,
                ethnicity: null,
                possibleAspire: true,
                schoolReportNotSeen: false,
                freeMealsWhileAtSchool: false,
                parentsUniversityEducated: true,
                status: null,
                offerType : null
                );
        students = Arrays.asList(student1, student2);
    }
    
    @Test
    public void testConstructor_NullObject(){
        StudentAdmissionDto studentTest = new StudentAdmissionDto( student3 )
        assertEquals( studentTest.id, student3.id );
        assertEquals( studentTest.statusId, student3.status );
        assertEquals( studentTest.ethnicityId, student3.ethnicity );
    }
    
    @Test
    public void testMapFromStudentEntity(){
        StudentAdmissionDto studentTest = StudentAdmissionDto.mapFromEntity( student1 )
        assertEquals( studentTest.id, student1.id );
    }
    
    @Test
    public void testMapFromStudentsEntities(){
        List<StudentAdmissionDto> studentAdmissionDtoTest = StudentAdmissionDto.mapFromList( students )
        assertEquals( studentAdmissionDtoTest[0].id, student1.id );
        assertEquals( studentAdmissionDtoTest[1].id, student2.id );
    }
    
    @Test
    public void testEquals_Same() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        StudentAdmissionDto studentAdmissionDto2 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1, studentAdmissionDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        StudentAdmissionDto studentAdmissionDto2 = new StudentAdmissionDto(student2)
        assertNotEquals(studentAdmissionDto1, studentAdmissionDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        StudentAdmissionDto studentAdmissionDto2 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.hashCode(), studentAdmissionDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        StudentAdmissionDto studentAdmissionDto2 = new StudentAdmissionDto(student2)
        assertNotEquals(studentAdmissionDto1.hashCode(), studentAdmissionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Student() {
        StudentAdmissionDto studentAdmissionDto = new StudentAdmissionDto(student1)
    }
    
    @Test
    public void testMethod_Get_NullInterviewerName() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student3)
        assertEquals(studentAdmissionDto1.interviewer, studentAdmissionDto1.get_InterviewerName())
    }
    
    @Test
    public void testMethod_Get_InterviewerName() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.interviewer.knownAs, studentAdmissionDto1.get_InterviewerName())
    }
    
    @Test
    public void testMethod_Get_NullSchoolReportStatusDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student3)
        assertEquals(studentAdmissionDto1.schoolReportStatus, studentAdmissionDto1.get_SchoolReportStatusDescription())
    }
    
    @Test
    public void testMethod_Get_SchoolReportStatusDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.schoolReportStatus.description, studentAdmissionDto1.get_SchoolReportStatusDescription())
    }
    
    @Test
    public void testMethod_Get_NullRestrictedUseIndicatorDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student3)
        assertEquals(studentAdmissionDto1.restrictedUseIndicator, studentAdmissionDto1.get_RestrictedUseIndicatorDescription())
    }
    
    @Test
    public void testMethod_Get_RestrictedUseIndicatorDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.restrictedUseIndicator.description, studentAdmissionDto1.get_RestrictedUseIndicatorDescription())
    }
    
    @Test
    public void testMethod_Get_NullEthnicityShortDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student3)
        assertEquals(studentAdmissionDto1.ethnicity, studentAdmissionDto1.get_EthnicityShortDescription())
    }
    
    @Test
    public void testMethod_Get_EthnicityShortDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.ethnicity.shortDescription, studentAdmissionDto1.get_EthnicityShortDescription())
    }
    
    @Test
    public void testMethod_Get_NullStatusDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student3)
        assertEquals(studentAdmissionDto1.status, studentAdmissionDto1.get_StatusDescription())
    }
    
    @Test
    public void testMethod_Get_StatusDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.status.description, studentAdmissionDto1.get_StatusDescription())
    }
    
    @Test
    public void testMethod_Get_NullOfferTypeDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student3)
        assertEquals(studentAdmissionDto1.offerType, studentAdmissionDto1.get_OfferTypeDescription())
    }
    
    @Test
    public void testMethod_Get_OfferTypeDescription() {
        StudentAdmissionDto studentAdmissionDto1 = new StudentAdmissionDto(student1)
        assertEquals(studentAdmissionDto1.offerType.description, studentAdmissionDto1.get_OfferTypeDescription())
    }
}
