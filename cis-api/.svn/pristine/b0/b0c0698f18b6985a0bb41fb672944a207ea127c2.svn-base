package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.dto.lookup.YearGroupDto

/**
 * This class is used to transmit a summarised version of the Course Group data. 
 */
@JsonSerialize
@EqualsAndHashCode(callSuper = true, includeFields = true)
public class CourseGroupSummaryDto extends CourseGroupBasicDto implements Serializable {
    
    @JsonProperty
    YearGroupDto yearGroup
    
    @JsonProperty
    CourseSummaryDto _course
    
    @JsonProperty
    AcademicYearSummaryDto year
    
    @JsonProperty
    Date startDate
    
    @JsonProperty
    Date endDate
    
    @JsonProperty
    Integer departmentId
    
    @JsonProperty
    DepartmentDto _department
    
    @JsonProperty
    StaffSummaryDto _courseLeader
    
    @JsonProperty
    String notes
    
    /**
     * Default No Args constructor
     */
    public CourseGroupSummaryDto() {
    }
    
    /**
     * Constructor to create a CourseGroupDto object from a CourseGroup object.
     *
     * @param courseGroup the CourseGroup object to use for construction
     */
    public CourseGroupSummaryDto(CourseGroup courseGroup) {
        super(courseGroup)
        if (courseGroup != null) {
            this.yearGroup = courseGroup.yearGroup != null ? new YearGroupDto(courseGroup.yearGroup) : null
            this._course = new CourseSummaryDto(courseGroup.course)
            this.year = courseGroup.year != null ? AcademicYearSummaryDto.mapFromEntity(courseGroup.year) : null
            this.startDate = courseGroup.startDate
            this.endDate = courseGroup.endDate
            this.departmentId = courseGroup.department ? courseGroup.department.id : null
            this._courseLeader = courseGroup.courseLeader ? StaffSummaryDto.mapFromEntity(courseGroup.courseLeader) : null
            this.notes = courseGroup.notes
            this._department = DepartmentDto.mapFromEntity(courseGroup.department)
        }
    }
    
    /**
     * This static method is used to create a CourseGroupSummaryDto from a CourseGroup data object.
     *
     * @param courseGroup the CourseGroup data object to use for the creation.
     * @return a CourseGroupSummaryDto object based on the CourseGroup data object supplied.
     */
    public static CourseGroupSummaryDto mapFromEntity(CourseGroup courseGroup) {
        return new CourseGroupSummaryDto(courseGroup)
    }
    
    /**
     * This static method is used to create a List of CourseGroupSummaryDto from a List of CourseGroup data object.
     *
     * @param courseGroups the List of CourseGroup data object to use for the creation.
     * @return a List of CourseGroupSummaryDto object based on the List of CourseGroup data object supplied.
     */
    public static List<CourseGroupSummaryDto> mapFromList(List<CourseGroup> courseGroups) {
        return courseGroups.collect { courseGroup ->  new CourseGroupSummaryDto(courseGroup) }
    }
    
    /**
     * This method is used to return the YearGroup description for the CourseGroup object
     *
     * @return the YearGroup description for the CourseGroup object
     */
    @JsonProperty(value = '_yearGroupDescription')
    public String get_YearGroupDescription() {
        return this.yearGroup != null ? this.yearGroup.description : null
    }
    
    /**
     * This method is used to return the academicYear description for the CourseGroup object.
     *
     * @return the AcademicYear description for the CourseGroup object
     */
    @JsonProperty(value = '_yearDescription')
    public String get_YearDescription() {
        return this.year != null ? this.year.description : null
    }
}
