package uk.ac.reigate.services.ilr

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.dto.ilr.RestrictedUseIndicatorDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.RestrictedUseIndicatorRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class RestrictedUseIndicatorService implements ICoreDataService<RestrictedUseIndicator, Integer>, IDtoCreateUpdateService<RestrictedUseIndicatorDto, RestrictedUseIndicator>{
    
    @Autowired
    RestrictedUseIndicatorRepository restrictedUseIndicatorRepository
    
    /**
     * Default NoArgs constructor
     */
    RestrictedUseIndicatorService() {}
    
    /**
     * Autowired Constructor
     *
     * @param restrictedUseIndicatorRepository
     */
    RestrictedUseIndicatorService(RestrictedUseIndicatorRepository restrictedUseIndicatorRepository) {
        this.restrictedUseIndicatorRepository = restrictedUseIndicatorRepository
    }
    
    /**
     * Find an individual restrictedUseIndicator using the restrictedUseIndicators ID fields
     *
     * @param id the ID fields to search for
     * @return the RestrictedUseIndicator object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    RestrictedUseIndicator findById(Integer id) {
        return restrictedUseIndicatorRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all restrictedUseIndicators
     *
     * @return a SearchResult set with the list of RestrictedUseIndicators
     */
    @Override
    @Transactional(readOnly = true)
    List<RestrictedUseIndicator> findAll() {
        return restrictedUseIndicatorRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete RestrictedUseIndicator object in the database
     *
     * @param restrictedUseIndicatorr the new RestrictedUseIndicator object to be saved
     * @return the saved version of the RestrictedUseIndicator object
     */
    @Override
    @Transactional
    public RestrictedUseIndicator save(RestrictedUseIndicator restrictedUseIndicator) {
        return restrictedUseIndicatorRepository.save(restrictedUseIndicator)
    }
    
    /**
     * This service method is used to create a RestrictedUseIndicator object in the database from a partial or complete RestrictedUseIndicator object.
     *
     * @param restrictedUseIndicator the partial or complete RestrictedUseIndicator object to be saved
     * @return the saved version of the RestrictedUseIndicator object
     */
    
    @Transactional
    public RestrictedUseIndicator createFromDto(RestrictedUseIndicatorDto restrictedUseIndicator) {
        if(restrictedUseIndicator == null) {
            throw new InvalidDataException("Cannot create restrictedUseIndicator from null object.")
        }
        RestrictedUseIndicator restrictedUseIndicatorToSave = new RestrictedUseIndicator()
        restrictedUseIndicatorToSave.code = restrictedUseIndicator.code != null ? restrictedUseIndicator.code : restrictedUseIndicatorToSave.code
        restrictedUseIndicatorToSave.description = restrictedUseIndicator.description != null ? restrictedUseIndicator.description : restrictedUseIndicatorToSave.description
        restrictedUseIndicatorToSave.shortDescription = restrictedUseIndicator.shortDescription != null ? restrictedUseIndicator.shortDescription : restrictedUseIndicatorToSave.shortDescription
        restrictedUseIndicatorToSave.validFrom = restrictedUseIndicator.validFrom != null ? restrictedUseIndicator.validFrom : restrictedUseIndicatorToSave.validFrom
        restrictedUseIndicatorToSave.validTo = restrictedUseIndicator.validTo != null ? restrictedUseIndicator.validTo : restrictedUseIndicatorToSave.validTo
        return save(restrictedUseIndicatorToSave)
    }
    
    /**
     * This service method is used to update a RestrictedUseIndicator object in the database from a partial or complete RestrictedUseIndicator object.
     *
     * @param restrictedUseIndicator the partial or complete RestrictedUseIndicator object to be saved
     * @return the saved version of the RestrictedUseIndicator object
     */
    
    @Transactional
    public RestrictedUseIndicator updateFromDto(RestrictedUseIndicatorDto restrictedUseIndicator) {
        if(restrictedUseIndicator == null) {
            throw new InvalidDataException("Cannot update restrictedUseIndicator from null object.")
        }
        RestrictedUseIndicator restrictedUseIndicatorToSave = findById(restrictedUseIndicator.id)
        restrictedUseIndicatorToSave.code = restrictedUseIndicator.code != null ? restrictedUseIndicator.code : restrictedUseIndicatorToSave.code
        restrictedUseIndicatorToSave.description = restrictedUseIndicator.description != null ? restrictedUseIndicator.description : restrictedUseIndicatorToSave.description
        restrictedUseIndicatorToSave.shortDescription = restrictedUseIndicator.shortDescription != null ? restrictedUseIndicator.shortDescription : restrictedUseIndicatorToSave.shortDescription
        restrictedUseIndicatorToSave.validFrom = restrictedUseIndicator.validFrom != null ? restrictedUseIndicator.validFrom : restrictedUseIndicatorToSave.validFrom
        restrictedUseIndicatorToSave.validTo = restrictedUseIndicator.validTo != null ? restrictedUseIndicator.validTo : restrictedUseIndicatorToSave.validTo
        return save(restrictedUseIndicatorToSave)
    }
    
    /**
     * Saves a list of RestrictedUseIndicator objects to the database
     *
     * @param restrictedUseIndicators a list of RestrictedUseIndicators to be saved to the database
     * @return the list of save RestrictedUseIndicator objects
     */
    
    @Transactional
    public List<RestrictedUseIndicator> saveRestrictedUseIndicators(List<RestrictedUseIndicator> restrictedUseIndicators) {
        return restrictedUseIndicators.collect { restrictedUseIndicator -> save(restrictedUseIndicator) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. QualificationAssessment should not be deleted.
     */
    @Override
    public void delete(RestrictedUseIndicator obj) {
        throw new InvalidOperationException("RestrictedUseIndicator should not be deleted")
    }
    
    
    
}
