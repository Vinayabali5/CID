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

import uk.ac.reigate.domain.NoteType
import uk.ac.reigate.dto.lookup.NoteTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.NoteTypeRepository


class NoteTypeServiceTest {
    
    @Mock
    private NoteTypeRepository noteTypeRepository;
    
    @InjectMocks
    private NoteTypeService noteTypeService;
    
    private NoteType noteType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample NoteType data object to use for the testing
     * 
     * @return a sample NoteType data object
     */
    NoteType createNoteType() {
        return new NoteType(
                id: 1,
                code: 'Gen',
                description: 'General Notes'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample NoteType created at setup
     * 
     * @return a NoteTypeDto object based on the sample NoteType
     */
    NoteTypeDto createDto() {
        return new NoteTypeDto(
                id: noteType.id,
                code: noteType.code,
                description: noteType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the NoteTypeService
     */
    @Before
    public void setup() {
        this.noteTypeRepository = Mockito.mock(NoteTypeRepository.class);
        this.noteTypeService = new NoteTypeService(noteTypeRepository);
        
        noteType = createNoteType()
        
        when(noteTypeRepository.save(any(NoteType.class))).thenReturn(noteType);
        when(noteTypeRepository.findById(1)).thenReturn(new Optional(noteType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        NoteTypeService service = new NoteTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<NoteType> result = noteTypeService.findAll();
        verify(noteTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        NoteType result = noteTypeService.findById(1);
        verify(noteTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        NoteType savedNoteType = noteTypeService.save(noteType);
        verify(noteTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<NoteType> savedNoteTypes = noteTypeService.saveNoteTypes([noteType, noteType]);
        verify(noteTypeRepository, times(2)).save(noteType)
        verifyNoMoreInteractions(noteTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        NoteTypeDto dto = createDto()
        NoteType noteTypeSaved = noteTypeService.createFromDto(dto)
        verify(noteTypeRepository, times(1)).save(any(NoteType.class))
        verifyNoMoreInteractions(noteTypeRepository)
        assertEquals(dto.id, noteType.id)
        assertEquals(dto.code, noteType.code)
        assertEquals(dto.description, noteType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create noteType from null object.")
        NoteTypeDto dto = null
        noteTypeService.createFromDto(dto)
        verifyNoMoreInteractions(noteTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        NoteTypeDto dto = createDto()
        NoteType noteTypeSaved = noteTypeService.updateFromDto(dto)
        verify(noteTypeRepository, times(1)).findById(noteType.id)
        verify(noteTypeRepository, times(1)).save(noteType)
        verifyNoMoreInteractions(noteTypeRepository)
        assertEquals(noteType.id, noteTypeSaved.id)
        assertEquals(noteType.code, noteTypeSaved.code)
        assertEquals(noteType.description, noteTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        NoteTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        NoteType noteTypeSaved = noteTypeService.updateFromDto(dto)
        verify(noteTypeRepository, times(1)).findById(noteType.id)
        verify(noteTypeRepository, times(1)).save(noteType)
        verifyNoMoreInteractions(noteTypeRepository)
        assertEquals(noteType.id, noteTypeSaved.id)
        assertEquals(noteType.code, noteTypeSaved.code)
        assertEquals(noteType.description, noteTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update noteType from null object.")
        NoteTypeDto dto = null
        noteTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(noteTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        noteTypeService.delete(noteType)
        verifyNoMoreInteractions(noteTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}