package uk.ac.reigate.services;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.register.AttendanceCode
import uk.ac.reigate.dto.AttendanceCodeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.register.AttendanceCodeRepository

@Service
class AttendanceCodeService implements ICoreDataService<AttendanceCode,Integer>, IDtoCreateUpdateService<AttendanceCodeDto, AttendanceCode> {
    
    @Autowired
    AttendanceCodeRepository attendanceCodeRepository
    
    /**
     * Default NoArgs constructor
     */
    AttendanceCodeService() {}
    
    /**
     * Autowired Constructor
     * 
     * @param attendanceCodeRepository
     */
    AttendanceCodeService(AttendanceCodeRepository attendanceCodeRepository) {
        this.attendanceCodeRepository = attendanceCodeRepository
    }
    
    /**
     * Find an individual attendanceCode using the attendanceCodes ID fields
     * 
     * @param id the ID fields to search for
     * @return the AttendanceCode object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    AttendanceCode findById(Integer id) {
        return attendanceCodeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all attendanceCodes
     * 
     * @return a SearchResult set with the list of AttendanceCodes
     * 
     */
    @Override
    @Transactional(readOnly = true)
    List<AttendanceCode> findAll() {
        return attendanceCodeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete AttendanceCode object in the database
     * 
     * @param attendanceCode the new AttendanceCode object to be saved
     * @return the saved version of the AttendanceCode object
     */
    @Override
    @Transactional
    public AttendanceCode save(AttendanceCode attendanceCode) {
        return attendanceCodeRepository.save(attendanceCode)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. AttendanceCode should not be deleted.
     */
    @Override
    public void delete(AttendanceCode obj) {
        throw new InvalidOperationException();
    }
    
    /**
     * Saves a list of AttendanceCode objects to the database
     *   
     * @param attendanceCodes a list of AttendanceCodes to be saved to the database
     * @return the list of save AttendanceCode objects
     */
    @Transactional
    public List<AttendanceCode> saveAttendanceCodes(List<AttendanceCode> attendanceCodes) {
        return attendanceCodes.collect { attendanceCode -> save(attendanceCode) };
    }
    
    /**
     * This service method is used to create an AttendanceCode object in the database from a partial or complete AttendanceCode object.
     * 
     * @param attendanceCode the partial or complete AttendanceCode object to be saved
     * @return the saved version of the AttendanceCode object
     */
    @Transactional
    public AttendanceCode createFromDto(AttendanceCodeDto attendanceCode) {
        if (attendanceCode == null) {
            throw new InvalidDataException("Cannot create AttendanceCode from null object.")
        }
        AttendanceCode attendanceCodeToSave = new AttendanceCode()
        attendanceCodeToSave.id = attendanceCode.id
        attendanceCodeToSave.code = attendanceCode.code
        attendanceCodeToSave.description = attendanceCode.description
        attendanceCodeToSave.registerMark = attendanceCode.registerMark
        attendanceCodeToSave.absence = attendanceCode.absence
        attendanceCodeToSave.authorisedAbsence = attendanceCode.authorisedAbsence
        attendanceCodeToSave.late = attendanceCode.late
        attendanceCodeToSave.authorisedLate = attendanceCode.authorisedLate
        attendanceCodeToSave.included = attendanceCode.included
        attendanceCodeToSave.lastDateOfAttendance = attendanceCode.lastDateOfAttendance
        attendanceCodeToSave.htmlColour = attendanceCode.htmlColour
        attendanceCodeToSave.accessColour = attendanceCode.accessColour
        return save(attendanceCodeToSave)
    }
    
    /**
     * This service method is used to update an AttendanceCode object in the database from a partial or complete AttendanceCode object.
     * 
     * @param attendanceCode the partial or complete AttendanceCode object to be saved
     * @return the saved version of the AttendanceCode object
     */
    @Transactional
    public AttendanceCode updateFromDto(AttendanceCodeDto attendanceCode) {
        if (attendanceCode == null) {
            throw new InvalidDataException("Cannot update AttendanceCode from null object.")
        }
        if (attendanceCode.id == null) {
            throw new InvalidDataException("Cannot update AttendanceCode from null object.")
        }
        AttendanceCode attendanceCodeToSave = findById(attendanceCode.id)
        attendanceCodeToSave.code = attendanceCode.code
        attendanceCodeToSave.description = attendanceCode.description
        attendanceCodeToSave.registerMark = attendanceCode.registerMark
        attendanceCodeToSave.absence = attendanceCode.absence
        attendanceCodeToSave.authorisedAbsence = attendanceCode.authorisedAbsence
        attendanceCodeToSave.late = attendanceCode.late
        attendanceCodeToSave.authorisedLate = attendanceCode.authorisedLate
        attendanceCodeToSave.included = attendanceCode.included
        attendanceCodeToSave.lastDateOfAttendance = attendanceCode.lastDateOfAttendance
        attendanceCodeToSave.htmlColour = attendanceCode.htmlColour
        attendanceCodeToSave.accessColour = attendanceCode.accessColour
        return save(attendanceCodeToSave)
    }
}
