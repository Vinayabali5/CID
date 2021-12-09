package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.SchoolType
import uk.ac.reigate.dto.lookup.SchoolTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.SchoolTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class SchoolTypeService implements ICoreDataService<SchoolType, Integer>, IDtoCreateUpdateService<SchoolTypeDto, SchoolType>{
    
    @Autowired
    SchoolTypeRepository schoolTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    SchoolTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param schoolTypeRepository
     */
    SchoolTypeService(SchoolTypeRepository schoolTypeRepository) {
        this.schoolTypeRepository = schoolTypeRepository;
    }
    
    /**
     * Find an individual schoolType using the schoolTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the SchoolType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    SchoolType findById(Integer id) {
        return schoolTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of SchoolType objects
     * @return a SearchResult set with the list of SchoolTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<SchoolType> findAll() {
        return schoolTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete SchoolType object in the database
     *
     * @param schoolType the new SchoolType object to be saved
     * @return the saved version of the SchoolType object
     */
    @Override
    @Transactional
    public SchoolType save(SchoolType schoolType) {
        return schoolTypeRepository.save(schoolType)
    }
    
    /**
     * This service method is used to update an SchoolType object in the database from a partial or complete SchoolType object.
     *
     * @param schoolType the partial or complete SchoolType object to be saved
     * @return the saved version of the SchoolType object
     */
    @Transactional
    public SchoolType createFromDto(SchoolTypeDto schoolTypeDto) {
        if (schoolTypeDto == null) {
            throw new InvalidDataException("Cannot create schoolType from null object.")
        }
        SchoolType schoolType = new SchoolType()
        schoolType.code = schoolTypeDto.code
        schoolType.description = schoolTypeDto.description
        return save(schoolType)
    }
    
    /**
     * This service method is used to update an SchoolType object in the database from a partial or complete SchoolType object.
     *
     * @param schoolType the partial or complete SchoolType object to be saved
     * @return the saved version of the SchoolType object
     */
    @Transactional
    public SchoolType updateFromDto(SchoolTypeDto schoolTypeDto) {
        if (schoolTypeDto == null) {
            throw new InvalidDataException("Cannot update schoolType from null object.")
        }
        SchoolType schoolType = findById(schoolTypeDto.id)
        schoolType.code = schoolTypeDto.code
        schoolType.description = schoolTypeDto.description
        return save(schoolType)
    }
    
    /**
     * Saves a list of SchoolType objects to the database
     *
     * @param schoolTypes a list of SchoolTypes to be saved to the database
     * @return the list of save SchoolType objects
     */
    @Transactional
    public List<SchoolType> saveSchoolTypes(List<SchoolType> schoolTypes) {
        return schoolTypes.collect { schoolType -> save(schoolType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. SchoolType should not be deleted.
     */
    @Override
    public void delete(SchoolType obj) {
        throw new InvalidOperationException("SchoolType should not be deleted")
    }
}
