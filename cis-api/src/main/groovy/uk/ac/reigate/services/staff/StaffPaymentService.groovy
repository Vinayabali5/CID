package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.StaffPayment
import uk.ac.reigate.dto.staff.StaffPaymentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.StaffPaymentRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StaffPaymentService implements ICoreDataService<StaffPayment, Integer>{
    
    @Autowired
    StaffPaymentRepository staffPaymentRepository
    
    /**
     * Default NoArgs constructor
     */
    StaffPaymentService() {}
    
    /**
     * Autowired Constructor
     *
     * @param staffPaymentRepository
     */
    StaffPaymentService(StaffPaymentRepository staffPaymentRepository) {
        this.staffPaymentRepository = staffPaymentRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param staffPaymentRepository
     */
    @Override
    @Transactional(readOnly = true)
    StaffPayment findById(Integer id) {
        return staffPaymentRepository.findById(id).orElse(null)
    }
    
    List<StaffPayment> findByStaffId(Integer staffId) {
        return staffPaymentRepository.findByStaff_Id(staffId)
    }
    
    /**
     * Find a single page of StaffPayment objects
     * @return a SearchResult set with the list of Nationalities
     */
    @Override
    @Transactional(readOnly = true)
    List<StaffPayment> findAll() {
        return staffPaymentRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StaffPayment object in the database
     *
     * @param staffPayment the new StaffPayment object to be saved
     * @return the saved version of the StaffPayment object
     */
    @Override
    @Transactional
    public StaffPayment save(StaffPayment staffPayment) {
        return staffPaymentRepository.save(staffPayment)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StaffPayment should not be deleted.
     */
    @Override
    public void delete(StaffPayment obj) {
        throw new InvalidOperationException("StaffPayment should not be deleted")
    }
}
