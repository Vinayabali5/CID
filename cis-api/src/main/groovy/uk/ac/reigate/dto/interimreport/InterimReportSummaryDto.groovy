package uk.ac.reigate.dto.interimreport;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.AcademicYearSummaryDto

/**
 *
 * JSON serializable DTO containing InterimReport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InterimReportSummaryDto implements Serializable {
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private String description
    
    @JsonProperty
    private AcademicYearSummaryDto year
    
    /**
     * Default No Args constructor
     */
    public InterimReportSummaryDto() {
    }
    
    /**
     * Constructor to create an InterimReportSummaryDto object from a InterimReport object
     *
     * @param interimReport the InterimReport object to use for construction
     */
    InterimReportSummaryDto(InterimReport interimReport) {
        if (interimReport != null) {
            this.id = interimReport.id;
            this.description = interimReport.description;
            this.year = AcademicYearSummaryDto.mapFromEntity(interimReport.year)
        }
    }
    
    /**
     * This static method is used to create a InterimReportSummaryDto from a InterimReport data object.
     * 
     * @param interimReport the InterimReport data object to use for the creation.
     * @return a InterimReportSummaryDto object based on the InterimReport data object supplied.
     */
    public static InterimReportSummaryDto mapFromEntity(InterimReport interimReport) {
        return new InterimReportSummaryDto(interimReport)
    }
    
    /**
     * This static method is used to create a List of InterimReportSummaryDto from a List of InterimReport data object.
     *
     * @param interimReports the List of InterimReport data object to use for the creation.
     * @return a List of InterimReportSummaryDto object based on the List of InterimReport data object supplied.
     */
    public static List<InterimReportSummaryDto> mapFromList(List<InterimReport> interimReports) {
        return interimReports.collect { interimReport ->  new InterimReportSummaryDto(interimReport) };
    }
}
