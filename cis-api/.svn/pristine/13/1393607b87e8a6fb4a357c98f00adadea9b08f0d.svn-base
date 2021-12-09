package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.CourseGroup

/**
 * This class is used to transmit a summarised version of the Course Group data. 
 */
@JsonSerialize
@EqualsAndHashCode(includeFields = true)
public class CourseGroupBasicDto implements Serializable {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    Integer yearGroupId
    
    @JsonProperty
    Integer courseId
    
    @JsonProperty
    Integer yearId
    
    @JsonProperty
    String code
    
    @JsonProperty
    String spec
    
    
    /**
     * Default No Args constructor
     */
    public CourseGroupBasicDto() {
    }
    
    /**
     * Constructor to create a CourseGroupDto object from a CourseGroup object.
     *
     * @param courseGroup the CourseGroup object to use for construction
     */
    public CourseGroupBasicDto(CourseGroup courseGroup) {
        if (courseGroup != null) {
            this.id = courseGroup.id
            this.yearGroupId = courseGroup.yearGroup ? courseGroup.yearGroup.id : null
            this.courseId = courseGroup.course != null ? courseGroup.course.id : null
            this.yearId = courseGroup.year ? courseGroup.year.id : null
            this.code = courseGroup.code
            this.spec = courseGroup.spec
        }
    }
    
    /**
     * This static method is used to create a CourseGroupSummaryDto from a CourseGroup data object.
     *
     * @param courseGroup the CourseGroup data object to use for the creation.
     * @return a CourseGroupSummaryDto object based on the CourseGroup data object supplied.
     */
    public static CourseGroupBasicDto mapFromEntity(CourseGroup courseGroup) {
        return new CourseGroupBasicDto(courseGroup)
    }
    
    /**
     * This static method is used to create a List of CourseGroupSummaryDto from a List of CourseGroup data object.
     *
     * @param courseGroups the List of CourseGroup data object to use for the creation.
     * @return a List of CourseGroupSummaryDto object based on the List of CourseGroup data object supplied.
     */
    public static List<CourseGroupBasicDto> mapFromList(List<CourseGroup> courseGroups) {
        return courseGroups.collect { courseGroup ->  new CourseGroupBasicDto(courseGroup) }
    }
}
