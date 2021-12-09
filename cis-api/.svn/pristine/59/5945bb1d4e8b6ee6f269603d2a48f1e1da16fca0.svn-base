package uk.ac.reigate.services.ilr

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.dto.ilr.EthnicityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.EthnicityRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class EthnicityService implements ICoreDataService<Ethnicity, Integer>, IDtoCreateUpdateService<EthnicityDto, Ethnicity> {
    
    @Autowired
    EthnicityRepository ethnicityRepository
    
    /**
     * Default NoArgs constructor
     */
    EthnicityService() {}
    
    /**
     * Autowired Constructor
     *
     * @param ethnicityRepository
     */
    EthnicityService(EthnicityRepository ethnicityRepository) {
        this.ethnicityRepository = ethnicityRepository;
    }
    
    /**
     * Find an individual ethnicity using the ethnicities ID fields
     *
     * @param id the ID fields to search for
     * @return the Ethnicity object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Ethnicity findById(Integer id) {
        return ethnicityRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all ethnicities
     *
     * @return a List of Ethnicities
     */
    @Override
    @Transactional(readOnly = true)
    List<Ethnicity> findAll() {
        return ethnicityRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Ethnicity object in the database
     *
     * @param ethnicity the new Ethnicity object to be saved
     * @return the saved version of the Ethnicity object
     */
    @Override
    @Transactional
    public Ethnicity save(Ethnicity ethnicity) {
        return ethnicityRepository.save(ethnicity)
    }
    
    /**
     * Saves a list of Ethnicity objects to the database
     *
     * @param ethnicities a list of Ethnicities to be saved to the database
     * @return the list of save Ethnicity objects
     */
    @Transactional
    public List<Ethnicity> saveEthnicities(List<Ethnicity> ethnicities) {
        return ethnicities.collect { ethnicity -> save(ethnicity) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Ethnicity should not be deleted.
     */
    @Override
    public void delete(Ethnicity obj) {
        throw new InvalidOperationException("Ethnicity should not be deleted");
    }
    
    /**
     * This service method is used to create an Ethnicity object in the database from a partial or complete Ethnicity object.
     *
     * @param ethnicity the partial or complete Ethnicity object to be saved
     * @return the saved version of the Ethnicity object
     */
    public Ethnicity createFromDto(EthnicityDto ethnicityDto) {
        if(ethnicityDto == null) {
            throw new InvalidDataException("Cannot create ethnicityDto from null object.")
        }
        Ethnicity ethnicity = new Ethnicity()
        ethnicity.code = ethnicityDto.code
        ethnicity.description = ethnicityDto.description
        ethnicity.shortDescription = ethnicityDto.shortDescription
        ethnicity.validFrom = ethnicityDto.validFrom
        ethnicity.validTo = ethnicityDto.validTo
        return save(ethnicity)
    }
    /**
     * This service method is used to update an Ethnicity object in the database from a partial or complete Ethnicity object.
     *
     * @param ethnicity the partial or complete Ethnicity object to be saved
     * @return the saved version of the Ethnicity object
     */
    @Transactional
    public Ethnicity updateFromDto(EthnicityDto ethnicityDto) {
        if(ethnicityDto == null) {
            throw new InvalidDataException("Cannot update ethnicityDto from null object.")
        }
        Ethnicity ethnicity = findById(ethnicityDto.id)
        ethnicity.code = ethnicityDto.code
        ethnicity.description = ethnicityDto.description
        ethnicity.shortDescription = ethnicityDto.shortDescription
        ethnicity.validFrom = ethnicityDto.validFrom
        ethnicity.validTo = ethnicityDto.validTo
        return save(ethnicity)
    }
    /**
     * This method is used to retrieve an Ethnicity object from the supplied code.
     * 
     * @param code The ethnicity code to search for.
     * @return An Ethnicity object that matches the code supplied.
     */
    public Ethnicity findByCode(String code) {
        return ethnicityRepository.findByCode(code)
    }
}
