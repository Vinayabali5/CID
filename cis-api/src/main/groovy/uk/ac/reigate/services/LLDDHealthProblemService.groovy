package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.LLDDHealthProblem
import uk.ac.reigate.dto.LLDDHealthProblemDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.ilr.LLDDHealthProblemRepository

@Service
class LLDDHealthProblemService implements ICoreDataService<LLDDHealthProblem, Integer>, IDtoCreateUpdateService<LLDDHealthProblemDto,LLDDHealthProblem>{
    
    @Autowired
    LLDDHealthProblemRepository lLDDHealthProblemRepository
    
    /**
     * Default NoArgs constructor
     */
    LLDDHealthProblemService() {}
    
    /**
     * Autowired Constructor
     *
     * @param lLDDHealthProblemRepository
     */
    LLDDHealthProblemService(LLDDHealthProblemRepository lLDDHealthProblemRepository) {
        this.lLDDHealthProblemRepository = lLDDHealthProblemRepository;
    }
    
    /**
     * Find an individual lLDDHealthProblem using the lLDDHealthProblems ID fields
     *
     * @param id the ID fields to search for
     * @return the LLDDHealthProblem object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LLDDHealthProblem findById(Integer id) {
        return lLDDHealthProblemRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all lLDDHealthProblems
     *
     * @return a SearchResult set with the list of LLDDHealthProblems
     */
    @Override
    @Transactional(readOnly = true)
    List<LLDDHealthProblem> findAll() {
        return lLDDHealthProblemRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete LLDDHealthProblem object in the database
     *
     * @param lLDDHealthProblem the new LLDDHealthProblem object to be saved
     * @return the saved version of the LLDDHealthProblem object
     */
    @Override
    @Transactional
    public LLDDHealthProblem save(LLDDHealthProblem lLDDHealthProblem) {
        return lLDDHealthProblemRepository.save(lLDDHealthProblem)
    }
    
    /**
     * This service method is used to create an LLDDHealthProblem object in the database from a partial or complete LLDDHealthProblem object.
     *
     * @param lLDDHealthProblem the partial or complete LLDDHealthProblem object to be saved
     * @return the saved version of the LLDDHealthProblem object
     */
    @Transactional
    public LLDDHealthProblem createFromDto(LLDDHealthProblemDto lLDDHealthProblem) {
        if (lLDDHealthProblem == null) {
            throw new InvalidDataException("Cannot create lLDDHealthProblem from null object.")
        }
        LLDDHealthProblem lLDDHealthProblemToSave = new LLDDHealthProblem()
        lLDDHealthProblemToSave.id = lLDDHealthProblem.id
        lLDDHealthProblemToSave.code = lLDDHealthProblem.code
        lLDDHealthProblemToSave.description = lLDDHealthProblem.description
        lLDDHealthProblemToSave.shortDescription = lLDDHealthProblem.shortDescription
        lLDDHealthProblemToSave.validFrom = lLDDHealthProblem.validFrom
        lLDDHealthProblemToSave.validTo = lLDDHealthProblem.validTo
        return save(lLDDHealthProblemToSave)
    }
    
    /**
     * This service method is used to update an LLDDHealthProblem object in the database from a partial or complete LLDDHealthProblem object.
     *
     * @param lLDDHealthProblem the partial or complete LLDDHealthProblem object to be saved
     * @return the saved version of the LLDDHealthProblem object
     */
    @Transactional
    public LLDDHealthProblem updateFromDto(LLDDHealthProblemDto lLDDHealthProblem) {
        if (lLDDHealthProblem == null) {
            throw new InvalidDataException("Cannot update lLDDHealthProblem from null object.")
        }
        LLDDHealthProblem lLDDHealthProblemToSave = findById(lLDDHealthProblem.id)
        lLDDHealthProblemToSave.code = lLDDHealthProblem.code
        lLDDHealthProblemToSave.description = lLDDHealthProblem.description
        lLDDHealthProblemToSave.shortDescription = lLDDHealthProblem.shortDescription
        lLDDHealthProblemToSave.validFrom = lLDDHealthProblem.validFrom
        lLDDHealthProblemToSave.validTo = lLDDHealthProblem.validTo
        return save(lLDDHealthProblemToSave)
    }
    
    /**
     * Saves a list of LLDDHealthProblem objects to the database
     * 
     * @param lLDDHealthProblems a list of LLDDHealthProblems to be saved to the database
     * @return the list of save LLDDHealthProblem objects
     */
    @Transactional
    public List<LLDDHealthProblem> saveLLDDHealthProblems(List<LLDDHealthProblem> lLDDHealthProblems) {
        return lLDDHealthProblems.collect { lLDDHealthProblem -> save(lLDDHealthProblem) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. LLDDHealthProblem should not be deleted.
     */
    @Override
    public void delete(LLDDHealthProblem obj) {
        throw new InvalidDataException("LLDDHealthProblem should not be deleted")
    }
    
    public LLDDHealthProblem findByShortDescription(String description) {
        return lLDDHealthProblemRepository.findByShortDescription(description)
    }
}
