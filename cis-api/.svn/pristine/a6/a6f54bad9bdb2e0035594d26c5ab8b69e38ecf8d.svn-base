package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.dto.exams.edi.EdiStatusTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.EdiStatusTypeRepository

@Service
class EdiStatusTypeService implements ICoreDataService<EdiStatusType, Integer>{
    
    @Autowired
    EdiStatusTypeRepository ediStatusTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    EdiStatusTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param ediStatusTypeRepository
     */
    EdiStatusTypeService(EdiStatusTypeRepository ediStatusTypeRepository) {
        this.ediStatusTypeRepository = ediStatusTypeRepository;
    }
    
    /**
     * Find an individual ediStatusType using the ediStatusTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the EdiStatusType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    EdiStatusType findById(Integer id) {
        return ediStatusTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all ediStatusTypes
     *
     * @return a List of EdiStatusTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<EdiStatusType> findAll() {
        return ediStatusTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete EdiStatusType object in the database
     *
     * @param ediStatusType the new EdiStatusType object to be saved
     * @return the saved version of the EdiStatusType object
     */
    @Override
    @Transactional
    public EdiStatusType save(EdiStatusType ediStatusType) {
        return ediStatusTypeRepository.save(ediStatusType)
    }
    
    /**
     * This service method is used to create an EdiStatusType object in the database from a partial or complete EdiStatusType object.
     *
     * @param ediStatusType the partial or complete EdiStatusType object to be saved
     * @return the saved version of the EdiStatusType object
     */
    @Transactional
    public EdiStatusType createFromDto(EdiStatusTypeDto ediStatusType) {
        if (ediStatusType == null) {
            throw new InvalidDataException("Cannot create ediStatusType from null object.")
        }
        EdiStatusType ediStatusTypeToSave = new EdiStatusType();
        ediStatusTypeToSave.code = ediStatusType.code
        ediStatusTypeToSave.description = ediStatusType.description
        return save(ediStatusTypeToSave)
    }
    
    /**
     * This service method is used to update an EdiStatusType object in the database from a partial or complete EdiStatusType object.
     *
     * @param ediStatusType the partial or complete EdiStatusType object to be saved
     * @return the saved version of the EdiStatusType object
     */
    @Transactional
    public EdiStatusType updateFromDto(EdiStatusTypeDto ediStatusType) {
        if (ediStatusType == null) {
            throw new InvalidDataException("Cannot create ediStatusType from null object.")
        }
        EdiStatusType ediStatusTypeToSave = findById(ediStatusType.id);
        ediStatusTypeToSave.code = ediStatusType.code
        ediStatusTypeToSave.description = ediStatusType.description
        return save(ediStatusTypeToSave)
    }
    
    /**
     * Saves a list of EdiStatusType objects to the database
     *
     * @param ediStatusTypes a list of EdiStatusTypes to be saved to the database
     * @return the list of save EdiStatusType objects
     */
    @Transactional
    public List<EdiStatusType> saveEdiStatusTypes(List<EdiStatusType> ediStatusTypes) {
        return ediStatusTypes.collect { ediStatusType -> save(ediStatusType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. EdiStatusType should not be deleted.
     */
    @Override
    public void delete(EdiStatusType obj) {
        throw new InvalidOperationException("EdiStatusType cannot be deleted")
    }
}
