package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentVolunteeringLog
import uk.ac.reigate.dto.StudentVolunteeringLogDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentVolunteeringLogRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.lookup.StudentRoleService
import uk.ac.reigate.services.lookup.VolunteeringExperienceService
import uk.ac.reigate.services.lookup.VolunteeringTypeService


@Service
class StudentVolunteeringLogService implements
ICoreDataService<StudentVolunteeringLog, Integer>,
IDtoCreateUpdateService<StudentVolunteeringLogDto, StudentVolunteeringLog> {
    
    @Autowired
    StudentVolunteeringLogRepository studentVolunteeringLogRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final VolunteeringTypeService volunteeringTypeService;
    
    @Autowired
    private final VolunteeringExperienceService volunteeringExperienceService;
    
    @Autowired
    private final StudentRoleService studentRoleService
    
    /**
     * Default No Args constructor
     */
    StudentVolunteeringLogService() {}
    
    StudentVolunteeringLogService(StudentVolunteeringLogRepository studentVolunteeringLogRepository, StudentService studentService, VolunteeringTypeService volunteeringTypeService, VolunteeringExperienceService volunteeringExperienceService, StudentRoleService studentRoleService) {
        super();
        this.studentVolunteeringLogRepository = studentVolunteeringLogRepository
        this.studentService = studentService
        this.volunteeringTypeService = volunteeringTypeService
        this.volunteeringExperienceService = volunteeringExperienceService
        this.studentRoleService = studentRoleService
    }
    
    /**
     * This methods is used to retrieve an instance of a StudentCareerRecord as specified by the supplied id.
     * 
     * @param id the ID to use for the retrieval.
     * @return an instance of the StudentCareerRecord matching the supplied ID.
     */
    @Transactional(readOnly = true)
    StudentVolunteeringLog findById(Integer id) {
        return studentVolunteeringLogRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to retrieve all instances of StudentVolunteeringLog.
     *
     * @return a List of all StudentVolunteeringLog data objects.
     */
    @Transactional(readOnly = true)
    List<StudentVolunteeringLog> findAll() {
        return studentVolunteeringLogRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentVolunteeringLog object in the database
     *
     * @param studentVolunteeringLog the new StudentVolunteeringLog object to be saved
     * @return the saved version of the StudentVolunteeringLog object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Careers')")
    @Override
    @Transactional
    public StudentVolunteeringLog save(StudentVolunteeringLog studentVolunteeringLog) {
        return studentVolunteeringLogRepository.save(studentVolunteeringLog)
    }
    
    /**
     * This method is used to delete a StudentVolunteeringLog data object from the database
     *
     * @param studentVolunteeringLog the StudentVolunteeringLog object to be deleted
     *
     */
    @Override
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('Office Administration', 'Careers')")
    public void delete(StudentVolunteeringLog studentVolunteeringLog) {
        throw new InvalidOperationException("StudentVolunteeringLog should not be deleted")
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentVolunteeringLogDto
     * @param StudentVolunteeringLogDto
     * @return
     */
    @Transactional
    public StudentVolunteeringLog createFromDto(StudentVolunteeringLogDto studentVolunteeringLogDto) {
        if (studentVolunteeringLogDto == null) {
            throw new InvalidDataException("Cannot create studentVolunteeringLogDto from null object.")
        }
        StudentVolunteeringLog studentVolunteeringLog = new StudentVolunteeringLog()
        if(studentVolunteeringLogDto.studentId != null) {
            studentVolunteeringLog.student = studentService.findById(studentVolunteeringLogDto.studentId)
        }
        if(studentVolunteeringLogDto.volunteeringTypeId != null) {
            studentVolunteeringLog.volunteeringType = volunteeringTypeService.findById(studentVolunteeringLogDto.volunteeringTypeId)
        }
        if(studentVolunteeringLogDto.volunteeringExperienceId != null) {
            studentVolunteeringLog.volunteeringExperience = volunteeringExperienceService.findById(studentVolunteeringLogDto.volunteeringExperienceId)
        }
        if(studentVolunteeringLogDto.studentRoleId != null) {
            studentVolunteeringLog.studentRole = studentRoleService.findById(studentVolunteeringLogDto.studentRoleId)
        }
        studentVolunteeringLog.date = studentVolunteeringLogDto.date
        studentVolunteeringLog.hours = studentVolunteeringLogDto.hours
        studentVolunteeringLog.note = studentVolunteeringLogDto.note
        return save(studentVolunteeringLog)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentVolunteeringLogDto
     * @param StudentVolunteeringLogDto
     * @return
     */
    @Transactional
    public StudentVolunteeringLog updateFromDto(StudentVolunteeringLogDto studentVolunteeringLogDto) {
        if (studentVolunteeringLogDto == null) {
            throw new InvalidDataException("Cannot update studentVolunteeringLogDto from null object.")
        }
        StudentVolunteeringLog studentVolunteeringLog = findById(studentVolunteeringLogDto.id)
        if(studentVolunteeringLogDto.studentId != null) {
            studentVolunteeringLog.student = studentService.findById(studentVolunteeringLogDto.studentId)
        }
        if(studentVolunteeringLogDto.volunteeringTypeId != null) {
            studentVolunteeringLog.volunteeringType = volunteeringTypeService.findById(studentVolunteeringLogDto.volunteeringTypeId)
        }
        if(studentVolunteeringLogDto.volunteeringExperienceId != null) {
            studentVolunteeringLog.volunteeringExperience = volunteeringExperienceService.findById(studentVolunteeringLogDto.volunteeringExperienceId)
        }
        if(studentVolunteeringLogDto.studentRoleId != null) {
            studentVolunteeringLog.studentRole = studentRoleService.findById(studentVolunteeringLogDto.studentRoleId)
        }
        studentVolunteeringLog.date = studentVolunteeringLogDto.date
        studentVolunteeringLog.hours = studentVolunteeringLogDto.hours
        studentVolunteeringLog.note = studentVolunteeringLogDto.note
        return save(studentVolunteeringLog)
    }
    
    /**
     * This method is used to retrieve a List of StudentCareerRecord data objects for the supplied student.
     * 
     * @param student the Student data object to use for the data retrieval. 
     * @return a List of StudentCareerRecord data objects.
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentVolunteeringLog> findByStudent(Student student){
        List<StudentVolunteeringLog> students = studentVolunteeringLogRepository.findByStudent_Id(student.id)
        return students
    }
    
    /**
     * This method is used to retrieve a List of StudentCareerRecord data objects for the supplied studentId.
     * 
     * @param studentId the ID for the student to retrieve the StudentCareerRecord data objects.
     * @return a List of StudentCareerRecord data objects.
     */
    @Transactional(readOnly = true)
    List<StudentVolunteeringLog> findByStudentId(Integer studentId) {
        return studentVolunteeringLogRepository.findByStudent_Id(studentId);
    }
    
    /**
     * There is no id for StudentVolunteeringLog object , therefore returning null
     *
     */
    public List<StudentVolunteeringLog> findByVolunteeringTypeId(Integer volunteeringTypeId) {
        // TODO: this method requires some explanation
        return studentVolunteeringLogRepository.findByVolunteeringType_Id(volunteeringTypeId);
    }
    
    /**
     * This method is used to delete a StudentCareerRecord by the ID supplied.
     * 
     * @param studentVolunteeringLogId the ID for the StudentCareerRecord data object to delete.
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('Office Administration', 'Careers')")
    public void deleteById(Integer studentVolunteeringLogId){
        studentVolunteeringLogRepository.deleteById(studentVolunteeringLogId)
    }
}
