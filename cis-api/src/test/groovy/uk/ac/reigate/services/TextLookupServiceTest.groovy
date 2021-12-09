package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.TextLookup
import uk.ac.reigate.dto.TextLookUpDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.TextLookupRepository


class TextLookupServiceTest {
    
    @Mock
    private TextLookupRepository textLookupRepository;
    
    @InjectMocks
    private TextLookupService textLookupService;
    
    private TextLookup textLookup
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    TextLookup createTextLookup() {
        return new TextLookup(
                id: 1,
                name:'Test',
                text:'Testing',
                description: 'T'
                )
    }
    
    TextLookUpDto createDto() {
        TextLookup sampleData = createTextLookup()
        return new TextLookUpDto(
                id: sampleData.id,
                name:sampleData.name,
                text:sampleData.text,
                description: sampleData.description
                )
    }
    /**
     * This method is used to set up the tests for the TextLookupService
     */
    @Before
    public void setup() {
        this.textLookupRepository = Mockito.mock(TextLookupRepository.class);
        this.textLookupService = new TextLookupService(textLookupRepository)
        textLookup = createTextLookup()
        when(textLookupRepository.save(any(TextLookup.class))).thenReturn(textLookup);
        when(textLookupRepository.findById(1)).thenReturn(new Optional(textLookup));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        TextLookupService service = new TextLookupService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<TextLookup> result = textLookupService.findAll();
        verify(textLookupRepository, times(1)).findAll()
        verifyNoMoreInteractions(textLookupRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        TextLookup result = textLookupService.findById(1);
        verify(textLookupRepository, times(1)).findById(1)
        verifyNoMoreInteractions(textLookupRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        TextLookup savedTextLookup = textLookupService.create(textLookup);
        verify(textLookupRepository, times(1)).save(any())
        verifyNoMoreInteractions(textLookupRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update textLookUpDto from null object.")
        TextLookUpDto dto = null
        textLookupService.updateTextLookUp(dto)
        verify(textLookupRepository, times(1)).findById(1)
        verifyNoMoreInteractions(textLookupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testUpdateFromDto_withDto() {
        TextLookUpDto dto = createDto()
        textLookupService.updateTextLookUp(dto)
        verify(textLookupRepository, times(1)).findById(dto.id)
    }
    
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        textLookupService.delete(textLookup)
        verifyNoMoreInteractions(textLookupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}