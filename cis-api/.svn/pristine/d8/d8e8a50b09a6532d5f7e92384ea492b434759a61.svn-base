package uk.ac.reigate.dto;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.GCSEScore
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.domain.ilr.LLDDHealthProblem
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentReferralReason
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.domain.risk_assessment.RiskLevel

import static org.junit.Assert.*

public class StudentDtoTest {
    
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
                restrictedUseIndicator: new RestrictedUseIndicator(id: 1, code: 'test', description: 'Test' ),
                contactByPost: false,
                contactByEmail: true,
                lrsOptOut: false,
                collegeFundPaid: new CollegeFundPaid(id:1),
                collegeFundPaidYears: 1,
                ethnicity: new Ethnicity(id:1, shortDescription: 'In'),
                possibleAspire: true,
                schoolReportNotSeen: false,
                freeMealsWhileAtSchool: false,
                parentsUniversityEducated: true,
                status: new ApplicationStatus(id:1),
                offerType : new OfferType(id:1),
                school : new School(id:1, name: 'Reigate School'),
                llddHealthProblem : new LLDDHealthProblem(id:1),
                gcseScore : new GCSEScore(student: new Student(id: 190001)),
                specialCategory: new SpecialCategory(id:1, code: 'T', description: 'Test', details: 'Testing'),
                riskLevel : new RiskLevel(id:1, code: 'R', description: 'High Risk'),
                readingInitialAssessment : new InitialAssessmentLevel(id:1, initialAssessmentLevel: 'Test'),
                writingInitialAssessment : new InitialAssessmentLevel(id:2),
                spellingInitialAssessment: new InitialAssessmentLevel(id:2),
                destination: new Destination(id:1, description: 'destination test'),
                studentYears : Arrays.asList(
                new StudentYear(student: new Student(id: 190001), year: new AcademicYear(id: 18)),
                new StudentYear(student: new Student(id: 190002), year: new AcademicYear(id: 19))),
                concessions : Arrays.asList(
                new StudentConcessionType(student: new Student(id: 190001)),
                new StudentConcessionType(student: new Student(id: 190003))
                ),
                llddHealthProblemCategory : Arrays.asList(
                new LLDDHealthProblemCategory(id: 1),
                new LLDDHealthProblemCategory(id:2)
                ),
                referralReasons : Arrays.asList(
                new StudentReferralReason(id:1),
                new StudentReferralReason(id:2)
                )
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
                school : new School(id:1),
                llddHealthProblem : new LLDDHealthProblem(id:1),
                gcseScore : new GCSEScore(student: new Student(id: 190001)),
                specialCategory: new SpecialCategory(id:1),
                riskLevel : new RiskLevel(id:1),
                readingInitialAssessment : new InitialAssessmentLevel(id:1),
                writingInitialAssessment : new InitialAssessmentLevel(id:2),
                spellingInitialAssessment: new InitialAssessmentLevel(id:2),
                destination: new Destination(id:1),
                concessions : Arrays.asList(
                new StudentConcessionType(student: new Student(id: 190001)),
                new StudentConcessionType(student: new Student(id: 190003))
                ),
                
                llddHealthProblemCategory : Arrays.asList(
                new LLDDHealthProblemCategory(id: 1),
                new LLDDHealthProblemCategory(id:2)
                ),
                referralReasons : Arrays.asList(
                new StudentReferralReason(id:1),
                new StudentReferralReason(id:2)
                ),
                )
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
                restrictedUseIndicator: null,
                contactByPost: false,
                contactByEmail: true,
                lrsOptOut: false,
                collegeFundPaid: new CollegeFundPaid(id:1),
                collegeFundPaidYears: 1,
                ethnicity: null,
                possibleAspire: true,
                schoolReportNotSeen: false,
                freeMealsWhileAtSchool: false,
                parentsUniversityEducated: true,
                status: new ApplicationStatus(id:1),
                offerType : new OfferType(id:1),
                school : null,
                llddHealthProblem : null,
                gcseScore : null,
                specialCategory: null,
                riskLevel : null,
                readingInitialAssessment : null,
                writingInitialAssessment : null,
                spellingInitialAssessment: null,
                destination: null
                );
        students = Arrays.asList(student1, student2);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        StudentDto studentDto = StudentDto.mapFromEntity( student1 )
        assertEquals( studentDto.id, student1.id );
        assertEquals( studentDto.referenceNo, student1.referenceNo);
        assertEquals( studentDto.specialConfirmed, student1.specialConfirmed);
        assertEquals( studentDto.uln, student1.uln);
        assertEquals( studentDto.uci, student1.uci);
        assertEquals( studentDto.specialConfirmed, student1.specialConfirmed);
        assertEquals( studentDto.ethnicityId, student1.ethnicity.id);
        assertEquals( studentDto.llddHealthProblemId, student1.llddHealthProblem.id)
        assertEquals( studentDto.specialCategoryId, student1.specialCategory.id);
        assertEquals( studentDto.riskLevelId, student1.riskLevel.id);
        assertEquals( studentDto.readingInitialAssessmentId, student1.readingInitialAssessment.id);
        assertEquals( studentDto.writingInitialAssessmentId, student1.writingInitialAssessment.id);
        assertEquals( studentDto.spellingInitialAssessmentId, student1.spellingInitialAssessment.id);
        assertEquals( studentDto.medicalNote, student1.medicalNote);
        assertEquals( studentDto.studentEmail, student1.studentEmail);
    }
    
    @Test
    public void testMapFromStudentsEntities(){
        List<StudentDto> studentDto = StudentDto.mapFromList( students )
        assertEquals( studentDto[0].id, student1.id );
        assertEquals( studentDto[0].referenceNo, student1.referenceNo);
        assertEquals( studentDto[0].specialConfirmed, student1.specialConfirmed);
        assertEquals( studentDto[0].uln, student1.uln);
        assertEquals( studentDto[0].uci, student1.uci);
        assertEquals( studentDto[0].specialConfirmed, student1.specialConfirmed);
        assertEquals( studentDto[0].ethnicityId, student1.ethnicity.id);
        assertEquals( studentDto[0].llddHealthProblemId, student1.llddHealthProblem.id)
        assertEquals( studentDto[0].specialCategoryId, student1.specialCategory.id);
        assertEquals( studentDto[0].riskLevelId, student1.riskLevel.id);
        assertEquals( studentDto[0].readingInitialAssessmentId, student1.readingInitialAssessment.id);
        assertEquals( studentDto[0].writingInitialAssessmentId, student1.writingInitialAssessment.id);
        assertEquals( studentDto[0].spellingInitialAssessmentId, student1.spellingInitialAssessment.id);
        assertEquals( studentDto[0].medicalNote, student1.medicalNote);
        assertEquals( studentDto[0].studentEmail, student1.studentEmail);
        assertEquals( studentDto[1].id, student2.id );
        assertEquals( studentDto[1].referenceNo, student2.referenceNo);
        assertEquals( studentDto[1].specialConfirmed, student2.specialConfirmed);
        assertEquals( studentDto[1].uln, student2.uln);
        assertEquals( studentDto[1].uci, student2.uci);
        assertEquals( studentDto[1].specialConfirmed, student2.specialConfirmed);
        assertEquals( studentDto[1].ethnicityId, student2.ethnicity.id);
        assertEquals( studentDto[1].llddHealthProblemId, student2.llddHealthProblem.id)
        assertEquals( studentDto[1].specialCategoryId, student2.specialCategory.id);
        assertEquals( studentDto[1].riskLevelId, student2.riskLevel.id);
        assertEquals( studentDto[1].readingInitialAssessmentId, student2.readingInitialAssessment.id);
        assertEquals( studentDto[1].writingInitialAssessmentId, student2.writingInitialAssessment.id);
        assertEquals( studentDto[1].spellingInitialAssessmentId, student2.spellingInitialAssessment.id);
        assertEquals( studentDto[1].medicalNote, student2.medicalNote);
        assertEquals( studentDto[1].studentEmail, student2.studentEmail);
    }
    
    @Test
    public void testEquals_Same() {
        StudentDto studentDto1 = new StudentDto(student1)
        StudentDto studentDto2 = new StudentDto(student1)
        assertEquals(studentDto1, studentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentDto studentDto1 = new StudentDto(student1)
        StudentDto studentDto2 = new StudentDto(student2)
        assertNotEquals(studentDto1, studentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentDto studentDto1 = new StudentDto(student1)
        StudentDto studentDto2 = new StudentDto(student1)
        assertEquals(studentDto1.hashCode(), studentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentDto studentDto1 = new StudentDto(student1)
        StudentDto studentDto2 = new StudentDto(student2)
        assertNotEquals(studentDto1.hashCode(), studentDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Student() {
        StudentDto studentDto = new StudentDto(student1)
        assertEquals( studentDto.id, student1.id);
        assertEquals( studentDto.referenceNo, student1.referenceNo);
        assertEquals( studentDto.specialConfirmed, student1.specialConfirmed);
        assertEquals( studentDto.uln, student1.uln);
        assertEquals( studentDto.uci, student1.uci);
        assertEquals( studentDto.specialConfirmed, student1.specialConfirmed);
        assertEquals( studentDto.ethnicityId, student1.ethnicity.id);
        assertEquals( studentDto.llddHealthProblemId, student1.llddHealthProblem.id)
        assertEquals( studentDto.specialCategoryId, student1.specialCategory.id);
        assertEquals( studentDto.riskLevelId, student1.riskLevel.id);
        assertEquals( studentDto.readingInitialAssessmentId, student1.readingInitialAssessment.id);
        assertEquals( studentDto.writingInitialAssessmentId, student1.writingInitialAssessment.id);
        assertEquals( studentDto.spellingInitialAssessmentId, student1.spellingInitialAssessment.id);
        assertEquals( studentDto.medicalNote, student1.medicalNote);
        assertEquals( studentDto.studentEmail, student1.studentEmail);
    }
    
    @Test
    public void testConstructor_NullObject() {
        StudentDto studentDto = new StudentDto(student3)
        assertEquals( studentDto.id, student3.id);
        assertEquals( studentDto.referenceNo, student3.referenceNo);
        assertEquals( studentDto.specialConfirmed, student3.specialConfirmed);
        assertEquals( studentDto.uln, student3.uln);
        assertEquals( studentDto.uci, student3.uci);
        assertEquals( studentDto.specialConfirmed, student3.specialConfirmed);
        assertEquals( studentDto.ethnicityId, student3.ethnicity);
        assertEquals( studentDto.llddHealthProblemId, student3.llddHealthProblem)
        assertEquals( studentDto.specialCategoryId, student3.specialCategory);
        assertEquals( studentDto.riskLevelId, student3.riskLevel);
        assertEquals( studentDto.readingInitialAssessmentId, student3.readingInitialAssessment);
        assertEquals( studentDto.writingInitialAssessmentId, student3.writingInitialAssessment);
        assertEquals( studentDto.spellingInitialAssessmentId, student3.spellingInitialAssessment);
        assertEquals( studentDto.medicalNote, student3.medicalNote);
        assertEquals( studentDto.studentEmail, student3.studentEmail);
    }
    
    @Test
    public void testMethod_StudentDto() {
        StudentDto studentDto1 = new StudentDto(student1, true)
        assertEquals( studentDto1.id, student1.id);
        assertEquals( studentDto1._similarNamedStudent, true);
    }
    
    @Test
    public void testMethod_Get_NullPreviousSchoolName() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.previousSchool, studentDto1.get_PreviousSchoolName())
    }
    
    @Test
    public void testMethod_Get_PreviousSchoolName() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.previousSchool.name, studentDto1.get_PreviousSchoolName())
    }
    
    @Test
    public void testMethod_Get_NullEthnicityDescription() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.ethnicity, studentDto1.get_EthnicityDescription())
    }
    
    @Test
    public void testMethod_Get_EthnicityDescription() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.ethnicity.shortDescription, studentDto1.get_EthnicityDescription())
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryCode() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.specialCategory, studentDto1.get_SpecialCategoryCode())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryCode() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.specialCategory.code, studentDto1.get_SpecialCategoryCode())
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryDescription() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.specialCategory, studentDto1.get_SpecialCategoryDescription())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryDescription() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.specialCategory.description, studentDto1.get_SpecialCategoryDescription())
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryDetails() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.specialCategory, studentDto1.get_SpecialCategoryDetails())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryDetails() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.specialCategory.details, studentDto1.get_SpecialCategoryDetails())
    }
    
    @Test
    public void testMethod_Get_NullRiskLevelCode() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.riskLevel, studentDto1.get_RiskLevelCode())
    }
    
    @Test
    public void testMethod_Get_RiskLevelCode() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.riskLevel.code, studentDto1.get_RiskLevelCode())
    }
    
    @Test
    public void testMethod_Get_NullRiskLevelDescription() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.riskLevel, studentDto1.get_RiskLevelDescription())
    }
    
    @Test
    public void testMethod_Get_RiskLevelDescription() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.riskLevel.description, studentDto1.get_RiskLevelDescription())
    }
    
    @Test
    public void testMethod_Get_NullReadingInitialAssessmentDescirption() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.readingInitialAssessment, studentDto1.get_ReadingInitialAssessmentDescirption())
    }
    
    @Test
    public void testMethod_Get_ReadingInitialAssessmentDescirption() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.readingInitialAssessment.initialAssessmentLevel, studentDto1.get_ReadingInitialAssessmentDescirption())
    }
    
    @Test
    public void testMethod_Get_NullRestrictedUseIndicatorCode() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.restrictedUseIndicator, studentDto1.get_RestrictedUseIndicatorCode())
    }
    
    @Test
    public void testMethod_Get_RestrictedUseIndicatorCode() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.restrictedUseIndicator.code, studentDto1.get_RestrictedUseIndicatorCode())
    }
    
    @Test
    public void testMethod_Get_NullRestrictedUseIndicatorDescription() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.restrictedUseIndicator, studentDto1.get_RestrictedUseIndicatorDescription())
    }
    
    @Test
    public void testMethod_Get_RestrictedUseIndicatorDescription() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.restrictedUseIndicator.description, studentDto1.get_RestrictedUseIndicatorDescription())
    }
    
    @Test
    public void testMethod_Get_NullDestinationDescription() {
        StudentDto studentDto1 = new StudentDto(student3)
        assertEquals(studentDto1.destination, studentDto1.get_DestinationDescription())
    }
    
    @Test
    public void testMethod_Get_DestinationDescription() {
        StudentDto studentDto1 = new StudentDto(student1)
        assertEquals(studentDto1.destination.description, studentDto1.get_DestinationDescription())
    }
}
