package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.dto.EntryQualificationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.EntryQualificationRepository

@Service
class EntryQualificationService implements ICoreDataService<EntryQualification, Integer>, IDtoCreateUpdateService<EntryQualificationDto, EntryQualification>{
    
    @Autowired
    EntryQualificationRepository entryQualificationRepository
    
    @Autowired
    private final EntryQualificationTypeService entryQualificationTypeService;
    
    /**
     * Default NoArgs constructor
     */
    EntryQualificationService() {}
    
    /**
     * Autowired Constructor
     *
     * @param entryQualificationRepository
     */
    EntryQualificationService(EntryQualificationRepository entryQualificationRepository, EntryQualificationTypeService entryQualificationTypeService) {
        this.entryQualificationRepository = entryQualificationRepository;
        this.entryQualificationTypeService = entryQualificationTypeService;
    }
    
    /**
     * Find an individual entryQualification using the entryQualifications ID fields
     *
     * @param id the ID fields to search for
     * @return the EntryQualification object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    EntryQualification findById(Integer id) {
        return entryQualificationRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all entryQualifications
     *
     * @return a List of EntryQualifications
     */
    @Override
    @Transactional(readOnly = true)
    List<EntryQualification> findAll() {
        return entryQualificationRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete EntryQualification object in the database
     *
     * @param entryQualification the new EntryQualification object to be saved
     * @return the saved version of the EntryQualification object
     */
    @Override
    @Transactional
    public EntryQualification save(EntryQualification entryQualification) {
        return entryQualificationRepository.save(entryQualification)
    }
    
    /**
     * Saves a list of EntryQualification objects to the database
     *
     * @param entryQualifications a list of EntryQualifications to be saved to the database
     * @return the list of save EntryQualification objects
     */
    @Transactional
    public List<EntryQualification> saveEntryQualifications(List<EntryQualification> entryQualifications) {
        return entryQualifications.collect { entryQualification -> save(entryQualification) };
    }
    
    /**
     * This service method is used to create an EntryQualification object in the database from a partial or complete EntryQualification object.
     *
     * @param bursaryType the partial or complete EntryQualification object to be saved
     * @return the saved version of the EntryQualification object
     */
    @Transactional
    public EntryQualification createFromDto(EntryQualificationDto entryQualificationDto) {
        if (entryQualificationDto == null) {
            throw new InvalidDataException("Cannot create entryQualificationDto from null object.")
        }
        EntryQualification entryQualification = new EntryQualification()
        entryQualification.title = entryQualificationDto.title;
        if(entryQualificationDto.entryQualificationTypeId != null){
            entryQualification.type = entryQualificationTypeService.findById(entryQualificationDto.entryQualificationTypeId)
        }
        entryQualification.basicList = entryQualificationDto.basicList
        entryQualification.shortCourse = entryQualificationDto.shortCourse
        entryQualification.dataMatchCode = entryQualificationDto.dataMatchCode;
        entryQualification.webLinkCode = entryQualificationDto.webLinkCode;
        entryQualification.OLDID = entryQualificationDto.OLDID;
        return save(entryQualification)
    }
    
    /**
     * This service method is used to update an EntryQualification object in the database from a partial or complete EntryQualification object.
     *
     * @param bursaryType the partial or complete EntryQualification object to be saved
     * @return the saved version of the EntryQualification object
     */
    @Transactional
    public EntryQualification updateFromDto(EntryQualificationDto entryQualificationDto) {
        if(entryQualificationDto.id == null) {
            throw new InvalidDataException("Cannot update entryQualificationDto from null object.")
        }
        EntryQualification entryQualification = findById(entryQualificationDto.id)
        if(entryQualificationDto.entryQualificationTypeId != null){
            entryQualification.type = entryQualificationTypeService.findById(entryQualificationDto.entryQualificationTypeId)
        }
        entryQualification.title = entryQualificationDto.title;
        entryQualification.basicList = entryQualificationDto.basicList
        entryQualification.shortCourse = entryQualificationDto.shortCourse
        entryQualification.dataMatchCode = entryQualificationDto.dataMatchCode;
        entryQualification.webLinkCode = entryQualificationDto.webLinkCode;
        entryQualification.OLDID = entryQualificationDto.OLDID;
        return save(entryQualification)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. EntryQualification should not be deleted.
     */
    @Override
    public void delete(EntryQualification obj) {
        throw new InvalidOperationException("EntryQualification should not be deleted")
    }
}
