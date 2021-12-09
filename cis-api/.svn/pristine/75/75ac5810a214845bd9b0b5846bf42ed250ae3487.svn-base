package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.EnglishConditionOfFunding

public class EnglishConditionOfFundingDtoTest {
    
    private EnglishConditionOfFunding englishConditionOfFunding1
    
    private EnglishConditionOfFunding englishConditionOfFunding2
    
    private List<EnglishConditionOfFunding> englishConditionOfFundings
    
    @Before
    public void setup() {
        this.englishConditionOfFunding1 = new EnglishConditionOfFunding(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.englishConditionOfFunding2 = new EnglishConditionOfFunding(
                id: 2,
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        englishConditionOfFundings = Arrays.asList(this.englishConditionOfFunding1, this.englishConditionOfFunding2);
    }
    
    @Test
    public void testMapFromEnglishConditionOfFundingEntityTest() {
        EnglishConditionOfFundingDto englishConditionOfFundingTest = EnglishConditionOfFundingDto.mapFromEntity( englishConditionOfFunding1 )
        assertEquals( englishConditionOfFundingTest.id, englishConditionOfFunding1.id);
        assertEquals( englishConditionOfFundingTest.code, englishConditionOfFunding1.code);
        assertEquals( englishConditionOfFundingTest.description, englishConditionOfFunding1.description);
        assertEquals( englishConditionOfFundingTest.shortDescription, englishConditionOfFunding1.shortDescription);
        assertEquals( englishConditionOfFundingTest.validFrom, englishConditionOfFunding1.validFrom);
        assertEquals( englishConditionOfFundingTest.validTo, englishConditionOfFunding1.validTo);
    }
    
    @Test
    public void testMapFromEnglishConditionOfFundingsEntitiesTest(){
        List<EnglishConditionOfFundingDto> englishConditionOfFundingsDtoTest = EnglishConditionOfFundingDto.mapFromList( this.englishConditionOfFundings )
        assertEquals( englishConditionOfFundingsDtoTest[0].id, englishConditionOfFunding1.id );
        assertEquals( englishConditionOfFundingsDtoTest[0].code, englishConditionOfFunding1.code );
        assertEquals( englishConditionOfFundingsDtoTest[0].description, englishConditionOfFunding1.description);
        assertEquals( englishConditionOfFundingsDtoTest[0].shortDescription, englishConditionOfFunding1.shortDescription);
        assertEquals( englishConditionOfFundingsDtoTest[0].validFrom, englishConditionOfFunding1.validFrom);
        assertEquals( englishConditionOfFundingsDtoTest[0].validTo, englishConditionOfFunding1.validTo);
        assertEquals( englishConditionOfFundingsDtoTest[1].id, englishConditionOfFunding2.id );
        assertEquals( englishConditionOfFundingsDtoTest[1].code, englishConditionOfFunding2.code );
        assertEquals( englishConditionOfFundingsDtoTest[1].description, englishConditionOfFunding2.description);
        assertEquals( englishConditionOfFundingsDtoTest[1].shortDescription, englishConditionOfFunding2.shortDescription);
        assertEquals( englishConditionOfFundingsDtoTest[1].validFrom, englishConditionOfFunding2.validFrom);
        assertEquals( englishConditionOfFundingsDtoTest[1].validTo, englishConditionOfFunding2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        EnglishConditionOfFundingDto englishConditionOfFundingDto1 = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        EnglishConditionOfFundingDto englishConditionOfFundingDto2 = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        assertEquals(englishConditionOfFundingDto1, englishConditionOfFundingDto2)
    }
    
    @Test
    public void testEquals_Different() {
        EnglishConditionOfFundingDto englishConditionOfFundingDto1 = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        EnglishConditionOfFundingDto englishConditionOfFundingDto2 = new EnglishConditionOfFundingDto(englishConditionOfFunding2)
        assertNotEquals(englishConditionOfFundingDto1, englishConditionOfFundingDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        EnglishConditionOfFundingDto englishConditionOfFundingDto1 = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        EnglishConditionOfFundingDto englishConditionOfFundingDto2 = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        assertEquals(englishConditionOfFundingDto1.hashCode(), englishConditionOfFundingDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        EnglishConditionOfFundingDto englishConditionOfFundingDto1 = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        EnglishConditionOfFundingDto englishConditionOfFundingDto2 = new EnglishConditionOfFundingDto(englishConditionOfFunding2)
        assertNotEquals(englishConditionOfFundingDto1.hashCode(), englishConditionOfFundingDto2.hashCode())
    }
    
    @Test
    public void testConstructor_EnglishConditionOfFunding() {
        EnglishConditionOfFundingDto englishConditionOfFundingDto = new EnglishConditionOfFundingDto(englishConditionOfFunding1)
        assertEquals( englishConditionOfFundingDto.code, englishConditionOfFunding1.code )
        assertEquals( englishConditionOfFundingDto.description, englishConditionOfFunding1.description )
        assertEquals( englishConditionOfFundingDto.shortDescription, englishConditionOfFunding1.shortDescription )
        assertEquals( englishConditionOfFundingDto.validFrom, englishConditionOfFunding1.validFrom )
        assertEquals( englishConditionOfFundingDto.validTo, englishConditionOfFunding1.validTo )
    }
}
