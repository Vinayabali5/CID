package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.dto.EntryQualificationTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.EntryQualificationTypeRepository
import uk.ac.reigate.services.lookup.PossibleGradeSetService

@Service
class EntryQualificationTypeService implements ICoreDataService<EntryQualificationType, Integer>, IDtoCreateUpdateService<EntryQualificationTypeDto, EntryQualificationType> {
    
    @Autowired
    EntryQualificationTypeRepository entryQualificationTypeRepository
    
    @Autowired
    private final PossibleGradeSetService possibleGradeSetService
    
    /**
     * Default NoArgs constructor
     */
    EntryQualificationTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param entryQualificationTypeRepository
     */
    EntryQualificationTypeService(EntryQualificationTypeRepository entryQualificationTypeRepository, PossibleGradeSetService possibleGradeSetService) {
        this.entryQualificationTypeRepository = entryQualificationTypeRepository;
        this.possibleGradeSetService = possibleGradeSetService;
    }
    
    /**
     * Find an individual entryQualificationType using the entryQualificationTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the EntryQualificationType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    EntryQualificationType findById(Integer id) {
        return entryQualificationTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all entryQualificationTypes
     *
     * @return a SearchResult set with the list of EntryQualificationTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<EntryQualificationType> findAll() {
        return entryQualificationTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete EntryQualificationType object in the database
     *
     * @param entryQualificationType the new EntryQualificationType object to be saved
     * @return the saved version of the EntryQualificationType object
     */
    @Override
    @Transactional
    public EntryQualificationType save(EntryQualificationType entryQualificationType) {
        return entryQualificationTypeRepository.save(entryQualificationType)
    }
    
    /**
     * This service method is used to update an EntryQualificationType object in the database from a partial or complete EntryQualificationType object.
     *
     * @param entryQualificationType the partial or complete EntryQualificationType object to be saved
     * @return the saved version of the EntryQualificationType object
     */
    @Transactional
    public EntryQualificationType createFromDto(EntryQualificationTypeDto entryQualificationType) {
        if (entryQualificationType == null) {
            throw new InvalidDataException("Cannot create entryQualificationTypeDto from null object.")
        }
        EntryQualificationType entryQualificationTypeToSave = new EntryQualificationType()
        entryQualificationTypeToSave.code = entryQualificationType.code
        entryQualificationTypeToSave.description = entryQualificationType.description
        entryQualificationTypeToSave.size = entryQualificationType.size
        entryQualificationTypeToSave.possibleGradeSet = entryQualificationType.possibleGradeSetId != null ? possibleGradeSetService.findById(entryQualificationType.possibleGradeSetId) : null
        entryQualificationTypeToSave.useOfRoe = entryQualificationType.useOfRoe
        return save(entryQualificationTypeToSave)
    }
    
    /**
     * This service method is used to update an EntryQualificationType object in the database from a partial or complete EntryQualificationType object.
     *
     * @param entryQualificationType the partial or complete EntryQualificationType object to be saved
     * @return the saved version of the EntryQualificationType object
     */
    @Transactional
    public EntryQualificationType updateFromDto(EntryQualificationTypeDto entryQualificationType) {
        if (entryQualificationType == null) {
            throw new InvalidDataException("Cannot update entryQualificationTypeDto from null object.")
        }
        EntryQualificationType entryQualificationTypeToSave = findById(entryQualificationType.id)
        entryQualificationTypeToSave.code = entryQualificationType.code
        entryQualificationTypeToSave.description = entryQualificationType.description
        entryQualificationTypeToSave.size = entryQualificationType.size
        entryQualificationTypeToSave.possibleGradeSet = entryQualificationType.possibleGradeSetId != null ? possibleGradeSetService.findById(entryQualificationType.possibleGradeSetId) : null
        entryQualificationTypeToSave.useOfRoe = entryQualificationType.useOfRoe
        return save(entryQualificationTypeToSave)
    }
    
    /**
     * Saves a list of EntryQualificationType objects to the database
     *
     * @param entryQualificationTypes a list of EntryQualificationTypes to be saved to the database
     * @return the list of save EntryQualificationType objects
     */
    @Transactional
    public List<EntryQualificationType> saveEntryQualificationTypes(List<EntryQualificationType> entryQualificationTypes) {
        return entryQualificationTypes.collect { entryQualificationType -> save(entryQualificationType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. EntryQualificationType should not be deleted.
     */
    @Override
    public void delete(EntryQualificationType obj) {
        throw new InvalidOperationException("EntryQualificationType should not be deleted")
    }
}
