package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentCareersRecord
import uk.ac.reigate.dto.careers.StudentCareersRecordDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentCareersRecordRepository
import uk.ac.reigate.services.student.StudentService


@Service
class StudentCareersRecordService implements
ICoreDataService<StudentCareersRecord, Integer>,
IDtoCreateUpdateService<StudentCareersRecordDto, StudentCareersRecord> {
    //, IStudentDataService<List<StudentCareersRecord>> {
    
    @Autowired
    StudentCareersRecordRepository studentCareersRecordRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final CareersRecordTypeService careersRecordTypeService;
    
    @Autowired
    PersonService personService
    
    /**
     * Default No Args constructor
     */
    StudentCareersRecordService() {}
    
    StudentCareersRecordService(StudentCareersRecordRepository studentCareersRecordRepository, StudentService studentService, CareersRecordTypeService careersRecordTypeService) {
        super();
        this.studentCareersRecordRepository = studentCareersRecordRepository
        this.studentService = studentService
        this.careersRecordTypeService = careersRecordTypeService
    }
    
    /**
     * This methods is used to retrieve an instance of a StudentCareerRecord as specified by the supplied id.
     * 
     * @param id the ID to use for the retrieval.
     * @return an instance of the StudentCareerRecord matching the supplied ID.
     */
    @Transactional(readOnly = true)
    StudentCareersRecord findById(Integer id) {
        return studentCareersRecordRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to retrieve all instances of StudentCareersRecord.
     *
     * @return a List of all StudentCareersRecord data objects.
     */
    @Transactional(readOnly = true)
    List<StudentCareersRecord> findAll() {
        return studentCareersRecordRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentCareersRecord object in the database
     *
     * @param studentCareersRecord the new StudentCareersRecord object to be saved
     * @return the saved version of the StudentCareersRecord object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Careers')")
    @Override
    @Transactional
    public StudentCareersRecord save(StudentCareersRecord studentCareersRecord) {
        return studentCareersRecordRepository.save(studentCareersRecord)
    }
    
    /**
     * This method is used to delete a StudentCareersRecord data object from the database
     *
     * @param studentCareersRecord the StudentCareersRecord object to be deleted
     *
     */
    @Override
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('Office Administration', 'Careers')")
    public void delete(StudentCareersRecord studentCareersRecord) {
        throw new InvalidOperationException("StudentCareersRecord should not be deleted")
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentCareersRecordDto
     * @param StudentCareersRecordDto
     * @return
     */
    @Transactional
    public StudentCareersRecord createFromDto(StudentCareersRecordDto studentCareersRecordDto) {
        if (studentCareersRecordDto == null) {
            throw new InvalidDataException("Cannot create studentCareersRecordDto from null object.")
        }
        StudentCareersRecord studentCareersRecord = new StudentCareersRecord()
        if(studentCareersRecordDto.studentId != null) {
            studentCareersRecord.student = studentService.findById(studentCareersRecordDto.studentId)
        }
        if(studentCareersRecordDto.careersRecordTypeId != null) {
            studentCareersRecord.careersRecordType = careersRecordTypeService.findById(studentCareersRecordDto.careersRecordTypeId)
        }
        studentCareersRecord.startDate = studentCareersRecordDto.startDate
        studentCareersRecord.endDate = studentCareersRecordDto.endDate
        studentCareersRecord.note = studentCareersRecordDto.note
        studentCareersRecord.employerInstitution = studentCareersRecordDto.employerInstitution
        studentCareersRecord.organiser = studentCareersRecordDto.organiser
        return save(studentCareersRecord)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentCareersRecordDto
     * @param StudentCareersRecordDto
     * @return
     */
    @Transactional
    public StudentCareersRecord updateFromDto(StudentCareersRecordDto studentCareersRecordDto) {
        if (studentCareersRecordDto == null) {
            throw new InvalidDataException("Cannot update studentCareersRecordDto from null object.")
        }
        StudentCareersRecord studentCareersRecord = findById(studentCareersRecordDto.id)
        if(studentCareersRecordDto.studentId != null) {
            studentCareersRecord.student = studentService.findById(studentCareersRecordDto.studentId)
        }
        studentCareersRecord.startDate = studentCareersRecordDto.startDate
        studentCareersRecord.endDate = studentCareersRecordDto.endDate
        studentCareersRecord.note = studentCareersRecordDto.note
        studentCareersRecord.employerInstitution = studentCareersRecordDto.employerInstitution
        studentCareersRecord.organiser = studentCareersRecordDto.organiser
        if(studentCareersRecordDto.careersRecordTypeId != null) {
            studentCareersRecord.careersRecordType = careersRecordTypeService.findById(studentCareersRecordDto.careersRecordTypeId)
        }
        return save(studentCareersRecord)
    }
    
    /**
     * This method is used to retrieve a List of StudentCareerRecord data objects for the supplied student.
     * 
     * @param student the Student data object to use for the data retrieval. 
     * @return a List of StudentCareerRecord data objects.
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentCareersRecord> findByStudent(Student student){
        List<StudentCareersRecord> students = studentCareersRecordRepository.findByStudent_Id(student.id)
        return students
    }
    
    /**
     * This method is used to retrieve a List of StudentCareerRecord data objects for the supplied studentId.
     * 
     * @param studentId the ID for the student to retrieve the StudentCareerRecord data objects.
     * @return a List of StudentCareerRecord data objects.
     */
    @Transactional(readOnly = true)
    List<StudentCareersRecord> findByStudentId(Integer studentId) {
        return studentCareersRecordRepository.findByStudent_Id(studentId);
    }
    
    /**
     * There is no id for StudentCareersRecord object , therefore returning null
     *
     */
    public List<StudentCareersRecord> findByCareersRecordTypeId(Integer careersRecordTypeId) {
        // TODO: this method requires some explanation
        return studentCareersRecordRepository.findByCareersRecordType_Id(careersRecordTypeId);
    }
    
    /**
     * This method is used to delete a StudentCareerRecord by the ID supplied.
     * 
     * @param studentCareersRecordId the ID for the StudentCareerRecord data object to delete.
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('Office Administration', 'Careers')")
    public void deleteById(Integer studentCareersRecordId){
        studentCareersRecordRepository.deleteById(studentCareersRecordId)
    }
    
}
