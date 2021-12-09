package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.dto.lookup.TitleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.TitleRepository


class TitleServiceTest {
    
    @Mock
    private TitleRepository titleRepository;
    
    @InjectMocks
    private TitleService titleService;
    
    private Title title
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Title data object to use for the testing
     * 
     * @return a sample Title data object
     */
    Title createTitle() {
        return new Title(
                id: 1,
                code: 'F',
                description: 'Father'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Title created at setup
     * 
     * @return a TitleDto object based on the sample Title
     */
    TitleDto createDto() {
        return new TitleDto(
                id: title.id,
                code: title.code,
                description: title.description
                )
    }
    
    /**
     * This method is used to set up the tests for the TitleService
     */
    @Before
    public void setup() {
        this.titleRepository = Mockito.mock(TitleRepository.class);
        this.titleService = new TitleService(titleRepository);
        
        title = createTitle()
        
        when(titleRepository.save(any(Title.class))).thenReturn(title);
        when(titleRepository.findById(1)).thenReturn(new Optional(title));
        when(titleRepository.findByDescription(title.description)).thenReturn(title);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        TitleService service = new TitleService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Title> result = titleService.findAll();
        verify(titleRepository, times(1)).findAll()
        verifyNoMoreInteractions(titleRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Title result = titleService.findById(1);
        verify(titleRepository, times(1)).findById(1)
        verifyNoMoreInteractions(titleRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Title savedTitle = titleService.save(title);
        verify(titleRepository, times(1)).save(any())
        verifyNoMoreInteractions(titleRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Title> savedTitles = titleService.saveTitles([title, title]);
        verify(titleRepository, times(2)).save(title)
        verifyNoMoreInteractions(titleRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        TitleDto dto = createDto()
        Title titleSaved = titleService.createFromDto(dto)
        verify(titleRepository, times(1)).save(any(Title.class))
        verifyNoMoreInteractions(titleRepository)
        assertEquals(dto.id, title.id)
        assertEquals(dto.code, title.code)
        assertEquals(dto.description, title.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create title from null object.")
        TitleDto dto = null
        titleService.createFromDto(dto)
        verifyNoMoreInteractions(titleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        TitleDto dto = createDto()
        Title titleSaved = titleService.updateFromDto(dto)
        verify(titleRepository, times(1)).findById(title.id)
        verify(titleRepository, times(1)).save(title)
        verifyNoMoreInteractions(titleRepository)
        assertEquals(title.id, titleSaved.id)
        assertEquals(title.code, titleSaved.code)
        assertEquals(title.description, titleSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        TitleDto dto = createDto()
        dto.code = null
        dto.description = null
        Title titleSaved = titleService.updateFromDto(dto)
        verify(titleRepository, times(1)).findById(title.id)
        verify(titleRepository, times(1)).save(title)
        verifyNoMoreInteractions(titleRepository)
        assertEquals(title.id, titleSaved.id)
        assertEquals(title.code, titleSaved.code)
        assertEquals(title.description, titleSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update title from null object.")
        TitleDto dto = null
        titleService.updateFromDto(dto)
        verifyNoMoreInteractions(titleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        titleService.delete(title)
        verifyNoMoreInteractions(titleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        Title result = titleService.findByDescription(title.description)
        verify(titleRepository, times(1)).findByDescription(title.description)
        verifyNoMoreInteractions(titleRepository)
    }
}

