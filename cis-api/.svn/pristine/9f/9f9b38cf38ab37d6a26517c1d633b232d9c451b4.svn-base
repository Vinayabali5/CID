package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.YearGroup
import uk.ac.reigate.dto.lookup.YearGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.YearGroupRepository

@Service
class YearGroupService implements ICoreDataService<YearGroup, Integer>, IDtoCreateUpdateService<YearGroupDto, YearGroup>{
    
    @Autowired
    YearGroupRepository yearGroupRepository
    
    /**
     * Default NoArgs constructor
     */
    YearGroupService() {}
    
    /**
     * Autowired Constructor
     *
     * @param yearGroupRepository
     */
    YearGroupService(YearGroupRepository yearGroupRepository) {
        this.yearGroupRepository = yearGroupRepository;
    }
    
    /**
     * Find an individual yearGroup using the yearGroups ID fields
     *
     * @param id the ID fields to search for
     * @return the YearGroup object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    YearGroup findById(Integer id) {
        return yearGroupRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of YearGroup objects
     * @return a SearchResult set with the list of YearGroups
     */
    @Override
    @Transactional(readOnly = true)
    List<YearGroup> findAll() {
        return yearGroupRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete YearGroup object in the database
     *
     * @param yearGroup the new YearGroup object to be saved
     * @return the saved version of the YearGroup object
     */
    @Override
    @Transactional
    public YearGroup save(YearGroup yearGroup) {
        return yearGroupRepository.save(yearGroup)
    }
    
    /**
     * This service method is used to create a YearGroup object in the database from a partial or complete YearGroup object.
     *
     * @param yearGroup the partial or complete YearGroup object to be saved
     * @return the saved version of the YearGroup object
     */
    @Transactional
    public YearGroup createFromDto(YearGroupDto yearGroup) {
        if (yearGroup == null) {
            throw new InvalidDataException("Cannot create yearGroup from null object.")
        }
        YearGroup yearGroupToSave = new YearGroup();
        yearGroupToSave.code = yearGroup.code
        yearGroupToSave.description = yearGroup.description
        yearGroupToSave.excludeTTCheck = yearGroup.excludeTTCheck
        return save(yearGroupToSave)
    }
    
    /**
     * This service method is used to update a YearGroup object in the database from a partial or complete YearGroup object.
     *
     * @param yearGroup the partial or complete YearGroup object to be saved
     * @return the saved version of the YearGroup object
     */
    @Transactional
    public YearGroup updateFromDto(YearGroupDto yearGroup) {
        if (yearGroup == null) {
            throw new InvalidDataException("Cannot update yearGroup from null object.")
        }
        YearGroup yearGroupToSave = findById(yearGroup.id)
        yearGroupToSave.code = yearGroup.code
        yearGroupToSave.description = yearGroup.description
        yearGroupToSave.excludeTTCheck = yearGroup.excludeTTCheck
        return save(yearGroupToSave)
    }
    
    /**
     * Saves a list of YearGroup objects to the database
     *
     * @param yearGroups a list of YearGroups to be saved to the database
     * @return the list of save YearGroup objects
     */
    @Transactional
    public List<YearGroup> saveYearGroups(List<YearGroup> yearGroups) {
        return yearGroups.collect { yearGroup -> save(yearGroup) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. YearGroup should not be deleted.
     */
    @Override
    public void delete(YearGroup obj) {
        throw new InvalidOperationException("YearGroup should not be deleted")
    }
}
