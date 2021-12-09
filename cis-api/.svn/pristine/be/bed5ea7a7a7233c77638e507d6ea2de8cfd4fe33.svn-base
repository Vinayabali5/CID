package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.LearningSupportVisit
import uk.ac.reigate.dto.LearningSupportVisitDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.LearningSupportVisitRepository
import uk.ac.reigate.services.student.StudentService

@Service
class LearningSupportVisitService implements ICoreDataService<LearningSupportVisit, Integer>, IDtoCreateUpdateService<LearningSupportVisitDto, LearningSupportVisit>{
    
    @Autowired
    LearningSupportVisitRepository learningSupportVisitRepository
    
    @Autowired
    private final StudentService studentService;
    
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default NoArgs constructor
     */
    LearningSupportVisitService() {}
    
    /**
     * Autowired Constructor
     *
     * @param learningSupportVisitRepository
     */
    LearningSupportVisitService(LearningSupportVisitRepository learningSupportVisitRepository, StudentService studentService, StaffService staffService) {
        this.learningSupportVisitRepository = learningSupportVisitRepository;
        this.studentService = studentService;
        this.staffService = staffService;
    }
    
    /**
     * Find an individual learningSupportVisit using the learningSupportVisits ID fields
     *
     * @param id the ID fields to search for
     * @return the LearningSupportVisit object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LearningSupportVisit findById(Integer id) {
        return learningSupportVisitRepository.findById(id).orElse(null)
    }
    
    @Transactional(readOnly = true)
    List<LearningSupportVisit> findByStudentId(Integer studentId) {
        return learningSupportVisitRepository.findByStudent_Id(studentId);
    }
    
    /**
     * Find a single page of LearningSupportVisit objects
     * @return a SearchResult set with the list of LearningSupportVisits
     */
    @Override
    @Transactional(readOnly = true)
    List<LearningSupportVisit> findAll() {
        return learningSupportVisitRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete LearningSupportVisit object in the database
     *
     * @param learningSupportVisit the new LearningSupportVisit object to be saved
     * @return the saved version of the LearningSupportVisit object
     */
    @Override
    @Transactional
    public LearningSupportVisit save(LearningSupportVisit learningSupportVisit) {
        return learningSupportVisitRepository.save(learningSupportVisit)
    }
    
    /**
     * This service method is used to create a LearningSupportVisit object in the database from a partial or complete LearningSupportVisit object.
     *
     * @param learningSupportCost the partial or complete LearningSupportVisit object to be saved
     * @return the saved version of the LearningSupportCost object
     */
    @Transactional
    public LearningSupportVisit createFromDto(LearningSupportVisitDto learningSupportVisitDto) {
        if (learningSupportVisitDto == null) {
            throw new InvalidDataException("Cannot create learningSupportVisitDto from null object.")
        }
        LearningSupportVisit learningSupportVisit = new LearningSupportVisit()
        if (learningSupportVisitDto.studentId != null) {
            learningSupportVisit.student = studentService.findById(learningSupportVisitDto.studentId)
        }
        learningSupportVisit.date = learningSupportVisitDto.date
        learningSupportVisit.duration = learningSupportVisitDto.duration
        learningSupportVisit.details = learningSupportVisitDto.details
        learningSupportVisit.time = learningSupportVisitDto.time
        return save(learningSupportVisit)
    }
    
    /**
     * This service method is used to update a LearningSupportVisit object in the database from a partial or complete LearningSupportVisit object.
     *
     * @param learningSupportCost the partial or complete LearningSupportVisit object to be saved
     * @return the saved version of the LearningSupportCost object
     */
    @Transactional
    public LearningSupportVisit updateFromDto(LearningSupportVisitDto learningSupportVisitDto) {
        if (learningSupportVisitDto == null) {
            throw new InvalidDataException("Cannot update learningSupportVisitDto from null object.")
        }
        if(learningSupportVisitDto.id == null) {
            throw new InvalidDataException("Cannot update learningSupportVisitDto from null Id.")
        }
        LearningSupportVisit learningSupportVisit = findById(learningSupportVisitDto.id)
        if (learningSupportVisitDto.studentId != null) {
            learningSupportVisit.student = studentService.findById(learningSupportVisitDto.studentId)
        }
        learningSupportVisit.date = learningSupportVisitDto.date
        learningSupportVisit.duration = learningSupportVisitDto.duration
        learningSupportVisit.details = learningSupportVisitDto.details
        learningSupportVisit.time = learningSupportVisitDto.time
        return save(learningSupportVisit)
    }
    
    /**
     * Saves a list of LearningSupportVisit objects to the database
     *
     * @param learningSupportVisits a list of LearningSupportVisits to be saved to the database
     * @return the list of save LearningSupportVisit objects
     */
    @Transactional
    public List<LearningSupportVisit> saveLearningSupportVisits(List<LearningSupportVisit> learningSupportVisits) {
        return learningSupportVisits.collect { learningSupportVisit -> save(learningSupportVisit) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. LearningSupportVisit should not be deleted.
     */
    @Override
    public void delete(LearningSupportVisit obj) {
        throw new InvalidOperationException("LearningSupportVisit should not be deleted")
    }
}
