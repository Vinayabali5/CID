package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.dto.lookup.GenderDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.GenderRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class GenderService implements ICoreDataService<Gender, Integer>, IDtoCreateUpdateService<GenderDto, Gender>{
    
    @Autowired
    GenderRepository genderRepository
    
    /**
     * Default NoArgs constructor
     */
    GenderService() {}
    
    /**
     * Autowired Constructor
     *
     * @param genderRepository
     */
    GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }
    
    /**
     * Find an individual gender using the genders ID fields
     *
     * @param id the ID fields to search for
     * @return the Gender object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Gender findById(Integer id) {
        return genderRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all genders
     *
     * @return a SearchResult set with the list of Genders
     */
    @Override
    @Transactional(readOnly = true)
    List<Gender> findAll() {
        return genderRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Gender object in the database
     *
     * @param gender the new Gender object to be saved
     * @return the saved version of the Gender object
     */
    @Override
    @Transactional
    public Gender save(Gender gender) {
        return genderRepository.save(gender)
    }
    
    /**
     * This service method is used to update an Gender object in the database from a partial or complete Gender object.
     *
     * @param gender the partial or complete Gender object to be saved
     * @return the saved version of the Gender object
     */
    @Transactional
    public Gender createFromDto(GenderDto genderDto) {
        if (genderDto == null) {
            throw new InvalidDataException("Cannot create gender from null object.")
        }
        Gender genderToSave = new Gender()
        genderToSave.code = genderDto.code
        genderToSave.description = genderDto.description
        genderToSave.sonDaughter = genderDto.sonDaughter
        genderToSave.heShe = genderDto.heShe
        genderToSave.himHer = genderDto.himHer
        genderToSave.hisHer = genderDto.hisHer
        return save(genderToSave)
    }
    
    /**
     * This service method is used to update an Gender object in the database from a partial or complete Gender object.
     *
     * @param gender the partial or complete Gender object to be saved
     * @return the saved version of the Gender object
     */
    @Transactional
    public Gender updateFromDto(GenderDto genderDto) {
        if (genderDto == null) {
            throw new InvalidDataException("Cannot update gender from null object.")
        }
        Gender genderToSave = findById(genderDto.id);
        genderToSave.code = genderDto.code
        genderToSave.description = genderDto.description
        genderToSave.sonDaughter = genderDto.sonDaughter
        genderToSave.heShe = genderDto.heShe
        genderToSave.himHer = genderDto.himHer
        genderToSave.hisHer = genderDto.hisHer
        return save(genderToSave)
    }
    
    /**
     * Saves a list of Gender objects to the database
     *
     * @param genders a list of Genders to be saved to the database
     * @return the list of save Gender objects
     */
    @Transactional
    public List<Gender> saveGenders(List<Gender> genders) {
        return genders.collect { gender -> save(gender) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Gender should not be deleted.
     */
    @Override
    public void delete(Gender obj) {
        throw new InvalidOperationException("Gender should not be deleted")
    }
    
    /**
     * This method is used to retrieve a Gender object by the code supplied.
     * 
     * @param code a gender code to lookup
     * @return a Gender object that matches the code
     */
    public findByCode(String code) {
        return genderRepository.findByCode(code)
    }
}
