package uk.ac.reigate.dto.interimreport;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.interimreport.CourseGroupInterimReport
import uk.ac.reigate.dto.CourseGroupSummaryDto

/**
 *
 * JSON serializable DTO containing CourseGroupInterimReport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CourseGroupInterimReportDto implements Serializable {
    
    @JsonProperty
    public Integer courseGroupId
    
    @JsonProperty
    public Integer interimReportId
    
    @JsonProperty
    public Integer staffCompletedId
    
    @JsonProperty
    public Boolean complete
    
    /**
     * Default No Args constructor
     */
    public CourseGroupInterimReportDto() {
    }
    
    /**
     * Constructor to create an CourseGroupInterimReportDto object from a CourseGroupInterimReport object
     *
     * @param courseGroupInterimReport the CourseGroupInterimReport object to use for construction
     */
    public CourseGroupInterimReportDto(CourseGroupInterimReport courseGroupInterimReport) {
        this.courseGroupId = courseGroupInterimReport.courseGroup.id;
        this.interimReportId = courseGroupInterimReport.interimReport.id;
        this.staffCompletedId = courseGroupInterimReport.staffCompleted != null ? courseGroupInterimReport.staffCompleted.id : null;
        this.complete = courseGroupInterimReport.complete;
    }
    
    /**
     * This static method is used to create a CourseGroupInterimReportDto from a CourseGroupInterimReport data object.
     *
     * @param courseGroupInterimReport the CourseGroupInterimReport data object to use for the creation.
     * @return a CourseGroupInterimReportDto object based on the CourseGroupInterimReport data object supplied.
     */
    public static CourseGroupInterimReportDto mapFromEntity(CourseGroupInterimReport courseGroupInterimReport) {
        return new CourseGroupInterimReportDto(courseGroupInterimReport)
    }
    
    /**
     * This static method is used to create a List of CourseGroupInterimReportDto from a List of CourseGroupInterimReport data object.
     *
     * @param courseGroupInterimReports the List of CourseGroupInterimReport data object to use for the creation.
     * @return a List of CourseGroupInterimReportDto object based on the List of CourseGroupInterimReport data object supplied.
     */
    public static List<CourseGroupInterimReportDto> mapFromList(List<CourseGroupInterimReport> courseGroupInterimReports) {
        return courseGroupInterimReports.collect { courseGroupInterimReport ->  new CourseGroupInterimReportDto(courseGroupInterimReport) };
    }
}