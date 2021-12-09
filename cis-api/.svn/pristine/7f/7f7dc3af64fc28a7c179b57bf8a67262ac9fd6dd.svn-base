package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.academic.ExternalResultsArchive
import uk.ac.reigate.dto.ExternalResultsArchiveDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.ExternalResultsArchiveRepository
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.services.student.StudentService

@RunWith(MockitoJUnitRunner.class)
class ExternalResultsArchiveServiceTest {
    
    @Mock
    private ExternalResultsArchiveRepository externalResultsArchiveRepository;
    
    @Mock
    private StudentService studentService
    
    @InjectMocks
    private ExternalResultsArchiveService externalResultsArchiveService;
    
    private ExternalResultsArchive externalResultsArchive
    
    private StudentRepository studentRepository
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample ExternalResultsArchive data object to use for the testing
     * 
     * @return a sample ExternalResultsArchive data object
     */
    ExternalResultsArchive createExternalResultsArchive() {
        return new ExternalResultsArchive(
                id: 1,
                courseSpec: 'N',
                levelDescription: 'EntryQualification Type'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample ExternalResultsArchive created at setup
     * 
     * @return a ExternalResultsArchiveDto object based on the sample ExternalResultsArchive
     */
    ExternalResultsArchiveDto createDto() {
        ExternalResultsArchive sampleData = createExternalResultsArchive()
        return new ExternalResultsArchiveDto(
                id: sampleData.id,
                courseSpec: sampleData.courseSpec,
                levelDescription: sampleData.levelDescription
                )
    }
    
    /**
     * This method is used to set up the tests for the ExternalResultsArchiveService
     */
    @Before
    public void setup() {
        this.externalResultsArchiveRepository = Mockito.mock(ExternalResultsArchiveRepository.class);
        this.externalResultsArchiveService = new ExternalResultsArchiveService(externalResultsArchiveRepository, studentService);
        
        externalResultsArchive = createExternalResultsArchive()
        
        when(externalResultsArchiveRepository.save(any(ExternalResultsArchive.class))).thenReturn(externalResultsArchive);
        when(externalResultsArchiveRepository.findById(1)).thenReturn(new Optional(new ExternalResultsArchive()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ExternalResultsArchiveService service = new ExternalResultsArchiveService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<ExternalResultsArchive> result = externalResultsArchiveService.findAll();
        verify(externalResultsArchiveRepository, times(1)).findAll()
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        ExternalResultsArchive result = externalResultsArchiveService.findById(1);
        verify(externalResultsArchiveRepository, times(1)).findById(1)
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    @Test
    public void testGetByExternalResultsArchives() {
        ExternalResultsArchive result = externalResultsArchiveService.getByExternalResultsArchives(1, 10);
        verify(externalResultsArchiveRepository, times(1)).findByStudent_IdAndId(1, 10)
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    @Test
    public void testGetByStudent() {
        ExternalResultsArchive result = externalResultsArchiveService.getByStudent(19001);
        verify(externalResultsArchiveRepository, times(1)).findByStudent_Id(19001)
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        ExternalResultsArchive savedExternalResultsArchive = externalResultsArchiveService.save(externalResultsArchive);
        verify(externalResultsArchiveRepository, times(1)).save(any())
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create externalResultsArchiveDto from null object.")
        ExternalResultsArchiveDto dto = null
        externalResultsArchiveService.createFromDto(dto)
        verifyNoMoreInteractions(externalResultsArchiveRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testCreateFromDto_withDto() {
        ExternalResultsArchiveDto dto = createDto()
        dto.studentId = null
        externalResultsArchiveService.createFromDto(dto)
        verify(externalResultsArchiveRepository, times(1)).save(any(ExternalResultsArchive.class))
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    @Test
    public void testCreateFromDto_withStudentId() {
        ExternalResultsArchiveDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        externalResultsArchiveService.createFromDto(dto)
        verify(externalResultsArchiveRepository, times(1)).save(any(ExternalResultsArchive.class))
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update externalResultsArchiveDto from null object.")
        ExternalResultsArchiveDto dto = null
        externalResultsArchiveService.updateFromDto(dto)
        verifyNoMoreInteractions(externalResultsArchiveRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        ExternalResultsArchiveDto dto = createDto()
        dto.studentId = null
        externalResultsArchiveService.updateFromDto(dto)
        verify(externalResultsArchiveRepository, times(1)).findById(externalResultsArchive.id)
        verify(externalResultsArchiveRepository, times(1)).save(any(ExternalResultsArchive.class))
        verifyNoMoreInteractions(externalResultsArchiveRepository)
    }
    
    @Test
    public void testUpdateFromDto_withStudentId() {
        ExternalResultsArchiveDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        externalResultsArchiveService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        externalResultsArchiveService.delete(externalResultsArchive)
        verifyNoMoreInteractions(externalResultsArchiveRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}