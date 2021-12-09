package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentLearningSupport
import uk.ac.reigate.domain.learning_support.SupportType
import uk.ac.reigate.dto.StudentLearningSupportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.StudentLearningSupportRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.lookup.SupportTypeService


@Service
class StudentLearningSupportService implements ICoreDataService<StudentLearningSupport, Integer>{
    
    @Autowired
    StudentLearningSupportRepository studentLearningSupportRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final SupportTypeService supportTypeService;
    
    /**
     * Default No Args constructor
     */
    StudentLearningSupportService() {}
    
    StudentLearningSupportService(StudentLearningSupportRepository studentLearningSupportRepository, StudentService studentService, SupportTypeService supportTypeService) {
        super();
        this.studentLearningSupportRepository = studentLearningSupportRepository
        this.studentService = studentService;
        this.supportTypeService = supportTypeService;
    }
    
    
    /**
     * @param studentId
     * @return
     */
    @Transactional(readOnly = true)
    StudentLearningSupport findStudentLearningSupport(Integer studentId) {
        return studentLearningSupportRepository.findByStudent_Id(studentId);
    }
    
    
    /**
     * Find all StudentLearningSupport
     *
     * @return a List of StudentLearningSupport
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentLearningSupport> findAll() {
        return studentLearningSupportRepository.findAll();
    }
    /**
     * There is no id for StudentLearningSupport object , therefore returning null
     *
     */
    public StudentLearningSupport findById(StudentLearningSupport studentLearningSupportPk) {
        return null
    }
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public StudentLearningSupport findByStudent(Integer studentId){
        StudentLearningSupport students = studentLearningSupportRepository.findByStudent_Id(studentId)
        return students
    }
    
    /**
     * This service method is used to save a complete StudentLearningSupport object in the database
     *
     * @param studentLearningSupport the new StudentLearningSupport object to be saved
     * @return the saved version of the StudentLearningSupport object
     */
    @Override
    @Transactional
    public StudentLearningSupport save(StudentLearningSupport studentLearningSupport) {
        return studentLearningSupportRepository.save(studentLearningSupport)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentLearningSupportDto
     * @param StudentLearningSupportDto
     * @return
     */
    @Transactional
    public StudentLearningSupport createFromDto(StudentLearningSupportDto studentLearningSupportDto) {
        if(studentLearningSupportDto.studentId == null) {
            throw new InvalidDataException("Cannot create studentLearningSupportDto from null object.")
        }
        StudentLearningSupport studentLearningSupport = new StudentLearningSupport()
        studentLearningSupport.id = studentLearningSupportDto.studentId
        if(studentLearningSupportDto.studentId) {
            studentLearningSupport.student = studentService.findById(studentLearningSupportDto.studentId)
        }
        if(studentLearningSupportDto.supportTypeId != null) {
            studentLearningSupport.supportType = supportTypeService.findById(studentLearningSupportDto.supportTypeId)
        }
        studentLearningSupport.referralNotes = studentLearningSupportDto.referralNotes
        studentLearningSupport.supportNotes = studentLearningSupportDto.supportNotes
        studentLearningSupport.previousConcession = studentLearningSupportDto.previousConcession
        studentLearningSupport.concessionApplication = studentLearningSupportDto.concessionApplication
        studentLearningSupport.examConcessionApproved = studentLearningSupportDto.examConcessionApproved
        studentLearningSupport.btecConcessionApproved = studentLearningSupportDto.btecConcessionApproved
        studentLearningSupport.fsConcessionApproved = studentLearningSupportDto.fsConcessionApproved
        studentLearningSupport.assessmentDate = studentLearningSupportDto.assessmentDate
        return save(studentLearningSupport)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentLearningSupportDto
     * @param StudentLearningSupportDto
     * @return
     */
    @Transactional
    public StudentLearningSupport updateFromDto(StudentLearningSupportDto studentLearningSupportDto) {
        if(studentLearningSupportDto.studentId == null) {
            throw new InvalidDataException("Cannot update studentLearningSupportDto from null object.")
        }
        StudentLearningSupport studentLearningSupport = findByStudent(studentLearningSupportDto.studentId)
        if(studentLearningSupport == null){
            studentLearningSupport = new StudentLearningSupport()
            studentLearningSupport.student = studentService.findById(studentLearningSupportDto.studentId)
        }
        studentLearningSupport.referralNotes = studentLearningSupportDto.referralNotes
        studentLearningSupport.supportNotes = studentLearningSupportDto.supportNotes
        studentLearningSupport.previousConcession = studentLearningSupportDto.previousConcession
        studentLearningSupport.concessionApplication = studentLearningSupportDto.concessionApplication
        studentLearningSupport.examConcessionApproved = studentLearningSupportDto.examConcessionApproved
        studentLearningSupport.btecConcessionApproved = studentLearningSupportDto.btecConcessionApproved
        studentLearningSupport.fsConcessionApproved = studentLearningSupportDto.fsConcessionApproved
        studentLearningSupport.assessmentDate = studentLearningSupportDto.assessmentDate
        studentLearningSupport.supportType = studentLearningSupportDto.supportTypeId != null ? supportTypeService.findById(studentLearningSupportDto.supportTypeId) : null
        return save(studentLearningSupport)
    }
    
    /**
     * This service method is used to delete a complete StudentLearningSupport object in the database
     *
     * @param studentLearningSupport the  StudentLearningSupport object to be deleted
     *
     */
    @Override
    public void delete(StudentLearningSupport obj) {
        throw new InvalidOperationException("StudentLearningSupport should not be deleted")
    }
    
    @Override
    public StudentLearningSupport findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
