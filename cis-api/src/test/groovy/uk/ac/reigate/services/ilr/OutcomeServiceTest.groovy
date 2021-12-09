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

import uk.ac.reigate.domain.ilr.Outcome
import uk.ac.reigate.dto.ilr.OutcomeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.OutcomeRepository


class OutcomeServiceTest {
    
    @Mock
    private OutcomeRepository outcomeRepository;
    
    @InjectMocks
    private OutcomeService outcomeService;
    
    private Outcome outcome
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Outcome data object to use for the testing
     * 
     * @return a sample Outcome data object
     */
    Outcome createOutcome() {
        return new Outcome(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Outcome created at setup
     * 
     * @return a OutcomeDto object based on the sample Outcome
     */
    OutcomeDto createDto() {
        return new OutcomeDto(
                id: outcome.id,
                code: outcome.code,
                description: outcome.description,
                shortDescription: outcome.shortDescription,
                validFrom: outcome.validFrom,
                validTo: outcome.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the OutcomeService
     */
    @Before
    public void setup() {
        this.outcomeRepository = Mockito.mock(OutcomeRepository.class);
        this.outcomeService = new OutcomeService(outcomeRepository);
        
        outcome = createOutcome()
        
        when(outcomeRepository.save(any(Outcome.class))).thenReturn(outcome);
        when(outcomeRepository.findById(1)).thenReturn(new Optional(outcome));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        OutcomeService service = new OutcomeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Outcome> result = outcomeService.findAll();
        verify(outcomeRepository, times(1)).findAll()
        verifyNoMoreInteractions(outcomeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Outcome result = outcomeService.findById(1);
        verify(outcomeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(outcomeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Outcome savedOutcome = outcomeService.save(outcome);
        verify(outcomeRepository, times(1)).save(any())
        verifyNoMoreInteractions(outcomeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Outcome> savedOutcomes = outcomeService.saveOutcomes([outcome, outcome]);
        verify(outcomeRepository, times(2)).save(outcome)
        verifyNoMoreInteractions(outcomeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        OutcomeDto dto = createDto()
        Outcome outcomeSaved = outcomeService.createFromDto(dto)
        verify(outcomeRepository, times(1)).save(any(Outcome.class))
        verifyNoMoreInteractions(outcomeRepository)
        assertEquals(dto.id, outcome.id)
        assertEquals(dto.code, outcome.code)
        assertEquals(dto.description, outcome.description)
        assertEquals(dto.shortDescription, outcome.shortDescription)
        assertEquals(dto.validFrom, outcome.validFrom)
        assertEquals(dto.validTo, outcome.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        OutcomeDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        Outcome outcomeSaved = outcomeService.createFromDto(dto)
        verify(outcomeRepository, times(1)).save(any(Outcome.class))
        verifyNoMoreInteractions(outcomeRepository)
        assertEquals(outcome.id, outcomeSaved.id)
        assertEquals(outcome.code, outcomeSaved.code)
        assertEquals(outcome.description, outcomeSaved.description)
        assertEquals(outcome.shortDescription, outcomeSaved.shortDescription)
        assertEquals(outcome.validFrom, outcomeSaved.validFrom)
        assertEquals(outcome.validTo, outcomeSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create outcome from null object.")
        OutcomeDto dto = null
        outcomeService.createFromDto(dto)
        verifyNoMoreInteractions(outcomeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        OutcomeDto dto = createDto()
        Outcome outcomeSaved = outcomeService.updateFromDto(dto)
        verify(outcomeRepository, times(1)).findById(outcome.id)
        verify(outcomeRepository, times(1)).save(outcome)
        verifyNoMoreInteractions(outcomeRepository)
        assertEquals(outcome.id, outcomeSaved.id)
        assertEquals(outcome.code, outcomeSaved.code)
        assertEquals(outcome.description, outcomeSaved.description)
        assertEquals(outcome.shortDescription, outcomeSaved.shortDescription)
        assertEquals(outcome.validFrom, outcomeSaved.validFrom)
        assertEquals(outcome.validTo, outcomeSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        OutcomeDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        Outcome outcomeSaved = outcomeService.updateFromDto(dto)
        verify(outcomeRepository, times(1)).findById(outcome.id)
        verify(outcomeRepository, times(1)).save(outcome)
        verifyNoMoreInteractions(outcomeRepository)
        assertEquals(outcome.id, outcomeSaved.id)
        assertEquals(outcome.code, outcomeSaved.code)
        assertEquals(outcome.description, outcomeSaved.description)
        assertEquals(outcome.shortDescription, outcomeSaved.shortDescription)
        assertEquals(outcome.validFrom, outcomeSaved.validFrom)
        assertEquals(outcome.validTo, outcomeSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update outcome from null object.")
        OutcomeDto dto = null
        outcomeService.updateFromDto(dto)
        verifyNoMoreInteractions(outcomeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        outcomeService.delete(outcome)
        verifyNoMoreInteractions(outcomeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}