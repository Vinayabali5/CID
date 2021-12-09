package uk.ac.reigate.services.admissions

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

import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.dto.admissions.ApplicationStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.ApplicationStatusRepository


class ApplicationStatusServiceTest {
    
    @Mock
    private ApplicationStatusRepository applicationStatusRepository;
    
    @InjectMocks
    private ApplicationStatusService applicationStatusService;
    
    private ApplicationStatus applicationStatus
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample ApplicationStatus data object to use for the testing
     * 
     * @return a sample ApplicationStatus data object
     */
    ApplicationStatus createApplicationStatus() {
        return new ApplicationStatus(
                id: 1,
                code: 'A',
                description: 'Active',
                considerWithdrawn: true,
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample ApplicationStatus created at setup
     * 
     * @return a ApplicationStatusDto object based on the sample ApplicationStatus
     */
    ApplicationStatusDto createDto() {
        return new ApplicationStatusDto(
                id: applicationStatus.id,
                code: applicationStatus.code,
                description: applicationStatus.description,
                considerWithdrawn: applicationStatus.considerWithdrawn
                )
    }
    
    /**
     * This method is used to set up the tests for the ApplicationStatusService
     */
    @Before
    public void setup() {
        this.applicationStatusRepository = Mockito.mock(ApplicationStatusRepository.class);
        this.applicationStatusService = new ApplicationStatusService(applicationStatusRepository);
        
        applicationStatus = createApplicationStatus()
        
        when(applicationStatusRepository.save(any(ApplicationStatus.class))).thenReturn(applicationStatus);
        when(applicationStatusRepository.findById(1)).thenReturn(new Optional(applicationStatus));
        when(applicationStatusRepository.findByDescription(applicationStatus.description)).thenReturn(applicationStatus);
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ApplicationStatusService service = new ApplicationStatusService();
        assertNotNull(service)
    }    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<ApplicationStatus> result = applicationStatusService.findAll();
        verify(applicationStatusRepository, times(1)).findAll()
        verifyNoMoreInteractions(applicationStatusRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        ApplicationStatus result = applicationStatusService.findById(1);
        verify(applicationStatusRepository, times(1)).findById(1)
        verifyNoMoreInteractions(applicationStatusRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        ApplicationStatus savedApplicationStatus = applicationStatusService.save(applicationStatus);
        verify(applicationStatusRepository, times(1)).save(any())
        verifyNoMoreInteractions(applicationStatusRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<ApplicationStatus> savedApplicationStatuss = applicationStatusService.saveList([
            applicationStatus,
            applicationStatus
        ]);
        verify(applicationStatusRepository, times(2)).save(applicationStatus)
        verifyNoMoreInteractions(applicationStatusRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        ApplicationStatusDto dto = createDto()
        ApplicationStatus applicationStatusSaved = applicationStatusService.createFromDto(dto)
        verify(applicationStatusRepository, times(1)).save(any(ApplicationStatus.class))
        verifyNoMoreInteractions(applicationStatusRepository)
        assertEquals(dto.id, applicationStatus.id)
        assertEquals(dto.code, applicationStatus.code)
        assertEquals(dto.description, applicationStatus.description)
        assertEquals(dto.considerWithdrawn, applicationStatus.considerWithdrawn)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create applicationStatus from null object.")
        ApplicationStatusDto dto = null
        applicationStatusService.createFromDto(dto)
        verifyNoMoreInteractions(applicationStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        ApplicationStatusDto dto = createDto()
        ApplicationStatus applicationStatusSaved = applicationStatusService.updateFromDto(dto)
        verify(applicationStatusRepository, times(1)).findById(applicationStatus.id)
        verify(applicationStatusRepository, times(1)).save(applicationStatus)
        verifyNoMoreInteractions(applicationStatusRepository)
        assertEquals(applicationStatus.id, applicationStatusSaved.id)
        assertEquals(applicationStatus.code, applicationStatusSaved.code)
        assertEquals(applicationStatus.description, applicationStatusSaved.description)
        assertEquals(applicationStatus.considerWithdrawn, applicationStatusSaved.considerWithdrawn)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        ApplicationStatusDto dto = createDto()
        dto.code = null
        dto.description = null
        ApplicationStatus applicationStatusSaved = applicationStatusService.updateFromDto(dto)
        verify(applicationStatusRepository, times(1)).findById(applicationStatus.id)
        verify(applicationStatusRepository, times(1)).save(applicationStatus)
        verifyNoMoreInteractions(applicationStatusRepository)
        assertEquals(applicationStatus.id, applicationStatusSaved.id)
        assertEquals(applicationStatus.code, applicationStatusSaved.code)
        assertEquals(applicationStatus.description, applicationStatusSaved.description)
        assertEquals(applicationStatus.considerWithdrawn, applicationStatusSaved.considerWithdrawn)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update applicationStatus from null object.")
        ApplicationStatusDto dto = null
        applicationStatusService.updateFromDto(dto)
        verifyNoMoreInteractions(applicationStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        applicationStatusService.delete(applicationStatus)
        verifyNoMoreInteractions(applicationStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        ApplicationStatus result = applicationStatusService.findByDescription(applicationStatus.description)
        verify(applicationStatusRepository, times(1)).findByDescription(applicationStatus.description)
        verifyNoMoreInteractions(applicationStatusRepository)
    }
}

