package uk.ac.reigate.services.exams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Course;
import uk.ac.reigate.domain.exams.CourseSyllabus
import uk.ac.reigate.domain.exams.CourseSyllabusPk
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.CourseSyllabusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.CourseSyllabusRepository
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.exams.basedata.SyllabusService


@Service
public class CourseSyllabusService implements ICoreDataService<CourseSyllabus,CourseSyllabusPk>{
    
    @Autowired
    CourseSyllabusRepository courseSyllabusRepository
    
    @Autowired
    CourseService courseService
    
    @Autowired
    SyllabusService syllabusService
    
    /**
     * Default NoArgs constructor
     */
    CourseSyllabusService() {}
    
    /**
     * Autowired constructor
     * 
     * @param courseOptionRepository
     */
    CourseSyllabusService(CourseSyllabusRepository courseSyllabusRepository, CourseService courseService, SyllabusService syllabusService) {
        this.courseSyllabusRepository = courseSyllabusRepository;
        this.courseService = courseService;
        this.syllabusService = syllabusService;
    }
    
    /**
     * Find an individual exam basedata CourseSyllabus by CourseSyllabusPk
     * 
     * @param courseId - the ID to search for
     * @param syllabusId - 
     * @return CourseSyllabus - the CourseSyllabus object that matches the ID, or null if not found
     */
    @Transactional(readOnly = true)
    public CourseSyllabus findCourseSyllabus(Integer courseId, Integer syllabusId) {
        CourseSyllabusPk courseSyllabusPk = new CourseSyllabusPk(courseId, syllabusId);
        return findById(courseSyllabusPk)
    }
    
    /**
     * This method is used to retrieve the courseSyllabus using ids
     * @param courseSyllabusPk
     */
    @Override
    public CourseSyllabus findById(CourseSyllabusPk courseSyllabusPk) {
        return courseSyllabusRepository.findById(courseSyllabusPk).orElse(null);
    }
    
    /**
     * Find all CourseSyllabus objects
     *         
     * @return a List set with the list of CourseSyllabi
     */
    @Transactional(readOnly = true)
    public List<CourseSyllabus> findAll() {
        return courseSyllabusRepository.findAll();
    }
    
    /**
     * Save an CourseOption object to the database
     *     
     * @param CourseOption - the CourseOption object to save
     * @return the saved CourseOption object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public CourseSyllabus save(CourseSyllabus courseSyllabus) {
        return courseSyllabusRepository.save(courseSyllabus);
    }
    
    /**
     * This Service method is used to create a new CourseSyllabus data object from the supplied CourseSyllabusDto
     * @param CourseSyllabusDto
     * @return
     */
    @Transactional
    public CourseSyllabus createFromDto(CourseSyllabusDto courseSyllabusDto) {
        if (courseSyllabusDto == null) {
            throw new InvalidDataException("Cannot create courseSyllabusDto from null object.")
        }
        CourseSyllabus courseSyllabus = new CourseSyllabus()
        courseSyllabus.course = courseService.findById(courseSyllabusDto.courseId)
        courseSyllabus.syllabus = syllabusService.findById(courseSyllabusDto.syllabusId)
        return save(courseSyllabus)
    }
    
    /**
     * Delete an CourseSyllabus object from the database
     *
     * @param courseId  - the ID of the CourseSyllabus object to delete
     * @param syllabusId
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public deleteByIds(Integer courseId, Integer syllabusId) {
        CourseSyllabus courseSyllabus = courseSyllabusRepository.findByCourse_IdAndSyllabus_Id(courseId, syllabusId);
        if(courseSyllabus != null) {
            courseSyllabusRepository.delete(courseSyllabus);
            return true
        }
        return false
    }
    
    /**
     * This method is used delete the Course Syllabus using Course and syllabus object.
     * @param course
     * @param syllabus
     * @return
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public deleteByCourseAndSyllabus(Course course, Syllabus syllabus) {
        return deleteByIds(course.id, syllabus.id);
    }
    
    /**
     * This method is used to delete the CourseSyllabus object
     * @param courseSyllabus
     */
    @Override
    public void delete(CourseSyllabus courseSyllabus) {
        courseSyllabusRepository.delete(courseSyllabus)
    }
}
