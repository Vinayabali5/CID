package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.dto.AttendanceMonitoringDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.lookup.AttendanceMonitoringRepository
import uk.ac.reigate.util.exception.IdMissingException

@Service
class AttendanceMonitoringService implements ICoreDataService<AttendanceMonitoring, Integer>, IDtoCreateUpdateService<AttendanceMonitoringDto, AttendanceMonitoring>{
    
    @Autowired
    AttendanceMonitoringRepository attendanceMonitoringRepository
    
    /**
     * Default NoArgs constructor
     */
    AttendanceMonitoringService() {}
    
    /**
     * Autowired Constructor
     *
     * @param attendanceMonitoringRepository
     */
    AttendanceMonitoringService(AttendanceMonitoringRepository attendanceMonitoringRepository) {
        this.attendanceMonitoringRepository = attendanceMonitoringRepository;
    }
    
    /**
     * Find an individual attendanceMonitoring using the attendanceMonitorings ID fields
     *
     * @param id the ID fields to search for
     * @return the AttendanceMonitoring object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    AttendanceMonitoring findById(Integer id) {
        return attendanceMonitoringRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all attendanceMonitorings
     *
     * @return a List set with the list of AttendanceMonitorings
     */
    @Override
    @Transactional(readOnly = true)
    List<AttendanceMonitoring> findAll() {
        return attendanceMonitoringRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete AttendanceMonitoring object in the database
     *
     * @param attendanceMonitoring the new AttendanceMonitoring object to be saved
     * @return the saved version of the AttendanceMonitoring object
     */
    @Override
    @Transactional
    public AttendanceMonitoring save(AttendanceMonitoring attendanceMonitoring) {
        return attendanceMonitoringRepository.save(attendanceMonitoring)
    }
    
    /**
     * This service method is used to create an AttendanceMonitoring object to the database from a partial or complete AttendanceMonitoring object.
     *
     * @param attendanceMonitoring the partial or complete AttendanceMonitoring object to be saved
     * @return the saved version of the AttendanceMonitoring object
     */
    
    @Transactional
    public AttendanceMonitoring createFromDto(AttendanceMonitoringDto attendanceMonitoring) {
        if (attendanceMonitoring == null) {
            throw new InvalidDataException("Cannot create AttendanceMonitoring from null object.")
        }
        if (findById(attendanceMonitoring.id) != null) {
            throw new IdMissingException("An AttendanceMonitoring already exist with this ID.")
        }
        AttendanceMonitoring attendanceMonitoringToSave = new AttendanceMonitoring()
        attendanceMonitoringToSave.id = attendanceMonitoring.id
        attendanceMonitoringToSave.code = attendanceMonitoring.code
        attendanceMonitoringToSave.description = attendanceMonitoring.description
        attendanceMonitoringToSave.warningColour = attendanceMonitoring.warningColour
        attendanceMonitoringToSave.htmlColour = attendanceMonitoring.htmlColour
        attendanceMonitoringToSave.inUse = attendanceMonitoring.inUse
        attendanceMonitoringToSave.nonEntry = attendanceMonitoring.nonEntry
        return save(attendanceMonitoringToSave)
    }
    
    /**
     * This service method is used to update an AttendanceMonitoring object in the database from a partial or complete AttendanceMonitoring object.
     *
     * @param attendanceMonitoring the partial or complete AttendanceMonitoring object to be saved
     * @return the saved version of the AttendanceMonitoring object
     */
    
    @Transactional
    public AttendanceMonitoring updateFromDto(AttendanceMonitoringDto attendanceMonitoring) {
        if (attendanceMonitoring == null) {
            throw new InvalidDataException("Cannot update AttendanceMonitoring from null object.")
        }
        if (attendanceMonitoring.id == null) {
            throw new InvalidDataException("Cannot update AttendanceMonitoring when ID is null.")
        }
        AttendanceMonitoring attendanceMonitoringToSave = findById(attendanceMonitoring.id);
        attendanceMonitoringToSave.code = attendanceMonitoring.code
        attendanceMonitoringToSave.description = attendanceMonitoring.description
        attendanceMonitoringToSave.warningColour = attendanceMonitoring.warningColour
        attendanceMonitoringToSave.htmlColour = attendanceMonitoring.htmlColour
        attendanceMonitoringToSave.inUse = attendanceMonitoring.inUse
        attendanceMonitoringToSave.nonEntry = attendanceMonitoring.nonEntry
        return save(attendanceMonitoringToSave)
    }
    
    /**
     * Saves a list of AttendanceMonitoring objects to the database
     *
     * @param attendanceMonitorings a list of AttendanceMonitorings to be saved to the database
     * @return the list of save AttendanceMonitoring objects
     */
    
    @Transactional
    public List<AttendanceMonitoring> saveAttendanceMonitorings(List<AttendanceMonitoring> attendanceMonitorings) {
        return attendanceMonitorings.collect { attendanceMonitoring -> save(attendanceMonitoring) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. AttendanceMonitoring should not be deleted.
     */
    @Override
    public void delete(AttendanceMonitoring obj) {
        throw new InvalidOperationException("AttendanceMonitoring should not be deleted.")
    }
}