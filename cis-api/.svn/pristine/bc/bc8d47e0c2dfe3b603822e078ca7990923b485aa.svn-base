package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.lookup.StudentTypeDto
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing StudentYear data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields = true)
class StudentYearSummaryDto implements Serializable {
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    Integer yearId
    
    @JsonProperty
    Integer typeId
    
    @JsonProperty
    Integer tutorGroupId
    
    @JsonProperty
    TutorGroupSummaryDto tutorGroup
    
    @JsonProperty
    Date startDate
    
    @JsonProperty
    Date endDate
    
    /**
     * Default No Args constructor
     */
    StudentYearSummaryDto() {}
    
    /**
     * Constructor to create a StudentYearDto object from a StudentYear object
     *
     * @param studentYear the StudentYear object to use for construction
     */
    StudentYearSummaryDto(StudentYear studentYear){
        if(studentYear != null) {
            this.studentId = studentYear.student.id;
            this.yearId = studentYear.year != null ? studentYear.year.id : null;
            this.typeId = studentYear.studentType != null ? studentYear.studentType.id : null;
            this.tutorGroupId = studentYear.tutorGroup != null ? studentYear.tutorGroup.id : null;
            this.tutorGroup = studentYear.tutorGroup != null ? TutorGroupSummaryDto.mapFromEntity(studentYear.tutorGroup) : null
            this.startDate = studentYear.startDate != null ? studentYear.startDate : null;
            this.endDate = studentYear.endDate != null ? studentYear.endDate : null;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentYearDto from a StudentYear data object.
     *
     * @param studentYear the StudentYear data object to use for the creation.
     * @return a StudentYearDto object based on the StudentYear data object supplied.
     */
    public static StudentYearSummaryDto mapFromStudentYearEntity(StudentYear studentYear) {
        return new StudentYearSummaryDto(studentYear);
    }
    
    /**
     * This static method is used to create a List of StudentYearDto from a List of StudentYear data object.
     *
     * @param studentYears the List of StudentYear data object to use for the creation.
     * @return a List of StudentYearDto object based on the List of StudentYear data object supplied.
     */
    public static List<StudentYearSummaryDto> mapFromStudentYearEntities(List<StudentYear> studentYears) {
        return studentYears.collect { studentYear -> new StudentYearSummaryDto(studentYear) };
    }
    
    /**
     * This method is used to return the tutorGroup code for the StudentYear object
     *
     * @return the tutorGroup Code for the StudentYear object
     */
    @JsonProperty(value = "_tutorGroupCode")
    public String get_TutorGroupCode() {
        return this.tutorGroup != null ? this.tutorGroup.code : null
    }
    
    /**
     * This method is used to return the tutorGroup description for the StudentYear object
     *
     * @return the tutorGroup description for the StudentYear object
     */
    @JsonProperty(value = "_tutorGroupDescription")
    public String get_TutorGroupDescription() {
        return this.tutorGroup != null ? this.tutorGroup.description : null
    }
}