package uk.ac.reigate.services.ilp

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilp.LetterWarningParagraph;
import uk.ac.reigate.dto.LetterWarningParagraphDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.LetterWarningParagraphRepository


class LetterWarningParagraphServiceTest {
    
    private LetterWarningParagraphRepository letterWarningParagraphRepository
    
    private LetterWarningParagraphService letterWarningParagraphService;
    
    private LetterWarningParagraph letterWarningParagraph
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.letterWarningParagraphRepository = Mockito.mock(LetterWarningParagraphRepository.class);
        this.letterWarningParagraphService = new LetterWarningParagraphService(letterWarningParagraphRepository);
        
        letterWarningParagraph = new LetterWarningParagraph(
                id: 1,
                description: 'A'
                )
        
        when(letterWarningParagraphRepository.findById(1)).thenReturn(new Optional(letterWarningParagraph));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LetterWarningParagraphService service = new LetterWarningParagraphService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<LetterWarningParagraph> result = letterWarningParagraphService.findAll();
        verify(letterWarningParagraphRepository, times(1)).findAll()
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testFindById() {
        LetterWarningParagraph result = letterWarningParagraphService.findById(1);
        verify(letterWarningParagraphRepository, times(1)).findById(1)
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testSave() {
        LetterWarningParagraph savedLetterWarningParagraph = letterWarningParagraphService.save(letterWarningParagraph);
        verify(letterWarningParagraphRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testSaveLetterWarningParagraph() {
        LetterWarningParagraph savedLetterWarningParagraph = letterWarningParagraphService.save(letterWarningParagraph);
        verify(letterWarningParagraphRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testSaveLetterWarningParagraphs() {
        List<LetterWarningParagraph> savedLetterWarningParagraphs = letterWarningParagraphService.saveLetterWarningParagraphs([
            new LetterWarningParagraph(id : 1),
            new LetterWarningParagraph(id: 2)
        ]);
        verify(letterWarningParagraphRepository, times(2)).save(any(LetterWarningParagraph.class))
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testSaveLetterWarningParagraphByFields() {
        LetterWarningParagraph savedLetterWarningParagraph = letterWarningParagraphService.save(letterWarningParagraph);
        verify(letterWarningParagraphRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testCreateFromDto_Dto() {
        LetterWarningParagraphDto dto = new LetterWarningParagraphDto(id: 1, description:'Test')
        letterWarningParagraphService.createFromDto(dto)
        verify(letterWarningParagraphRepository, times(1)).save(any(LetterWarningParagraph.class))
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testUpdateFromDto_Dto() {
        LetterWarningParagraphDto dto = new LetterWarningParagraphDto(id: 1, description:'Test')
        letterWarningParagraphService.updateFromDto(dto)
        verify(letterWarningParagraphRepository, times(1)).findById(dto.id)
        verify(letterWarningParagraphRepository, times(1)).save(any(LetterWarningParagraph.class))
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testCreateFromDto_WithNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create letterWarningParagraph from null object.")
        LetterWarningParagraphDto dto = null
        letterWarningParagraphService.createFromDto(dto)
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testupdateFromDto_WithNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update letterWarningParagraph from null object.")
        LetterWarningParagraphDto dto = null
        letterWarningParagraphService.updateFromDto(dto)
        verifyNoMoreInteractions(letterWarningParagraphRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        letterWarningParagraphService.delete(letterWarningParagraph)
        verifyNoMoreInteractions(letterWarningParagraphRepository)
        assertThatExceptionOfType(InvalidOperationException.class)
    }
}

