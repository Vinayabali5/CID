package uk.ac.reigate.services.ilp

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mock

import uk.ac.reigate.domain.ilp.StatementBank;
import uk.ac.reigate.dto.StatementBankDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.StatementBankRepository

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*


class StatementBankServiceTest {
    
    @Mock
    private StatementBankRepository statementBankRepository
    
    private StatementBankService statementBankService
    
    @Mock
    private StatementBankTypeService statementBankTypeService
    
    private StatementBank statementBank
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.statementBankRepository = mock(StatementBankRepository.class)
        this.statementBankTypeService = mock(StatementBankTypeService.class)
        this.statementBankService = new StatementBankService(statementBankRepository, statementBankTypeService)
        
        statementBank = new StatementBank(
                id: 1,
                discussion: 'Testing',
                target: 'Test'
                )
        
        when(statementBankRepository.findById(1)).thenReturn(new Optional(statementBank))
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StatementBankService service = new StatementBankService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StatementBank> result = statementBankService.findAll();
        verify(statementBankRepository, times(1)).findByInUseTrue()
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testFindById() {
        StatementBank result = statementBankService.findById(1);
        verify(statementBankRepository, times(1)).findById(1)
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testFindByILPStatementBankType() {
        StatementBank result = statementBankService.findByILPStatementBankType(1);
        verify(statementBankRepository, times(1)).findByInUseTrueAndStatementBankTypeId(1)
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testFindUseForMassLetters() {
        List<StatementBank> result = statementBankService.findUseForMassLetters();
        verify(statementBankRepository, times(1)).findByUseForMassLettersTrueAndInUseTrue()
        verifyNoMoreInteractions(statementBankRepository)
    }
    @Test
    public void testSave() {
        StatementBank savedStatementBank = statementBankService.save(statementBank);
        verify(statementBankRepository, times(1)).save(any())
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testSaveStatementBank() {
        StatementBank savedStatementBank = statementBankService.save(statementBank);
        verify(statementBankRepository, times(1)).save(any())
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testSaveStatementBanks() {
        List<StatementBank> savedStatementBanks = statementBankService.saveStatementBanks([
            new StatementBank(id : 1),
            new StatementBank(id: 2)
        ]);
        verify(statementBankRepository, times(2)).save(any(StatementBank.class))
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testSaveStatementBankByFields() {
        StatementBank savedStatementBank = statementBankService.save(statementBank);
        verify(statementBankRepository, times(1)).save(any())
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        StatementBankDto dto = new StatementBankDto(id: 1, target:'Test')
        statementBankService.createFromDto(dto)
        verify(statementBankRepository, times(1)).save(any(StatementBank.class))
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoILPStatementBankTypeId() {
        StatementBankDto dto = new StatementBankDto(id: 1, target:'Test')
        dto.iLPStatementBankTypeId = 1
        when(statementBankTypeService.findById(dto.iLPStatementBankTypeId)).thenReturn(null)
        statementBankService.createFromDto(dto)
        verify(statementBankRepository, times(1)).save(any(StatementBank.class))
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        StatementBankDto dto = new StatementBankDto(id: 1, target:'Test')
        statementBankService.updateFromDto(dto)
        verify(statementBankRepository, times(1)).findById(dto.id)
        verify(statementBankRepository, times(1)).save(any(StatementBank.class))
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoILPStatementBankTypeId() {
        StatementBankDto dto = new StatementBankDto(id: 1, target:'Test')
        dto.iLPStatementBankTypeId = 1
        when(statementBankTypeService.findById(dto.iLPStatementBankTypeId)).thenReturn(null)
        statementBankService.updateFromDto(dto)
        verify(statementBankTypeService, times(1)).findById(dto.id)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create statamentBank from null object.")
        StatementBankDto dto = null
        statementBankService.createFromDto(dto)
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update statamentBank from null object.")
        StatementBankDto dto = null
        statementBankService.updateFromDto(dto)
        verifyNoMoreInteractions(statementBankRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        statementBankService.delete(statementBank)
        verifyNoMoreInteractions(statementBankRepository)
        assertThatExceptionOfType(InvalidOperationException.class)
    }
}

