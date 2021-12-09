package uk.ac.reigate.dto.risk_assessment

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.risk_assessment.StudentRiskLevel
import uk.ac.reigate.dto.StaffDto


/**
 *
 * JSON serializable DTO containing StudentRiskLevel data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentRiskLevelDto implements Serializable{
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer riskLevelId;
    
    @JsonProperty
    private RiskLevelDto riskLevel
    
    @JsonProperty
    private Integer staffRequestingId
    
    @JsonProperty
    private StaffDto staffRequesting;
    
    @JsonProperty
    private Date dateRequested
    
    @JsonProperty
    private Boolean confidential
    
    @JsonProperty
    private Boolean evidence
    
    @JsonProperty
    private Boolean riskAssessmentRequired
    
    @JsonProperty
    private Boolean safetyPlanRequired
    
    @JsonProperty
    private Date dateForReview
    
    @JsonProperty
    private String riskNotes
    
    /**
     * Default No Args constructor
     */
    public StudentRiskLevelDto() {
    }
    
    /**
     * Constructor to create an StudentRiskLevelDto object from a StudentRiskLevel object
     *
     * @param studentRiskLevel the StudentRiskLevel object to use for construction
     */
    StudentRiskLevelDto(StudentRiskLevel studentRiskLevel) {
        if(studentRiskLevel != null) {
            this.id = studentRiskLevel.id;
            this.studentId = studentRiskLevel.student != null ? studentRiskLevel.student.id : null;
            this.riskLevelId = studentRiskLevel.riskLevel != null ? studentRiskLevel.riskLevel.id : null;
            this.riskLevel = studentRiskLevel.riskLevel != null ? RiskLevelDto.mapFromEntity(studentRiskLevel.riskLevel) : null;
            this.staffRequestingId = studentRiskLevel.staffRequesting != null ? studentRiskLevel.staffRequesting.id : null;
            this.staffRequesting = StaffDto.mapFromEntity(studentRiskLevel.staffRequesting)
            this.dateRequested = studentRiskLevel.dateRequested;
            this.confidential = studentRiskLevel.confidential;
            this.evidence = studentRiskLevel.evidence;
            this.riskAssessmentRequired = studentRiskLevel.riskAssessmentRequired
            this.safetyPlanRequired =  studentRiskLevel.safetyPlanRequired
            this.dateForReview = studentRiskLevel.dateForReview
            this.riskNotes = studentRiskLevel.riskNotes
        }
    }
    
    /**
     * This static method is used to create a StudentRiskLevelDto from a StudentRiskLevel data object.
     *
     * @param studentRiskLevel the StudentRiskLevel data object to use for the creation.
     * @return a StudentRiskLevelDto object based on the StudentRiskLevel data object supplied.
     */
    public static StudentRiskLevelDto mapFromEntity(StudentRiskLevel studentRiskLevel) {
        return new StudentRiskLevelDto(studentRiskLevel)
    }
    
    /**
     * This static method is used to create a List of StudentRiskLevelDto from a List of StudentRiskLevel data object.
     *
     * @param studentRiskLevels the List of StudentRiskLevel data object to use for the creation.
     * @return a List of StudentRiskLevelDto object based on the List of StudentRiskLevel data object supplied.
     */
    public static List<StudentRiskLevelDto> mapFromList(List<StudentRiskLevel> studentRiskLevels) {
        return studentRiskLevels.collect { studentRiskLevel ->  new StudentRiskLevelDto(studentRiskLevel) };
    }
    
    /**
     * This method is used to return the RiskLevel Code for the StudentRiskLevel object
     *
     * @return the RiskLevel Code for the StudentRiskLevel object
     */
    @JsonProperty(value = "_riskLevelCode")
    public String get_RiskLevelCode() {
        return this.riskLevel != null ? this.riskLevel.code : null
    }
    
    /**
     * This method is used to return the RiskLevel Description for the StudentRiskLevel object
     *
     * @return the RiskLevel Description for the StudentRiskLevel object
     */
    @JsonProperty(value = "_riskLevelDescription")
    public String get_RiskLevelDescription() {
        return this.riskLevel != null ? this.riskLevel.description : null
    }
    
    /**
     * This method is used to return the StaffRequesting Name for the StudentRiskLevel object
     *
     * @return the StaffRequesting Name for the StudentRiskLevel object
     */
    @JsonProperty(value = "_staffRequestingName")
    public String get_StaffRequestingName() {
        return this.staffRequesting != null && this.staffRequesting.person != null ? this.staffRequesting.person.surname + '-' + this.staffRequesting.person.firstName : null
    }
}
