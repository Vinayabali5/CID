package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentEntryQualification
import uk.ac.reigate.dto.StudentEntryQualificationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.academic.StudentEntryQualificationRepository
import uk.ac.reigate.services.EntryQualificationService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.exams.ExamBoardService

@Service
class StudentEntryQualificationService implements ICoreDataService<StudentEntryQualification, Integer>, IDtoCreateUpdateService<StudentEntryQualificationDto, StudentEntryQualification>{
    
    @Autowired
    StudentEntryQualificationRepository studentEntryQualificationRepository
    
    @Autowired
    StudentService studentService
    
    @Autowired
    EntryQualificationService entryQualificationService
    
    @Autowired
    ExamBoardService examBoardService
    /**
     * Default NoArgs constructor
     */
    StudentEntryQualificationService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentEntryQualificationRepository
     */
    StudentEntryQualificationService(StudentEntryQualificationRepository studentEntryQualificationRepository, StudentService studentService, EntryQualificationService entryQualificationService, ExamBoardService examBoardService) {
        super();
        this.studentEntryQualificationRepository = studentEntryQualificationRepository;
        this.studentService = studentService;
        this.entryQualificationService = entryQualificationService;
        this.examBoardService = examBoardService;
    }
    
    /**
     * Find an individual StudentEntryQualification using the StudentEntryQualification ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentEntryQualification object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentEntryQualification findById(Integer id) {
        return studentEntryQualificationRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of StudentEntryQualification objects
     * @return a List of StudentEntryQualification
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentEntryQualification> findAll() {
        return studentEntryQualificationRepository.findAll();
    }
    
    
    /**
     * This service method is used to save a complete StudentEntryQualification object in the database
     *
     * @param studentEntryQualification the new StudentEntryQualification object to be saved
     * @return the saved version of the StudentEntryQualification object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Quals on Entry')")
    @Transactional
    public StudentEntryQualification save(StudentEntryQualification studentEntryQualification) {
        return studentEntryQualificationRepository.save(studentEntryQualification)
    }
    
    /**
     * This service method is used to create a StudentEntryQualification object in the database from a partial or complete StudentEntryQualification object.
     *
     * @param studentEntryQualification the partial or complete StudentEntryQualification object to be saved
     * @return the saved version of the StudentEntryQualification object
     */
    @Transactional
    public StudentEntryQualification createFromDto(StudentEntryQualificationDto studentEntryQualification){
        if(studentEntryQualification == null) {
            throw new InvalidDataException("Cannot create studentEntryQualificationDto from null object.")
        }
        StudentEntryQualification studentEntryQualificationToSave = new StudentEntryQualification()
        studentEntryQualificationToSave.student = studentEntryQualification.studentId != null ? studentService.findById(studentEntryQualification.studentId) : null
        studentEntryQualificationToSave.qualification = studentEntryQualification.entryQualificationId != null ? entryQualificationService.findById(studentEntryQualification.entryQualificationId) : null
        studentEntryQualificationToSave.date = studentEntryQualification.date != null ? studentEntryQualification.date : studentEntryQualificationToSave.date
        studentEntryQualificationToSave.grade = studentEntryQualification.grade != null ? studentEntryQualification.grade : studentEntryQualificationToSave.grade
        studentEntryQualificationToSave.checked = studentEntryQualification.checked != null ? studentEntryQualification.checked : studentEntryQualificationToSave.checked
        studentEntryQualificationToSave.examBoard = studentEntryQualification.examBoardId != null ? examBoardService.findById(studentEntryQualification.examBoardId) : null
        return save(studentEntryQualificationToSave)
    }
    
    /**
     * This service method is used to update an StudentEntryQualification object in the database from a partial or complete StudentEntryQualification object.
     *
     * @param studentEntryQualification the partial or complete StudentEntryQualification object to be saved
     * @return the saved version of the StudentEntryQualification object
     */
    @Transactional
    public StudentEntryQualification updateFromDto(StudentEntryQualificationDto studentEntryQualification){
        if(studentEntryQualification == null) {
            throw new InvalidDataException("Cannot update studentEntryQualificationDto from null object.")
        }
        StudentEntryQualification studentEntryQualificationToSave = findById(studentEntryQualification.studentEntryQualificationId)
        studentEntryQualificationToSave.student = studentEntryQualification.studentId != null ? studentService.findById(studentEntryQualification.studentId) : null
        studentEntryQualificationToSave.qualification = studentEntryQualification.entryQualificationId != null ? entryQualificationService.findById(studentEntryQualification.entryQualificationId) : null
        studentEntryQualificationToSave.date = studentEntryQualification.date != null ? studentEntryQualification.date : studentEntryQualificationToSave.date
        studentEntryQualificationToSave.grade = studentEntryQualification.grade != null ? studentEntryQualification.grade : studentEntryQualificationToSave.grade
        studentEntryQualificationToSave.checked = studentEntryQualification.checked != null ? studentEntryQualification.checked : studentEntryQualificationToSave.checked
        studentEntryQualificationToSave.examBoard = studentEntryQualification.examBoardId != null ? examBoardService.findById(studentEntryQualification.examBoardId) : null
        return save(studentEntryQualificationToSave)
    }
    
    /**
     * @param studentEntryQualifications
     * @return
     */
    @Transactional
    public List<StudentEntryQualification> saveStudentEntryQualifications(List<StudentEntryQualification> studentEntryQualifications){
        return studentEntryQualifications.collect { studentEntryQualification -> save( studentEntryQualification )};
    }
    
    
    /**
     * This method is used to retrieve the student entry qualifications that a specific studentId and studentEntryQualificationId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  StudentEntryQualification getByStudentEntryQualifications(Integer studentId, Integer studentEntryQualificationId){
        return studentEntryQualificationRepository.findByStudent_IdAndId(studentId, studentEntryQualificationId);
    }
    
    /**
     * This method is used to retrieve the list of student entry qualifications that a specific studentId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<StudentEntryQualification> getByStudent(Integer studentId){
        return studentEntryQualificationRepository.findByStudent_Id(studentId);
    }
    
    
    /**
     * This service method is used to delete a complete StudentEntryQualification object in the database
     *
     * @param studentEntryQualificationId the object to be deleted   
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer studentEntryQualificationId){
        studentEntryQualificationRepository.deleteById(studentEntryQualificationId)
    }
    
    
    /* (non-Javadoc)
     * @see uk.ac.reigate.services.ICoreDataService#delete(java.lang.Object)
     */
    @Override
    public void delete(StudentEntryQualification studentEntryQualification) {
        // studentEntryQualificationRepository.delete(studentEntryQualification)
    }
}
