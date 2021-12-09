package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.dto.exams.ExamBoardDto

/**
 *
 * JSON serializable DTO containing Course data
 *
 */

@JsonSerialize
@EqualsAndHashCode(callSuper = true, includeFields=true)
public class CourseDto extends CourseSummaryDto implements Serializable {
    
    @JsonProperty
    private Integer glh
    
    @JsonProperty
    private String learningAimReference
    
    @JsonProperty
    private String syllabusCode;
    
    @JsonProperty
    private Integer examBoardId;
    
    @JsonProperty
    private ExamBoardDto examBoard;
    
    @JsonProperty
    private String notes;
    
    @JsonProperty
    private Integer validFromId;
    
    @JsonProperty
    private AcademicYearDto validFrom;
    
    @JsonProperty
    private Integer validToId;
    
    @JsonProperty
    private AcademicYearDto validTo;
    
    @JsonProperty
    private String locationPostcode;
    
    @JsonProperty
    private String subjectSectorArea;
    
    @JsonProperty
    private String courseSummary
    
    @JsonProperty
    private String entryRequirements
    
    @JsonProperty
    private Boolean russell
    
    @JsonProperty
    private String externalLink
    
    @JsonProperty
    private Boolean published
    
    @JsonProperty
    private String publishedTitle
    
    @JsonProperty
    private Boolean externallyAssessed
    
    @JsonProperty
    private Integer rqfLevelOverride
    
    @JsonProperty
    private String ucasTitle
    /**
     * Default No Args constructor
     */
    public CourseDto() {
        super()
    }
    
    /**
     * Constructor to create a CourseDto object from a Course object
     *
     * @param course the Course object to use for construction
     */
    CourseDto(Course course) {
        super(course)
        if (course != null) {
            this.glh = course.glh;
            this.learningAimReference = course.learningAimReference;
            this.syllabusCode = course.syllabusCode;
            this.examBoardId = course.examBoard != null ? course.examBoard.id : null;
            this.examBoard = course.examBoard != null ? ExamBoardDto.mapFromEntity(course.examBoard) : null
            this.notes = course.notes;
            this.validFromId = course.validFrom != null ? course.validFrom.id : null;
            this.validFrom = course.validFrom != null ? AcademicYearDto.mapFromEntity(course.validFrom) : null
            this.validToId = course.validTo != null ? course.validTo.id : null;
            this.validTo = course.validTo != null ? AcademicYearDto.mapFromEntity(course.validTo) : null
            this.locationPostcode = course.locationPostcode;
            this.subjectSectorArea = course.subjectSectorArea;
            this.courseSummary = course.courseSummary;
            this.entryRequirements = course.entryRequirements;
            this.russell = course.russell;
            this.externalLink = course.externalLink;
            this.published = course.published;
            this.externallyAssessed = course.externallyAssessed;
            this.publishedTitle = course.publishedTitle
            this.rqfLevelOverride = course.rqfLevelOverride
            this.ucasTitle = course.ucasTitle
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a CourseDto from a Course data object.
     *
     * @param course the Course data object to use for the creation.
     * @return a CourseDto object based on the Course data object supplied.
     */
    public static CourseDto mapFromEntity(Course course) {
        return new CourseDto(course);
    }
    
    /**
     * This static method is used to create a List of CourseDto from a List of Course data object.
     *
     * @param courses the List of Course data object to use for the creation.
     * @return a List of CourseDto object based on the List of Course data object supplied.
     */
    public static List<CourseDto> mapFromList(List<Course> courses) {
        return courses.collect { course ->  new CourseDto(course) };
    }
    
    /**
     * This method is used to return the Exam board description for the Course object
     *
     * @return the Exam board description for the Course object
     */
    @JsonProperty(value = "_examBoardDescription")
    public String get_ExamBoardDescription() {
        return this.examBoard != null ? this.examBoard.description : null
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
     * This method is used to return the Valid from AcademicYear code for the Course object
     *
     * @return the Valid from AcademicYear code for the Course object
     */
    @JsonProperty(value = "_validFromCode")
    public String get_ValidFromCode() {
        return this.validFrom != null ? this.validFrom.code : null
    }
    
    /**
     * This method is used to return the Valid from AcademicYear Description for the Course object
     *
     * @return the Valid from AcademicYear Description for the Course object
     */
    @JsonProperty(value = "_validFromDescription")
    public String get_ValidFromDescription() {
        return this.validFrom != null ? this.validFrom.description : null
    }
    
    /**
     * This method is used to return the Valid To AcademicYear code for the Course object
     *
     * @return the Valid To AcademicYear code for the Course object
     */
    @JsonProperty(value = "_validToCode")
    public String get_ValidToCode() {
        return this.validTo != null ? this.validTo.code : null
    }
    
    /**
     * This method is used to return the Valid To AcademicYear Description for the Course object
     *
     * @return the Valid To AcademicYear Description for the Course object
     */
    @JsonProperty(value = "_validToDescription")
    public String get_ValidToDescription() {
        return this.validTo != null ? this.validTo.description : null
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
