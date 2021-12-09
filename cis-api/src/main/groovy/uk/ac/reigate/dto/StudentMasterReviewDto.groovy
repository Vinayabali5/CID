package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.risk_assessment.RiskLevelDto

/**
 * This class is a DTO for display a summary of a student object.  
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class StudentMasterReviewDto  {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    PersonSummaryDto person
    
    @JsonProperty
    RiskLevelDto riskLevel
    
    @JsonProperty
    List<StudentYearSummaryDto> studentYears
    
    /**
     * Default No Args constructor  
     */
    StudentMasterReviewDto() {
    }
    
    /**
     * Constructor to create a StudentSummaryDto object from a Student object
     *
     * @param student, the Student object to use for construction
     */
    StudentMasterReviewDto (Student student) {
        if(student != null) {
            this.id = student.id
            this.person = student.person != null ? new PersonSummaryDto(student.person) : null
            this.riskLevel = student.riskLevel != null ? RiskLevelDto.mapFromEntity(student.riskLevel) : null
            this.studentYears = student.studentYears != null ? StudentYearSummaryDto.mapFromStudentYearEntities(student.studentYears) : null;
        }
    }
    
    /**
     * This static method is used to create a StudentSummaryDto from a Student data object.
     *
     * @param student the Student data object to use for the creation.
     * @return a StudentDto object based on the Student data object supplied.
     */
    public static StudentMasterReviewDto mapFromEntity(Student student) {
        return new StudentMasterReviewDto(student)
    }
    
    /**
     * This static method is used to create a List of StudentDto from a List of Student data object.
     *
     * @param students the List of Student data object to use for the creation.
     * @return a List of StudentSummaryDto object based on the List of Student data object supplied.
     */
    public static List<StudentMasterReviewDto> mapFromList(List<Student> students) {
        return students.collect { student ->  new StudentMasterReviewDto(student) };
    }
}
