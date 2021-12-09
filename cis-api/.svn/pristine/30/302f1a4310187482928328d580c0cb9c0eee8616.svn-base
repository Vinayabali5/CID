package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.PaymentReason
import uk.ac.reigate.dto.staff.PaymentReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.PaymentReasonRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class PaymentReasonService implements ICoreDataService<PaymentReason, Integer>, IDtoCreateUpdateService<PaymentReasonDto, PaymentReason>{
    
    @Autowired
    PaymentReasonRepository paymentReasonRepository
    
    /**
     * Default NoArgs constructor
     */
    PaymentReasonService() {}
    
    /**
     * Autowired Constructor
     *
     * @param paymentReasonRepository
     */
    PaymentReasonService(PaymentReasonRepository paymentReasonRepository) {
        this.paymentReasonRepository = paymentReasonRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param paymentReasonRepository
     */
    @Override
    @Transactional(readOnly = true)
    PaymentReason findById(Integer id) {
        return paymentReasonRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of PaymentReason objects
     * @return a SearchResult set with the list of PaymentReasons
     */
    @Override
    @Transactional(readOnly = true)
    List<PaymentReason> findAll() {
        return paymentReasonRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete PaymentReason object in the database
     *
     * @param paymentReason the new PaymentReason object to be saved
     * @return the saved version of the PaymentReason object
     */
    @Override
    @Transactional
    public PaymentReason save(PaymentReason paymentReason) {
        return paymentReasonRepository.save(paymentReason)
    }
    
    /**
     * This service method is used to create a PaymentReason object in the database from a partial or complete PaymentReason object.
     *
     * @param paymentReason the partial or complete PaymentReason object to be saved
     * @return the saved version of the PaymentReason object
     */
    @Transactional
    public PaymentReason createFromDto(PaymentReasonDto paymentReasonDto) {
        if (paymentReasonDto == null) {
            throw new InvalidDataException("Cannot create paymentReasonDto from null object.")
        }
        PaymentReason paymentReason = new PaymentReason()
        paymentReason.paymentReason = paymentReasonDto.paymentReason
        return  save(paymentReason)
    }
    
    /**
     * This service method is used to update a PaymentReason object in the database from a partial or complete PaymentReason object.
     *
     * @param paymentReason the partial or complete PaymentReason object to be saved
     * @return the saved version of the PaymentReason object
     */
    @Transactional
    public PaymentReason updateFromDto(PaymentReasonDto paymentReasonDto) {
        if (paymentReasonDto == null) {
            throw new InvalidDataException("Cannot update paymentReasonDto from null object.")
        }
        PaymentReason paymentReason = findById(paymentReasonDto.id)
        paymentReason.paymentReason = paymentReasonDto.paymentReason
        return  save(paymentReason)
    }
    
    /**
     * Saves a list of PaymentReason objects to the database
     *
     * @param paymentReasons a list of PaymentReasons to be saved to the database
     * @return the list of save PaymentReason objects
     */
    @Transactional
    public List<PaymentReason> savePaymentReasons(List<PaymentReason> paymentReasons) {
        return paymentReasons.collect { paymentReason -> save(paymentReason) };
    }
    /**
     * This methods throws an InvalidOperationException when called. PaymentReason should not be deleted.
     */
    @Override
    public void delete(PaymentReason obj) {
        throw new InvalidOperationException("PaymentReason should not be deleted")
    }
}
