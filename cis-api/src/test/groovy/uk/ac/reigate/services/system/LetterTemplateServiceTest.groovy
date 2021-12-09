package uk.ac.reigate.services.system

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.system.LetterTemplate
import uk.ac.reigate.dto.LetterTemplateDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.system.LetterTemplateRepository


class LetterTemplateServiceTest {
    
    @Mock
    private LetterTemplateRepository letterTemplateRepository;
    
    @InjectMocks
    private LetterTemplateService letterTemplateService;
    
    private LetterTemplate letterTemplate
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    
    LetterTemplate createLetterTemplate() {
        return new LetterTemplate(
                id: 1,
                name: 'test',
                description: 'testing',
                templateText: 'template',
                inUse: true
                )
    }
    
    LetterTemplateDto createDto() {
        return new LetterTemplateDto(
                id: letterTemplate.id,
                name : letterTemplate.name,
                description: letterTemplate.description,
                templateText : letterTemplate.templateText,
                inUse : letterTemplate.inUse
                )
    }
    /**
     * This method is used to set up the tests for the LetterTemplateService
     */
    @Before
    public void setup() {
        this.letterTemplateRepository = Mockito.mock(LetterTemplateRepository.class);
        this.letterTemplateService = new LetterTemplateService(letterTemplateRepository);
        
        letterTemplate = createLetterTemplate()
        when(letterTemplateRepository.findById(letterTemplate.id)).thenReturn(new Optional(letterTemplate));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LetterTemplateService service = new LetterTemplateService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<LetterTemplate> result = letterTemplateService.findAll();
        verify(letterTemplateRepository, times(1)).findAll()
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        LetterTemplate result = letterTemplateService.findById(1);
        verify(letterTemplateRepository, times(1)).findById(1)
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        LetterTemplate savedLetterTemplate = letterTemplateService.save(letterTemplate);
        verify(letterTemplateRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    @Test
    public void testFindValidLetterTemplates() {
        List<LetterTemplate> result = letterTemplateService.findValidLetterTemplates();
        verify(letterTemplateRepository, times(1)).findValidTemplate()
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Letter Template should not be deleted");
        letterTemplateService.delete(new LetterTemplate(id: 1))
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        LetterTemplateDto dto = new LetterTemplateDto(name: 'test', description : 'testing')
        letterTemplateService.createFromDto(dto)
        verify(letterTemplateRepository, times(1)).save(any(LetterTemplate.class))
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create LetterTemplate from null object.")
        LetterTemplateDto dto = null
        letterTemplateService.createFromDto(dto)
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        LetterTemplateDto dto = createDto()
        letterTemplateService.updateFromDto(dto)
        verify(letterTemplateRepository, times(1)).findById(letterTemplate.id)
        verify(letterTemplateRepository, times(1)).save(any(LetterTemplate.class))
        verifyNoMoreInteractions(letterTemplateRepository)
    }
    
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update LetterTemplate from null object.")
        LetterTemplateDto dto = null
        letterTemplateService.updateFromDto(dto)
        verifyNoMoreInteractions(letterTemplateRepository)
    }
}