package uk.ac.reigate.services.ilr

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.PriorAttainment;
import uk.ac.reigate.dto.ilr.PriorAttainmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.PriorAttainmentRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class PriorAttainmentService implements ICoreDataService<PriorAttainment, Integer>, IDtoCreateUpdateService<PriorAttainmentDto, PriorAttainment>{
    
    @Autowired
    PriorAttainmentRepository priorAttainmentRepository
    
    /**
     * Default NoArgs constructor
     */
    PriorAttainmentService() {}
    
    /**
     * Autowired Constructor
     *
     * @param priorAttainmentRepository
     */
    PriorAttainmentService(PriorAttainmentRepository priorAttainmentRepository) {
        this.priorAttainmentRepository = priorAttainmentRepository
    }
    
    /**
     * Find an individual priorAttainment using the priorAttainments ID fields
     *
     * @param id the ID fields to search for
     * @return the PriorAttainment object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    PriorAttainment findById(Integer id) {
        return priorAttainmentRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all priorAttainments
     *
     * @return a SearchResult set with the list of PriorAttainments
     */
    @Override
    @Transactional(readOnly = true)
    List<PriorAttainment> findAll() {
        return priorAttainmentRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete PriorAttainment object in the database
     *
     * @param priorAttainmentr the new PriorAttainment object to be saved
     * @return the saved version of the PriorAttainment object
     */
    @Override
    @Transactional
    public PriorAttainment save(PriorAttainment priorAttainment) {
        return priorAttainmentRepository.save(priorAttainment)
    }
    
    /**
     * This service method is used to create a PriorAttainment object in the database from a partial or complete PriorAttainment object.
     *
     * @param priorAttainment the partial or complete PriorAttainment object to be saved
     * @return the saved version of the PriorAttainment object
     */
    
    @Transactional
    public PriorAttainment createFromDto(PriorAttainmentDto priorAttainment) {
        if(priorAttainment == null) {
            throw new InvalidDataException("Cannot create priorAttainment from null object.")
        }
        PriorAttainment priorAttainmentToSave = new PriorAttainment()
        priorAttainmentToSave.code = priorAttainment.code != null ? priorAttainment.code : priorAttainmentToSave.code
        priorAttainmentToSave.description = priorAttainment.description != null ? priorAttainment.description : priorAttainmentToSave.description
        priorAttainmentToSave.shortDescription = priorAttainment.shortDescription != null ? priorAttainment.shortDescription : priorAttainmentToSave.shortDescription
        priorAttainmentToSave.validFrom = priorAttainment.validFrom != null ? priorAttainment.validFrom : priorAttainmentToSave.validFrom
        priorAttainmentToSave.validTo = priorAttainment.validTo != null ? priorAttainment.validTo : priorAttainmentToSave.validTo
        return save(priorAttainmentToSave)
    }
    
    /**
     * This service method is used to update a PriorAttainment object in the database from a partial or complete PriorAttainment object.
     *
     * @param priorAttainment the partial or complete PriorAttainment object to be saved
     * @return the saved version of the PriorAttainment object
     */
    
    @Transactional
    public PriorAttainment updateFromDto(PriorAttainmentDto priorAttainment) {
        if(priorAttainment == null) {
            throw new InvalidDataException("Cannot update priorAttainment from null object.")
        }
        PriorAttainment priorAttainmentToSave = findById(priorAttainment.id)
        priorAttainmentToSave.code = priorAttainment.code != null ? priorAttainment.code : priorAttainmentToSave.code
        priorAttainmentToSave.description = priorAttainment.description != null ? priorAttainment.description : priorAttainmentToSave.description
        priorAttainmentToSave.shortDescription = priorAttainment.shortDescription != null ? priorAttainment.shortDescription : priorAttainmentToSave.shortDescription
        priorAttainmentToSave.validFrom = priorAttainment.validFrom != null ? priorAttainment.validFrom : priorAttainmentToSave.validFrom
        priorAttainmentToSave.validTo = priorAttainment.validTo != null ? priorAttainment.validTo : priorAttainmentToSave.validTo
        return save(priorAttainmentToSave)
    }
    
    /**
     * Saves a list of PriorAttainment objects to the database
     *
     * @param priorAttainments a list of PriorAttainments to be saved to the database
     * @return the list of save PriorAttainment objects
     */
    
    @Transactional
    public List<PriorAttainment> savePriorAttainments(List<PriorAttainment> priorAttainments) {
        return priorAttainments.collect { priorAttainment -> save(priorAttainment) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. PriorAttainment should not be deleted.
     */
    @Override
    public void delete(PriorAttainment obj) {
        throw new InvalidOperationException("PriorAttainment should not be deleted")
        
    }
}