package uk.ac.reigate.services.ilp

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilp.StatementBankType;
import uk.ac.reigate.dto.ilp.StatementBankTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.StatementBankTypeRepository

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*


class StatementBankTypeServiceTest {
    
    private StatementBankTypeRepository statementBankTypeRepository
    
    private StatementBankTypeService statementBankTypeService;
    
    private StatementBankType statementBankType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.statementBankTypeRepository = Mockito.mock(StatementBankTypeRepository.class);
        this.statementBankTypeService = new StatementBankTypeService(statementBankTypeRepository);
        
        statementBankType = new StatementBankType(
                id: 1,
                type: 'A'
                )
        
        when(statementBankTypeRepository.findById(1)).thenReturn(new Optional(statementBankType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StatementBankTypeService service = new StatementBankTypeService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StatementBankType> result = statementBankTypeService.findAll();
        verify(statementBankTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testFindById() {
        StatementBankType result = statementBankTypeService.findById(1);
        verify(statementBankTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testSave() {
        StatementBankType savedStatementBankType = statementBankTypeService.save(statementBankType);
        verify(statementBankTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testSaveStatementBankType() {
        StatementBankType savedStatementBankType = statementBankTypeService.save(statementBankType);
        verify(statementBankTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testSaveStatementBankTypes() {
        List<StatementBankType> savedStatementBankTypes = statementBankTypeService.saveStatementBankTypes([
            new StatementBankType(id : 1),
            new StatementBankType(id: 2)
        ]);
        verify(statementBankTypeRepository, times(2)).save(any(StatementBankType.class))
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testSaveStatementBankTypeByFields() {
        StatementBankType savedStatementBankType = statementBankTypeService.save(statementBankType);
        verify(statementBankTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_Dto() {
        StatementBankTypeDto dto = new StatementBankTypeDto(id: 1, type:'Test')
        statementBankTypeService.createFromDto(dto)
        verify(statementBankTypeRepository, times(1)).save(any(StatementBankType.class))
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_Dto() {
        StatementBankTypeDto dto = new StatementBankTypeDto(id: 1, type:'Test')
        statementBankTypeService.updateFromDto(dto)
        verify(statementBankTypeRepository, times(1)).findById(dto.id)
        verify(statementBankTypeRepository, times(1)).save(any(StatementBankType.class))
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_WithNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create StatementBankType from null object.")
        StatementBankTypeDto dto = null
        statementBankTypeService.createFromDto(dto)
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testupdateFromDto_WithNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update StatementBankType from null object.")
        StatementBankTypeDto dto = null
        statementBankTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(statementBankTypeRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        statementBankTypeService.delete(statementBankType)
        verifyNoMoreInteractions(statementBankTypeRepository)
        assertThatExceptionOfType(InvalidOperationException.class)
    }
}

