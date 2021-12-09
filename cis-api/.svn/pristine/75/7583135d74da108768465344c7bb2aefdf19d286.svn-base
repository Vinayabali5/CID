package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.cristal.MasterRegister
import uk.ac.reigate.dto.MasterRegisterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.cristal.MasterRegisterRepository
import uk.ac.reigate.repositories.register.AttendanceCodeRepository
import uk.ac.reigate.services.student.StudentService

@Service
@RequiredArgsConstructor
class MasterRegisterService implements ICoreDataService<MasterRegister, Integer>, IDtoCreateUpdateService<MasterRegisterDto, MasterRegister>{
    
    @Autowired
    MasterRegisterRepository masterRegisterRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final AttendanceCodeService attendanceCodeService;
    
    @Autowired
    private final AcademicYearService academicYearService
    /**
     * Default NoArgs constructor
     */
    MasterRegisterService() {}
    
    /**
     * Autowired Constructor
     *
     * @param masterRegisterRepository
     */
    MasterRegisterService(MasterRegisterRepository masterRegisterRepository, StudentService studentService, AttendanceCodeService attendanceCodeService, AcademicYearService academicYearService) {
        super()
        this.masterRegisterRepository = masterRegisterRepository;
        this.studentService= studentService;
        this.attendanceCodeService = attendanceCodeService;
        this.academicYearService = academicYearService
    }
    /**
     * Find an individual MasterRegister using the MasterRegister ID fields
     *
     * @param id the ID fields to search for
     * @return the MasterRegister object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    MasterRegister findById(Integer id) {
        return masterRegisterRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of MasterRegister objects
     * @return a SearchResult set with the list of MasterRegisters
     */
    @Override
    @Transactional(readOnly = true)
    List<MasterRegister> findAll() {
        return masterRegisterRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete MasterRegister object in the database
     *
     * @param masterRegister the new MasterRegister object to be saved
     * @return the saved version of the MasterRegister object
     */
    @Override
    @Transactional
    public MasterRegister save(MasterRegister masterRegister) {
        return masterRegisterRepository.save(masterRegister)
    }
    
    /**
     * This service method is used to update a MasterRegister object in the database from a partial or complete MasterRegister object.
     *
     * @param masterRegister the partial or complete MasterRegister object to be saved
     * @return the saved version of the MasterRegister object
     */
    @Transactional
    public MasterRegister createFromDto(MasterRegisterDto masterRegister) {
        if (masterRegister == null) {
            throw new InvalidDataException("Cannot create masterRegister from null object.")
        }
        MasterRegister masterRegisterToSave = new MasterRegister()
        if(masterRegister.studentId != null) {
            masterRegisterToSave.student = studentService.findById(masterRegister.studentId)
        }
        if(masterRegister.attendanceId != null){
            masterRegisterToSave.attendance = attendanceCodeService.findById(masterRegister.attendanceId)
        }
        masterRegisterToSave.sessionRef = masterRegister.sessionRef
        masterRegisterToSave.subjectCode = masterRegister.subjectCode
        masterRegisterToSave.group = masterRegister.group
        if(masterRegister.academicYearId != null) {
            masterRegisterToSave.academicYear = academicYearService.findById(masterRegister.academicYearId)
        }
        masterRegisterToSave.notes = masterRegister.notes
        return save(masterRegisterToSave)
    }
    
    /**
     * This service method is used to update a MasterRegister object in the database from a partial or complete MasterRegister object.
     *
     * @param masterRegister the partial or complete MasterRegister object to be saved
     * @return the saved version of the MasterRegister object
     */
    @Transactional
    public MasterRegister updateFromDto(MasterRegisterDto masterRegister) {
        if (masterRegister == null) {
            throw new InvalidDataException("Cannot update masterRegister from null object.")
        }
        if(masterRegister.id == null) {
            throw new InvalidDataException("Cannot update masterRegister from null Id.")
        }
        MasterRegister masterRegisterToSave = findById(masterRegister.id)
        if(masterRegister.studentId != null) {
            masterRegisterToSave.student = studentService.findById(masterRegister.studentId)
        }
        if(masterRegister.attendanceId != null){
            masterRegisterToSave.attendance = attendanceCodeService.findById(masterRegister.attendanceId)
        }
        if(masterRegister.academicYearId != null) {
            masterRegisterToSave.academicYear = academicYearService.findById(masterRegister.academicYearId)
        }
        masterRegisterToSave.sessionRef = masterRegister.sessionRef
        masterRegisterToSave.subjectCode = masterRegister.subjectCode
        masterRegisterToSave.group = masterRegister.group
        masterRegisterToSave.notes = masterRegister.notes
        return save(masterRegisterToSave)
    }
    
    /**
     * Saves a list of MasterRegister objects to the database
     *
     * @param masterRegisters a list of MasterRegisters to be saved to the database
     * @return the list of save MasterRegister objects
     */
    @Transactional
    public List<MasterRegister> saveMasterRegisters(List<MasterRegister> masterRegisters) {
        return masterRegisters.collect { masterRegister -> save(masterRegister) };
    }
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<MasterRegister> getByStudent(Integer studentId){
        return masterRegisterRepository.findByStudent_Id(studentId);
    }
    
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public  List<MasterRegister> getByStudentAndYear(Integer studentId, Integer yearId){
        return masterRegisterRepository.findByStudentIdAndAcademicYearId(studentId, yearId);
    }
    
    /**
     * This methods throws an InvalidOperationException when called. MasterRegister should not be deleted.
     */
    @Override
    public void delete(MasterRegister obj) {
        throw new InvalidOperationException("MasterRegister should not be deleted")
    }
}
