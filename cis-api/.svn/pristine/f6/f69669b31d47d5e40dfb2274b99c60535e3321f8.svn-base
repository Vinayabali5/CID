package uk.ac.reigate.services.ilp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.LetterWarningParagraph
import uk.ac.reigate.dto.LetterWarningParagraphDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.LetterWarningParagraphRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class LetterWarningParagraphService implements ICoreDataService<LetterWarningParagraph, Integer>, IDtoCreateUpdateService<LetterWarningParagraphDto, LetterWarningParagraph>{
    
    @Autowired
    LetterWarningParagraphRepository letterWarningParagraphRepository
    
    /**
     * Default NoArgs constructor    
     */
    LetterWarningParagraphService() {}
    
    /**
     * Autowired constructor
     * 
     * @param letterWarningParagraphRepository
     */
    LetterWarningParagraphService(LetterWarningParagraphRepository letterWarningParagraphRepository) {
        this.letterWarningParagraphRepository = letterWarningParagraphRepository
    }
    
    /**
     * Find an individual letterWarningParagraph using the letterWarningParagraphs ID fields
     *
     * @param id the ID fields to search for
     * @return the LetterWarningParagraph object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LetterWarningParagraph findById(Integer id) {
        return letterWarningParagraphRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all letterWarningParagraphs
     *
     * @return a SearchResult set with the list of LetterWarningParagraphs
     */
    @Override
    @Transactional(readOnly = true)
    List<LetterWarningParagraph> findAll() {
        return letterWarningParagraphRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete LetterWarningParagraph object in the database
     *
     * @param letterWarningParagraph the new LetterWarningParagraph object to be saved
     * @return the saved version of the LetterWarningParagraph object
     */
    @Override
    @Transactional
    public LetterWarningParagraph save(LetterWarningParagraph letterWarningParagraph) {
        return letterWarningParagraphRepository.save(letterWarningParagraph)
    }
    
    /**
     * This service method is used to update a LetterWarningParagraph object in the database from a partial or complete LetterWarningParagraph object.
     *
     * @param letterWarningParagraph the partial or complete LetterWarningParagraph object to be saved
     * @return the saved version of the LetterWarningParagraph object
     */
    @Transactional
    public LetterWarningParagraph createFromDto(LetterWarningParagraphDto letterWarningParagraph) {
        if (letterWarningParagraph == null) {
            throw new InvalidDataException("Cannot create letterWarningParagraph from null object.")
        }
        LetterWarningParagraph letterWarningParagraphToSave = new LetterWarningParagraph();
        letterWarningParagraphToSave.id = letterWarningParagraph.id
        letterWarningParagraphToSave.description = letterWarningParagraph.description
        return save(letterWarningParagraphToSave)
    }
    
    /**
     * This service method is used to update a LetterWarningParagraph object in the database from a partial or complete LetterWarningParagraph object.
     *
     * @param letterWarningParagraph the partial or complete LetterWarningParagraph object to be saved
     * @return the saved version of the LetterWarningParagraph object
     */
    @Transactional
    public LetterWarningParagraph updateFromDto(LetterWarningParagraphDto letterWarningParagraph) {
        if (letterWarningParagraph == null) {
            throw new InvalidDataException("Cannot update letterWarningParagraph from null object.")
        }
        LetterWarningParagraph letterWarningParagraphToSave = findById(letterWarningParagraph.id)
        letterWarningParagraphToSave.description = letterWarningParagraph.description
        return save(letterWarningParagraphToSave)
    }
    
    /**
     * Saves a list of LetterWarningParagraph objects to the database
     *
     * @param letterWarningParagraphs a list of LetterWarningParagraphs to be saved to the database
     * @return the list of save LetterWarningParagraph objects
     */
    @Transactional
    public List<LetterWarningParagraph> saveLetterWarningParagraphs(List<LetterWarningParagraph> letterWarningParagraphs) {
        return letterWarningParagraphs.collect { letterWarningParagraph -> save(letterWarningParagraph) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. LetterWarningParagraph should not be deleted.
     */
    @Override
    public void delete(LetterWarningParagraph obj) {
        throw new InvalidOperationException("LetterWarningParagraph should not be deleted")
    }
}
