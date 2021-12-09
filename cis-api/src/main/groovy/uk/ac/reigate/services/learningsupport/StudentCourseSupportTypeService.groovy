package uk.ac.reigate.services.learningsupport

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentCourseSupportType
import uk.ac.reigate.dto.learningsupport.StudentCourseSupportTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentCourseSupportTypeRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.lookup.SupportTypeService
import uk.ac.reigate.services.student.StudentService

/**
 * This service is used to access the StudentCourseSupportType data that is stored in the database. 
 * 
 * @author Vinaya Bali
 *
 */
@Service
class StudentCourseSupportTypeService implements ICoreDataService<StudentCourseSupportType, Integer>, IStudentDataService<List<StudentCourseSupportType>> {
    
    @Autowired
    StudentCourseSupportTypeRepository studentCourseSupportTypeRepository
    
    @Autowired
    CourseService courseService
    
    @Autowired
    SupportTypeService supportTypeService
    
    @Autowired
    StudentService studentService
    
    StudentCourseSupportTypeService() {}
    
    StudentCourseSupportTypeService(StudentCourseSupportTypeRepository studentCourseSupportTypeRepository, CourseService courseService, SupportTypeService supportTypeService, StudentService studentService){
        super();
        this.studentCourseSupportTypeRepository = studentCourseSupportTypeRepository;
        this.courseService = courseService;
        this.supportTypeService = supportTypeService;
        this.studentService = studentService;
    }
    /**
     * This method is used to retrieve a StudentCourseSupportType by the supplied StudentCourseSupportTypePk object. 
     * 
     * @param id the StudentCourseSupportTypePk object used for the search.
     * @return a StudentCourseSupportType that matches the id supplied.
     */
    @Override
    public StudentCourseSupportType findById(Integer id) {
        return studentCourseSupportTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to retieve all the StudentCourseSupportType data objects.
     *
     * @return a List of StudentCourseSupportType
     */
    @Override
    public List<StudentCourseSupportType> findAll() {
        return studentCourseSupportTypeRepository.findAll()
    }
    
    /**
     * This service method is used to save the studentSupportType
     *
     * @param studentSupportType
     * @return
     */
    @Override
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Learning Support')")
    @Transactional
    public StudentCourseSupportType save(StudentCourseSupportType studentCourseSupportType) {
        return studentCourseSupportTypeRepository.save(studentCourseSupportType)
    }
    
    /**
     * This method is used to delete the supplied StudentCourseSupportType data object. 
     */
    @Override
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Learning Support')")
    @Transactional
    public void delete(StudentCourseSupportType studentCourseSupportType) {
        studentCourseSupportTypeRepository.delete(studentCourseSupportType)
    }
    
    /**
     * This method is used to delete the supplied StudentCourseSupportType data object. 
     */
    public void deleteById(Integer id) {
        studentCourseSupportTypeRepository.deleteById(id)
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseSupportType object for the supplied student.
     *
     * @param student a Student data object to use for the search.
     * @return a List of StudentCourseSupportType data objects for the supplied Student.
     */
    public List<StudentCourseSupportType> getByStudent(Student student){
        List<StudentCourseSupportType> students = studentCourseSupportTypeRepository.findByStudent(student)
        return students
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseSupportType object for the supplied student and course.
     *
     * @param student a Student data object to use for the search.
     * @param course a Course data object to use for the search.
     * @return a List of StudentCourseSupportType data objects for the supplied Student.
     */
    public List<StudentCourseSupportType> getByStudentAndCourse(Student student, Course course){
        return studentCourseSupportTypeRepository.findByStudentAndCourse(student, course)
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseSupportType object for the supplied student and course list.
     *
     * @param student a Student data object to use for the search.
     * @param courses a List of Course data objects to use for the search.
     * @return a List of StudentCourseSupportType data objects for the supplied Student.
     */
    public List<StudentCourseSupportType> getByStudentAndCourseList(Student student, List<Course> courses){
        List<StudentCourseSupportType> studentCourseSupportTypes = new ArrayList<StudentCourseSupportType>()
        courses.each { course ->
            studentCourseSupportTypes.addAll(studentCourseSupportTypeRepository.findByStudentAndCourse(student, course))
        }
        return studentCourseSupportTypes
    }
    
    /**
     * This method is used to retrieve the list of StudentCourseSupportType object for the supplied studentId.
     *
     * @param studentId the studentId to use for the search.
     * @return a List of StudentCourseSupportType data objects for the supplied studentId.
     */
    public List<StudentCourseSupportType> getByStudentId(Integer studentId){
        List<StudentCourseSupportType> students = studentCourseSupportTypeRepository.findByStudentId(studentId)
        return students
    }
    
    public StudentCourseSupportType createFromDto(StudentCourseSupportTypeDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot create StudentCourseSupportType from null object.")
        }
        StudentCourseSupportType studentCourseSupportType = new StudentCourseSupportType()
        if(dto.studentId != null) {
            studentCourseSupportType.student = studentService.findById(dto.studentId)
        }
        if(dto.courseId != null) {
            studentCourseSupportType.course = courseService.findById(dto.courseId)
        }
        if(dto.supportTypeId != null) {
            studentCourseSupportType.supportType = supportTypeService.findById(dto.supportTypeId)
        }
        studentCourseSupportType.startDate = dto.startDate
        studentCourseSupportType.endDate = dto.endDate
        return save(studentCourseSupportType)
    }
    
    /**
     * This method is used to update a StudentCourseSupportType based on a StudentCourseSupportTypeDto object. The
     * resulting object is then saved to the database and returned to the caller.
     *  
     * @param dto the StudentCourseSupportTypeDto to use for the update
     * @return the updated StudentCourseSupportType object
     */
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Learning Support')")
    public StudentCourseSupportType updateFromDto(StudentCourseSupportTypeDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot update StudentCourseSupportType from null object.")
        }
        StudentCourseSupportType studentCourseSupportType = findById(dto.studentCourseSupportTypeId)
        if (studentCourseSupportType != null) {
            studentCourseSupportType.course = courseService.findById(dto.courseId)
            studentCourseSupportType.supportType = supportTypeService.findById(dto.supportTypeId)
            studentCourseSupportType.startDate = dto.startDate
            studentCourseSupportType.endDate = dto.endDate
            return save(studentCourseSupportType)
        }
    }
}
