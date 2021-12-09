package uk.ac.reigate.services.risk_assessment;

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentSafetyPlan
import uk.ac.reigate.dto.risk_assessment.StudentSafetyPlanDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.StudentSafetyPlanRepository
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

public class StudentSafetyPlanServiceTest {
    
    @Mock
    private StudentSafetyPlanRepository studentSafetyPlanRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private RiskLevelService riskLevelService;
    
    @InjectMocks
    private StudentSafetyPlanService studentSafetyPlanService;
    
    private StudentSafetyPlan studentSafetyPlan
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentSafetyPlan createStudentSafetyPlan() {
        return new StudentSafetyPlan(
                id: 1,
                student: new Student(id:19001),
                howToReduceRiskAtHome: 'stayHome'
                )
    }
    
    StudentSafetyPlanDto createDto() {
        StudentSafetyPlan sampleStudentSafetyPlan = createStudentSafetyPlan()
        return new StudentSafetyPlanDto(
                id: sampleStudentSafetyPlan.id,
                studentId: sampleStudentSafetyPlan.student.id,
                howToReduceRiskAtHome: sampleStudentSafetyPlan.howToReduceRiskAtHome
                )
    }
    
    @Before
    public void setup() {
        studentSafetyPlanRepository = mock(StudentSafetyPlanRepository.class);
        studentService = mock(StudentService.class);
        staffService = mock(StaffService.class);
        studentSafetyPlanService = new StudentSafetyPlanService(studentSafetyPlanRepository, studentService, staffService);
        
        studentSafetyPlan = createStudentSafetyPlan()
        when(studentSafetyPlanRepository.findById(1)).thenReturn(new Optional(new StudentSafetyPlan()));
    }
    
    /**
     * This metcompleteByStaff is used to test the Default NoArgs constructor service metcompleteByStaff
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentSafetyPlanService service = new StudentSafetyPlanService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentSafetyPlan> result = studentSafetyPlanService.findAll();
        verify(studentSafetyPlanRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testFindById() {
        StudentSafetyPlan result = studentSafetyPlanService.findStudentSafetyPlan(1);
        verify(studentSafetyPlanRepository, times(1)).findByStudent_Id(1)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        StudentSafetyPlan result = studentSafetyPlanService.findByStudent(2);
        verify(studentSafetyPlanRepository, times(1)).findByStudent_Id(2)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    
    @Test
    public void testSave() {
        studentSafetyPlan.id = null
        studentSafetyPlanService.save(studentSafetyPlan);
        verify(studentSafetyPlanRepository, times(1)).save(studentSafetyPlan)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testSaveStudentSafetyPlan() {
        studentSafetyPlanService.save(studentSafetyPlan);
        verify(studentSafetyPlanRepository, times(1)).save(studentSafetyPlan)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentSafetyPlanDto dto = createDto()
        dto.studentId = 19001
        dto.completedWithId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        when(staffService.findById(dto.completedWithId)).thenReturn(null);
        studentSafetyPlanService.createFromDto(dto)
        verify(studentSafetyPlanRepository, times(1)).save(any(StudentSafetyPlan.class))
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullStudentDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentSafetyPlan without studentId")
        StudentSafetyPlanDto dto = new StudentSafetyPlanDto(howToReduceRiskAtHome: 'test')
        dto.studentId = null
        studentSafetyPlanService.createFromDto(dto)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullStudentDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentSafetyPlan without studentId")
        StudentSafetyPlanDto dto = new StudentSafetyPlanDto(howToReduceRiskAtHome: 'test')
        dto.studentId = null
        studentSafetyPlanService.updateFromDto(dto)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentSafetyPlan from null object.")
        StudentSafetyPlanDto dto = null
        studentSafetyPlanService.createFromDto(dto)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentSafetyPlan from null object.")
        StudentSafetyPlanDto dto = null
        studentSafetyPlanService.updateFromDto(dto)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentSafetyPlanDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentSafetyPlanService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStaffId() {
        StudentSafetyPlanDto dto = createDto()
        dto.studentId = 19001
        dto.completedWithId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        when(staffService.findById(dto.completedWithId)).thenReturn(null);
        // Initialise Test
        studentSafetyPlanService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verify(staffService, times(1)).findById(dto.completedWithId)
        verifyNoMoreInteractions(studentService)
        verifyNoMoreInteractions(staffService)
    }
    
    /**
     * This metcompleteByStaff is used to test the delete service metcompleteByStaff
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentSafetyPlanService.delete(studentSafetyPlan)
        verifyNoMoreInteractions(studentSafetyPlanRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}
