package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.StaffInsetCourse
import uk.ac.reigate.dto.AcademicYearDto
import uk.ac.reigate.dto.StaffSummaryDto


/**
 *
 * JSON serializable DTO containing StaffInsetCourse data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StaffInsetCourseDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer staffId
    
    @JsonProperty
    private StaffSummaryDto staff
    
    @JsonProperty
    private Integer insetCourseId
    
    @JsonProperty
    private InsetCourseDto insetCourse
    
    @JsonProperty
    private Double hours
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    
    /**
     * Default No Args constructor
     */
    public StaffInsetCourseDto() {
    }
    
    /**
     * Constructor to create a StaffInsetCourseDto object from a StaffInsetCourse object
     *
     * @param staffInsetCourse the StaffInsetCourse object to use for construction
     */
    StaffInsetCourseDto(StaffInsetCourse staffInsetCourse) {
        if(staffInsetCourse != null) {
            this.id = staffInsetCourse.id;
            this.staffId = staffInsetCourse.staff != null ? staffInsetCourse.staff.id : null;
            this.staff = staffInsetCourse.staff != null ? StaffSummaryDto.mapFromEntity(staffInsetCourse.staff) : null;
            this.insetCourseId = staffInsetCourse.insetCourse != null ? staffInsetCourse.insetCourse.id : null;
            this.insetCourse = staffInsetCourse.insetCourse != null ? InsetCourseDto.mapFromEntity(staffInsetCourse.insetCourse) : null;
            this.hours = staffInsetCourse.hours;
            this.startDate = staffInsetCourse.startDate;
            this.endDate = staffInsetCourse.endDate;
        }
    }
    
    /**
     * This static method is used to create a StaffInsetCourseDto from a StaffInsetCourse data object.
     *
     * @param staffInsetCourse the StaffInsetCourse data object to use for the creation.
     * @return a StaffInsetCourseDto object based on the StaffInsetCourse data object supplied.
     */
    public static StaffInsetCourseDto mapFromEntity(StaffInsetCourse staffInsetCourse) {
        return new StaffInsetCourseDto(staffInsetCourse);
    }
    
    /**
     * This static method is used to create a List of StaffInsetCourseDto from a List of StaffInsetCourse data object.
     *
     * @param staffInsetCourses the List of StaffInsetCourse data object to use for the creation.
     * @return a List of LetterDto object based on the List of StaffInsetCourse data object supplied.
     */
    public static List<StaffInsetCourseDto> mapFromList(List<StaffInsetCourse> staffInsetCourses) {
        return staffInsetCourses.collect { staffInsetCourse ->  new StaffInsetCourseDto(staffInsetCourse) };
    }
}
