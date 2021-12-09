package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGrade
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.dto.lookup.PossibleGradeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.LevelRepository
import uk.ac.reigate.repositories.lookup.PossibleGradeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class PossibleGradeService implements ICoreDataService<PossibleGrade, Integer>, IDtoCreateUpdateService<PossibleGradeDto, PossibleGrade>{
    
    @Autowired
    PossibleGradeRepository possibleGradeRepository
    
    @Autowired
    PossibleGradeSetService possibleGradeSetService
    
    /**
     * Default NoArgs constructor
     */
    PossibleGradeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param possibleGradeRepository
     */
    PossibleGradeService(PossibleGradeRepository possibleGradeRepository, PossibleGradeSetService possibleGradeSetService) {
        this.possibleGradeRepository = possibleGradeRepository;
        this.possibleGradeSetService = possibleGradeSetService;
    }
    
    /**
     * Find an individual possibleGrade using the possibleGrades ID fields
     *
     * @param id the ID fields to search for
     * @return the PossibleGrade object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    PossibleGrade findById(Integer id) {
        return possibleGradeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all possibleGrades
     *
     * @return a SearchResult set with the list of PossibleGrades
     */
    @Override
    @Transactional(readOnly = true)
    List<PossibleGrade> findAll() {
        return possibleGradeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete PossibleGrade object in the database
     *
     * @param possibleGrade the new PossibleGrade object to be saved
     * @return the saved version of the PossibleGrade object
     */
    @Override
    @Transactional
    public PossibleGrade save(PossibleGrade possibleGrade) {
        return possibleGradeRepository.save(possibleGrade)
    }
    
    /**
     * Saves a list of PossibleGrade objects to the database
     *
     * @param possibleGrades a list of PossibleGrades to be saved to the database
     * @return the list of save PossibleGrade objects
     */
    @Transactional
    public List<PossibleGrade> savePossibleGrades(List<PossibleGrade> possibleGrades) {
        return possibleGrades.collect { possibleGrade -> save(possibleGrade) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Period should not be deleted.
     */
    @Override
    public void delete(PossibleGrade obj) {
        throw new InvalidOperationException("PossibleGrade should not be deleted")
    }
    
    /**
     * @param possibleGradeSetId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<PossibleGrade> findByPossibleGradeSet(Integer possibleGradeSetId){
        List<PossibleGrade> possibleGrade = possibleGradeRepository.findByGradeSet_Id(possibleGradeSetId)
        return possibleGrade
    }
    
    /**
     * This method is used to create a new possibleGrade data object from the supplied possibleGradeDto
     * @param possibleGradeDto
     * @return
     */
    @Transactional
    public PossibleGrade createFromDto(PossibleGradeDto possibleGradeDto) {
        if (possibleGradeDto == null) {
            throw new InvalidDataException("Cannot create possibleGradeDto from null object.")
        }
        PossibleGrade possibleGrade = new PossibleGrade()
        if(possibleGradeDto.gradeSetId != null) {
            possibleGrade.gradeSet = possibleGradeSetService.findById(possibleGradeDto.gradeSetId)
        }
        possibleGrade.code = possibleGradeDto.code
        possibleGrade.description = possibleGradeDto.description
        possibleGrade.grade = possibleGradeDto.grade
        possibleGrade.ucasPoints = possibleGradeDto.ucasPoints
        possibleGrade.useForKeyAssessment = possibleGradeDto.useForKeyAssessment
        possibleGrade.alisPoints = possibleGradeDto.alisPoints
        possibleGrade.alpsPoints = possibleGradeDto.alpsPoints
        return save(possibleGrade)
    }
    
    /**
     * This method is used to update the existing possibleGrade data object from the supplied possibleGradeDto
     * @param possibleGradeDto
     * @return
     */
    @Transactional
    public PossibleGrade updateFromDto(PossibleGradeDto possibleGradeDto) {
        if(possibleGradeDto == null) {
            throw new InvalidDataException("Cannot update possibleGradeDto from null object.")
        }
        PossibleGrade possibleGrade = findById(possibleGradeDto.id)
        if(possibleGradeDto.gradeSetId != null) {
            possibleGrade.gradeSet = possibleGradeSetService.findById(possibleGradeDto.gradeSetId)
        }
        possibleGrade.code = possibleGradeDto.code
        possibleGrade.description = possibleGradeDto.description
        possibleGrade.grade = possibleGradeDto.grade
        possibleGrade.ucasPoints = possibleGradeDto.ucasPoints
        possibleGrade.useForKeyAssessment = possibleGradeDto.useForKeyAssessment
        possibleGrade.alisPoints = possibleGradeDto.alisPoints
        possibleGrade.alpsPoints = possibleGradeDto.alpsPoints
        return save(possibleGrade)
    }
}
