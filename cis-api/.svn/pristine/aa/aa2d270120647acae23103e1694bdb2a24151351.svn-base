package uk.ac.reigate.services.risk_assessment

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentSafetyPlan
import uk.ac.reigate.dto.risk_assessment.StudentSafetyPlanDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.StudentSafetyPlanRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService


@Service
class StudentSafetyPlanService implements ICoreDataService<StudentSafetyPlan, Integer>{
    
    @Autowired
    StudentSafetyPlanRepository studentSafetyPlanRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default No Args constructor
     */
    StudentSafetyPlanService() {}
    
    StudentSafetyPlanService(StudentSafetyPlanRepository studentSafetyPlanRepository, StudentService studentService, StaffService staffService) {
        super();
        this.studentSafetyPlanRepository = studentSafetyPlanRepository;
        this.studentService = studentService;
        this.staffService = staffService;
    }
    
    
    /**
     * @param studentId
     * @return
     */
    @Transactional(readOnly = true)
    StudentSafetyPlan findStudentSafetyPlan(Integer studentId) {
        return studentSafetyPlanRepository.findByStudent_Id(studentId);
    }
    
    
    /**
     * Find all StudentSafetyPlan
     *
     * @return a List of StudentSafetyPlan
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentSafetyPlan> findAll() {
        return studentSafetyPlanRepository.findAll();
    }
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public StudentSafetyPlan findByStudent(Integer studentId){
        StudentSafetyPlan students = studentSafetyPlanRepository.findByStudent_Id(studentId)
        return students
    }
    
    /**
     * This service method is used to save a complete StudentSafetyPlan object in the database
     *
     * @param studentSafetyPlan the new StudentSafetyPlan object to be saved
     * @return the saved version of the StudentSafetyPlan object
     */
    @Override
    @Transactional
    public StudentSafetyPlan save(StudentSafetyPlan studentSafetyPlan) {
        return studentSafetyPlanRepository.save(studentSafetyPlan)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentSafetyPlanDto
     * @param StudentSafetyPlanDto
     * @return
     */
    @Transactional
    public StudentSafetyPlan createFromDto(StudentSafetyPlanDto studentSafetyPlanDto) {
        if (studentSafetyPlanDto == null) {
            throw new InvalidDataException("Cannot create studentSafetyPlan from null object.")
        }
        if(studentSafetyPlanDto.studentId == null) {
            throw new InvalidDataException("Cannot create studentSafetyPlan without studentId")
        }
        StudentSafetyPlan studentSafetyPlan = new StudentSafetyPlan()
        studentSafetyPlan.id = studentSafetyPlanDto.studentId
        studentSafetyPlan.student = studentService.findById(studentSafetyPlanDto.studentId)
        studentSafetyPlan.howToReduceRiskAtHome = studentSafetyPlanDto.howToReduceRiskAtHome
        studentSafetyPlan.warningSignsOrTriggers = studentSafetyPlanDto.warningSignsOrTriggers
        studentSafetyPlan.pastActionsToHelp = studentSafetyPlanDto.pastActionsToHelp
        studentSafetyPlan.actionsToCalmAndSoothe = studentSafetyPlanDto.actionsToCalmAndSoothe
        studentSafetyPlan.whatToTellSelf = studentSafetyPlanDto.whatToTellSelf
        studentSafetyPlan.whoWouldbeSaidToFriend = studentSafetyPlanDto.whoWouldbeSaidToFriend
        studentSafetyPlan.whatCouldOthersDo = studentSafetyPlanDto.whatCouldOthersDo
        studentSafetyPlan.whoCanICall = studentSafetyPlanDto.whoCanICall
        studentSafetyPlan.completedWith = studentSafetyPlanDto.completedWithId != null ? staffService.findById(studentSafetyPlanDto.completedWithId) : null
        studentSafetyPlan.dateCompleted = studentSafetyPlanDto.dateCompleted
        return save(studentSafetyPlan)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentSafetyPlanDto
     * @param StudentSafetyPlanDto
     * @return
     */
    @Transactional
    public StudentSafetyPlan updateFromDto(StudentSafetyPlanDto studentSafetyPlanDto) {
        if (studentSafetyPlanDto == null) {
            throw new InvalidDataException("Cannot update studentSafetyPlan from null object.")
        }
        if(studentSafetyPlanDto.studentId == null) {
            throw new InvalidDataException("Cannot update studentSafetyPlan without studentId")
        }
        StudentSafetyPlan studentSafetyPlan = findByStudent(studentSafetyPlanDto.studentId)
        if(studentSafetyPlan == null){
            studentSafetyPlan = new StudentSafetyPlan()
            studentSafetyPlan.student = studentService.findById(studentSafetyPlanDto.studentId)
        }
        studentSafetyPlan.id = studentSafetyPlanDto.studentId
        studentSafetyPlan.howToReduceRiskAtHome = studentSafetyPlanDto.howToReduceRiskAtHome
        studentSafetyPlan.warningSignsOrTriggers = studentSafetyPlanDto.warningSignsOrTriggers
        studentSafetyPlan.pastActionsToHelp = studentSafetyPlanDto.pastActionsToHelp
        studentSafetyPlan.actionsToCalmAndSoothe = studentSafetyPlanDto.actionsToCalmAndSoothe
        studentSafetyPlan.whatToTellSelf = studentSafetyPlanDto.whatToTellSelf
        studentSafetyPlan.whoWouldbeSaidToFriend = studentSafetyPlanDto.whoWouldbeSaidToFriend
        studentSafetyPlan.whatCouldOthersDo = studentSafetyPlanDto.whatCouldOthersDo
        studentSafetyPlan.whoCanICall = studentSafetyPlanDto.whoCanICall
        studentSafetyPlan.dateCompleted = studentSafetyPlanDto.dateCompleted
        studentSafetyPlan.completedWith = studentSafetyPlanDto.completedWithId != null ? staffService.findById(studentSafetyPlanDto.completedWithId) : null
        return save(studentSafetyPlan)
    }
    
    /**
     * This service method is used to delete a complete StudentSafetyPlan object in the database
     *
     * @param studentSafetyPlan the  StudentSafetyPlan object to be deleted
     *
     */
    @Override
    public void delete(StudentSafetyPlan obj) {
        throw new InvalidOperationException("StudentSafetyPlan should not be deleted")
    }
    
    @Override
    public StudentSafetyPlan findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
