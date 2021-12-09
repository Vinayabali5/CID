package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.VolunteeringType
import uk.ac.reigate.dto.lookup.VolunteeringTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.VolunteeringTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class VolunteeringTypeService implements ICoreDataService<VolunteeringType, Integer>, IDtoCreateUpdateService<VolunteeringTypeDto, VolunteeringType>{
    
    @Autowired
    VolunteeringTypeRepository volunteeringTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    VolunteeringTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param volunteeringTypeRepository
     */
    VolunteeringTypeService(VolunteeringTypeRepository volunteeringTypeRepository) {
        this.volunteeringTypeRepository = volunteeringTypeRepository;
    }
    
    /**
     * Find an individual volunteeringType using the volunteeringTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the VolunteeringType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    VolunteeringType findById(Integer id) {
        return volunteeringTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all volunteeringTypes
     *
     * @return a SearchResult set with the list of VolunteeringTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<VolunteeringType> findAll() {
        return volunteeringTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete VolunteeringType object in the database
     *
     * @param volunteeringType the new VolunteeringType object to be saved
     * @return the saved version of the VolunteeringType object
     */
    @Override
    @Transactional
    public VolunteeringType save(VolunteeringType volunteeringType) {
        return volunteeringTypeRepository.save(volunteeringType)
    }
    
    /**
     * Saves a list of VolunteeringType objects to the database
     *
     * @param volunteeringTypes a list of VolunteeringTypes to be saved to the database
     * @return the list of save VolunteeringType objects
     */
    @Transactional
    public List<VolunteeringType> saveVolunteeringTypes(List<VolunteeringType> volunteeringTypes) {
        return volunteeringTypes.collect { volunteeringType -> save(volunteeringType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. VolunteeringType should not be deleted.
     */
    @Override
    public void delete(VolunteeringType obj) {
        throw new InvalidOperationException("VolunteeringType should not be deleted");
    }
    
    /**
     * This service method is used to create an VolunteeringType object in the database from a partial or complete VolunteeringType object.
     *
     * @param volunteeringType the partial or complete VolunteeringType object to be saved
     * @return the saved version of the VolunteeringType object
     */
    @Transactional
    public VolunteeringType createFromDto(VolunteeringTypeDto volunteeringTypeDto) {
        if (volunteeringTypeDto == null) {
            throw new InvalidDataException("Cannot create volunteeringType from null object.")
        }
        VolunteeringType volunteeringType = new VolunteeringType()
        volunteeringType.code = volunteeringTypeDto.code
        volunteeringType.description = volunteeringTypeDto.description
        return save(volunteeringType)
    }
    
    /**
     * This service method is used to update an VolunteeringType object in the database from a partial or complete VolunteeringType object.
     *
     * @param volunteeringType the partial or complete VolunteeringType object to be saved
     * @return the saved version of the VolunteeringType object
     */
    @Transactional
    public VolunteeringType updateFromDto(VolunteeringTypeDto volunteeringTypeDto) {
        if (volunteeringTypeDto == null) {
            throw new InvalidDataException("Cannot update volunteeringType from null object.")
        }
        VolunteeringType volunteeringType = findById(volunteeringTypeDto.id);
        volunteeringType.code = volunteeringTypeDto.code
        volunteeringType.description = volunteeringTypeDto.description
        return save(volunteeringType)
    }
}
