package uk.ac.reigate.services

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

import uk.ac.reigate.domain.ilr.EnglishConditionOfFunding
import uk.ac.reigate.dto.EnglishConditionOfFundingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.EnglishConditionOfFundingRepository


class EnglishConditionOfFundingServiceTest {
    
    @Mock
    private EnglishConditionOfFundingRepository englishConditionOfFundingRepository;
    
    @InjectMocks
    private EnglishConditionOfFundingService englishConditionOfFundingService;
    
    private EnglishConditionOfFunding englishConditionOfFunding
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample EnglishConditionOfFunding data object to use for the testing
     * 
     * @return a sample EnglishConditionOfFunding data object
     */
    EnglishConditionOfFunding createEnglishConditionOfFunding() {
        return new EnglishConditionOfFunding(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample EnglishConditionOfFunding created at setup
     * 
     * @return a EnglishConditionOfFundingDto object based on the sample EnglishConditionOfFunding
     */
    EnglishConditionOfFundingDto createDto() {
        return new EnglishConditionOfFundingDto(
                id: englishConditionOfFunding.id,
                code: englishConditionOfFunding.code,
                description: englishConditionOfFunding.description,
                shortDescription: englishConditionOfFunding.shortDescription,
                validFrom: englishConditionOfFunding.validFrom,
                validTo: englishConditionOfFunding.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the EnglishConditionOfFundingService
     */
    @Before
    public void setup() {
        this.englishConditionOfFundingRepository = Mockito.mock(EnglishConditionOfFundingRepository.class);
        this.englishConditionOfFundingService = new EnglishConditionOfFundingService(englishConditionOfFundingRepository);
        
        englishConditionOfFunding = createEnglishConditionOfFunding()
        
        // when(englishConditionOfFundingRepository.save(any(EnglishConditionOfFunding.class))).thenReturn(englishConditionOfFunding);
        when(englishConditionOfFundingRepository.findById(englishConditionOfFunding.id)).thenReturn(new Optional(new EnglishConditionOfFunding()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        EnglishConditionOfFundingService service = new EnglishConditionOfFundingService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<EnglishConditionOfFunding> result = englishConditionOfFundingService.findAll();
        verify(englishConditionOfFundingRepository, times(1)).findAll()
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        EnglishConditionOfFunding result = englishConditionOfFundingService.findById(1);
        verify(englishConditionOfFundingRepository, times(1)).findById(1)
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        EnglishConditionOfFunding savedEnglishConditionOfFunding = englishConditionOfFundingService.save(englishConditionOfFunding);
        verify(englishConditionOfFundingRepository, times(1)).save(any(EnglishConditionOfFunding.class))
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<EnglishConditionOfFunding> savedEnglishConditionOfFundings = englishConditionOfFundingService.saveEnglishConditionOfFundings([
            englishConditionOfFunding,
            englishConditionOfFunding
        ]);
        verify(englishConditionOfFundingRepository, times(2)).save(any(EnglishConditionOfFunding.class))
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        EnglishConditionOfFundingDto dto = createDto()
        EnglishConditionOfFunding englishConditionOfFundingSaved = englishConditionOfFundingService.createFromDto(dto)
        verify(englishConditionOfFundingRepository, times(1)).save(any(EnglishConditionOfFunding.class))
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        EnglishConditionOfFundingDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        EnglishConditionOfFunding englishConditionOfFundingSaved = englishConditionOfFundingService.createFromDto(dto)
        verify(englishConditionOfFundingRepository, times(1)).save(any(EnglishConditionOfFunding.class))
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create englishConditionOfFunding from null object.")
        EnglishConditionOfFundingDto dto = null
        englishConditionOfFundingService.createFromDto(dto)
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        EnglishConditionOfFundingDto dto = createDto()
        EnglishConditionOfFunding englishConditionOfFundingSaved = englishConditionOfFundingService.updateFromDto(dto)
        verify(englishConditionOfFundingRepository, times(1)).findById(englishConditionOfFunding.id)
        verify(englishConditionOfFundingRepository, times(1)).save(any(EnglishConditionOfFunding.class))
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        EnglishConditionOfFundingDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        EnglishConditionOfFunding englishConditionOfFundingSaved = englishConditionOfFundingService.updateFromDto(dto)
        verify(englishConditionOfFundingRepository, times(1)).findById(englishConditionOfFunding.id)
        verify(englishConditionOfFundingRepository, times(1)).save(any(EnglishConditionOfFunding.class))
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update englishConditionOfFunding from null object.")
        EnglishConditionOfFundingDto dto = null
        englishConditionOfFundingService.updateFromDto(dto)
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null ID
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update englishConditionOfFunding when the ID is null.")
        EnglishConditionOfFundingDto dto = new EnglishConditionOfFundingDto(code: '123', description: 'Year 123')
        englishConditionOfFundingService.updateFromDto(dto)
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
    }
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        englishConditionOfFundingService.delete(englishConditionOfFunding)
        verifyNoMoreInteractions(englishConditionOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}