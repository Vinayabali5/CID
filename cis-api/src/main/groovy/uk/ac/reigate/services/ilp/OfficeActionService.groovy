package uk.ac.reigate.services.ilp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.OfficeAction
import uk.ac.reigate.dto.ilp.OfficeActionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.OfficeActionRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class OfficeActionService implements ICoreDataService<OfficeAction, Integer>, IDtoCreateUpdateService<OfficeActionDto, OfficeAction>{
    
    @Autowired
    OfficeActionRepository officeActionRepository
    
    /**
     * Default NoArgs constructor    
     */
    OfficeActionService() {}
    
    /**
     * Autowired constructor
     * 
     * @param officeActionRepository
     */
    OfficeActionService(OfficeActionRepository officeActionRepository) {
        this.officeActionRepository = officeActionRepository
    }
    
    /**
     * Find an individual officeAction using the officeActions ID fields
     *
     * @param id the ID fields to search for
     * @return the OfficeAction object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    OfficeAction findById(Integer id) {
        return officeActionRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all officeActions
     *
     * @return a SearchResult set with the list of OfficeActions
     */
    @Override
    @Transactional(readOnly = true)
    List<OfficeAction> findAll() {
        return officeActionRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete OfficeAction object in the database
     *
     * @param officeAction the new OfficeAction object to be saved
     * @return the saved version of the OfficeAction object
     */
    @Override
    @Transactional
    public OfficeAction save(OfficeAction officeAction) {
        return officeActionRepository.save(officeAction)
    }
    
    /**
     * This service method is used to update a OfficeAction object in the database from a partial or complete OfficeAction object.
     *
     * @param officeAction the partial or complete OfficeAction object to be saved
     * @return the saved version of the OfficeAction object
     */
    @Transactional
    public OfficeAction createFromDto(OfficeActionDto officeAction) {
        if (officeAction == null) {
            throw new InvalidDataException("Cannot create officeAction from null object.")
        }
        OfficeAction officeActionToSave = new OfficeAction();
        officeActionToSave.action = officeAction.action
        return save(officeActionToSave)
    }
    
    /**
     * This service method is used to update a OfficeAction object in the database from a partial or complete OfficeAction object.
     *
     * @param officeAction the partial or complete OfficeAction object to be saved
     * @return the saved version of the OfficeAction object
     */
    @Transactional
    public OfficeAction updateFromDto(OfficeActionDto officeAction) {
        if (officeAction == null) {
            throw new InvalidDataException("Cannot update officeAction from null object.")
        }
        OfficeAction officeActionToSave = findById(officeAction.id)
        officeActionToSave.action = officeAction.action
        return save(officeActionToSave)
    }
    
    /**
     * Saves a list of OfficeAction objects to the database
     *
     * @param officeActions a list of OfficeActions to be saved to the database
     * @return the list of save OfficeAction objects
     */
    @Transactional
    public List<OfficeAction> saveOfficeActions(List<OfficeAction> officeActions) {
        return officeActions.collect { officeAction -> save(officeAction) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. OfficeAction should not be deleted.
     */
    @Override
    public void delete(OfficeAction obj) {
        throw new InvalidOperationException("OfficeAction should not be deleted")
    }
}
