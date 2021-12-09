package uk.ac.reigate.dto.interimreport;

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



public class StudentInterimReportDtoTest {
    
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
                course: null,
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
        StudentInterimReportDto studentInterimReportTest = StudentInterimReportDto.mapFromEntity( studentInterimReport1 )
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
        List<StudentInterimReportDto> studentInterimReportTest = StudentInterimReportDto.mapFromList( studentInterimReports )
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
        StudentInterimReportDto studentInterimReportDto1 = new StudentInterimReportDto(studentInterimReport1)
        StudentInterimReportDto studentInterimReportDto2 = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto1, studentInterimReportDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentInterimReportDto studentInterimReportDto1 = new StudentInterimReportDto(studentInterimReport1)
        StudentInterimReportDto studentInterimReportDto2 = new StudentInterimReportDto(studentInterimReport2)
        assertNotEquals(studentInterimReportDto1, studentInterimReportDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentInterimReportDto studentInterimReportDto1 = new StudentInterimReportDto(studentInterimReport1)
        StudentInterimReportDto studentInterimReportDto2 = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto1.hashCode(), studentInterimReportDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentInterimReportDto studentInterimReportDto1 = new StudentInterimReportDto(studentInterimReport1)
        StudentInterimReportDto studentInterimReportDto2 = new StudentInterimReportDto(studentInterimReport2)
        assertNotEquals(studentInterimReportDto1.hashCode(), studentInterimReportDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentInterimReport() {
        StudentInterimReportDto studentInterimReportTest= new StudentInterimReportDto(studentInterimReport1)
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
        StudentInterimReportDto studentInterimReportTest = new StudentInterimReportDto(studentInterimReport)
        assertEquals( studentInterimReport, null );
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentInterimReportDto studentInterimReportTest= new StudentInterimReportDto(studentInterimReport3)
        assertEquals( studentInterimReportTest.id, studentInterimReport3.id );
        assertEquals( studentInterimReportTest.studentId, studentInterimReport3.student);
        assertEquals( studentInterimReportTest.interimReportId, studentInterimReport3.interimReport)
        assertEquals( studentInterimReportTest.courseGroupId, studentInterimReport3.courseGroup)
        assertEquals( studentInterimReportTest.staffId, studentInterimReport3.staff)
        assertEquals( studentInterimReportTest.motivationId, studentInterimReport3.motivation)
        assertEquals( studentInterimReportTest.classEthicId, studentInterimReport3.classEthic)
        assertEquals( studentInterimReportTest.timeManagementId, studentInterimReport3.timeManagement)
        assertEquals( studentInterimReportTest.totalPossible, studentInterimReport3.totalPossible)
        assertEquals( studentInterimReportTest.absence, studentInterimReport3.absence)
        assertEquals( studentInterimReportTest.authorisedAbsence, studentInterimReport3.authorisedAbsence)
        assertEquals( studentInterimReportTest.late , studentInterimReport3.late )
    }
    
    @Test
    public void testMethod_Get_InterimReportDescription() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.interimReport.description, studentInterimReportDto.get_InterimReportDescription())
    }
    
    @Test
    public void testMethod_Get_NullInterimReportDescription() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.interimReport, studentInterimReportDto.get_InterimReportDescription())
    }
    
    @Test
    public void testMethod_Get_CourseDescription() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.course.spec, studentInterimReportDto.get_CourseDescription())
    }
    
    @Test
    public void testMethod_Get_NullCourseDescription() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.course, studentInterimReportDto.get_CourseDescription())
    }
    
    @Test
    public void testMethod_Get_CourseGroupDescription() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.courseGroup.spec, studentInterimReportDto.get_CourseGroupDescription())
    }
    
    @Test
    public void testMethod_Get_NullCourseGroupDescription() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.courseGroup, studentInterimReportDto.get_CourseGroupDescription())
    }
    
    @Test
    public void testMethod_Get_CurrentPredictedGrade() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.currentPredictedGrade.grade, studentInterimReportDto.get_CurrentPredictedGrade())
    }
    
    @Test
    public void testMethod_Get_NullCurrentPredictedGrade() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.currentPredictedGrade, studentInterimReportDto.get_CurrentPredictedGrade())
    }
    
    @Test
    public void testMethod_Get_KeyAssessment1Grade() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.keyAssessment1.grade, studentInterimReportDto.get_KeyAssessment1Grade())
    }
    
    @Test
    public void testMethod_Get_NullKeyAssessment1Grade() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.keyAssessment1, studentInterimReportDto.get_KeyAssessment1Grade())
    }
    
    @Test
    public void testMethod_Get_KeyAssessment2Grade() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(studentInterimReportDto.keyAssessment2.grade, studentInterimReportDto.get_KeyAssessment2Grade())
    }
    
    @Test
    public void testMethod_Get_NullKeyAssessment2Grade() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport3)
        assertEquals(studentInterimReportDto.keyAssessment2, studentInterimReportDto.get_KeyAssessment2Grade())
    }
    
    @Test
    public void testMethod_Get_AverageEffort() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals((studentInterimReportDto.motivationId + studentInterimReportDto.classEthicId + studentInterimReportDto.timeManagementId) / 3, studentInterimReportDto.get_AverageEffort(), 1.3333)
    }
    
    @Test
    public void testMethod_Get_AttendancePercentage() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals((studentInterimReportDto.totalPossible - studentInterimReportDto.absence) / studentInterimReportDto.totalPossible, studentInterimReportDto.get_AttendancePercentage(), 0.5)
    }
    
    @Test
    public void testMethod_Get_AdjustedAttendancePercentage() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals((studentInterimReportDto.totalPossible - (studentInterimReportDto.absence - studentInterimReportDto.authorisedAbsence)) / studentInterimReportDto.totalPossible, studentInterimReportDto.get_AdjustedAttendancePercentage(), 1.5)
    }
    
    @Test
    public void testMethod_Get_PunctualityPercentage() {
        StudentInterimReportDto studentInterimReportDto = new StudentInterimReportDto(studentInterimReport1)
        assertEquals(((studentInterimReportDto.totalPossible - studentInterimReportDto.absence) - studentInterimReportDto.late) / studentInterimReportDto.absence, studentInterimReportDto.get_PunctualityPercentage(), 1.5)
    }
}
