package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Course;
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGrade
import uk.ac.reigate.domain.lookup.Subject
import uk.ac.reigate.dto.lookup.PossibleGradeDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class PreReferenceDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private Integer predictedGradeId;
    
    @JsonProperty
    private PossibleGradeDto possibleGrade
    
    /**
     * Default No Args constructor
     */
    PreReferenceDto() {}
    
    /**
     * Constructor to create a CourseOption object
     * 
     * @param course
     * @param option
     */
    PreReferenceDto(Student student, Course course, PossibleGrade predictedGrade) {
        this.studentId = student.id
        this.courseId = course.id;
        this.predictedGradeId = predictedGrade.id;
    }
    
    /**
     * Constructor to create a CourseOption object
     *
     * @param course
     * @param option
     */
    PreReferenceDto(PreReference preReference) {
        this.studentId = preReference.student != null ? preReference.student.id : null
        this.courseId = preReference.course != null ? preReference.course.id : null;
        this.predictedGradeId = preReference.predictedGrade != null ? preReference.predictedGrade.id : null;
        this.possibleGrade = preReference.predictedGrade != null ? PossibleGradeDto.mapFromEntity(preReference.predictedGrade) : null
    }
    
    /**
     * This method is used to map an PreReference object to an PreReferenceDto object
     *
     * @param preReference an PreReference object
     * @return an PreReferenceDto object
     */
    public static PreReferenceDto mapFromEntity(PreReference preReference) {
        return new PreReferenceDto(preReference);
    }
    
    /**
     * This method is used to map a List of PreReference objects to a List of PreReferenceDto objects.
     *
     * @param preReferenceList a List of PreReference objects
     * @return a List of PreReferenceDto objects
     */
    public static List<PreReferenceDto> mapFromList(List<PreReference> preReferences) {
        return preReferences.collect { preReference -> mapFromEntity(preReference) } ;
    }
    
    /**
     * This method is used to return the PossibleGrade Grade for the PreReference object
     *
     * @return the PossibleGrade Grade for the PreReference object
     */
    @JsonProperty(value = "_grade")
    public String get_Grade() {
        return this.possibleGrade != null ? this.possibleGrade.grade : null
    }
}
