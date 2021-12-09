package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.CorrespondenceType
import uk.ac.reigate.dto.lookup.CorrespondenceTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.CorrespondenceTypeRepository

/**
 * This service is used to manage the CorrespondenceType data objects.
 *
 */
@Service
class CorrespondenceTypeService implements ICoreDataService<CorrespondenceType, Integer>, IDtoCreateUpdateService<CorrespondenceTypeDto, CorrespondenceType>{
    
    @Autowired
    CorrespondenceTypeRepository correspondenceTypeRepository
    
    /**
     * Default NoArgs constructor    
     */
    CorrespondenceTypeService() {}
    
    /**
     * Autowired constructor
     * 
     * @param correspondenceTypeRepository
     */
    CorrespondenceTypeService(CorrespondenceTypeRepository correspondenceTypeRepository) {
        this.correspondenceTypeRepository = correspondenceTypeRepository
    }
    
    /**
     * Find an individual correspondenceType using the correspondenceTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the CorrespondenceType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    CorrespondenceType findById(Integer id) {
        return correspondenceTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all correspondenceTypes
     *
     * @return a SearchResult set with the list of CorrespondenceTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<CorrespondenceType> findAll() {
        return correspondenceTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CorrespondenceType object in the database
     *
     * @param correspondenceType the new CorrespondenceType object to be saved
     * @return the saved version of the CorrespondenceType object
     */
    @Override
    @Transactional
    public CorrespondenceType save(CorrespondenceType correspondenceType) {
        return correspondenceTypeRepository.save(correspondenceType)
    }
    
    /**
     * This service method is used to update an CorrespondenceType object in the database from a partial or complete CorrespondenceType object.
     *
     * @param correspondenceType the partial or complete CorrespondenceType object to be saved
     * @return the saved version of the CorrespondenceType object
     */
    @Transactional
    public CorrespondenceType createFromDto(CorrespondenceTypeDto correspondenceType) {
        if (correspondenceType == null) {
            throw new InvalidDataException("Cannot create CorrespondenceType from null object.")
        }
        CorrespondenceType correspondenceTypeToSave = new CorrespondenceType()
        correspondenceTypeToSave.id = correspondenceType.id
        correspondenceTypeToSave.type = correspondenceType.type
        return save(correspondenceTypeToSave)
    }
    
    /**
     * This service method is used to update an CorrespondenceType object in the database from a partial or complete CorrespondenceType object.
     *
     * @param correspondenceType the partial or complete CorrespondenceType object to be saved
     * @return the saved version of the CorrespondenceType object
     */
    @Transactional
    public CorrespondenceType updateFromDto(CorrespondenceTypeDto correspondenceType) {
        if (correspondenceType == null) {
            throw new InvalidDataException("Cannot update CorrespondenceType from null object.")
        }
        CorrespondenceType correspondenceTypeToSave = findById(correspondenceType.id)
        correspondenceTypeToSave.type = correspondenceType.type
        return save(correspondenceTypeToSave)
    }
    
    /**
     * Saves a list of CorrespondenceType objects to the database
     *
     * @param correspondenceTypes a list of CorrespondenceTypes to be saved to the database
     * @return the list of save CorrespondenceType objects
     */
    @Transactional
    public List<CorrespondenceType> saveCorrespondenceTypes(List<CorrespondenceType> correspondenceTypes) {
        return correspondenceTypes.collect { correspondenceType -> save(correspondenceType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. CorrespondenceType should not be deleted.
     */
    @Override
    public void delete(CorrespondenceType obj) {
        throw new InvalidOperationException("CorrespondenceType should not be deleted")
    }
}
