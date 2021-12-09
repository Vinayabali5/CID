package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Timetable
import uk.ac.reigate.dto.TimetableDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.TimetableRepository

@Service
class TimetableService implements ICoreDataService<Timetable, Integer>, IDtoCreateUpdateService<TimetableDto, Timetable>{
    
    @Autowired
    TimetableRepository timetableRepository
    
    @Autowired
    private final CourseGroupService courseGroupService;
    
    @Autowired
    private final PeriodService periodService;
    
    @Autowired
    private final RoomService roomService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default NoArgs constructor
     */
    TimetableService() {}
    
    /**
     * Autowired Constructor
     *
     * @param timetableRepository
     */
    TimetableService(TimetableRepository timetableRepository, CourseGroupService courseGroupService, PeriodService periodService, RoomService roomService, StaffService staffService) {
        super();
        this.timetableRepository = timetableRepository;
        this.courseGroupService = courseGroupService;
        this.periodService = periodService;
        this.roomService = roomService;
        this.staffService = staffService;
    }
    
    /**
     * Find an individual timetable using the timetables ID fields
     *
     * @param id the ID fields to search for
     * @return the Timetable object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Timetable findById(Integer id) {
        return timetableRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all timetables
     *
     * @return a List of Timetables
     */
    @Override
    @Transactional(readOnly = true)
    List<Timetable> findAll() {
        List<Timetable> timetables = timetableRepository.findAll();
        return timetables
    }
    
    
    /**
     * This service method is used to save a complete Timetable object in the database
     *
     * @param timetable the new Timetable object to be saved
     * @return the saved version of the Timetable object
     */
    @Override
    @Transactional
    public Timetable save(Timetable timetable) {
        return timetableRepository.save(timetable)
    }
    
    /**
     * This service method is used to create a Timetable object in the database from a partial or complete Timetable object.
     *
     * @param timetable the partial or complete Timetable object to be saved
     * @return the saved version of the Timetable object
     */
    @Transactional
    public Timetable createFromDto(TimetableDto timetable) {
        if (timetable == null) {
            throw new InvalidDataException("Cannot create timetableDto from null object.")
        }
        Timetable timetableToSave = new Timetable()
        if (timetable.courseGroupId != null) {
            timetableToSave.courseGroup = courseGroupService.findById(timetable.courseGroupId)
        }
        if (timetable.periodId != null) {
            timetableToSave.period = periodService.findById(timetable.periodId)
        }
        if (timetable.roomId != null) {
            timetableToSave.room = roomService.findById(timetable.roomId)
        }
        if (timetable.teacherId != null) {
            timetableToSave.teacher = staffService.findById(timetable.teacherId)
        }
        timetableToSave.validFrom = timetable.validFrom
        timetableToSave.validTo = timetable.validTo
        return save(timetableToSave)
    }
    
    /**
     * This service method is used to update a Timetable object in the database from a partial or complete Timetable object.
     *
     * @param timetable the partial or complete Timetable object to be saved
     * @return the saved version of the Timetable object
     */
    @Transactional
    public Timetable updateFromDto(TimetableDto timetable) {
        if (timetable == null) {
            throw new InvalidDataException("Cannot update timetableDto from null object.")
        }
        Timetable timetableToSave = findById(timetable.id)
        if (timetable.courseGroupId != null) {
            timetableToSave.courseGroup = courseGroupService.findById(timetable.courseGroupId)
        }
        if (timetable.periodId != null) {
            timetableToSave.period = periodService.findById(timetable.periodId)
        }
        if (timetable.roomId != null) {
            timetableToSave.room = roomService.findById(timetable.roomId)
        }
        if (timetable.teacherId != null) {
            timetableToSave.teacher = staffService.findById(timetable.teacherId)
        }
        timetableToSave.validFrom = timetable.validFrom
        timetableToSave.validTo = timetable.validTo
        return save(timetableToSave)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Timetable should not be deleted.
     */
    @Override
    public void delete(Timetable timetable) {
        throw new InvalidOperationException("Timetable should not be deleted")
    }
    
    public void delete(Integer timetableId) {
        timetableRepository.deleteById(timetableId)
    }
    
    public List<Timetable> getStaffTimetable(AcademicYear year, Staff staff) {
        return timetableRepository.findByCourseGroup_YearAndTeacher(year, staff)
    }
    
    public List<Timetable> getStaffTimetableCurrent(AcademicYear year, Staff staff) {
        return timetableRepository.findByYearAndTeacherCurrent(year, staff)
    }
    
    public List<Timetable> getStaffTimetableOnDate(AcademicYear year, Staff staff, Date date) {
        return timetableRepository.findByYearAndTeacherOnDate(year, staff, date)
    }
    
    public List<Timetable> getCourseGroupsByYearId(Integer yearId, Integer courseGroupId) {
        return timetableRepository.findByCourseGroup_Year_IdAndCourseGroup_Id(yearId, courseGroupId)
    }
}
