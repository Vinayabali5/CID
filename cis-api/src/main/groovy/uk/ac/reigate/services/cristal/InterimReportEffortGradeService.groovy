package uk.ac.reigate.services.cristal

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.cristal.InterimReportEffortGrade
import uk.ac.reigate.dto.cristal.InterimReportEffortGradeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.cristal.InterimReportEffortGradeRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class InterimReportEffortGradeService implements ICoreDataService<InterimReportEffortGrade, Integer>{
    
    @Autowired
    InterimReportEffortGradeRepository interimReportEffortGradeRepository
    
    /**
     * Default NoArgs constructor
     */
    InterimReportEffortGradeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param interimReportEffortGradeRepository
     */
    InterimReportEffortGradeService(InterimReportEffortGradeRepository interimReportEffortGradeRepository) {
        this.interimReportEffortGradeRepository = interimReportEffortGradeRepository;
    }
    
    /**
     * Find an individual interimReportEffortGrade using the interimReportEffortGrades ID fields
     *
     * @param id the ID fields to search for
     * @return the InterimReportEffortGrade object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    InterimReportEffortGrade findById(Integer id) {
        return interimReportEffortGradeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of InterimReportEffortGrade objects
     * @return a List of InterimReportEffortGrades
     */
    @Override
    @Transactional(readOnly = true)
    List<InterimReportEffortGrade> findAll() {
        List<InterimReportEffortGrade> interimReportEffortGrades = interimReportEffortGradeRepository.findAll();
        return interimReportEffortGrades
    }
    
    /**
     * This service method is used to save a complete InterimReportEffortGrade object in the database
     *
     * @param interimReportEffortGrade the new InterimReportEffortGrade object to be saved
     * @return the saved version of the InterimReportEffortGrade object
     */
    @Override
    @Transactional
    public InterimReportEffortGrade save(InterimReportEffortGrade interimReportEffortGrade) {
        return interimReportEffortGradeRepository.save(interimReportEffortGrade)
    }
    
    /**
     * This service method is used to update an InterimReportEffortGrade object in the database from a partial or complete InterimReportEffortGrade object.
     *
     * @param interimReportEffortGrade the partial or complete InterimReportEffortGrade object to be saved
     * @return the saved version of the InterimReportEffortGrade object
     */
    
    @Transactional
    public InterimReportEffortGrade createFromDto(InterimReportEffortGradeDto interimReportEffortGradeDto) {
        if (interimReportEffortGradeDto == null) {
            throw new InvalidDataException("Cannot create interimReportEffortGrade from null object.")
        }
        InterimReportEffortGrade interimReportEffortGrade = new InterimReportEffortGrade()
        interimReportEffortGrade.code = interimReportEffortGradeDto.code
        interimReportEffortGrade.description = interimReportEffortGradeDto.description
        return save(interimReportEffortGrade)
    }
    
    /**
     * This service method is used to update an InterimReportEffortGrade object in the database from a partial or complete InterimReportEffortGrade object.
     *
     * @param interimReportEffortGrade the partial or complete InterimReportEffortGrade object to be saved
     * @return the saved version of the InterimReportEffortGrade object
     */
    
    @Transactional
    public InterimReportEffortGrade updateFromDto(InterimReportEffortGradeDto interimReportEffortGradeDto) {
        if (interimReportEffortGradeDto == null) {
            throw new InvalidDataException("Cannot update interimReportEffortGrade from null object.")
        }
        InterimReportEffortGrade interimReportEffortGrade = findById(interimReportEffortGradeDto.id)
        interimReportEffortGrade.code = interimReportEffortGradeDto.code
        interimReportEffortGrade.description = interimReportEffortGradeDto.description
        return save(interimReportEffortGrade)
    }
    
    /**
     * Saves a list of InterimReportEffortGrade objects to the database
     *
     * @param interimReportEffortGrades a list of InterimReportEffortGrades to be saved to the database
     * @return the list of save InterimReportEffortGrade objects
     */
    
    @Transactional
    public List<InterimReportEffortGrade> saveInterimReportEffortGrades(List<InterimReportEffortGrade> interimReportEffortGrades) {
        return interimReportEffortGrades.collect { interimReportEffortGrade -> save(interimReportEffortGrade) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. InterimReportEffortGrade should not be deleted.
     */
    @Override
    public void delete(InterimReportEffortGrade obj) {
        throw new InvalidOperationException("InterimReportEffortGrade should not be deleted")
        
    }
    
    
    @Transactional(readOnly = true)
    InterimReportEffortGrade findByDescription(String description) {
        return interimReportEffortGradeRepository.findByDescription(description);
    }
    
}
