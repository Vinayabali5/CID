package uk.ac.reigate.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.dto.AcademicYearDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.util.exception.IdMissingException

/**
 * This service is used to manage the AcademicYear data objects. 
 * 
 * @author Michael Horgan
 * @see uk.ac.reigate.services.IAnonymousReadDataService
 */
@Service
class AcademicYearService implements IAnonymousReadDataService<AcademicYear, Integer>, IDtoCreateUpdateService<AcademicYearDto, AcademicYear> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AcademicYearService.class);
    
    @Autowired
    AcademicYearRepository academicYearRepository
    
    /**
     * Autowired Constructor
     * 
     * @param academicYearRepository 
     */
    AcademicYearService(AcademicYearRepository academicYearRepository) {
        this.academicYearRepository = academicYearRepository
    }
    
    /**
     * This service method is used to retrieve an individual AcademicYear object from the database.
     * 
     * @param id the id of the AcademicYear object to retrieve
     * @return the AcademicYear object identified by the id
     */
    @Override
    @Transactional(readOnly = true)
    AcademicYear findById(Integer id) {
        return academicYearRepository.findById(id).orElse(null)
    }
    
    /**
     * This service method is used to retrieve all instances of the AcademicYear object from the database.
     * 
     * @return A List of AcademicYear objects
     */
    @Override
    @Transactional(readOnly = true)
    List<AcademicYear> findAll() {
        List<AcademicYear> academicYears = academicYearRepository.findAll();
        return academicYears
    }
    
    /**
     * This service method is used to save a complete AcademicYear object in the database
     *  
     * @param academicYear the new AcademicYear object to be saved
     * @return the saved version of the AcademicYear object
     */
    @Override
    @Transactional
    public AcademicYear save(AcademicYear academicYear) {
        return academicYearRepository.save(academicYear)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. AcademicYears should not be deleted.
     */
    @Override
    @Transactional
    public void delete(AcademicYear obj) {
        throw new InvalidOperationException("AcademicYears should not be deleted.")
    }
    
    /**
     * This service method is used to create an AcademicYear object in the database from a partial or complete AcademicYear object.
     *
     * @param academicYear the partial or complete AcademicYear object to be saved
     * @return the saved version of the AcademicYear object
     */
    @Transactional
    public AcademicYear createFromDto(AcademicYearDto academicYear) {
        if (academicYear == null) {
            throw new InvalidDataException("Cannot create AcademicYear from null object.")
        }
        if (findById(academicYear.id) != null) {
            throw new IdMissingException("An academic year already exist with this ID.")
        }
        AcademicYear academicYearToSave = new AcademicYear()
        academicYearToSave.id = academicYear.id
        academicYearToSave.code = academicYear.code
        academicYearToSave.description = academicYear.description
        academicYearToSave.startDate = academicYear.startDate
        academicYearToSave.endDate = academicYear.endDate
        academicYearToSave.startYear = academicYear.startYear
        academicYearToSave.enumerationDate = academicYear.enumerationDate
        academicYearToSave.teachingStartDate = academicYear.teachingStartDate
        academicYearToSave.teachingEndDate = academicYear.teachingEndDate
        return save(academicYearToSave)
    }
    
    /**
     * This service method is used to update an AcademicYear object in the database from a partial or complete AcademicYear object.
     * 
     * @param academicYear the partial or complete AcademicYear object to be saved
     * @return the saved version of the AcademicYear object
     */
    @Transactional
    public AcademicYear updateFromDto(AcademicYearDto academicYear) {
        if (academicYear == null) {
            throw new InvalidDataException("Cannot update AcademicYear from null object.")
        }
        if (academicYear.id == null) {
            throw new InvalidDataException("Cannot update AcademicYear when the ID is null.")
        }
        AcademicYear academicYearToUpdate = findById(academicYear.id)
        academicYearToUpdate.code = academicYear.code
        academicYearToUpdate.description = academicYear.description
        academicYearToUpdate.startDate = academicYear.startDate
        academicYearToUpdate.endDate = academicYear.endDate
        academicYearToUpdate.startYear = academicYear.startYear
        academicYearToUpdate.enumerationDate = academicYear.enumerationDate
        academicYearToUpdate.teachingStartDate = academicYear.teachingStartDate
        academicYearToUpdate.teachingEndDate = academicYear.teachingEndDate
        return save(academicYearToUpdate)
    }
    
    
    /**
     * This service method is used to save a list of complete AcademicYear objects to the database. 
     * 
     * @param academicYears a list of AcademicYear objects to persist to the database
     * @return the saved version of the list of AcademicYear objects
     */
    @Transactional
    public List<AcademicYear> saveAcademicYears(List<AcademicYear> academicYears) {
        return academicYears.collect { academicYear -> save(academicYear) };
    }
    
    /**
     * This service method is used to retrieve the AcademicYear as specified by the code  
     * 
     * @param code the code of the AcademicYear to retrieve
     * @return the AcademicYear with a matching code
     */
    public AcademicYear findByCode(String code) {
        return academicYearRepository.findByCode(code)
    }
    
    
    /**
     * This service method is used to retrieve the current AcademicYear
     *
     * @return the current AcademicYear
     */
    public AcademicYear getCurrentAcademicYear() {
        return academicYearRepository.findCurrent()
    }
    
    /**
     * This service method is used to retrieve the next AcademicYear
     * 
     * @return the next AcademicYear
     */
    public AcademicYear getNextAcademicYear() {
        return academicYearRepository.findNext()
    }
    
    /**
     * This service method is used to retrieve the previous AcademicYear
     *
     * @return the next AcademicYear
     */
    public AcademicYear getPreviousAcademicYear() {
        return academicYearRepository.findPrevious()
    }
    
    /**
     * This method is used to retrieve an AcademicYear where the supplied date fall between
     * the start and end dates.
     * 
     * @param date a date to use for the search
     * @return an AcademicYear matching the criteria
     */
    public AcademicYear findByDate(Date date) {
        return academicYearRepository.findByDate(date)
    }
}
