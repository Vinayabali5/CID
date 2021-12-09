package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.YearGroup
import uk.ac.reigate.dto.CourseGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.predicates.CourseGroupPredicates
import uk.ac.reigate.repositories.academic.CourseGroupRepository
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.ilp.ILPInterviewService

@Service
class CourseGroupService implements ICoreDataService<CourseGroup, Integer>, IDtoCreateUpdateService<CourseGroupDto, CourseGroup> {
    
    @Autowired
    CourseGroupRepository courseGroupRepository
    
    @Autowired
    private final YearGroupService yearGroupService;
    
    @Autowired
    private final CourseService courseService;
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    @Autowired
    private final DepartmentService departmentService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final EnrolmentService enrolmentService;
    
    @Autowired
    private final TimetableService timetableService;
    
    @Autowired
    private final ILPInterviewService iLPInterviewService;
    
    /**
     * Default NoArgs constructor
     */
    CourseGroupService() {}
    
    /**
     * Autowired Constructor
     *
     * @param courseGroupRepository
     */
    CourseGroupService(CourseGroupRepository courseGroupRepository, YearGroupService yearGroupService, CourseService courseService, AcademicYearService academicYearService, DepartmentService departmentService, StaffService staffService, EnrolmentService enrolmentService, TimetableService timetableService, ILPInterviewService iLPInterviewService) {
        super();
        this.courseGroupRepository = courseGroupRepository;
        this.yearGroupService = yearGroupService;
        this.courseService = courseService;
        this.academicYearService = academicYearService;
        this.departmentService = departmentService;
        this.staffService= staffService;
        this.enrolmentService = enrolmentService;
        this.timetableService = timetableService;
        this.iLPInterviewService = iLPInterviewService;
    }
    
    /**
     * Find an individual courseGroup using the courseGroups ID fields
     *
     * @param id the ID fields to search for
     * @return the CourseGroup object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    CourseGroup findById(Integer id) {
        return courseGroupRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to find the course groups that a member of staff is the teacher of by their staffId.
     * 
     * @param teacherId the staffId for the teacher to find. 
     * @param yearId the yearId to use for the search.
     * @return a List of CourseGroup objects.
     */
    @Transactional(readOnly = true)
    List<CourseGroup> findByTeacherAndYear(Integer teacherId, Integer yearId) {
        return courseGroupRepository.findDistinctCourseGroupByTimetable_TeacherIdAndYear_Id(teacherId, yearId)
    }
    
    /**
     * This method is used to find the course groups that a member of staff is the course leader of by their staffId.
     * 
     * @param courseLeaderId the staffId for the course leader to find. 
     * @param yearId the yearId to use for the search.
     * @return a List of CourseGroup objects.
     */
    @Transactional(readOnly = true)
    List<CourseGroup> findByCourseLeaderAndYear(Integer courseLeaderId, Integer yearId) {
        return courseGroupRepository.findByCourseLeader_IdAndYear_Id(courseLeaderId, yearId)
    }
    
    /**
     * This method is used to find the course groups that a member of staff is the course leader of by their staffId.
     * 
     * @param hodId the staffId for the course leader to find.
     * @param yearId the yearId to use for the search.
     * @return a List of CourseGroup objects.
     */
    @Transactional(readOnly = true)
    List<CourseGroup> findByHodAndYear(Integer hodId, Integer yearId) {
        List<CourseGroup> courseGroups = new ArrayList<CourseGroup>()
        courseGroups.addAll(courseGroupRepository.findByDepartment_Hod_IdAndYear_Id(hodId, yearId))
        courseGroups.addAll(courseGroupRepository.findByDepartment_Hod2_IdAndYear_Id(hodId, yearId))
        return courseGroups
    }
    
    /**
     * This service method is used to create a CourseGroup object in the database from a partial or complete CourseGroup object.
     *
     * @param courseGroup the partial or complete CourseGroup object to be saved
     * @return the saved version of the CourseGroup object
     */
    @Transactional
    public CourseGroup createFromDto(CourseGroupDto courseGroup) {
        if (courseGroup == null) {
            throw new InvalidDataException("Cannot create CourseGroup from null object.")
        }
        YearGroup yearGroup
        if(courseGroup.yearGroupId != null) {
            yearGroup = yearGroupService.findById(courseGroup.yearGroupId)
        }
        Course course
        if(courseGroup.courseId != null){
            course = courseService.findById(courseGroup.courseId)
        }
        AcademicYear year
        if(courseGroup.yearId != null){
            year = academicYearService.findById(courseGroup.yearId)
        }
        Department department
        if(courseGroup.departmentId != null){
            department = departmentService.findById(courseGroup.departmentId)
        }
        Staff courseLeader
        if(courseGroup.courseLeaderId != null){
            courseLeader = staffService.findById(courseGroup.courseLeaderId)
        }
        CourseGroup courseGroupToSave = new CourseGroup()
        courseGroupToSave.yearGroup = yearGroup
        courseGroupToSave.course = course
        courseGroupToSave.year= year
        courseGroupToSave.code = courseGroup.code;
        courseGroupToSave.startDate = courseGroup.startDate;
        courseGroupToSave.endDate = courseGroup.endDate;
        courseGroupToSave.department = department
        courseGroupToSave.courseLeader = courseLeader
        courseGroupToSave.displayOnTimetable = courseGroup.displayOnTimetable;
        courseGroupToSave.hasRegister = courseGroup.hasRegister;
        courseGroupToSave.notes = courseGroup.notes;
        courseGroupToSave.spec = courseGroup.spec;
        courseGroupToSave.plh = courseGroup.plh;
        courseGroupToSave.peeph = courseGroup.peeph;
        courseGroupToSave.nested = courseGroup.nested;
        courseGroupToSave.excludeFromAllocation = courseGroup.excludeFromAllocation;
        courseGroupToSave.excludeFromIR = courseGroup.excludeFromIR;
        courseGroupToSave.ilrReturn = courseGroup.ilrReturn;
        return save(courseGroupToSave)
    }
    
    /**
     * This service method is used to update a CourseGroup object in the database from a partial or complete CourseGroup object.
     *
     * @param courseGroup the partial or complete CourseGroup object to be saved
     * @return the saved version of the CourseGroup object
     */
    @Transactional
    public CourseGroup updateFromDto(CourseGroupDto courseGroup) {
        if (courseGroup == null) {
            throw new InvalidDataException("Cannot update CourseGroup from null object.")
        }
        CourseGroup courseGroupToSave = findById(courseGroup.id)
        if(courseGroup.yearGroupId != null) {
            courseGroupToSave.yearGroup = yearGroupService.findById(courseGroup.yearGroupId)
        }
        if(courseGroup.courseId != null){
            courseGroupToSave.course = courseService.findById(courseGroup.courseId)
        }
        if(courseGroup.yearId != null){
            courseGroupToSave.year = academicYearService.findById(courseGroup.yearId)
        }
        if(courseGroup.departmentId != null){
            courseGroupToSave.department = departmentService.findById(courseGroup.departmentId)
        }
        if(courseGroup.courseLeaderId != null){
            courseGroupToSave.courseLeader = staffService.findById(courseGroup.courseLeaderId)
        }
        courseGroupToSave.code = courseGroup.code;
        courseGroupToSave.startDate = courseGroup.startDate;
        courseGroupToSave.endDate = courseGroup.endDate;
        courseGroupToSave.displayOnTimetable = courseGroup.displayOnTimetable;
        courseGroupToSave.hasRegister = courseGroup.hasRegister;
        courseGroupToSave.notes = courseGroup.notes;
        courseGroupToSave.spec = courseGroup.spec;
        courseGroupToSave.plh = courseGroup.plh;
        courseGroupToSave.peeph = courseGroup.peeph;
        courseGroupToSave.nested = courseGroup.nested;
        courseGroupToSave.excludeFromAllocation = courseGroup.excludeFromAllocation;
        courseGroupToSave.excludeFromIR = courseGroup.excludeFromIR;
        courseGroupToSave.excludeFromExams = courseGroup.excludeFromExams
        courseGroupToSave.ilrReturn = courseGroup.ilrReturn;
        return save(courseGroupToSave)
    }
    
    /**
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public CourseGroup getByAcademicYear(AcademicYear year) {
        return courseGroupRepository.findByYear(year)
    }
    
    /**
     * Find all courseGroups
     *
     * @return a List of CourseGroups
     */
    @Override
    @Transactional(readOnly = true)
    List<CourseGroup> findAll() {
        return courseGroupRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CourseGroup object in the database
     *
     * @param courseGroup the new CourseGroup object to be saved
     * @return the saved version of the CourseGroup object
     */
    @Override
    @Transactional
    public CourseGroup save(CourseGroup courseGroup) {
        return courseGroupRepository.save(courseGroup)
    }
    
    /**
     * Saves a list of CourseGroup objects to the database
     *
     * @param courseGroups a list of CourseGroups to be saved to the database
     * @return the list of save CourseGroup objects
     */
    @Transactional
    public List<CourseGroup> saveCourseGroups(List<CourseGroup> courseGroups) {
        return courseGroups.collect { courseGroup -> save(courseGroup ) };
    }
    
    /** Retrieves CourseGroup by courseId and year
     * @param courseId
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<CourseGroup> searchBycourseAndYear(Integer courseId, AcademicYear year){
        List<CourseGroup> courseGroups = courseGroupRepository.findByCourse_IdAndYear(courseId, year)
        return courseGroups
    }
    
    /** Retrieves List of CourseGroup by courseId
     * @param courseId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<CourseGroup> searchByCourse(Integer courseId){
        List<CourseGroup> courseGroups = courseGroupRepository.findByCourse_Id(courseId)
        return courseGroups
    }
    
    /**  Retrieves List of CourseGroup by year and spec
     * @param year
     * @param spec
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <CourseGroup> searchByYearAndSpec(AcademicYear year, String spec){
        List<CourseGroup> courseGroup = courseGroupRepository.findByYearAndSpecLike(year, spec);
        return courseGroup;
    }
    
    /**  Retrieves List of CourseGroup by yearId , courseId and spec
     * @param yearId
     * @param courseId
     * @param spec
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List <CourseGroup> searchByYearAndCourseIdAndSpec(Integer yearId, Integer courseId, String spec){
        List<CourseGroup> courseGroup = courseGroupRepository.findByYear_IdAndCourse_IdAndSpec(yearId, courseId, spec);
        return courseGroup;
    }
    
    /**  Retrieves List of CourseGroup by year
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<CourseGroup> searchByYear(AcademicYear year) {
        List<CourseGroup> courseGroups = courseGroupRepository.findCourseGroupYear(year.id);
        return courseGroups;
    }
    
    /** Retrieves List of Enrolment by courseGroupId
     * @param courseGroupId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Enrolment> getCourseGroupEnrolments(Integer courseGroupId) {
        return enrolmentService.findByCourseGroup(courseGroupId);
    }
    
    /** Retrieves List of CourseGroup by yearId
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<CourseGroup> getCourseGroupsByYearId(Integer yearId){
        List<CourseGroup> courseGroups = courseGroupRepository.findAll(CourseGroupPredicates.courseGroupValidInYear(yearId))
        return courseGroups;
    }
    
    /** Retrieves CourseGroup by yearId and courseGroupId
     * @param courseGroupId
     * @param yearId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public CourseGroup getCourseGroupByIdYearId(Integer courseGroupId , Integer yearId){
        CourseGroup courseGroup = courseGroupRepository.findCourseGroupByIdYearId(courseGroupId, yearId)
        return courseGroup;
    }
    /**
     * This methods throws an InvalidOperationException when called. CourseGroup should not be deleted.
     */
    @Override
    public void delete(CourseGroup obj) {
        throw new InvalidOperationException("CourseGroup should not be deleted")
    }
    
    public List<CourseGroup> findByStudent(Student student) {
        return courseGroupRepository.findByStudent(student)
    }
    
    public List<CourseGroup> findByStudentAndYear(Student student, AcademicYear year) {
        return courseGroupRepository.findByStudentAndYear(student, year)
    }
}
