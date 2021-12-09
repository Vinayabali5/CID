package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.VolunteeringExperience
import uk.ac.reigate.dto.lookup.VolunteeringExperienceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.VolunteeringExperienceRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class VolunteeringExperienceService implements ICoreDataService<VolunteeringExperience, Integer>, IDtoCreateUpdateService<VolunteeringExperienceDto, VolunteeringExperience>{
    
    @Autowired
    VolunteeringExperienceRepository volunteeringExperienceRepository
    
    /**
     * Default NoArgs constructor
     */
    VolunteeringExperienceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param volunteeringExperienceRepository
     */
    VolunteeringExperienceService(VolunteeringExperienceRepository volunteeringExperienceRepository) {
        this.volunteeringExperienceRepository = volunteeringExperienceRepository;
    }
    
    /**
     * Find an individual volunteeringExperience using the volunteeringExperiences ID fields
     *
     * @param id the ID fields to search for
     * @return the VolunteeringExperience object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    VolunteeringExperience findById(Integer id) {
        return volunteeringExperienceRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all volunteeringExperiences
     *
     * @return a SearchResult set with the list of VolunteeringExperiences
     */
    @Override
    @Transactional(readOnly = true)
    List<VolunteeringExperience> findAll() {
        return volunteeringExperienceRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete VolunteeringExperience object in the database
     *
     * @param volunteeringExperience the new VolunteeringExperience object to be saved
     * @return the saved version of the VolunteeringExperience object
     */
    @Override
    @Transactional
    public VolunteeringExperience save(VolunteeringExperience volunteeringExperience) {
        return volunteeringExperienceRepository.save(volunteeringExperience)
    }
    
    /**
     * Saves a list of VolunteeringExperience objects to the database
     *
     * @param volunteeringExperiences a list of VolunteeringExperiences to be saved to the database
     * @return the list of save VolunteeringExperience objects
     */
    @Transactional
    public List<VolunteeringExperience> saveVolunteeringExperiences(List<VolunteeringExperience> volunteeringExperiences) {
        return volunteeringExperiences.collect { volunteeringExperience -> save(volunteeringExperience) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. VolunteeringExperience should not be deleted.
     */
    @Override
    public void delete(VolunteeringExperience obj) {
        throw new InvalidOperationException("VolunteeringExperience should not be deleted");
    }
    
    /**
     * This service method is used to create an VolunteeringExperience object in the database from a partial or complete VolunteeringExperience object.
     *
     * @param volunteeringExperience the partial or complete VolunteeringExperience object to be saved
     * @return the saved version of the VolunteeringExperience object
     */
    @Transactional
    public VolunteeringExperience createFromDto(VolunteeringExperienceDto volunteeringExperienceDto) {
        if (volunteeringExperienceDto == null) {
            throw new InvalidDataException("Cannot create volunteeringExperience from null object.")
        }
        VolunteeringExperience volunteeringExperience = new VolunteeringExperience()
        volunteeringExperience.code = volunteeringExperienceDto.code
        volunteeringExperience.description = volunteeringExperienceDto.description
        return save(volunteeringExperience)
    }
    
    /**
     * This service method is used to update an VolunteeringExperience object in the database from a partial or complete VolunteeringExperience object.
     *
     * @param volunteeringExperience the partial or complete VolunteeringExperience object to be saved
     * @return the saved version of the VolunteeringExperience object
     */
    @Transactional
    public VolunteeringExperience updateFromDto(VolunteeringExperienceDto volunteeringExperienceDto) {
        if (volunteeringExperienceDto == null) {
            throw new InvalidDataException("Cannot update volunteeringExperience from null object.")
        }
        VolunteeringExperience volunteeringExperience = findById(volunteeringExperienceDto.id);
        volunteeringExperience.code = volunteeringExperienceDto.code
        volunteeringExperience.description = volunteeringExperienceDto.description
        return save(volunteeringExperience)
    }
}
