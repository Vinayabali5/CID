package uk.ac.reigate.services.risk_assessment

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.risk_assessment.RiskLevel
import uk.ac.reigate.dto.risk_assessment.RiskLevelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.risk_assessment.RiskLevelRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class RiskLevelService implements ICoreDataService<RiskLevel, Integer>, IDtoCreateUpdateService<RiskLevelDto, RiskLevel>{
    
    @Autowired
    RiskLevelRepository riskLevelRepository
    
    /**
     * Default NoArgs constructor
     */
    RiskLevelService() {}
    
    /**
     * Autowired Constructor
     *
     * @param riskLevelRepository
     */
    RiskLevelService(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }
    
    /**
     * Find an individual riskLevel using the riskLevels ID fields
     *
     * @param id the ID fields to search for
     * @return the RiskLevel object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    RiskLevel findById(Integer id) {
        return riskLevelRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all riskLevels
     *
     * @return a SearchResult set with the list of RiskLevels
     */
    @Override
    @Transactional(readOnly = true)
    List<RiskLevel> findAll() {
        return riskLevelRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete RiskLevel object in the database
     *
     * @param riskLevel the new RiskLevel object to be saved
     * @return the saved version of the RiskLevel object
     */
    @Override
    @Transactional
    public RiskLevel save(RiskLevel riskLevel) {
        return riskLevelRepository.save(riskLevel)
    }
    
    /**
     * This service method is used to update an RiskLevel object in the database from a partial or complete RiskLevel object.
     *
     * @param riskLevel the partial or complete RiskLevel object to be saved
     * @return the saved version of the RiskLevel object
     */
    @Transactional
    public RiskLevel createFromDto(RiskLevelDto riskLevelDto) {
        if (riskLevelDto == null) {
            throw new InvalidDataException("Cannot create riskLevel from null object.")
        }
        RiskLevel riskLevelToSave = new RiskLevel()
        riskLevelToSave.id = riskLevelDto.id
        riskLevelToSave.code = riskLevelDto.code
        riskLevelToSave.description = riskLevelDto.description
        riskLevelToSave.priority = riskLevelDto.priority
        riskLevelToSave.sendEmail = riskLevelDto.sendEmail
        riskLevelToSave.sendEmailSafeguarding = riskLevelDto.sendEmailSafeguarding
        return save(riskLevelToSave)
    }
    
    /**
     * This service method is used to update an RiskLevel object in the database from a partial or complete RiskLevel object.
     *
     * @param riskLevel the partial or complete RiskLevel object to be saved
     * @return the saved version of the RiskLevel object
     */
    @Transactional
    public RiskLevel updateFromDto(RiskLevelDto riskLevelDto) {
        if (riskLevelDto == null) {
            throw new InvalidDataException("Cannot update riskLevel from null object.")
        }
        RiskLevel riskLevelToSave = findById(riskLevelDto.id);
        riskLevelToSave.code = riskLevelDto.code
        riskLevelToSave.description = riskLevelDto.description
        riskLevelToSave.priority = riskLevelDto.priority
        riskLevelToSave.sendEmail = riskLevelDto.sendEmail
        riskLevelToSave.sendEmailSafeguarding = riskLevelDto.sendEmailSafeguarding
        return save(riskLevelToSave)
    }
    
    /**
     * Saves a list of RiskLevel objects to the database
     *
     * @param riskLevels a list of RiskLevels to be saved to the database
     * @return the list of save RiskLevel objects
     */
    @Transactional
    public List<RiskLevel> saveRiskLevels(List<RiskLevel> riskLevels) {
        return riskLevels.collect { riskLevel -> save(riskLevel) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. RiskLevel should not be deleted.
     */
    @Override
    public void delete(RiskLevel obj) {
        throw new InvalidOperationException("RiskLevel should not be deleted")
    }
    
    /**
     * This method is used to retrieve a RiskLevel object by the code supplied.
     * 
     * @param code a riskLevel code to lookup
     * @return a RiskLevel object that matches the code
     */
    public findByCode(String code) {
        return riskLevelRepository.findByCode(code)
    }
}
