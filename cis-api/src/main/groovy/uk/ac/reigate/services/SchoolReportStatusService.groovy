package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.dto.SchoolReportStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.SchoolReportStatusRepository

@Service
class SchoolReportStatusService implements ICoreDataService<SchoolReportStatus, Integer>, IDtoCreateUpdateService<SchoolReportStatusDto, SchoolReportStatus>{
    
    @Autowired
    SchoolReportStatusRepository schoolReportStatusRepository
    
    /**
     * Default NoArgs constructor
     */
    SchoolReportStatusService() {}
    
    /**
     * Autowired Constructor
     *
     * @param schoolReportStatusRepository
     */
    SchoolReportStatusService(SchoolReportStatusRepository schoolReportStatusRepository) {
        this.schoolReportStatusRepository = schoolReportStatusRepository;
    }
    
    /**
     * This method is used to find an individual schoolReportStatus data object using the ID field
     *
     * @param id the ID fields to search for
     * @return the SchoolReportStatus object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    SchoolReportStatus findById(Integer id) {
        return schoolReportStatusRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all schoolReportStatuss
     *
     * @return a SearchResult set with the list of SchoolReportStatuss
     */
    @Override
    @Transactional(readOnly = true)
    List<SchoolReportStatus> findAll() {
        return schoolReportStatusRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete SchoolReportStatus object in the database
     *
     * @param schoolReportStatus the new SchoolReportStatus object to be saved
     * @return the saved version of the SchoolReportStatus object
     */
    @Override
    @Transactional
    public SchoolReportStatus save(SchoolReportStatus schoolReportStatus) {
        return schoolReportStatusRepository.save(schoolReportStatus)
    }
    
    /**
     * This service method is used to create a SchoolReportStatus object in the database from a partial or complete SchoolReportStatus object.
     *
     * @param schoolReportStatus the partial or complete SchoolReportStatus object to be saved
     * @return the saved version of the SchoolReportStatus object
     */
    @Transactional
    public SchoolReportStatus createFromDto(SchoolReportStatusDto schoolReportStatusDto) {
        if (schoolReportStatusDto == null) {
            throw new InvalidDataException("Cannot create schoolReportStatusDto from null object.")
        }
        SchoolReportStatus schoolReportStatus = new SchoolReportStatus()
        schoolReportStatus.code = schoolReportStatusDto.code
        schoolReportStatus.description = schoolReportStatusDto.description
        return save(schoolReportStatus)
    }
    
    /**
     * This service method is used to update a SchoolReportStatus object in the database from a partial or complete SchoolReportStatus object.
     *
     * @param schoolReportStatus the partial or complete SchoolReportStatus object to be saved
     * @return the saved version of the SchoolReportStatus object
     */
    @Transactional
    public SchoolReportStatus updateFromDto(SchoolReportStatusDto schoolReportStatusDto) {
        if (schoolReportStatusDto == null) {
            throw new InvalidDataException("Cannot update schoolReportStatusDto from null object.")
        }
        SchoolReportStatus schoolReportStatus = findById(schoolReportStatusDto.id);
        schoolReportStatus.code = schoolReportStatusDto.code
        schoolReportStatus.description = schoolReportStatusDto.description
        return save(schoolReportStatus)
    }
    
    /**
     * Saves a list of SchoolReportStatus objects to the database
     *
     * @param schoolReportStatuss a list of SchoolReportStatuss to be saved to the database
     * @return the list of save SchoolReportStatus objects
     */
    @Transactional
    public List<SchoolReportStatus> saveSchoolReportStatuss(List<SchoolReportStatus> schoolReportStatuss) {
        return schoolReportStatuss.collect { schoolReportStatus -> save(schoolReportStatus) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. SchoolReportStatus should not be deleted.
     */
    @Override
    public void delete(SchoolReportStatus obj) {
        throw new InvalidOperationException("SchoolReportStatus should not be deleted")
    }
    
    public SchoolReportStatus findByDesc(String description){
        return schoolReportStatusRepository.findByDescription(description)
    }
}
