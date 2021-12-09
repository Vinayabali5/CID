package uk.ac.reigate.services.student;

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.dto.StudentAdmissionDto
import uk.ac.reigate.dto.StudentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.learning_support.StudentConcessionTypeRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CollegeFundPaidService
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.DestinationService
import uk.ac.reigate.services.LLDDHealthProblemService
import uk.ac.reigate.services.SchoolReportStatusService
import uk.ac.reigate.services.SchoolService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.TutorGroupService
import uk.ac.reigate.services.admissions.ApplicationStatusService
import uk.ac.reigate.services.admissions.OfferTypeService
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.ilr.EthnicityService
import uk.ac.reigate.services.ilr.RestrictedUseIndicatorService
import uk.ac.reigate.services.lookup.StudentTypeService
import uk.ac.reigate.services.risk_assessment.RiskLevelService

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*


public class StudentServiceTest {
    
    @Mock
    private StudentRepository studentRepository
    
    @Mock
    private StudentYearService studentYearService
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private StudentTypeService studentTypeService
    
    @Mock
    private TutorGroupService tutorGroupService
    
    @Mock
    private CourseService courseService
    
    @Mock
    private CourseGroupService courseGroupService
    
    @Mock
    private EthnicityService ethnicityService
    
    @Mock
    private SchoolReportStatusService schoolReportStatusService
    
    @Mock
    private CollegeFundPaidService collegeFundPaidService
    
    @Mock
    private StaffService staffService
    
    @Mock
    private RestrictedUseIndicatorService restrictedUseIndicatorService
    
    @Mock
    private SchoolService schoolService
    
    @Mock
    private EnrolmentService enrolmentService
    
    @Mock
    private DestinationService destinationService
    
    @Mock
    private StudentRemarkPermissionService studentRemarkPermissionService
    
    @Mock
    private LLDDHealthProblemService llddHealthProblemService
    
    @Mock
    private RiskLevelService riskLevelService
    
    @Mock
    private ApplicationStatusService applicationStatusService
    
    @Mock
    private OfferTypeService offerTypeService
    
    @Mock
    private StudentConcessionTypeRepository studentConcessionTypeRepository
    
    @InjectMocks
    private StudentService studentService;
    
    private Student student
    
    private Course course
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Student createStudent() {
        return new Student(id:190001)
    }
    
    StudentDto createDto() {
        Student sampleStudent = createStudent()
        return new StudentDto(
                id: sampleStudent.id
                )
    }
    @Before
    public void setup() {
        studentRepository = mock(StudentRepository.class);
        studentYearService = mock(StudentYearService.class);
        academicYearService = mock(AcademicYearService.class);
        studentTypeService = mock(StudentTypeService.class);
        tutorGroupService = mock(TutorGroupService.class);
        courseService = mock(CourseService.class);
        courseGroupService = mock(CourseGroupService.class);
        ethnicityService = mock(EthnicityService.class);
        schoolReportStatusService = mock(SchoolReportStatusService.class);
        collegeFundPaidService = mock(CollegeFundPaidService.class);
        staffService = mock(StaffService.class);
        restrictedUseIndicatorService = mock(RestrictedUseIndicatorService.class);
        schoolService = mock(SchoolService.class);
        enrolmentService = mock(EnrolmentService.class);
        destinationService = mock(DestinationService.class);
        studentRemarkPermissionService = mock(StudentRemarkPermissionService.class);
        llddHealthProblemService = mock(LLDDHealthProblemService.class);
        riskLevelService = mock(RiskLevelService.class);
        applicationStatusService = mock(ApplicationStatusService.class);
        offerTypeService = mock(OfferTypeService.class);
        studentService = new StudentService(studentRepository, studentYearService, academicYearService,
                studentTypeService, tutorGroupService, courseService, courseGroupService, ethnicityService, schoolReportStatusService,
                collegeFundPaidService, staffService, restrictedUseIndicatorService,schoolService, enrolmentService, destinationService,
                studentRemarkPermissionService, llddHealthProblemService, riskLevelService,
                applicationStatusService, offerTypeService);
        
        student = createStudent()
        when(studentService.findById(190001))thenReturn(new Optional(new Student()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentService service = new StudentService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindById() {
        Student result = studentService.findById(1);
        verify(studentRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testFindAll() {
        List<Student> result = studentService.findAll();
        verify(studentRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testFindByPersonInAndStudentYears_Year() {
        Collection<Person> person = [new Person(id:1)]
        AcademicYear year = new AcademicYear(id:18)
        List<Student> result = studentService.findByPersonInAndStudentYears_Year(person, year);
        verify(studentRepository, times(1)).findByPersonInAndStudentYears_Year(person, year)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testFindByReferenceNoContainingIgnoreCaseAndStudentYears_Year() {
        AcademicYear year = new AcademicYear(id:18)
        List<Student> result = studentService.findByReferenceNoContainingIgnoreCaseAndStudentYears_Year('test', year);
        verify(studentRepository, times(1)).findByReferenceNoContainingIgnoreCaseAndStudentYears_Year('test', year)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testSave() {
        studentService.save(student);
        verify(studentRepository, times(1)).save(student)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testSaveList() {
        List<Student> savedStudents = studentService.saveStudents([student, student]);
        verify(studentRepository, times(2)).save(student)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testFindCurrentStudents() {
        List<Student> result = studentService.findCurrentStudents();
        verify(studentRepository, times(1)).findCurrent()
        verifyNoMoreInteractions(studentRepository)
    }
    
    //@Test
    public void testFindByYearAndTutorGroup() {
        List<Student> result = studentService.findByYearAndTutorGroup(19001, 1);
        verify(studentRepository, times(1)).findByAcademicYear_IdAndTutorGroup_Id(19001, 1)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testFindStudentsInYear() {
        AcademicYear year = new AcademicYear(id:18)
        List<Student> result = studentService.findStudentsInYear(year);
        verify(studentRepository, times(1)).findAllByStudentYears_Year()
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateStudentRemarkPermission() {
        Student student = new Student(id:19001)
        StudentRemarkPermission studentRemarkPermission = new StudentRemarkPermission(id: 1)
        Student result = studentService.updateStudentRemarkPermission(student, studentRemarkPermission);
        verify(studentRepository, times(1)).save(any(Student.class))
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentService.delete(student)
        verifyNoMoreInteractions(studentRepository)
        assertThatExceptionOfType(InvalidOperationException.class)
    }
    
    @Test
    public void testUpdateCollegeFundPaid() {
        Student student = new Student(id:19001)
        CollegeFundPaid collegeFundPaid = new CollegeFundPaid(id: 1)
        Student result = studentService.updateCollegeFundPaid(student, collegeFundPaid, 1);
        verify(studentRepository, times(1)).save(any(Student.class))
        verifyNoMoreInteractions(studentRepository)
    }
    
    //@Test
    public void testFindByTutorGroup() {
        AcademicYear year = new AcademicYear(id:18)
        TutorGroup tutorGroup = new TutorGroup(id: 1)
        List<Student> result = studentService.findByTutorGroup(year, tutorGroup);
        verify(studentRepository, times(1)).findByStudentYears_Year_IdAndTutorGroup_Id(year.id, tutorGroup.id)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update student from null object.")
        StudentDto dto = null
        studentService.updateFromDto(dto)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_NullAdmissionDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentAdmission from null object.")
        StudentAdmissionDto dto = null
        studentService.updateFromAdmissionDto(dto)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullIdDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update student from null Id.")
        StudentDto dto = new StudentDto(referenceNo: '19001')
        studentService.updateFromDto(dto)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_NullAdmissionIdDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentAdmission from null Id.")
        StudentAdmissionDto dto = new StudentAdmissionDto(admissionsNotes: '19001')
        studentService.updateFromAdmissionDto(dto)
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        StudentDto dto = createDto()
        dto.riskLevelId = null
        dto.studentRemarkPermissionId = null
        studentService.updateFromDto(dto)
        verify(studentRepository, times(1)).findById(student.id)
        verify(studentRepository, times(1)).save(any(Student.class))
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRiskLevel() {
        StudentDto dto = createDto()
        dto.riskLevelId = 1
        when(riskLevelService.findById(dto.riskLevelId)).thenReturn(null);
        studentService.updateFromDto(dto)
        verify(riskLevelService, times(1)).findById(dto.riskLevelId)
        verifyNoMoreInteractions(riskLevelService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithPreviousSchool() {
        StudentDto dto = createDto()
        dto.previousSchoolId = 1
        when(schoolService.findById(dto.previousSchoolId)).thenReturn(null);
        studentService.updateFromDto(dto)
        verify(schoolService, times(1)).findById(dto.previousSchoolId)
        verifyNoMoreInteractions(schoolService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithEthnicity() {
        StudentDto dto = createDto()
        dto.ethnicityId = 1
        when(ethnicityService.findById(dto.ethnicityId)).thenReturn(null);
        studentService.updateFromDto(dto)
        verify(ethnicityService, times(1)).findById(dto.ethnicityId)
        verifyNoMoreInteractions(ethnicityService)
    }
    
    
    @Test
    public void testUpdateFromDto_dtoWithRestrictedUseIndicator() {
        StudentDto dto = createDto()
        dto.restrictedUseIndicatorId = 1
        when(restrictedUseIndicatorService.findById(dto.restrictedUseIndicatorId)).thenReturn(null);
        studentService.updateFromDto(dto)
        verify(restrictedUseIndicatorService, times(1)).findById(dto.restrictedUseIndicatorId)
        verifyNoMoreInteractions(restrictedUseIndicatorService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithllddHealthProblem() {
        StudentDto dto = createDto()
        dto.llddHealthProblemId = 1
        when(llddHealthProblemService.findById(dto.llddHealthProblemId)).thenReturn(null);
        studentService.updateFromDto(dto)
        verify(llddHealthProblemService, times(1)).findById(dto.llddHealthProblemId)
        verifyNoMoreInteractions(llddHealthProblemService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentRemarkPermission() {
        StudentDto dto = createDto()
        dto.studentRemarkPermissionId = 1
        when(studentRemarkPermissionService.findById(dto.studentRemarkPermissionId)).thenReturn(null);
        studentService.updateFromDto(dto)
        verify(studentRemarkPermissionService, times(1)).findById(dto.studentRemarkPermissionId)
        verifyNoMoreInteractions(studentRemarkPermissionService)
    }
    
    @Test
    public void testUpdateFromDto_AdmissionDto() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        studentService.updateFromAdmissionDto(dto)
        verify(studentRepository, times(1)).findById(student.id)
        verify(studentRepository, times(1)).save(any(Student.class))
        verifyNoMoreInteractions(studentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoInterviewer() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.interviewerId = 1
        when(staffService.findById(dto.interviewerId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(staffService, times(1)).findById(dto.interviewerId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoSchoolReportStatus() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.schoolReportStatusId = 1
        when(schoolReportStatusService.findById(dto.schoolReportStatusId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(schoolReportStatusService, times(1)).findById(dto.schoolReportStatusId)
        verifyNoMoreInteractions(schoolReportStatusService)
    }
    
    @Test
    public void testUpdateFromDto_dtoRestrictedUseIndicator() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.restrictedUseIndicatorId = 1
        when(restrictedUseIndicatorService.findById(dto.restrictedUseIndicatorId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(restrictedUseIndicatorService, times(1)).findById(dto.restrictedUseIndicatorId)
        verifyNoMoreInteractions(restrictedUseIndicatorService)
    }
    
    @Test
    public void testUpdateFromDto_dtoCollegeFundPaid() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.collegeFundPaidId = 1
        when(collegeFundPaidService.findById(dto.collegeFundPaidId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(collegeFundPaidService, times(1)).findById(dto.collegeFundPaidId)
        verifyNoMoreInteractions(collegeFundPaidService)
    }
    
    @Test
    public void testUpdateFromDto_dtoEthnicity() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.ethnicityId = 1
        when(ethnicityService.findById(dto.ethnicityId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(ethnicityService, times(1)).findById(dto.ethnicityId)
        verifyNoMoreInteractions(ethnicityService)
    }
    
    @Test
    public void testUpdateFromDto_dtoOfferType() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.offerTypeId = 1
        when(offerTypeService.findById(dto.offerTypeId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(offerTypeService, times(1)).findById(dto.offerTypeId)
        verifyNoMoreInteractions(offerTypeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoStatus() {
        StudentAdmissionDto dto = new StudentAdmissionDto(id:190001)
        dto.statusId = 1
        when(applicationStatusService.findById(dto.statusId)).thenReturn(null);
        studentService.updateFromAdmissionDto(dto)
        verify(applicationStatusService, times(1)).findById(dto.statusId)
        verifyNoMoreInteractions(applicationStatusService)
    }
}