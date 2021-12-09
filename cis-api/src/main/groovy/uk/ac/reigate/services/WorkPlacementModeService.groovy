package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.WorkPlacementMode
import uk.ac.reigate.dto.WorkPlacementModeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.WorkPlacementModeRepository

@Service
class WorkPlacementModeService implements ICoreDataService<WorkPlacementMode, Integer>, IDtoCreateUpdateService<WorkPlacementModeDto, WorkPlacementMode>{
    
    @Autowired
    WorkPlacementModeRepository workPlacementModeRepository
    
    /**
     * Default NoArgs constructor
     */
    WorkPlacementModeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param workPlacementModeRepository
     */
    WorkPlacementModeService(WorkPlacementModeRepository workPlacementModeRepository) {
        this.workPlacementModeRepository = workPlacementModeRepository;
    }
    
    /**
     * Find an individual workPlacementMode using the workPlacementModes ID fields
     *
     * @param id the ID fields to search for
     * @return the WorkPlacementMode object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    WorkPlacementMode findById(Integer id) {
        return workPlacementModeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all workPlacementModes
     *
     * @return a SearchResult set with the list of WorkPlacementModes
     */
    @Override
    @Transactional(readOnly = true)
    List<WorkPlacementMode> findAll() {
        return workPlacementModeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete WorkPlacementMode object in the database
     *
     * @param workPlacementMode the new WorkPlacementMode object to be saved
     * @return the saved version of the WorkPlacementMode object
     */
    @Override
    @Transactional
    public WorkPlacementMode save(WorkPlacementMode workPlacementMode) {
        return workPlacementModeRepository.save(workPlacementMode)
    }
    
    /**
     * Saves a list of WorkPlacementMode objects to the database
     *
     * @param workPlacementModes a list of WorkPlacementModes to be saved to the database
     * @return the list of save WorkPlacementMode objects
     */
    @Transactional
    public List<WorkPlacementMode> saveWorkPlacementModes(List<WorkPlacementMode> workPlacementModes) {
        return workPlacementModes.collect { workPlacementMode -> save(workPlacementMode) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. WorkPlacementMode should not be deleted.
     */
    @Override
    public void delete(WorkPlacementMode obj) {
        throw new InvalidOperationException("WorkPlacementMode should not be deleted");
    }
    
    /**
     * This service method is used to create an WorkPlacementMode object in the database from a partial or complete WorkPlacementMode object.
     *
     * @param workPlacementMode the partial or complete WorkPlacementMode object to be saved
     * @return the saved version of the WorkPlacementMode object
     */
    @Transactional
    public WorkPlacementMode createFromDto(WorkPlacementModeDto workPlacementModeDto) {
        if (workPlacementModeDto == null) {
            throw new InvalidDataException("Cannot create workPlacementModeDto from null object.")
        }
        WorkPlacementMode workPlacementMode = new WorkPlacementMode()
        workPlacementMode.id = workPlacementModeDto.id
        workPlacementMode.code = workPlacementModeDto.code
        workPlacementMode.description = workPlacementModeDto.description
        return save(workPlacementMode)
    }
    
    /**
     * This service method is used to update an WorkPlacementMode object in the database from a partial or complete WorkPlacementMode object.
     *
     * @param workPlacementMode the partial or complete WorkPlacementMode object to be saved
     * @return the saved version of the WorkPlacementMode object
     */
    @Transactional
    public WorkPlacementMode updateFromDto(WorkPlacementModeDto workPlacementModeDto) {
        if (workPlacementModeDto == null) {
            throw new InvalidDataException("Cannot update workPlacementModeDto from null object.")
        }
        WorkPlacementMode workPlacementMode = findById(workPlacementModeDto.id);
        workPlacementMode.code = workPlacementModeDto.code
        workPlacementMode.description = workPlacementModeDto.description
        return save(workPlacementMode)
    }
}
