package uk.ac.reigate.services.ilr

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.MathsConditionOfFunding
import uk.ac.reigate.dto.MathsConditionOfFundingDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.MathsConditionOfFundingRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class MathsConditionOfFundingService implements ICoreDataService<MathsConditionOfFunding, Integer>, IDtoCreateUpdateService<MathsConditionOfFundingDto, MathsConditionOfFunding>{
    
    @Autowired
    MathsConditionOfFundingRepository mathsConditionOfFundingRepository
    
    /**
     * Default NoArgs constructor
     */
    MathsConditionOfFundingService() {}
    
    /**
     * Autowired Constructor
     *
     * @param mathsConditionOfFundingRepository
     */
    MathsConditionOfFundingService(MathsConditionOfFundingRepository mathsConditionOfFundingRepository) {
        this.mathsConditionOfFundingRepository = mathsConditionOfFundingRepository
    }
    
    /**
     * Find an individual mathsConditionOfFunding using the mathsConditionOfFundings ID fields
     *
     * @param id the ID fields to search for
     * @return the MathsConditionOfFunding object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    MathsConditionOfFunding findById(Integer id) {
        return mathsConditionOfFundingRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all mathsConditionOfFundings
     *
     * @return a SearchResult set with the list of MathsConditionOfFundings
     */
    @Override
    @Transactional(readOnly = true)
    List<MathsConditionOfFunding> findAll() {
        return mathsConditionOfFundingRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete MathsConditionOfFunding object in the database
     *
     * @param mathsConditionOfFundingr the new MathsConditionOfFunding object to be saved
     * @return the saved version of the MathsConditionOfFunding object
     */
    @Override
    @Transactional
    public MathsConditionOfFunding save(MathsConditionOfFunding mathsConditionOfFunding) {
        return mathsConditionOfFundingRepository.save(mathsConditionOfFunding)
    }
    
    /**
     * This service method is used to update an MathsConditionOfFunding object in the database from a partial or complete MathsConditionOfFunding object.
     *
     * @param mathsConditionOfFunding the partial or complete MathsConditionOfFunding object to be saved
     * @return the saved version of the MathsConditionOfFunding object
     */
    @Transactional
    public MathsConditionOfFunding createFromDto(MathsConditionOfFundingDto mathsConditionOfFunding) {
        if(mathsConditionOfFunding == null) {
            throw new InvalidDataException("Cannot create mathsConditionOfFunding from null object.")
        }
        MathsConditionOfFunding mathsConditionOfFundingToSave = new MathsConditionOfFunding()
        mathsConditionOfFundingToSave.id = mathsConditionOfFunding.id
        mathsConditionOfFundingToSave.code = mathsConditionOfFunding.code != null ? mathsConditionOfFunding.code : mathsConditionOfFundingToSave.code
        mathsConditionOfFundingToSave.description = mathsConditionOfFunding.description != null ? mathsConditionOfFunding.description : mathsConditionOfFundingToSave.description
        mathsConditionOfFundingToSave.shortDescription = mathsConditionOfFunding.shortDescription != null ? mathsConditionOfFunding.shortDescription : mathsConditionOfFundingToSave.shortDescription
        mathsConditionOfFundingToSave.validFrom = mathsConditionOfFunding.validFrom != null ? mathsConditionOfFunding.validFrom : mathsConditionOfFundingToSave.validFrom
        mathsConditionOfFundingToSave.validTo = mathsConditionOfFunding.validTo != null ? mathsConditionOfFunding.validTo : mathsConditionOfFundingToSave.validTo
        return save(mathsConditionOfFundingToSave)
    }
    
    /**
     * This service method is used to update an MathsConditionOfFunding object in the database from a partial or complete MathsConditionOfFunding object.
     *
     * @param mathsConditionOfFunding the partial or complete MathsConditionOfFunding object to be saved
     * @return the saved version of the MathsConditionOfFunding object
     */
    @Transactional
    public MathsConditionOfFunding updateFromDto(MathsConditionOfFundingDto mathsConditionOfFunding) {
        if(mathsConditionOfFunding == null) {
            throw new InvalidDataException("Cannot update mathsConditionOfFunding from null object.")
        }
        MathsConditionOfFunding mathsConditionOfFundingToSave = findById(mathsConditionOfFunding.id)
        mathsConditionOfFundingToSave.code = mathsConditionOfFunding.code != null ? mathsConditionOfFunding.code : mathsConditionOfFundingToSave.code
        mathsConditionOfFundingToSave.description = mathsConditionOfFunding.description != null ? mathsConditionOfFunding.description : mathsConditionOfFundingToSave.description
        mathsConditionOfFundingToSave.shortDescription = mathsConditionOfFunding.shortDescription != null ? mathsConditionOfFunding.shortDescription : mathsConditionOfFundingToSave.shortDescription
        mathsConditionOfFundingToSave.validFrom = mathsConditionOfFunding.validFrom != null ? mathsConditionOfFunding.validFrom : mathsConditionOfFundingToSave.validFrom
        mathsConditionOfFundingToSave.validTo = mathsConditionOfFunding.validTo != null ? mathsConditionOfFunding.validTo : mathsConditionOfFundingToSave.validTo
        return save(mathsConditionOfFundingToSave)
    }
    
    /**
     * Saves a list of MathsConditionOfFunding objects to the database
     *
     * @param mathsConditionOfFundings a list of MathsConditionOfFundings to be saved to the database
     * @return the list of save MathsConditionOfFunding objects
     */
    @Transactional
    public List<MathsConditionOfFunding> saveMathsConditionOfFundings(List<MathsConditionOfFunding> mathsConditionOfFundings) {
        return mathsConditionOfFundings.collect { mathsConditionOfFunding -> save(mathsConditionOfFunding) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. MathsConditionOfFunding should not be deleted.
     */
    @Override
    public void delete(MathsConditionOfFunding obj) {
        throw new InvalidOperationException("MathsConditionOfFunding should not be deleted")
    }
}
