package uk.ac.reigate.dto;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilp.StatementBank
import uk.ac.reigate.domain.ilp.StatementBankType

import static org.junit.Assert.*
import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNull

public class StatementBankDtoTest {
    
    private StatementBank statementBank1
    
    private StatementBank statementBank2
    
    private StatementBank statementBank3
    
    private List<StatementBank> statementBanks
    
    @Before
    public void setup() {
        statementBank1 = new StatementBank(
                id: 1,
                statementBankType: new StatementBankType(id:1, type: 'subject'),
                letterType:'StatementBank',
                topic: 'Test',
                discussion: 'Testing',
                target:'A',
                useForMassLetters: true
                );
        statementBank2 = new StatementBank(
                id: 2,
                statementBankType: new StatementBankType(id:2),
                letterType:'StatementBank 2',
                topic: 'Test',
                discussion: 'Testing',
                target:'A',
                useForMassLetters: true
                );
        statementBank3 = new StatementBank(
                id: 3,
                statementBankType: null,
                letterType:'StatementBank 2',
                topic: 'Test',
                discussion: 'Testing',
                target:'A',
                useForMassLetters: true
                );
        statementBanks = Arrays.asList(statementBank1, statementBank2);
    }
    
    @Test
    public void testConstructor_NullObject(){
        StatementBankDto statementBankTest = new StatementBankDto( null )
        assertNull( statementBankTest.id)
        assertNull( statementBankTest.iLPStatementBankTypeId )
        assertNull( statementBankTest.iLPStatementBankType )
        assertNull( statementBankTest.letterType )
        assertNull( statementBankTest.topic )
        assertNull( statementBankTest.discussion )
        assertNull( statementBankTest.target )
        assertNull( statementBankTest.useForMassLetters )
    }
    
    @Test
    public void testConstructor_NullStatementBankType(){
        StatementBankDto statementBankTest = new StatementBankDto( statementBank3 )
        assertNull( statementBankTest.iLPStatementBankType )
        assertNull( statementBankTest.iLPStatementBankTypeId )
    }
    
    @Test
    public void testMapFromStatementBankEntity(){
        StatementBankDto statementBankTest = StatementBankDto.mapFromEntity( statementBank1 )
        assertEquals( statementBankTest.id, statementBank1.id );
        assertEquals( statementBankTest.target, statementBank1.target );
        assertEquals( statementBankTest.topic, statementBank1.topic );
        assertEquals( statementBankTest.discussion, statementBank1.discussion );
        assertEquals( statementBankTest.target, statementBank1.target );
    }
    
    @Test
    public void testMapFromStatementBanksEntities(){
        List<StatementBankDto> statementBankDtoTest = StatementBankDto.mapFromList( statementBanks )
        assertEquals( statementBankDtoTest[0].id, statementBank1.id );
        assertEquals( statementBankDtoTest[0].target, statementBank1.target);
        assertEquals( statementBankDtoTest[1].id, statementBank2.id );
        assertEquals( statementBankDtoTest[1].target, statementBank2.target);
    }
    
    @Test
    public void testEquals_Same() {
        StatementBankDto statementBankDto1 = new StatementBankDto(statementBank1)
        StatementBankDto statementBankDto2 = new StatementBankDto(statementBank1)
        assertTrue(statementBankDto1 == statementBankDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StatementBankDto statementBankDto1 = new StatementBankDto(statementBank1)
        StatementBankDto statementBankDto2 = new StatementBankDto(statementBank2)
        assertFalse(statementBankDto1 == statementBankDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StatementBankDto statementBankDto1 = new StatementBankDto(statementBank1)
        StatementBankDto statementBankDto2 = new StatementBankDto(statementBank1)
        assertEquals(statementBankDto1.hashCode(), statementBankDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StatementBankDto statementBankDto1 = new StatementBankDto(statementBank1)
        StatementBankDto statementBankDto2 = new StatementBankDto(statementBank2)
        assertNotEquals(statementBankDto1.hashCode(), statementBankDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StatementBank() {
        StatementBankDto statementBankDto = new StatementBankDto(statementBank1)
        assertEquals( statementBankDto.target, statementBank1.target )
    }
    
    @Test
    public void testMethod_Get_NullILPStatementBankType() {
        StatementBankDto statementBankDto1 = new StatementBankDto(statementBank3)
        assertEquals(statementBankDto1.get_ILPStatementBankType(), null)
    }
    
    @Test
    public void testMethod_Get_ILPStatementBankType() {
        StatementBankDto statementBankDto1 = new StatementBankDto(statementBank1)
        assertEquals(statementBankDto1.iLPStatementBankType.type, statementBankDto1.get_ILPStatementBankType())
    }
}
