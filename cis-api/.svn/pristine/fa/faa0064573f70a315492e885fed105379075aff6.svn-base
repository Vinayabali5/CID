package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.Note
import uk.ac.reigate.dto.NoteDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.NoteRepository
import uk.ac.reigate.services.lookup.NoteTypeService

@Service
@RequiredArgsConstructor
class NoteService implements ICoreDataService<Note, Integer>, IDtoCreateUpdateService<NoteDto, Note>{
    
    @Autowired
    NoteRepository noteRepository
    
    @Autowired
    PersonService personService
    
    @Autowired
    NoteTypeService noteTypeService
    
    /**
     * Default NoArgs constructor
     */
    NoteService() {}
    
    /**
     * Autowired Constructor
     *
     * @param noteRepository
     */
    NoteService(NoteRepository noteRepository, PersonService personService, NoteTypeService noteTypeService) {
        super();
        this.noteRepository = noteRepository;
        this.personService= personService;
        this.noteTypeService = noteTypeService;
    }
    
    /**
     * Find an individual note using the notes ID fields
     *
     * @param id the ID fields to search for
     * @return the Note object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Note findById(Integer id) {
        return noteRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all notes
     *
     * @return a SearchResult set with the list of Notes
     */
    @Override
    @Transactional(readOnly = true)
    List<Note> findAll() {
        return noteRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Note object in the database
     *
     * @param note the new Note object to be saved
     * @return the saved version of the Note object
     */
    @Override
    @Transactional
    public Note save(Note note) {
        return noteRepository.save(note)
    }
    
    /**
     * Saves a list of Note objects to the database
     *
     * @param notes a list of Notes to be saved to the database
     * @return the list of save Note objects
     */
    @Transactional
    public List<Note> saveNotes(List<Note> notes) {
        return notes.collect { note -> save( note) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Note should not be deleted.
     */
    @Override
    public void delete(Note note) {
        throw new InvalidOperationException("Note should not be deleted")
    }
    
    /**
     * This service method is used to delete a complete Note object in the database
     *
     * @param noteId the object to be deleted
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer noteId){
        noteRepository.deleteById(noteId)
    }
    
    /** Returns Notes for a given personId
     * @param personId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Note> getNotesByPersonId(Integer personId){
        return noteRepository.findByPerson_Id(personId)
    }
    
    /**
     * This method is used to create a new Note object from a NoteDto object. 
     * 
     * @param noteDto a NoteDto object to create a new Note from 
     * @return the save Note object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public Note createFromDto(NoteDto noteDto){
        if (noteDto == null) {
            throw new InvalidDataException("Cannot create noteDto from null object.")
        }
        Note note = new Note()
        if(noteDto.personId != null) {
            note.person = personService.findById(noteDto.personId)
        }
        note.note = noteDto.note
        if(noteDto.typeId != null) {
            note.type = noteTypeService.findById(noteDto.typeId)
        }
        note.pastoral = noteDto.pastoral
        return save(note)
    }
    
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public Note updateFromDto(NoteDto noteDto){
        if (noteDto == null) {
            throw new InvalidDataException("Cannot update noteDto from null object.")
        }
        Note note = findById(noteDto.id)
        if(noteDto.personId != null) {
            note.person = personService.findById(noteDto.personId)
        }
        if(noteDto.typeId != null) {
            note.type = noteTypeService.findById(noteDto.typeId)
        }
        note.note = noteDto.note
        note.pastoral = noteDto.pastoral
        return save(note)
    }
}
