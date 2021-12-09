package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.CourseDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.predicates.CoursePredicates
import uk.ac.reigate.repositories.academic.CourseRepository
import uk.ac.reigate.services.exams.ExamBoardService

import lombok.RequiredArgsConstructor

@Service
@RequiredArgsConstructor
class CourseService implements ICoreDataService<Course, Integer>, IDtoCreateUpdateService<CourseDto, Course>{
    
    @Autowired
    CourseRepository courseRepository
    
    @Autowired
    LevelService levelService;
    
    @Autowired
    SubjectService subjectService;
    
    @Autowired
    ExamBoardService examBoardService;
    
    @Autowired
    AcademicYearService academicYearService;
    
    /**
     * Default NoArgs constructor
     */
    CourseService() {}
    
    CourseService(CourseRepository courseRepository, LevelService levelService, SubjectService subjectService, ExamBoardService examBoardService, AcademicYearService academicYearService) {
        super();
        this.courseRepository = courseRepository;
        this.levelService = levelService;
        this.subjectService = subjectService;
        this.examBoardService = examBoardService;
        this.academicYearService = academicYearService;
    }
    
    /**
     * Find an individual course using the courses ID fields
     *
     * @param id the ID fields to search for
     * @return the Course object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null)
    }
    /**
     * Find all courses
     *
     * @return a List of Courses
     */
    @Override
    @Transactional(readOnly = true)
    List<Course> findAll() {
        return courseRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Course object in the database
     *
     * @param course the new Course object to be saved
     * @return the saved version of the Course object
     */
    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course)
    }
    
    /**
     * This method is used to create a new Course data object from the supplied CourseDto
     * @param courseDto
     * @return
     */
    @Transactional
    public Course createFromDto(CourseDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot create Course from null object.")
        }
        Course course = new Course()
        course.glh = dto.glh
        course.learningAimReference = dto.learningAimReference
        course.locationPostcode = dto.locationPostcode
        course.syllabusCode = dto.syllabusCode
        if (dto.examBoardId != null){
            course.examBoard = examBoardService.findById(dto.examBoardId)
        }
        if (dto.levelId != null){
            course.level = levelService.findById(dto.levelId)
        }
        if (dto.subjectId != null){
            course.subject = subjectService.findById(dto.subjectId)
        }
        course.notes = dto.notes
        if (dto.validFromId != null){
            course.validFrom = academicYearService.findById(dto.validFromId)
        }
        if (dto.validToId != null){
            course.validTo = academicYearService.findById(dto.validToId)
        }
        course.courseSummary = dto.courseSummary
        course.entryRequirements = dto.entryRequirements
        course.russell = dto.russell
        course.externalLink = dto.externalLink
        course.published = dto.published
        course.publishedTitle = dto.publishedTitle
        course.spec = dto.spec
        course.externallyAssessed = dto.externallyAssessed
        course.rqfLevelOverride = dto.rqfLevelOverride
        course.ucasTitle = dto.ucasTitle
        return save(course)
    }
    
    /**
     * This method is used to update a Course data object from a CourseDto object.
     * 
     * @param dto
     * @return
     */
    @Transactional
    Course updateFromDto(CourseDto dto) {
        if (dto.id == null) {
            throw new InvalidDataException("Course ID should not be null when updating")
        }
        Course course = findById(dto.id)
        if (dto.levelId != null){
            course.level = levelService.findById(dto.levelId)
        }
        if (dto.subjectId != null){
            course.subject = subjectService.findById(dto.subjectId)
        }
        if (dto.examBoardId != null){
            course.examBoard = examBoardService.findById(dto.examBoardId)
        }
        if (dto.validFromId != null){
            course.validFrom = academicYearService.findById(dto.validFromId)
        }
        if (dto.validToId != null){
            course.validTo = academicYearService.findById(dto.validToId)
        }
        course.syllabusCode = dto.syllabusCode
        course.glh = dto.glh
        course.learningAimReference = dto.learningAimReference
        course.locationPostcode = dto.locationPostcode
        course.subjectSectorArea = dto.subjectSectorArea
        course.notes = dto.notes
        course.courseSummary = dto.courseSummary
        course.entryRequirements = dto.entryRequirements
        course.russell = dto.russell
        course.externalLink = dto.externalLink
        course.published = dto.published
        course.publishedTitle = dto.publishedTitle
        course.spec = dto.spec
        course.externallyAssessed = dto.externallyAssessed
        course.rqfLevelOverride = dto.rqfLevelOverride
        course.ucasTitle = dto.ucasTitle
        return save(course)
    }
    
    /**
     * Saves a list of Course objects to the database
     *
     * @param courses a list of Courses to be saved to the database
     * @return the list of save Course objects
     */
    
    @Transactional
    public List<Course> saveCourses(List<Course> courses) {
        return courses.collect { course -> save( course ) };
    }
    
    /** Retrieves List of Course by Year and Spec
     * @param year
     * @param spec
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <Course> searchByYearAndSpec(AcademicYear year, String spec){
        List<Course> courses = courseRepository.findByValidFromAndSpecLike(year, spec)
        return courses
    }
    
    /** Retrieves List of Course by yearId
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public findAllCoursesValidInYear(Integer yearId) {
        List<Course> courses = courseRepository.findAll(CoursePredicates.courseValidInYear(yearId))
        return courses
    }
    
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('ROLE_Service User')")
    public findAllPublishedCoursesValidInYear(Integer yearId) {
        List<Course> courses = courseRepository.findAll(CoursePredicates.coursePublishedAndValidInYear(yearId))
        return courses
    }
    
    /** Retrieves List of Course by year
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Course> searchByYear(AcademicYear year) {
        List<Course> courses = courseRepository.findCourseValidOnYear(year.id)
        return courses
    }
    
    /**Retrieves List of Course that is valid from year
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public Course getByAcademicYear(AcademicYear year) {
        return courseRepository.findByValidFrom(year)
    }
    
    /**
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Course> getCourseByYearId(Integer yearId){
        return courseRepository.findCourseValidOnYear(yearId)
    }
    
    /**
     * @param courseId
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public Course getCourseByIdAndYearId(Integer courseId,Integer yearId){
        return courseRepository.findCourseByIDAndValidFrom(courseId,yearId)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. CourseGroup should not be deleted.
     */
    @Override
    public void delete(Course obj) {
        throw new InvalidOperationException("Course should not be deleted");
    }
    
    /**
     * This method is used to retrieve the courses that a given Student object has been enrolled on.
     * 
     * @param student The Student object to use for the search
     * @return a List of Course objects that the Student is enrolled on
     */
    List<Course> findByStudent(Student student) {
        List<Course> courses = courseRepository.findByStudent(student)
        return courses
    }
}
