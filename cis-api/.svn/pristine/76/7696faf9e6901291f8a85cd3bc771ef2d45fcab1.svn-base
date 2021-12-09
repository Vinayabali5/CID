package uk.ac.reigate.services

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

import uk.ac.reigate.domain.lookup.CentralMonitoring
import uk.ac.reigate.dto.CentralMonitoringDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.CentralMonitoringRepository
import uk.ac.reigate.util.exception.IdMissingException


class CentralMonitoringServiceTest {
    
    @Mock
    private CentralMonitoringRepository centralMonitoringRepository;
    
    @InjectMocks
    private CentralMonitoringService centralMonitoringService;
    
    private CentralMonitoring centralMonitoring
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample CentralMonitoring data object to use for the testing
     *
     * @return a sample CentralMonitoring data object
     */
    CentralMonitoring createCentralMonitoring() {
        return new CentralMonitoring(
                id: 99,
                code: 'G',
                description: 'Good',
                warningColour: 'red'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample centralMonitoring created at setup
     *
     * @return a centralMonitoringDto object based on the sample centralMonitoring
     */
    CentralMonitoringDto createDto() {
        return new CentralMonitoringDto(
                id: centralMonitoring.id,
                code: centralMonitoring.code,
                description: centralMonitoring.description,
                warningColour: centralMonitoring.warningColour
                )
    }
    
    /**
     * This method is used to set up the tests for the CentralMonitoringService
     */
    @Before
    public void setup() {
        this.centralMonitoringRepository = Mockito.mock(CentralMonitoringRepository.class);
        this.centralMonitoringService = new CentralMonitoringService(centralMonitoringRepository);
        
        centralMonitoring = createCentralMonitoring()
        
        when(centralMonitoringRepository.save(any(CentralMonitoring.class))).thenReturn(centralMonitoring);
        when(centralMonitoringRepository.findById(centralMonitoring.id)).thenReturn(new Optional(centralMonitoring));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CentralMonitoringService service = new CentralMonitoringService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<CentralMonitoring> result = centralMonitoringService.findAll();
        verify(centralMonitoringRepository, times(1)).findAll()
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        CentralMonitoring result = centralMonitoringService.findById(1);
        verify(centralMonitoringRepository, times(1)).findById(1)
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        CentralMonitoring savedCentralMonitoring = centralMonitoringService.save(new CentralMonitoring());
        verify(centralMonitoringRepository, times(1)).save(any())
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveCentralMonitorings() {
        List<CentralMonitoring> savedCentralMonitorings = centralMonitoringService.saveCentralMonitorings([
            new CentralMonitoring(id: 1),
            new CentralMonitoring(id: 2)
        ]);
        verify(centralMonitoringRepository, times(2)).save(any(CentralMonitoring.class))
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create CentralMonitoring from null object.")
        CentralMonitoringDto dto = null
        centralMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CentralMonitoringDto dto = new CentralMonitoringDto(id: 1, code: '123', description: 'Year 123')
        centralMonitoringService.createFromDto(dto)
        verify(centralMonitoringRepository, times(1)).findById(1)
        verify(centralMonitoringRepository, times(1)).save(any(CentralMonitoring.class))
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoForExisting() {
        thrown.expect(IdMissingException.class)
        thrown.expectMessage("A centralMonitoring already exist with this ID.")
        CentralMonitoringDto dto = new CentralMonitoringDto(id: 99, code: '99', description: 'Year 99')
        centralMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CentralMonitoringDto dto = createDto()
        centralMonitoringService.updateFromDto(dto)
        verify(centralMonitoringRepository, times(1)).findById(centralMonitoring.id)
        verify(centralMonitoringRepository, times(1)).save(any(CentralMonitoring.class))
        verifyNoMoreInteractions(centralMonitoringRepository)
        assertEquals(dto.id, centralMonitoring.id)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update centralMonitoring from null object.")
        CentralMonitoringDto dto = null
        centralMonitoringService.updateFromDto(dto)
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method with null Id
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update centralMonitoring when the ID is null.")
        CentralMonitoringDto dto = new CentralMonitoringDto(code: '123', description: 'cane hill')
        centralMonitoringService.updateFromDto(dto)
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method for existing
     */
    @Test
    public void testUpdateFromDto_dtoForExisting() {
        thrown.expect(IdMissingException.class)
        thrown.expectMessage("A centralMonitoring already exist with this ID.")
        CentralMonitoringDto dto = new CentralMonitoringDto(id: 99, code: "99", description: "Year 99")
        centralMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(centralMonitoringRepository)
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("CentralMonitoring should not be deleted.")
        centralMonitoringService.delete(new CentralMonitoring(id: 1))
    }
}

