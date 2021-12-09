package uk.ac.reigate.services.ilp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.StatementBankType
import uk.ac.reigate.dto.ilp.StatementBankTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.StatementBankTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StatementBankTypeService implements ICoreDataService<StatementBankType, Integer>, IDtoCreateUpdateService<StatementBankTypeDto, StatementBankType>{
    
    @Autowired
    StatementBankTypeRepository statementBankTypeRepository
    
    /**
     * Default NoArgs constructor    
     */
    StatementBankTypeService() {}
    
    /**
     * Autowired constructor
     * 
     * @param statementBankTypeRepository
     */
    StatementBankTypeService(StatementBankTypeRepository statementBankTypeRepository) {
        this.statementBankTypeRepository = statementBankTypeRepository
    }
    
    /**
     * Find an individual statementBankType using the statementBankTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the ILPStatementBankType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StatementBankType findById(Integer id) {
        return statementBankTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all statementBankTypes
     *
     * @return a SearchResult set with the list of ILPStatementBankTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<StatementBankType> findAll() {
        return statementBankTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ILPStatementBankType object in the database
     *
     * @param statementBankType the new ILPStatementBankType object to be saved
     * @return the saved version of the ILPStatementBankType object
     */
    @Override
    @Transactional
    public StatementBankType save(StatementBankType statementBankType) {
        return statementBankTypeRepository.save(statementBankType)
    }
    
    /**
     * This service method is used to update a ILPStatementBankType object in the database from a partial or complete ILPStatementBankType object.
     *
     * @param statementBankType the partial or complete ILPStatementBankType object to be saved
     * @return the saved version of the ILPStatementBankType object
     */
    @Transactional
    public StatementBankType createFromDto(StatementBankTypeDto statementBankType) {
        if (statementBankType == null) {
            throw new InvalidDataException("Cannot create StatementBankType from null object.")
        }
        StatementBankType statementBankTypeToSave = new StatementBankType();
        statementBankTypeToSave.id = statementBankType.id
        statementBankTypeToSave.type = statementBankType.type
        return save(statementBankTypeToSave)
    }
    
    /**
     * This service method is used to update a ILPStatementBankType object in the database from a partial or complete ILPStatementBankType object.
     *
     * @param statementBankType the partial or complete ILPStatementBankType object to be saved
     * @return the saved version of the ILPStatementBankType object
     */
    @Transactional
    public StatementBankType updateFromDto(StatementBankTypeDto statementBankType) {
        if (statementBankType == null) {
            throw new InvalidDataException("Cannot update StatementBankType from null object.")
        }
        StatementBankType statementBankTypeToSave = findById(statementBankType.id)
        statementBankTypeToSave.type = statementBankType.type
        return save(statementBankTypeToSave)
    }
    
    /**
     * Saves a list of ILPStatementBankType objects to the database
     *
     * @param statementBankTypes a list of ILPStatementBankTypes to be saved to the database
     * @return the list of save ILPStatementBankType objects
     */
    @Transactional
    public List<StatementBankType> saveStatementBankTypes(List<StatementBankType> statementBankTypes) {
        return statementBankTypes.collect { statementBankType -> save(statementBankType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ILPStatementBankType should not be deleted.
     */
    @Override
    public void delete(StatementBankType obj) {
        throw new InvalidOperationException("StatementBankType should not be deleted")
    }
}
