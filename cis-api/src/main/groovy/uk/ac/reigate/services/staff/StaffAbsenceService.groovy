package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.StaffAbsence
import uk.ac.reigate.dto.staff.StaffAbsenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.StaffAbsenceRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StaffAbsenceService implements ICoreDataService<StaffAbsence, Integer>{
    
    @Autowired
    StaffAbsenceRepository staffAbsenceRepository
    
    /**
     * Default NoArgs constructor
     */
    StaffAbsenceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param staffAbsenceRepository
     */
    StaffAbsenceService(StaffAbsenceRepository staffAbsenceRepository) {
        this.staffAbsenceRepository = staffAbsenceRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param staffAbsenceRepository
     */
    @Override
    @Transactional(readOnly = true)
    StaffAbsence findById(Integer id) {
        return staffAbsenceRepository.findById(id).orElse(null)
    }
    
    List<StaffAbsence> findByStaffId(Integer staffId) {
        return staffAbsenceRepository.findByStaff_Id(staffId)
    }
    
    /**
     * Find a single page of StaffAbsence objects
     * @return a SearchResult set with the list of Nationalities
     */
    @Override
    @Transactional(readOnly = true)
    List<StaffAbsence> findAll() {
        return staffAbsenceRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StaffAbsence object in the database
     *
     * @param staffAbsence the new StaffAbsence object to be saved
     * @return the saved version of the StaffAbsence object
     */
    @Override
    @Transactional
    public StaffAbsence save(StaffAbsence staffAbsence) {
        return staffAbsenceRepository.save(staffAbsence)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StaffAbsence should not be deleted.
     */
    @Override
    public void delete(StaffAbsence obj) {
        throw new InvalidOperationException("StaffAbsence should not be deleted")
    }
}
