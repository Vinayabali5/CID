package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.lookup.ReportingPeriod

/**
 *
 * JSON serializable DTO containing ReportingPeriod data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ReportingPeriodDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer academicYearId;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private Date startDate;
    
    @JsonProperty
    private Date endDate;
    
    /**
     * Default No Args constructor
     */
    public ReportingPeriodDto() {
    }
    
    /**
     * Constructor to create a ReportingPeriodDto object from a ReportingPeriod object
     *
     * @param reportingPeriod the ReportingPeriod object to use for construction
     */
    ReportingPeriodDto(ReportingPeriod reportingPeriod) {
        this.id = reportingPeriod.id;
        this.academicYearId = reportingPeriod.academicYear != null ? reportingPeriod.academicYear.id : null;
        this.name = reportingPeriod.name;
        this.startDate = reportingPeriod.startDate;
        this.endDate = reportingPeriod.endDate;
    }
    
    /**
     * This static method is used to create a ReportingPeriodDto from a ReportingPeriod data object.
     *
     * @param reportingPeriod the ReportingPeriod data object to use for the creation.
     * @return a ReportingPeriodDto object based on the ReportingPeriod data object supplied.
     */
    public static ReportingPeriodDto mapFromEntity(ReportingPeriod reportingPeriod) {
        return new ReportingPeriodDto(reportingPeriod);
    }
    
    /**
     * This static method is used to create a List of ReportingPeriodDto from a List of ReportingPeriod data object.
     *
     * @param reportingPeriods the List of ReportingPeriod data object to use for the creation.
     * @return a List of ReportingPeriodDto object based on the List of ReportingPeriod data object supplied.
     */
    public static List<ReportingPeriodDto> mapFromList(List<ReportingPeriod> reportingPeriods) {
        return reportingPeriods.collect { reportingPeriod ->  new ReportingPeriodDto(reportingPeriod) };
    }
}
