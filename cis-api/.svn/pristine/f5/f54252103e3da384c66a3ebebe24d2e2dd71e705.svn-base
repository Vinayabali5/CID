package uk.ac.reigate.dto.exams

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Course;
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.basedata.ExamOption

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class CourseOptionDto implements Serializable {
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private Integer examOptionId;
    
    @JsonProperty
    private boolean lowerEntry;
    
    @JsonProperty
    private boolean upperEntry;
    
    @JsonProperty
    private boolean intermediateEntry;
    
    /**
     * Default No Args constructor
     */
    CourseOptionDto() {}
    
    /**
     * Constructor to create a CourseOption object
     * 
     * @param course
     * @param option
     */
    CourseOptionDto(Course course, ExamOption examOption, boolean lowerEntry, boolean upperEntry, boolean intermediateEntry) {
        this.courseId = course.id;
        this.examOptionId = examOption.id;
        this.lowerEntry = lowerEntry;
        this.upperEntry = upperEntry;
        this.intermediateEntry = intermediateEntry;
    }
    
    /**
     * Constructor to create a CourseOptionDto object from a CourseOption object
     *
     * @param CourseOption object to use for construction
     */
    CourseOptionDto(CourseOption courseOption) {
        this.courseId = courseOption.course.id;
        this.examOptionId = courseOption.examOption.id;
        this.lowerEntry = lowerEntry;
        this.upperEntry = upperEntry;
        this.intermediateEntry = intermediateEntry;
    }
    
    /**
     * This static method is used to create a CourseOptionDto from a CourseOption data object.
     *
     * @param courseOption the CourseOption data object to use for the creation.
     * @return a CourseOptionDto object based on the CourseOption data object supplied.
     */
    public static CourseOptionDto mapFromEntity(CourseOption courseOption) {
        return new CourseOptionDto(courseOption);
    }
    
    /**
     * This static method is used to create a List of CourseOptionDto from a List of CourseOption data object.
     *
     * @param courseOptions the List of CourseOption data object to use for the creation.
     * @return a List of CourseOptionDto object based on the List of CourseOption data object supplied.
     */
    public static List<CourseOptionDto> mapFromList(List<CourseOption> courseOptions) {
        return courseOptions.collect { courseOption -> new CourseOptionDto(courseOption.course, courseOption.examOption, courseOption.lowerEntry, courseOption.upperEntry, courseOption.intermediateEntry) } ;
    }
}