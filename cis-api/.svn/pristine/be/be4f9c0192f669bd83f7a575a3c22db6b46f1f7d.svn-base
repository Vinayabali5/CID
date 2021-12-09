package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel
import uk.ac.reigate.dto.InitialAssessmentLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.InitialAssessmentLevelRepository

@Service
class InitialAssessmentLevelService implements ICoreDataService<InitialAssessmentLevel, Integer>, IDtoCreateUpdateService<InitialAssessmentLevelDto, InitialAssessmentLevel> {
    
    @Autowired
    InitialAssessmentLevelRepository initialAssessmentLevelRepository
    
    /**
     * Default NoArgs constructor
     */
    InitialAssessmentLevelService() {}
    
    /**
     * Autowired Constructor
     *
     * @param initialAssessmentLevelRepository
     */
    InitialAssessmentLevelService(InitialAssessmentLevelRepository initialAssessmentLevelRepository) {
        this.initialAssessmentLevelRepository = initialAssessmentLevelRepository
    }
    
    /**
     * Find an individual initialAssessmentLevel using the initialAssessmentLevels ID fields
     *
     * @param id the ID fields to search for
     * @return the InitialAssessmentLevel object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    InitialAssessmentLevel findById(Integer id) {
        return initialAssessmentLevelRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of InitialAssessmentLevel objects
     * @return a SearchResult set with the list of InitialAssessmentLevels
     */
    @Override
    @Transactional(readOnly = true)
    List<InitialAssessmentLevel> findAll() {
        return initialAssessmentLevelRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete InitialAssessmentLevel object in the database
     *
     * @param initialAssessmentLevel the new InitialAssessmentLevel object to be saved
     * @return the saved version of the InitialAssessmentLevel object
     */
    @Override
    @Transactional
    public InitialAssessmentLevel save(InitialAssessmentLevel initialAssessmentLevel) {
        return initialAssessmentLevelRepository.save(initialAssessmentLevel)
    }
    
    /**
     * This service method is used to update an InitialAssessmentLevel object in the database from a partial or complete InitialAssessmentLevel object.
     *
     * @param initialAssessmentLevel the partial or complete InitialAssessmentLevel object to be saved
     * @return the saved version of the InitialAssessmentLevel object
     */
    @Transactional
    public InitialAssessmentLevel createFromDto(InitialAssessmentLevelDto initialAssessmentLevel) {
        if (initialAssessmentLevel == null) {
            throw new InvalidDataException("Cannot create initialAssessmentLevelDto from null object.")
        }
        InitialAssessmentLevel initialAssessmentLevelToSave = new InitialAssessmentLevel()
        initialAssessmentLevelToSave.id = initialAssessmentLevel.id
        initialAssessmentLevelToSave.initialAssessmentLevel = initialAssessmentLevel.initialAssessmentLevel
        initialAssessmentLevelToSave.abbrv = initialAssessmentLevel.abbrv
        return save(initialAssessmentLevelToSave)
    }
    
    /**
     * This service method is used to update an InitialAssessmentLevel object in the database from a partial or complete InitialAssessmentLevel object.
     *
     * @param initialAssessmentLevel the partial or complete InitialAssessmentLevel object to be saved
     * @return the saved version of the InitialAssessmentLevel object
     */
    @Transactional
    public InitialAssessmentLevel updateFromDto(InitialAssessmentLevelDto initialAssessmentLevel) {
        if (initialAssessmentLevel == null) {
            throw new InvalidDataException("Cannot update initialAssessmentLevelDto from null object.")
        }
        InitialAssessmentLevel initialAssessmentLevelToSave = findById(initialAssessmentLevel.id)
        initialAssessmentLevelToSave.initialAssessmentLevel = initialAssessmentLevel.initialAssessmentLevel
        initialAssessmentLevelToSave.abbrv = initialAssessmentLevel.abbrv
        return save(initialAssessmentLevelToSave)
    }
    
    /**
     * Saves a list of InitialAssessmentLevel objects to the database
     *
     * @param initialAssessmentLevels a list of InitialAssessmentLevels to be saved to the database
     * @return the list of save InitialAssessmentLevel objects
     */
    @Transactional
    public List<InitialAssessmentLevel> saveInitialAssessmentLevels(List<InitialAssessmentLevel> initialAssessmentLevels) {
        return initialAssessmentLevels.collect { initialAssessmentLevel -> save(initialAssessmentLevel) };
    }
    /**
     * This methods throws an InvalidOperationException when called. InitialAssessmentLevel should not be deleted.
     */
    @Override
    public void delete(InitialAssessmentLevel obj) {
        throw new InvalidOperationException("InitialAssessmentLevel should not be deleted")
    }
}
