package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.lookup.ReportingPeriod
import uk.ac.reigate.dto.ReportingPeriodDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.ReportingPeriodRepository
import uk.ac.reigate.utils.ValidationUtils

@Service
class ReportingPeriodService implements ICoreDataService<ReportingPeriod, Integer>, IDtoCreateUpdateService<ReportingPeriodDto, ReportingPeriod>{
    
    @Autowired
    ReportingPeriodRepository reportingPeriodRepository
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    /**
     * Default NoArgs constructor
     */
    ReportingPeriodService() {}
    
    /**
     * Autowired Constructor
     *
     * @param reportingPeriodRepository
     */
    ReportingPeriodService(ReportingPeriodRepository reportingPeriodRepository, AcademicYearService academicYearService) {
        this.reportingPeriodRepository = reportingPeriodRepository;
        this.academicYearService = academicYearService;
    }
    
    /**
     * Find an individual reportingPeriod using the reportingPeriods ID fields
     *
     * @param id the ID fields to search for
     * @return the ReportingPeriod object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ReportingPeriod findById(Integer id) {
        return reportingPeriodRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all reportingPeriods
     *
     * @return a SearchResult set with the list of ReportingPeriods
     */
    @Override
    @Transactional(readOnly = true)
    List<ReportingPeriod> findAll() {
        return reportingPeriodRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    List<ReportingPeriod> searchByAcademicYear(AcademicYear academicYear) {
        return reportingPeriodRepository.findByAcademicYear(academicYear);
    }
    
    /**
     * This service is used top create a ReportingPeriod object in the database from a partial or complete ReportingPeriod object
     * 
     * @param reportingPeriod the partial or complete ReportingPeriod object to be saved
     * @return the saved version of the ReportingPeriod object
     */
    public ReportingPeriod createFromDto(ReportingPeriodDto reportingPeriodDto) {
        if (reportingPeriodDto == null) {
            throw new InvalidDataException("Cannot create reportingPeriodDto from null object.")
        }
        ReportingPeriod reportingPeriod = new ReportingPeriod()
        if(reportingPeriodDto.academicYearId != null) {
            reportingPeriod.academicYear = academicYearService.findById(reportingPeriodDto.academicYearId)
        }
        reportingPeriod.name = reportingPeriodDto.name
        reportingPeriod.startDate = reportingPeriodDto.startDate
        reportingPeriod.endDate = reportingPeriodDto.endDate
        return save(reportingPeriod)
    }
    
    /**
     * This service is used top create a ReportingPeriod object in the database from a partial or complete ReportingPeriod object
     *
     * @param reportingPeriod the partial or complete ReportingPeriod object to be saved
     * @return the saved version of the ReportingPeriod object
     */
    public ReportingPeriod updateFromDto(ReportingPeriodDto reportingPeriodDto) {
        if (reportingPeriodDto == null) {
            throw new InvalidDataException("Cannot update reportingPeriodDto from null object.")
        }
        ReportingPeriod reportingPeriod = findById(reportingPeriodDto.id)
        if(reportingPeriodDto.academicYearId != null) {
            reportingPeriod.academicYear = academicYearService.findById(reportingPeriodDto.academicYearId)
        }
        reportingPeriod.name = reportingPeriodDto.name
        reportingPeriod.startDate = reportingPeriodDto.startDate
        reportingPeriod.endDate = reportingPeriodDto.endDate
        return save(reportingPeriod)
    }
    
    /**
     * This service method is used to save a complete ReportingPeriod object in the database
     *
     * @param reportingPeriod the new ReportingPeriod object to be saved
     * @return the saved version of the ReportingPeriod object
     */
    @Override
    @Transactional
    public ReportingPeriod save(ReportingPeriod reportingPeriod) {
        return reportingPeriodRepository.save(reportingPeriod)
    }
    
    @Override
    public void delete(ReportingPeriod obj) {
        throw new InvalidOperationException("ReportingPeriod should not be deleted.")
    }
}
