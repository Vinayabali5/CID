package uk.ac.reigate.services.risk_assessment;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentRiskLevel
import uk.ac.reigate.dto.risk_assessment.StudentRiskLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.StudentRiskLevelRepository
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService


public class StudentRiskLevelServiceTest {
    
    @Mock
    private StudentRiskLevelRepository studentRiskLevelRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private RiskLevelService riskLevelService;
    
    @InjectMocks
    private StudentRiskLevelService studentRiskLevelService;
    
    private StudentRiskLevel studentRiskLevel
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    StudentRiskLevel createStudentRiskLevel() {
        return new StudentRiskLevel(
                id: 1,
                student: new Student(id:19001),
                evidence: true
                )
    }
    
    StudentRiskLevelDto createDto() {
        StudentRiskLevel sampleStudentRiskLevel = createStudentRiskLevel()
        return new StudentRiskLevelDto(
                id: sampleStudentRiskLevel.id,
                studentId: sampleStudentRiskLevel.student.id,
                evidence: sampleStudentRiskLevel.evidence
                )
    }
    
    @Before
    public void setup() {
        studentRiskLevelRepository = mock(StudentRiskLevelRepository.class);
        studentService = mock(StudentService.class);
        staffService = mock(StaffService.class);
        riskLevelService = mock(RiskLevelService.class);
        studentRiskLevelService = new StudentRiskLevelService(studentRiskLevelRepository, studentService, staffService, riskLevelService);
        
        studentRiskLevel = createStudentRiskLevel()
        when(studentRiskLevelRepository.findById(1)).thenReturn(new Optional(new StudentRiskLevel()));
    }
    
    /**
     * This metcompleteByStaff is used to test the Default NoArgs constructor service metcompleteByStaff
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentRiskLevelService service = new StudentRiskLevelService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentRiskLevel> result = studentRiskLevelService.findAll();
        verify(studentRiskLevelRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testFindById() {
        StudentRiskLevel result = studentRiskLevelService.findById(1);
        verify(studentRiskLevelRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        StudentRiskLevel result = studentRiskLevelService.getByStudentId(2);
        verify(studentRiskLevelRepository, times(1)).findByStudent_Id(2)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testFindByStudentAll() {
        StudentRiskLevel result = studentRiskLevelService.getByStudentAll(2);
        verify(studentRiskLevelRepository, times(1)).findByStudent_Id(2)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testFindByStudent() {
        Student student = new Student(id:19001)
        StudentRiskLevel result = studentRiskLevelService.getByStudent(student);
        verify(studentRiskLevelRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testSave() {
        studentRiskLevel.id = null
        studentRiskLevelService.save(studentRiskLevel);
        verify(studentRiskLevelRepository, times(1)).save(studentRiskLevel)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testSaveStudentRiskLevel() {
        studentRiskLevelService.save(studentRiskLevel);
        verify(studentRiskLevelRepository, times(1)).save(studentRiskLevel)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StudentRiskLevelDto dto = createDto()
        studentRiskLevelService.createFromDto(dto)
        verify(studentRiskLevelRepository, times(1)).save(any(StudentRiskLevel.class))
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentRiskLevelDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        studentRiskLevelService.createFromDto(dto)
        verify(studentRiskLevelRepository, times(1)).save(any(StudentRiskLevel.class))
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithRiskLevelId() {
        StudentRiskLevelDto dto = createDto()
        dto.riskLevelId = 1
        when(riskLevelService.findById(dto.staffRequestingId)).thenReturn(null);
        studentRiskLevelService.createFromDto(dto)
        verify(studentRiskLevelRepository, times(1)).save(any(StudentRiskLevel.class))
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStaffId() {
        StudentRiskLevelDto dto = createDto()
        dto.staffRequestingId = 1
        when(staffService.findById(dto.staffRequestingId)).thenReturn(null);
        studentRiskLevelService.createFromDto(dto)
        verify(studentRiskLevelRepository, times(1)).save(any(StudentRiskLevel.class))
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullStudentDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create without studentId.")
        StudentRiskLevelDto dto = new StudentRiskLevelDto(evidence: false)
        dto.studentId = null
        studentRiskLevelService.createFromDto(dto)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentRiskLevel from null object.")
        StudentRiskLevelDto dto = null
        studentRiskLevelService.createFromDto(dto)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentRiskLevel from null object.")
        StudentRiskLevelDto dto = null
        studentRiskLevelService.updateFromDto(dto)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentRiskLevelDto dto = createDto()
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        studentRiskLevelService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStaffId() {
        StudentRiskLevelDto dto = createDto()
        dto.staffRequestingId = 1
        when(staffService.findById(dto.staffRequestingId)).thenReturn(null);
        // Initialise Test
        studentRiskLevelService.updateFromDto(dto)
        // Verify Results
        verify(staffService, times(1)).findById(dto.staffRequestingId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithRiskLevelId() {
        StudentRiskLevelDto dto = createDto()
        dto.riskLevelId = 1
        when(staffService.findById(dto.riskLevelId)).thenReturn(null);
        // Initialise Test
        studentRiskLevelService.updateFromDto(dto)
        // Verify Results
        verify(riskLevelService, times(1)).findById(dto.riskLevelId)
        verifyNoMoreInteractions(riskLevelService)
    }
    
    /**
     * This metcompleteByStaff is used to test the delete service metcompleteByStaff
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentRiskLevelService.delete(studentRiskLevel)
        verifyNoMoreInteractions(studentRiskLevelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testDeleteId() {
        studentRiskLevelService.delete(1)
        verify(studentRiskLevelRepository, times(1)).deleteById(1)
        verifyNoMoreInteractions(studentRiskLevelRepository)
    }
}
