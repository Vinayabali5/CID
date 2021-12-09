package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.Religion
import uk.ac.reigate.dto.staff.ReligionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.ReligionRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class ReligionService implements ICoreDataService<Religion, Integer>, IDtoCreateUpdateService<ReligionDto, Religion>{
    
    @Autowired
    ReligionRepository religionRepository
    
    /**
     * Default NoArgs constructor
     */
    ReligionService() {}
    
    /**
     * Autowired Constructor
     *
     * @param religionRepository
     */
    ReligionService(ReligionRepository religionRepository) {
        this.religionRepository = religionRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param religionRepository
     */
    @Override
    @Transactional(readOnly = true)
    Religion findById(Integer id) {
        return religionRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of Religion objects
     * @return a SearchResult set with the list of Religions
     */
    @Override
    @Transactional(readOnly = true)
    List<Religion> findAll() {
        return religionRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Religion object in the database
     *
     * @param religion the new Religion object to be saved
     * @return the saved version of the Religion object
     */
    @Override
    @Transactional
    public Religion save(Religion religion) {
        return religionRepository.save(religion)
    }
    
    /**
     * This service method is used to create a Religion object in the database from a partial or complete Religion object.
     *
     * @param religion the partial or complete Religion object to be saved
     * @return the saved version of the Religion object
     */
    @Transactional
    public Religion createFromDto(ReligionDto religionDto) {
        if (religionDto == null) {
            throw new InvalidDataException("Cannot create religionDto from null object.")
        }
        Religion religion = new Religion()
        religion.religion = religionDto.religion
        return  save(religion)
    }
    
    /**
     * This service method is used to update a Religion object in the database from a partial or complete Religion object.
     *
     * @param religion the partial or complete Religion object to be saved
     * @return the saved version of the Religion object
     */
    @Transactional
    public Religion updateFromDto(ReligionDto religionDto) {
        if (religionDto == null) {
            throw new InvalidDataException("Cannot update religionDto from null object.")
        }
        Religion religion = findById(religionDto.id)
        religion.religion = religionDto.religion
        return  save(religion)
    }
    
    /**
     * Saves a list of Religion objects to the database
     *
     * @param religions a list of Religions to be saved to the database
     * @return the list of save Religion objects
     */
    @Transactional
    public List<Religion> saveReligions(List<Religion> religions) {
        return religions.collect { religion -> save(religion) };
    }
    /**
     * This methods throws an InvalidOperationException when called. Religion should not be deleted.
     */
    @Override
    public void delete(Religion obj) {
        throw new InvalidOperationException("Religion should not be deleted")
    }
}
