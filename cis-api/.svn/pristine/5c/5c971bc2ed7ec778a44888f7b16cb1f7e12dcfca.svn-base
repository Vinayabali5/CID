package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.dto.lookup.LevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.lookup.LevelRepository
import uk.ac.reigate.services.lookup.PossibleGradeSetService
import uk.ac.reigate.utils.ValidationUtils

@Service
@RequiredArgsConstructor
class LevelService implements ICoreDataService<Level, Integer>, IDtoCreateUpdateService<LevelDto, Level>{
    
    @Autowired
    LevelRepository levelRepository
    
    @Autowired
    PossibleGradeSetService possibleGradeSetService
    
    /**
     * Default NoArgs constructor
     */
    LevelService() {}
    
    /**
     * Autowired Constructor
     *
     * @param levelRepository
     */
    LevelService(LevelRepository levelRepository, PossibleGradeSetService possibleGradeSetService) {
        super();
        this.levelRepository = levelRepository;
        this.possibleGradeSetService = possibleGradeSetService;
    }
    
    /**
     * Find an individual level using the levels ID fields
     *
     * @param id the ID fields to search for
     * @return the Level object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Level findById(Integer id) {
        return levelRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all levels
     *
     * @return a SearchResult set with the list of Levels
     */
    @Override
    @Transactional(readOnly = true)
    List<Level> findAll() {
        return levelRepository.findAll();
    }
    
    /**
     * Saves a Level object to the database
     *
     * @param level the Level object to save
     * @return the save Level object
     */
    @Override
    @Transactional
    public Level save(Level level) {
        return levelRepository.save(level)
    }
    
    /**
     * This service method is used to update an Level object in the database from a partial or complete Level object.
     *
     * @param level the partial or complete Level object to be saved
     * @return the saved version of the Level object
     */
    @Transactional
    public Level createFromDto(LevelDto level) {
        if (level == null) {
            throw new InvalidDataException("Cannot create Level from null object.")
        }
        Level levelToSave = new Level()
        levelToSave.code = level.code
        levelToSave.description = level.description
        if(level.possibleGradeSetId != null) {
            levelToSave.possibleGradeSet = possibleGradeSetService.findById(level.possibleGradeSetId)
        }
        levelToSave.progressionTo = level.progressionTo
        levelToSave.alisQualCode = level.alisQualCode
        levelToSave.academic = level.academic
        levelToSave.coreAimPriority = level.coreAimPriority
        levelToSave.sarInclude = level.sarInclude
        levelToSave.rqfLevel = level.rqfLevel
        levelToSave.qualificationFramework = level.qualificationFramework
        levelToSave.dfeQualName = level.dfeQualName
        levelToSave.inUse = level.inUse
        return save(levelToSave)
    }
    
    /**
     * This service method is used to update an Level object in the database from a partial or complete Level object.
     *
     * @param level the partial or complete Level object to be saved
     * @return the saved version of the Level object
     */
    @Transactional
    public Level updateFromDto(LevelDto levelDto) {
        if (levelDto == null) {
            throw new InvalidDataException("Cannot update Level from null object.")
        }
        if(levelDto.id == null) {
            throw new InvalidDataException("Cannot create Level from null Id.")
        }
        Level level = findById(levelDto.id)
        if(levelDto.possibleGradeSetId != null) {
            level.possibleGradeSet = possibleGradeSetService.findById(levelDto.possibleGradeSetId)
        }
        level.code = levelDto.code
        level.description = levelDto.description
        level.progressionTo = levelDto.progressionTo
        level.alisQualCode = levelDto.alisQualCode
        level.academic = levelDto.academic
        level.coreAimPriority = levelDto.coreAimPriority
        level.sarInclude = levelDto.sarInclude
        level.rqfLevel = levelDto.rqfLevel
        level.qualificationFramework = levelDto.qualificationFramework
        level.dfeQualName = levelDto.dfeQualName
        level.inUse = levelDto.inUse
        return save(level)
    }
    
    /**
     * Saves a list of Level objects to the database
     *
     * @param levels a list of Levels to be saved to the database
     * @return the list of save Level objects
     */
    @Transactional
    public List<Level> saveLevels(List<Level> levels) {
        return levels.collect { level -> save(level) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Level should not be deleted.
     */
    @Override
    public void delete(Level obj) {
        throw new InvalidOperationException("Level should not be deleted")
    }
}
