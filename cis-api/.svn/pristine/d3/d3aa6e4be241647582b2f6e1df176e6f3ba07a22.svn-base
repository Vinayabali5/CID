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

import uk.ac.reigate.domain.ilr.WithdrawalReason
import uk.ac.reigate.dto.ilr.WithdrawalReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.WithdrawalReasonRepository


class WithdrawalReasonServiceTest {
    
    @Mock
    private WithdrawalReasonRepository withdrawalReasonRepository;
    
    @InjectMocks
    private WithdrawalReasonService withdrawalReasonService;
    
    private WithdrawalReason withdrawalReason
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample WithdrawalReason data object to use for the testing
     * 
     * @return a sample WithdrawalReason data object
     */
    WithdrawalReason createWithdrawalReason() {
        return new WithdrawalReason(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample WithdrawalReason created at setup
     * 
     * @return a WithdrawalReasonDto object based on the sample WithdrawalReason
     */
    WithdrawalReasonDto createDto() {
        return new WithdrawalReasonDto(
                id: withdrawalReason.id,
                code: withdrawalReason.code,
                description: withdrawalReason.description,
                shortDescription: withdrawalReason.shortDescription,
                validFrom: withdrawalReason.validFrom,
                validTo: withdrawalReason.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the WithdrawalReasonService
     */
    @Before
    public void setup() {
        this.withdrawalReasonRepository = Mockito.mock(WithdrawalReasonRepository.class);
        this.withdrawalReasonService = new WithdrawalReasonService(withdrawalReasonRepository);
        
        withdrawalReason = createWithdrawalReason()
        
        when(withdrawalReasonRepository.save(any(WithdrawalReason.class))).thenReturn(withdrawalReason);
        when(withdrawalReasonRepository.findById(1)).thenReturn(new Optional(withdrawalReason));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        WithdrawalReasonService service = new WithdrawalReasonService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<WithdrawalReason> result = withdrawalReasonService.findAll();
        verify(withdrawalReasonRepository, times(1)).findAll()
        verifyNoMoreInteractions(withdrawalReasonRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        WithdrawalReason result = withdrawalReasonService.findById(1);
        verify(withdrawalReasonRepository, times(1)).findById(1)
        verifyNoMoreInteractions(withdrawalReasonRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        WithdrawalReason savedWithdrawalReason = withdrawalReasonService.save(withdrawalReason);
        verify(withdrawalReasonRepository, times(1)).save(any())
        verifyNoMoreInteractions(withdrawalReasonRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<WithdrawalReason> savedWithdrawalReasons = withdrawalReasonService.saveWithdrawalReasons([
            withdrawalReason,
            withdrawalReason
        ]);
        verify(withdrawalReasonRepository, times(2)).save(withdrawalReason)
        verifyNoMoreInteractions(withdrawalReasonRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        WithdrawalReasonDto dto = createDto()
        WithdrawalReason withdrawalReasonSaved = withdrawalReasonService.createFromDto(dto)
        verify(withdrawalReasonRepository, times(1)).save(any(WithdrawalReason.class))
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertEquals(dto.id, withdrawalReason.id)
        assertEquals(dto.code, withdrawalReason.code)
        assertEquals(dto.description, withdrawalReason.description)
        assertEquals(dto.shortDescription, withdrawalReason.shortDescription)
        assertEquals(dto.validFrom, withdrawalReason.validFrom)
        assertEquals(dto.validTo, withdrawalReason.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        WithdrawalReasonDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        WithdrawalReason withdrawalReasonSaved = withdrawalReasonService.createFromDto(dto)
        verify(withdrawalReasonRepository, times(1)).save(any(WithdrawalReason.class))
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertEquals(withdrawalReason.id, withdrawalReasonSaved.id)
        assertEquals(withdrawalReason.code, withdrawalReasonSaved.code)
        assertEquals(withdrawalReason.description, withdrawalReasonSaved.description)
        assertEquals(withdrawalReason.shortDescription, withdrawalReasonSaved.shortDescription)
        assertEquals(withdrawalReason.validFrom, withdrawalReasonSaved.validFrom)
        assertEquals(withdrawalReason.validTo, withdrawalReasonSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create withdrawalReason from null object.")
        WithdrawalReasonDto dto = null
        withdrawalReasonService.createFromDto(dto)
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        WithdrawalReasonDto dto = createDto()
        WithdrawalReason withdrawalReasonSaved = withdrawalReasonService.updateFromDto(dto)
        verify(withdrawalReasonRepository, times(1)).findById(withdrawalReason.id)
        verify(withdrawalReasonRepository, times(1)).save(withdrawalReason)
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertEquals(withdrawalReason.id, withdrawalReasonSaved.id)
        assertEquals(withdrawalReason.code, withdrawalReasonSaved.code)
        assertEquals(withdrawalReason.description, withdrawalReasonSaved.description)
        assertEquals(withdrawalReason.shortDescription, withdrawalReasonSaved.shortDescription)
        assertEquals(withdrawalReason.validFrom, withdrawalReasonSaved.validFrom)
        assertEquals(withdrawalReason.validTo, withdrawalReasonSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        WithdrawalReasonDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        WithdrawalReason withdrawalReasonSaved = withdrawalReasonService.updateFromDto(dto)
        verify(withdrawalReasonRepository, times(1)).findById(withdrawalReason.id)
        verify(withdrawalReasonRepository, times(1)).save(withdrawalReason)
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertEquals(withdrawalReason.id, withdrawalReasonSaved.id)
        assertEquals(withdrawalReason.code, withdrawalReasonSaved.code)
        assertEquals(withdrawalReason.description, withdrawalReasonSaved.description)
        assertEquals(withdrawalReason.shortDescription, withdrawalReasonSaved.shortDescription)
        assertEquals(withdrawalReason.validFrom, withdrawalReasonSaved.validFrom)
        assertEquals(withdrawalReason.validTo, withdrawalReasonSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update withdrawalReason from null object.")
        WithdrawalReasonDto dto = null
        withdrawalReasonService.updateFromDto(dto)
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        withdrawalReasonService.delete(withdrawalReason)
        verifyNoMoreInteractions(withdrawalReasonRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}