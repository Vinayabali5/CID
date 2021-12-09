package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.domain.risk_assessment.RiskLevel

public class StudentSummaryDtoTest {
    
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
                offerType : new OfferType(id:1),
                person : new Person(id:1),
                school : new School(id:1, name: 'Reigate college'),
                specialCategory : new SpecialCategory(id:1, description: 'test', details: 'Testing'),
                riskLevel : new RiskLevel(id: 1)
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
                offerType : new OfferType(id:1),
                person : new Person(id:1),
                school : new School(id:1),
                specialCategory : new SpecialCategory(id:1)
                );
        student3 = new Student(
                id: 3,
                admissionsNotes: 'test',
                refRequested: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                refReceived: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                person : null,
                school : null,
                riskLevel : null,
                specialCategory : null
                );
        students = Arrays.asList(student1, student2);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        StudentSummaryDto studentTest = StudentSummaryDto.mapFromEntity( student1 )
        assertEquals( studentTest.id, student1.id );
    }
    
    @Test
    public void testMapFromStudentsEntities(){
        List<StudentSummaryDto> studentSummaryDtoTest = StudentSummaryDto.mapFromList( students )
        assertEquals( studentSummaryDtoTest[0].id, student1.id );
        assertEquals( studentSummaryDtoTest[1].id, student2.id );
    }
    
    @Test
    public void testEquals_Same() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        StudentSummaryDto studentSummaryDto2 = new StudentSummaryDto(student1)
        assertEquals(studentSummaryDto1, studentSummaryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        StudentSummaryDto studentSummaryDto2 = new StudentSummaryDto(student2)
        assertNotEquals(studentSummaryDto1, studentSummaryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        StudentSummaryDto studentSummaryDto2 = new StudentSummaryDto(student1)
        assertEquals(studentSummaryDto1.hashCode(), studentSummaryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        StudentSummaryDto studentSummaryDto2 = new StudentSummaryDto(student2)
        assertNotEquals(studentSummaryDto1.hashCode(), studentSummaryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Student() {
        StudentSummaryDto studentTest = new StudentSummaryDto(student1)
        assertEquals( studentTest.id, student1.id );
        assertEquals( studentTest.previousSchoolId, student1.school.id );
        assertEquals( studentTest.specialCategoryId, student1.specialCategory.id );
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentSummaryDto studentTest = new StudentSummaryDto(student3)
        assertEquals( studentTest.id, student3.id );
        assertEquals( studentTest.person, student3.person );
        assertEquals( studentTest.previousSchoolId, student3.school );
        assertEquals( studentTest.specialCategoryId, student3.specialCategory );
    }
    
    @Test
    public void testMethod_Get_NullPreviousSchoolName() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student3)
        assertEquals(studentSummaryDto1.school, studentSummaryDto1.get_PreviousSchoolName())
    }
    
    @Test
    public void testMethod_Get_PreviousSchoolName() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        assertEquals(studentSummaryDto1.school.name, studentSummaryDto1.get_PreviousSchoolName())
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryCode() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student3)
        assertEquals(studentSummaryDto1.specialCategory, studentSummaryDto1.get_SpecialCategoryCode())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryCode() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        assertEquals(studentSummaryDto1.specialCategory.code, studentSummaryDto1.get_SpecialCategoryCode())
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryDetails() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student3)
        assertEquals(studentSummaryDto1.specialCategory, studentSummaryDto1.get_SpecialCategoryDetails())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryDetails() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        assertEquals(studentSummaryDto1.specialCategory.details , studentSummaryDto1.get_SpecialCategoryDetails())
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryDescription() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student3)
        assertEquals(studentSummaryDto1.specialCategory, studentSummaryDto1.get_SpecialCategoryDescription())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryDescription() {
        StudentSummaryDto studentSummaryDto1 = new StudentSummaryDto(student1)
        assertEquals(studentSummaryDto1.specialCategory.description, studentSummaryDto1.get_SpecialCategoryDescription())
    }
}
