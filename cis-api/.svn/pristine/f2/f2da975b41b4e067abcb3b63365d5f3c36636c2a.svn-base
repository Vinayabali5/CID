package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.edi.StatusType
import uk.ac.reigate.dto.exams.edi.StatusTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.StatusTypeRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class StatusTypeService implements ICoreDataService<StatusType, Integer>{
    
    @Autowired
    StatusTypeRepository statusTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    StatusTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param statusTypeRepository
     */
    StatusTypeService(StatusTypeRepository statusTypeRepository) {
        this.statusTypeRepository = statusTypeRepository;
    }
    
    /**
     * Find an individual statusType using the statusTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the StatusType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StatusType findById(Integer id) {
        return statusTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all statusTypes
     *
     * @return a List of StatusTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<StatusType> findAll() {
        return statusTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StatusType object in the database
     *
     * @param statusType the new StatusType object to be saved
     * @return the saved version of the StatusType object
     */
    @Override
    @Transactional
    public StatusType save(StatusType statusType) {
        return statusTypeRepository.save(statusType)
    }
    
    /**
     * This service method is used to update an StatusType object in the database from a partial or complete StatusType object.
     *
     * @param statusType the partial or complete StatusType object to be saved
     * @return the saved version of the StatusType object
     */
    @Transactional
    public StatusType createFromDto(StatusTypeDto statusType) {
        if (statusType == null) {
            throw new InvalidDataException("Cannot update statusType from null object.")
        }
        StatusType statusTypeToSave = new StatusType()
        statusTypeToSave.code = statusType.code
        statusTypeToSave.description = statusType.description
        return save(statusTypeToSave)
    }
    
    /**
     * This service method is used to update an StatusType object in the database from a partial or complete StatusType object.
     *
     * @param statusType the partial or complete StatusType object to be saved
     * @return the saved version of the StatusType object
     */
    @Transactional
    public StatusType updateFromDto(StatusTypeDto statusType) {
        if (statusType == null) {
            throw new InvalidDataException("Cannot update statusType from null object.")
        }
        StatusType statusTypeToSave = findById(statusType.id);
        statusTypeToSave.code = statusType.code
        statusTypeToSave.description = statusType.description
        return save(statusTypeToSave)
    }
    
    /**
     * Saves a list of StatusType objects to the database
     *
     * @param statusTypes a list of StatusTypes to be saved to the database
     * @return the list of save StatusType objects
     */
    @Transactional
    public List<StatusType> saveStatusTypes(List<StatusType> statusTypes) {
        return statusTypes.collect { statusType -> save(statusType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StatusType should not be deleted.
     */
    @Override
    public void delete(StatusType obj) {
        throw new InvalidOperationException("StatusType should not be deleted")
    }
}