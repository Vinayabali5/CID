package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.system.LetterTemplate


public class LetterTemplateDtoTest {
    
    private LetterTemplate letterTemplate1
    
    private LetterTemplate letterTemplate2
    
    private LetterTemplateDto letterTemplateDto
    
    private List<LetterTemplate> letterTemplates
    
    @Before
    public void setup() {
        letterTemplate1 = new LetterTemplate(
                id: 1,
                name:'GEN',
                description:'General LetterTemplate',
                templateText: 'Test',
                inUse: true
                );
        letterTemplate2 = new LetterTemplate(
                id: 2,
                name:'PER',
                description:'Permanent LetterTemplate',
                templateText: 'Test',
                inUse: true
                );
        letterTemplates = Arrays.asList(letterTemplate1, letterTemplate2);
        
        letterTemplateDto = new LetterTemplateDto(
                id: letterTemplate2.id,
                name:letterTemplate2.name,
                description:letterTemplate2.description,
                templateText: letterTemplate2.templateText,
                inUse: letterTemplate2.inUse
                );
    }
    
    @Test
    public void testConstructor_NullObjects() {
        LetterTemplate letterTemplate = null
        LetterTemplateDto letterTemplateDto = new LetterTemplateDto(letterTemplate)
        assertEquals( letterTemplate, null )
    }
    
    @Test
    public void testMapFromEntity(){
        LetterTemplateDto letterTemplateDtoTest = LetterTemplateDto.mapFromEntity( letterTemplate1 )
        assertEquals( letterTemplateDtoTest.id, letterTemplate1.id );
        assertEquals( letterTemplateDtoTest.name, letterTemplate1.name);
        assertEquals( letterTemplateDtoTest.description, letterTemplate1.description);
    }
    
    @Test
    public void testMapFromLettersTemplatesEntities(){
        List<LetterTemplateDto> letterTemplateDtoTest = LetterTemplateDto.mapFromList( letterTemplates )
        assertEquals( letterTemplateDtoTest[0].id, letterTemplate1.id );
        assertEquals( letterTemplateDtoTest[0].name, letterTemplate1.name);
        assertEquals( letterTemplateDtoTest[0].description, letterTemplate1.description);
        assertEquals( letterTemplateDtoTest[1].id, letterTemplate2.id );
        assertEquals( letterTemplateDtoTest[1].name, letterTemplate2.name);
        assertEquals( letterTemplateDtoTest[1].description, letterTemplate2.description);
    }
    
    @Test
    public void testEquals_Same() {
        LetterTemplateDto letterTemplateDto1 = new LetterTemplateDto(letterTemplate1)
        LetterTemplateDto letterTemplateDto2 = new LetterTemplateDto(letterTemplate1)
    }
    
    @Test
    public void testEquals_Different() {
        LetterTemplateDto letterTemplateDto1 = new LetterTemplateDto(letterTemplate1)
        LetterTemplateDto letterTemplateDto2 = new LetterTemplateDto(letterTemplate2)
        assertNotEquals(letterTemplateDto1, letterTemplateDto2)
    }
    
    @Test
    public void testHashCode_Different() {
        LetterTemplateDto letterTemplateDto1 = new LetterTemplateDto(letterTemplate1)
        LetterTemplateDto letterTemplateDto2 = new LetterTemplateDto(letterTemplate2)
        assertNotEquals(letterTemplateDto1.hashCode(), letterTemplateDto2.hashCode())
    }
    
    @Test
    public void testConstructor_LetterTemplate() {
        LetterTemplateDto letterTemplateDto = new LetterTemplateDto(letterTemplate1)
        assertEquals( letterTemplateDto.name, letterTemplate1.name )
        assertEquals( letterTemplateDto.description, letterTemplate1.description )
    }
}
