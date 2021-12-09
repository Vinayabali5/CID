package uk.ac.reigate.services.enrolments

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.jdbc.core.JdbcTemplate

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.EnrolmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.mappers.WorkingCombinationsMapper
import uk.ac.reigate.model.allocation.WorkingCombination
import uk.ac.reigate.repositories.academic.EnrolmentRepository
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CentralMonitoringService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ilr.AimTypeService
import uk.ac.reigate.services.ilr.CompletionStatusService
import uk.ac.reigate.services.ilr.FundingModelService
import uk.ac.reigate.services.ilr.OutcomeService
import uk.ac.reigate.services.ilr.SourceOfFundingService
import uk.ac.reigate.services.ilr.WithdrawalReasonService
import uk.ac.reigate.services.student.StudentService


class EnrolmentServiceTest {
    
    @Mock
    private EnrolmentRepository enrolmentRepository;
    
    @Mock
    private JdbcTemplate jdbcTemplate
    
    private StudentRepository studentRepository
    
    @InjectMocks
    private EnrolmentService enrolmentService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @Mock
    private CourseGroupService courseGroupService;
    
    @Mock
    private CourseService courseService;
    
    @Mock
    private OutcomeService outcomeService;
    
    @Mock
    private FundingModelService fundingModelService;
    
    @Mock
    private SourceOfFundingService sourceOfFundingService;
    
    @Mock
    private AimTypeService aimTypeService;
    
    @Mock
    private WithdrawalReasonService withdrawalReasonService;
    
    @Mock
    private CompletionStatusService completionStatusService;
    
    @Mock
    private CentralMonitoringService centralMonitoringService
    
    private Enrolment enrolment
    
    private Course course
    
    private Student student
    
    private AcademicYear academicYear
    
    private StudentService studentService
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Enrolment data object to use for the testing
     * 
     * @return a sample Enrolment data object
     */
    Enrolment createEnrolment() {
        return new Enrolment(
                id: 1,
                student : new Student()
                
                )
    }
    
    Course createCourse() {
        return new Course(
                id: 2,
                glh: 10,
                learningAimReference : 'Test'
                )
    }
    
    Student createStudent() {
        return new Student(
                id: 190001,
                academicYear: new AcademicYear())
    }
    
    AcademicYear createAcademicYear() {
        return new AcademicYear(
                id: 18)
    }
    /**
     * This method is used to create a DTO object based on the sample Enrolment created at setup
     * 
     * @return a EnrolmentDto object based on the sample Enrolment
     */
    EnrolmentDto createDto() {
        return new EnrolmentDto(
                enrolmentId : enrolment.id,
                studentId : enrolment.student.id
                
                )
    }
    
    /**
     * This method is used to set up the tests for the EnrolmentService
     */
    @Before
    public void setup() {
        enrolmentRepository = mock(EnrolmentRepository.class);
        academicYearService = mock(AcademicYearService.class);
        courseGroupService = mock(CourseGroupService.class);
        courseService = mock(CourseService.class);
        outcomeService = mock(OutcomeService.class);
        fundingModelService = mock(FundingModelService.class);
        sourceOfFundingService = mock(SourceOfFundingService.class);
        aimTypeService = mock(AimTypeService.class);
        withdrawalReasonService = mock(WithdrawalReasonService.class);
        studentService = mock(StudentService.class);
        completionStatusService = mock(CompletionStatusService.class);
        centralMonitoringService = mock(CentralMonitoringService.class)
        enrolmentService = new EnrolmentService(enrolmentRepository, academicYearService, courseGroupService, courseService, outcomeService, fundingModelService, sourceOfFundingService,
                aimTypeService, withdrawalReasonService, studentService, completionStatusService, centralMonitoringService);
        
        enrolment = createEnrolment()
        
        // when(enrolmentRepository.save(any(Enrolment.class))).thenReturn(enrolment);
        when(enrolmentRepository.findById(enrolment.id)).thenReturn(new Optional(new Enrolment()));
    }
    
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        EnrolmentService service = new EnrolmentService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Enrolment> result = enrolmentService.findAll();
        verify(enrolmentRepository, times(1)).findAll()
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Enrolment result = enrolmentService.findById(1);
        verify(enrolmentRepository, times(1)).findById(1)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByCourse service method
     */
    @Test
    public void testFindByCourse() {
        List<Enrolment> result = enrolmentService.findByCourse(course);
        verify(enrolmentRepository, times(1)).findByCourse(course)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByStudentAndYear service method
     */
    @Test
    public void testFindByStudentAndYear() {
        List<Enrolment> result = enrolmentService.findByStudentAndYear(student, academicYear);
        verify(enrolmentRepository, times(1)).findByStudentAndYear(student, academicYear)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByStudentAndYearId service method
     */
    @Test
    public void testFindByStudentAndYearId() {
        Integer studentId = 190001
        Integer yearId = 18
        List<Enrolment> result = enrolmentService.findByStudentAndYearId(studentId, yearId);
        verify(enrolmentRepository, times(1)).findByStudent_IdAndYear_Id(studentId, yearId)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByStudentAndYearId service method
     */
    @Test
    public void testFindByStudentId() {
        Integer studentId = 190001
        List<Enrolment> result = enrolmentService.findByStudentId(studentId);
        verify(enrolmentRepository, times(1)).findByStudent_Id(studentId)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByCourseGroup service method
     */
    @Test
    public void testFindByCourseGroup() {
        Integer courseGroupId = 1
        List<Enrolment> result = enrolmentService.findByCourseGroup(courseGroupId);
        verify(enrolmentRepository, times(1)).findByCourseGroup_Id(courseGroupId)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByCourseGroup service method
     */
    @Test
    public void testFindByCourseGroupAndYear() {
        Integer courseGroupId = 1
        List<Enrolment> result = enrolmentService.findByCourseGroupAndYear(courseGroupId, academicYear);
        verify(enrolmentRepository, times(1)).findByCourseGroup_IdAndYear(courseGroupId, academicYear)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findCurrentCourseGroup service method
     */
    @Test
    public void testFindCurrentCourseGroup() {
        Integer courseGroupId = 1
        List<Enrolment> result = enrolmentService.findCurrentCourseGroup(courseGroupId);
        verify(enrolmentRepository, times(1)).findByCurrentCourseGroup_Id(courseGroupId)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByCourseGroup service method
     */
    @Test
    public void testFindByCourseId() {
        Integer courseId = 1
        List<Enrolment> result = enrolmentService.findByCourseId(courseId);
        verify(enrolmentRepository, times(1)).findByCourse_Id(courseId)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByCourseAndYear service method
     */
    @Test
    public void testFindByCourseAndYear() {
        Integer courseId = 1
        List<Enrolment> result = enrolmentService.findByCourseAndYear(courseId, academicYear);
        verify(enrolmentRepository, times(1)).findByCourse_IdAndYear(courseId, academicYear)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the findByStudentAndYearId service method
     */
    @Test
    public void testFindByYearId() {
        Integer yearId = 18
        List<Enrolment> result = enrolmentService.findByYearId(yearId);
        verify(enrolmentRepository, times(1)).findByYear_Id(yearId)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Enrolment savedEnrolment = enrolmentService.save(enrolment);
        verify(enrolmentRepository, times(1)).save(any())
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Enrolment> savedEnrolments = enrolmentService.saveEnrolments([enrolment, enrolment]);
        verify(enrolmentRepository, times(2)).save(enrolment)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        EnrolmentDto dto = createDto()
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        EnrolmentDto dto = createDto()
        dto.studentId = 190001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearId() {
        EnrolmentDto dto = createDto()
        dto.yearId = 18
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithCourseId() {
        EnrolmentDto dto = createDto()
        dto.courseId = 1
        when(courseService.findById(dto.courseId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithAimTypeId() {
        EnrolmentDto dto = createDto()
        dto.aimTypeId = 1
        when(aimTypeService.findById(dto.aimTypeId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithCompletionStatusId() {
        EnrolmentDto dto = createDto()
        dto.completionStatusId = 1
        when(completionStatusService.findById(dto.completionStatusId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithOutcomeId() {
        EnrolmentDto dto = createDto()
        dto.outcomeId = 1
        when(outcomeService.findById(dto.outcomeId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithdrawalReasonId() {
        EnrolmentDto dto = createDto()
        dto.withdrawalReasonId = 1
        when(withdrawalReasonService.findById(dto.withdrawalReasonId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoCourseGroupId() {
        EnrolmentDto dto = createDto()
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithGrade() {
        EnrolmentDto dto = createDto()
        dto.grade = 'A'
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoCentralMonitoringId() {
        EnrolmentDto dto = createDto()
        dto.centralMonitoringId = 1
        when(centralMonitoringService.findById(dto.centralMonitoringId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoFundingModelId() {
        EnrolmentDto dto = createDto()
        dto.fundingModelId = 1
        when(fundingModelService.findById(dto.fundingModelId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoSourceOfFundingId() {
        EnrolmentDto dto = createDto()
        dto.sourceOfFundingId = 1
        when(sourceOfFundingService.findById(dto.sourceOfFundingId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        EnrolmentDto dto = createDto()
        dto.studentId = 190001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithYearId() {
        EnrolmentDto dto = createDto()
        dto.yearId = 18
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.yearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithCourseId() {
        EnrolmentDto dto = createDto()
        dto.courseId = 1
        when(courseService.findById(dto.courseId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(courseService, times(1)).findById(dto.courseId)
        verifyNoMoreInteractions(courseService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithAimTypeId() {
        EnrolmentDto dto = createDto()
        dto.aimTypeId = 1
        when(aimTypeService.findById(dto.aimTypeId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(aimTypeService, times(1)).findById(dto.aimTypeId)
        verifyNoMoreInteractions(aimTypeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithCompletionStatusId() {
        EnrolmentDto dto = createDto()
        dto.completionStatusId = 1
        when(completionStatusService.findById(dto.completionStatusId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(completionStatusService, times(1)).findById(dto.completionStatusId)
        verifyNoMoreInteractions(completionStatusService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithOutcomeId() {
        EnrolmentDto dto = createDto()
        dto.outcomeId = 1
        when(outcomeService.findById(dto.outcomeId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(outcomeService, times(1)).findById(dto.outcomeId)
        verifyNoMoreInteractions(outcomeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithdrawalReasonId() {
        EnrolmentDto dto = createDto()
        dto.withdrawalReasonId = 1
        when(withdrawalReasonService.findById(dto.withdrawalReasonId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(withdrawalReasonService, times(1)).findById(dto.withdrawalReasonId)
        verifyNoMoreInteractions(withdrawalReasonService)
    }
    
    @Test
    public void testUpdateFromDto_dtoCourseGroupId() {
        EnrolmentDto dto = createDto()
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(courseGroupService, times(1)).findById(dto.courseGroupId)
        verifyNoMoreInteractions(courseGroupService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithGrade() {
        EnrolmentDto dto = createDto()
        dto.grade = 'A'
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        //verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoCentralMonitoringId() {
        EnrolmentDto dto = createDto()
        dto.centralMonitoringId = 1
        when(centralMonitoringService.findById(dto.centralMonitoringId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(centralMonitoringService, times(1)).findById(dto.centralMonitoringId)
        verifyNoMoreInteractions(centralMonitoringService)
    }
    
    @Test
    public void testUpdateFromDto_dtoFundingModelId() {
        EnrolmentDto dto = createDto()
        dto.fundingModelId = 1
        when(fundingModelService.findById(dto.fundingModelId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(fundingModelService, times(1)).findById(dto.fundingModelId)
        verifyNoMoreInteractions(fundingModelService)
    }
    
    @Test
    public void testUPdateFromDto_dtoSourceOfFundingId() {
        EnrolmentDto dto = createDto()
        dto.sourceOfFundingId = 1
        when(sourceOfFundingService.findById(dto.sourceOfFundingId)).thenReturn(null);
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(sourceOfFundingService, times(1)).findById(dto.sourceOfFundingId)
        verifyNoMoreInteractions(sourceOfFundingService)
    }
    
    @Test
    public void testCreateFromDto_withNull() {
        EnrolmentDto dto = createDto()
        dto.studentId = null
        dto.yearId = null
        dto.courseId = null
        dto.courseGroupId = null
        dto.completionStatusId = null
        dto.outcomeId = null
        dto.withdrawalReasonId = null
        dto.centralMonitoringId = null
        dto.grade != null
        Enrolment enrolmentSaved = enrolmentService.createFromDto(dto)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        EnrolmentDto dto = createDto()
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(enrolmentRepository, times(1)).findById(enrolment.id)
        verify(enrolmentRepository, times(1)).save(any(Enrolment.class))
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    //@Test
    public void testUpdateFromDto_dtoWithNullValues() {
        EnrolmentDto dto = createDto()
        dto.studentId = null
        dto.yearId = null
        dto.courseId = null
        dto.courseGroupId = null
        dto.completionStatusId = null
        dto.outcomeId = null
        dto.withdrawalReasonId = null
        dto.centralMonitoringId = null
        dto.grade != null
        Enrolment enrolmentSaved = enrolmentService.updateFromDto(dto)
        verify(enrolmentRepository, times(1)).findById(enrolment.id)
        verify(enrolmentRepository, times(1)).save(enrolment)
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        // Stub Data and Method Returns
        EnrolmentDto dto = createDto()
        dto.enrolmentId = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("enrolment ID should not be null when updating");
        // Initialise Test
        enrolmentService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(enrolmentRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        enrolmentService.delete(enrolment)
        verifyNoMoreInteractions(enrolmentRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
}