package uk.ac.reigate.services.ilp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.StatementBank
import uk.ac.reigate.dto.StatementBankDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.StatementBankRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StatementBankService implements ICoreDataService<StatementBank, Integer>, IDtoCreateUpdateService<StatementBankDto, StatementBank>{
    
    @Autowired
    StatementBankRepository statementBankRepository
    
    @Autowired
    StatementBankTypeService iLPStatementBankTypeService
    
    /**
     * Default NoArgs constructor    
     */
    StatementBankService() {}
    
    /**
     * Autowired constructor
     * 
     * @param statementBankRepository
     */
    StatementBankService(StatementBankRepository statementBankRepository, StatementBankTypeService iLPStatementBankTypeService) {
        this.statementBankRepository = statementBankRepository
        this.iLPStatementBankTypeService = iLPStatementBankTypeService
    }
    
    /**
     * Find an individual statementBank using the statementBanks ID fields
     *
     * @param id the ID fields to search for
     * @return the StatementBank object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StatementBank findById(Integer id) {
        return statementBankRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all statementBanks
     *
     * @return a SearchResult set with the list of StatementBanks
     */
    @Override
    @Transactional(readOnly = true)
    List<StatementBank> findAll() {
        return statementBankRepository.findByInUseTrue();
    }
    
    @Transactional(readOnly = true)
    List<StatementBank> findUseForMassLetters() {
        return statementBankRepository.findByUseForMassLettersTrueAndInUseTrue();
    }
    
    @Transactional(readOnly = true)
    List<StatementBank> findUseForMassPraiseLetters() {
        return statementBankRepository.findByUseForPraiseEmailTrueAndInUseTrue();
    }
    
    /**
     * Find all the statementBanks using the statementBanktype ID fields
     *
     * @param id the iLPStatementBankTypeId fields to search for
     * @return the StatementBank object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    List<StatementBank> findByILPStatementBankType(Integer iLPStatementBankTypeId) {
        return statementBankRepository.findByInUseTrueAndStatementBankTypeId(iLPStatementBankTypeId);
    }
    
    /**
     * This service method is used to save a complete StatementBank object in the database
     *
     * @param statementBank the new StatementBank object to be saved
     * @return the saved version of the StatementBank object
     */
    @Override
    @Transactional
    public StatementBank save(StatementBank statementBank) {
        return statementBankRepository.save(statementBank)
    }
    
    /**
     * This service method is used to update a StatementBank object in the database from a partial or complete StatementBank object.
     *
     * @param statementBank the partial or complete StatementBank object to be saved
     * @return the saved version of the StatementBank object
     */
    @Transactional
    public StatementBank createFromDto(StatementBankDto statementBank) {
        if (statementBank == null) {
            throw new InvalidDataException("Cannot create statamentBank from null object.")
        }
        StatementBank statementBankToSave = new StatementBank();
        if(statementBank.iLPStatementBankTypeId != null) {
            statementBankToSave.statementBankType = iLPStatementBankTypeService.findById(statementBank.iLPStatementBankTypeId)
        }
        statementBankToSave.letterType = statementBank.letterType
        statementBankToSave.topic = statementBank.topic
        statementBankToSave.discussion = statementBank.discussion
        statementBankToSave.target = statementBank.target
        statementBankToSave.useForMassLetters = statementBank.useForMassLetters
        statementBankToSave.useForPraiseEmail = statementBank.useForPraiseEmail
        return save(statementBankToSave)
    }
    
    /**
     * This service method is used to update a StatementBank object in the database from a partial or complete StatementBank object.
     *
     * @param statementBank the partial or complete StatementBank object to be saved
     * @return the saved version of the StatementBank object
     */
    @Transactional
    public StatementBank updateFromDto(StatementBankDto statementBank) {
        if (statementBank == null) {
            throw new InvalidDataException("Cannot update statamentBank from null object.")
        }
        StatementBank statementBankToSave = findById(statementBank.id)
        if(statementBank.iLPStatementBankTypeId != null) {
            statementBankToSave.statementBankType = iLPStatementBankTypeService.findById(statementBank.iLPStatementBankTypeId)
        }
        statementBankToSave.letterType = statementBank.letterType
        statementBankToSave.topic = statementBank.topic
        statementBankToSave.discussion = statementBank.discussion
        statementBankToSave.target = statementBank.target
        statementBankToSave.useForMassLetters = statementBank.useForMassLetters
        statementBankToSave.useForPraiseEmail = statementBank.useForPraiseEmail
        return save(statementBankToSave)
    }
    
    /**
     * Saves a list of StatementBank objects to the database
     *
     * @param statementBanks a list of StatementBanks to be saved to the database
     * @return the list of save StatementBank objects
     */
    @Transactional
    public List<StatementBank> saveStatementBanks(List<StatementBank> statementBanks) {
        return statementBanks.collect { statementBank -> save(statementBank) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StatementBank should not be deleted.
     */
    @Override
    public void delete(StatementBank obj) {
        throw new InvalidOperationException("StatementBank should not be deleted")
    }
}
