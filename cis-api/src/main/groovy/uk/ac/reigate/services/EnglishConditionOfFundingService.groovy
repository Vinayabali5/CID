package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.EnglishConditionOfFunding
import uk.ac.reigate.dto.EnglishConditionOfFundingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.ilr.EnglishConditionOfFundingRepository
import uk.ac.reigate.util.exception.IdMissingException

@Service
class EnglishConditionOfFundingService implements ICoreDataService<EnglishConditionOfFunding, Integer>, IDtoCreateUpdateService<EnglishConditionOfFundingDto, EnglishConditionOfFunding>{
    
    @Autowired
    EnglishConditionOfFundingRepository englishConditionOfFundingRepository
    
    /**
     * Default NoArgs constructor
     */
    EnglishConditionOfFundingService() {}
    
    /**
     * Autowired Constructor
     *
     * @param englishConditionOfFundingRepository
     */
    EnglishConditionOfFundingService(EnglishConditionOfFundingRepository englishConditionOfFundingRepository) {
        super();
        this.englishConditionOfFundingRepository = englishConditionOfFundingRepository
    }
    
    /**
     * Find an individual englishConditionOfFunding using the englishConditionOfFundings ID fields
     *
     * @param id the ID fields to search for
     * @return the EnglishConditionOfFunding object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    EnglishConditionOfFunding findById(Integer id) {
        return englishConditionOfFundingRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all englishConditionOfFundings
     *
     * @return a SearchResult set with the list of EnglishConditionOfFundings
     */
    @Override
    @Transactional(readOnly = true)
    List<EnglishConditionOfFunding> findAll() {
        return englishConditionOfFundingRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete EnglishConditionOfFunding object in the database
     *
     * @param englishConditionOfFundingr the new EnglishConditionOfFunding object to be saved
     * @return the saved version of the EnglishConditionOfFunding object
     */
    @Override
    @Transactional
    public EnglishConditionOfFunding save(EnglishConditionOfFunding englishConditionOfFunding) {
        return englishConditionOfFundingRepository.save(englishConditionOfFunding)
    }
    
    /**
     * This service method is used to update an EnglishConditionOfFunding object in the database from a partial or complete EnglishConditionOfFunding object.
     *
     * @param englishConditionOfFunding the partial or complete EnglishConditionOfFunding object to be saved
     * @return the saved version of the EnglishConditionOfFunding object
     */
    @Transactional
    public EnglishConditionOfFunding createFromDto(EnglishConditionOfFundingDto englishConditionOfFunding) {
        if (englishConditionOfFunding == null) {
            throw new InvalidDataException("Cannot create englishConditionOfFunding from null object.")
        }
        EnglishConditionOfFunding englishConditionOfFundingToSave = new EnglishConditionOfFunding()
        englishConditionOfFundingToSave.id = englishConditionOfFunding.id
        englishConditionOfFundingToSave.code = englishConditionOfFunding.code != null ? englishConditionOfFunding.code : englishConditionOfFundingToSave.code
        englishConditionOfFundingToSave.description = englishConditionOfFunding.description != null ? englishConditionOfFunding.description : englishConditionOfFundingToSave.description
        englishConditionOfFundingToSave.shortDescription = englishConditionOfFunding.shortDescription != null ? englishConditionOfFunding.shortDescription : englishConditionOfFundingToSave.shortDescription
        englishConditionOfFundingToSave.validFrom = englishConditionOfFunding.validFrom != null ? englishConditionOfFunding.validFrom : englishConditionOfFundingToSave.validFrom
        englishConditionOfFundingToSave.validTo = englishConditionOfFunding.validTo != null ? englishConditionOfFunding.validTo : englishConditionOfFundingToSave.validTo
        return save(englishConditionOfFundingToSave)
    }
    
    /**
     * This service method is used to update an EnglishConditionOfFunding object in the database from a partial or complete EnglishConditionOfFunding object.
     *
     * @param englishConditionOfFunding the partial or complete EnglishConditionOfFunding object to be saved
     * @return the saved version of the EnglishConditionOfFunding object
     */
    @Transactional
    public EnglishConditionOfFunding updateFromDto(EnglishConditionOfFundingDto englishConditionOfFunding) {
        if (englishConditionOfFunding == null) {
            throw new InvalidDataException("Cannot update englishConditionOfFunding from null object.")
        }
        if (englishConditionOfFunding.id == null) {
            throw new InvalidDataException("Cannot update englishConditionOfFunding when the ID is null.")
        }
        EnglishConditionOfFunding englishConditionOfFundingToSave = findById(englishConditionOfFunding.id)
        englishConditionOfFundingToSave.code = englishConditionOfFunding.code != null ? englishConditionOfFunding.code : englishConditionOfFundingToSave.code
        englishConditionOfFundingToSave.description = englishConditionOfFunding.description != null ? englishConditionOfFunding.description : englishConditionOfFundingToSave.description
        englishConditionOfFundingToSave.shortDescription = englishConditionOfFunding.shortDescription != null ? englishConditionOfFunding.shortDescription : englishConditionOfFundingToSave.shortDescription
        englishConditionOfFundingToSave.validFrom = englishConditionOfFunding.validFrom != null ? englishConditionOfFunding.validFrom : englishConditionOfFundingToSave.validFrom
        englishConditionOfFundingToSave.validTo = englishConditionOfFunding.validTo != null ? englishConditionOfFunding.validTo : englishConditionOfFundingToSave.validTo
        return save(englishConditionOfFundingToSave)
    }
    
    /**
     * Saves a list of EnglishConditionOfFunding objects to the database
     *
     * @param englishConditionOfFundings a list of EnglishConditionOfFundings to be saved to the database
     * @return the list of save EnglishConditionOfFunding objects
     */
    @Transactional
    public List<EnglishConditionOfFunding> saveEnglishConditionOfFundings(List<EnglishConditionOfFunding> englishConditionOfFundings) {
        return englishConditionOfFundings.collect { englishConditionOfFunding -> save(englishConditionOfFunding) }
    }
    /**
     * This methods throws an InvalidOperationException when called. EnglishConditionOfFunding should not be deleted.
     */
    @Override
    public void delete(EnglishConditionOfFunding obj) {
        throw new InvalidOperationException("EnglishConditionOfFunding cannot be deleted")
        
    }
    
    
    
    
}
