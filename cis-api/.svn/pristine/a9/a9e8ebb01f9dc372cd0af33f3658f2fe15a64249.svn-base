package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.domain.lookup.PunctualityMonitoring
import uk.ac.reigate.domain.lookup.WarningCodeChange
import uk.ac.reigate.dto.WarningCodeChangeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.WarningCodeChangeRepository
import uk.ac.reigate.services.student.StudentService

@Service
class WarningCodeChangeService implements ICoreDataService<WarningCodeChange, Integer>, IDtoCreateUpdateService<WarningCodeChangeDto, WarningCodeChange>{
    
    @Autowired
    WarningCodeChangeRepository warningCodeChangeRepository
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    @Autowired
    private final AttendanceMonitoringService attendanceMonitoringService;
    
    @Autowired
    private final PunctualityMonitoringService punctualityMonitoringService;
    
    /**
     * Default NoArgs constructor
     */
    WarningCodeChangeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param warningCodeChangeRepository
     */
    WarningCodeChangeService(WarningCodeChangeRepository warningCodeChangeRepository, StudentService studentService, AcademicYearService academicYearService, AttendanceMonitoringService attendanceMonitoringService, PunctualityMonitoringService punctualityMonitoringService) {
        super();
        this.warningCodeChangeRepository = warningCodeChangeRepository
        this.studentService = studentService;
        this.academicYearService = academicYearService;
        this.attendanceMonitoringService = attendanceMonitoringService;
        this.punctualityMonitoringService = punctualityMonitoringService;
    }
    
    /**
     * Find an individual warningCodeChange using the warningCodeChanges ID fields
     *
     * @param id the ID fields to search for
     * @return the WarningCodeChange object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    WarningCodeChange findById(Integer id) {
        return warningCodeChangeRepository.findById(id).orElse(null)
    }
    
    /** Retrieves List of WarningCodeChange by studentId
     * @param year
     * @return
     */
    @Transactional(readOnly = true)
    List<WarningCodeChange> findByStudentId(Integer studentId) {
        return warningCodeChangeRepository.findByStudent_Id(studentId)
    }
    
    /**
     * Find all warningCodeChanges
     *
     * @return a SearchResult set with the list of WarningCodeChanges
     */
    @Override
    @Transactional(readOnly = true)
    List<WarningCodeChange> findAll() {
        return warningCodeChangeRepository.findAll()
    }
    
    /**
     * This method is used to create a new WarningCodeChange data object from the supplied warningCodeChangeDto
     * @param warningCodeChangeDto
     * @return
     */
    @Transactional
    public WarningCodeChange createFromDto(WarningCodeChangeDto warningCodeChangeDto) {
        if (warningCodeChangeDto == null) {
            throw new InvalidDataException("Cannot create warningCodeChangeDto from null object.")
        }
        WarningCodeChange warningCodeChange = new WarningCodeChange()
        if(warningCodeChangeDto.studentId != null) {
            warningCodeChange.student = studentService.findById(warningCodeChangeDto.studentId)
        }
        if(warningCodeChangeDto.yearId != null) {
            warningCodeChange.year = academicYearService.findById(warningCodeChangeDto.yearId)
        }
        if(warningCodeChangeDto.previousAmId != null) {
            warningCodeChange.previousAm = attendanceMonitoringService.findById(warningCodeChangeDto.previousAmId)
        }
        if(warningCodeChangeDto.currentAmId != null) {
            warningCodeChange.currentAm = attendanceMonitoringService.findById(warningCodeChangeDto.currentAmId)
        }
        if(warningCodeChangeDto.previousPmId != null) {
            warningCodeChange.previousPm = punctualityMonitoringService.findById(warningCodeChangeDto.previousPmId)
        }
        if(warningCodeChangeDto.currentPmId != null) {
            warningCodeChange.currentPm = punctualityMonitoringService.findById(warningCodeChangeDto.currentPmId)
        }
        warningCodeChange.changeDate = warningCodeChangeDto.changeDate
        return save(warningCodeChange)
    }
    
    /**
     * This method is used to update a new WarningCodeChange data object from the supplied warningCodeChangeDto
     * @param warningCodeChangeDto
     * @return
     */
    @Transactional
    public WarningCodeChange updateFromDto(WarningCodeChangeDto warningCodeChangeDto) {
        if (warningCodeChangeDto == null) {
            throw new InvalidDataException("Cannot update warningCodeChangeDto from null object.")
        }
        WarningCodeChange warningCodeChange = findById(warningCodeChangeDto.id)
        if(warningCodeChangeDto.studentId != null) {
            warningCodeChange.student = studentService.findById(warningCodeChangeDto.studentId)
        }
        if(warningCodeChangeDto.yearId != null) {
            warningCodeChange.year = academicYearService.findById(warningCodeChangeDto.yearId)
        }
        if(warningCodeChangeDto.previousAmId != null) {
            warningCodeChange.previousAm = attendanceMonitoringService.findById(warningCodeChangeDto.previousAmId)
        }
        if(warningCodeChangeDto.currentAmId != null) {
            warningCodeChange.currentAm = attendanceMonitoringService.findById(warningCodeChangeDto.currentAmId)
        }
        if(warningCodeChangeDto.previousPmId != null) {
            warningCodeChange.previousPm = punctualityMonitoringService.findById(warningCodeChangeDto.previousPmId)
        }
        if(warningCodeChangeDto.currentPmId != null) {
            warningCodeChange.currentPm = punctualityMonitoringService.findById(warningCodeChangeDto.currentPmId)
        }
        warningCodeChange.changeDate = warningCodeChangeDto.changeDate
        return save(warningCodeChange)
    }
    
    
    /** Retrieves List of WarningCodeChange by studentId and yearId
     * @param studentId
     * @param yearId
     * @return
     */
    @Transactional(readOnly = true)
    List<WarningCodeChange> getByStudentAndYear(Integer studentId, Integer yearId){
        return warningCodeChangeRepository.findByStudent_IdAndYear_Id(studentId, yearId)
    }
    
    @Override
    public void delete(WarningCodeChange obj) {
        throw new InvalidOperationException("WarningCodeChange should not be deleted")
    }
    
    @Override
    @Transactional
    public WarningCodeChange save(WarningCodeChange warningCodeChange) {
        return warningCodeChangeRepository.save(warningCodeChange)
    }
}
