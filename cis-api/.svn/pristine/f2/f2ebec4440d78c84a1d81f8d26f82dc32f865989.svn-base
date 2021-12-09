package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.CourseGroup

/**
 *
 * JSON serializable DTO containing CourseGroup data
 *
 */
@JsonSerialize
@EqualsAndHashCode(callSuper = true, includeFields=true)
public class CourseGroupDto extends CourseGroupSummaryDto implements Serializable {
    
    @JsonProperty
    CourseDto _course
    
    @JsonProperty
    Integer yearId;
    
    @JsonProperty
    AcademicYearDto year;
    
    @JsonProperty
    String code;
    
    @JsonProperty
    Integer departmentId;
    
    @JsonProperty
    DepartmentDto department;
    
    @JsonProperty
    Integer courseLeaderId;
    
    @JsonProperty
    StaffDto courseLeader;
    
    @JsonProperty
    Boolean displayOnTimetable;
    
    @JsonProperty
    Boolean hasRegister;
    
    @JsonProperty
    String notes;
    
    @JsonProperty
    Date startDate;
    
    @JsonProperty
    Date endDate;
    
    @JsonProperty
    String spec;
    
    @JsonProperty
    Integer plh;
    
    @JsonProperty
    Integer peeph;
    
    @JsonProperty
    Boolean nested
    
    @JsonProperty
    Boolean excludeFromAllocation
    
    @JsonProperty
    Boolean excludeFromExams
    
    @JsonProperty
    Boolean excludeFromIR
    
    @JsonProperty
    Boolean ilrReturn
    
    @JsonProperty
    String learningAimReferenceOverride
    
    
    /**
     * Default No Args constructor
     */
    public CourseGroupDto() {
        super()
    }
    
    /**
     * Constructor to create a CourseGroupDto object from a CourseGroup object
     *
     * @param courseGroup the CourseGroup object to use for construction
     */
    public CourseGroupDto(CourseGroup courseGroup) {
        super(courseGroup)
        if (courseGroup != null) {
            this._course = new CourseDto(courseGroup.course)
            this.yearId = courseGroup.year ? courseGroup.year.id : null
            this.year = courseGroup.year ? AcademicYearDto.mapFromEntity(courseGroup.year) : null
            this.code = courseGroup.code
            this.startDate = courseGroup.startDate
            this.endDate = courseGroup.endDate
            this.departmentId = courseGroup.department ? courseGroup.department.id : null
            this.department = courseGroup.department ? DepartmentDto.mapFromEntity(courseGroup.department) : null
            this.courseLeaderId = courseGroup.courseLeader ? courseGroup.courseLeader.id : null
            this.courseLeader = courseGroup.courseLeader ? StaffDto.mapFromEntity(courseGroup.courseLeader) : null
            this.displayOnTimetable = courseGroup.displayOnTimetable
            this.hasRegister = courseGroup.hasRegister
            this.notes = courseGroup.notes
            this.spec = courseGroup.spec
            this.plh = courseGroup.plh
            this.peeph = courseGroup.peeph
            this.nested = courseGroup.nested
            this.excludeFromAllocation = courseGroup.excludeFromAllocation
            this.excludeFromExams = courseGroup.excludeFromExams
            this.excludeFromIR = courseGroup.excludeFromIR;
            this.ilrReturn = courseGroup.ilrReturn
            this.learningAimReferenceOverride = courseGroup.learningAimReferenceOverride
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a CourseGroupDto from a CourseGroup data object.
     *
     * @param courseGroup the CourseGroup data object to use for the creation.
     * @return a CourseGroupDto object based on the CourseGroup data object supplied.
     */
    public static CourseGroupDto mapFromEntity(CourseGroup courseGroup) {
        return new CourseGroupDto(courseGroup)
    }
    
    /**
     * This static method is used to create a List of CourseGroupDto from a List of CourseGroup data object.
     *
     * @param courseGroups the List of CourseGroup data object to use for the creation.
     * @return a List of CourseGroupDto object based on the List of CourseGroup data object supplied.
     */
    public static List<CourseGroupDto> mapFromList(List<CourseGroup> courseGroups) {
        return courseGroups.collect { courseGroup ->  new CourseGroupDto(courseGroup) };
    }
    
    /**
     * This method is used to return the YearGroup description for the CourseGroup object
     *
     * @return the YearGroup description for the CourseGroup object
     */
    @JsonProperty(value = "_yearGroupDescription")
    public String get_YearGroupDescription() {
        return this.yearGroup != null ? this.yearGroup.description : null;
    }
    
    /**
     * This method is used to return the academicYear description for the CourseGroup object
     *
     * @return the AcademicYear description for the CourseGroup object
     */
    @JsonProperty(value = "_yearDescription")
    public String get_YearDescription() {
        return this.year != null ? this.year.description : null;
    }
    
    /**
     * This method is used to return the department description for the CourseGroup object
     *
     * @return the Department description for the CourseGroup object
     */
    @JsonProperty(value = "_departmentDescription")
    public String get_DepartmentDescription() {
        return this.department != null ? this.department.description : null;
    }
    
    /**
     * This method is used to return the CourseLeader initials for the CourseGroup object
     *
     * @return the CourseLeader initials for the CourseGroup object
     */
    @JsonProperty(value = "_courseLeaderInitials")
    public String get_CourseLeaderInitials() {
        return this.courseLeader != null ? this.courseLeader.initials : null;
    }
}
