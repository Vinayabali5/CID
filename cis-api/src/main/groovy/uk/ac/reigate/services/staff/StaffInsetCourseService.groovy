package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.StaffAbsence
import uk.ac.reigate.domain.staff.StaffInsetCourse
import uk.ac.reigate.dto.staff.StaffInsetCourseDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.StaffInsetCourseRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StaffInsetCourseService implements ICoreDataService<StaffInsetCourse, Integer>, IDtoCreateUpdateService<StaffInsetCourseDto, StaffInsetCourse>{
    
    @Autowired
    StaffInsetCourseRepository staffInsetCourseRepository
    
    /**
     * Default NoArgs constructor
     */
    StaffInsetCourseService() {}
    
    /**
     * Autowired Constructor
     *
     * @param staffInsetCourseRepository
     */
    StaffInsetCourseService(StaffInsetCourseRepository staffInsetCourseRepository) {
        this.staffInsetCourseRepository = staffInsetCourseRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param staffInsetCourseRepository
     */
    @Override
    @Transactional(readOnly = true)
    StaffInsetCourse findById(Integer id) {
        return staffInsetCourseRepository.findById(id).orElse(null)
    }
    
    List<StaffInsetCourse> findByStaffId(Integer staffId) {
        return staffInsetCourseRepository.findByStaff_Id(staffId)
    }
    /**
     * Find a single page of StaffInsetCourse objects
     * @return a SearchResult set with the list of StaffInsetCourses
     */
    @Override
    @Transactional(readOnly = true)
    List<StaffInsetCourse> findAll() {
        return staffInsetCourseRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StaffInsetCourse object in the database
     *
     * @param staffInsetCourse the new StaffInsetCourse object to be saved
     * @return the saved version of the StaffInsetCourse object
     */
    @Override
    @Transactional
    public StaffInsetCourse save(StaffInsetCourse staffInsetCourse) {
        return staffInsetCourseRepository.save(staffInsetCourse)
    }
    
    /**
     * This service method is used to create a StaffInsetCourse object in the database from a partial or complete StaffInsetCourse object.
     *
     * @param staffInsetCourse the partial or complete StaffInsetCourse object to be saved
     * @return the saved version of the StaffInsetCourse object
     */
    @Transactional
    public StaffInsetCourse createFromDto(StaffInsetCourseDto staffInsetCourseDto) {
        if (staffInsetCourseDto == null) {
            throw new InvalidDataException("Cannot create staffInsetCourseDto from null object.")
        }
        StaffInsetCourse staffInsetCourse = new StaffInsetCourse()
        staffInsetCourse.hours = staffInsetCourseDto.hours
        staffInsetCourse.startDate = staffInsetCourseDto.startDate
        staffInsetCourse.endDate = staffInsetCourseDto.endDate
        return  save(staffInsetCourse)
    }
    
    /**
     * This service method is used to update a StaffInsetCourse object in the database from a partial or complete StaffInsetCourse object.
     *
     * @param staffInsetCourse the partial or complete StaffInsetCourse object to be saved
     * @return the saved version of the StaffInsetCourse object
     */
    @Transactional
    public StaffInsetCourse updateFromDto(StaffInsetCourseDto staffInsetCourseDto) {
        if (staffInsetCourseDto == null) {
            throw new InvalidDataException("Cannot update staffInsetCourseDto from null object.")
        }
        StaffInsetCourse staffInsetCourse = findById(staffInsetCourseDto.id)
        staffInsetCourse.hours = staffInsetCourseDto.hours
        staffInsetCourse.startDate = staffInsetCourseDto.startDate
        staffInsetCourse.endDate = staffInsetCourseDto.endDate
        return  save(staffInsetCourse)
    }
    
    /**
     * Saves a list of StaffInsetCourse objects to the database
     *
     * @param staffInsetCourses a list of StaffInsetCourses to be saved to the database
     * @return the list of save StaffInsetCourse objects
     */
    @Transactional
    public List<StaffInsetCourse> saveStaffInsetCourses(List<StaffInsetCourse> staffInsetCourses) {
        return staffInsetCourses.collect { staffInsetCourse -> save(staffInsetCourse) };
    }
    /**
     * This methods throws an InvalidOperationException when called. StaffInsetCourse should not be deleted.
     */
    @Override
    public void delete(StaffInsetCourse obj) {
        throw new InvalidOperationException("StaffInsetCourse should not be deleted")
    }
}
