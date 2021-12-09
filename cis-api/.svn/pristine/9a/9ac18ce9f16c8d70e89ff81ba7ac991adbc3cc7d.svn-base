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

import uk.ac.reigate.domain.academic.IdentificationViolation
import uk.ac.reigate.dto.IdentificationViolationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.IdentificationViolationRepository
import uk.ac.reigate.services.student.StudentService


class IdentificationViolationServiceTest {
    
    @Mock
    private IdentificationViolationRepository identificationViolationRepository;
    
    @Mock
    private AcademicYearService academicYearService
    
    @Mock
    private StudentService studentService
    
    @InjectMocks
    private IdentificationViolationService identificationViolationService;
    
    private IdentificationViolation identificationViolation
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample IdentificationViolation data object to use for the testing
     * 
     * @return a sample IdentificationViolation data object
     */
    IdentificationViolation createIdentificationViolation() {
        return new IdentificationViolation(
                id: 1,
                returned : true,
                printed: true
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample IdentificationViolation created at setup
     * 
     * @return a IdentificationViolationDto object based on the sample IdentificationViolation
     */
    IdentificationViolationDto createDto() {
        IdentificationViolation sampleData = createIdentificationViolation()
        return new IdentificationViolationDto(
                id: sampleData.id,
                returned: sampleData.returned,
                printed: sampleData.printed
                )
    }
    
    /**
     * This method is used to set up the tests for the IdentificationViolationService
     */
    @Before
    public void setup() {
        this.identificationViolationRepository = mock(IdentificationViolationRepository.class);
        this.academicYearService = mock(AcademicYearService.class);
        studentService = mock(StudentService.class);
        this.identificationViolationService = new IdentificationViolationService(identificationViolationRepository, academicYearService, studentService);
        
        identificationViolation = createIdentificationViolation()
        
        when(identificationViolationRepository.save(any(IdentificationViolation.class))).thenReturn(identificationViolation);
        when(identificationViolationRepository.findById(1)).thenReturn(new Optional(identificationViolation));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        IdentificationViolationService service = new IdentificationViolationService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<IdentificationViolation> result = identificationViolationService.findAll();
        verify(identificationViolationRepository, times(1)).findAll()
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        List<IdentificationViolation> result = identificationViolationService.findByStudentId(19001);
        verify(identificationViolationRepository, times(1)).findByStudentId(19001)
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        IdentificationViolation result = identificationViolationService.findById(1);
        verify(identificationViolationRepository, times(1)).findById(1)
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        IdentificationViolation savedIdentificationViolation = identificationViolationService.save(identificationViolation);
        verify(identificationViolationRepository, times(1)).save(any())
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<IdentificationViolation> savedIdentificationViolations = identificationViolationService.saveIdentificationViolations([
            identificationViolation,
            identificationViolation
        ]);
        verify(identificationViolationRepository, times(2)).save(identificationViolation)
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        IdentificationViolationDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        identificationViolationService.convert(dto)
        verify(identificationViolationRepository, times(1)).save(any(IdentificationViolation.class))
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithNullYearId() {
        IdentificationViolationDto dto = createDto()
        dto.yearId = null
        when(academicYearService.getCurrentAcademicYear()).thenReturn(null);
        identificationViolationService.convert(dto)
        verify(identificationViolationRepository, times(1)).save(any(IdentificationViolation.class))
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearId() {
        IdentificationViolationDto dto = createDto()
        dto.yearId = 19001
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        identificationViolationService.convert(dto)
        verify(identificationViolationRepository, times(1)).save(any(IdentificationViolation.class))
        verifyNoMoreInteractions(identificationViolationRepository)
    }
    
    @Test
    public void testDelete() {
        identificationViolationService.delete(new IdentificationViolation(id: 1))
    }
}