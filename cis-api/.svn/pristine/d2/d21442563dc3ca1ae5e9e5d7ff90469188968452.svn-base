package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.learning_support.LearningSupportCost
import uk.ac.reigate.dto.LearningSupportCostDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.LearningSupportCostRepository
import uk.ac.reigate.services.student.StudentService

@Service
class LearningSupportCostService implements ICoreDataService<LearningSupportCost, Integer>, IDtoCreateUpdateService<LearningSupportCostDto, LearningSupportCost>{
    
    @Autowired
    LearningSupportCostRepository learningSupportCostRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final LearningSupportCostCategoryService learningSupportCostCategoryService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default NoArgs constructor
     */
    LearningSupportCostService() {}
    
    /**
     * Autowired Constructor
     *
     * @param learningSupportCostRepository
     */
    LearningSupportCostService(LearningSupportCostRepository learningSupportCostRepository,StudentService studentService, LearningSupportCostCategoryService learningSupportCostCategoryService, StaffService staffService) {
        this.learningSupportCostRepository = learningSupportCostRepository
        this.studentService = studentService;
        this.learningSupportCostCategoryService = learningSupportCostCategoryService;
        this.staffService = staffService;
    }
    
    /**
     * Find an individual learningSupportCost using the learningSupportCosts ID fields
     *
     * @param id the ID fields to search for
     * @return the LearningSupportCost object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LearningSupportCost findById(Integer id) {
        return learningSupportCostRepository.findById(id).orElse(null)
    }
    
    @Transactional(readOnly = true)
    List<LearningSupportCost>  findByStudentId(Integer studentId) {
        return learningSupportCostRepository.findByStudent_Id(studentId);
    }
    
    /**
     * Find a single page of LearningSupportCost objects
     * @return a SearchResult set with the list of LearningSupportCosts
     */
    @Override
    @Transactional(readOnly = true)
    List<LearningSupportCost> findAll() {
        return learningSupportCostRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete LearningSupportCost object in the database
     *
     * @param learningSupportCost the new LearningSupportCost object to be saved
     * @return the saved version of the LearningSupportCost object
     */
    @Override
    @Transactional
    public LearningSupportCost save(LearningSupportCost learningSupportCost) {
        return learningSupportCostRepository.save(learningSupportCost)
    }
    
    /**
     * This service method is used to create a LearningSupportCost object in the database from a partial or complete LearningSupportCost object.
     *
     * @param learningSupportCost the partial or complete LearningSupportCost object to be saved
     * @return the saved version of the LearningSupportCost object
     */
    @Transactional
    public LearningSupportCost createFromDto(LearningSupportCostDto learningSupportCostDto) {
        if (learningSupportCostDto == null) {
            throw new InvalidDataException("Cannot create learningSupportCostDto from null object.")
        }
        LearningSupportCost learningSupportCost = new LearningSupportCost()
        if (learningSupportCostDto.studentId != null) {
            learningSupportCost.student = studentService.findById(learningSupportCostDto.studentId)
        }
        learningSupportCost.startDate = learningSupportCostDto.startDate
        learningSupportCost.endDate = learningSupportCostDto.endDate
        learningSupportCost.hoursPerWeek = learningSupportCostDto.hoursPerWeek
        learningSupportCost.weeks = learningSupportCostDto.weeks
        learningSupportCost.rate = learningSupportCostDto.rate
        if (learningSupportCostDto.costCategoryId != null) {
            learningSupportCost.costCategory = learningSupportCostCategoryService.findById(learningSupportCostDto.costCategoryId)
        }
        learningSupportCost.description = learningSupportCostDto.description
        learningSupportCost.periodDescription = learningSupportCostDto.periodDescription
        if (learningSupportCostDto.staffId != null) {
            learningSupportCost.staff = staffService.findById(learningSupportCostDto.staffId)
        }
        return save(learningSupportCost)
    }
    
    /**
     * This service method is used to update a LearningSupportCost object in the database from a partial or complete LearningSupportCost object.
     *
     * @param learningSupportCost the partial or complete LearningSupportCost object to be saved
     * @return the saved version of the LearningSupportCost object
     */
    @Transactional
    public LearningSupportCost updateFromDto(LearningSupportCostDto learningSupportCostDto) {
        if (learningSupportCostDto == null) {
            throw new InvalidDataException("Cannot update learningSupportCostCategoryDto from null object.")
        }
        if(learningSupportCostDto.id ==  null) {
            throw new InvalidDataException("Cannot update learningSupportCostCategoryDto from null Id.")
        }
        LearningSupportCost learningSupportCost = findById(learningSupportCostDto.id)
        if (learningSupportCostDto.studentId != null) {
            learningSupportCost.student = studentService.findById(learningSupportCostDto.studentId)
        }
        if (learningSupportCostDto.costCategoryId != null) {
            learningSupportCost.costCategory = learningSupportCostCategoryService.findById(learningSupportCostDto.costCategoryId)
        }
        if (learningSupportCostDto.staffId != null) {
            learningSupportCost.staff = staffService.findById(learningSupportCostDto.staffId)
        }
        learningSupportCost.startDate = learningSupportCostDto.startDate
        learningSupportCost.endDate = learningSupportCostDto.endDate
        learningSupportCost.hoursPerWeek = learningSupportCostDto.hoursPerWeek
        learningSupportCost.weeks = learningSupportCostDto.weeks
        learningSupportCost.rate = learningSupportCostDto.rate
        learningSupportCost.description = learningSupportCostDto.description
        learningSupportCost.periodDescription = learningSupportCostDto.periodDescription
        return save(learningSupportCost)
    }
    
    /**
     * Saves a list of LearningSupportCost objects to the database
     *
     * @param learningSupportCosts a list of LearningSupportCosts to be saved to the database
     * @return the list of save LearningSupportCost objects
     */
    @Transactional
    public List<LearningSupportCost> saveLearningSupportCosts(List<LearningSupportCost> learningSupportCosts) {
        return learningSupportCosts.collect { learningSupportCost -> save(learningSupportCost) };
    }
    /**
     * This methods throws an InvalidOperationException when called. LearningSupportCost should not be deleted.
     */
    @Override
    public void delete(LearningSupportCost obj) {
        throw new InvalidOperationException("LearningSupportCost should not be deleted")
    }
}
