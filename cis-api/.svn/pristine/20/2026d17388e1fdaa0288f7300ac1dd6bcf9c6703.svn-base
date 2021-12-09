package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.dto.lookup.BursaryTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.BursaryTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class BursaryTypeService implements ICoreDataService<BursaryType, Integer>, IDtoCreateUpdateService<BursaryTypeDto, BursaryType>{
    
    @Autowired
    BursaryTypeRepository bursaryTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    BursaryTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param bursaryTypeRepository
     */
    BursaryTypeService(BursaryTypeRepository bursaryTypeRepository) {
        this.bursaryTypeRepository = bursaryTypeRepository;
    }
    
    /**
     * Find an individual bursaryType using the bursaryTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the BursaryType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    BursaryType findById(Integer id) {
        return bursaryTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all bursaryTypes
     *
     * @return a SearchResult set with the list of BursaryTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<BursaryType> findAll() {
        return bursaryTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete BursaryType object in the database
     *
     * @param bursaryType the new BursaryType object to be saved
     * @return the saved version of the BursaryType object
     */
    @Override
    @Transactional
    public BursaryType save(BursaryType bursaryType) {
        return bursaryTypeRepository.save(bursaryType)
    }
    
    /**
     * Saves a list of BursaryType objects to the database
     *
     * @param bursaryTypes a list of BursaryTypes to be saved to the database
     * @return the list of save BursaryType objects
     */
    @Transactional
    public List<BursaryType> saveBursaryTypes(List<BursaryType> bursaryTypes) {
        return bursaryTypes.collect { bursaryType -> save(bursaryType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. BursaryType should not be deleted.
     */
    @Override
    public void delete(BursaryType obj) {
        throw new InvalidOperationException("BursaryType should not be deleted");
    }
    
    /**
     * This service method is used to create an BursaryType object in the database from a partial or complete BursaryType object.
     *
     * @param bursaryType the partial or complete BursaryType object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public BursaryType createFromDto(BursaryTypeDto bursaryTypeDto) {
        if (bursaryTypeDto == null) {
            throw new InvalidDataException("Cannot create bursaryType from null object.")
        }
        BursaryType bursaryType = new BursaryType()
        bursaryType.code = bursaryTypeDto.code
        bursaryType.description = bursaryTypeDto.description
        return save(bursaryType)
    }
    
    /**
     * This service method is used to update an BursaryType object in the database from a partial or complete BursaryType object.
     *
     * @param bursaryType the partial or complete BursaryType object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public BursaryType updateFromDto(BursaryTypeDto bursaryTypeDto) {
        if (bursaryTypeDto == null) {
            throw new InvalidDataException("Cannot update bursaryType from null object.")
        }
        BursaryType bursaryType = findById(bursaryTypeDto.id);
        bursaryType.code = bursaryTypeDto.code
        bursaryType.description = bursaryTypeDto.description
        return save(bursaryType)
    }
}
