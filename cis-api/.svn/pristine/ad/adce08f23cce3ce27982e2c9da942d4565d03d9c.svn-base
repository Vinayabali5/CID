package uk.ac.reigate.services.exams

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.CourseOptionPk
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.dto.exams.CourseOptionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.predicates.CourseOptionPredicates
import uk.ac.reigate.repositories.exams.CourseOptionRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.utils.ValidationUtils;;

@Service
public class CourseOptionService implements ICoreDataService<CourseOption,CourseOptionPk>{
    
    private final static Logger LOGGER = LoggerFactory.getLogger(CourseOptionService.class.getName())
    
    @Autowired
    CourseOptionRepository courseOptionRepository
    
    @Autowired
    CourseService courseService
    
    @Autowired
    ExamOptionService examOptionService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    /**
     * Default NoArgs constructor
     */
    CourseOptionService() {}
    
    /**
     * Autowired constructor
     *
     * @param courseOptionRepository
     */
    CourseOptionService(CourseOptionRepository courseOptionRepository, CourseService courseService, ExamOptionService examOptionService, ExamSeriesService examSeriesService) {
        this.courseOptionRepository = courseOptionRepository
        this.courseService = courseService
        this.examOptionService = examOptionService
        this.examSeriesService = examSeriesService
    }
    
    /**
     * Find an individual exam basedata CourseOption by CourseOptionPk
     *
     * @param componentId - the ID to search for
     * @return CourseOption - the CourseOption object that matches the ID, or null if not found
     */
    @Transactional(readOnly = true)
    public CourseOption findCourseOption(Integer courseId, Integer examOptionId) {
        CourseOptionPk courseOptionPk = new CourseOptionPk(courseId, examOptionId);
        findById(courseOptionPk);
    }
    
    /**
     * Find all CourseOption objects
     *
     * @return a SearchResult set with the list of CourseOptions
     */
    @Override
    @Transactional(readOnly = true)
    public List<CourseOption> findAll() {
        return courseOptionRepository.findAll();
    }
    
    /**
     * This Service method is used to create a new CourseOption data object from the supplied CourseOptionDto
     * @param CourseOptionDto
     * @return
     */
    @Transactional
    public CourseOption createFromDto(CourseOptionDto courseOptionDto) {
        if (courseOptionDto == null) {
            throw new InvalidDataException("Cannot create courseOptionDto from null object.")
        }
        CourseOption courseOption = new CourseOption()
        if(courseOptionDto.courseId != null) {
            courseOption.course = courseService.findById(courseOptionDto.courseId)
        }
        if(courseOptionDto.examOptionId != null) {
            courseOption.examOption = examOptionService.findById(courseOptionDto.examOptionId)
        }
        courseOption.lowerEntry = courseOptionDto.lowerEntry
        courseOption.upperEntry = courseOptionDto.upperEntry
        courseOption.intermediateEntry = courseOptionDto.intermediateEntry
        return save(courseOption)
    }
    
    /**
     * This Service method is used to update the existing CourseOption data object from the supplied CourseOptionDto
     * @param CourseOptionDto
     * @return
     */
    @Transactional
    public CourseOption updateFromDto(CourseOptionDto courseOptionDto) {
        if (courseOptionDto == null) {
            throw new InvalidDataException("Cannot update courseOptionDto from null object.")
        }
        CourseOption courseOption = findCourseOption(courseOptionDto.courseId, courseOptionDto.examOptionId)
        courseOption.lowerEntry = courseOptionDto.lowerEntry
        courseOption.upperEntry = courseOptionDto.upperEntry
        courseOption.intermediateEntry = courseOptionDto.intermediateEntry
        return save(courseOption)
    }
    
    /**
     * Save an CourseOption object to the database
     *
     * @param CourseOption - the CourseOption object to save
     * @return the saved CourseOption object
     */
    @Override
    public CourseOption save(CourseOption courseOption) {
        return courseOptionRepository.save(courseOption)
    }
    
    
    /**
     * This method is used to retrieve courseOption by id
     * @param courseOptionPk
     * @return
     */
    @Override
    public CourseOption findById(CourseOptionPk courseOptionPk) {
        return courseOptionRepository.findById(courseOptionPk).orElse(null);
    }
    
    /**
     * This method is used to retrieve a list of CourseOptions for a given courseId
     *
     * @param courseId the ID of the course to load data for
     * @return a List of CourseOption objects
     */
    public List<ExamOption> findCourseExamOptions(Integer courseId) {
        return courseOptionRepository.findByCourseId(courseId).collect {
            examOptionService.findById(it.examOption.id)
        }
    }
    
    /**
     * This method is used to retrieve a list of CourseOptions for a given courseId
     *
     * @param courseId the ID of the course to load data for
     * @return a List of CourseOption objects
     */
    public List<ExamOption> findCourseExamOptions(Integer courseId, Integer yearId) {
        List<CourseOption> courseOptions = courseOptionRepository.findAll(CourseOptionPredicates.courseAndYear(courseId, yearId))
        return courseOptions.collect {
            examOptionService.findById(it.examOption.id)
        }
    }
    
    /**
     * Delete an CourseOption object from the database
     *
     * @param courseId the ID of the CourseOption object to delete
     * @param examOptionId  the ID of the ExamOption object to delete
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public Boolean deleteByIds(Integer courseId, Integer examOptionId) {
        CourseOption courseOption = courseOptionRepository.findByCourse_IdAndExamOptionId(courseId, examOptionId)
        if(courseOption != null) {
            delete(courseOption)
            return true;
        }
        return false;
    }
    /**
     * This method is used to delete by course and examOption object.
     */
    public Boolean deleteByCourseAndExamOption(Course course, ExamOption examOption) {
        return deleteByIds(course.id, examOption.id)
    }
    
    /**
     * This method is used to delete by courseOption object
     */
    @Override
    public void delete(CourseOption courseOption) {
        courseOptionRepository.delete(courseOption)
    }
}
