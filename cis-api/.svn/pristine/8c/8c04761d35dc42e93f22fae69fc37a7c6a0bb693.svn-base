package uk.ac.reigate.dto.interimreport

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.cristal.InterimReportEffortGrade
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.domain.lookup.PossibleGrade

class StudentInterimReportSummaryDtoTest {
    
    private StudentInterimReport studentInterimReport1
    
    private StudentInterimReport studentInterimReport2
    
    private StudentInterimReport studentInterimReport3
    
    private List<StudentInterimReport> studentInterimReports
    
    @Before
    public void setup() {
        studentInterimReport1 = new StudentInterimReport(
                id: 1,
                student: new Student(id: 190001),
                interimReport: new InterimReport(id:1),
                course : new Course(id:1),
                courseGroup : new CourseGroup (id:1),
                staff : new Staff(id: 1),
                motivation : new InterimReportEffortGrade(id: 1),
                classEthic : new InterimReportEffortGrade(id: 1),
                timeManagement : new InterimReportEffortGrade(id: 1),
                totalPossible : 4,
                absence : 2,
                authorisedAbsence : 4,
                late : 6,
                currentPredictedGrade : new PossibleGrade(id:1),
                keyAssessment1 : new PossibleGrade(id:1),
                keyAssessment2 : new PossibleGrade(id:2)
                );
        studentInterimReport2 = new StudentInterimReport(
                id: 2,
                student: new Student(id: 190001),
                interimReport: new InterimReport(id:1),
                course : new Course(id:1),
                courseGroup : new CourseGroup (id:1),
                staff : new Staff(id: 1),
                motivation : new InterimReportEffortGrade(id: 1),
                classEthic : new InterimReportEffortGrade(id: 1),
                timeManagement : new InterimReportEffortGrade(id: 1),
                totalPossible : 4,
                absence : 2,
                authorisedAbsence : 4,
                late : 6,
                currentPredictedGrade : new PossibleGrade(id:1),
                keyAssessment1 : new PossibleGrade(id:1),
                keyAssessment2 : new PossibleGrade(id:2)
                );
        studentInterimReport3 = new StudentInterimReport(
                id: 2,
                student: null,
                interimReport: null,
                courseGroup : null,
                staff : null,
                motivation : null,
                classEthic : null,
                timeManagement : null,
                totalPossible : null,
                absence : null,
                authorisedAbsence : null,
                late : null,
                currentPredictedGrade : null,
                keyAssessment1 : null,
                keyAssessment2 : null
                );
        studentInterimReports = Arrays.asList(studentInterimReport1, studentInterimReport2);
    }
    
    @Test
    public void testMapFromStudentInterimReportEntity(){
        StudentInterimReportSummaryDto studentInterimReportTest = StudentInterimReportSummaryDto.mapFromEntity( studentInterimReport1 )
        assertEquals( studentInterimReportTest.id, studentInterimReport1.id );
        assertEquals( studentInterimReportTest.studentId, studentInterimReport1.student.id);
        assertEquals( studentInterimReportTest.interimReportId, studentInterimReport1.interimReport.id)
        assertEquals( studentInterimReportTest.courseId, studentInterimReport1.course.id)
        assertEquals( studentInterimReportTest.courseGroupId, studentInterimReport1.courseGroup.id)
        assertEquals( studentInterimReportTest.staffId, studentInterimReport1.staff.id)
        assertEquals( studentInterimReportTest.motivationId, studentInterimReport1.motivation.id)
        assertEquals( studentInterimReportTest.classEthicId, studentInterimReport1.classEthic.id)
        assertEquals( studentInterimReportTest.timeManagementId, studentInterimReport1.timeManagement.id)
        assertEquals( studentInterimReportTest.totalPossible, studentInterimReport1.totalPossible)
        assertEquals( studentInterimReportTest.absence, studentInterimReport1.absence)
        assertEquals( studentInterimReportTest.authorisedAbsence, studentInterimReport1.authorisedAbsence)
        assertEquals( studentInterimReportTest.late , studentInterimReport1.late )
    }
    
    @Test
    public void testMapFromStudentInterimReportsEntities(){
        List<StudentInterimReportSummaryDto> studentInterimReportTest = StudentInterimReportSummaryDto.mapFromList( studentInterimReports )
        assertEquals( studentInterimReportTest[0].id, studentInterimReport1.id );
        assertEquals( studentInterimReportTest[0].studentId, studentInterimReport1.student.id);
        assertEquals( studentInterimReportTest[0].interimReportId, studentInterimReport1.interimReport.id)
        assertEquals( studentInterimReportTest[0].courseId, studentInterimReport1.course.id)
        assertEquals( studentInterimReportTest[0].courseGroupId, studentInterimReport1.courseGroup.id)
        assertEquals( studentInterimReportTest[0].staffId, studentInterimReport1.staff.id)
        assertEquals( studentInterimReportTest[0].motivationId, studentInterimReport1.motivation.id)
        assertEquals( studentInterimReportTest[0].classEthicId, studentInterimReport1.classEthic.id)
        assertEquals( studentInterimReportTest[0].timeManagementId, studentInterimReport1.timeManagement.id)
        assertEquals( studentInterimReportTest[0].totalPossible, studentInterimReport1.totalPossible)
        assertEquals( studentInterimReportTest[0].absence, studentInterimReport1.absence)
        assertEquals( studentInterimReportTest[0].authorisedAbsence, studentInterimReport1.authorisedAbsence)
        assertEquals( studentInterimReportTest[0].late , studentInterimReport1.late )
        assertEquals( studentInterimReportTest[1].id, studentInterimReport2.id );
        assertEquals( studentInterimReportTest[1].studentId, studentInterimReport2.student.id);
        assertEquals( studentInterimReportTest[1].interimReportId, studentInterimReport2.interimReport.id)
        assertEquals( studentInterimReportTest[1].courseId, studentInterimReport2.course.id)
        assertEquals( studentInterimReportTest[1].courseGroupId, studentInterimReport2.courseGroup.id)
        assertEquals( studentInterimReportTest[1].staffId, studentInterimReport2.staff.id)
        assertEquals( studentInterimReportTest[1].motivationId, studentInterimReport2.motivation.id)
        assertEquals( studentInterimReportTest[1].classEthicId, studentInterimReport2.classEthic.id)
        assertEquals( studentInterimReportTest[1].timeManagementId, studentInterimReport2.timeManagement.id)
        assertEquals( studentInterimReportTest[1].totalPossible, studentInterimReport2.totalPossible)
        assertEquals( studentInterimReportTest[1].absence, studentInterimReport2.absence)
        assertEquals( studentInterimReportTest[1].authorisedAbsence, studentInterimReport2.authorisedAbsence)
        assertEquals( studentInterimReportTest[1].late , studentInterimReport2.late )
    }
    
    @Test
    public void testEquals_Same() {
        StudentInterimReportSummaryDto studentInterimReportDto1 = new StudentInterimReportSummaryDto(studentInterimReport1)
        StudentInterimReportSummaryDto studentInterimReportDto2 = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto1, studentInterimReportDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentInterimReportSummaryDto studentInterimReportDto1 = new StudentInterimReportSummaryDto(studentInterimReport1)
        StudentInterimReportSummaryDto studentInterimReportDto2 = new StudentInterimReportSummaryDto(studentInterimReport2)
        assertNotEquals(studentInterimReportDto1, studentInterimReportDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentInterimReportSummaryDto studentInterimReportDto1 = new StudentInterimReportSummaryDto(studentInterimReport1)
        StudentInterimReportSummaryDto studentInterimReportDto2 = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto1.hashCode(), studentInterimReportDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentInterimReportSummaryDto studentInterimReportDto1 = new StudentInterimReportSummaryDto(studentInterimReport1)
        StudentInterimReportSummaryDto studentInterimReportDto2 = new StudentInterimReportSummaryDto(studentInterimReport2)
        assertNotEquals(studentInterimReportDto1.hashCode(), studentInterimReportDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentInterimReport() {
        StudentInterimReportSummaryDto studentInterimReportTest= new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals( studentInterimReportTest.id, studentInterimReport1.id );
        assertEquals( studentInterimReportTest.studentId, studentInterimReport1.student.id);
        assertEquals( studentInterimReportTest.interimReportId, studentInterimReport1.interimReport.id)
        assertEquals( studentInterimReportTest.courseId, studentInterimReport1.course.id)
        assertEquals( studentInterimReportTest.courseGroupId, studentInterimReport1.courseGroup.id)
        assertEquals( studentInterimReportTest.staffId, studentInterimReport1.staff.id)
        assertEquals( studentInterimReportTest.motivationId, studentInterimReport1.motivation.id)
        assertEquals( studentInterimReportTest.classEthicId, studentInterimReport1.classEthic.id)
        assertEquals( studentInterimReportTest.timeManagementId, studentInterimReport1.timeManagement.id)
        assertEquals( studentInterimReportTest.totalPossible, studentInterimReport1.totalPossible)
        assertEquals( studentInterimReportTest.absence, studentInterimReport1.absence)
        assertEquals( studentInterimReportTest.authorisedAbsence, studentInterimReport1.authorisedAbsence)
        assertEquals( studentInterimReportTest.late , studentInterimReport1.late )
    }
    
    @Test
    public void testConstructor_NullStudentInterimReport() {
        StudentInterimReport studentInterimReport = null
        StudentInterimReportSummaryDto studentInterimReportTest = new StudentInterimReportSummaryDto(studentInterimReport)
        assertEquals( studentInterimReport, null );
    }
    
    @Test
    public void testMethod_Get_InterimReportDescription() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.interimReport.description, studentInterimReportDto.get_InterimReportDescription())
    }
    
    @Test
    public void testMethod_Get_NullInterimReportDescription() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.interimReport, studentInterimReportDto.get_InterimReportDescription())
    }
    
    @Test
    public void testMethod_Get_NullCourseDescription() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.course, studentInterimReportDto.get_CourseDescription())
    }
    
    @Test
    public void testMethod_Get_CourseDescription() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.course.spec, studentInterimReportDto.get_CourseDescription())
    }
    
    @Test
    public void testMethod_Get_NullCourseGroupDescription() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.courseGroup, studentInterimReportDto.get_CourseGroupDescription())
    }
    
    @Test
    public void testMethod_Get_CourseGroupDescription() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.courseGroup.spec, studentInterimReportDto.get_CourseGroupDescription())
    }
    
    @Test
    public void testMethod_Get_CurrentPredictedGrade() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.currentPredictedGrade.grade, studentInterimReportDto.get_CurrentPredictedGrade())
    }
    
    @Test
    public void testMethod_Get_NullCurrentPredictedGrade() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.currentPredictedGrade, studentInterimReportDto.get_CurrentPredictedGrade())
    }
    
    @Test
    public void testMethod_Get_NullKeyAssessment1Grade() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.keyAssessment1, studentInterimReportDto.get_KeyAssessment1Grade())
    }
    
    @Test
    public void testMethod_Get_KeyAssessment1Grade() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.keyAssessment1.grade, studentInterimReportDto.get_KeyAssessment1Grade())
    }
    
    @Test
    public void testMethod_Get_KeyAssessment2Grade() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.keyAssessment2.grade, studentInterimReportDto.get_KeyAssessment2Grade())
    }
    
    @Test
    public void testMethod_Get_NullKeyAssessment2Grade() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.keyAssessment2, studentInterimReportDto.get_KeyAssessment2Grade())
    }
    
    @Test
    public void testMethod_Get_AverageEffort() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals((studentInterimReportDto.motivationId + studentInterimReportDto.classEthicId + studentInterimReportDto.timeManagementId) / 3, studentInterimReportDto.get_AverageEffort(), 1.3333)
    }
    
    @Test
    public void testMethod_Get_AttendancePercentage() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals((studentInterimReportDto.totalPossible - studentInterimReportDto.absence) / studentInterimReportDto.totalPossible, studentInterimReportDto.get_AttendancePercentage(), 0.5)
    }
    
    @Test
    public void testMethod_Get_AdjustedAttendancePercentage() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals((studentInterimReportDto.totalPossible - (studentInterimReportDto.absence - studentInterimReportDto.authorisedAbsence)) / studentInterimReportDto.totalPossible, studentInterimReportDto.get_AdjustedAttendancePercentage(), 1.5)
    }
    
    @Test
    public void testMethod_Get_PunctualityPercentage() {
        StudentInterimReportSummaryDto studentInterimReportDto = new StudentInterimReportSummaryDto(studentInterimReport1)
        assertEquals(((studentInterimReportDto.totalPossible - studentInterimReportDto.absence) - studentInterimReportDto.late) / studentInterimReportDto.absence, studentInterimReportDto.get_PunctualityPercentage(), 1.5)
    }
}
