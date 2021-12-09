package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.Disability
import uk.ac.reigate.dto.staff.DisabilityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.DisabilityRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class DisabilityService implements ICoreDataService<Disability, Integer>, IDtoCreateUpdateService<DisabilityDto, Disability>{
    
    @Autowired
    DisabilityRepository disabilityRepository
    
    /**
     * Default NoArgs constructor
     */
    DisabilityService() {}
    
    /**
     * Autowired Constructor
     *
     * @param disabilityRepository
     */
    DisabilityService(DisabilityRepository disabilityRepository) {
        this.disabilityRepository = disabilityRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param disabilityRepository
     */
    @Override
    @Transactional(readOnly = true)
    Disability findById(Integer id) {
        return disabilityRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of Disability objects
     * @return a SearchResult set with the list of Nationalities
     */
    @Override
    @Transactional(readOnly = true)
    List<Disability> findAll() {
        return disabilityRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Disability object in the database
     *
     * @param disability the new Disability object to be saved
     * @return the saved version of the Disability object
     */
    @Override
    @Transactional
    public Disability save(Disability disability) {
        return disabilityRepository.save(disability)
    }
    
    /**
     * This service method is used to create a Disability object in the database from a partial or complete Disability object.
     *
     * @param disability the partial or complete Disability object to be saved
     * @return the saved version of the Disability object
     */
    @Transactional
    public Disability createFromDto(DisabilityDto disabilityDto) {
        if (disabilityDto == null) {
            throw new InvalidDataException("Cannot create disabilityDto from null object.")
        }
        Disability disability = new Disability()
        disability.disability = disabilityDto.disability
        return  save(disability)
    }
    
    /**
     * This service method is used to update a Disability object in the database from a partial or complete Disability object.
     *
     * @param disability the partial or complete Disability object to be saved
     * @return the saved version of the Disability object
     */
    @Transactional
    public Disability updateFromDto(DisabilityDto disabilityDto) {
        if (disabilityDto == null) {
            throw new InvalidDataException("Cannot update disabilityDto from null object.")
        }
        Disability disability = findById(disabilityDto.id)
        disability.disability = disabilityDto.disability
        return  save(disability)
    }
    
    /**
     * Saves a list of Disability objects to the database
     *
     * @param disabilitys a list of Nationalities to be saved to the database
     * @return the list of save Disability objects
     */
    @Transactional
    public List<Disability> saveNationalities(List<Disability> disabilities) {
        return disabilities.collect { disability -> save(disability) };
    }
    /**
     * This methods throws an InvalidOperationException when called. Disability should not be deleted.
     */
    @Override
    public void delete(Disability obj) {
        throw new InvalidOperationException("Disability should not be deleted")
    }
}
