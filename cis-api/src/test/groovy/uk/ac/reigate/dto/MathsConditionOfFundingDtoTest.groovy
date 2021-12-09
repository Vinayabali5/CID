package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.ilr.MathsConditionOfFunding
import uk.ac.reigate.exceptions.InvalidDataException

public class MathsConditionOfFundingDtoTest {
    
    private MathsConditionOfFunding mathsConditionOfFunding1
    
    private MathsConditionOfFunding mathsConditionOfFunding2
    
    private List<MathsConditionOfFunding> mathsConditionOfFundings
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        mathsConditionOfFunding1 = new MathsConditionOfFunding(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        mathsConditionOfFunding2 = new MathsConditionOfFunding(
                id: 2,
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        mathsConditionOfFundings = Arrays.asList(mathsConditionOfFunding1, mathsConditionOfFunding2);
    }
    
    @Test
    public void testConstructor_NullCollegeFundPaid() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create MathsConditionOfFundingDto from null object.")
        MathsConditionOfFunding mathsConditionOfFunding = null
        MathsConditionOfFundingDto mathsConditionOfFundingDto = new MathsConditionOfFundingDto(mathsConditionOfFunding)
    }
    
    @Test
    public void testMapFromMathsConditionOfFundingEntityTest() {
        MathsConditionOfFundingDto mathsConditionOfFundingTest = MathsConditionOfFundingDto.mapFromEntity( mathsConditionOfFunding1 )
        assertEquals( mathsConditionOfFundingTest.id, mathsConditionOfFunding1.id);
        assertEquals( mathsConditionOfFundingTest.code, mathsConditionOfFunding1.code);
        assertEquals( mathsConditionOfFundingTest.description, mathsConditionOfFunding1.description);
        assertEquals( mathsConditionOfFundingTest.shortDescription, mathsConditionOfFunding1.shortDescription);
        assertEquals( mathsConditionOfFundingTest.validFrom, mathsConditionOfFunding1.validFrom);
        assertEquals( mathsConditionOfFundingTest.validTo, mathsConditionOfFunding1.validTo);
    }
    
    @Test
    public void testMapFromMathsConditionOfFundingsEntitiesTest(){
        List<MathsConditionOfFundingDto> mathsConditionOfFundingsDtoTest = MathsConditionOfFundingDto.mapFromList( this.mathsConditionOfFundings )
        assertEquals( mathsConditionOfFundingsDtoTest[0].id, mathsConditionOfFunding1.id );
        assertEquals( mathsConditionOfFundingsDtoTest[0].code, mathsConditionOfFunding1.code );
        assertEquals( mathsConditionOfFundingsDtoTest[0].description, mathsConditionOfFunding1.description);
        assertEquals( mathsConditionOfFundingsDtoTest[0].shortDescription, mathsConditionOfFunding1.shortDescription);
        assertEquals( mathsConditionOfFundingsDtoTest[0].validFrom, mathsConditionOfFunding1.validFrom);
        assertEquals( mathsConditionOfFundingsDtoTest[0].validTo, mathsConditionOfFunding1.validTo);
        assertEquals( mathsConditionOfFundingsDtoTest[1].id, mathsConditionOfFunding2.id );
        assertEquals( mathsConditionOfFundingsDtoTest[1].code, mathsConditionOfFunding2.code );
        assertEquals( mathsConditionOfFundingsDtoTest[1].description, mathsConditionOfFunding2.description);
        assertEquals( mathsConditionOfFundingsDtoTest[1].shortDescription, mathsConditionOfFunding2.shortDescription);
        assertEquals( mathsConditionOfFundingsDtoTest[1].validFrom, mathsConditionOfFunding2.validFrom);
        assertEquals( mathsConditionOfFundingsDtoTest[1].validTo, mathsConditionOfFunding2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        MathsConditionOfFundingDto mathsConditionOfFundingDto1 = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        MathsConditionOfFundingDto mathsConditionOfFundingDto2 = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        assertEquals(mathsConditionOfFundingDto1, mathsConditionOfFundingDto2)
    }
    
    @Test
    public void testEquals_Different() {
        MathsConditionOfFundingDto mathsConditionOfFundingDto1 = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        MathsConditionOfFundingDto mathsConditionOfFundingDto2 = new MathsConditionOfFundingDto(mathsConditionOfFunding2)
        assertNotEquals(mathsConditionOfFundingDto1, mathsConditionOfFundingDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        MathsConditionOfFundingDto mathsConditionOfFundingDto1 = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        MathsConditionOfFundingDto mathsConditionOfFundingDto2 = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        assertEquals(mathsConditionOfFundingDto1.hashCode(), mathsConditionOfFundingDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        MathsConditionOfFundingDto mathsConditionOfFundingDto1 = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        MathsConditionOfFundingDto mathsConditionOfFundingDto2 = new MathsConditionOfFundingDto(mathsConditionOfFunding2)
        assertNotEquals(mathsConditionOfFundingDto1.hashCode(), mathsConditionOfFundingDto2.hashCode())
    }
    
    @Test
    public void testConstructor_MathsConditionOfFunding() {
        MathsConditionOfFundingDto mathsConditionOfFundingDto = new MathsConditionOfFundingDto(mathsConditionOfFunding1)
        assertEquals( mathsConditionOfFundingDto.code, mathsConditionOfFunding1.code )
        assertEquals( mathsConditionOfFundingDto.description, mathsConditionOfFunding1.description )
        assertEquals( mathsConditionOfFundingDto.shortDescription, mathsConditionOfFunding1.shortDescription )
        assertEquals( mathsConditionOfFundingDto.validFrom, mathsConditionOfFunding1.validFrom )
        assertEquals( mathsConditionOfFundingDto.validTo, mathsConditionOfFunding1.validTo )
    }
}
