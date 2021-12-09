package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.dto.lookup.StaffTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StaffTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StaffTypeService implements ICoreDataService<StaffType, Integer>, IDtoCreateUpdateService<StaffTypeDto, StaffType>{
    
    @Autowired
    StaffTypeRepository staffTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    StaffTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param staffTypeRepository
     */
    StaffTypeService(StaffTypeRepository staffTypeRepository) {
        this.staffTypeRepository = staffTypeRepository;
    }
    
    /**
     * Find an individual staffType using the staffTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the StaffType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StaffType findById(Integer id) {
        return staffTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of StaffType objects
     * @return a List of StaffTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<StaffType> findAll() {
        return staffTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StaffType object in the database
     *
     * @param staffType the new StaffType object to be saved
     * @return the saved version of the StaffType object
     */
    @Override
    @Transactional
    public StaffType save(StaffType staffType) {
        return staffTypeRepository.save(staffType)
    }
    
    /**
     * This service method is used to create a StaffType object in the database from a partial or complete StaffType object.
     *
     * @param staffType the partial or complete StaffType object to be saved
     * @return the saved version of the StaffType object
     */
    @Transactional
    public StaffType createFromDto(StaffTypeDto staffTypeDto) {
        if (staffTypeDto == null) {
            throw new InvalidDataException("Cannot create staffType from null object.")
        }
        StaffType staffType = new StaffType()
        staffType.code = staffTypeDto.code
        staffType.description = staffTypeDto.description
        staffType.needInitials = staffTypeDto.needInitials
        return save(staffType)
    }
    
    /**
     * This service method is used to update an StaffType object in the database from a partial or complete StaffType object.
     *
     * @param staffType the partial or complete StaffType object to be saved
     * @return the saved version of the StaffType object
     */
    @Transactional
    public StaffType updateFromDto(StaffTypeDto staffTypeDto) {
        if (staffTypeDto == null) {
            throw new InvalidDataException("Cannot update staffType from null object.")
        }
        StaffType staffType = findById(staffTypeDto.id)
        staffType.code = staffTypeDto.code
        staffType.description = staffTypeDto.description
        staffType.needInitials = staffTypeDto.needInitials
        return save(staffType)
    }
    
    /**
     * Saves a list of StaffType objects to the database
     *
     * @param staffTypes a list of StaffTypes to be saved to the database
     * @return the list of save StaffType objects
     */
    @Transactional
    public List<StaffType> saveStaffTypes(List<StaffType> staffTypes) {
        return staffTypes.collect { staffType -> save(staffType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StaffType should not be deleted.
     */
    @Override
    public void delete(StaffType obj) {
        throw new InvalidOperationException("StaffType should not be deleted")
    }
}
