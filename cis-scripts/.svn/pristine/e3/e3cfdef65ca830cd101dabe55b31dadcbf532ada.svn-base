package uk.ac.reigate.services.schoolimport

//import static org.springframework.util.Assert

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.utils.ValidationUtils;

@Service
class AcademicYearService {
    
    @Autowired
    AcademicYearRepository academicYearRepository
    
    /**
     * Default NoArgs constructor
     */
    AcademicYearService() {}
    
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
    @Transactional(readOnly = true)
    AcademicYear findAcademicYear(Integer id) {
        return academicYearRepository.findOne(id);
    }
    
    /**
     * This service method is used to retrieve all instances of the AcademicYear object from the database.
     * 
     * @return A List of AcademicYear objects
     */
    @Transactional(readOnly = true)
    SearchResult<AcademicYear> findAcademicYears() {
        List<AcademicYear> academicYears = academicYearRepository.findAll();
        int resultsCount = academicYears.size()
        return new SearchResult<>(resultsCount, academicYears);
    }
    
    @Transactional
    public AcademicYear saveAcademicYear(Integer id, String code, String description, Date startDate, Date endDate) {
        ValidationUtils.assertNotBlank(code, "code cannot be blank");
        ValidationUtils.assertNotNull(description, "description is mandatory");
        ValidationUtils.assertNotNull(startDate, "description is mandatory");
        ValidationUtils.assertNotNull(endDate, "description is mandatory");
        
        AcademicYear academicYear = null;
        if (id != null) {
            academicYear = academicYearRepository.findOne(id);
            academicYear.setCode(code);
            academicYear.setDescription(description);
            academicYear.setStartDate(startDate);
            academicYear.setEndDate(endDate);
            
            academicYearRepository.save(academicYear);
        } else {
            academicYear = academicYearRepository.save(new AcademicYear(code, description, startDate, endDate));
        }
        
        return academicYear;
    }
    
    /**
     * This service method is used to save a complete AcademicYear object in the database
     * 
     * @param academicYear the new AcademicYear object to be saved
     * @return the saved version of the AcademicYear object
     */
    @Transactional
    public AcademicYear saveAcademicYear(AcademicYear academicYear) {
        return academicYearRepository.save(academicYear)
    }
    
    /**
     * This service method is used to update an AcademicYear object in the database from a partial or complete AcademicYear object.
     * 
     * @param academicYear the partial or complete AcademicYear object to be saved
     * @return the saved version of the AcademicYear object
     */
    @Transactional
    public AcademicYear updateAcademicYear(AcademicYear academicYear) {
        AcademicYear academicYearToSave = academicYearRepository.findOne(academicYear.id)
        academicYearToSave.code = academicYear.code != null ? academicYear.code : academicYearToSave.code
        academicYearToSave.description = academicYear.description != null ? academicYear.description : academicYearToSave.description
        academicYearToSave.startDate = academicYear.startDate != null ? academicYear.startDate : academicYearToSave.startDate
        academicYearToSave.endDate = academicYear.endDate != null ? academicYear.endDate : academicYearToSave.endDate
        return academicYearRepository.save(academicYearToSave)
    }
    
    
    /**
     * This service method is used to save a list of complete AcademicYear objects to the database. 
     * 
     * @param academicYears a list of AcademicYear objects to persist to the database
     * @return the saved version of the list of AcademicYear objects
     */
    @Transactional
    public List<AcademicYear> saveAcademicYears(List<AcademicYear> academicYears) {
        return academicYears.collect { academicYear -> saveAcademicYear(academicYear) };
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
    
}
