package uk.ac.reigate.dto.risk_assessment

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentRiskAssessment
import uk.ac.reigate.dto.StaffDto

/**
 *
 * JSON serializable DTO containing LearningSupport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentRiskAssessmentDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private String riskToStudent
    
    @JsonProperty
    private String actionsToMinimiseRisk
    
    @JsonProperty
    private String riskToOtherStudents
    
    @JsonProperty
    private String riskToStaff
    
    @JsonProperty
    private String whoToInform
    
    @JsonProperty
    private String otherAgenciesInvolved
    
    @JsonProperty
    private String agencyContactDetails
    
    @JsonProperty
    private Integer completeByStaffId
    
    @JsonProperty
    private String _completeByStaffName
    
    /**
     * Default No Args constructor
     */
    public StudentRiskAssessmentDto() {
    }
    
    /**
     * Constructor to create a StudentRiskAssessmentDto object from a Student, StudentRiskAssessment object
     *
     * @param student, studentRiskAssessment the Student, StudentRiskAssessment object to use for construction
     */
    public StudentRiskAssessmentDto(StudentRiskAssessment studentRiskAssessment) {
        if (studentRiskAssessment != null) {
            this.riskToStudent = studentRiskAssessment.riskToStudent
            this.actionsToMinimiseRisk = studentRiskAssessment.actionsToMinimiseRisk
            this.riskToOtherStudents = studentRiskAssessment.riskToOtherStudents
            this.riskToStaff = studentRiskAssessment.riskToStaff
            this.whoToInform = studentRiskAssessment.whoToInform
            this.otherAgenciesInvolved = studentRiskAssessment.otherAgenciesInvolved
            this.agencyContactDetails = studentRiskAssessment.agencyContactDetails
            this.completeByStaffId = studentRiskAssessment.completeByStaff != null ? studentRiskAssessment.completeByStaff.id : null;
            this._completeByStaffName  = studentRiskAssessment.completeByStaff != null && studentRiskAssessment.completeByStaff.person != null ? studentRiskAssessment.completeByStaff.person.surname + ', ' + studentRiskAssessment.completeByStaff.person.firstName : ''
            Student student = studentRiskAssessment.student
            if (student != null) {
                this.studentId = student.id
            }
        }
    }
    
    /**
     * This static method is used to create a StudentRiskAssessmentDto from a StudentRiskAssessment data object.
     *
     * @param studentRiskAssessment the StudentRiskAssessmentContact data object to use for the creation.
     * @return a StudentRiskAssessmentDto object based on the StudentRiskAssessment data object supplied.
     */
    public static StudentRiskAssessmentDto mapFromEntity(StudentRiskAssessment studentRiskAssessment) {
        return new StudentRiskAssessmentDto(studentRiskAssessment);
    }
    
    /**
     * This static method is used to create a List of StudentRiskAssessmentDto from a List of StudentRiskAssessment data object.
     *
     * @param StudentRiskAssessments the List of StudentRiskAssessment data object to use for the creation.
     * @return a List of StudentRiskAssessmentDto object based on the List of StudentRiskAssessment data object supplied.
     */
    public static List<StudentRiskAssessmentDto> mapFromList(List<StudentRiskAssessment> studentRiskAssessments) {
        return studentRiskAssessments.collect { studentRiskAssessment ->  new StudentRiskAssessmentDto(studentRiskAssessment) };
    }
}