package uk.ac.reigate.dto.admissions;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.admissions.InterviewCategory
import uk.ac.reigate.dto.admissions.InterviewCategoryDto

import static org.junit.Assert.*

public class InterviewCategoryDtoTest {
    
    private InterviewCategory interviewCategory1
    
    private InterviewCategory interviewCategory2
    
    private List<InterviewCategory> interviewCategories
    
    @Before
    public void setup() {
        interviewCategory1 = new InterviewCategory(
                id: 1,
                category:'C',
                description:'Conditional'
                );
        interviewCategory2 = new InterviewCategory(
                id: 2,
                category:'N',
                description:'Normal'
                );
        interviewCategories = Arrays.asList(interviewCategory1, interviewCategory2);
    }
    
    @Test
    public void testMapFromInterviewCategoryEntity(){
        InterviewCategoryDto interviewCategoryTest = InterviewCategoryDto.mapFromEntity( interviewCategory1 )
        assertEquals( interviewCategoryTest.id, interviewCategory1.id );
        assertEquals( interviewCategoryTest.category, interviewCategory1.category);
        assertEquals( interviewCategoryTest.description, interviewCategory1.description);
    }
    
    @Test
    public void testMapFromInterviewCategorysEntities(){
        List<InterviewCategoryDto> interviewCategorysDtoTest = InterviewCategoryDto.mapFromList( interviewCategories )
        assertEquals( interviewCategorysDtoTest[0].id, interviewCategory1.id );
        assertEquals( interviewCategorysDtoTest[0].category, interviewCategory1.category);
        assertEquals( interviewCategorysDtoTest[0].description, interviewCategory1.description);
        assertEquals( interviewCategorysDtoTest[1].id, interviewCategory2.id );
        assertEquals( interviewCategorysDtoTest[1].category, interviewCategory2.category);
        assertEquals( interviewCategorysDtoTest[1].description, interviewCategory2.description);
    }
    
    @Test
    public void testEquals_Same() {
        InterviewCategoryDto interviewCategoryDto1 = new InterviewCategoryDto(interviewCategory1)
        InterviewCategoryDto interviewCategoryDto2 = new InterviewCategoryDto(interviewCategory1)
        assertEquals(interviewCategoryDto1, interviewCategoryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        InterviewCategoryDto interviewCategoryDto1 = new InterviewCategoryDto(interviewCategory1)
        InterviewCategoryDto interviewCategoryDto2 = new InterviewCategoryDto(interviewCategory2)
        assertNotEquals(interviewCategoryDto1, interviewCategoryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        InterviewCategoryDto interviewCategoryDto1 = new InterviewCategoryDto(interviewCategory1)
        InterviewCategoryDto interviewCategoryDto2 = new InterviewCategoryDto(interviewCategory1)
        assertEquals(interviewCategoryDto1.hashCode(), interviewCategoryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        InterviewCategoryDto interviewCategoryDto1 = new InterviewCategoryDto(interviewCategory1)
        InterviewCategoryDto interviewCategoryDto2 = new InterviewCategoryDto(interviewCategory2)
        assertNotEquals(interviewCategoryDto1.hashCode(), interviewCategoryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_InterviewCategory() {
        InterviewCategoryDto interviewCategoryDto = new InterviewCategoryDto(interviewCategory1)
        assertEquals( interviewCategoryDto.category, interviewCategory1.category )
        assertEquals( interviewCategoryDto.description, interviewCategory1.description )
    }
    
    @Test
    public void testConstructor_NullInterviewCategory() {
        InterviewCategory interviewCategory = null
        InterviewCategoryDto interviewCategoryDto = new InterviewCategoryDto(interviewCategory)
        assertEquals( interviewCategoryDto.category, null )
    }
}
