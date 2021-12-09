package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentWorkPlacement
import uk.ac.reigate.domain.academic.WorkPlacementMode
import uk.ac.reigate.dto.StudentWorkPlacementDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentWorkPlacementRepository
import uk.ac.reigate.services.student.StudentService


@Service
class StudentWorkPlacementService implements ICoreDataService<StudentWorkPlacement, Integer>{
    
    @Autowired
    StudentWorkPlacementRepository studentWorkPlacementRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final WorkPlacementModeService workPlacementModeService;
    
    /**
     * Default No Args constructor
     */
    StudentWorkPlacementService() {}
    
    StudentWorkPlacementService(StudentWorkPlacementRepository studentWorkPlacementRepository, StudentService studentService, WorkPlacementModeService workPlacementModeService) {
        super()
        this.studentWorkPlacementRepository = studentWorkPlacementRepository;
        this.studentService = studentService;
        this.workPlacementModeService = workPlacementModeService
    }
    
    @Transactional(readOnly = true)
    StudentWorkPlacement findById(Integer id) {
        return studentWorkPlacementRepository.findById(id).orElse(null)
    }
    
    /**
     * @param studentId
     * @return
     */
    @Transactional(readOnly = true)
    List<StudentWorkPlacement> findByStudentId(Integer studentId) {
        return studentWorkPlacementRepository.findByStudent_Id(studentId);
    }
    
    
    /**
     * Find all StudentWorkPlacement
     *
     * @return a List of StudentWorkPlacement
     */
    @Transactional(readOnly = true)
    List<StudentWorkPlacement> findAll() {
        return studentWorkPlacementRepository.findAll();
    }
    /**
     * There is no id for StudentWorkPlacement object , therefore returning null
     *
     */
    public List<StudentWorkPlacement> findByWorkPlacementModeId(Integer workPlacementModeId) {
        return studentWorkPlacementRepository.findByWorkPlacementMode_Id(workPlacementModeId);
    }
    
    /**
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public StudentWorkPlacement findByStudent(Integer studentId){
        StudentWorkPlacement students = studentWorkPlacementRepository.findByStudent_Id(studentId)
        return students
    }
    
    /**
     * This service method is used to save a complete StudentWorkPlacement object in the database
     *
     * @param studentWorkPlacement the new StudentWorkPlacement object to be saved
     * @return the saved version of the StudentWorkPlacement object
     */
    @Override
    @Transactional
    public StudentWorkPlacement save(StudentWorkPlacement studentWorkPlacement) {
        return studentWorkPlacementRepository.save(studentWorkPlacement)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentWorkPlacementDto
     * @param StudentWorkPlacementDto
     * @return
     */
    @Transactional
    public StudentWorkPlacement createFromDto(StudentWorkPlacementDto studentWorkPlacementDto) {
        if (studentWorkPlacementDto == null) {
            throw new InvalidDataException("Cannot create studentWorkPlacementDto from null object.")
        }
        StudentWorkPlacement studentWorkPlacement = new StudentWorkPlacement()
        if(studentWorkPlacementDto.studentId != null) {
            studentWorkPlacement.student = studentService.findById(studentWorkPlacementDto.studentId)
        }
        if(studentWorkPlacementDto.workPlacementModeId != null) {
            studentWorkPlacement.workPlacementMode = workPlacementModeService.findById(studentWorkPlacementDto.workPlacementModeId)
        }
        studentWorkPlacement.startDate = studentWorkPlacementDto.startDate
        studentWorkPlacement.endDate = studentWorkPlacementDto.endDate
        studentWorkPlacement.placementHours = studentWorkPlacementDto.placementHours
        studentWorkPlacement.employer = studentWorkPlacementDto.employer
        studentWorkPlacement.extraDetails = studentWorkPlacementDto.extraDetails
        return save(studentWorkPlacement)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentWorkPlacementDto
     * @param StudentWorkPlacementDto
     * @return
     */
    @Transactional
    public StudentWorkPlacement updateFromDto(StudentWorkPlacementDto studentWorkPlacementDto) {
        if (studentWorkPlacementDto == null) {
            throw new InvalidDataException("Cannot update studentWorkPlacementDto from null object.")
        }
        StudentWorkPlacement studentWorkPlacement = findById(studentWorkPlacementDto.id)
        if(studentWorkPlacementDto.studentId != null) {
            studentWorkPlacement.student = studentService.findById(studentWorkPlacementDto.studentId)
        }
        studentWorkPlacement.startDate = studentWorkPlacementDto.startDate
        studentWorkPlacement.endDate = studentWorkPlacementDto.endDate
        studentWorkPlacement.placementHours = studentWorkPlacementDto.placementHours
        if(studentWorkPlacementDto.workPlacementModeId != null) {
            studentWorkPlacement.workPlacementMode = workPlacementModeService.findById(studentWorkPlacementDto.workPlacementModeId)
        }
        studentWorkPlacement.employer = studentWorkPlacementDto.employer
        studentWorkPlacement.extraDetails = studentWorkPlacementDto.extraDetails
        return save(studentWorkPlacement)
    }
    
    /**
     * This service method is used to delete a complete StudentWorkPlacement object in the database
     *
     * @param studentWorkPlacement the  StudentWorkPlacement object to be deleted
     *
     */
    @Override
    public void delete(StudentWorkPlacement obj) {
        throw new InvalidOperationException("StudentWorkPlacement should not be deleted")
    }
}
