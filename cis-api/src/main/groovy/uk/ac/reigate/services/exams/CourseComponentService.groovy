package uk.ac.reigate.services.exams

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.domain.exams.CourseComponentPk
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.CourseOptionPk
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.academic.CourseRepository;
import uk.ac.reigate.repositories.exams.CourseComponentRepository
import uk.ac.reigate.repositories.exams.CourseOptionRepository
import uk.ac.reigate.repositories.exams.basedata.ExamComponentRepository
import uk.ac.reigate.repositories.exams.basedata.ExamOptionRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.utils.ValidationUtils;

@Service
public class CourseComponentService implements ICoreDataService<CourseComponent, CourseComponentPk>{
    
    @Autowired
    CourseComponentRepository courseComponentRepository
    
    /**
     * Default NoArgs constructor
     */
    CourseComponentService() {}
    
    /**
     * Autowired Constructor
     * 
     * @param courseComponentRepository
     */
    CourseComponentService(CourseComponentRepository courseComponentRepository) {
        this.courseComponentRepository = courseComponentRepository;
    }
    
    /**
     * Find an individual exam CourseComponent by courseId, optionId and componentId
     *
     * @return CourseComponent - the CourseComponent object that matches the ID, or null if not found
     */
    @Transactional(readOnly = true)
    public CourseComponent findCourseComponent(Integer courseId, Integer examOptionId, Integer examComponentId) {
        CourseComponentPk courseComponentPk = new CourseComponentPk(courseId, examOptionId, examComponentId);
        return findById(courseComponentPk);
    }
    
    /**
     * Find an individual exam CourseComponent by CourseComponentPk
     * 
     * @param courseComponentId - the compound ID to search for
     * @return CourseComponent - the CourseComponent object that matches the ID, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    public CourseComponent findById(CourseComponentPk courseComponentPk) {
        return courseComponentRepository.findById(courseComponentPk).orElse(null);
    }
    
    /**
     * Find all CourseComponent objects
     *
     * @return a SearchResult set with the list of CourseOptions
     */
    @Override
    @Transactional(readOnly = true)
    public List<CourseComponent> findAll() {
        return courseComponentRepository.findAll();
    }
    
    /**
     * Save an CourseComponent object to the database
     *     
     * @param CourseComponent - the CourseComponent object to save
     * @return the saved CourseComponent object
     */
    @Override
    public CourseComponent save(CourseComponent courseComponent) {
        return courseComponentRepository.save(courseComponent)
    }
    
    /**
     * Delete an CourseOption object from the database
     * 
     * @param examComponentId - the ID of the CourseOption object to delete    
     */
    public deleteByIds(Integer courseId, Integer examOptionId, Integer examComponentId) {
        CourseComponent courseComponent = courseComponentRepository.findByCourse_IdAndExamOption_IdAndExamComponent_Id(courseId, examOptionId, examComponentId)
        if(courseComponent != null) {
            delete(courseComponent);
            return true;
        }
        return false;
    }
    
    /**
     * @param CourseComponent
     */
    @Override
    public void delete(CourseComponent courseComponent) {
        courseComponentRepository.delete(courseComponent);
    }
}