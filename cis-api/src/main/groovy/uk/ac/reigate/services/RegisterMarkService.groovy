package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.register.RegisterMark
import uk.ac.reigate.dto.RegisterMarkDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.register.RegisterMarkRepository
import uk.ac.reigate.services.student.StudentService

@Service
class RegisterMarkService implements ICoreDataService<RegisterMark, Integer>, IDtoCreateUpdateService<RegisterMarkDto, RegisterMark>{
    
    @Autowired
    RegisterMarkRepository registerMarkRepository
    
    @Autowired
    private final RegisterService registerService;
    
    @Autowired
    private final CourseGroupService courseGroupService;
    
    @Autowired
    private final CourseService courseService;
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final AttendanceCodeService attendanceCodeService;
    
    /**
     * Default NoArgs constructor
     */
    RegisterMarkService() {}
    
    /**
     * Autowired Constructor
     *
     * @param registerMarkRepository
     */
    RegisterMarkService(RegisterMarkRepository registerMarkRepository, RegisterService registerService, CourseGroupService courseGroupService, CourseService courseService, StudentService studentService, StaffService staffService, AttendanceCodeService attendanceCodeService) {
        this.registerMarkRepository = registerMarkRepository;
        this.registerService = registerService;
        this.courseGroupService = courseGroupService;
        this.courseService = courseService;
        this.studentService = studentService;
        this.staffService = staffService;
        this.attendanceCodeService = attendanceCodeService;
    }
    
    /**
     * Find an individual registerMark using the registerMarks ID fields
     *
     * @param id the ID fields to search for
     * @return the RegisterMark object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    RegisterMark findById(Integer id) {
        return registerMarkRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all registerMarks
     *
     * @return a List of RegisterMarks
     */
    @Override
    @Transactional(readOnly = true)
    List<RegisterMark> findAll() {
        return registerMarkRepository.findAll();
    }
    
    /**
     * This service method is used to create a RegisterMark object in the database from a partial or complete RegisterMark object.
     *
     * @param registerMark the partial or complete RegisterMark object to be saved
     * @return the saved version of the RegisterMark object
     */
    @Transactional
    public RegisterMark createFromDto(RegisterMarkDto registerMark) {
        if (registerMark == null) {
            throw new InvalidDataException("Cannot create regiaterMarkDto from null object.")
        }
        RegisterMark registerMarkToSave = new RegisterMark()
        if(registerMark.courseId != null) {
            registerMarkToSave.course = courseService.findById(registerMark.courseId)
        }
        if(registerMark.courseGroupId != null) {
            registerMarkToSave.courseGroup = courseGroupService.findById(registerMark.courseGroupId)
        }
        if(registerMark.registerId != null) {
            registerMarkToSave.register = registerService.findById(registerMark.registerId)
        }
        if(registerMark.studentId != null) {
            registerMarkToSave.student = studentService.findById(registerMark.studentId)
        }
        if(registerMark.attendanceCodeId != null) {
            registerMarkToSave.attendanceCode = attendanceCodeService.findById(registerMark.attendanceCodeId)
        }
        return save(registerMarkToSave)
    }
    
    /**
     * This service method is used to create a RegisterMark object in the database from a partial or complete RegisterMark object.
     *
     * @param registerMark the partial or complete RegisterMark object to be saved
     * @return the saved version of the RegisterMark object
     */
    @Transactional
    public RegisterMark updateFromDto(RegisterMarkDto registerMark) {
        if (registerMark == null) {
            throw new InvalidDataException("Cannot update regiaterMarkDto from null object.")
        }
        RegisterMark registerMarkToSave = findById(registerMark.id)
        if(registerMark.courseId != null) {
            registerMarkToSave.course = courseService.findById(registerMark.courseId)
        }
        if(registerMark.courseGroupId != null) {
            registerMarkToSave.courseGroup = courseGroupService.findById(registerMark.courseGroupId)
        }
        if(registerMark.registerId != null) {
            registerMarkToSave.register = registerService.findById(registerMark.registerId)
        }
        if(registerMark.studentId != null) {
            registerMarkToSave.student = studentService.findById(registerMark.studentId)
        }
        if(registerMark.attendanceCodeId != null) {
            registerMarkToSave.attendanceCode = attendanceCodeService.findById(registerMark.attendanceCodeId)
        }
        return save(registerMarkToSave)
    }
    
    /**
     * This service method is used to save a complete RegisterMark object in the database
     *
     * @param registerMark the new RegisterMark object to be saved
     * @return the saved version of the RegisterMark object
     */
    @Override
    @Transactional
    public RegisterMark save(RegisterMark registerMark) {
        return registerMarkRepository.save(registerMark)
    }
    
    /**
     * Saves a list of RegisterMark objects to the database
     *
     * @param registerMarks a list of RegisterMarks to be saved to the database
     * @return the list of save RegisterMark objects
     */
    @Transactional
    public List<RegisterMark> saveRegisterMarks(List<RegisterMark> registerMarks) {
        return registerMarks.collect { registerMark -> save(registerMark) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. QualificationAssessment should not be deleted.
     */
    @Override
    public void delete(RegisterMark obj) {
        throw new InvalidOperationException("RegisterMark should not be deleted")
    }
}
