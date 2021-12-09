package uk.ac.reigate.services.ilr

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.Outcome
import uk.ac.reigate.dto.ilr.OutcomeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.OutcomeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class OutcomeService implements ICoreDataService<Outcome, Integer>, IDtoCreateUpdateService<OutcomeDto, Outcome>{
    
    @Autowired
    OutcomeRepository outcomeRepository
    
    /**
     * Default NoArgs constructor
     */
    OutcomeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param outcomeRepository
     */
    OutcomeService(OutcomeRepository outcomeRepository) {
        this.outcomeRepository = outcomeRepository;
    }
    
    /**
     * Find an individual outcome using the outcomes ID fields
     *
     * @param id the ID fields to search for
     * @return the Outcome object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Outcome findById(Integer id) {
        return outcomeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all outcomes
     *
     * @return a List of Outcomes
     */
    @Override
    @Transactional(readOnly = true)
    List<Outcome> findAll() {
        return outcomeRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete Outcome object in the database
     *
     * @param outcomer the new Outcome object to be saved
     * @return the saved version of the Outcome object
     */
    @Override
    @Transactional
    public Outcome save(Outcome outcome) {
        return outcomeRepository.save(outcome)
    }
    
    /**
     * This service method is used to update an Outcome object in the database from a partial or complete Outcome object.
     *
     * @param outcome outcome the partial or complete Outcome object to be saved
     * @return the saved version of the Outcome object
     */
    @Transactional
    public Outcome createFromDto(OutcomeDto outcome) {
        if(outcome == null) {
            throw new InvalidDataException("Cannot create outcome from null object.")
        }
        Outcome outcomeToSave = new Outcome()
        outcomeToSave.code = outcome.code != null ? outcome.code : outcomeToSave.code
        outcomeToSave.description = outcome.description != null ? outcome.description : outcomeToSave.description
        outcomeToSave.shortDescription = outcome.shortDescription != null ? outcome.shortDescription : outcomeToSave.shortDescription
        outcomeToSave.validFrom = outcome.validFrom != null ? outcome.validFrom : outcomeToSave.validFrom
        outcomeToSave.validTo = outcome.validTo != null ? outcome.validTo : outcomeToSave.validTo
        return save(outcomeToSave)
    }
    
    /**
     * This service method is used to update an Outcome object in the database from a partial or complete Outcome object.
     * 
     * @param outcome outcome the partial or complete Outcome object to be saved
     * @return the saved version of the Outcome object
     */
    @Transactional
    public Outcome updateFromDto(OutcomeDto outcome) {
        if(outcome == null) {
            throw new InvalidDataException("Cannot update outcome from null object.")
        }
        Outcome outcomeToSave = findById(outcome.id)
        outcomeToSave.code = outcome.code != null ? outcome.code : outcomeToSave.code
        outcomeToSave.description = outcome.description != null ? outcome.description : outcomeToSave.description
        outcomeToSave.shortDescription = outcome.shortDescription != null ? outcome.shortDescription : outcomeToSave.shortDescription
        outcomeToSave.validFrom = outcome.validFrom != null ? outcome.validFrom : outcomeToSave.validFrom
        outcomeToSave.validTo = outcome.validTo != null ? outcome.validTo : outcomeToSave.validTo
        return save(outcomeToSave)
    }
    
    /**
     * Saves a list of Outcome objects to the database
     *
     * @param outcomes a list of Outcomes to be saved to the database
     * @return the list of save Outcome objects
     */
    @Transactional
    public List<Outcome> saveOutcomes(List<Outcome> outcomes) {
        return outcomes.collect { outcome -> save(outcome) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Outcome should not be deleted.
     */
    @Override
    public void delete(Outcome obj) {
        throw new InvalidOperationException("Outcome should not be deleted")
    }
}
