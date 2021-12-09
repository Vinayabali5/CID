package uk.ac.reigate.dto.ilr;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.Outcome
import uk.ac.reigate.dto.ilr.OutcomeDto

public class OutcomeTest {
    
    private Outcome outcome1
    
    private Outcome outcome2
    
    private List<Outcome> outcomes
    
    @Before
    public void setup() {
        outcome1 = new Outcome(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        outcome2 = new Outcome(
                id: 2,
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        outcomes = Arrays.asList(outcome1, outcome2);
    }
    
    @Test
    public void testMapFromOutcomeEntityTest() {
        OutcomeDto outcomeTest = OutcomeDto.mapFromEntity( outcome1 )
        assertEquals( outcomeTest.id, outcome1.id);
        assertEquals( outcomeTest.code, outcome1.code);
        assertEquals( outcomeTest.description, outcome1.description);
        assertEquals( outcomeTest.shortDescription, outcome1.shortDescription);
        assertEquals( outcomeTest.validFrom, outcome1.validFrom);
        assertEquals( outcomeTest.validTo, outcome1.validTo);
    }
    
    @Test
    public void testMapFromOutcomesEntitiesTest(){
        List<OutcomeDto> outcomesDtoTest = OutcomeDto.mapFromList(outcomes)
        assertEquals( outcomesDtoTest[0].id, outcome1.id );
        assertEquals( outcomesDtoTest[0].code, outcome1.code );
        assertEquals( outcomesDtoTest[0].description, outcome1.description);
        assertEquals( outcomesDtoTest[0].shortDescription, outcome1.shortDescription);
        assertEquals( outcomesDtoTest[0].validFrom, outcome1.validFrom);
        assertEquals( outcomesDtoTest[0].validTo, outcome1.validTo);
        assertEquals( outcomesDtoTest[1].id, outcome2.id );
        assertEquals( outcomesDtoTest[1].code, outcome2.code );
        assertEquals( outcomesDtoTest[1].description, outcome2.description);
        assertEquals( outcomesDtoTest[1].shortDescription, outcome2.shortDescription);
        assertEquals( outcomesDtoTest[1].validFrom, outcome2.validFrom);
        assertEquals( outcomesDtoTest[1].validTo, outcome2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        OutcomeDto outcomeDto1 = new OutcomeDto(outcome1)
        OutcomeDto outcomeDto2 = new OutcomeDto(outcome1)
        assertEquals(outcomeDto1, outcomeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        OutcomeDto outcomeDto1 = new OutcomeDto(outcome1)
        OutcomeDto outcomeDto2 = new OutcomeDto(outcome2)
        assertNotEquals(outcomeDto1, outcomeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        OutcomeDto outcomeDto1 = new OutcomeDto(outcome1)
        OutcomeDto outcomeDto2 = new OutcomeDto(outcome1)
        assertEquals(outcomeDto1.hashCode(), outcomeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        OutcomeDto outcomeDto1 = new OutcomeDto(outcome1)
        OutcomeDto outcomeDto2 = new OutcomeDto(outcome2)
        assertNotEquals(outcomeDto1.hashCode(), outcomeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Outcome() {
        OutcomeDto outcomeDto = new OutcomeDto(outcome1)
        assertEquals( outcomeDto.code, outcome1.code )
        assertEquals( outcomeDto.description, outcome1.description )
        assertEquals( outcomeDto.shortDescription, outcome1.shortDescription )
        assertEquals( outcomeDto.validFrom, outcome1.validFrom )
        assertEquals( outcomeDto.validTo, outcome1.validTo )
    }
    
    @Test
    public void testConstructor_NullOutcome() {
        Outcome outcome = null
        OutcomeDto outcomeDto = new OutcomeDto(outcome)
        assertEquals( outcome, null )
    }
}
