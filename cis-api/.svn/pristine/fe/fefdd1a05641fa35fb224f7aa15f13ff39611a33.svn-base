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

import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.dto.ilr.RestrictedUseIndicatorDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.RestrictedUseIndicatorRepository


class RestrictedUseIndicatorServiceTest {
    
    @Mock
    private RestrictedUseIndicatorRepository restrictedUseIndicatorRepository;
    
    @InjectMocks
    private RestrictedUseIndicatorService restrictedUseIndicatorService;
    
    private RestrictedUseIndicator restrictedUseIndicator
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample RestrictedUseIndicator data object to use for the testing
     * 
     * @return a sample RestrictedUseIndicator data object
     */
    RestrictedUseIndicator createRestrictedUseIndicator() {
        return new RestrictedUseIndicator(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample RestrictedUseIndicator created at setup
     * 
     * @return a RestrictedUseIndicatorDto object based on the sample RestrictedUseIndicator
     */
    RestrictedUseIndicatorDto createDto() {
        return new RestrictedUseIndicatorDto(
                id: restrictedUseIndicator.id,
                code: restrictedUseIndicator.code,
                description: restrictedUseIndicator.description,
                shortDescription: restrictedUseIndicator.shortDescription,
                validFrom: restrictedUseIndicator.validFrom,
                validTo: restrictedUseIndicator.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the RestrictedUseIndicatorService
     */
    @Before
    public void setup() {
        this.restrictedUseIndicatorRepository = Mockito.mock(RestrictedUseIndicatorRepository.class);
        this.restrictedUseIndicatorService = new RestrictedUseIndicatorService(restrictedUseIndicatorRepository);
        
        restrictedUseIndicator = createRestrictedUseIndicator()
        
        when(restrictedUseIndicatorRepository.save(any(RestrictedUseIndicator.class))).thenReturn(restrictedUseIndicator);
        when(restrictedUseIndicatorRepository.findById(1)).thenReturn(new Optional(restrictedUseIndicator));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        RestrictedUseIndicatorService service = new RestrictedUseIndicatorService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<RestrictedUseIndicator> result = restrictedUseIndicatorService.findAll();
        verify(restrictedUseIndicatorRepository, times(1)).findAll()
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        RestrictedUseIndicator result = restrictedUseIndicatorService.findById(1);
        verify(restrictedUseIndicatorRepository, times(1)).findById(1)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        RestrictedUseIndicator savedRestrictedUseIndicator = restrictedUseIndicatorService.save(restrictedUseIndicator);
        verify(restrictedUseIndicatorRepository, times(1)).save(any())
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<RestrictedUseIndicator> savedRestrictedUseIndicators = restrictedUseIndicatorService.saveRestrictedUseIndicators([
            restrictedUseIndicator,
            restrictedUseIndicator
        ]);
        verify(restrictedUseIndicatorRepository, times(2)).save(restrictedUseIndicator)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        RestrictedUseIndicatorDto dto = createDto()
        RestrictedUseIndicator restrictedUseIndicatorSaved = restrictedUseIndicatorService.createFromDto(dto)
        verify(restrictedUseIndicatorRepository, times(1)).save(any(RestrictedUseIndicator.class))
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertEquals(dto.id, restrictedUseIndicator.id)
        assertEquals(dto.code, restrictedUseIndicator.code)
        assertEquals(dto.description, restrictedUseIndicator.description)
        assertEquals(dto.shortDescription, restrictedUseIndicator.shortDescription)
        assertEquals(dto.validFrom, restrictedUseIndicator.validFrom)
        assertEquals(dto.validTo, restrictedUseIndicator.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        RestrictedUseIndicatorDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        RestrictedUseIndicator restrictedUseIndicatorSaved = restrictedUseIndicatorService.createFromDto(dto)
        verify(restrictedUseIndicatorRepository, times(1)).save(any(RestrictedUseIndicator.class))
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertEquals(restrictedUseIndicator.id, restrictedUseIndicatorSaved.id)
        assertEquals(restrictedUseIndicator.code, restrictedUseIndicatorSaved.code)
        assertEquals(restrictedUseIndicator.description, restrictedUseIndicatorSaved.description)
        assertEquals(restrictedUseIndicator.shortDescription, restrictedUseIndicatorSaved.shortDescription)
        assertEquals(restrictedUseIndicator.validFrom, restrictedUseIndicatorSaved.validFrom)
        assertEquals(restrictedUseIndicator.validTo, restrictedUseIndicatorSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create restrictedUseIndicator from null object.")
        RestrictedUseIndicatorDto dto = null
        restrictedUseIndicatorService.createFromDto(dto)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        RestrictedUseIndicatorDto dto = createDto()
        RestrictedUseIndicator restrictedUseIndicatorSaved = restrictedUseIndicatorService.updateFromDto(dto)
        verify(restrictedUseIndicatorRepository, times(1)).findById(restrictedUseIndicator.id)
        verify(restrictedUseIndicatorRepository, times(1)).save(restrictedUseIndicator)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertEquals(restrictedUseIndicator.id, restrictedUseIndicatorSaved.id)
        assertEquals(restrictedUseIndicator.code, restrictedUseIndicatorSaved.code)
        assertEquals(restrictedUseIndicator.description, restrictedUseIndicatorSaved.description)
        assertEquals(restrictedUseIndicator.shortDescription, restrictedUseIndicatorSaved.shortDescription)
        assertEquals(restrictedUseIndicator.validFrom, restrictedUseIndicatorSaved.validFrom)
        assertEquals(restrictedUseIndicator.validTo, restrictedUseIndicatorSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        RestrictedUseIndicatorDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        RestrictedUseIndicator restrictedUseIndicatorSaved = restrictedUseIndicatorService.updateFromDto(dto)
        verify(restrictedUseIndicatorRepository, times(1)).findById(restrictedUseIndicator.id)
        verify(restrictedUseIndicatorRepository, times(1)).save(restrictedUseIndicator)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertEquals(restrictedUseIndicator.id, restrictedUseIndicatorSaved.id)
        assertEquals(restrictedUseIndicator.code, restrictedUseIndicatorSaved.code)
        assertEquals(restrictedUseIndicator.description, restrictedUseIndicatorSaved.description)
        assertEquals(restrictedUseIndicator.shortDescription, restrictedUseIndicatorSaved.shortDescription)
        assertEquals(restrictedUseIndicator.validFrom, restrictedUseIndicatorSaved.validFrom)
        assertEquals(restrictedUseIndicator.validTo, restrictedUseIndicatorSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update restrictedUseIndicator from null object.")
        RestrictedUseIndicatorDto dto = null
        restrictedUseIndicatorService.updateFromDto(dto)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        restrictedUseIndicatorService.delete(restrictedUseIndicator)
        verifyNoMoreInteractions(restrictedUseIndicatorRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}