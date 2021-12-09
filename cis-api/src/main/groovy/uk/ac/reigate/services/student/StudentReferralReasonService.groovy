package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentReferralReason
import uk.ac.reigate.dto.StudentReferralReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentReferralReasonRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.ReferralReasonService


@Service
class StudentReferralReasonService implements ICoreDataService<StudentReferralReason, Integer>, IStudentDataService<List<StudentReferralReason>>, IDtoCreateUpdateService<StudentReferralReasonDto, StudentReferralReason> {
    
    @Autowired
    StudentReferralReasonRepository studentReferralReasonRepository
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    ReferralReasonService referralReasonService
    
    
    /**
     * Default No Args constructor
     */
    StudentReferralReasonService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentReferralReasonRepository
     */
    StudentReferralReasonService(StudentReferralReasonRepository studentReferralReasonRepository, StudentService studentService, ReferralReasonService referralReasonService){
        super();
        this.studentReferralReasonRepository = studentReferralReasonRepository;
        this.studentService =  studentService;
        this.referralReasonService = referralReasonService;
    }
    
    /**
     * This method is used to retrieve a StudentReferralReason object using the supplied StudentReferralReasonPk object.
     *
     * @return an instance of the StudentReferralReason object match the supplied ID.
     */
    @Override
    @Transactional(readOnly = true)
    public StudentReferralReason findById(Integer id) {
        return studentReferralReasonRepository.findById(id).orElse(null)
    }
    
    
    /**
     * This method is used to retrieve all the StudnetReferralReason objects. 
     * 
     * @return a List of all StudentReferralReason objects
     */
    @Override
    public List<StudentReferralReason> findAll() {
        return studentReferralReasonRepository.findAll()
    }
    
    
    /**
     * This method is used to save an instance of a StudentReferralReason object to the database.
     *
     * @param studentReferralReason a StudentReferralReason object to persist to the database.
     * @return the saved version of the StudentReferralReason object.
     */
    @Override
    @Transactional
    public StudentReferralReason save(StudentReferralReason studentReferralReason) {
        return studentReferralReasonRepository.save(studentReferralReason)
    }
    
    /**
     * This method is used to delete an instance of a StudentReferralReason from the database.
     *
     * @param studentReferralReasonId the studentReferralReasonId ID to use for the deletion.
     * @return
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer studentReferralReasonId){
        studentReferralReasonRepository.deleteById(studentReferralReasonId)
    }
    
    /**
     * This method is used to retrieve a List of StudentReferralReason object for the supplied Student ID.
     * 
     * @param studentId the Student ID to use for the search.
     * @return a List of StudentReferralReason objects.
     */
    public List<StudentReferralReason> getByStudentId(Integer studentId){
        return studentReferralReasonRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This method is used to retrieve a List of StudentReferralReason object for the supplied Student.
     *
     * @param student the Student to use for the search.
     * @return a List of StudentReferralReason objects.
     */
    public List<StudentReferralReason> getByStudent(Student student) {
        return studentReferralReasonRepository.findByStudent(student)
    }
    
    /**
     * This method is used to create a new StudentReferralReason data object from the supplied StudentReferralReasonDto.
     *
     * @param studentReferralReasonDto the DTO to use for the creation
     * @return the newly create StudentReferralReason
     */
    public StudentReferralReason createFromDto(StudentReferralReasonDto studentReferralReasonDto) {
        if(studentReferralReasonDto == null) {
            throw new InvalidDataException("Cannot create studentReferralReasonDto from null object.")
        }
        StudentReferralReason studentReferralReason = new StudentReferralReason()
        if(studentReferralReasonDto.studentId != null) {
            studentReferralReason.student = studentService.findById(studentReferralReasonDto.studentId)
        }
        if(studentReferralReasonDto.referralReasonId != null) {
            studentReferralReason.referralReason = referralReasonService.findById(studentReferralReasonDto.referralReasonId)
        }
        studentReferralReason.primary = studentReferralReasonDto.primary
        return save(studentReferralReason)
    }
    
    /**
     * This method is used to update a StudentReferralReason based on a StudentReferralReasonDto
     *
     * @param studentReferralReasonDto the DTO object to use for the update
     * @return the saved StudentReferralReason object
     */
    public StudentReferralReason updateFromDto(StudentReferralReasonDto studentReferralReasonDto) {
        if(studentReferralReasonDto == null) {
            throw new InvalidDataException("Cannot update studentReferralReasonDto from null object.")
        }
        StudentReferralReason studentReferralReason = findById(studentReferralReasonDto.id)
        if(studentReferralReasonDto.studentId != null) {
            studentReferralReason.student = studentService.findById(studentReferralReasonDto.studentId)
        }
        if(studentReferralReasonDto.referralReasonId != null) {
            studentReferralReason.referralReason = referralReasonService.findById(studentReferralReasonDto.referralReasonId)
        }
        studentReferralReason.primary = studentReferralReasonDto.primary
        return save(studentReferralReason)
    }
    
    /**
     * This method is used to delete a StudentReferralReason by StudentReferralReason object.
     */
    @Override
    public void delete(StudentReferralReason obj) {
        studentReferralReasonRepository.delete(obj)
    }
}
