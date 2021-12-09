package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.risk_assessment.RiskLevelDto

/**
 * This class is a DTO for display a summary of a student object.  
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class StudentSummaryDto  {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    String referenceNo
    
    @JsonProperty
    PersonSummaryDto person
    
    @JsonProperty
    Integer previousSchoolId
    
    @JsonProperty
    SchoolDto School
    
    @JsonProperty
    String uln
    
    @JsonProperty
    String uci
    
    @JsonProperty
    Integer specialCategoryId
    
    @JsonProperty
    SpecialCategoryDto specialCategory
    
    @JsonProperty
    Boolean specialConfirmed
    
    @JsonProperty
    String _studentEmail
    
    @JsonProperty
    Boolean monitorable
    
    @JsonProperty
    RiskLevelDto riskLevel
    
    /**
     * Default No Args constructor  
     */
    StudentSummaryDto() {
    }
    
    /**
     * Constructor to create a StudentSummaryDto object from a Student object
     *
     * @param student, the Student object to use for construction
     */
    StudentSummaryDto (Student student) {
        if(student != null) {
            this.id = student.id
            this.referenceNo = student.referenceNo
            this.person = student.person != null ? new PersonSummaryDto(student.person) : null
            this.previousSchoolId = student.school != null ? student.school.id : null
            this.school = student.school != null ? SchoolDto.mapFromEntity(student.school) : null
            this.specialConfirmed = student.specialConfirmed;
            this.uln = student.uln
            this.uci = student.uci
            this.specialConfirmed = student.specialConfirmed;
            this.specialCategoryId = student.specialCategory != null ? student.specialCategory.id : null
            this.specialCategory = student.specialCategory != null ? SpecialCategoryDto.mapFromEntity(student.specialCategory) : null
            this._studentEmail = student.studentEmail;
            this.monitorable = student.monitorable;
            this.riskLevel = student.riskLevel != null ? RiskLevelDto.mapFromEntity(student.riskLevel) : null
        }
    }
    
    /**
     * This static method is used to create a StudentSummaryDto from a Student data object.
     *
     * @param student the Student data object to use for the creation.
     * @return a StudentDto object based on the Student data object supplied.
     */
    public static StudentSummaryDto mapFromEntity(Student student) {
        return new StudentSummaryDto(student)
    }
    
    /**
     * This static method is used to create a List of StudentDto from a List of Student data object.
     *
     * @param students the List of Student data object to use for the creation.
     * @return a List of StudentSummaryDto object based on the List of Student data object supplied.
     */
    public static List<StudentSummaryDto> mapFromList(List<Student> students) {
        return students.collect { student ->  new StudentSummaryDto(student) };
    }
    
    /**
     * This method is used to return the school name for the Student object
     *
     * @return the school name for the Student object
     */
    @JsonProperty(value = "_previousSchoolName")
    public String get_PreviousSchoolName() {
        return this.school != null ? this.school.name : null
    }
    
    /**
     * This method is used to return the SpecialCategory Code for the Student object
     *
     * @return the SpecialCategory Code for the Student object
     */
    @JsonProperty(value = "_specialCategoryCode")
    public String get_SpecialCategoryCode() {
        return this.specialCategory != null ? this.specialCategory.code : null
    }
    
    /**
     * This method is used to return the SpecialCategory Description for the Student object
     *
     * @return the SpecialCategory Description for the Student object
     */
    @JsonProperty(value = "_specialCategoryDescription")
    public String get_SpecialCategoryDescription() {
        return this.specialCategory != null ? this.specialCategory.description : null
    }
    
    /**
     * This method is used to return the SpecialCategory Details for the Student object
     *
     * @return the SpecialCategory Details for the Student object
     */
    @JsonProperty(value = "_specialCategoryDetails")
    public String get_SpecialCategoryDetails() {
        return this.specialCategory != null ? this.specialCategory.details : null
    }
}
