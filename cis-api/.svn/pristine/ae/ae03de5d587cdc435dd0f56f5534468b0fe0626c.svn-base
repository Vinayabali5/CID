package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.learning_support.LearningSupportCostCategory
import uk.ac.reigate.exceptions.InvalidDataException


public class LearningSupportCostCategoryDtoTest {
    
    private LearningSupportCostCategory learningSupportCostCategory1
    
    private LearningSupportCostCategory learningSupportCostCategory2
    
    private List<LearningSupportCostCategory> learningSupportCostCategories
    
    @Before
    public void setup() {
        learningSupportCostCategory1 = new LearningSupportCostCategory(
                id: 1,
                category:'M'
                );
        learningSupportCostCategory2 = new LearningSupportCostCategory(
                id: 2,
                category:'F'
                );
        learningSupportCostCategories = Arrays.asList(learningSupportCostCategory1, learningSupportCostCategory2);
    }
    
    @Test
    public void testConstructor_NullLearningSupportCostCategory() {
        LearningSupportCostCategory learningSupportCostCategory = null
        LearningSupportCostCategoryDto learningSupportCostCategoryDto = new LearningSupportCostCategoryDto(learningSupportCostCategory)
        assertEquals( learningSupportCostCategory, null );
    }
    
    @Test
    public void testMapFromLearningSupportCostCategoryEntity(){
        LearningSupportCostCategoryDto learningSupportCostCategoryTest = LearningSupportCostCategoryDto.mapFromEntity( learningSupportCostCategory1 )
        assertEquals( learningSupportCostCategoryTest.id, learningSupportCostCategory1.id );
        assertEquals( learningSupportCostCategoryTest.category, learningSupportCostCategory1.category);
    }
    
    @Test
    public void testMapFromLearningSupportCostCategorysEntities(){
        List<LearningSupportCostCategoryDto> learningSupportCostCategorysDtoTest = LearningSupportCostCategoryDto.mapFromList( learningSupportCostCategories )
        assertEquals( learningSupportCostCategorysDtoTest[0].id, learningSupportCostCategory1.id );
        assertEquals( learningSupportCostCategorysDtoTest[0].category, learningSupportCostCategory1.category);
        assertEquals( learningSupportCostCategorysDtoTest[1].id, learningSupportCostCategory2.id );
        assertEquals( learningSupportCostCategorysDtoTest[1].category, learningSupportCostCategory2.category);
    }
    
    @Test
    public void testEquals_Same() {
        LearningSupportCostCategoryDto learningSupportCostCategoryDto1 = new LearningSupportCostCategoryDto(learningSupportCostCategory1)
        LearningSupportCostCategoryDto learningSupportCostCategoryDto2 = new LearningSupportCostCategoryDto(learningSupportCostCategory1)
        assertEquals(learningSupportCostCategoryDto1, learningSupportCostCategoryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        LearningSupportCostCategoryDto learningSupportCostCategoryDto1 = new LearningSupportCostCategoryDto(learningSupportCostCategory1)
        LearningSupportCostCategoryDto learningSupportCostCategoryDto2 = new LearningSupportCostCategoryDto(learningSupportCostCategory2)
        assertNotEquals(learningSupportCostCategoryDto1, learningSupportCostCategoryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        LearningSupportCostCategoryDto learningSupportCostCategoryDto1 = new LearningSupportCostCategoryDto(learningSupportCostCategory1)
        LearningSupportCostCategoryDto learningSupportCostCategoryDto2 = new LearningSupportCostCategoryDto(learningSupportCostCategory1)
        assertEquals(learningSupportCostCategoryDto1.hashCode(), learningSupportCostCategoryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        LearningSupportCostCategoryDto learningSupportCostCategoryDto1 = new LearningSupportCostCategoryDto(learningSupportCostCategory1)
        LearningSupportCostCategoryDto learningSupportCostCategoryDto2 = new LearningSupportCostCategoryDto(learningSupportCostCategory2)
        assertNotEquals(learningSupportCostCategoryDto1.hashCode(), learningSupportCostCategoryDto2.hashCode())
    }
}
