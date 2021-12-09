package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.PunctualityMonitoring
import uk.ac.reigate.dto.PunctualityMonitoringDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.PunctualityMonitoringRepository

@Service
class PunctualityMonitoringService implements ICoreDataService<PunctualityMonitoring, Integer>, IDtoCreateUpdateService<PunctualityMonitoringDto, PunctualityMonitoring>{
    
    @Autowired
    PunctualityMonitoringRepository punctualityMonitoringRepository
    
    /**
     * Default NoArgs constructor
     */
    PunctualityMonitoringService() {}
    
    /**
     * Autowired Constructor
     *
     * @param punctualityMonitoringRepository
     */
    PunctualityMonitoringService(PunctualityMonitoringRepository punctualityMonitoringRepository) {
        this.punctualityMonitoringRepository = punctualityMonitoringRepository;
    }
    
    /**
     * Find an individual punctualityMonitoring using the punctualityMonitorings ID fields
     *
     * @param id the ID fields to search for
     * @return the PunctualityMonitoring object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    PunctualityMonitoring findById(Integer id) {
        return punctualityMonitoringRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all punctualityMonitorings
     *
     * @return a SearchResult set with the list of PunctualityMonitorings
     */
    @Override
    @Transactional(readOnly = true)
    List<PunctualityMonitoring> findAll() {
        return punctualityMonitoringRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete PunctualityMonitoring object in the database
     *
     * @param punctualityMonitoring the new PunctualityMonitoring object to be saved
     * @return the saved version of the PunctualityMonitoring object
     */
    @Override
    @Transactional
    public PunctualityMonitoring save(PunctualityMonitoring punctualityMonitoring) {
        return punctualityMonitoringRepository.save(punctualityMonitoring)
    }
    
    /**
     * This service method is used to create a PunctualityMonitoring object in the database from a partial or complete PunctualityMonitoring object.
     *
     * @param punctualityMonitoring the partial or complete PunctualityMonitoring object to be saved
     * @return the saved version of the PunctualityMonitoring object
     */
    
    @Transactional
    public PunctualityMonitoring createFromDto(PunctualityMonitoringDto punctualityMonitoringDto) {
        if (punctualityMonitoringDto == null) {
            throw new InvalidDataException("Cannot create punctualityMonitoringDto from null object.")
        }
        PunctualityMonitoring punctualityMonitoring = new PunctualityMonitoring()
        punctualityMonitoring.id = punctualityMonitoringDto.id
        punctualityMonitoring.code = punctualityMonitoringDto.code
        punctualityMonitoring.description = punctualityMonitoringDto.description
        punctualityMonitoring.warningColour = punctualityMonitoringDto.warningColour
        punctualityMonitoring.htmlColour = punctualityMonitoringDto.htmlColour
        punctualityMonitoring.inUse = punctualityMonitoringDto.inUse
        punctualityMonitoring.nonEntry = punctualityMonitoringDto.nonEntry
        return save(punctualityMonitoring)
    }
    
    /**
     * This service method is used to update a PunctualityMonitoring object in the database from a partial or complete PunctualityMonitoring object.
     *
     * @param punctualityMonitoring the partial or complete PunctualityMonitoring object to be saved
     * @return the saved version of the PunctualityMonitoring object
     */
    
    @Transactional
    public PunctualityMonitoring updateFromDto(PunctualityMonitoringDto punctualityMonitoringDto) {
        if (punctualityMonitoringDto == null) {
            throw new InvalidDataException("Cannot update punctualityMonitoringDto from null object.")
        }
        PunctualityMonitoring punctualityMonitoring = findById(punctualityMonitoringDto.id)
        punctualityMonitoring.code = punctualityMonitoringDto.code
        punctualityMonitoring.description = punctualityMonitoringDto.description
        punctualityMonitoring.warningColour = punctualityMonitoringDto.warningColour
        punctualityMonitoring.htmlColour = punctualityMonitoringDto.htmlColour
        punctualityMonitoring.inUse = punctualityMonitoringDto.inUse
        punctualityMonitoring.nonEntry = punctualityMonitoringDto.nonEntry
        return save(punctualityMonitoring)
    }
    
    /**
     * Saves a list of PunctualityMonitoring objects to the database
     *
     * @param punctualityMonitorings a list of PunctualityMonitorings to be saved to the database
     * @return the list of save PunctualityMonitoring objects
     */
    
    @Transactional
    public List<PunctualityMonitoring> savePunctualityMonitorings(List<PunctualityMonitoring> punctualityMonitorings) {
        return punctualityMonitorings.collect { punctualityMonitoring -> save(punctualityMonitoring) };
    }
    
    
    /**
     * This methods throws an InvalidOperationException when called. PunctualityMonitoring should not be deleted.
     */
    @Override
    public void delete(PunctualityMonitoring obj) {
        throw new InvalidOperationException("PunctualityMonitoring should not be deleted")
    }
}
