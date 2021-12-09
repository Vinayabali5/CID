package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Room;
import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.dto.TutorGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.FacultyRepository
import uk.ac.reigate.repositories.lookup.TutorGroupRepository
import uk.ac.reigate.services.student.StudentRemarkPermissionService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

@Service
class TutorGroupService implements ICoreDataService<TutorGroup, Integer>, IDtoCreateUpdateService<TutorGroupDto, TutorGroup>{
    
    @Autowired
    TutorGroupRepository tutorGroupRepository
    
    @Autowired
    private final FacultyService facultyService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final RoomService roomService;
    
    @Autowired
    StudentService studentService
    
    @Autowired
    StudentYearService studentYearService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentRemarkPermissionService studentRemarkPermissionService
    
    
    /**
     * Default NoArgs constructor
     */
    TutorGroupService() {}
    
    /**
     * Autowired Constructor
     *
     * @param tutorGroupRepository
     */
    TutorGroupService(TutorGroupRepository tutorGroupRepository, FacultyService facultyService, StaffService staffService, RoomService roomService, StudentService studentService, StudentYearService studentYearService, AcademicYearService academicYearService, StudentRemarkPermissionService studentRemarkPermissionService) {
        super();
        this.tutorGroupRepository = tutorGroupRepository;
        this.facultyService = facultyService;
        this.staffService = staffService;
        this.roomService = roomService;
        this.studentService = studentService;
        this.studentYearService = studentYearService;
        this.academicYearService = academicYearService;
        this.studentRemarkPermissionService = studentRemarkPermissionService;
    }
    
    /**
     * Find an individual tutorGroup using the tutorGroups ID fields
     *
     * @param id the ID fields to search for
     * @return the TutorGroup object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    TutorGroup findById(Integer id) {
        return tutorGroupRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all tutorGroups
     *
     * @return a SearchResult set with the list of TutorGroups
     */
    @Override
    @Transactional(readOnly = true)
    List<TutorGroup> findAll() {
        return tutorGroupRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete TutorGroup object in the database
     *
     * @param tutorGroup the new TutorGroup object to be saved
     * @return the saved version of the TutorGroup object
     */
    @Override
    @Transactional
    public TutorGroup save(TutorGroup tutorGroup) {
        return tutorGroupRepository.save(tutorGroup)
    }
    
    /**
     * This service method is used to create a TutorGroup object in the database from a partial or complete TutorGroup object.
     *
     * @param tutorGroup the partial or complete TutorGroup object to be saved
     * @return the saved version of the TutorGroup object
     */
    @Transactional
    public TutorGroup createFromDto(TutorGroupDto tutorGroup) {
        if (tutorGroup == null) {
            throw new InvalidDataException("Cannot create tutorGroupDto from null object.")
        }
        TutorGroup tutorGroupToSave = new TutorGroup()
        tutorGroupToSave.code = tutorGroup.code
        tutorGroupToSave.description = tutorGroup.description
        if(tutorGroup.facultyId != null){
            tutorGroupToSave.faculty = facultyService.findById(tutorGroup.facultyId)
        }
        if(tutorGroup.tutorId != null) {
            tutorGroupToSave.tutor = staffService.findById(tutorGroup.tutorId)
        }
        if(tutorGroup.seniorTutorId != null) {
            tutorGroupToSave.seniorTutor = staffService.findById(tutorGroup.seniorTutorId)
        }
        if(tutorGroup.roomId != null){
            tutorGroupToSave.room = roomService.findById(tutorGroup.roomId)
        }
        tutorGroupToSave.inUse = tutorGroup.inUse
        return save(tutorGroupToSave)
    }
    
    /**
     * This service method is used to update a TutorGroup object in the database from a partial or complete TutorGroup object.
     *
     * @param tutorGroup the partial or complete TutorGroup object to be saved
     * @return the saved version of the TutorGroup object
     */
    @Transactional
    public TutorGroup updateFromDto(TutorGroupDto tutorGroup) {
        if (tutorGroup == null) {
            throw new InvalidDataException("Cannot update tutorGroupDto from null object.")
        }
        TutorGroup tutorGroupToSave = findById(tutorGroup.id)
        tutorGroupToSave.code = tutorGroup.code
        tutorGroupToSave.description = tutorGroup.description
        if(tutorGroup.facultyId != null){
            tutorGroupToSave.faculty = facultyService.findById(tutorGroup.facultyId)
        }
        if(tutorGroup.tutorId != null) {
            tutorGroupToSave.tutor = staffService.findById(tutorGroup.tutorId)
        }
        if(tutorGroup.seniorTutorId != null) {
            tutorGroupToSave.seniorTutor = staffService.findById(tutorGroup.seniorTutorId)
        }
        if(tutorGroup.roomId != null){
            tutorGroupToSave.room = roomService.findById(tutorGroup.roomId)
        }
        tutorGroupToSave.inUse = tutorGroup.inUse
        return save(tutorGroupToSave)
    }
    
    /**
     * Saves a list of TutorGroup objects to the database
     *
     * @param tutorGroups a list of TutorGroups to be saved to the database
     * @return the list of save TutorGroup objects
     */
    @Transactional
    public List<TutorGroup> saveTutorGroups(List<TutorGroup> tutorGroups) {
        return tutorGroups.collect { tutorGroup -> save( tutorGroup ) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. TutorGroup should not be deleted.
     */
    @Override
    public void delete(TutorGroup obj) {
        throw new InvalidOperationException("TutorGroup should not be deleted")
    }
    
    /**
     * @param inUse if true returns the valid TutorGroups
     * @return TutorGroups
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<TutorGroup> getValidTutorGroups(Boolean inUse){
        return tutorGroupRepository.findByInUse(inUse)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the tutor for.
     *  
     * @param tutor the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findByTutor(Staff tutor) {
        return tutorGroupRepository.findByTutorAndInUseIsTrue(tutor)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the senior tutor for.
     *  
     * @param seniorTutor the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findBySeniorTutor(Staff seniorTutor) {
        return tutorGroupRepository.findBySeniorTutorAndInUseIsTrue(seniorTutor)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the head of faculty for.
     *
     * @param hof the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findByHeadOfFaculty(Staff hof) {
        return tutorGroupRepository.findByFaculty_HofAndInUseIsTrue(hof)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the director of learning  for.
     *
     * @param dol the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findByDirectorOfLearning(Staff dol) {
        return tutorGroupRepository.findByFaculty_DolAndInUseIsTrue(dol)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the associate director of learning for.
     *
     * @param adol the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findByAssociateDirectorOfLearning(Staff adol) {
        return tutorGroupRepository.findByFaculty_AdolAndInUseIsTrue(adol)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the pastoral director for.
     *
     * @param pd the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findByPastoralDirector(Staff pd) {
        return tutorGroupRepository.findByFaculty_PdAndInUseIsTrue(pd)
    }
    
    /**
     * This method is used to retrieve a list of tutor groups that the specified member of staff is the associate pastoral director for.
     *
     * @param apd the member of staff to use for the search
     * @return a List of TutorGroup objects
     */
    public List<TutorGroup> findByAssoicatePastoralDirector(Staff apd) {
        return tutorGroupRepository.findByFaculty_ApdAndInUseIsTrue(apd)
    }
}
