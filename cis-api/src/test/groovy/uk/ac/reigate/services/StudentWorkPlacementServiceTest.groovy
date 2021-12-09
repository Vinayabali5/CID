package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

import uk.ac.reigate.domain.academic.StudentWorkPlacement
import uk.ac.reigate.dto.StudentWorkPlacementDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentWorkPlacementRepository
import uk.ac.reigate.services.student.StudentService


class StudentWorkPlacementServiceTest {
    
    @Mock
    private StudentWorkPlacementRepository studentWorkPlacementRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private WorkPlacementModeService workPlacementModeService;
    
    @InjectMocks
    private StudentWorkPlacementService studentWorkPlacementService;
    
    private StudentWorkPlacement studentWorkPlacement
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample StudentWorkPlacement data object to use for the testing
     * 
     * @return a sample StudentWorkPlacement data object
     */
    StudentWorkPlacement createStudentWorkPlacement() {
        return new StudentWorkPlacement(
                id: 1,
                extraDetails: 'Testing',
                employer: 'Reigate'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample StudentWorkPlacement created at setup
     * 
     * @return a StudentWorkPlacementDto object based on the sample StudentWorkPlacement
     */
    StudentWorkPlacementDto createDto() {
        return new StudentWorkPlacementDto(
                id: studentWorkPlacement.id,
                extraDetails: studentWorkPlacement.extraDetails,
                employer: studentWorkPlacement.employer
                )
    }
    
    /**
     * This method is used to set up the tests for the StudentWorkPlacementService
     */
    @Before
    public void setup() {
        studentWorkPlacementRepository = mock(StudentWorkPlacementRepository.class);
        studentService = mock(StudentService.class);
        workPlacementModeService = mock(WorkPlacementModeService.class);
        
        this.studentWorkPlacementService = new StudentWorkPlacementService(studentWorkPlacementRepository, studentService, workPlacementModeService);
        
        studentWorkPlacement = createStudentWorkPlacement()
        
        when(studentWorkPlacementRepository.save(any(StudentWorkPlacement.class))).thenReturn(studentWorkPlacement);
        when(studentWorkPlacementRepository.findById(1)).thenReturn(new Optional(studentWorkPlacement));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentWorkPlacementService service = new StudentWorkPlacementService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<StudentWorkPlacement> result = studentWorkPlacementService.findAll();
        verify(studentWorkPlacementRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        StudentWorkPlacement result = studentWorkPlacementService.findById(1);
        verify(studentWorkPlacementRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    @Test
    public void testFindByStudent() {
        StudentWorkPlacement result = studentWorkPlacementService.findByStudent(190001);
        verify(studentWorkPlacementRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    @Test
    public void testFindByStudents() {
        List<StudentWorkPlacement> result = studentWorkPlacementService.findByStudentId(190001);
        verify(studentWorkPlacementRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    @Test
    public void testFindByWorkPlacementTypeId() {
        List<StudentWorkPlacement> result = studentWorkPlacementService.findByWorkPlacementModeId(19);
        verify(studentWorkPlacementRepository, times(1)).findByWorkPlacementMode_Id(19)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StudentWorkPlacement savedStudentWorkPlacement = studentWorkPlacementService.save(studentWorkPlacement);
        verify(studentWorkPlacementRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        StudentWorkPlacementDto dto = createDto()
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.createFromDto(dto)
        verify(studentWorkPlacementRepository, times(1)).save(any(StudentWorkPlacement.class))
        verifyNoMoreInteractions(studentWorkPlacementRepository)
        assertEquals(dto.id, studentWorkPlacement.id)
        assertEquals(dto.extraDetails, studentWorkPlacement.extraDetails)
        assertEquals(dto.employer, studentWorkPlacement.employer)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        StudentWorkPlacementDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.createFromDto(dto)
        verify(studentWorkPlacementRepository, times(1)).save(any(StudentWorkPlacement.class))
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithWorkPlacementModeId() {
        StudentWorkPlacementDto dto = createDto()
        dto.workPlacementModeId = 19001
        when(workPlacementModeService.findById(dto.workPlacementModeId)).thenReturn(null);
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.createFromDto(dto)
        verify(studentWorkPlacementRepository, times(1)).save(any(StudentWorkPlacement.class))
        verifyNoMoreInteractions(studentWorkPlacementRepository)
    }
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentWorkPlacementDto from null object.")
        StudentWorkPlacementDto dto = null
        studentWorkPlacementService.createFromDto(dto)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StudentWorkPlacementDto dto = createDto()
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.updateFromDto(dto)
        verify(studentWorkPlacementRepository, times(1)).findById(studentWorkPlacement.id)
        verify(studentWorkPlacementRepository, times(1)).save(studentWorkPlacement)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
        assertEquals(studentWorkPlacement.id, studentWorkPlacementSaved.id)
        assertEquals(studentWorkPlacement.extraDetails, studentWorkPlacementSaved.extraDetails)
        assertEquals(studentWorkPlacement.employer, studentWorkPlacementSaved.employer)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        StudentWorkPlacementDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithWorkPlacementModeId() {
        StudentWorkPlacementDto dto = createDto()
        dto.workPlacementModeId = 19001
        when(workPlacementModeService.findById(dto.workPlacementModeId)).thenReturn(null);
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.updateFromDto(dto)
        verify(workPlacementModeService, times(1)).findById(dto.workPlacementModeId)
        verifyNoMoreInteractions(workPlacementModeService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StudentWorkPlacementDto dto = createDto()
        StudentWorkPlacement studentWorkPlacementSaved = studentWorkPlacementService.updateFromDto(dto)
        verify(studentWorkPlacementRepository, times(1)).findById(studentWorkPlacement.id)
        verify(studentWorkPlacementRepository, times(1)).save(studentWorkPlacement)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
        assertEquals(studentWorkPlacement.id, studentWorkPlacementSaved.id)
        assertEquals(studentWorkPlacement.extraDetails, studentWorkPlacementSaved.extraDetails)
        assertEquals(studentWorkPlacement.employer, studentWorkPlacementSaved.employer)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentWorkPlacementDto from null object.")
        StudentWorkPlacementDto dto = null
        studentWorkPlacementService.updateFromDto(dto)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentWorkPlacementService.delete(studentWorkPlacement)
        verifyNoMoreInteractions(studentWorkPlacementRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}