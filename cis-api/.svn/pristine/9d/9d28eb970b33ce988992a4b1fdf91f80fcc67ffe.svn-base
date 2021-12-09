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

import uk.ac.reigate.domain.ilr.MathsConditionOfFunding
import uk.ac.reigate.dto.MathsConditionOfFundingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.MathsConditionOfFundingRepository


class MathsConditionOfFundingServiceTest {
    
    @Mock
    private MathsConditionOfFundingRepository mathsConditionOfFundingRepository;
    
    @InjectMocks
    private MathsConditionOfFundingService mathsConditionOfFundingService;
    
    private MathsConditionOfFunding mathsConditionOfFunding
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample MathsConditionOfFunding data object to use for the testing
     * 
     * @return a sample MathsConditionOfFunding data object
     */
    MathsConditionOfFunding createMathsConditionOfFunding() {
        return new MathsConditionOfFunding(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample MathsConditionOfFunding created at setup
     * 
     * @return a MathsConditionOfFundingDto object based on the sample MathsConditionOfFunding
     */
    MathsConditionOfFundingDto createDto() {
        return new MathsConditionOfFundingDto(
                id: mathsConditionOfFunding.id,
                code: mathsConditionOfFunding.code,
                description: mathsConditionOfFunding.description,
                shortDescription: mathsConditionOfFunding.shortDescription,
                validFrom: mathsConditionOfFunding.validFrom,
                validTo: mathsConditionOfFunding.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the MathsConditionOfFundingService
     */
    @Before
    public void setup() {
        this.mathsConditionOfFundingRepository = Mockito.mock(MathsConditionOfFundingRepository.class);
        this.mathsConditionOfFundingService = new MathsConditionOfFundingService(mathsConditionOfFundingRepository);
        
        mathsConditionOfFunding = createMathsConditionOfFunding()
        
        when(mathsConditionOfFundingRepository.save(any(MathsConditionOfFunding.class))).thenReturn(mathsConditionOfFunding);
        when(mathsConditionOfFundingRepository.findById(1)).thenReturn(new Optional(mathsConditionOfFunding));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        MathsConditionOfFundingService service = new MathsConditionOfFundingService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<MathsConditionOfFunding> result = mathsConditionOfFundingService.findAll();
        verify(mathsConditionOfFundingRepository, times(1)).findAll()
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        MathsConditionOfFunding result = mathsConditionOfFundingService.findById(1);
        verify(mathsConditionOfFundingRepository, times(1)).findById(1)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        MathsConditionOfFunding savedMathsConditionOfFunding = mathsConditionOfFundingService.save(mathsConditionOfFunding);
        verify(mathsConditionOfFundingRepository, times(1)).save(any())
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<MathsConditionOfFunding> savedMathsConditionOfFundings = mathsConditionOfFundingService.saveMathsConditionOfFundings([
            mathsConditionOfFunding,
            mathsConditionOfFunding
        ]);
        verify(mathsConditionOfFundingRepository, times(2)).save(mathsConditionOfFunding)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        MathsConditionOfFundingDto dto = createDto()
        MathsConditionOfFunding mathsConditionOfFundingSaved = mathsConditionOfFundingService.createFromDto(dto)
        verify(mathsConditionOfFundingRepository, times(1)).save(any(MathsConditionOfFunding.class))
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertEquals(dto.id, mathsConditionOfFunding.id)
        assertEquals(dto.code, mathsConditionOfFunding.code)
        assertEquals(dto.description, mathsConditionOfFunding.description)
        assertEquals(dto.shortDescription, mathsConditionOfFunding.shortDescription)
        assertEquals(dto.validFrom, mathsConditionOfFunding.validFrom)
        assertEquals(dto.validTo, mathsConditionOfFunding.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        MathsConditionOfFundingDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        MathsConditionOfFunding mathsConditionOfFundingSaved = mathsConditionOfFundingService.createFromDto(dto)
        verify(mathsConditionOfFundingRepository, times(1)).save(any(MathsConditionOfFunding.class))
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertEquals(mathsConditionOfFunding.id, mathsConditionOfFundingSaved.id)
        assertEquals(mathsConditionOfFunding.code, mathsConditionOfFundingSaved.code)
        assertEquals(mathsConditionOfFunding.description, mathsConditionOfFundingSaved.description)
        assertEquals(mathsConditionOfFunding.shortDescription, mathsConditionOfFundingSaved.shortDescription)
        assertEquals(mathsConditionOfFunding.validFrom, mathsConditionOfFundingSaved.validFrom)
        assertEquals(mathsConditionOfFunding.validTo, mathsConditionOfFundingSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create mathsConditionOfFunding from null object.")
        MathsConditionOfFundingDto dto = null
        mathsConditionOfFundingService.createFromDto(dto)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        MathsConditionOfFundingDto dto = createDto()
        MathsConditionOfFunding mathsConditionOfFundingSaved = mathsConditionOfFundingService.updateFromDto(dto)
        verify(mathsConditionOfFundingRepository, times(1)).findById(mathsConditionOfFunding.id)
        verify(mathsConditionOfFundingRepository, times(1)).save(mathsConditionOfFunding)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertEquals(mathsConditionOfFunding.id, mathsConditionOfFundingSaved.id)
        assertEquals(mathsConditionOfFunding.code, mathsConditionOfFundingSaved.code)
        assertEquals(mathsConditionOfFunding.description, mathsConditionOfFundingSaved.description)
        assertEquals(mathsConditionOfFunding.shortDescription, mathsConditionOfFundingSaved.shortDescription)
        assertEquals(mathsConditionOfFunding.validFrom, mathsConditionOfFundingSaved.validFrom)
        assertEquals(mathsConditionOfFunding.validTo, mathsConditionOfFundingSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        MathsConditionOfFundingDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        MathsConditionOfFunding mathsConditionOfFundingSaved = mathsConditionOfFundingService.updateFromDto(dto)
        verify(mathsConditionOfFundingRepository, times(1)).findById(mathsConditionOfFunding.id)
        verify(mathsConditionOfFundingRepository, times(1)).save(mathsConditionOfFunding)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertEquals(mathsConditionOfFunding.id, mathsConditionOfFundingSaved.id)
        assertEquals(mathsConditionOfFunding.code, mathsConditionOfFundingSaved.code)
        assertEquals(mathsConditionOfFunding.description, mathsConditionOfFundingSaved.description)
        assertEquals(mathsConditionOfFunding.shortDescription, mathsConditionOfFundingSaved.shortDescription)
        assertEquals(mathsConditionOfFunding.validFrom, mathsConditionOfFundingSaved.validFrom)
        assertEquals(mathsConditionOfFunding.validTo, mathsConditionOfFundingSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update mathsConditionOfFunding from null object.")
        MathsConditionOfFundingDto dto = null
        mathsConditionOfFundingService.updateFromDto(dto)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        mathsConditionOfFundingService.delete(mathsConditionOfFunding)
        verifyNoMoreInteractions(mathsConditionOfFundingRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}