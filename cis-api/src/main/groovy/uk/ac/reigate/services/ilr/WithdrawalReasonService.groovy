package uk.ac.reigate.services.ilr

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.WithdrawalReason
import uk.ac.reigate.dto.ilr.WithdrawalReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.WithdrawalReasonRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class WithdrawalReasonService implements ICoreDataService<WithdrawalReason, Integer>, IDtoCreateUpdateService<WithdrawalReasonDto, WithdrawalReason> {
    
    @Autowired
    WithdrawalReasonRepository withdrawalReasonRepository
    
    /**
     * Default NoArgs constructor
     */
    WithdrawalReasonService() {}
    
    /**
     * Autowired Constructor
     *
     * @param withdrawalReasonRepository
     */
    WithdrawalReasonService(WithdrawalReasonRepository withdrawalReasonRepository) {
        this.withdrawalReasonRepository = withdrawalReasonRepository
    }
    
    /**
     * Find an individual withdrawalReason using the withdrawalReasons ID fields
     *
     * @param id the ID fields to search for
     * @return the WithdrawalReason object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    WithdrawalReason findById(Integer id) {
        return withdrawalReasonRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all withdrawalReasons
     *
     * @return a SearchResult set with the list of WithdrawalReasons
     */
    @Override
    @Transactional(readOnly = true)
    List<WithdrawalReason> findAll() {
        return withdrawalReasonRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete WithdrawalReason object in the database
     *
     * @param withdrawalReasonr the new WithdrawalReason object to be saved
     * @return the saved version of the WithdrawalReason object
     */
    @Override
    @Transactional
    public WithdrawalReason save(WithdrawalReason withdrawalReason) {
        return withdrawalReasonRepository.save(withdrawalReason)
    }
    
    /**
     * This service method is used to create an WithdrawalReason object in the database from a partial or complete WithdrawalReason object.
     *
     * @param withdrawalReason the partial or complete WithdrawalReason object to be saved
     * @return the saved version of the WithdrawalReason object
     */
    @Transactional
    public WithdrawalReason createFromDto(WithdrawalReasonDto withdrawalReason) {
        if(withdrawalReason == null) {
            throw new InvalidDataException("Cannot create withdrawalReason from null object.")
        }
        WithdrawalReason withdrawalReasonToSave = new WithdrawalReason()
        withdrawalReasonToSave.id = withdrawalReason.id
        withdrawalReasonToSave.code = withdrawalReason.code
        withdrawalReasonToSave.description = withdrawalReason.description
        withdrawalReasonToSave.shortDescription = withdrawalReason.shortDescription
        withdrawalReasonToSave.validFrom = withdrawalReason.validFrom
        withdrawalReasonToSave.validTo = withdrawalReason.validTo
        return save(withdrawalReasonToSave)
    }
    
    /**
     * This service method is used to update an WithdrawalReason object in the database from a partial or complete WithdrawalReason object.
     *
     * @param withdrawalReason the partial or complete WithdrawalReason object to be saved
     * @return the saved version of the WithdrawalReason object
     */
    @Transactional
    public WithdrawalReason updateFromDto(WithdrawalReasonDto withdrawalReason) {
        if(withdrawalReason == null) {
            throw new InvalidDataException("Cannot update withdrawalReason from null object.")
        }
        WithdrawalReason withdrawalReasonToSave = findById(withdrawalReason.id)
        withdrawalReasonToSave.code = withdrawalReason.code
        withdrawalReasonToSave.description = withdrawalReason.description
        withdrawalReasonToSave.shortDescription = withdrawalReason.shortDescription
        withdrawalReasonToSave.validFrom = withdrawalReason.validFrom
        withdrawalReasonToSave.validTo = withdrawalReason.validTo
        return save(withdrawalReasonToSave)
    }
    
    /**
     * Saves a list of WithdrawalReason objects to the database
     *
     * @param withdrawalReasons a list of WithdrawalReasons to be saved to the database
     * @return the list of save WithdrawalReason objects
     */
    @Transactional
    public List<WithdrawalReason> saveWithdrawalReasons(List<WithdrawalReason> withdrawalReasons) {
        return withdrawalReasons.collect { withdrawalReason -> save(withdrawalReason) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. WithdrawalReason should not be deleted.
     */
    @Override
    public void delete(WithdrawalReason obj) {
        throw new InvalidOperationException("WithdrawalReason should not be deleted")
    }
}
