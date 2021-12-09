package uk.ac.reigate.dto.ilp;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilp.StatementBankType

import static org.junit.Assert.*

public class StatementBankTypeDtoTest {
    
    private StatementBankType iLPStatementBankType1
    
    private StatementBankType iLPStatementBankType2
    
    private List<StatementBankType> iLPStatementBankTypes
    
    @Before
    public void setup() {
        this.iLPStatementBankType1 = new StatementBankType(
                id: 1,
                type: 'A'
                );
        this.iLPStatementBankType2 = new StatementBankType(
                id: 2,
                type: 'B'
                );
        this.iLPStatementBankTypes = Arrays.asList(this.iLPStatementBankType1, this.iLPStatementBankType2);
    }
    
    @Test
    public void testMapFromStatementBankTypeEntity(){
        StatementBankTypeDto iLPStatementBankTypeTest = StatementBankTypeDto.mapFromEntity( iLPStatementBankType1 )
        assertEquals( iLPStatementBankTypeTest.id, iLPStatementBankType1.id );
        assertEquals( iLPStatementBankTypeTest.type, iLPStatementBankType1.type);
    }
    
    @Test
    public void testMapFromStatementBankTypesEntities(){
        List<StatementBankTypeDto> iLPStatementBankTypesTest = StatementBankTypeDto.mapFromList( this.iLPStatementBankTypes )
        assertEquals( iLPStatementBankTypesTest[0].id, iLPStatementBankType1.id );
        assertEquals( iLPStatementBankTypesTest[0].type, iLPStatementBankType1.type );
        assertEquals( iLPStatementBankTypesTest[1].id, iLPStatementBankType2.id );
        assertEquals( iLPStatementBankTypesTest[1].type, iLPStatementBankType2.type );
    }
    
    @Test
    public void testEquals_Same() {
        StatementBankTypeDto iLPStatementBankTypeDto1 = new StatementBankTypeDto(iLPStatementBankType1)
        StatementBankTypeDto iLPStatementBankTypeDto2 = new StatementBankTypeDto(iLPStatementBankType1)
        assertEquals(iLPStatementBankTypeDto1, iLPStatementBankTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StatementBankTypeDto iLPStatementBankTypeDto1 = new StatementBankTypeDto(iLPStatementBankType1)
        StatementBankTypeDto iLPStatementBankTypeDto2 = new StatementBankTypeDto(iLPStatementBankType2)
        assertNotEquals(iLPStatementBankTypeDto1, iLPStatementBankTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StatementBankTypeDto iLPStatementBankTypeDto1 = new StatementBankTypeDto(iLPStatementBankType1)
        StatementBankTypeDto iLPStatementBankTypeDto2 = new StatementBankTypeDto(iLPStatementBankType1)
        assertEquals(iLPStatementBankTypeDto1.hashCode(), iLPStatementBankTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StatementBankTypeDto iLPStatementBankTypeDto1 = new StatementBankTypeDto(iLPStatementBankType1)
        StatementBankTypeDto iLPStatementBankTypeDto2 = new StatementBankTypeDto(iLPStatementBankType2)
        assertNotEquals(iLPStatementBankTypeDto1.hashCode(), iLPStatementBankTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StatementBankType() {
        StatementBankTypeDto iLPStatementBankTypeDto = new StatementBankTypeDto(iLPStatementBankType1)
        assertEquals( iLPStatementBankTypeDto.type, iLPStatementBankType1.type )
    }
    
    @Test
    public void testConstructor_NullStatementBankType() {
        StatementBankType iLPStatementBankType = null
        StatementBankTypeDto iLPStatementBankTypeDto = new StatementBankTypeDto(iLPStatementBankType)
        assertEquals( iLPStatementBankType, null )
    }
}
