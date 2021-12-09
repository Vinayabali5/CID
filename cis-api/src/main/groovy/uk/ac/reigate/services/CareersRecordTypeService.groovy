package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.CareersRecordType
import uk.ac.reigate.dto.careers.CareersRecordTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.CareersRecordTypeRepository

@Service
class CareersRecordTypeService implements ICoreDataService<CareersRecordType, Integer>, IDtoCreateUpdateService<CareersRecordTypeDto, CareersRecordType>{
    
    @Autowired
    CareersRecordTypeRepository careersRecordTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    CareersRecordTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param careersRecordTypeRepository
     */
    CareersRecordTypeService(CareersRecordTypeRepository careersRecordTypeRepository) {
        this.careersRecordTypeRepository = careersRecordTypeRepository;
    }
    
    /**
     * Find an individual careersRecordType using the careersRecordTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the CareersRecordType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    CareersRecordType findById(Integer id) {
        return careersRecordTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all careersRecordTypes
     *
     * @return a SearchResult set with the list of CareersRecordTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<CareersRecordType> findAll() {
        return careersRecordTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CareersRecordType object in the database
     *
     * @param careersRecordType the new CareersRecordType object to be saved
     * @return the saved version of the CareersRecordType object
     */
    @Override
    @Transactional
    public CareersRecordType save(CareersRecordType careersRecordType) {
        return careersRecordTypeRepository.save(careersRecordType)
    }
    
    /**
     * Saves a list of CareersRecordType objects to the database
     *
     * @param careersRecordTypes a list of CareersRecordTypes to be saved to the database
     * @return the list of save CareersRecordType objects
     */
    @Transactional
    public List<CareersRecordType> saveCareersRecordTypes(List<CareersRecordType> careersRecordTypes) {
        return careersRecordTypes.collect { careersRecordType -> save(careersRecordType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. CareersRecordType should not be deleted.
     */
    @Override
    public void delete(CareersRecordType obj) {
        throw new InvalidOperationException("CareersRecordType should not be deleted");
    }
    
    /**
     * This service method is used to create an CareersRecordType object in the database from a partial or complete CareersRecordType object.
     *
     * @param careersRecordType the partial or complete CareersRecordType object to be saved
     * @return the saved version of the CareersRecordType object
     */
    @Transactional
    public CareersRecordType createFromDto(CareersRecordTypeDto careersRecordTypeDto) {
        if (careersRecordTypeDto == null) {
            throw new InvalidDataException("Cannot create careersRecordTypeDto from null object.")
        }
        CareersRecordType careersRecordType = new CareersRecordType()
        careersRecordType.code = careersRecordTypeDto.code
        careersRecordType.description = careersRecordTypeDto.description
        return save(careersRecordType)
    }
    
    /**
     * This service method is used to update an CareersRecordType object in the database from a partial or complete CareersRecordType object.
     *
     * @param careersRecordType the partial or complete CareersRecordType object to be saved
     * @return the saved version of the CareersRecordType object
     */
    @Transactional
    public CareersRecordType updateFromDto(CareersRecordTypeDto careersRecordTypeDto) {
        if (careersRecordTypeDto == null) {
            throw new InvalidDataException("Cannot update careersRecordTypeDto from null object.")
        }
        CareersRecordType careersRecordType = findById(careersRecordTypeDto.id);
        careersRecordType.code = careersRecordTypeDto.code
        careersRecordType.description = careersRecordTypeDto.description
        return save(careersRecordType)
    }
}
