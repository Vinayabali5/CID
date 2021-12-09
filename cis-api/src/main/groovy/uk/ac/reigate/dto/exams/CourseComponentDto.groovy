package uk.ac.reigate.dto.exams

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import groovy.transform.EqualsAndHashCode

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class CourseComponentDto implements Serializable {
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private Integer examOptionId;
    
    @JsonProperty
    private Integer examComponentId;
    
    /**
     * Default No Args constructor
     */
    CourseComponentDto() {}
    
    /**
     * Constructor to create a CourseOption object
     * 
     * @param course
     * @param option
     */
    CourseComponentDto(Course course, ExamOption examOption, ExamComponent examComponent) {
        this.courseId = course.id;
        this.examOptionId = examOption.id;
        this.examComponentId = examComponent.id;
    }
    
    /**
     * Constructor to create a CourseComponentDto object from a CourseComponent object
     *
     * @param CourseComponent object to use for construction
     */
    CourseComponentDto(CourseComponent courseComponent) {
        this.courseId = courseComponent.course.id
        this.examOptionId = courseComponent.examOption.id;
        this.examComponentId = courseComponent.examComponent.id;
    }
    
    /**
     * This static method is used to create a CourseComponentDto from a CourseComponent data object.
     *
     * @param courseComponent the CourseComponent data object to use for the creation.
     * @return a CourseComponentDto object based on the CourseComponent data object supplied.
     */
    public static CourseComponentDto mapFromEntity(CourseComponent courseComponent) {
        return new CourseComponentDto(courseComponent);
    }
    
    /**
     * This static method is used to create a List of CourseComponentDto from a List of CourseComponent data object.
     *
     * @param courseComponents the List of CourseComponent data object to use for the creation.
     * @return a List of CourseComponentDto object based on the List of CourseComponent data object supplied.
     */
    public static List<CourseComponentDto> mapFromList(List<CourseComponent> courseComponents) {
        return courseComponents.collect { courseComponent -> new CourseComponentDto(courseComponent) } ;
    }
}
