package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.register.Register
import uk.ac.reigate.domain.register.RegisteredSession
import uk.ac.reigate.dto.RegisterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.register.RegisterRepository

@Service
class RegisterService implements ICoreDataService<Register, Integer>, IDtoCreateUpdateService<RegisterDto, Register>{
    
    @Autowired
    RegisterRepository registerRepository
    
    @Autowired
    private final RegisteredSessionService registeredSessionService;
    
    @Autowired
    private final CourseGroupService courseGroupService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default NoArgs constructor
     */
    RegisterService() {}
    
    /**
     * Autowired Constructor
     *
     * @param registerRepository
     */
    RegisterService(RegisterRepository registerRepository, RegisteredSessionService registeredSessionService, CourseGroupService courseGroupService, StaffService staffService) {
        super();
        this.registerRepository = registerRepository;
        this.registeredSessionService = registeredSessionService;
        this.courseGroupService = courseGroupService;
        this.staffService = staffService;
    }
    
    /**
     * Find an individual register using the registers ID fields
     *
     * @param id the ID fields to search for
     * @return the Register object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Register findById(Integer id) {
        return registerRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all registers
     *
     * @return a SearchResult set with the list of Registers
     */
    @Override
    @Transactional(readOnly = true)
    List<Register> findAll() {
        return registerRepository.findAll();
    }
    
    /**
     * This service method is used to create a Register object in the database from a partial or complete Register object.
     *
     * @param register the partial or complete Register object to be saved
     * @return the saved version of the Register object
     */
    @Transactional
    public Register createFromDto(RegisterDto register) {
        if (register == null) {
            throw new InvalidDataException("Cannot create registerDto from null object.")
        }
        Register registerToSave = new Register()
        if(register.sessionId != null) {
            registerToSave.session = registeredSessionService.findById(register.sessionId)
        }
        if(register.courseGroupId != null) {
            registerToSave.courseGroup = courseGroupService.findById(register.courseGroupId)
        }
        registerToSave.completed = register.completed
        if(register.staffCompletedId != null) {
            registerToSave.staffCompleted = staffService.findById(register.staffCompletedId)
        }
        registerToSave.dateCompleted = register.dateCompleted
        return save(registerToSave)
    }
    
    /**
     * This service method is used to update a Register object in the database from a partial or complete Register object.
     *
     * @param register the partial or complete Register object to be saved
     * @return the saved version of the Register object
     */
    @Transactional
    public Register updateFromDto(RegisterDto register) {
        if (register == null) {
            throw new InvalidDataException("Cannot update registerDto from null object.")
        }
        Register registerToSave = findById(register.id)
        if(register.sessionId != null) {
            registerToSave.session = registeredSessionService.findById(register.sessionId)
        }
        if(register.courseGroupId != null) {
            registerToSave.courseGroup = courseGroupService.findById(register.courseGroupId)
        }
        registerToSave.completed = register.completed
        if(register.staffCompletedId != null) {
            registerToSave.staffCompleted = staffService.findById(register.staffCompletedId)
        }
        registerToSave.dateCompleted = register.dateCompleted
        return save(registerToSave)
    }
    
    /**
     * This service method is used to save a complete Register object in the database
     *
     * @param register the new Register object to be saved
     * @return the saved version of the Register object
     */
    @Override
    @Transactional
    public Register save(Register register) {
        return registerRepository.save(register)
    }
    
    /**
     * Saves a list of Register objects to the database
     *
     * @param registers a list of Registers to be saved to the database
     * @return the list of save Register objects
     */
    
    @Transactional
    public List<Register> saveRegisters(List<Register> registers) {
        return registers.collect { register -> save(register) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. QualificationAssessment should not be deleted.
     */
    @Override
    public void delete(Register obj) {
        throw new InvalidOperationException("Register should not be deleted")
        
    }
    
    
    
}
