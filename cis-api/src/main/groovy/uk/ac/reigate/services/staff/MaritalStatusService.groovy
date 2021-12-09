package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.MaritalStatus
import uk.ac.reigate.dto.staff.MaritalStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.MaritalStatusRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class MaritalStatusService implements ICoreDataService<MaritalStatus, Integer>, IDtoCreateUpdateService<MaritalStatusDto, MaritalStatus>{
    
    @Autowired
    MaritalStatusRepository maritalStatusRepository
    
    /**
     * Default NoArgs constructor
     */
    MaritalStatusService() {}
    
    /**
     * Autowired Constructor
     *
     * @param maritalStatusRepository
     */
    MaritalStatusService(MaritalStatusRepository maritalStatusRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param maritalStatusRepository
     */
    @Override
    @Transactional(readOnly = true)
    MaritalStatus findById(Integer id) {
        return maritalStatusRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of MaritalStatus objects
     * @return a SearchResult set with the list of Nationalities
     */
    @Override
    @Transactional(readOnly = true)
    List<MaritalStatus> findAll() {
        return maritalStatusRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete MaritalStatus object in the database
     *
     * @param maritalStatus the new MaritalStatus object to be saved
     * @return the saved version of the MaritalStatus object
     */
    @Override
    @Transactional
    public MaritalStatus save(MaritalStatus maritalStatus) {
        return maritalStatusRepository.save(maritalStatus)
    }
    
    /**
     * This service method is used to create a MaritalStatus object in the database from a partial or complete MaritalStatus object.
     *
     * @param maritalStatus the partial or complete MaritalStatus object to be saved
     * @return the saved version of the MaritalStatus object
     */
    @Transactional
    public MaritalStatus createFromDto(MaritalStatusDto maritalStatusDto) {
        if (maritalStatusDto == null) {
            throw new InvalidDataException("Cannot create maritalStatusDto from null object.")
        }
        MaritalStatus maritalStatus = new MaritalStatus()
        maritalStatus.maritalStatus = maritalStatusDto.maritalStatus
        return  save(maritalStatus)
    }
    
    /**
     * This service method is used to update a MaritalStatus object in the database from a partial or complete MaritalStatus object.
     *
     * @param maritalStatus the partial or complete MaritalStatus object to be saved
     * @return the saved version of the MaritalStatus object
     */
    @Transactional
    public MaritalStatus updateFromDto(MaritalStatusDto maritalStatusDto) {
        if (maritalStatusDto == null) {
            throw new InvalidDataException("Cannot update maritalStatusDto from null object.")
        }
        MaritalStatus maritalStatus = findById(maritalStatusDto.id)
        maritalStatus.maritalStatus = maritalStatusDto.maritalStatus
        return  save(maritalStatus)
    }
    
    /**
     * Saves a list of MaritalStatus objects to the database
     *
     * @param maritalStatuss a list of Nationalities to be saved to the database
     * @return the list of save MaritalStatus objects
     */
    @Transactional
    public List<MaritalStatus> saveNationalities(List<MaritalStatus> maritalStatuses) {
        return maritalStatuses.collect { maritalStatus -> save(maritalStatus) };
    }
    /**
     * This methods throws an InvalidOperationException when called. MaritalStatus should not be deleted.
     */
    @Override
    public void delete(MaritalStatus obj) {
        throw new InvalidOperationException("MaritalStatus should not be deleted")
    }
}
