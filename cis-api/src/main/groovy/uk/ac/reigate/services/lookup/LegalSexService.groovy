package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.dto.lookup.LegalSexDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.LegalSexRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class LegalSexService implements ICoreDataService<LegalSex, Integer>, IDtoCreateUpdateService<LegalSexDto, LegalSex>{
    
    @Autowired
    LegalSexRepository legalSexRepository
    
    /**
     * Default NoArgs constructor
     */
    LegalSexService() {}
    
    /**
     * Autowired Constructor
     *
     * @param legalSexRepository
     */
    LegalSexService(LegalSexRepository legalSexRepository) {
        this.legalSexRepository = legalSexRepository;
    }
    
    /**
     * Find an individual legalSex using the legalSexs ID fields
     *
     * @param id the ID fields to search for
     * @return the LegalSex object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    LegalSex findById(Integer id) {
        return legalSexRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all legalSexs
     *
     * @return a SearchResult set with the list of LegalSexs
     */
    @Override
    @Transactional(readOnly = true)
    List<LegalSex> findAll() {
        return legalSexRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete LegalSex object in the database
     *
     * @param legalSex the new LegalSex object to be saved
     * @return the saved version of the LegalSex object
     */
    @Override
    @Transactional
    public LegalSex save(LegalSex legalSex) {
        return legalSexRepository.save(legalSex)
    }
    
    /**
     * This service method is used to update an LegalSex object in the database from a partial or complete LegalSex object.
     *
     * @param legalSex the partial or complete LegalSex object to be saved
     * @return the saved version of the LegalSex object
     */
    @Transactional
    public LegalSex createFromDto(LegalSexDto legalSexDto) {
        if (legalSexDto == null) {
            throw new InvalidDataException("Cannot create legalSex from null object.")
        }
        LegalSex legalSexToSave = new LegalSex()
        legalSexToSave.code = legalSexDto.code
        legalSexToSave.description = legalSexDto.description
        return save(legalSexToSave)
    }
    
    /**
     * This service method is used to update an LegalSex object in the database from a partial or complete LegalSex object.
     *
     * @param legalSex the partial or complete LegalSex object to be saved
     * @return the saved version of the LegalSex object
     */
    @Transactional
    public LegalSex updateFromDto(LegalSexDto legalSexDto) {
        if (legalSexDto == null) {
            throw new InvalidDataException("Cannot update legalSex from null object.")
        }
        LegalSex legalSexToSave = findById(legalSexDto.id);
        legalSexToSave.code = legalSexDto.code
        legalSexToSave.description = legalSexDto.description
        return save(legalSexToSave)
    }
    
    /**
     * Saves a list of LegalSex objects to the database
     *
     * @param legalSexs a list of LegalSexs to be saved to the database
     * @return the list of save LegalSex objects
     */
    @Transactional
    public List<LegalSex> saveLegalSexs(List<LegalSex> legalSexs) {
        return legalSexs.collect { legalSex -> save(legalSex) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. LegalSex should not be deleted.
     */
    @Override
    public void delete(LegalSex obj) {
        throw new InvalidOperationException("LegalSex should not be deleted")
    }
    
    /**
     * This method is used to retrieve a LegalSex object by the code supplied.
     * 
     * @param code a legalSex code to lookup
     * @return a LegalSex object that matches the code
     */
    public findByCode(String code) {
        return legalSexRepository.findByCode(code)
    }
}
