package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.CentralMonitoring
import uk.ac.reigate.dto.CentralMonitoringDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.lookup.CentralMonitoringRepository
import uk.ac.reigate.util.exception.IdMissingException

@Service
class CentralMonitoringService implements ICoreDataService<CentralMonitoring, Integer>, IDtoCreateUpdateService<CentralMonitoringDto, CentralMonitoring>{
    
    @Autowired
    CentralMonitoringRepository centralMonitoringRepository
    
    /**
     * Default NoArgs constructor
     */
    CentralMonitoringService() {}
    
    /**
     * Autowired Constructor
     *
     * @param centralMonitoringRepository
     */
    CentralMonitoringService(CentralMonitoringRepository centralMonitoringRepository) {
        this.centralMonitoringRepository = centralMonitoringRepository;
    }
    
    /**
     * Find an individual centralMonitoring using the centralMonitorings ID fields
     *
     * @param id the ID fields to search for
     * @return the CentralMonitoring object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    CentralMonitoring findById(Integer id) {
        return centralMonitoringRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all centralMonitorings
     *
     * @return a List of CentralMonitorings
     */
    @Override
    @Transactional(readOnly = true)
    List<CentralMonitoring> findAll() {
        return centralMonitoringRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CentralMonitoring object in the database
     *
     * @param centralMonitoring the new CentralMonitoring object to be saved
     * @return the saved version of the CentralMonitoring object
     */
    @Override
    @Transactional
    public CentralMonitoring save(CentralMonitoring centralMonitoring) {
        return centralMonitoringRepository.save(centralMonitoring)
    }
    
    /**
     * This service method is used to create an CentralMonitoring object in the database from a partial or complete CentralMonitoring object.
     *
     * @param centralMonitoring the partial or complete CentralMonitoring object to be saved
     * @return the saved version of the CentralMonitoring object
     */
    @Transactional
    public CentralMonitoring createFromDto(CentralMonitoringDto centralMonitoring) {
        if (centralMonitoring == null) {
            throw new InvalidDataException("Cannot create CentralMonitoring from null object.")
        }
        if (findById(centralMonitoring.id) != null) {
            throw new IdMissingException("A centralMonitoring already exist with this ID.")
        }
        CentralMonitoring centralMonitoringToSave = new CentralMonitoring()
        centralMonitoringToSave.id = centralMonitoring.id
        centralMonitoringToSave.code = centralMonitoring.code
        centralMonitoringToSave.description = centralMonitoring.description
        centralMonitoringToSave.warningColour = centralMonitoring.warningColour
        centralMonitoringToSave.nonEntry = centralMonitoring.nonEntry
        return save(centralMonitoringToSave)
    }
    
    /**
     * This service method is used to update an CentralMonitoring object in the database from a partial or complete CentralMonitoring object.
     *
     * @param centralMonitoring the partial or complete CentralMonitoring object to be saved
     * @return the saved version of the CentralMonitoring object
     */
    @Transactional
    public CentralMonitoring updateFromDto(CentralMonitoringDto centralMonitoring) {
        if (centralMonitoring == null) {
            throw new InvalidDataException("Cannot update centralMonitoring from null object.")
        }
        if (centralMonitoring.id == null) {
            throw new InvalidDataException("Cannot update centralMonitoring when the ID is null.")
        }
        CentralMonitoring centralMonitoringToSave = findById(centralMonitoring.id);
        centralMonitoringToSave.code = centralMonitoring.code
        centralMonitoringToSave.description = centralMonitoring.description
        centralMonitoringToSave.warningColour = centralMonitoring.warningColour
        centralMonitoringToSave.nonEntry = centralMonitoring.nonEntry
        return save(centralMonitoringToSave)
    }
    
    /**
     * Saves a list of CentralMonitoring objects to the database
     *
     * @param centralMonitorings a list of CentralMonitorings to be saved to the database
     * @return the list of save CentralMonitoring objects
     */
    @Transactional
    public List<CentralMonitoring> saveCentralMonitorings(List<CentralMonitoring> centralMonitorings) {
        return centralMonitorings.collect { centralMonitoring -> save(centralMonitoring) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. CentralMonitoring should not be deleted.
     */
    @Override
    public void delete(CentralMonitoring obj) {
        throw new InvalidOperationException("CentralMonitoring should not be deleted.")
    }
}
