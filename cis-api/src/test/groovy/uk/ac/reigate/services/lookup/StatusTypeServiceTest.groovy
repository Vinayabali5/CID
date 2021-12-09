package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.exams.edi.StatusType
import uk.ac.reigate.dto.exams.edi.StatusTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.StatusTypeRepository


class StatusTypeServiceTest {
    
    @Mock
    private StatusTypeRepository statusTypeRepository;
    
    @InjectMocks
    private StatusTypeService statusTypeService;
    
    private StatusType statusType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample StatusType data object to use for the testing
     * 
     * @return a sample StatusType data object
     */
    StatusType createStatusType() {
        return new StatusType(
                id: 1,
                code: 'A',
                description: 'Active'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample StatusType created at setup
     * 
     * @return a StatusTypeDto object based on the sample StatusType
     */
    StatusTypeDto createDto() {
        return new StatusTypeDto(
                id: statusType.id,
                code: statusType.code,
                description: statusType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the StatusTypeService
     */
    @Before
    public void setup() {
        this.statusTypeRepository = Mockito.mock(StatusTypeRepository.class);
        this.statusTypeService = new StatusTypeService(statusTypeRepository);
        
        statusType = createStatusType()
        
        when(statusTypeRepository.save(any(StatusType.class))).thenReturn(statusType);
        when(statusTypeRepository.findById(1)).thenReturn(new Optional(statusType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StatusTypeService service = new StatusTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<StatusType> result = statusTypeService.findAll();
        verify(statusTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(statusTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        StatusType result = statusTypeService.findById(1);
        verify(statusTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(statusTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StatusType savedStatusType = statusTypeService.save(statusType);
        verify(statusTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(statusTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<StatusType> savedStatusTypes = statusTypeService.saveStatusTypes([statusType, statusType]);
        verify(statusTypeRepository, times(2)).save(statusType)
        verifyNoMoreInteractions(statusTypeRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StatusTypeDto dto = createDto()
        StatusType statusTypeSaved = statusTypeService.updateFromDto(dto)
        verify(statusTypeRepository, times(1)).findById(statusType.id)
        verify(statusTypeRepository, times(1)).save(statusType)
        verifyNoMoreInteractions(statusTypeRepository)
        assertEquals(statusType.id, statusTypeSaved.id)
        assertEquals(statusType.code, statusTypeSaved.code)
        assertEquals(statusType.description, statusTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StatusTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        StatusType statusTypeSaved = statusTypeService.updateFromDto(dto)
        verify(statusTypeRepository, times(1)).findById(statusType.id)
        verify(statusTypeRepository, times(1)).save(statusType)
        verifyNoMoreInteractions(statusTypeRepository)
        assertEquals(statusType.id, statusTypeSaved.id)
        assertEquals(statusType.code, statusTypeSaved.code)
        assertEquals(statusType.description, statusTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update statusType from null object.")
        StatusTypeDto dto = null
        statusTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(statusTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        statusTypeService.delete(statusType)
        verifyNoMoreInteractions(statusTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}