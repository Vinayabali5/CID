package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.Note
import uk.ac.reigate.dto.NoteDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.NoteRepository
import uk.ac.reigate.services.lookup.NoteTypeService

@RunWith(MockitoJUnitRunner.class)
class NoteServiceTest {
    
    @Mock
    private NoteRepository noteRepository;
    
    @Mock
    private PersonService personService;
    
    @Mock
    private NoteTypeService noteTypeService;
    
    @InjectMocks
    private NoteService noteService;
    
    private Note note
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Note data object to use for the testing
     * 
     * @return a sample Note data object
     */
    Note createNote() {
        return new Note(
                id: 1,
                pastoral: true,
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Note created at setup
     * 
     * @return a NoteDto object based on the sample Note
     */
    NoteDto createDto() {
        Note sampleData = createNote()
        return new NoteDto(
                id: sampleData.id,
                pastoral: sampleData.pastoral
                )
    }
    
    /**
     * This method is used to set up the tests for the NoteService
     */
    @Before
    public void setup() {
        noteRepository = mock(NoteRepository.class);
        personService = mock(PersonService.class);
        noteTypeService = mock(NoteTypeService.class);
        noteService = new NoteService(noteRepository, personService, noteTypeService);
        
        note = createNote()
        
        when(noteRepository.save(any(Note.class))).thenReturn(note);
        when(noteRepository.findById(1)).thenReturn(new Optional(note));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        NoteService service = new NoteService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Note> result = noteService.findAll();
        verify(noteRepository, times(1)).findAll()
        verifyNoMoreInteractions(noteRepository)
    }
    
    @Test
    public void testGetNotesByPersonId() {
        List<Note> result = noteService.getNotesByPersonId(22);
        verify(noteRepository, times(1)).findByPerson_Id(22)
        verifyNoMoreInteractions(noteRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Note result = noteService.findById(1);
        verify(noteRepository, times(1)).findById(1)
        verifyNoMoreInteractions(noteRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Note savedNote = noteService.save(note);
        verify(noteRepository, times(1)).save(any())
        verifyNoMoreInteractions(noteRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Note> savedNotes = noteService.saveNotes([note, note]);
        verify(noteRepository, times(2)).save(note)
        verifyNoMoreInteractions(noteRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        NoteDto dto = createDto()
        Note noteSaved = noteService.createFromDto(dto)
        verify(noteRepository, times(1)).save(any(Note.class))
        verifyNoMoreInteractions(noteRepository)
    }
    
    @Test
    public void testCreateFromDto_withPersonId() {
        NoteDto dto = createDto()
        dto.personId = 1
        when(personService.findById(dto.personId)).thenReturn(null);
        Note noteSaved = noteService.createFromDto(dto)
        verify(noteRepository, times(1)).save(any(Note.class))
        verifyNoMoreInteractions(noteRepository)
    }
    
    @Test
    public void testCreateFromDto_withNoteId() {
        NoteDto dto = createDto()
        dto.typeId = 1
        when(noteTypeService.findById(dto.typeId)).thenReturn(null);
        Note noteSaved = noteService.createFromDto(dto)
        verify(noteRepository, times(1)).save(any(Note.class))
        verifyNoMoreInteractions(noteRepository)
    }
    
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create noteDto from null object.")
        NoteDto dto = null
        noteService.createFromDto(dto)
        verifyNoMoreInteractions(noteRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        NoteDto dto = createDto()
        Note noteSaved = noteService.updateFromDto(dto)
        verify(noteRepository, times(1)).findById(note.id)
        verify(noteRepository, times(1)).save(note)
        verifyNoMoreInteractions(noteRepository)
    }
    
    @Test
    public void testUpdateFromDto_PersonId() {
        NoteDto dto = createDto()
        dto.personId = 1
        when(personService.findById(dto.personId)).thenReturn(null);
        Note noteSaved = noteService.updateFromDto(dto)
        verify(personService, times(1)).findById(dto.personId)
        verifyNoMoreInteractions(personService)
    }
    
    @Test
    public void testUpdateFromDto_TypeId() {
        NoteDto dto = createDto()
        dto.typeId = 1
        when(noteTypeService.findById(dto.typeId)).thenReturn(null);
        Note noteSaved = noteService.updateFromDto(dto)
        verify(noteTypeService, times(1)).findById(dto.typeId)
        verifyNoMoreInteractions(noteTypeService)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update noteDto from null object.")
        NoteDto dto = null
        noteService.updateFromDto(dto)
        verifyNoMoreInteractions(noteRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        noteService.delete(note)
        verifyNoMoreInteractions(noteRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testDeleteById() {
        noteService.delete(note.id)
        verify(noteRepository, times(1)).deleteById(note.id)
        verifyNoMoreInteractions(noteRepository)
    }
}