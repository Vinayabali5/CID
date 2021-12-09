package uk.ac.reigate.services.risk_assessment

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.risk_assessment.StudentRiskAssessment
import uk.ac.reigate.dto.risk_assessment.StudentRiskAssessmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.StudentRiskAssessmentRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService


@Service
class StudentRiskAssessmentService implements ICoreDataService<StudentRiskAssessment, Integer>{
    
    @Autowired
    StudentRiskAssessmentRepository studentRiskAssessmentRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default No Args constructor
     */
    StudentRiskAssessmentService() {}
    
    StudentRiskAssessmentService(StudentRiskAssessmentRepository studentRiskAssessmentRepository, StudentService studentService, StaffService staffService) {
        super();
        this.studentRiskAssessmentRepository = studentRiskAssessmentRepository
        this.studentService = studentService;
        this.staffService = staffService;
    }
    
    
    /**
     * @param studentId
     * @return
     */
    @Transactional(readOnly = true)
    StudentRiskAssessment findStudentRiskAssessment(Integer studentId) {
        return studentRiskAssessmentRepository.findByStudent_Id(studentId);
    }
    
    @Override
    @Transactional(readOnly = true)
    StudentRiskAssessment findById(Integer id) {
        return studentRiskAssessmentRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all StudentRiskAssessment
     *
     * @return a List of StudentRiskAssessment
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentRiskAssessment> findAll() {
        return studentRiskAssessmentRepository.findAll();
    }
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public StudentRiskAssessment findByStudent(Integer studentId){
        StudentRiskAssessment students = studentRiskAssessmentRepository.findByStudent_Id(studentId)
        return students
    }
    
    /**
     * This service method is used to save a complete StudentRiskAssessment object in the database
     *
     * @param studentRiskAssessment the new StudentRiskAssessment object to be saved
     * @return the saved version of the StudentRiskAssessment object
     */
    @Override
    @Transactional
    public StudentRiskAssessment save(StudentRiskAssessment studentRiskAssessment) {
        return studentRiskAssessmentRepository.save(studentRiskAssessment)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentRiskAssessmentDto
     * @param StudentRiskAssessmentDto
     * @return
     */
    @Transactional
    public StudentRiskAssessment createFromDto(StudentRiskAssessmentDto studentRiskAssessmentDto) {
        if (studentRiskAssessmentDto == null) {
            throw new InvalidDataException("Cannot create studentRiskAssessment from null object.")
        }
        if(studentRiskAssessmentDto.studentId == null) {
            throw new InvalidDataException("Cannot create studentRiskAssessment from null studentId")
        }
        StudentRiskAssessment studentRiskAssessment = new StudentRiskAssessment()
        studentRiskAssessment.student = studentRiskAssessmentDto.studentId != null ? studentService.findById(studentRiskAssessmentDto.studentId) : null
        studentRiskAssessment.riskToStudent = studentRiskAssessmentDto.riskToStudent
        studentRiskAssessment.actionsToMinimiseRisk = studentRiskAssessmentDto.actionsToMinimiseRisk
        studentRiskAssessment.riskToOtherStudents = studentRiskAssessmentDto.riskToOtherStudents
        studentRiskAssessment.riskToStaff = studentRiskAssessmentDto.riskToStaff
        studentRiskAssessment.whoToInform = studentRiskAssessmentDto.whoToInform
        studentRiskAssessment.otherAgenciesInvolved = studentRiskAssessmentDto.otherAgenciesInvolved
        studentRiskAssessment.agencyContactDetails = studentRiskAssessmentDto.agencyContactDetails
        if(studentRiskAssessmentDto.completeByStaffId != null) {
            studentRiskAssessment.completeByStaff = staffService.findById(studentRiskAssessmentDto.completeByStaffId)
        }
        return save(studentRiskAssessment)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentRiskAssessmentDto
     * @param StudentRiskAssessmentDto
     * @return
     */
    @Transactional
    public StudentRiskAssessment updateFromDto(StudentRiskAssessmentDto studentRiskAssessmentDto) {
        if (studentRiskAssessmentDto == null) {
            throw new InvalidDataException("Cannot update studentRiskAssessment from null object.")
        }
        StudentRiskAssessment studentRiskAssessment = findById(studentRiskAssessmentDto.id)
        studentRiskAssessment.student = studentService.findById(studentRiskAssessmentDto.studentId)
        studentRiskAssessment.riskToStudent = studentRiskAssessmentDto.riskToStudent
        studentRiskAssessment.actionsToMinimiseRisk = studentRiskAssessmentDto.actionsToMinimiseRisk
        studentRiskAssessment.riskToOtherStudents = studentRiskAssessmentDto.riskToOtherStudents
        studentRiskAssessment.riskToStaff = studentRiskAssessmentDto.riskToStaff
        studentRiskAssessment.whoToInform = studentRiskAssessmentDto.whoToInform
        studentRiskAssessment.otherAgenciesInvolved = studentRiskAssessmentDto.otherAgenciesInvolved
        studentRiskAssessment.agencyContactDetails = studentRiskAssessmentDto.agencyContactDetails
        studentRiskAssessment.completeByStaff = studentRiskAssessmentDto.completeByStaffId != null ? staffService.findById(studentRiskAssessmentDto.completeByStaffId) : null
        return save(studentRiskAssessment)
    }
    
    /**
     * This service method is used to delete a complete StudentRiskAssessment object in the database
     *
     * @param studentRiskAssessment the  StudentRiskAssessment object to be deleted
     *
     */
    @Override
    public void delete(StudentRiskAssessment obj) {
        throw new InvalidOperationException("StudentRiskAssessment should not be deleted")
    }
}
