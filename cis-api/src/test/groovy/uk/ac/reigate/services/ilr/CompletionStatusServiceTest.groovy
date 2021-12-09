package uk.ac.reigate.services.ilr

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.ilr.CompletionStatus
import uk.ac.reigate.dto.ilr.CompletionStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.CompletionStatusRepository


class CompletionStatusServiceTest {
    
    @Mock
    private CompletionStatusRepository completionStatusRepository;
    
    @InjectMocks
    private CompletionStatusService completionStatusService;
    
    private CompletionStatus completionStatus
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample CompletionStatus data object to use for the testing
     * 
     * @return a sample CompletionStatus data object
     */
    CompletionStatus createCompletionStatus() {
        return new CompletionStatus(
                id: 1,
                code: 'N',
                description: 'New',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample CompletionStatus created at setup
     * 
     * @return a CompletionStatusDto object based on the sample CompletionStatus
     */
    CompletionStatusDto createDto() {
        return new CompletionStatusDto(
                id: completionStatus.id,
                code: completionStatus.code,
                description: completionStatus.description,
                shortDescription: completionStatus.shortDescription,
                validFrom: completionStatus.validFrom,
                validTo: completionStatus.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the CompletionStatusService
     */
    @Before
    public void setup() {
        this.completionStatusRepository = Mockito.mock(CompletionStatusRepository.class);
        this.completionStatusService = new CompletionStatusService(completionStatusRepository);
        
        completionStatus = createCompletionStatus()
        
        when(completionStatusRepository.save(any(CompletionStatus.class))).thenReturn(completionStatus);
        when(completionStatusRepository.findById(1)).thenReturn(new Optional(completionStatus));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CompletionStatusService service = new CompletionStatusService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<CompletionStatus> result = completionStatusService.findAll();
        verify(completionStatusRepository, times(1)).findAll()
        verifyNoMoreInteractions(completionStatusRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        CompletionStatus result = completionStatusService.findById(1);
        verify(completionStatusRepository, times(1)).findById(1)
        verifyNoMoreInteractions(completionStatusRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        CompletionStatus savedCompletionStatus = completionStatusService.save(completionStatus);
        verify(completionStatusRepository, times(1)).save(any())
        verifyNoMoreInteractions(completionStatusRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<CompletionStatus> savedCompletionStatuss = completionStatusService.saveCompletionStatuses([
            completionStatus,
            completionStatus
        ]);
        verify(completionStatusRepository, times(2)).save(completionStatus)
        verifyNoMoreInteractions(completionStatusRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CompletionStatusDto dto = createDto()
        CompletionStatus completionStatusSaved = completionStatusService.createFromDto(dto)
        verify(completionStatusRepository, times(1)).save(any(CompletionStatus.class))
        verifyNoMoreInteractions(completionStatusRepository)
        assertEquals(dto.id, completionStatus.id)
        assertEquals(dto.code, completionStatus.code)
        assertEquals(dto.description, completionStatus.description)
        assertEquals(dto.shortDescription, completionStatus.shortDescription)
        assertEquals(dto.validFrom, completionStatus.validFrom)
        assertEquals(dto.validTo, completionStatus.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        CompletionStatusDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        CompletionStatus completionStatusSaved = completionStatusService.createFromDto(dto)
        verify(completionStatusRepository, times(1)).save(any(CompletionStatus.class))
        verifyNoMoreInteractions(completionStatusRepository)
        assertEquals(completionStatus.id, completionStatusSaved.id)
        assertEquals(completionStatus.code, completionStatusSaved.code)
        assertEquals(completionStatus.description, completionStatusSaved.description)
        assertEquals(completionStatus.shortDescription, completionStatusSaved.shortDescription)
        assertEquals(completionStatus.validFrom, completionStatusSaved.validFrom)
        assertEquals(completionStatus.validTo, completionStatusSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create CompletionStatus from null object.")
        CompletionStatusDto dto = null
        completionStatusService.createFromDto(dto)
        verifyNoMoreInteractions(completionStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CompletionStatusDto dto = createDto()
        CompletionStatus completionStatusSaved = completionStatusService.updateFromDto(dto)
        verify(completionStatusRepository, times(1)).findById(completionStatus.id)
        verify(completionStatusRepository, times(1)).save(completionStatus)
        verifyNoMoreInteractions(completionStatusRepository)
        assertEquals(completionStatus.id, completionStatusSaved.id)
        assertEquals(completionStatus.code, completionStatusSaved.code)
        assertEquals(completionStatus.description, completionStatusSaved.description)
        assertEquals(completionStatus.shortDescription, completionStatusSaved.shortDescription)
        assertEquals(completionStatus.validFrom, completionStatusSaved.validFrom)
        assertEquals(completionStatus.validTo, completionStatusSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        CompletionStatusDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        CompletionStatus completionStatusSaved = completionStatusService.updateFromDto(dto)
        verify(completionStatusRepository, times(1)).findById(completionStatus.id)
        verify(completionStatusRepository, times(1)).save(completionStatus)
        verifyNoMoreInteractions(completionStatusRepository)
        assertEquals(completionStatus.id, completionStatusSaved.id)
        assertEquals(completionStatus.code, completionStatusSaved.code)
        assertEquals(completionStatus.description, completionStatusSaved.description)
        assertEquals(completionStatus.shortDescription, completionStatusSaved.shortDescription)
        assertEquals(completionStatus.validFrom, completionStatusSaved.validFrom)
        assertEquals(completionStatus.validTo, completionStatusSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update CompletionStatus from null object.")
        CompletionStatusDto dto = null
        completionStatusService.updateFromDto(dto)
        verifyNoMoreInteractions(completionStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        completionStatusService.delete(completionStatus)
        verifyNoMoreInteractions(completionStatusRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}