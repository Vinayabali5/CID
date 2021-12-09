package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.dto.StaffDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.services.ilr.EthnicityService
import uk.ac.reigate.services.lookup.StaffTypeService
import uk.ac.reigate.services.staff.DisabilityService
import uk.ac.reigate.services.staff.MaritalStatusService
import uk.ac.reigate.services.staff.ReligionService
import uk.ac.reigate.services.staff.SexualOrientationService

@Service
class StaffService implements ICoreDataService<Staff, Integer>, IDtoCreateUpdateService<StaffDto, Staff>{
    
    @Autowired
    StaffRepository staffRepository
    
    @Autowired
    private final PersonService personService;
    
    @Autowired
    private final StaffTypeService staffTypeService;
    
    @Autowired
    private final EthnicityService ethnicityService
    
    @Autowired
    private final DisabilityService disabilityService
    
    @Autowired
    private final SexualOrientationService sexualOrientationService
    
    @Autowired
    private final MaritalStatusService maritalStatusService
    
    @Autowired
    private final ReligionService religionService
    
    /**
     * Default NoArgs constructor
     */
    StaffService() {}
    
    /**
     * Autowired constructor
     * 
     * @param staffRepository
     */
    StaffService(StaffRepository staffRepository, PersonService personService, StaffTypeService staffTypeService, EthnicityService ethnicityService, DisabilityService disabilityService, SexualOrientationService sexualOrientationService, MaritalStatusService maritalStatusService, ReligionService religionService ) {
        this.staffRepository = staffRepository;
        this.personService = personService;
        this.staffTypeService = staffTypeService;
        this.ethnicityService = ethnicityService;
        this.disabilityService = disabilityService;
        this.sexualOrientationService = sexualOrientationService;
        this.maritalStatusService = maritalStatusService;
        this.religionService = religionService;
    }
    
    /**
     * The findStaff(id) method is the singular form of the service method to retrieve an individual member of staff.
     * 
     * @param id the id of the member of staff to retrieve
     * @return the Staff object identified by the id
     */
    @Override
    @Transactional(readOnly = true)
    Staff findById(Integer id) {
        return staffRepository.findById(id).orElse(null)
    }
    
    /**
     * The findStaff() method is the pluralised form of the service method to retrieve multiple members of staff.
     * 
     * @return A List of Staff objects
     */
    @Override
    @Transactional(readOnly = true)
    List<Staff> findAll() {
        List<Staff> staff = staffRepository.findByType_NeedInitialsTrue();
        return staff;
    }
    
    /**
     * This service method is used to retrieve a page of Staff from the database. 
     *     
     * @param page The page information to be used for retrieval
     * @return A SearchResult object with the desired Staff objects.
     */
    @Transactional(readOnly = true)
    Page<Staff> findStaffByPage(Pageable page) {
        Page<Staff> results = staffRepository.findAll(page);
        return results
    }
    
    /**
     * This service method is used to save a complete Staff object in the database
     *
     * @param staff the new Staff object to be saved
     * @return the saved version of the Staff object
     */
    @Override
    @Transactional
    public Staff save(Staff staff) {
        return staffRepository.save(staff)
    }
    
    /**
     * Saves a list of Staff objects to the database
     *
     * @param staffs a list of Staffs to be saved to the database
     * @return the list of save Staff objects
     */
    @Transactional
    public List<Staff> saveStaffs(List<Staff> staffs) {
        return staffs.collect { staff -> save( staff ) };
    }
    
    /**
     * This service method is used to retrieve all the Staff objects for those members of staff that are current. This 
     * means that their end date is set to null.
     * 
     * @param id 
     * @return
     */
    @Transactional(readOnly = true)
    List<Staff> findStaffCurrent() {
        return staffRepository.findAllCurrent();
    }
    
    /**
     * This service method is used to create a Staff object in the database from Staff object
     * 
     * @param staff the Staff object to be loaded
     * @return the saved version of the staff object
     */
    @Transactional
    public Staff createFromDto(StaffDto staff) {
        if (staff == null) {
            throw new InvalidDataException("Cannot create staffDto from null object.")
        }
        Staff staffToSave = new Staff()
        if(staff.personId != null){
            staffToSave.person = personService.findById(staff.personId)
        }
        if(staff.typeId != null){
            staffToSave.type = staffTypeService.findById(staff.typeId)
        }
        staffToSave.onTimetable = staff.onTimetable
        staffToSave.initials = staff.initials
        staffToSave.knownAs = staff.knownAs
        staffToSave.networkLogin = staff.networkLogin
        staffToSave.startDate = staff.startDate
        staffToSave.endDate = staff.endDate
        staffToSave.staffRef = staff.staffRef
        staffToSave.staffDetailsId = staff.staffDetailsId
        staffToSave.staffEmail = staff.StaffEmail
        staffToSave.signature = staff.signature
        return save(staffToSave)
    }
    
    /**
     * This service method is used to update a Staff object in the database from Staff object
     *
     * @param staff the Staff object to be loaded
     * @return the saved version of the staff object
     */
    @Transactional
    public Staff updateFromDto(StaffDto staff) {
        if (staff == null) {
            throw new InvalidDataException("Cannot update staffDto from null object.")
        }
        Staff staffToSave = findById(staff.id)
        if(staff.personId != null){
            staffToSave.person = personService.findById(staff.personId)
        }
        if(staff.typeId != null){
            staffToSave.type = staffTypeService.findById(staff.typeId)
        }
        staffToSave.onTimetable = staff.onTimetable
        staffToSave.initials = staff.initials
        staffToSave.knownAs = staff.knownAs
        staffToSave.networkLogin = staff.networkLogin
        staffToSave.startDate = staff.startDate
        staffToSave.endDate = staff.endDate
        staffToSave.staffRef = staff.staffRef
        staffToSave.staffDetailsId = staff.staffDetailsId
        staffToSave.staffEmail = staff.StaffEmail
        staffToSave.signature = staff.signature
        staffToSave.nationality = staff.nationality
        if(staff.ethnicityId != null){
            staffToSave.ethnicity = ethnicityService.findById(staff.ethnicityId)
        }
        if(staff.disabilityId != null){
            staffToSave.disability = disabilityService.findById(staff.disabilityId)
        }
        if(staff.sexualOrientationId != null){
            staffToSave.sexualOrientation = sexualOrientationService.findById(staff.sexualOrientationId)
        }
        if(staff.maritalStatusId != null){
            staffToSave.maritalStatus = maritalStatusService.findById(staff.maritalStatusId)
        }
        if(staff.religionId != null){
            staffToSave.religion = religionService.findById(staff.religionId)
        }
        return save(staffToSave)
    }
    
    /**
     * This service method is used to retrieve a pageable list of the Staff objects for those members of staff that 
     * are current. This means that their end date is set to null.
     * 
     * @param page The page information for the section of data to retrieve
     * @return 
     */
    @Transactional(readOnly = true)
    Page<Staff> findStaffCurrent(Pageable page) {
        return staffRepository.findAllCurrent(page);
    }
    
    
    /**
     * @param person
     * @return
     */
    Staff findByPerson(Person person) {
        return staffRepository.findByPerson(person);
    }
    
    List<Staff> findTeachers(CourseGroup courseGroup) {
        return staffRepository.findTeacherByCourseGroup(courseGroup);
    }
    /**
     * This methods throws an InvalidOperationException when called. QualificationAssessment should not be deleted.
     */
    @Override
    public void delete(Staff obj) {
        throw new InvalidOperationException("Staff should not be deleted")
    }
}
