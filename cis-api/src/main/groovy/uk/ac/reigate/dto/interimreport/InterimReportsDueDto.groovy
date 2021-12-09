package uk.ac.reigate.dto.interimreport;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.domain.interimreport.InterimReportsDue

/**
 *
 * JSON serializable DTO containing InterimReportsDue data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InterimReportsDueDto implements Serializable {
    
    @JsonProperty
    public Integer interimReportId
    
    @JsonProperty
    public Integer courseId
    
    @JsonProperty
    public Integer courseGroupId
    
    @JsonProperty
    public String CourseGroupSpec
    
    @JsonProperty
    public Boolean complete
    
    /**
     * Default No Args constructor
     */
    public InterimReportsDueDto() {
    }
    
    /**
     * Constructor to create an InterimReportsDueDto object from a InterimReportsDue object
     *
     * @param interimReportsDue the InterimReportsDue object to use for construction
     */
    public InterimReportsDueDto(InterimReportsDue interimReportsDue) {
        if(interimReportsDue != null) {
            this.interimReportId = interimReportsDue.interimReport.id;
            this.courseId = interimReportsDue.course.id;
            this.courseGroupId = interimReportsDue.courseGroup.id;
            this.CourseGroupSpec = interimReportsDue.CourseGroupSpec;
            this.complete = interimReportsDue.complete;
        }
    }
    
    public InterimReportsDueDto(InterimReport interimReport, Course course, CourseGroup courseGroup) {
        this.interimReportId = interimReport.id;
        this.courseId = course.id;
        this.courseGroupId = courseGroup.id;
    }
    
    /**
     * This static method is used to create a InterimReportsDueDto from a InterimReportsDue data object.
     *
     * @param interimReportsDue the InterimReportsDue data object to use for the creation.
     * @return a InterimReportsDueDto object based on the InterimReportsDue data object supplied.
     */
    public static InterimReportsDueDto mapFromEntity(InterimReportsDue interimReportsDue) {
        return new InterimReportsDueDto(interimReportsDue)
    }
    
    /**
     * This static method is used to create a List of InterimReportsDueDto from a List of InterimReportsDue data object.
     *
     * @param interimReportsDues the List of InterimReportsDue data object to use for the creation.
     * @return a List of InterimReportsDueDto object based on the List of InterimReportsDue data object supplied.
     */
    public static List<InterimReportsDueDto> mapFromList(List<InterimReportsDue> interimReportsDues) {
        return interimReportsDues.collect { interimReportsDue ->  new InterimReportsDueDto(interimReportsDue) };
    }
}