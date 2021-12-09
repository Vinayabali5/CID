package uk.ac.reigate.dto.risk_assessment

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentSafetyPlan

/**
 *
 * JSON serializable DTO containing LearningSupport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentSafetyPlanDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private String howToReduceRiskAtHome
    
    @JsonProperty
    private String warningSignsOrTriggers
    
    @JsonProperty
    private String pastActionsToHelp
    
    @JsonProperty
    private String actionsToCalmAndSoothe
    
    @JsonProperty
    private String whatToTellSelf
    
    @JsonProperty
    private String whoWouldbeSaidToFriend
    
    @JsonProperty
    private String whatCouldOthersDo
    
    @JsonProperty
    private String whoCanICall
    
    @JsonProperty
    private Integer completedWithId
    
    @JsonProperty
    private String _completedWithName
    
    @JsonProperty
    private Date dateCompleted
    
    /**
     * Default No Args constructor
     */
    public StudentSafetyPlanDto() {
    }
    
    /**
     * Constructor to create a StudentSafetyPlanDto object from a Student, StudentSafetyPlan object
     *
     * @param student, studentSafetyPlan the Student, StudentSafetyPlan object to use for construction
     */
    public StudentSafetyPlanDto(StudentSafetyPlan studentSafetyPlan) {
        if (studentSafetyPlan != null) {
            this.id = studentSafetyPlan.id
            this.howToReduceRiskAtHome = studentSafetyPlan.howToReduceRiskAtHome
            this.warningSignsOrTriggers = studentSafetyPlan.warningSignsOrTriggers
            this.pastActionsToHelp = studentSafetyPlan.pastActionsToHelp
            this.actionsToCalmAndSoothe = studentSafetyPlan.actionsToCalmAndSoothe
            this.whatToTellSelf = studentSafetyPlan.whatToTellSelf
            this.whoWouldbeSaidToFriend = studentSafetyPlan.whoWouldbeSaidToFriend
            this.whatCouldOthersDo = studentSafetyPlan.whatCouldOthersDo
            this.whoCanICall = studentSafetyPlan.whoCanICall
            this.dateCompleted = studentSafetyPlan.dateCompleted
            this.completedWithId = studentSafetyPlan.completedWith != null ? studentSafetyPlan.completedWith.id : null;
            this._completedWithName = studentSafetyPlan.completedWith != null && studentSafetyPlan.completedWith.person != null ? studentSafetyPlan.completedWith.person.surname + '-' + studentSafetyPlan.completedWith.person.firstName : ''
            Student student = studentSafetyPlan.student
            if (student != null) {
                this.studentId = student.id
            }
        }
    }
    
    public static StudentSafetyPlanDto mapFromEntity(StudentSafetyPlan studentSafetyPlan) {
        return new StudentSafetyPlanDto(studentSafetyPlan);
    }
    
    public static List<StudentSafetyPlanDto> mapFromList(List<StudentSafetyPlan> studentSafetyPlans) {
        return studentSafetyPlans.collect { studentSafetyPlan ->  new StudentSafetyPlanDto(studentSafetyPlan) };
    }
}

