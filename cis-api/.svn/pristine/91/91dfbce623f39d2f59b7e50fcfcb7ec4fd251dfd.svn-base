package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory

public class LLDDHealthProblemCategoryDtoTest {
    
    private LLDDHealthProblemCategory lLDDHealthProblemCategory1
    
    private LLDDHealthProblemCategory lLDDHealthProblemCategory2
    
    private List<LLDDHealthProblemCategory> lLDDHealthProblemCategorys
    
    @Before
    public void setup() {
        lLDDHealthProblemCategory1 = new LLDDHealthProblemCategory();
        lLDDHealthProblemCategory2 = new LLDDHealthProblemCategory();
        lLDDHealthProblemCategorys = Arrays.asList(lLDDHealthProblemCategory1, lLDDHealthProblemCategory2);
    }
    
    @Test
    public void testMapFromLLDDHealthProblemCategoryEntityTest() {
        LLDDHealthProblemCategoryDto lLDDHealthProblemCategoryTest = LLDDHealthProblemCategoryDto.mapFromEntity( lLDDHealthProblemCategory1 )
        assertEquals( lLDDHealthProblemCategoryTest.id, lLDDHealthProblemCategory1.id);
        assertEquals( lLDDHealthProblemCategoryTest.code, lLDDHealthProblemCategory1.code);
        assertEquals( lLDDHealthProblemCategoryTest.description, lLDDHealthProblemCategory1.description);
        assertEquals( lLDDHealthProblemCategoryTest.shortDescription, lLDDHealthProblemCategory1.shortDescription);
        assertEquals( lLDDHealthProblemCategoryTest.validFrom, lLDDHealthProblemCategory1.validFrom);
        assertEquals( lLDDHealthProblemCategoryTest.validTo, lLDDHealthProblemCategory1.validTo);
    }
    
    @Test
    public void testMapFromLLDDHealthProblemCategoriesEntitiesTest(){
        List<LLDDHealthProblemCategoryDto> lLDDHealthProblemCategorysDtoTest = LLDDHealthProblemCategoryDto.mapFromList(lLDDHealthProblemCategorys)
        assertEquals( lLDDHealthProblemCategorysDtoTest[0].id, lLDDHealthProblemCategory1.id );
        assertEquals( lLDDHealthProblemCategorysDtoTest[0].code, lLDDHealthProblemCategory1.code );
        assertEquals( lLDDHealthProblemCategorysDtoTest[0].description, lLDDHealthProblemCategory1.description);
        assertEquals( lLDDHealthProblemCategorysDtoTest[0].shortDescription, lLDDHealthProblemCategory1.shortDescription);
        assertEquals( lLDDHealthProblemCategorysDtoTest[0].validFrom, lLDDHealthProblemCategory1.validFrom);
        assertEquals( lLDDHealthProblemCategorysDtoTest[0].validTo, lLDDHealthProblemCategory1.validTo);
        assertEquals( lLDDHealthProblemCategorysDtoTest[1].id, lLDDHealthProblemCategory2.id );
        assertEquals( lLDDHealthProblemCategorysDtoTest[1].code, lLDDHealthProblemCategory2.code );
        assertEquals( lLDDHealthProblemCategorysDtoTest[1].description, lLDDHealthProblemCategory2.description);
        assertEquals( lLDDHealthProblemCategorysDtoTest[1].shortDescription, lLDDHealthProblemCategory2.shortDescription);
        assertEquals( lLDDHealthProblemCategorysDtoTest[1].validFrom, lLDDHealthProblemCategory2.validFrom);
        assertEquals( lLDDHealthProblemCategorysDtoTest[1].validTo, lLDDHealthProblemCategory2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        LLDDHealthProblemCategoryDto lLDDHealthProblemCategoryDto1 = new LLDDHealthProblemCategoryDto(lLDDHealthProblemCategory1)
        LLDDHealthProblemCategoryDto lLDDHealthProblemCategoryDto2 = new LLDDHealthProblemCategoryDto(lLDDHealthProblemCategory1)
        assertEquals(lLDDHealthProblemCategoryDto1, lLDDHealthProblemCategoryDto2)
    }
    
    @Test
    public void testConstructor_LLDDHealthProblemCategory() {
        LLDDHealthProblemCategoryDto lLDDHealthProblemCategoryDto = new LLDDHealthProblemCategoryDto(lLDDHealthProblemCategory1)
        assertEquals( lLDDHealthProblemCategoryDto.code, lLDDHealthProblemCategory1.code )
        assertEquals( lLDDHealthProblemCategoryDto.description, lLDDHealthProblemCategory1.description )
        assertEquals( lLDDHealthProblemCategoryDto.shortDescription, lLDDHealthProblemCategory1.shortDescription )
        assertEquals( lLDDHealthProblemCategoryDto.validFrom, lLDDHealthProblemCategory1.validFrom )
        assertEquals( lLDDHealthProblemCategoryDto.validTo, lLDDHealthProblemCategory1.validTo )
    }
}