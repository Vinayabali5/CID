package uk.ac.reigate.services.risk_assessment

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.RiskLevel
import uk.ac.reigate.domain.risk_assessment.StudentRiskLevel
import uk.ac.reigate.dto.risk_assessment.StudentRiskLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.StudentRiskLevelRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService

@Service
class StudentRiskLevelService implements ICoreDataService<StudentRiskLevel, Integer>, IStudentDataService<List<StudentRiskLevel>>, IDtoCreateUpdateService<StudentRiskLevelDto, StudentRiskLevel>{
    
    @Autowired
    StudentRiskLevelRepository studentRiskLevelRepository
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    StaffService staffService;
    
    @Autowired
    RiskLevelService riskLevelService;
    
    
    /**
     * Default NoArgs constructor
     */
    StudentRiskLevelService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentRiskLevelRepository
     */
    StudentRiskLevelService(StudentRiskLevelRepository studentRiskLevelRepository, StudentService studentService, StaffService staffService, RiskLevelService riskLevelService) {
        super();
        this.studentRiskLevelRepository = studentRiskLevelRepository;
        this.studentService = studentService;
        this.staffService = staffService;
        this.riskLevelService = riskLevelService;
    }
    
    /**
     * This method is used to find an individual StudentRiskLevel using the StudentRiskLevel ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentRiskLevel object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentRiskLevel findById(Integer id) {
        return studentRiskLevelRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to find all StudentRiskLevel objects
     * 
     * @return a List of StudentRiskLevels
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentRiskLevel> findAll() {
        return studentRiskLevelRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentRiskLevel object in the database
     *
     * @param studentRiskLevel the new StudentRiskLevel object to be saved
     * @return the saved version of the StudentRiskLevel object
     */
    @Override
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Staff')")
    public StudentRiskLevel save(StudentRiskLevel studentRiskLevel) {
        return studentRiskLevelRepository.save(studentRiskLevel)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StudentRiskLevel should not be deleted.
     */
    @Override
    public void delete(StudentRiskLevel obj) {
        throw new InvalidOperationException("StudentRiskLevel should not be deleted");
        
    }
    
    /** 
     * This method is used to retrieve a list of StudentRiskLevel data objects for the supplied studentId.
     * 
     * @param studentId the studentId to use for the retrieval
     * @return List of StudentRiskLevel by studentId
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<StudentRiskLevel> getByStudentId(Integer studentId){
        return studentRiskLevelRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This method is used to retrieve a List of StudentRiskLevel object for the supplied Student.
     *
     * @param student the Student to use for the search.
     * @return a List of StudentReferralReason objects.
     */
    public List<StudentRiskLevel> getByStudent(Student student) {
        return studentRiskLevelRepository.findByStudent(student)
    }
    
    /** 
     * This method is used to retrieve all the students ILP interviews including those that are marked as private.
     * 
     * @param studentId
     * @return List of StudentRiskLevel by studentId
     */
    @PreAuthorize("@securityChecker.checkReader(authentication) and hasRole('ROLE_Pastoral')")
    public  List<StudentRiskLevel> getByStudentAll(Integer studentId){
        return studentRiskLevelRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This method is used to create a new StudentRiskLevel data object from the supplied StudentRiskLevelDto.
     * 
     * @param studentRiskLevelDto the DTO to use for the creation
     * @return the newly create StudentRiskLevel
     */
    public StudentRiskLevel createFromDto(StudentRiskLevelDto studentRiskLevelDto) throws InvalidDataException {
        if (studentRiskLevelDto == null) {
            throw new InvalidDataException("Cannot create studentRiskLevel from null object.")
        }
        if (studentRiskLevelDto.studentId == null) {
            throw new InvalidDataException("Cannot create without studentId.")
        }
        StudentRiskLevel studentRiskLevel = new StudentRiskLevel()
        if (studentRiskLevelDto.studentId != null) {
            studentRiskLevel.student = studentService.findById(studentRiskLevelDto.studentId)
        }
        if (studentRiskLevelDto.riskLevelId != null) {
            studentRiskLevel.riskLevel = riskLevelService.findById(studentRiskLevelDto.riskLevelId)
        }
        if (studentRiskLevelDto.staffRequestingId != null) {
            studentRiskLevel.staffRequesting = staffService.findById(studentRiskLevelDto.staffRequestingId)
        }
        studentRiskLevel.dateRequested = studentRiskLevelDto.dateRequested
        studentRiskLevel.confidential = studentRiskLevelDto.confidential
        studentRiskLevel.evidence = studentRiskLevelDto.evidence
        studentRiskLevel.riskAssessmentRequired = studentRiskLevelDto.riskAssessmentRequired
        studentRiskLevel.safetyPlanRequired = studentRiskLevelDto.safetyPlanRequired
        studentRiskLevel.dateForReview = studentRiskLevelDto.dateForReview
        studentRiskLevel.riskNotes = studentRiskLevelDto.riskNotes
        return save(studentRiskLevel)
    }
    
    /**
     * This method is used to update an StudentRiskLevel based on a StudentRiskLevelDto
     * 
     * @param studentRiskLevelDto the DTO object to use for the update
     * @return the saved StudentRiskLevel object
     */
    public  StudentRiskLevel updateFromDto(StudentRiskLevelDto studentRiskLevelDto) {
        if (studentRiskLevelDto == null) {
            throw new InvalidDataException("Cannot update studentRiskLevel from null object.")
        }
        StudentRiskLevel studentRiskLevel = findById(studentRiskLevelDto.id)
        
        if (studentRiskLevelDto.studentId != null) {
            studentRiskLevel.student = studentService.findById(studentRiskLevelDto.studentId)
        }
        if (studentRiskLevelDto.riskLevelId != null) {
            studentRiskLevel.riskLevel = riskLevelService.findById(studentRiskLevelDto.riskLevelId)
        }
        if (studentRiskLevelDto.staffRequestingId != null) {
            studentRiskLevel.staffRequesting = staffService.findById(studentRiskLevelDto.staffRequestingId)
        }
        studentRiskLevel.dateRequested = studentRiskLevelDto.dateRequested
        studentRiskLevel.confidential = studentRiskLevelDto.confidential
        studentRiskLevel.evidence = studentRiskLevelDto.evidence
        studentRiskLevel.riskAssessmentRequired = studentRiskLevelDto.riskAssessmentRequired
        studentRiskLevel.safetyPlanRequired = studentRiskLevelDto.safetyPlanRequired
        studentRiskLevel.dateForReview = studentRiskLevelDto.dateForReview
        studentRiskLevel.riskNotes = studentRiskLevelDto.riskNotes
        return save(studentRiskLevel)
    }
    
    /**
     * This service method is used to delete a complete StudentRiskLevel object in the database
     *
     * @param studentRiskLevelId the object to be deleted
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer studentRiskLevelId){
        studentRiskLevelRepository.deleteById(studentRiskLevelId)
    }
    
}
