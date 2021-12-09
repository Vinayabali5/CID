package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.learning_support.ReferralReason
import uk.ac.reigate.dto.ReferralReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.ReferralReasonRepository
import uk.ac.reigate.utils.ValidationUtils

@Service
class ReferralReasonService implements ICoreDataService<ReferralReason, Integer>, IDtoCreateUpdateService<ReferralReasonDto, ReferralReason>{
    
    @Autowired
    ReferralReasonRepository referralReasonRepository
    
    @Autowired
    private final LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService
    
    /**
     * Default NoArgs constructor
     */
    ReferralReasonService() {}
    
    /**
     * Autowired Constructor
     *
     * @param referralReasonRepository
     */
    ReferralReasonService(ReferralReasonRepository referralReasonRepository, LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService) {
        super();
        this.referralReasonRepository = referralReasonRepository
        this.lLDDHealthProblemCategoryService = lLDDHealthProblemCategoryService;
    }
    
    /**
     * Find an individual referralReason using the referralReasons ID fields
     *
     * @param id the ID fields to search for
     * @return the ReferralReason object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ReferralReason findById(Integer id) {
        return referralReasonRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of ReferralReason objects
     * @return a SearchResult set with the list of ReferralReasons
     */
    @Override
    @Transactional(readOnly = true)
    List<ReferralReason> findAll() {
        return referralReasonRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ReferralReason object in the database
     *
     * @param referralReason the new ReferralReason object to be saved
     * @return the saved version of the ReferralReason object
     */
    @Override
    @Transactional
    public ReferralReason save(ReferralReason referralReason) {
        return referralReasonRepository.save(referralReason)
    }
    
    /**
     * This service method is used to create a ReferralReason object in the database from a partial or complete ReferralReason object.
     *
     * @param referralReason the partial or complete ReferralReason object to be saved
     * @return the saved version of the ReferralReason object
     */
    @Transactional
    public ReferralReason createFromDto(ReferralReasonDto referralReason) {
        if (referralReason == null) {
            throw new InvalidDataException("Cannot create referralReasonDto from null object.")
        }
        ReferralReason referralReasonToSave = new ReferralReason()
        referralReasonToSave.id = referralReason.id
        referralReasonToSave.reason = referralReason.reason
        if(referralReason.llddHealthProblemCategoryId != null) {
            referralReasonToSave.llddHealthProblemCategory = lLDDHealthProblemCategoryService.findById(referralReason.llddHealthProblemCategoryId)
        }
        return save(referralReasonToSave)
    }
    
    /**
     * This service method is used to update an ReferralReason object in the database from a partial or complete ReferralReason object.
     *
     * @param referralReason the partial or complete ReferralReason object to be saved
     * @return the saved version of the ReferralReason object
     */
    @Transactional
    public ReferralReason updateFromDto(ReferralReasonDto referralReason) {
        if (referralReason == null) {
            throw new InvalidDataException("Cannot update referralReasonDto from null object.")
        }
        ReferralReason referralReasonToSave = findById(referralReason.id)
        if(referralReason.llddHealthProblemCategoryId != null) {
            referralReasonToSave.llddHealthProblemCategory = lLDDHealthProblemCategoryService.findById(referralReason.llddHealthProblemCategoryId)
        }
        referralReasonToSave.reason = referralReason.reason
        return save(referralReasonToSave)
    }
    
    /**
     * Saves a list of ReferralReason objects to the database
     *
     * @param referralReasons a list of ReferralReasons to be saved to the database
     * @return the list of save ReferralReason objects
     */
    @Transactional
    public List<ReferralReason> saveReferralReasons(List<ReferralReason> referralReasons) {
        return referralReasons.collect { referralReason -> save(referralReason) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ReferralReason should not be deleted.
     */
    @Override
    public void delete(ReferralReason obj) {
        throw new InvalidOperationException("ReferralReason should not be deleted")
    }
}
