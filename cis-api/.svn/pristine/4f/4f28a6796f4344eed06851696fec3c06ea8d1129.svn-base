package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.InsetCourse
import uk.ac.reigate.dto.AcademicYearDto


/**
 *
 * JSON serializable DTO containing InsetCourse data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InsetCourseDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String courseTitle
    
    @JsonProperty
    private String courseNotes
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    @JsonProperty
    private Integer academicYearId
    
    @JsonProperty
    private AcademicYearDto academicYear
    
    /**
     * Default No Args constructor
     */
    public InsetCourseDto() {
    }
    
    /**
     * Constructor to create a InsetCourseDto object from a InsetCourse object
     *
     * @param insetCourse the InsetCourse object to use for construction
     */
    InsetCourseDto(InsetCourse insetCourse) {
        if(insetCourse != null) {
            this.id = insetCourse.id;
            this.courseTitle = insetCourse.courseTitle;
            this.courseNotes = insetCourse.courseNotes;
            this.startDate = insetCourse.startDate;
            this.endDate = insetCourse.endDate;
            this.academicYearId = insetCourse.academicYear != null ? insetCourse.academicYear.id : null;
            this.academicYear = insetCourse.academicYear != null ? AcademicYearDto.mapFromEntity(insetCourse.academicYear) : null;
        }
    }
    
    /**
     * This static method is used to create a InsetCourseDto from a InsetCourse data object.
     *
     * @param insetCourse the InsetCourse data object to use for the creation.
     * @return a InsetCourseDto object based on the InsetCourse data object supplied.
     */
    public static InsetCourseDto mapFromEntity(InsetCourse insetCourse) {
        return new InsetCourseDto(insetCourse);
    }
    
    /**
     * This static method is used to create a List of InsetCourseDto from a List of InsetCourse data object.
     *
     * @param insetCourses the List of InsetCourse data object to use for the creation.
     * @return a List of LetterDto object based on the List of InsetCourse data object supplied.
     */
    public static List<InsetCourseDto> mapFromList(List<InsetCourse> insetCourses) {
        return insetCourses.collect { insetCourse ->  new InsetCourseDto(insetCourse) };
    }
}
