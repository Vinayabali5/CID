package uk.ac.reigate.services.learningsupport

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.learningsupport.StudentCourseConcessionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentCourseConcessionRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.lookup.ConcessionTypeService
import uk.ac.reigate.services.student.StudentService

/**
 * This service is used to access the StudentCourseConcession data that is stored in the database. 
 * 
 * @author Michael Horgan
 *
 */
@Service
class StudentCourseConcessionService implements ICoreDataService<StudentCourseConcession, Integer>, IStudentDataService<List<StudentCourseConcession>> {
    
    @Autowired
    StudentCourseConcessionRepository studentCourseConcessionRepository
    
    @Autowired
    CourseService courseService
    
    @Autowired
    ConcessionTypeService concessionTypeService
    
    @Autowired
    StudentService studentService
    
    StudentCourseConcessionService() {}
    
    StudentCourseConcessionService(StudentCourseConcessionRepository studentCourseConcessionRepository, CourseService courseService, ConcessionTypeService concessionTypeService, StudentService studentService){
        super();
        this.studentCourseConcessionRepository = studentCourseConcessionRepository;
        this.courseService = courseService;
        this.concessionTypeService = concessionTypeService;
        this.studentService = studentService;
    }
    /**
     * This method is used to retrieve a StudentCourseConcession by the supplied StudentCourseConcessionPk object. 
     * 
     * @param id the StudentCourseConcessionPk object used for the search.
     * @return a StudentCourseConcession that matches the id supplied.
     */
    @Override
    public StudentCourseConcession findById(Integer id) {
        return studentCourseConcessionRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to retieve all the StudentCourseConcession data objects.
     *
     * @return a List of StudentCourseConcession
     */
    @Override
    public List<StudentCourseConcession> findAll() {
        return studentCourseConcessionRepository.findAll()
    }
    
    /**
     * This service method is used to save the studentConcessionType
     *
     * @param studentConcessionType
     * @return
     */
    @Override
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Learning Support')")
    @Transactional
    public StudentCourseConcession save(StudentCourseConcession studentCourseConcession) {
        return studentCourseConcessionRepository.save(studentCourseConcession)
    }
    
    /**
     * This method is used to delete the supplied StudentCourseConcession data object. 
     */
    @Override
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Learning Support')")
    @Transactional
    public void delete(StudentCourseConcession studentCourseConcession) {
        studentCourseConcessionRepository.delete(studentCourseConcession)
    }
    
    /**
     * This method is used to delete the supplied StudentCourseConcession data object. 
     */
    public void deleteById(Integer id) {
        studentCourseConcessionRepository.deleteById(id)
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseConcession object for the supplied student.
     *
     * @param student a Student data object to use for the search.
     * @return a List of StudentCourseConcession data objects for the supplied Student.
     */
    public List<StudentCourseConcession> getByStudent(Student student){
        List<StudentCourseConcession> students = studentCourseConcessionRepository.findByStudent(student)
        return students
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseConcession object for the supplied student and course.
     *
     * @param student a Student data object to use for the search.
     * @param course a Course data object to use for the search.
     * @return a List of StudentCourseConcession data objects for the supplied Student.
     */
    public List<StudentCourseConcession> getByStudentAndCourse(Student student, Course course){
        return studentCourseConcessionRepository.findByStudentAndCourse(student, course)
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseConcession object for the supplied student and course list.
     *
     * @param student a Student data object to use for the search.
     * @param courses a List of Course data objects to use for the search.
     * @return a List of StudentCourseConcession data objects for the supplied Student.
     */
    public List<StudentCourseConcession> getByStudentAndCourseList(Student student, List<Course> courses){
        List<StudentCourseConcession> concessions = new ArrayList<StudentCourseConcession>()
        courses.each { course ->
            concessions.addAll(studentCourseConcessionRepository.findByStudentAndCourse(student, course))
        }
        return concessions
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseConcession object for the supplied studentId.
     *
     * @param studentId the studentId to use for the search.
     * @return a List of StudentCourseConcession data objects for the supplied studentId.
     */
    public List<StudentCourseConcession> getByStudentId(Integer studentId){
        List<StudentCourseConcession> students = studentCourseConcessionRepository.findByStudentId(studentId)
        return students
    }
    
    public StudentCourseConcession createFromDto(StudentCourseConcessionDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot create StudentCourseConcession from null object.")
        }
        StudentCourseConcession concession = new StudentCourseConcession()
        if(dto.studentId != null) {
            concession.student = studentService.findById(dto.studentId)
        }
        if(dto.courseId != null) {
            concession.course = courseService.findById(dto.courseId)
        }
        if(dto.concessionTypeId != null) {
            concession.concessionType = concessionTypeService.findById(dto.concessionTypeId)
        }
        concession.extraTimePercentage = dto.extraTimePercentage
        return save(concession)
    }
    
    /**
     * This method is used to update a StudentCourseConcession based on a StudentCourseConcessionDto object. The
     * resulting object is then saved to the database and returned to the caller.
     *  
     * @param dto the StudentCourseConcessionDto to use for the update
     * @return the updated StudentCourseConcession object
     */
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Learning Support')")
    public StudentCourseConcession updateFromDto(StudentCourseConcessionDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot update StudentCourseConcession from null object.")
        }
        StudentCourseConcession concession = findById(dto.studentCourseConcessionId)
        if (concession != null) {
            concession.course = courseService.findById(dto.courseId)
            concession.concessionType = concessionTypeService.findById(dto.concessionTypeId)
            concession.extraTimePercentage = dto.extraTimePercentage
            return save(concession)
        }
    }
}
