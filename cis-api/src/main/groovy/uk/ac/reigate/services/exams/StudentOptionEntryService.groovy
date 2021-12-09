package uk.ac.reigate.services.exams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.StudentOptionEntryPk
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.dto.exams.StudentOptionEntryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.StudentOptionEntryRepository
import uk.ac.reigate.services.EdiStatusTypeService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.lookup.StatusTypeService
import uk.ac.reigate.services.student.StudentService


@Service
class StudentOptionEntryService implements ICoreDataService<StudentOptionEntry,StudentOptionEntryPk>{
    
    @Autowired
    StudentOptionEntryRepository studentOptionEntryRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StatusTypeService statusTypeService;
    
    @Autowired
    private final EdiStatusTypeService ediStatusTypeService;
    
    @Autowired
    private final ExamOptionService examOptionService;
    
    /**
     * Default No Args constructor
     */
    StudentOptionEntryService() {}
    
    
    StudentOptionEntryService(StudentOptionEntryRepository studentOptionEntryRepository, StudentService studentService, StatusTypeService statusTypeService, EdiStatusTypeService ediStatusTypeService, ExamOptionService examOptionService) {
        this.studentOptionEntryRepository = studentOptionEntryRepository;
        this.studentService = studentService;
        this.statusTypeService = statusTypeService;
        this.ediStatusTypeService = ediStatusTypeService;
        this.examOptionService = examOptionService;
    }
    
    /**
     * Find all StudentOptionEntries
     * @return a SearchResult set with the list of OptionEntries
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentOptionEntry> findAll() {
        return studentOptionEntryRepository.findAll();
    }
    
    /**
     * Saves a StudentOptionEntry object to the database
     * @return StudentOptionEntry
     */
    @Override
    @Transactional
    public StudentOptionEntry save(StudentOptionEntry studentOptionEntry) {
        return studentOptionEntryRepository.save(studentOptionEntry)
    }
    
    /**
     * Finds individual studentOptionEntryPk
     * @return StudentOptionEntry
     */
    @Override
    public StudentOptionEntry findById(StudentOptionEntryPk studentOptionEntryPk) {
        return studentOptionEntryRepository.findById(studentOptionEntryPk).orElse(null)
    }
    
    
    /** Deletes StudentOptionEntry object     
     * @return StudentOptionEntry
     */
    @Override
    public void delete(StudentOptionEntry studentOptionEntry) {
        studentOptionEntryRepository.delete(new StudentOptionEntryPk(studentOptionEntry))
    }
    
    /**
     * Find an individual optionEntry using Student and ExamOption
     *
     * @param student
     * @param examOption
     * @return the OptionEntry object that matches student and examOption
     */
    @Transactional(readOnly = true)
    StudentOptionEntry findByStudentAndExamOption(Student student, ExamOption examOption){
        return findById(new StudentOptionEntryPk(student, examOption))
    }
    /**
     * This service method is used to create the StudentOptionEntry data object from StudentOptionEntryDto
     */
    @Transactional
    public StudentOptionEntry createFromDto(StudentOptionEntryDto studentOptionEntryDto) {
        if(studentOptionEntryDto == null) {
            throw new InvalidDataException("Cannot create a studentOptionEntry with a null object.")
        }
        StudentOptionEntry studentOptionEntry = new StudentOptionEntry()
        studentOptionEntry.student = studentService.findById(studentOptionEntryDto.studentId)
        studentOptionEntry.examOption = examOptionService.findById(studentOptionEntryDto.examOptionId)
        if(studentOptionEntryDto.statusTypeId != null){
            studentOptionEntry.statusType = statusTypeService.findById(studentOptionEntryDto.statusTypeId)
        }
        if(studentOptionEntryDto.ediStatusTypeId != null){
            studentOptionEntry.ediStatusType = ediStatusTypeService.findById(studentOptionEntryDto.ediStatusTypeId)
        }
        studentOptionEntry.resit = studentOptionEntryDto.resit
        studentOptionEntry.privateStudent = studentOptionEntryDto.privateStudent
        return save(studentOptionEntry)
    }
    
    /**
     * Find an individual optionEntry using StudentId and ExamOptionId
     *
     * @param studentId
     * @param examOptionId
     * @return the OptionEntry object that matches studentId and examOptionID
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    StudentOptionEntry findByStudentAndOption(Integer studentId, Integer optionId){
        return studentOptionEntryRepository.findByStudent_IdAndExamOption_Id(studentId, optionId)
    }
    
    
    /** List of StudentOptionEntry of a particular studentId
     * @param studentId
     * @return List of StudentOptionEntry
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentOptionEntry> getByStudent(Integer studentId){
        List<StudentOptionEntry> students = studentOptionEntryRepository.findByStudent_Id(studentId)
        return students
    }
    
    
    /**
     * This method is used to retrieve the student option entry information for a given exam component. This will return all student 
     * option entry information including those that are no long live.
     *  
     * @param componentId The exam component ID 
     * @return 
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentOptionEntry> getByComponentId(Integer componentId){
        List<StudentOptionEntry> examOptions = studentOptionEntryRepository.findByExamOption_OptionComponents_ExamComponentId(componentId)
        return examOptions
    }
    
    /**
     * This method is used to retrieve the student option entry information for a given exam component where the entry is live. This will 
     * only return student option entry information for the entries that are still live.
     * 
     * @param componentId The exam component ID 
     * @return 
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentOptionEntry> getByComponentIdAndLive(Integer componentId){
        List<StudentOptionEntry> examOptions = studentOptionEntryRepository.findByExamOption_OptionComponents_ExamComponentIdAndStatusType_Id(componentId, 1)
        return examOptions
    }
    
    
    /** Deleted StudentOptionEntry of StudentId and examOptionId
     * @param studentId
     * @param examOptionId
     * @return
     */
    @PreAuthorize("@securityChecker.checkDeleter(authentication) or hasRole('Exams Officer')")
    @Transactional
    public void deleteById(Integer studentId, Integer examOptionId){
        studentOptionEntryRepository.deleteById(new StudentOptionEntryPk(studentId, examOptionId))
    }
    
    /**
     * @param student
     * @param examOption
     * @return
     */
    public Boolean deleteByStudentAndExamOption(Student student, ExamOption examOption){
        return deleteById(student.id, examOption.id);
    }
    
    
    public List<StudentOptionEntry> getByOptionYearId(Integer optionYearId, Integer studentId){
        return studentOptionEntryRepository.findByOptionYearIdAndStudentId(optionYearId, studentId)
    }
}
