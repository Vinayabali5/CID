package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentLLDDHealthProblemCategory
import uk.ac.reigate.dto.StudentLLDDHealthProblemCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentLLDDHealthProblemCategoryRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.LLDDHealthProblemCategoryService


@Service
class StudentLLDDHealthProblemCategoryService implements ICoreDataService<StudentLLDDHealthProblemCategory, Integer>, IStudentDataService<List<StudentLLDDHealthProblemCategory>>, IDtoCreateUpdateService<StudentLLDDHealthProblemCategoryDto, StudentLLDDHealthProblemCategory> {
    
    @Autowired
    StudentLLDDHealthProblemCategoryRepository studentLLDDHealthProblemCategoryRepository
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService
    
    /**
     * Default No Args constructor
     */
    StudentLLDDHealthProblemCategoryService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentlLDDHealthProblemCategoryRepository
     */
    StudentLLDDHealthProblemCategoryService(StudentLLDDHealthProblemCategoryRepository studentLLDDHealthProblemCategoryRepository, StudentService studentService, LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService){
        super();
        this.studentLLDDHealthProblemCategoryRepository = studentLLDDHealthProblemCategoryRepository;
        this.studentService = studentService;
        this.lLDDHealthProblemCategoryService = lLDDHealthProblemCategoryService;
    }
    
    /**
     * This method is used to retrieve a StudentlLDDHealthProblemCategory object using the supplied StudentlLDDHealthProblemCategoryPk object.
     *
     * @return an instance of the StudentlLDDHealthProblemCategory object match the supplied ID.
     */
    @Override
    @Transactional(readOnly = true)
    public StudentLLDDHealthProblemCategory findById(Integer id) {
        return studentLLDDHealthProblemCategoryRepository.findById(id).orElse(null)
    }
    
    
    /**
     * This method is used to retrieve all the StudnetlLDDHealthProblemCategory objects. 
     * 
     * @return a List of all StudentlLDDHealthProblemCategory objects
     */
    @Override
    public List<StudentLLDDHealthProblemCategory> findAll() {
        return studentLLDDHealthProblemCategoryRepository.findAll()
    }
    
    
    /**
     * This method is used to save an instance of a StudentlLDDHealthProblemCategory object to the database.
     *
     * @param studentlLDDHealthProblemCategory a StudentlLDDHealthProblemCategory object to persist to the database.
     * @return the saved version of the StudentlLDDHealthProblemCategory object.
     */
    @Override
    @Transactional
    public StudentLLDDHealthProblemCategory save(StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory) {
        return studentLLDDHealthProblemCategoryRepository.save(studentLLDDHealthProblemCategory)
    }
    
    /**
     * This method is used to delete an instance of a StudentlLDDHealthProblemCategory from the database.
     *
     * @param studentlLDDHealthProblemCategoryId the studentlLDDHealthProblemCategoryId ID to use for the deletion.
     * @return
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer studentLLDDHealthProblemCategoryId){
        studentLLDDHealthProblemCategoryRepository.deleteById(studentLLDDHealthProblemCategoryId)
    }
    
    /**
     * This method is used to retrieve a List of StudentlLDDHealthProblemCategory object for the supplied Student ID.
     * 
     * @param studentId the Student ID to use for the search.
     * @return a List of StudentlLDDHealthProblemCategory objects.
     */
    public List<StudentLLDDHealthProblemCategory> getByStudentId(Integer studentId){
        return studentLLDDHealthProblemCategoryRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This method is used to retrieve a List of StudentlLDDHealthProblemCategory object for the supplied Student.
     *
     * @param student the Student to use for the search.
     * @return a List of StudentlLDDHealthProblemCategory objects.
     */
    public List<StudentLLDDHealthProblemCategory> getByStudent(Student student) {
        return studentLLDDHealthProblemCategoryRepository.findByStudent(student)
    }
    
    /**
     * This method is used to create a new StudentlLDDHealthProblemCategory data object from the supplied StudentlLDDHealthProblemCategoryDto.
     *
     * @param studentlLDDHealthProblemCategoryDto the DTO to use for the creation
     * @return the newly create StudentlLDDHealthProblemCategory
     */
    public StudentLLDDHealthProblemCategory createFromDto(StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto) {
        if(studentLLDDHealthProblemCategoryDto == null) {
            throw new InvalidDataException("Cannot create studentLLDDHealthProblemCategoryDto from null object.")
        }
        StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory = new StudentLLDDHealthProblemCategory()
        if(studentLLDDHealthProblemCategoryDto.studentId != null) {
            studentLLDDHealthProblemCategory.student = studentService.findById(studentLLDDHealthProblemCategoryDto.studentId)
        }
        if(studentLLDDHealthProblemCategoryDto.lLDDHealthProblemCategoryId != null) {
            studentLLDDHealthProblemCategory.lLDDHealthProblemCategory = lLDDHealthProblemCategoryService.findById(studentLLDDHealthProblemCategoryDto.lLDDHealthProblemCategoryId)
        }
        studentLLDDHealthProblemCategory.primarylldd = studentLLDDHealthProblemCategoryDto.primarylldd
        return save(studentLLDDHealthProblemCategory)
    }
    
    /**
     * This method is used to update a StudentlLDDHealthProblemCategory based on a StudentlLDDHealthProblemCategoryDto
     *
     * @param studentlLDDHealthProblemCategoryDto the DTO object to use for the update
     * @return the saved StudentlLDDHealthProblemCategory object
     */
    public StudentLLDDHealthProblemCategory updateFromDto(StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto) {
        if(studentLLDDHealthProblemCategoryDto == null) {
            throw new InvalidDataException("Cannot update studentLLDDHealthProblemCategoryDto from null object.")
        }
        StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory = findById(studentLLDDHealthProblemCategoryDto.id)
        if(studentLLDDHealthProblemCategoryDto.studentId != null) {
            studentLLDDHealthProblemCategory.student = studentService.findById(studentLLDDHealthProblemCategoryDto.studentId)
        }
        if(studentLLDDHealthProblemCategoryDto.lLDDHealthProblemCategoryId != null) {
            studentLLDDHealthProblemCategory.lLDDHealthProblemCategory = lLDDHealthProblemCategoryService.findById(studentLLDDHealthProblemCategoryDto.lLDDHealthProblemCategoryId)
        }
        studentLLDDHealthProblemCategory.primarylldd = studentLLDDHealthProblemCategoryDto.primarylldd
        return save(studentLLDDHealthProblemCategory)
    }
    
    /**
     * This method is used to delete a StudentlLDDHealthProblemCategory by StudentlLDDHealthProblemCategory object.
     */
    @Override
    public void delete(StudentLLDDHealthProblemCategory obj) {
        studentLLDDHealthProblemCategoryRepository.delete(obj)
    }
}
