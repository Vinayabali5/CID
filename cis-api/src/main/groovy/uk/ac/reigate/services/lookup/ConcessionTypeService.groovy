package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.dto.lookup.ConcessionTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.ConcessionTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class ConcessionTypeService implements ICoreDataService<ConcessionType, Integer>, IDtoCreateUpdateService<ConcessionTypeDto, ConcessionType>{
    
    @Autowired
    ConcessionTypeRepository concessionTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    ConcessionTypeService() {}
    
    /**
     * Autowired Constructor
     * @param concessionTypeRepository
     */
    ConcessionTypeService(ConcessionTypeRepository concessionTypeRepository) {
        this.concessionTypeRepository = concessionTypeRepository
    }
    
    /**
     * Find an individual concessionType using the concessionTypes ID fields
     * 
     * @param id the ID fields to search for
     * @return the ConcessionType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ConcessionType findById(Integer id) {
        return concessionTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of ConcessionType objects
     * @return a SearchResult set with the list of ConcessionTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<ConcessionType> findAll() {
        return concessionTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ConcessionType object in the database
     * 
     * @param concessionType the new ConcessionType object to be saved
     * @return the saved version of the ConcessionType object
     */
    @Override
    @Transactional
    public ConcessionType save(ConcessionType concessionType) {
        return concessionTypeRepository.save(concessionType)
    }
    
    /**
     * This service method is used to update an ConcessionType object in the database from a partial or complete ConcessionType object.
     * 
     * @param concessionType the partial or complete ConcessionType object to be saved
     * @return the saved version of the ConcessionType object
     */
    @Transactional
    public ConcessionType updateFromDto(ConcessionTypeDto concessionType) {
        if (concessionType == null) {
            throw new InvalidDataException("Cannot update concessionType from null object.")
        }
        ConcessionType concessionTypeToSave = findById(concessionType.id)
        concessionTypeToSave.code = concessionType.code
        concessionTypeToSave.description = concessionType.description
        concessionTypeToSave.inUse = concessionType.inUse
        concessionTypeToSave.onExamTimetable = concessionType.onExamTimetable
        return save(concessionTypeToSave)
    }
    
    /**
     * This service method is used to create an BursaryType object in the database from a partial or complete BursaryType object.
     * 
     * @param bursaryType the partial or complete BursaryType object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public ConcessionType createFromDto(ConcessionTypeDto concessionTypeDto) {
        if (concessionTypeDto == null) {
            throw new InvalidDataException("Cannot create concessionType from null object.")
        }
        ConcessionType concessionType = new ConcessionType()
        concessionType.id = concessionTypeDto.id
        concessionType.code = concessionTypeDto.code
        concessionType.description = concessionTypeDto.description
        concessionType.inUse = concessionTypeDto.inUse
        concessionType.onExamTimetable = concessionTypeDto.onExamTimetable
        return save(concessionType)
    }
    
    /**
     * Saves a list of ConcessionType objects to the database
     * 
     * @param concessionTypes a list of ConcessionTypes to be saved to the database
     * @return the list of save ConcessionType objects
     */
    @Transactional
    public List<ConcessionType> saveConcessionTypes(List<ConcessionType> concessionTypes) {
        return concessionTypes.collect { concessionType -> save(concessionType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ConcessionType should not be deleted.
     */
    @Override
    public void delete(ConcessionType obj) {
        throw new InvalidOperationException("ConcessionType should not be deleted")
    }
}
