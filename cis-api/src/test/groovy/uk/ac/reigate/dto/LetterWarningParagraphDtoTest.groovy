package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilp.LetterWarningParagraph


public class LetterWarningParagraphDtoTest {
    
    private LetterWarningParagraph letterWarningParagraph1
    
    private LetterWarningParagraph letterWarningParagraph2
    
    private List<LetterWarningParagraph> letterWarningParagraphs
    
    @Before
    public void setup() {
        letterWarningParagraph1 = new LetterWarningParagraph(
                id: 1,
                description:'General LetterWarningParagraph'
                );
        letterWarningParagraph2 = new LetterWarningParagraph(
                id: 2,
                description:'Permanent LetterWarningParagraph'
                );
        letterWarningParagraphs = Arrays.asList(letterWarningParagraph1, letterWarningParagraph2);
    }
    
    @Test
    public void testMapFromLetterWarningParagraphEntity(){
        LetterWarningParagraphDto letterWarningParagraphTest = LetterWarningParagraphDto.mapFromEntity( letterWarningParagraph1 )
        assertEquals( letterWarningParagraphTest.id, letterWarningParagraph1.id );
        assertEquals( letterWarningParagraphTest.description, letterWarningParagraph1.description);
    }
    
    @Test
    public void testMapFromLetterWarningParagraphsEntities(){
        List<LetterWarningParagraphDto> letterWarningParagraphDtoTest = LetterWarningParagraphDto.mapFromList( letterWarningParagraphs )
        assertEquals( letterWarningParagraphDtoTest[0].id, letterWarningParagraph1.id );
        assertEquals( letterWarningParagraphDtoTest[0].description, letterWarningParagraph1.description);
        assertEquals( letterWarningParagraphDtoTest[1].id, letterWarningParagraph2.id );
        assertEquals( letterWarningParagraphDtoTest[1].description, letterWarningParagraph2.description);
    }
    
    @Test
    public void testEquals_Same() {
        LetterWarningParagraphDto letterWarningParagraphDto1 = new LetterWarningParagraphDto(letterWarningParagraph1)
        LetterWarningParagraphDto letterWarningParagraphDto2 = new LetterWarningParagraphDto(letterWarningParagraph1)
        assertEquals(letterWarningParagraphDto1, letterWarningParagraphDto2)
    }
    
    @Test
    public void testEquals_Different() {
        LetterWarningParagraphDto letterWarningParagraphDto1 = new LetterWarningParagraphDto(letterWarningParagraph1)
        LetterWarningParagraphDto letterWarningParagraphDto2 = new LetterWarningParagraphDto(letterWarningParagraph2)
        assertNotEquals(letterWarningParagraphDto1, letterWarningParagraphDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        LetterWarningParagraphDto letterWarningParagraphDto1 = new LetterWarningParagraphDto(letterWarningParagraph1)
        LetterWarningParagraphDto letterWarningParagraphDto2 = new LetterWarningParagraphDto(letterWarningParagraph1)
        assertEquals(letterWarningParagraphDto1.hashCode(), letterWarningParagraphDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        LetterWarningParagraphDto letterWarningParagraphDto1 = new LetterWarningParagraphDto(letterWarningParagraph1)
        LetterWarningParagraphDto letterWarningParagraphDto2 = new LetterWarningParagraphDto(letterWarningParagraph2)
        assertNotEquals(letterWarningParagraphDto1.hashCode(), letterWarningParagraphDto2.hashCode())
    }
    
    @Test
    public void testConstructor_LetterWarningParagraph() {
        LetterWarningParagraphDto letterWarningParagraphDto = new LetterWarningParagraphDto(letterWarningParagraph1)
        assertEquals( letterWarningParagraphDto.description, letterWarningParagraph1.description )
    }
    
    @Test
    public void testConstructor_NullLetterWarningParagraph() {
        LetterWarningParagraph letterWarningParagraph = null
        LetterWarningParagraphDto letterWarningParagraphDto = new LetterWarningParagraphDto(letterWarningParagraph)
        assertEquals( letterWarningParagraph, null)
    }
}
