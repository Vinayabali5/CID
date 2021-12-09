package uk.ac.reigate.services.ilr

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.SourceOfFunding
import uk.ac.reigate.dto.ilr.SourceOfFundingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.SourceOfFundingRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class SourceOfFundingService implements ICoreDataService<SourceOfFunding, Integer>{
    
    @Autowired
    SourceOfFundingRepository sourceOfFundingRepository
    
    /**
     * Default NoArgs constructor
     */
    SourceOfFundingService() {}
    
    /**
     * Autowired Constructor
     *
     * @param sourceOfFundingRepository
     */
    SourceOfFundingService(SourceOfFundingRepository sourceOfFundingRepository) {
        this.sourceOfFundingRepository = sourceOfFundingRepository;
    }
    
    /**
     * Find an individual sourceOfFunding using the sourceOfFundings ID fields
     *
     * @param id the ID fields to search for
     * @return the SourceOfFunding object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    SourceOfFunding findById(Integer id) {
        return sourceOfFundingRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all sourceOfFundings
     *
     * @return a SearchResult set with the list of SourceOfFundings
     */
    @Override
    @Transactional(readOnly = true)
    List<SourceOfFunding> findAll() {
        return sourceOfFundingRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete SourceOfFunding object in the database
     *
     * @param sourceOfFunding the new SourceOfFunding object to be saved
     * @return the saved version of the SourceOfFunding object
     */
    @Override
    @Transactional
    public SourceOfFunding save(SourceOfFunding sourceOfFunding) {
        return sourceOfFundingRepository.save(sourceOfFunding)
    }
    
    /**
     * This service method is used to update an SourceOfFunding object in the database from a partial or complete SourceOfFunding object.
     *
     * @param sourceOfFunding the partial or complete SourceOfFunding object to be saved
     * @return the saved version of the SourceOfFunding object
     */
    @Transactional
    public SourceOfFunding createFromDto(SourceOfFundingDto sourceOfFunding) {
        if(sourceOfFunding == null) {
            throw new InvalidDataException("Cannot create sourceOfFunding from null object.")
        }
        SourceOfFunding sourceOfFundingToSave = new SourceOfFunding()
        sourceOfFundingToSave.code = sourceOfFunding.code != null ? sourceOfFunding.code : sourceOfFundingToSave.code
        sourceOfFundingToSave.description = sourceOfFunding.description != null ? sourceOfFunding.description : sourceOfFundingToSave.description
        sourceOfFundingToSave.shortDescription = sourceOfFunding.shortDescription != null ? sourceOfFunding.shortDescription : sourceOfFundingToSave.shortDescription
        sourceOfFundingToSave.validFrom = sourceOfFunding.validFrom != null ? sourceOfFunding.validFrom : sourceOfFundingToSave.validFrom
        sourceOfFundingToSave.validTo = sourceOfFunding.validTo != null ? sourceOfFunding.validTo : sourceOfFundingToSave.validTo
        
        return save(sourceOfFundingToSave)
    }
    
    /**
     * This service method is used to update an SourceOfFunding object in the database from a partial or complete SourceOfFunding object.
     *
     * @param sourceOfFunding the partial or complete SourceOfFunding object to be saved
     * @return the saved version of the SourceOfFunding object
     */
    @Transactional
    public SourceOfFunding updateFromDto(SourceOfFundingDto sourceOfFunding) {
        if(sourceOfFunding == null) {
            throw new InvalidDataException("Cannot update sourceOfFunding from null object.")
        }
        SourceOfFunding sourceOfFundingToSave = findById(sourceOfFunding.id)
        sourceOfFundingToSave.code = sourceOfFunding.code != null ? sourceOfFunding.code : sourceOfFundingToSave.code
        sourceOfFundingToSave.description = sourceOfFunding.description != null ? sourceOfFunding.description : sourceOfFundingToSave.description
        sourceOfFundingToSave.shortDescription = sourceOfFunding.shortDescription != null ? sourceOfFunding.shortDescription : sourceOfFundingToSave.shortDescription
        sourceOfFundingToSave.validFrom = sourceOfFunding.validFrom != null ? sourceOfFunding.validFrom : sourceOfFundingToSave.validFrom
        sourceOfFundingToSave.validTo = sourceOfFunding.validTo != null ? sourceOfFunding.validTo : sourceOfFundingToSave.validTo
        
        return save(sourceOfFundingToSave)
    }
    
    /**
     * Saves a list of SourceOfFunding objects to the database
     *
     * @param sourceOfFundings a list of SourceOfFundings to be saved to the database
     * @return the list of save SourceOfFunding objects
     */
    @Transactional
    public List<SourceOfFunding> saveSourceOfFundings(List<SourceOfFunding> sourceOfFundings) {
        return sourceOfFundings.collect { sourceOfFunding -> save(sourceOfFunding) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. SourceOfFunding should not be deleted.
     */
    @Override
    public void delete(SourceOfFunding obj) {
        throw new InvalidOperationException("SourceOfFunding should not be deleted")
    }
}
