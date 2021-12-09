package uk.ac.reigate.services.risk_assessment;

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentRiskAssessment
import uk.ac.reigate.dto.risk_assessment.StudentRiskAssessmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.StudentRiskAssessmentRepository
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*


public class StudentRiskAssessmentServiceTest {
    
    @Mock
    private StudentRiskAssessmentRepository studentRiskAssessmentRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private StaffService completeByStaffService;
    
    @InjectMocks
    private StudentRiskAssessmentService studentRiskAssessmentService;
    
    private StudentRiskAssessment studentRiskAssessment
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentRiskAssessment createStudentRiskAssessment() {
        return new StudentRiskAssessment(
                id: 1,
                student: new Student(id:200001),
                riskToOtherStudents: 'A',
                riskToStaff: 'Arts StudentRiskAssessment'
                )
    }
    
    StudentRiskAssessmentDto createDto() {
        StudentRiskAssessment sampleStudentRiskAssessment = createStudentRiskAssessment()
        return new StudentRiskAssessmentDto(
                id: sampleStudentRiskAssessment.id,
                studentId: sampleStudentRiskAssessment.student.id,
                riskToOtherStudents: sampleStudentRiskAssessment.riskToOtherStudents,
                riskToStaff: sampleStudentRiskAssessment.riskToStaff
                )
    }
    
    @Before
    public void setup() {
        studentRiskAssessmentRepository = mock(StudentRiskAssessmentRepository.class);
        studentService = mock(StudentService.class);
        completeByStaffService = mock(StaffService.class);
        
        studentRiskAssessmentService = new StudentRiskAssessmentService(studentRiskAssessmentRepository, studentService, completeByStaffService);
        
        studentRiskAssessment = createStudentRiskAssessment()
        when(studentRiskAssessmentRepository.findById(1)).thenReturn(new Optional(new StudentRiskAssessment()));
    }
    
    /**
     * This metcompleteByStaff is used to test the Default NoArgs constructor service metcompleteByStaff
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentRiskAssessmentService service = new StudentRiskAssessmentService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentRiskAssessment> result = studentRiskAssessmentService.findAll();
        verify(studentRiskAssessmentRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testFindById() {
        StudentRiskAssessment result = studentRiskAssessmentService.findStudentRiskAssessment(1);
        verify(studentRiskAssessmentRepository, times(1)).findByStudent_Id(1)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testFindByStudent() {
        StudentRiskAssessment result = studentRiskAssessmentService.findByStudent(2);
        verify(studentRiskAssessmentRepository, times(1)).findByStudent_Id(2)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testSave() {
        studentRiskAssessment.id = null
        studentRiskAssessmentService.save(studentRiskAssessment);
        verify(studentRiskAssessmentRepository, times(1)).save(studentRiskAssessment)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testSaveStudentRiskAssessment() {
        studentRiskAssessmentService.save(studentRiskAssessment);
        verify(studentRiskAssessmentRepository, times(1)).save(studentRiskAssessment)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentRiskAssessmentDto dto = createDto()
        studentRiskAssessmentService.createFromDto(dto)
        verify(studentRiskAssessmentRepository, times(1)).save(any(StudentRiskAssessment.class))
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentRiskAssessmentDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentRiskAssessmentService.createFromDto(dto)
        verify(studentRiskAssessmentRepository, times(1)).save(any(StudentRiskAssessment.class))
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithHodId() {
        StudentRiskAssessmentDto dto = createDto()
        dto.completeByStaffId = 1
        when(completeByStaffService.findById(dto.completeByStaffId)).thenReturn(null);
        studentRiskAssessmentService.createFromDto(dto)
        verify(studentRiskAssessmentRepository, times(1)).save(any(StudentRiskAssessment.class))
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullStudentDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentRiskAssessment from null studentId")
        StudentRiskAssessmentDto dto = new StudentRiskAssessmentDto(actionsToMinimiseRisk:'test')
        dto.studentId = null
        studentRiskAssessmentService.createFromDto(dto)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentRiskAssessment from null object.")
        StudentRiskAssessmentDto dto = null
        studentRiskAssessmentService.createFromDto(dto)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentRiskAssessment from null object.")
        StudentRiskAssessmentDto dto = null
        studentRiskAssessmentService.updateFromDto(dto)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentRiskAssessmentDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentRiskAssessmentService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStaffId() {
        StudentRiskAssessmentDto dto = createDto()
        dto.completeByStaffId = 1
        when(completeByStaffService.findById(dto.completeByStaffId)).thenReturn(null);
        // Initialise Test
        studentRiskAssessmentService.updateFromDto(dto)
        // Verify Results
        verify(completeByStaffService, times(1)).findById(dto.completeByStaffId)
        verifyNoMoreInteractions(completeByStaffService)
    }
    
    /**
     * This metcompleteByStaff is used to test the delete service metcompleteByStaff
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentRiskAssessmentService.delete(studentRiskAssessment)
        verifyNoMoreInteractions(studentRiskAssessmentRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}
