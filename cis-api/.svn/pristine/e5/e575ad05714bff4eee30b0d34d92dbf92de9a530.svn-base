package uk.ac.reigate.services.admissions

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.dto.admissions.OfferTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.OfferTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class OfferTypeService implements ICoreDataService<OfferType, Integer>, IDtoCreateUpdateService<OfferTypeDto, OfferType> {
    
    @Autowired
    OfferTypeRepository offerTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    OfferTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param offerTypeRepository
     */
    OfferTypeService(OfferTypeRepository offerTypeRepository) {
        this.offerTypeRepository = offerTypeRepository;
    }
    
    /**
     * Find an individual OfferType using the OfferType ID fields
     *
     * @param id the ID fields to search for
     * @return the OfferType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    OfferType findById(Integer id) {
        return offerTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of OfferType objects
     * @return a List of OfferTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<OfferType> findAll() {
        return offerTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete OfferType object in the database
     *
     * @param offerType the new OfferType object to be saved
     * @return the saved version of the OfferType object
     */
    @Override
    @Transactional
    public OfferType save(OfferType offerType) {
        return offerTypeRepository.save(offerType)
    }
    
    /**
     * This service method is used to create an OfferType object in the database from a partial or complete OfferType object.
     *
     * @param offerType the partial or complete OfferType object to be saved
     * @return the saved version of the OfferType object
     */
    @Transactional
    public OfferType createFromDto(OfferTypeDto offerType) {
        if(offerType == null) {
            throw new InvalidDataException("Cannot create offerTypeDto from null object.")
        }
        OfferType offerTypeToSave = new OfferType();
        offerTypeToSave.code = offerType.code
        offerTypeToSave.description = offerType.description
        offerTypeToSave.considerAsEnrolling = offerType.considerAsEnrolling
        return save(offerTypeToSave)
    }
    
    /**
     * This service method is used to update an OfferType object in the database from a partial or complete OfferType object.
     *
     * @param offerType the partial or complete OfferType object to be saved
     * @return the saved version of the OfferType object
     */
    @Transactional
    public OfferType updateFromDto(OfferTypeDto offerType) {
        if(offerType == null) {
            throw new InvalidDataException("Cannot update offerTypeDto from null object.")
        }
        OfferType offerTypeToSave = findById(offerType.id)
        offerTypeToSave.code = offerType.code != null ? offerType.code : offerTypeToSave.code
        offerTypeToSave.description = offerType.description != null ? offerType.description : offerTypeToSave.description
        offerTypeToSave.considerAsEnrolling = offerType.considerAsEnrolling
        return save(offerTypeToSave)
    }
    
    /**
     * Saves a list of OfferType objects to the database
     *
     * @param offerTypes a list of OfferTypes to be saved to the database
     * @return the list of save OfferType objects
     */
    @Transactional
    public List<OfferType> saveList(List<OfferType> offerTypes) {
        return offerTypes.collect { offerType -> save(offerType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. OfferType should not be deleted.
     */
    @Override
    public void delete(OfferType obj) {
        throw new InvalidOperationException("OfferType should not be deleted")
    }
    
    /**
     * This method is used to retrieve an OfferType data object based on the supplied description.
     *
     * @param description the description to search for in the database
     * @return an OfferType data object that matches the search criteria
     */
    public OfferType findByDescription(String description) {
        return offerTypeRepository.findByDescription(description)
    }
}
