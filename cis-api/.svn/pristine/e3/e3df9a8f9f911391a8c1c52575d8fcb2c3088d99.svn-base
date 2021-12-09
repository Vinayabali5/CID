package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.StudentPredictedGrade
import uk.ac.reigate.dto.StudentPredictedGradeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.academic.StudentPredictedGradeRepository
import uk.ac.reigate.services.EntryQualificationService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.exams.ExamBoardService

@Service
class StudentPredictedGradeService implements ICoreDataService<StudentPredictedGrade, Integer>, IDtoCreateUpdateService<StudentPredictedGradeDto, StudentPredictedGrade>{
    
    @Autowired
    StudentPredictedGradeRepository studentPredictedGradeRepository
    
    @Autowired
    StudentService studentService
    
    @Autowired
    EntryQualificationService entryQualificationService
    
    @Autowired
    ExamBoardService examBoardService
    /**
     * Default NoArgs constructor
     */
    StudentPredictedGradeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentPredictedGradeRepository
     */
    StudentPredictedGradeService(StudentPredictedGradeRepository studentPredictedGradeRepository, StudentService studentService, EntryQualificationService entryQualificationService, ExamBoardService examBoardService) {
        super();
        this.studentPredictedGradeRepository = studentPredictedGradeRepository;
        this.studentService = studentService;
        this.entryQualificationService = entryQualificationService;
        this.examBoardService = examBoardService;
    }
    
    /**
     * Find an individual StudentPredictedGrade using the StudentPredictedGrade ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentPredictedGrade object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentPredictedGrade findById(Integer id) {
        return studentPredictedGradeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of StudentPredictedGrade objects
     * @return a List of StudentPredictedGrade
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentPredictedGrade> findAll() {
        return studentPredictedGradeRepository.findAll();
    }
    
    
    /**
     * This service method is used to save a complete StudentPredictedGrade object in the database
     *
     * @param studentPredictedGrade the new StudentPredictedGrade object to be saved
     * @return the saved version of the StudentPredictedGrade object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Quals on Entry')")
    @Transactional
    public StudentPredictedGrade save(StudentPredictedGrade studentPredictedGrade) {
        return studentPredictedGradeRepository.save(studentPredictedGrade)
    }
    
    /**
     * This service method is used to create a StudentPredictedGrade object in the database from a partial or complete StudentPredictedGrade object.
     *
     * @param studentPredictedGrade the partial or complete StudentPredictedGrade object to be saved
     * @return the saved version of the StudentPredictedGrade object
     */
    @Transactional
    public StudentPredictedGrade createFromDto(StudentPredictedGradeDto studentPredictedGrade){
        if(studentPredictedGrade == null) {
            throw new InvalidDataException("Cannot create studentPredictedGradeDto from null object.")
        }
        StudentPredictedGrade studentPredictedGradeToSave = new StudentPredictedGrade()
        studentPredictedGradeToSave.student = studentPredictedGrade.studentId != null ? studentService.findById(studentPredictedGrade.studentId) : null
        studentPredictedGradeToSave.predictedGrade = studentPredictedGrade.predictedGradeId != null ? entryQualificationService.findById(studentPredictedGrade.predictedGradeId) : null
        studentPredictedGradeToSave.grade = studentPredictedGrade.grade != null ? studentPredictedGrade.grade : studentPredictedGradeToSave.grade
        studentPredictedGradeToSave.examBoard = studentPredictedGrade.examBoardId != null ? examBoardService.findById(studentPredictedGrade.examBoardId) : null
        return save(studentPredictedGradeToSave)
    }
    
    /**
     * This service method is used to update an StudentPredictedGrade object in the database from a partial or complete StudentPredictedGrade object.
     *
     * @param studentPredictedGrade the partial or complete StudentPredictedGrade object to be saved
     * @return the saved version of the StudentPredictedGrade object
     */
    @Transactional
    public StudentPredictedGrade updateFromDto(StudentPredictedGradeDto studentPredictedGrade){
        if(studentPredictedGrade == null) {
            throw new InvalidDataException("Cannot update studentPredictedGradeDto from null object.")
        }
        StudentPredictedGrade studentPredictedGradeToSave = findById(studentPredictedGrade.studentPredictedGradeId)
        studentPredictedGradeToSave.student = studentPredictedGrade.studentId != null ? studentService.findById(studentPredictedGrade.studentId) : null
        studentPredictedGradeToSave.predictedGrade = studentPredictedGrade.predictedGradeId != null ? entryQualificationService.findById(studentPredictedGrade.predictedGradeId) : null
        studentPredictedGradeToSave.grade = studentPredictedGrade.grade != null ? studentPredictedGrade.grade : studentPredictedGradeToSave.grade
        studentPredictedGradeToSave.examBoard = studentPredictedGrade.examBoardId != null ? examBoardService.findById(studentPredictedGrade.examBoardId) : null
        return save(studentPredictedGradeToSave)
    }
    
    /**
     * @param studentPredictedGrades
     * @return
     */
    @Transactional
    public List<StudentPredictedGrade> saveStudentPredictedGrades(List<StudentPredictedGrade> studentPredictedGrades){
        return studentPredictedGrades.collect { studentPredictedGrade -> save( studentPredictedGrade )};
    }
    
    
    /**
     * This method is used to retrieve the student entry qualifications that a specific studentId and studentPredictedGradeId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  StudentPredictedGrade getByStudentPredictedGrades(Integer studentId, Integer studentPredictedGradeId){
        return studentPredictedGradeRepository.findByStudent_IdAndId(studentId, studentPredictedGradeId);
    }
    
    /**
     * This method is used to retrieve the list of student entry qualifications that a specific studentId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<StudentPredictedGrade> getByStudent(Integer studentId){
        return studentPredictedGradeRepository.findByStudent_Id(studentId);
    }
    
    
    /**
     * This service method is used to delete a complete StudentPredictedGrade object in the database
     *
     * @param studentPredictedGradeId the object to be deleted   
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer studentPredictedGradeId){
        studentPredictedGradeRepository.deleteById(studentPredictedGradeId)
    }
    
    
    /* (non-Javadoc)
     * @see uk.ac.reigate.services.ICoreDataService#delete(java.lang.Object)
     */
    @Override
    public void delete(StudentPredictedGrade studentPredictedGrade) {
        // studentPredictedGradeRepository.delete(studentPredictedGrade)
    }
}
