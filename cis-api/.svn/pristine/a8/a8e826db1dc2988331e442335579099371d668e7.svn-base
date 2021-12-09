package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilr.AimType
import uk.ac.reigate.domain.ilr.CompletionStatus
import uk.ac.reigate.domain.ilr.FundingModel
import uk.ac.reigate.domain.ilr.Outcome
import uk.ac.reigate.domain.ilr.SourceOfFunding
import uk.ac.reigate.domain.ilr.WithdrawalReason
import uk.ac.reigate.domain.lookup.CentralMonitoring
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGrade
import uk.ac.reigate.domain.lookup.Subject


public class EnrolmentSummaryDtoTest {
    
    private Enrolment enrolment1
    
    private Enrolment enrolment2
    
    private Enrolment enrolment3
    
    private List<Enrolment> enrolments
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    AcademicYear createAcademicYear() {
        AcademicYear year = new AcademicYear()
        year.id = 1
        year.code = '18/19'
        year.description = '2018/2019'
        return year
    }
    
    Course createCourse() {
        Course course = new Course()
        course.id = 1
        course.spec = 'MHA'
        course.subject = new Subject(id:1, description: 'Maths')
        course.level = new Level(id: 1, description: 'A Level')
        return course
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
        courseGroup.id = 1
        courseGroup.spec = 'L-BIA'
        return courseGroup
    }
    
    AimType createAimType() {
        AimType aimType = new AimType()
        aimType.id = 1
        return aimType
    }
    
    CompletionStatus createCompletionStatus() {
        CompletionStatus completionStatus = new CompletionStatus()
        completionStatus.id = 1
        return completionStatus
    }
    
    Outcome createOutcome() {
        Outcome outcome = new Outcome()
        outcome.id = 1
        return outcome
    }
    
    WithdrawalReason createWithdrawalReason() {
        WithdrawalReason withdrawalReason = new WithdrawalReason()
        withdrawalReason.id = 1
        return withdrawalReason
    }
    
    CentralMonitoring createCentralMonitoring() {
        CentralMonitoring centralMonitoring = new CentralMonitoring()
        centralMonitoring.id = 1
        return centralMonitoring
    }
    
    FundingModel createFundingModel() {
        FundingModel fundingModel = new FundingModel()
        fundingModel.id = 1
        fundingModel.code = 'TS'
        fundingModel.description ='Test'
        return fundingModel
    }
    
    SourceOfFunding createSourceOfFunding() {
        SourceOfFunding sourceOfFunding = new SourceOfFunding()
        sourceOfFunding.id = 1
        sourceOfFunding.code = 'TT'
        sourceOfFunding.description = 'Test'
        return sourceOfFunding
    }
    
    @Before
    public void setup() {
        enrolment1 = new Enrolment(
                id: 1,
                student: createStudent(),
                year : createAcademicYear(),
                course: createCourse(),
                courseGroup: createCourseGroup(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                qualificationStartDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                plannedEndDate:new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                aimType : createAimType(),
                completionStatus : createCompletionStatus(),
                withdrawalReason : createWithdrawalReason(),
                outcome : createOutcome(),
                grade : 'NULL',
                ilr : true,
                centralMonitoring : createCentralMonitoring(),
                plh: 300,
                peeph : 60,
                fundingModel : createFundingModel(),
                sourceOfFunding : createSourceOfFunding(),
                reference: new PreReference(student: createStudent(), course: createCourse(), predictedGrade: new PossibleGrade(id: 1, grade:'A') )
                );
        enrolment2 = new Enrolment(
                id: 2,
                student: createStudent(),
                year : createAcademicYear(),
                course: createCourse(),
                courseGroup: createCourseGroup(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                qualificationStartDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                plannedEndDate:new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                aimType : createAimType(),
                completionStatus : createCompletionStatus(),
                withdrawalReason : createWithdrawalReason(),
                outcome : createOutcome(),
                grade : 'A*',
                ilr : true,
                centralMonitoring : createCentralMonitoring(),
                plh: 150,
                peeph : 30,
                fundingModel : createFundingModel(),
                sourceOfFunding : createSourceOfFunding()
                );
        enrolment3 = new Enrolment(
                id: 3,
                student: createStudent(),
                year : null,
                course: null,
                courseGroup: null,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                qualificationStartDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                plannedEndDate:new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                aimType : null,
                completionStatus : null,
                withdrawalReason : null,
                outcome : null,
                grade : 'A*',
                ilr : true,
                centralMonitoring : null,
                plh: 150,
                peeph : 30,
                fundingModel : null,
                sourceOfFunding : null
                );
        enrolments = Arrays.asList(enrolment1, enrolment2);
    }
    
    @Test
    public void testConstructor_NullStudent() {
        EnrolmentSummaryDto enrolment = new EnrolmentSummaryDto(enrolment3)
        assertEquals( enrolment.enrolmentId, enrolment3.id );
        assertEquals( enrolment.studentId, enrolment3.student.id);
        assertEquals( enrolment.courseId, null);
        assertEquals( enrolment.yearId, null);
        assertEquals( enrolment.courseId, null);
        assertEquals( enrolment.courseGroupId, null);
        assertEquals( enrolment.startDate, enrolment3.startDate);
        assertEquals( enrolment.endDate, enrolment3.endDate);
        assertEquals( enrolment.qualificationStartDate, enrolment1.qualificationStartDate);
        assertEquals( enrolment.plannedEndDate, enrolment3.plannedEndDate);
        assertEquals( enrolment.aimTypeId, null);
        assertEquals( enrolment.completionStatusId, null);
        assertEquals( enrolment.withdrawalReasonId, null);
        assertEquals( enrolment.outcomeId, null);
        assertEquals( enrolment.grade, enrolment3.grade);
        assertEquals( enrolment.ilr, enrolment3.ilr);
        assertEquals( enrolment.centralMonitoringId, null);
        assertEquals( enrolment.plh, enrolment3.plh);
        assertEquals( enrolment.peeph, enrolment3.peeph);
        assertEquals( enrolment.fundingModelId, null);
        assertEquals( enrolment.sourceOfFundingId, null);
    }
    
    @Test
    public void testMapFromEnrolmentEntity(){
        EnrolmentSummaryDto enrolmentTest = EnrolmentSummaryDto.mapFromEntity( enrolment1 )
        assertEquals( enrolmentTest.enrolmentId, enrolment1.id );
        assertEquals( enrolmentTest.studentId, enrolment1.student.id);
        assertEquals( enrolmentTest.yearId, enrolment1.year.id);
        assertEquals( enrolmentTest.courseId, enrolment1.course.id);
        assertEquals( enrolmentTest.courseGroupId, enrolment1.courseGroup.id);
        assertEquals( enrolmentTest.startDate, enrolment1.startDate);
        assertEquals( enrolmentTest.endDate, enrolment1.endDate);
        assertEquals( enrolmentTest.qualificationStartDate, enrolment1.qualificationStartDate);
        assertEquals( enrolmentTest.plannedEndDate, enrolment1.plannedEndDate);
        assertEquals( enrolmentTest.aimTypeId, enrolment1.aimType.id);
        assertEquals( enrolmentTest.completionStatusId, enrolment1.completionStatus.id);
        assertEquals( enrolmentTest.withdrawalReasonId, enrolment1.withdrawalReason.id);
        assertEquals( enrolmentTest.outcomeId, enrolment1.outcome.id);
        assertEquals( enrolmentTest.grade, enrolment1.grade);
        assertEquals( enrolmentTest.ilr, enrolment1.ilr);
        assertEquals( enrolmentTest.centralMonitoringId, enrolment1.centralMonitoring.id);
        assertEquals( enrolmentTest.plh, enrolment1.plh);
        assertEquals( enrolmentTest.peeph, enrolment1.peeph);
        assertEquals( enrolmentTest.fundingModelId, enrolment1.fundingModel.id);
        assertEquals( enrolmentTest.sourceOfFundingId, enrolment1.sourceOfFunding.id);
    }
    
    @Test
    public void testMapFromEntity(){
        List<EnrolmentSummaryDto> enrolmentTest = EnrolmentSummaryDto.mapFromList( enrolments )
        assertEquals( enrolmentTest[0].enrolmentId, enrolment1.id );
        assertEquals( enrolmentTest[0].studentId, enrolment1.student.id);
        assertEquals( enrolmentTest[0].yearId, enrolment1.year.id);
        assertEquals( enrolmentTest[0].courseId, enrolment1.course.id);
        assertEquals( enrolmentTest[0].courseGroupId, enrolment1.courseGroup.id);
        assertEquals( enrolmentTest[0].startDate, enrolment1.startDate);
        assertEquals( enrolmentTest[0].endDate, enrolment1.endDate);
        assertEquals( enrolmentTest[0].qualificationStartDate, enrolment1.qualificationStartDate);
        assertEquals( enrolmentTest[0].plannedEndDate, enrolment1.plannedEndDate);
        assertEquals( enrolmentTest[0].aimTypeId, enrolment1.aimType.id);
        assertEquals( enrolmentTest[0].completionStatusId, enrolment1.completionStatus.id);
        assertEquals( enrolmentTest[0].withdrawalReasonId, enrolment1.withdrawalReason.id);
        assertEquals( enrolmentTest[0].outcomeId, enrolment1.outcome.id);
        assertEquals( enrolmentTest[0].grade, enrolment1.grade);
        assertEquals( enrolmentTest[0].ilr, enrolment1.ilr);
        assertEquals( enrolmentTest[0].centralMonitoringId, enrolment1.centralMonitoring.id);
        assertEquals( enrolmentTest[0].plh, enrolment1.plh);
        assertEquals( enrolmentTest[0].peeph, enrolment1.peeph);
        assertEquals( enrolmentTest[0].fundingModelId, enrolment1.fundingModel.id);
        assertEquals( enrolmentTest[0].sourceOfFundingId, enrolment1.sourceOfFunding.id);
    }
    
    @Test
    public void testEquals_Same() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        EnrolmentSummaryDto enrolmentDto2 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1, enrolmentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        EnrolmentSummaryDto enrolmentDto2 = new EnrolmentSummaryDto(enrolment2)
        assertNotEquals(enrolmentDto1, enrolmentDto2)
    }
    
    @Test
    public void testHashCode_Different() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        EnrolmentSummaryDto enrolmentDto2 = new EnrolmentSummaryDto(enrolment2)
        assertNotEquals(enrolmentDto1.hashCode(), enrolmentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Same() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        EnrolmentSummaryDto enrolmentDto2 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.hashCode(), enrolmentDto2.hashCode())
    }
    
    
    @Test
    public void testConstructor_Enrolment() {
        EnrolmentSummaryDto enrolment = new EnrolmentSummaryDto(enrolment1)
        assertEquals( enrolment.enrolmentId, enrolment1.id );
        assertEquals( enrolment.studentId, enrolment1.student.id);
        assertEquals( enrolment.courseId, enrolment1.course.id);
        assertEquals( enrolment.yearId, enrolment1.year.id);
        assertEquals( enrolment.courseId, enrolment1.course.id);
        assertEquals( enrolment.courseGroupId, enrolment1.courseGroup.id);
        assertEquals( enrolment.startDate, enrolment1.startDate);
        assertEquals( enrolment.endDate, enrolment1.endDate);
        assertEquals( enrolment.qualificationStartDate, enrolment1.qualificationStartDate);
        assertEquals( enrolment.plannedEndDate, enrolment1.plannedEndDate);
        assertEquals( enrolment.aimTypeId, enrolment1.aimType.id);
        assertEquals( enrolment.completionStatusId, enrolment1.completionStatus.id);
        assertEquals( enrolment.withdrawalReasonId, enrolment1.withdrawalReason.id);
        assertEquals( enrolment.outcomeId, enrolment1.outcome.id);
        assertEquals( enrolment.grade, enrolment1.grade);
        assertEquals( enrolment.ilr, enrolment1.ilr);
        assertEquals( enrolment.centralMonitoringId, enrolment1.centralMonitoring.id);
        assertEquals( enrolment.plh, enrolment1.plh);
        assertEquals( enrolment.peeph, enrolment1.peeph);
        assertEquals( enrolment.fundingModelId, enrolment1.fundingModel.id);
        assertEquals( enrolment.sourceOfFundingId, enrolment1.sourceOfFunding.id);
        assertEquals( enrolment.reference, PreReferenceDto.mapFromEntity(enrolment1.reference));
    }
    
    @Test
    public void testMethod_Get_NullCourseReference() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.course, enrolmentDto1.get_CourseReference())
    }
    
    @Test
    public void testMethod_Get_CourseReference() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.course.spec, enrolmentDto1.get_CourseReference())
    }
    
    @Test
    public void testMethod_Get_NullAcademicYearCode() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.academicYear, enrolmentDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_AcademicYearCode() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.academicYear.code, enrolmentDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_NullCourseGroupReference() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.courseGroup, enrolmentDto1.get_CourseGroupReference())
    }
    
    @Test
    public void testMethod_Get_CourseGroupReference() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.courseGroup.spec, enrolmentDto1.get_CourseGroupReference())
    }
    
    @Test
    public void testMethod_Get_NullFundingModelCode() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.fundingModel, enrolmentDto1.get_FundingModelCode())
    }
    
    @Test
    public void testMethod_Get_FundingModelCode() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.fundingModel.code, enrolmentDto1.get_FundingModelCode())
    }
    
    @Test
    public void testMethod_Get_NullFundingModelDescription() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.fundingModel, enrolmentDto1.get_FundingModelDescription())
    }
    
    @Test
    public void testMethod_Get_FundingModelDescription() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.fundingModel.description, enrolmentDto1.get_FundingModelDescription())
    }
    
    @Test
    public void testMethod_Get_NullSourceOfFundingCode() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.sourceOfFunding, enrolmentDto1.get_SourceOfFundingCode())
    }
    
    @Test
    public void testMethod_Get_SourceOfFundingCode() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.sourceOfFunding.code, enrolmentDto1.get_SourceOfFundingCode())
    }
    
    @Test
    public void testMethod_Get_NullSourceOfFundingDescription() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment3)
        assertEquals(enrolmentDto1.sourceOfFunding, enrolmentDto1.get_SourceOfFundingDescription())
    }
    
    @Test
    public void testMethod_Get_SourceOfFundingDescription() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.sourceOfFunding.description, enrolmentDto1.get_SourceOfFundingDescription())
    }
    
    @Test
    public void testMethod_Get_NullSubjectDescription() {
        Enrolment enrolment = new Enrolment(id: 1, student: createStudent(), year : createAcademicYear(), course: new Course(id: 1, subject: null))
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment)
        assertEquals(enrolmentDto1.course.subject, enrolmentDto1.get_SubjectDescription())
    }
    
    @Test
    public void testMethod_Get_SubjectDescription() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.course.subject.description, enrolmentDto1.get_SubjectDescription())
    }
    
    @Test
    public void testMethod_Get_NullLevelDescription() {
        Enrolment enrolment = new Enrolment(id: 1, student: createStudent(), year : createAcademicYear(), course: new Course(id: 1, level: null))
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment)
        assertEquals(enrolmentDto1.course.level, enrolmentDto1.get_LevelDescription())
    }
    
    @Test
    public void testMethod_Get_LevelDescription() {
        EnrolmentSummaryDto enrolmentDto1 = new EnrolmentSummaryDto(enrolment1)
        assertEquals(enrolmentDto1.course.level.description, enrolmentDto1.get_LevelDescription())
    }
}
