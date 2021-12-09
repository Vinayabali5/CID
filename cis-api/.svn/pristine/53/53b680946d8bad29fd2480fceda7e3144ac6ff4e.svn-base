package uk.ac.reigate.services.staff

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.staff.AbsenceReason
import uk.ac.reigate.dto.staff.AbsenceReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.staff.AbsenceReasonRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class AbsenceReasonService implements ICoreDataService<AbsenceReason, Integer>, IDtoCreateUpdateService<AbsenceReasonDto, AbsenceReason>{
    
    @Autowired
    AbsenceReasonRepository absenceReasonRepository
    
    /**
     * Default NoArgs constructor
     */
    AbsenceReasonService() {}
    
    /**
     * Autowired Constructor
     *
     * @param absenceReasonRepository
     */
    AbsenceReasonService(AbsenceReasonRepository absenceReasonRepository) {
        this.absenceReasonRepository = absenceReasonRepository;
    }
    
    /**
     * Autowired Constructor
     *
     * @param absenceReasonRepository
     */
    @Override
    @Transactional(readOnly = true)
    AbsenceReason findById(Integer id) {
        return absenceReasonRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of AbsenceReason objects
     * @return a SearchResult set with the list of Nationalities
     */
    @Override
    @Transactional(readOnly = true)
    List<AbsenceReason> findAll() {
        return absenceReasonRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete AbsenceReason object in the database
     *
     * @param absenceReason the new AbsenceReason object to be saved
     * @return the saved version of the AbsenceReason object
     */
    @Override
    @Transactional
    public AbsenceReason save(AbsenceReason absenceReason) {
        return absenceReasonRepository.save(absenceReason)
    }
    
    /**
     * This service method is used to create a AbsenceReason object in the database from a partial or complete AbsenceReason object.
     *
     * @param absenceReason the partial or complete AbsenceReason object to be saved
     * @return the saved version of the AbsenceReason object
     */
    @Transactional
    public AbsenceReason createFromDto(AbsenceReasonDto absenceReasonDto) {
        if (absenceReasonDto == null) {
            throw new InvalidDataException("Cannot create absenceReasonDto from null object.")
        }
        AbsenceReason absenceReason = new AbsenceReason()
        absenceReason.disability = absenceReasonDto.disability
        return  save(absenceReason)
    }
    
    /**
     * This service method is used to update a AbsenceReason object in the database from a partial or complete AbsenceReason object.
     *
     * @param absenceReason the partial or complete AbsenceReason object to be saved
     * @return the saved version of the AbsenceReason object
     */
    @Transactional
    public AbsenceReason updateFromDto(AbsenceReasonDto absenceReasonDto) {
        if (absenceReasonDto == null) {
            throw new InvalidDataException("Cannot update absenceReasonDto from null object.")
        }
        AbsenceReason absenceReason = findById(absenceReasonDto.id)
        absenceReason.disability = absenceReasonDto.disability
        return  save(absenceReason)
    }
    
    /**
     * Saves a list of AbsenceReason objects to the database
     *
     * @param absenceReasons a list of Nationalities to be saved to the database
     * @return the list of save AbsenceReason objects
     */
    @Transactional
    public List<AbsenceReason> saveAbsenceReasons(List<AbsenceReason> absenceReasons) {
        return absenceReasons.collect { absenceReason -> save(absenceReason) };
    }
    /**
     * This methods throws an InvalidOperationException when called. AbsenceReason should not be deleted.
     */
    @Override
    public void delete(AbsenceReason obj) {
        throw new InvalidOperationException("AbsenceReason should not be deleted")
    }
}
