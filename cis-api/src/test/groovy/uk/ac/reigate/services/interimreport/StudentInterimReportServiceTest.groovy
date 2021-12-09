package uk.ac.reigate.services.interimreport;

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.cristal.InterimReportEffortGrade
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.interimreport.StudentInterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.interimreport.StudentInterimReportRepository
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.cristal.InterimReportEffortGradeService
import uk.ac.reigate.services.lookup.PossibleGradeService
import uk.ac.reigate.services.student.StudentService


public class StudentInterimReportServiceTest {
    
    @Mock
    private StudentInterimReportRepository studentInterimReportRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private CourseService courseService;
    
    @Mock
    private CourseGroupService courseGroupService;
    
    @Mock
    private InterimReportService interimReportService;
    
    @Mock
    private InterimReportEffortGradeService interimReportEffortGradeService;
    
    @Mock
    private PossibleGradeService possibleGradeService;
    
    @InjectMocks
    private StudentInterimReportService studentInterimReportService;
    
    private StudentInterimReport studentInterimReport
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentInterimReport createStudentInterimReport() {
        return new StudentInterimReport(
                id: 1,
                motivation: new InterimReportEffortGrade(id: 1),
                classEthic: new InterimReportEffortGrade(id: 1)
                )
    }
    
    StudentInterimReportDto createDto() {
        StudentInterimReport sampleStudentInterimReport = createStudentInterimReport()
        return new StudentInterimReportDto(
                id: sampleStudentInterimReport.id,
                motivationId: sampleStudentInterimReport.motivation.id,
                classEthicId: sampleStudentInterimReport.classEthic.id
                )
    }
    
    @Before
    public void setup() {
        studentInterimReportRepository = mock(StudentInterimReportRepository.class);
        studentService = mock(StudentService.class);
        staffService = mock(StaffService.class);
        courseService = mock(CourseService.class);
        courseGroupService = mock(CourseGroupService.class);
        interimReportService = mock(InterimReportService.class);
        possibleGradeService = mock(PossibleGradeService.class);
        interimReportEffortGradeService = mock(InterimReportEffortGradeService.class);
        
        studentInterimReportService = new StudentInterimReportService(studentInterimReportRepository, studentService, staffService, courseService, courseGroupService, interimReportService, possibleGradeService, interimReportEffortGradeService);
        
        studentInterimReport = createStudentInterimReport()
        when(studentInterimReportRepository.findById(1)).thenReturn(new Optional(new StudentInterimReport()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentInterimReportService service = new StudentInterimReportService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentInterimReport> result = studentInterimReportService.findAll();
        verify(studentInterimReportRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindById() {
        StudentInterimReport result = studentInterimReportService.findById(1);
        verify(studentInterimReportRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        List<StudentInterimReport> result = studentInterimReportService.getByStudentId(2);
        verify(studentInterimReportRepository, times(1)).findByStudent_Id(2)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByStudentIdAndYearId() {
        List<StudentInterimReport> result = studentInterimReportService.findByStudentAndYearId(19001, 18);
        verify(studentInterimReportRepository, times(1)).findByStudent_IdAndInterimReport_Year_Id(19001, 18)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByCourseId() {
        List<StudentInterimReport> result = studentInterimReportService.findByCourseId(2);
        verify(studentInterimReportRepository, times(1)).findByCourse_Id(2)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByCourseGroupId() {
        List<StudentInterimReport> result = studentInterimReportService.findByCourseGroupId(2);
        verify(studentInterimReportRepository, times(1)).findByCourseGroup_Id(2)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByCourseGroupIdAndInterimReportId() {
        List<StudentInterimReport> result = studentInterimReportService.findByCourseGroupIdAndInterimReportId(2, 1);
        verify(studentInterimReportRepository, times(1)).findByCourseGroup_IdAndInterimReport_Id(2, 1)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByStudentAndCourseGroupAndInterimReport() {
        StudentInterimReport result = studentInterimReportService.findByStudentAndCourseGroupAndInterimReport(2, 1, 1);
        verify(studentInterimReportRepository, times(1)).findByStudent_IdAndCourseGroup_IdAndInterimReport_Id(2, 1, 1)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testFindByStudent() {
        Student student = new Student(id:19001)
        List<StudentInterimReport> result = studentInterimReportService.getByStudent(student);
        verify(studentInterimReportRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testSave() {
        studentInterimReport.id = null
        studentInterimReportService.save(studentInterimReport);
        verify(studentInterimReportRepository, times(1)).save(studentInterimReport)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testSaveStudentInterimReport() {
        studentInterimReportService.save(studentInterimReport);
        verify(studentInterimReportRepository, times(1)).save(studentInterimReport)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update StudentInterimReport from null object.")
        StudentInterimReportDto dto = null
        studentInterimReportService.updateFromDto(dto)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentInterimReportDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStaffId() {
        StudentInterimReportDto dto = createDto()
        dto.staffId = 1
        when(staffService.findById(dto.staffId)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.staffId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithInterimReportId() {
        StudentInterimReportDto dto = createDto()
        dto.interimReportId = 1
        when(interimReportService.findById(dto.interimReportId)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(interimReportService, times(1)).findById(dto.interimReportId)
        verifyNoMoreInteractions(interimReportService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithcourseGroupId() {
        StudentInterimReportDto dto = createDto()
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(courseGroupService, times(1)).findById(dto.courseGroupId)
        verifyNoMoreInteractions(courseGroupService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithcurrentPredictedGradeId() {
        StudentInterimReportDto dto = createDto()
        dto.currentPredictedGradeId = 1
        when(possibleGradeService.findById(dto.currentPredictedGradeId)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(possibleGradeService, times(1)).findById(dto.currentPredictedGradeId)
        verifyNoMoreInteractions(possibleGradeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithcurrentkeyAssessment1Id() {
        StudentInterimReportDto dto = createDto()
        dto.keyAssessment1Id = 1
        when(possibleGradeService.findById(dto.keyAssessment1Id)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(possibleGradeService, times(1)).findById(dto.keyAssessment1Id)
        verifyNoMoreInteractions(possibleGradeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithcurrentkeyAssessment2Id() {
        StudentInterimReportDto dto = createDto()
        dto.keyAssessment2Id = 1
        when(possibleGradeService.findById(dto.keyAssessment2Id)).thenReturn(null);
        // Initialise Test
        studentInterimReportService.updateFromDto(dto)
        // Verify Results
        verify(possibleGradeService, times(1)).findById(dto.keyAssessment2Id)
        verifyNoMoreInteractions(possibleGradeService)
    }
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        studentInterimReportService.delete(studentInterimReport)
        verify(studentInterimReportRepository, times(1)).delete(studentInterimReport)
        verifyNoMoreInteractions(studentInterimReportRepository)
    }
}
