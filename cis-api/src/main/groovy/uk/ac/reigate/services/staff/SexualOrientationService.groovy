package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.SexualOrientation
import uk.ac.reigate.dto.staff.SexualOrientationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.SexualOrientationRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class SexualOrientationService implements ICoreDataService<SexualOrientation, Integer>, IDtoCreateUpdateService<SexualOrientationDto, SexualOrientation>{
    
    @Autowired
    SexualOrientationRepository sexualOrientationRepository
    
    /**
     * Default NoArgs constructor
     */
    SexualOrientationService() {}
    
    /**
     * Autowired Constructor
     *
     * @param sexualOrientationRepository
     */
    SexualOrientationService(SexualOrientationRepository sexualOrientationRepository) {
        this.sexualOrientationRepository = sexualOrientationRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param sexualOrientationRepository
     */
    @Override
    @Transactional(readOnly = true)
    SexualOrientation findById(Integer id) {
        return sexualOrientationRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of SexualOrientation objects
     * @return a SearchResult set with the list of Nationalities
     */
    @Override
    @Transactional(readOnly = true)
    List<SexualOrientation> findAll() {
        return sexualOrientationRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete SexualOrientation object in the database
     *
     * @param sexualOrientation the new SexualOrientation object to be saved
     * @return the saved version of the SexualOrientation object
     */
    @Override
    @Transactional
    public SexualOrientation save(SexualOrientation sexualOrientation) {
        return sexualOrientationRepository.save(sexualOrientation)
    }
    
    /**
     * This service method is used to create a SexualOrientation object in the database from a partial or complete SexualOrientation object.
     *
     * @param sexualOrientation the partial or complete SexualOrientation object to be saved
     * @return the saved version of the SexualOrientation object
     */
    @Transactional
    public SexualOrientation createFromDto(SexualOrientationDto sexualOrientationDto) {
        if (sexualOrientationDto == null) {
            throw new InvalidDataException("Cannot create sexualOrientationDto from null object.")
        }
        SexualOrientation sexualOrientation = new SexualOrientation()
        sexualOrientation.sexualOrientation = sexualOrientationDto.sexualOrientation
        return  save(sexualOrientation)
    }
    
    /**
     * This service method is used to update a SexualOrientation object in the database from a partial or complete SexualOrientation object.
     *
     * @param sexualOrientation the partial or complete SexualOrientation object to be saved
     * @return the saved version of the SexualOrientation object
     */
    @Transactional
    public SexualOrientation updateFromDto(SexualOrientationDto sexualOrientationDto) {
        if (sexualOrientationDto == null) {
            throw new InvalidDataException("Cannot update sexualOrientationDto from null object.")
        }
        SexualOrientation sexualOrientation = findById(sexualOrientationDto.id)
        sexualOrientation.sexualOrientation = sexualOrientationDto.sexualOrientation
        return  save(sexualOrientation)
    }
    
    /**
     * Saves a list of SexualOrientation objects to the database
     *
     * @param sexualOrientations a list of Nationalities to be saved to the database
     * @return the list of save SexualOrientation objects
     */
    @Transactional
    public List<SexualOrientation> saveNationalities(List<SexualOrientation> disabilities) {
        return disabilities.collect { sexualOrientation -> save(sexualOrientation) };
    }
    /**
     * This methods throws an InvalidOperationException when called. SexualOrientation should not be deleted.
     */
    @Override
    public void delete(SexualOrientation obj) {
        throw new InvalidOperationException("SexualOrientation should not be deleted")
    }
}
