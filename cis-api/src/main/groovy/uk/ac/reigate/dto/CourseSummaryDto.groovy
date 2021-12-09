package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.dto.lookup.LevelDto
import uk.ac.reigate.dto.lookup.SubjectDto

/**
 *
 * JSON serializable DTO containing Course data
 *
 */

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CourseSummaryDto implements Serializable {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    Integer levelId
    
    @JsonProperty
    LevelDto level
    
    @JsonProperty
    Integer subjectId
    
    @JsonProperty
    SubjectDto subject
    
    @JsonProperty
    String spec
    
    @JsonProperty
    String learningAimReference
    
    /**
     * Default No Args constructor
     */
    public CourseSummaryDto() {
    }
    
    /**
     * Constructor to create a CourseDto object from a Course object
     *
     * @param course the Course object to use for construction
     */
    public CourseSummaryDto(Course course) {
        if (course != null) {
            this.id = course.id
            this.levelId = course.level != null ? course.level.id : null
            this.level = course.level != null ? LevelDto.mapFromEntity(course.level) : null
            this.subjectId = course.subject != null ? course.subject.id : null
            this.subject = course.subject != null ? SubjectDto.mapFromEntity(course.subject) : null
            this.spec = course.spec
            this.learningAimReference = course.learningAimReference
        }
    }
    
    /**
     * This static method is used to create a CourseSummaryDto from a Course data object.
     *
     * @param course the Course data object to use for the creation.
     * @return a CourseSummaryDto object based on the Course data object supplied.
     */
    public static CourseSummaryDto mapFromEntity(Course course) {
        return new CourseSummaryDto(course)
    }
    
    /**
     * This static method is used to create a List of CourseSummaryDto from a List of Course data object.
     *
     * @param courses the List of Course data object to use for the creation.
     * @return a List of CourseSummaryDto object based on the List of Course data object supplied.
     */
    public static List<CourseSummaryDto> mapFromList(List<Course> courses) {
        return courses.collect { course ->  new CourseSummaryDto(course) }
    }
    
    /**
     * This method is used to return the Level description for the Course object
     *
     * @return the Level description for the Course object
     */
    @JsonProperty(value = "_levelDescription")
    public String get_LevelDescription() {
        return this.level != null ? this.level.description : null
    }
    
    /**
     * This method is used to return the Subject description for the Course object
     *
     * @return the Subject description for the Course object
     */
    @JsonProperty(value = "_subjectDescription")
    public String get_SubjectDescription() {
        return this.subject != null ? this.subject.description : null
    }
    
    /**
     * This method is used to return the Level and subject description for the Course object
     *
     * @return the Level and subject description for the Course object
     */
    @JsonProperty(value = "_description")
    public String get_Description() {
        return this.level != null & this.subject != null ? this.level.description + ' - ' + this.subject.description : null
    }
}
