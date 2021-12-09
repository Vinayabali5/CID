package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.InsetCourse
import uk.ac.reigate.dto.staff.InsetCourseDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.InsetCourseRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class InsetCourseService implements ICoreDataService<InsetCourse, Integer>, IDtoCreateUpdateService<InsetCourseDto, InsetCourse>{
    
    @Autowired
    InsetCourseRepository insetCourseRepository
    
    /**
     * Default NoArgs constructor
     */
    InsetCourseService() {}
    
    /**
     * Autowired Constructor
     *
     * @param insetCourseRepository
     */
    InsetCourseService(InsetCourseRepository insetCourseRepository) {
        this.insetCourseRepository = insetCourseRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param insetCourseRepository
     */
    @Override
    @Transactional(readOnly = true)
    InsetCourse findById(Integer id) {
        return insetCourseRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of InsetCourse objects
     * @return a SearchResult set with the list of InsetCourses
     */
    @Override
    @Transactional(readOnly = true)
    List<InsetCourse> findAll() {
        return insetCourseRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete InsetCourse object in the database
     *
     * @param insetCourse the new InsetCourse object to be saved
     * @return the saved version of the InsetCourse object
     */
    @Override
    @Transactional
    public InsetCourse save(InsetCourse insetCourse) {
        return insetCourseRepository.save(insetCourse)
    }
    
    /**
     * This service method is used to create a InsetCourse object in the database from a partial or complete InsetCourse object.
     *
     * @param insetCourse the partial or complete InsetCourse object to be saved
     * @return the saved version of the InsetCourse object
     */
    @Transactional
    public InsetCourse createFromDto(InsetCourseDto insetCourseDto) {
        if (insetCourseDto == null) {
            throw new InvalidDataException("Cannot create insetCourseDto from null object.")
        }
        InsetCourse insetCourse = new InsetCourse()
        insetCourse.courseTitle = insetCourseDto.courseTitle
        insetCourse.courseNotes = insetCourseDto.courseNotes
        insetCourse.startDate = insetCourseDto.startDate
        insetCourse.endDate = insetCourseDto.endDate
        return  save(insetCourse)
    }
    
    /**
     * This service method is used to update a InsetCourse object in the database from a partial or complete InsetCourse object.
     *
     * @param insetCourse the partial or complete InsetCourse object to be saved
     * @return the saved version of the InsetCourse object
     */
    @Transactional
    public InsetCourse updateFromDto(InsetCourseDto insetCourseDto) {
        if (insetCourseDto == null) {
            throw new InvalidDataException("Cannot update insetCourseDto from null object.")
        }
        InsetCourse insetCourse = findById(insetCourseDto.id)
        insetCourse.courseTitle = insetCourseDto.courseTitle
        insetCourse.courseNotes = insetCourseDto.courseNotes
        insetCourse.startDate = insetCourseDto.startDate
        insetCourse.endDate = insetCourseDto.endDate
        return  save(insetCourse)
    }
    
    /**
     * Saves a list of InsetCourse objects to the database
     *
     * @param insetCourses a list of InsetCourses to be saved to the database
     * @return the list of save InsetCourse objects
     */
    @Transactional
    public List<InsetCourse> saveInsetCourses(List<InsetCourse> insetCourses) {
        return insetCourses.collect { insetCourse -> save(insetCourse) };
    }
    /**
     * This methods throws an InvalidOperationException when called. InsetCourse should not be deleted.
     */
    @Override
    public void delete(InsetCourse obj) {
        throw new InvalidOperationException("InsetCourse should not be deleted")
    }
}
