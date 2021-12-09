package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.dto.lookup.PossibleGradeSetDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.PossibleGradeSetRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
@RequiredArgsConstructor
class PossibleGradeSetService implements ICoreDataService<PossibleGradeSet, Integer>, IDtoCreateUpdateService<PossibleGradeSetDto, PossibleGradeSet>{
    
    @Autowired
    PossibleGradeSetRepository possibleGradeSetRepository
    
    @Autowired
    PossibleGradeService possibleGradeService
    
    /**
     * Default NoArgs constructor
     */
    PossibleGradeSetService() {}
    
    /**
     * Autowired Constructor
     *
     * @param possibleGradeSetRepository
     */
    PossibleGradeSetService(PossibleGradeSetRepository possibleGradeSetRepository, PossibleGradeService possibleGradeService) {
        super();
        this.possibleGradeSetRepository = possibleGradeSetRepository;
        this.possibleGradeService = possibleGradeService;
    }
    
    /**
     * Find an individual possibleGradeSet using the possibleGradeSets ID fields
     *
     * @param id the ID fields to search for
     * @return the PossibleGradeSet object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    PossibleGradeSet findById(Integer id) {
        return possibleGradeSetRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all possibleGradeSets
     *
     * @return a List of PossibleGradeSets
     */
    @Transactional(readOnly = true)
    List<PossibleGradeSet> findAll() {
        return possibleGradeSetRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete PossibleGradeSet object in the database
     *
     * @param possibleGradeSet the new PossibleGradeSet object to be saved
     * @return the saved version of the PossibleGradeSet object
     */
    @Transactional
    public PossibleGradeSet save(PossibleGradeSet possibleGradeSet) {
        return possibleGradeSetRepository.save(possibleGradeSet)
    }
    
    /**
     * This service method is used to create a PossibleGradeSet object in the database from a partial or complete PossibleGradeSet object.
     *
     * @param possibleGradeSet the partial or complete PossibleGradeSet object to be saved
     * @return the saved version of the PossibleGradeSet object
     */
    @Transactional
    public PossibleGradeSet createFromDto(PossibleGradeSetDto possibleGradeSet) {
        if (possibleGradeSet == null) {
            throw new InvalidDataException("Cannot create possibleGradeSet from null object.")
        }
        PossibleGradeSet possibleGradeSetToSave = new PossibleGradeSet();
        possibleGradeSetToSave.code = possibleGradeSet.code
        possibleGradeSetToSave.description = possibleGradeSet.description
        possibleGradeSetToSave.grades = possibleGradeSet.grades.collect {
            return possibleGradeService.createFromDto(it)
        }
        return save(possibleGradeSetToSave)
    }
    
    /**
     * This service method is used to update an PossibleGradeSet object in the database from a partial or complete PossibleGradeSet object.
     *
     * @param possibleGradeSet the partial or complete PossibleGradeSet object to be saved
     * @return the saved version of the PossibleGradeSet object
     */
    @Transactional
    public PossibleGradeSet updateFromDto(PossibleGradeSetDto possibleGradeSet) {
        if (possibleGradeSet == null) {
            throw new InvalidDataException("Cannot update possibleGradeSet from null object.")
        }
        PossibleGradeSet possibleGradeSetToSave = findById(possibleGradeSet.id);
        possibleGradeSetToSave.code = possibleGradeSet.code
        possibleGradeSetToSave.description = possibleGradeSet.description
        if (!possibleGradeSet.grades.empty) {
            possibleGradeSetToSave.grades = possibleGradeSet.grades.collect {
                if (it.id != null) {
                    return possibleGradeService.updateFromDto(it)
                } else {
                    return possibleGradeService.createFromDto(it)
                }
            }
        }
        return save(possibleGradeSetToSave)
    }
    
    /**
     * Saves a list of PossibleGradeSet objects to the database
     *
     * @param possibleGradeSets a list of PossibleGradeSets to be saved to the database
     * @return the list of save PossibleGradeSet objects
     */
    @Transactional
    public List<PossibleGradeSet> savePossibleGradeSets(List<PossibleGradeSet> possibleGradeSets) {
        return possibleGradeSets.collect { possibleGradeSet -> save(possibleGradeSet) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. PossibleGradeSet should not be deleted.
     */
    @Override
    public void delete(PossibleGradeSet obj) {
        throw new InvalidOperationException("PossibleGradeSet should not be deleted")
    }
}
