package uk.ac.reigate.services

import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.NoteType
import uk.ac.reigate.dto.MasterRegisterDto
import uk.ac.reigate.dto.lookup.NoteTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.NoteTypeRepository
import uk.ac.reigate.services.lookup.NoteTypeService


class NoteTypeServiceTest {
    
    private NoteTypeRepository noteTypeRepository;
    
    private NoteTypeService noteTypeService;
    
    private NoteType noteType;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.noteTypeRepository = Mockito.mock(NoteTypeRepository.class);
        this.noteTypeService = new NoteTypeService(noteTypeRepository);
        
        noteType = new NoteType(
                id: 1,
                code: 'A',
                description: 'A NoteType'
                )
        
        when(noteTypeRepository.findById(1)).thenReturn(new Optional(noteType));
    }
    
    @Test
    public void testFindNoteTypes() {
        List<NoteType> result = noteTypeService.findAll();
        verify(noteTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testFindNoteType() {
        NoteType result = noteTypeService.findById(1);
        verify(noteTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testSaveNewNoteType() {
        NoteType savedNoteType = noteTypeService.save(noteType);
        verify(noteTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testSaveNoteType() {
        NoteType savedNoteType = noteTypeService.save(noteType);
        verify(noteTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testSaveNoteTypes() {
        List<NoteType> savedNoteTypes = noteTypeService.saveNoteTypes([
            new NoteType(id: 1),
            new NoteType(id: 2)
        ]);
        verify(noteTypeRepository, times(2)).save(any(NoteType.class))
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testSaveNoteTypeByFields_WithNullId() {
        NoteType savedNoteType = noteTypeService.save(noteType);
        verify(noteTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        NoteTypeDto dto = new NoteTypeDto(id: 1, code: 'Test')
        noteTypeService.createFromDto(dto)
        verify(noteTypeRepository, times(1)).save(any(NoteType.class))
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create noteType from null object.")
        NoteTypeDto dto = null
        noteTypeService.createFromDto(dto)
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update noteType from null object.")
        NoteTypeDto dto = null
        noteTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(noteTypeRepository)
    }
}
