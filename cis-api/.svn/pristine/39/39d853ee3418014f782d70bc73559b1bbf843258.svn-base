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

import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.dto.ilr.EthnicityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.EthnicityRepository


class EthnicityServiceTest {
    
    @Mock
    private EthnicityRepository ethnicityRepository;
    
    @InjectMocks
    private EthnicityService ethnicityService;
    
    private Ethnicity ethnicity
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Ethnicity data object to use for the testing
     * 
     * @return a sample Ethnicity data object
     */
    Ethnicity createEthnicity() {
        return new Ethnicity(
                id: 1,
                code: 'N',
                description: 'Indian',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Ethnicity created at setup
     * 
     * @return a EthnicityDto object based on the sample Ethnicity
     */
    EthnicityDto createDto() {
        return new EthnicityDto(
                id: ethnicity.id,
                code: ethnicity.code,
                description: ethnicity.description,
                shortDescription: ethnicity.shortDescription,
                validFrom: ethnicity.validFrom,
                validTo: ethnicity.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the EthnicityService
     */
    @Before
    public void setup() {
        this.ethnicityRepository = Mockito.mock(EthnicityRepository.class);
        this.ethnicityService = new EthnicityService(ethnicityRepository);
        
        ethnicity = createEthnicity()
        
        when(ethnicityRepository.save(any(Ethnicity.class))).thenReturn(ethnicity);
        when(ethnicityRepository.findById(1)).thenReturn(new Optional(ethnicity));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        EthnicityService service = new EthnicityService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Ethnicity> result = ethnicityService.findAll();
        verify(ethnicityRepository, times(1)).findAll()
        verifyNoMoreInteractions(ethnicityRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Ethnicity result = ethnicityService.findById(1);
        verify(ethnicityRepository, times(1)).findById(1)
        verifyNoMoreInteractions(ethnicityRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Ethnicity savedEthnicity = ethnicityService.save(ethnicity);
        verify(ethnicityRepository, times(1)).save(any())
        verifyNoMoreInteractions(ethnicityRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Ethnicity> savedEthnicitys = ethnicityService.saveEthnicities([ethnicity, ethnicity]);
        verify(ethnicityRepository, times(2)).save(ethnicity)
        verifyNoMoreInteractions(ethnicityRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        EthnicityDto dto = createDto()
        Ethnicity ethnicitySaved = ethnicityService.createFromDto(dto)
        verify(ethnicityRepository, times(1)).save(any(Ethnicity.class))
        verifyNoMoreInteractions(ethnicityRepository)
        assertEquals(dto.id, ethnicity.id)
        assertEquals(dto.code, ethnicity.code)
        assertEquals(dto.description, ethnicity.description)
        assertEquals(dto.shortDescription, ethnicity.shortDescription)
        assertEquals(dto.validFrom, ethnicity.validFrom)
        assertEquals(dto.validTo, ethnicity.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        EthnicityDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        Ethnicity ethnicitySaved = ethnicityService.createFromDto(dto)
        verify(ethnicityRepository, times(1)).save(any(Ethnicity.class))
        verifyNoMoreInteractions(ethnicityRepository)
        assertEquals(ethnicity.id, ethnicitySaved.id)
        assertEquals(ethnicity.code, ethnicitySaved.code)
        assertEquals(ethnicity.description, ethnicitySaved.description)
        assertEquals(ethnicity.shortDescription, ethnicitySaved.shortDescription)
        assertEquals(ethnicity.validFrom, ethnicitySaved.validFrom)
        assertEquals(ethnicity.validTo, ethnicitySaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create ethnicityDto from null object.")
        EthnicityDto dto = null
        ethnicityService.createFromDto(dto)
        verifyNoMoreInteractions(ethnicityRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        EthnicityDto dto = createDto()
        Ethnicity ethnicitySaved = ethnicityService.updateFromDto(dto)
        verify(ethnicityRepository, times(1)).findById(ethnicity.id)
        verify(ethnicityRepository, times(1)).save(ethnicity)
        verifyNoMoreInteractions(ethnicityRepository)
        assertEquals(ethnicity.id, ethnicitySaved.id)
        assertEquals(ethnicity.code, ethnicitySaved.code)
        assertEquals(ethnicity.description, ethnicitySaved.description)
        assertEquals(ethnicity.shortDescription, ethnicitySaved.shortDescription)
        assertEquals(ethnicity.validFrom, ethnicitySaved.validFrom)
        assertEquals(ethnicity.validTo, ethnicitySaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        EthnicityDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        Ethnicity ethnicitySaved = ethnicityService.updateFromDto(dto)
        verify(ethnicityRepository, times(1)).findById(ethnicity.id)
        verify(ethnicityRepository, times(1)).save(ethnicity)
        verifyNoMoreInteractions(ethnicityRepository)
        assertEquals(ethnicity.id, ethnicitySaved.id)
        assertEquals(ethnicity.code, ethnicitySaved.code)
        assertEquals(ethnicity.description, ethnicitySaved.description)
        assertEquals(ethnicity.shortDescription, ethnicitySaved.shortDescription)
        assertEquals(ethnicity.validFrom, ethnicitySaved.validFrom)
        assertEquals(ethnicity.validTo, ethnicitySaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update ethnicityDto from null object.")
        EthnicityDto dto = null
        ethnicityService.updateFromDto(dto)
        verifyNoMoreInteractions(ethnicityRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        ethnicityService.delete(ethnicity)
        verifyNoMoreInteractions(ethnicityRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByCode service method
     */
    @Test
    public void testFindByCode() {
        Ethnicity result = ethnicityService.findByCode("N")
        verify(ethnicityRepository, times(1)).findByCode("N")
        verifyNoMoreInteractions(ethnicityRepository)
    }
}