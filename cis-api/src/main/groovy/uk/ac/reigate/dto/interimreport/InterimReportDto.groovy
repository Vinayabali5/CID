package uk.ac.reigate.dto.interimreport;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.AcademicYearDto

/**
 *
 * JSON serializable DTO containing InterimReport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InterimReportDto implements Serializable {
    
    @JsonProperty
    public Integer id
    
    @JsonProperty
    public String description
    
    @JsonProperty
    public Integer yearId
    
    @JsonProperty
    public AcademicYearDto year
    
    @JsonProperty
    public Date startDate
    
    @JsonProperty
    public Date endDate
    
    @JsonProperty
    public Date publishDate
    
    @JsonProperty
    public Boolean active
    
    /**
     * Default No Args constructor
     */
    public InterimReportDto() {
    }
    
    /**
     * Constructor to create an InterimReportDto object from a InterimReport object
     *
     * @param interimReport the InterimReport object to use for construction
     */
    public InterimReportDto(InterimReport interimReport) {
        if (interimReport != null) {
            this.id = interimReport.id;
            this.description = interimReport.description;
            this.yearId = interimReport.year != null ? interimReport.year.id : null;
            this.year = AcademicYearDto.mapFromEntity(interimReport.year)
            this.startDate = interimReport.startDate;
            this.endDate = interimReport.endDate;
            this.publishDate = interimReport.publishDate;
            this.active = interimReport.active;
        }
    }
    
    /**
     * This static method is used to create a InterimReportDto from a InterimReport data object.
     *
     * @param interimReport the InterimReport data object to use for the creation.
     * @return a InterimReportDto object based on the InterimReport data object supplied.
     */
    public static InterimReportDto mapFromEntity(InterimReport interimReport) {
        return new InterimReportDto(interimReport)
    }
    
    /**
     * This static method is used to create a List of InterimReportDto from a List of InterimReport data object.
     *
     * @param interimReports the List of InterimReport data object to use for the creation.
     * @return a List of InterimReportDto object based on the List of InterimReport data object supplied.
     */
    public static List<InterimReportDto> mapFromList(List<InterimReport> interimReports) {
        return interimReports.collect { interimReport ->  new InterimReportDto(interimReport) };
    }
}