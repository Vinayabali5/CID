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

import uk.ac.reigate.domain.ilr.SourceOfFunding
import uk.ac.reigate.dto.ilr.SourceOfFundingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.SourceOfFundingRepository


class SourceOfFundingServiceTest {
    
    @Mock
    private SourceOfFundingRepository sourceOfFundingRepository;
    
    @InjectMocks
    private SourceOfFundingService sourceOfFundingService;
    
    private SourceOfFunding sourceOfFunding
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample SourceOfFunding data object to use for the testing
     * 
     * @return a sample SourceOfFunding data object
     */
    SourceOfFunding createSourceOfFunding() {
        return new SourceOfFunding(
                id: 1,
                code: 'N',
                description: 'Test',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample SourceOfFunding created at setup
     * 
     * @return a SourceOfFundingDto object based on the sample SourceOfFunding
     */
    SourceOfFundingDto createDto() {
        return new SourceOfFundingDto(
                id: sourceOfFunding.id,
                code: sourceOfFunding.code,
                description: sourceOfFunding.description,
                shortDescription: sourceOfFunding.shortDescription,
                validFrom: sourceOfFunding.validFrom,
                validTo: sourceOfFunding.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the SourceOfFundingService
     */
    @Before
    public void setup() {
        this.sourceOfFundingRepository = Mockito.mock(SourceOfFundingRepository.class);
        this.sourceOfFundingService = new SourceOfFundingService(sourceOfFundingRepository);
        
        sourceOfFunding = createSourceOfFunding()
        
        when(sourceOfFundingRepository.save(any(SourceOfFunding.class))).thenReturn(sourceOfFunding);
        when(sourceOfFundingRepository.findById(1)).thenReturn(new Optional(sourceOfFunding));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SourceOfFundingService service = new SourceOfFundingService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SourceOfFunding> result = sourceOfFundingService.findAll();
        verify(sourceOfFundingRepository, times(1)).findAll()
        verifyNoMoreInteractions(sourceOfFundingRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SourceOfFunding result = sourceOfFundingService.findById(1);
        verify(sourceOfFundingRepository, times(1)).findById(1)
        verifyNoMoreInteractions(sourceOfFundingRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SourceOfFunding savedSourceOfFunding = sourceOfFundingService.save(sourceOfFunding);
        verify(sourceOfFundingRepository, times(1)).save(any())
        verifyNoMoreInteractions(sourceOfFundingRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<SourceOfFunding> savedSourceOfFundings = sourceOfFundingService.saveSourceOfFundings([
            sourceOfFunding,
            sourceOfFunding
        ]);
        verify(sourceOfFundingRepository, times(2)).save(sourceOfFunding)
        verifyNoMoreInteractions(sourceOfFundingRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SourceOfFundingDto dto = createDto()
        SourceOfFunding sourceOfFundingSaved = sourceOfFundingService.createFromDto(dto)
        verify(sourceOfFundingRepository, times(1)).save(any(SourceOfFunding.class))
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertEquals(dto.id, sourceOfFunding.id)
        assertEquals(dto.code, sourceOfFunding.code)
        assertEquals(dto.description, sourceOfFunding.description)
        assertEquals(dto.shortDescription, sourceOfFunding.shortDescription)
        assertEquals(dto.validFrom, sourceOfFunding.validFrom)
        assertEquals(dto.validTo, sourceOfFunding.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        SourceOfFundingDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        SourceOfFunding sourceOfFundingSaved = sourceOfFundingService.createFromDto(dto)
        verify(sourceOfFundingRepository, times(1)).save(any(SourceOfFunding.class))
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertEquals(sourceOfFunding.id, sourceOfFundingSaved.id)
        assertEquals(sourceOfFunding.code, sourceOfFundingSaved.code)
        assertEquals(sourceOfFunding.description, sourceOfFundingSaved.description)
        assertEquals(sourceOfFunding.shortDescription, sourceOfFundingSaved.shortDescription)
        assertEquals(sourceOfFunding.validFrom, sourceOfFundingSaved.validFrom)
        assertEquals(sourceOfFunding.validTo, sourceOfFundingSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create sourceOfFunding from null object.")
        SourceOfFundingDto dto = null
        sourceOfFundingService.createFromDto(dto)
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SourceOfFundingDto dto = createDto()
        SourceOfFunding sourceOfFundingSaved = sourceOfFundingService.updateFromDto(dto)
        verify(sourceOfFundingRepository, times(1)).findById(sourceOfFunding.id)
        verify(sourceOfFundingRepository, times(1)).save(sourceOfFunding)
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertEquals(sourceOfFunding.id, sourceOfFundingSaved.id)
        assertEquals(sourceOfFunding.code, sourceOfFundingSaved.code)
        assertEquals(sourceOfFunding.description, sourceOfFundingSaved.description)
        assertEquals(sourceOfFunding.shortDescription, sourceOfFundingSaved.shortDescription)
        assertEquals(sourceOfFunding.validFrom, sourceOfFundingSaved.validFrom)
        assertEquals(sourceOfFunding.validTo, sourceOfFundingSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SourceOfFundingDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        SourceOfFunding sourceOfFundingSaved = sourceOfFundingService.updateFromDto(dto)
        verify(sourceOfFundingRepository, times(1)).findById(sourceOfFunding.id)
        verify(sourceOfFundingRepository, times(1)).save(sourceOfFunding)
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertEquals(sourceOfFunding.id, sourceOfFundingSaved.id)
        assertEquals(sourceOfFunding.code, sourceOfFundingSaved.code)
        assertEquals(sourceOfFunding.description, sourceOfFundingSaved.description)
        assertEquals(sourceOfFunding.shortDescription, sourceOfFundingSaved.shortDescription)
        assertEquals(sourceOfFunding.validFrom, sourceOfFundingSaved.validFrom)
        assertEquals(sourceOfFunding.validTo, sourceOfFundingSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update sourceOfFunding from null object.")
        SourceOfFundingDto dto = null
        sourceOfFundingService.updateFromDto(dto)
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        sourceOfFundingService.delete(sourceOfFunding)
        verifyNoMoreInteractions(sourceOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}