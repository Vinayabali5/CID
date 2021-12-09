package uk.ac.reigate.services.admissions

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.dto.admissions.ApplicationStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.ApplicationStatusRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class ApplicationStatusService implements ICoreDataService<ApplicationStatus, Integer>, IDtoCreateUpdateService<ApplicationStatusDto, ApplicationStatus> {
    
    @Autowired
    ApplicationStatusRepository applicationStatusRepository
    
    /**
     * Default NoArgs constructor
     */
    ApplicationStatusService() {}
    
    /**
     * Autowired Constructor
     *
     * @param applicationStatusRepository
     */
    ApplicationStatusService(ApplicationStatusRepository applicationStatusRepository) {
        this.applicationStatusRepository = applicationStatusRepository
    }
    
    /**
     * Find an individual applicationStatus using the applicationStatuses ID fields
     *
     * @param id the ID fields to search for
     * @return the ApplicationStatus object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ApplicationStatus findById(Integer id) {
        return applicationStatusRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all applicationStatuses
     *
     * @return a List set with the list of ApplicationStatuses
     */
    @Override
    @Transactional(readOnly = true)
    List<ApplicationStatus> findAll() {
        return applicationStatusRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ApplicationStatus object in the database
     *
     * @param applicationStatus the new ApplicationStatus object to be saved
     * @return the saved version of the ApplicationStatus object
     */
    @Override
    @Transactional
    public ApplicationStatus save(ApplicationStatus applicationStatus) {
        return applicationStatusRepository.save(applicationStatus)
    }
    
    /**
     * This service method is used to update an ApplicationStatus object in the database from a partial or complete ApplicationStatus object.
     *
     * @param applicationStatus the partial or complete ApplicationStatus object to be saved
     * @return the saved version of the ApplicationStatus object
     */
    @Transactional
    public ApplicationStatus createFromDto(ApplicationStatusDto applicationStatus) {
        if (applicationStatus == null) {
            throw new InvalidDataException("Cannot create applicationStatus from null object.")
        }
        ApplicationStatus applicationStatusToSave = new ApplicationStatus()
        applicationStatusToSave.code = applicationStatus.code
        applicationStatusToSave.description = applicationStatus.description
        applicationStatusToSave.considerWithdrawn = applicationStatus.considerWithdrawn
        return save(applicationStatusToSave)
    }
    
    /**
     * This service method is used to update an ApplicationStatus object in the database from a partial or complete ApplicationStatus object.
     *
     * @param applicationStatus the partial or complete ApplicationStatus object to be saved
     * @return the saved version of the ApplicationStatus object
     */
    @Transactional
    public ApplicationStatus updateFromDto(ApplicationStatusDto applicationStatus) {
        if (applicationStatus == null) {
            throw new InvalidDataException("Cannot update applicationStatus from null object.")
        }
        ApplicationStatus applicationStatusToSave = findById(applicationStatus.id)
        applicationStatusToSave.code = applicationStatus.code != null ? applicationStatus.code : applicationStatusToSave.code
        applicationStatusToSave.description = applicationStatus.description != null ? applicationStatus.description : applicationStatusToSave.description
        applicationStatusToSave.considerWithdrawn = applicationStatus.considerWithdrawn
        return save(applicationStatusToSave)
    }
    
    /**
     * Saves a list of ApplicationStatus objects to the database
     *
     * @param applicationStatuses a list of ApplicationStatuses to be saved to the database
     * @return the list of save ApplicationStatus objects
     */
    @Transactional
    public List<ApplicationStatus> saveList(List<ApplicationStatus> applicationStatuses) {
        return applicationStatuses.collect { applicationStatus -> save(applicationStatus) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ApplicationStatus should not be deleted.
     */
    @Override
    @Transactional
    public void delete(ApplicationStatus obj) {
        throw new InvalidOperationException("ApplicationStatus should not be deleted.")
    }
    
    /**
     * This method is used to retrieve an ApplicationStatus data object based on the supplied description.
     *  
     * @param description the description to search for in the database
     * @return an ApplicationStatus data object that matches the search criteria
     */
    public ApplicationStatus findByDescription(String description) {
        return applicationStatusRepository.findByDescription(description)
    }
}
