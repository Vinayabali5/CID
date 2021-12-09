package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.FundingModel

public class FundingModelDtoTest {
    
    private FundingModel fundingModel1
    
    private FundingModel fundingModel2
    
    private List<FundingModel> fundingModels
    
    @Before
    public void setup() {
        fundingModel1 = new FundingModel(
                id: 1,
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        fundingModel2 = new FundingModel(
                id: 2,
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        fundingModels = Arrays.asList(fundingModel1, fundingModel2);
    }
    
    @Test
    public void testMapFromFundingModelEntityTest() {
        FundingModelDto fundingModelTest = FundingModelDto.mapFromEntity( fundingModel1 )
        assertEquals( fundingModelTest.id, fundingModel1.id);
        assertEquals( fundingModelTest.code, fundingModel1.code);
        assertEquals( fundingModelTest.description, fundingModel1.description);
        assertEquals( fundingModelTest.shortDescription, fundingModel1.shortDescription);
        assertEquals( fundingModelTest.validFrom, fundingModel1.validFrom);
        assertEquals( fundingModelTest.validTo, fundingModel1.validTo);
    }
    
    @Test
    public void testMapFromFundingModelsEntitiesTest(){
        List<FundingModelDto> fundingModelsDtoTest = FundingModelDto.mapFromList(fundingModels)
        assertEquals( fundingModelsDtoTest[0].id, fundingModel1.id );
        assertEquals( fundingModelsDtoTest[0].code, fundingModel1.code );
        assertEquals( fundingModelsDtoTest[0].description, fundingModel1.description);
        assertEquals( fundingModelsDtoTest[0].shortDescription, fundingModel1.shortDescription);
        assertEquals( fundingModelsDtoTest[0].validFrom, fundingModel1.validFrom);
        assertEquals( fundingModelsDtoTest[0].validTo, fundingModel1.validTo);
        assertEquals( fundingModelsDtoTest[1].id, fundingModel2.id );
        assertEquals( fundingModelsDtoTest[1].code, fundingModel2.code );
        assertEquals( fundingModelsDtoTest[1].description, fundingModel2.description);
        assertEquals( fundingModelsDtoTest[1].shortDescription, fundingModel2.shortDescription);
        assertEquals( fundingModelsDtoTest[1].validFrom, fundingModel2.validFrom);
        assertEquals( fundingModelsDtoTest[1].validTo, fundingModel2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        FundingModelDto fundingModelDto1 = new FundingModelDto(fundingModel1)
        FundingModelDto fundingModelDto2 = new FundingModelDto(fundingModel1)
        assertEquals(fundingModelDto1, fundingModelDto2)
    }
    
    @Test
    public void testEquals_Different() {
        FundingModelDto fundingModelDto1 = new FundingModelDto(fundingModel1)
        FundingModelDto fundingModelDto2 = new FundingModelDto(fundingModel2)
        assertNotEquals(fundingModelDto1, fundingModelDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        FundingModelDto fundingModelDto1 = new FundingModelDto(fundingModel1)
        FundingModelDto fundingModelDto2 = new FundingModelDto(fundingModel1)
        assertEquals(fundingModelDto1.hashCode(), fundingModelDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        FundingModelDto fundingModelDto1 = new FundingModelDto(fundingModel1)
        FundingModelDto fundingModelDto2 = new FundingModelDto(fundingModel2)
        assertNotEquals(fundingModelDto1.hashCode(), fundingModelDto2.hashCode())
    }
    
    @Test
    public void testConstructor_FundingModel() {
        FundingModelDto fundingModelDto = new FundingModelDto(fundingModel1)
        assertEquals( fundingModelDto.code, fundingModel1.code )
        assertEquals( fundingModelDto.description, fundingModel1.description )
        assertEquals( fundingModelDto.shortDescription, fundingModel1.shortDescription )
        assertEquals( fundingModelDto.validFrom, fundingModel1.validFrom )
        assertEquals( fundingModelDto.validTo, fundingModel1.validTo )
    }
    
    @Test
    public void testConstructor_NullFundingModel() {
        FundingModel fundingModel = null
        FundingModelDto fundingModelDto = new FundingModelDto(fundingModel)
        assertEquals( fundingModel, null )
    }
}
