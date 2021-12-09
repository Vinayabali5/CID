package uk.ac.reigate.services.interimreport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.interimreport.InterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.interimreport.InterimReportRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class InterimReportService implements ICoreDataService<InterimReport, Integer>, IDtoCreateUpdateService<InterimReportDto, InterimReport>{
    
    @Autowired
    InterimReportRepository interimReportRepository
    
    @Autowired
    private final AcademicYearService academicYearService
    
    /**
     * Default NoArgs constructor
     */
    InterimReportService() {}
    
    /**
     * Autowired Constructor
     *
     * @param interimReportRepository
     */
    InterimReportService(InterimReportRepository interimReportRepository, AcademicYearService academicYearService) {
        this.interimReportRepository = interimReportRepository;
        this.academicYearService = academicYearService;
    }
    
    /**
     * Find an individual interimReport using the interimReports ID fields
     *
     * @param id the ID fields to search for
     * @return the InterimReport object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    InterimReport findById(Integer id) {
        return interimReportRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of InterimReport objects
     * @return a SearchResult set with the list of InterimReports
     */
    @Override
    @Transactional(readOnly = true)
    List<InterimReport> findAll() {
        return interimReportRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete InterimReport object in the database
     *
     * @param interimReport the new InterimReport object to be saved
     * @return the saved version of the InterimReport object
     */
    @Override
    @Transactional
    public InterimReport save(InterimReport interimReport) {
        return interimReportRepository.save(interimReport)
    }
    
    /**
     * This service method is used to create an InterimReport object in the database from a partial or complete InterimReport object.
     *
     * @param interimReport the partial or complete InterimReport object to be saved
     * @return the saved version of the InterimReport object
     */
    @Transactional
    public InterimReport createFromDto(InterimReportDto interimReport) {
        if (interimReport == null) {
            throw new InvalidDataException("Cannot create interimReportDto from null object.")
        }
        InterimReport interimReportToSave = new InterimReport()
        interimReportToSave.description = interimReport.description
        if (interimReport.yearId != null) {
            interimReportToSave.year = academicYearService.findById(interimReport.yearId)
        }
        interimReportToSave.startDate = interimReport.startDate
        interimReportToSave.endDate = interimReport.endDate
        interimReportToSave.publishDate = interimReport.publishDate
        interimReportToSave.active = interimReport.active
        return save(interimReportToSave)
    }
    
    /**
     * This service method is used to update an InterimReport object in the database from a partial or complete InterimReport object.
     *
     * @param interimReport the partial or complete InterimReport object to be saved
     * @return the saved version of the InterimReport object
     */
    @Transactional
    public InterimReport updateFromDto(InterimReportDto interimReport) {
        if (interimReport == null) {
            throw new InvalidDataException("Cannot update interimReportDto from null object.")
        }
        InterimReport interimReportToSave = findById(interimReport.id)
        if (interimReport.yearId != null) {
            interimReportToSave.year = academicYearService.findById(interimReport.yearId)
        }
        interimReportToSave.description = interimReport.description
        interimReportToSave.startDate = interimReport.startDate
        interimReportToSave.endDate = interimReport.endDate
        interimReportToSave.publishDate = interimReport.publishDate
        interimReportToSave.active = interimReport.active
        return save(interimReportToSave)
    }
    
    /**
     * Saves a list of InterimReport objects to the database
     *
     * @param interimReports a list of InterimReports to be saved to the database
     * @return the list of save InterimReport objects
     */
    @Transactional
    public List<InterimReport> saveInterimReports(List<InterimReport> interimReports) {
        return interimReports.collect { interimReport -> save(interimReport) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. InterimReport should not be deleted.
     */
    @Override
    public void delete(InterimReport obj) {
        throw new InvalidOperationException("InterimReport should not be deleted")
    }
    
    /**
     * This method is used to retrieve the current active interim report.
     * 
     * @return the current active interim report
     */
    public InterimReport getCurrent() {
        return interimReportRepository.findTopByActiveIsTrueOrderByStartDateDesc()
    }
    
    /**
     * This method is used to retrieve the previous interim report based on which ever interim report is 
     * currently active.
     * 
     * @return
     */
    public InterimReport getPrevious() {
        return interimReportRepository.findTopByStartDateLessThanOrderByStartDateDesc(getCurrent().startDate)
    }
    
    /**
     * This method is used to retrieve the previous interim report based on the supplied interim report.
     *
     * @return
     */
    public InterimReport getPrevious(InterimReport interimReport) {
        return interimReportRepository.findTopByStartDateLessThanOrderByStartDateDesc(interimReport.startDate)
    }
}
