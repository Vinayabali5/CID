package uk.ac.reigate.dto;


import javax.persistence.Column

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.SchoolReference
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing SchoolReference data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SchoolReferenceDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private StudentSummaryDto student
    
    @JsonProperty
    private Integer meetingTargets
    
    @JsonProperty
    private Integer effort
    
    @JsonProperty
    private Integer workEthic
    
    @JsonProperty
    private Integer homeworkCompletion
    
    @JsonProperty
    private Integer behaviour
    
    @JsonProperty
    private Integer organisation
    
    @JsonProperty
    private Integer attainmentPotential
    
    @JsonProperty
    private Double year10Attendance
    
    @JsonProperty
    private String year10AttendanceComment
    
    @JsonProperty
    private Double year11Attendance
    
    @JsonProperty
    private String year11AttendanceComment
    
    @JsonProperty
    private Integer reliability
    
    @JsonProperty
    private Integer independence
    
    @JsonProperty
    private Integer sociability
    
    @JsonProperty
    private Integer relationshipWithStaff
    
    @JsonProperty
    private Boolean recommend;
    
    @JsonProperty
    private String recommendComment
    
    @JsonProperty
    private Boolean behaviouralIssues
    
    @JsonProperty
    private String behaviouralIssuesComment
    
    @JsonProperty
    private String responsibilitiesExtraCurricular
    
    @JsonProperty
    private Boolean senco
    
    @JsonProperty
    private String areasOfNeed
    
    @JsonProperty
    private Boolean ehcp
    
    @JsonProperty
    private Boolean senPlan
    
    @JsonProperty
    private String detailsOfSupport
    
    @JsonProperty
    private String externalAgencies
    
    @JsonProperty
    private Boolean safeguardingIssues
    
    @JsonProperty
    private String literacyLevel
    
    @JsonProperty
    private Boolean examAccess
    
    @JsonProperty
    private String examAccessDetails
    
    @JsonProperty
    private Date dateOfLastReport
    
    /**
     * Default No Args constructor
     */
    public SchoolReferenceDto() {
    }
    
    /**
     * Constructor to create an SchoolReferenceDto object from a SchoolReference object
     *
     * @param schoolReference the SchoolReference object to use for construction
     */
    SchoolReferenceDto(SchoolReference schoolReference) {
        if(schoolReference != null) {
            this.studentId = schoolReference.student.id;
            this.student =  StudentSummaryDto.mapFromEntity(schoolReference.student)
            this.meetingTargets = schoolReference.meetingTargets
            this.effort = schoolReference.effort
            this.workEthic = schoolReference.workEthic;
            this.homeworkCompletion = schoolReference.homeworkCompletion;
            this.behaviour = schoolReference.behaviour
            this.organisation = schoolReference.organisation
            this.attainmentPotential = schoolReference.attainmentPotential
            this.year10Attendance = schoolReference.year10Attendance;
            this.year10AttendanceComment = schoolReference.year10AttendanceComment;
            this.year11Attendance = schoolReference.year11Attendance
            this.year11AttendanceComment = schoolReference.year11AttendanceComment
            this.reliability = schoolReference.reliability
            this.independence = schoolReference.independence;
            this.sociability = schoolReference.sociability;
            this.relationshipWithStaff = schoolReference.relationshipWithStaff
            this.recommend = schoolReference.recommend
            this.recommendComment = schoolReference.recommendComment
            this.behaviouralIssuesComment = schoolReference.behaviouralIssuesComment
            this.behaviouralIssues = schoolReference.behaviouralIssues
            this.responsibilitiesExtraCurricular = schoolReference.responsibilitiesExtraCurricular;
            this.senco = schoolReference.senco;
            this.areasOfNeed = schoolReference.areasOfNeed
            this.ehcp= schoolReference.ehcp
            this.senPlan = schoolReference.senPlan
            this.detailsOfSupport = schoolReference.detailsOfSupport;
            this.externalAgencies = schoolReference.externalAgencies;
            this.safeguardingIssues = schoolReference.safeguardingIssues
            this.literacyLevel = schoolReference.literacyLevel
            this.examAccess = schoolReference.examAccess;
            this.examAccessDetails = schoolReference.examAccessDetails;
            this.dateOfLastReport = schoolReference.dateOfLastReport
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a SchoolReferenceDto from a SchoolReference data object.
     *
     * @param schoolReference the SchoolReference data object to use for the creation.
     * @return a SchoolReferenceDto object based on the SchoolReference data object supplied.
     */
    public static SchoolReferenceDto mapFromEntity(SchoolReference schoolReference) {
        return new SchoolReferenceDto(schoolReference)
    }
    
    /**
     * This static method is used to create a List of SchoolReferenceDto from a List of SchoolReference data object.
     *
     * @param schoolReferences the List of SchoolReference data object to use for the creation.
     * @return a List of SchoolReferenceDto object based on the List of SchoolReference data object supplied.
     */
    public static List<SchoolReferenceDto> mapFromList(List<SchoolReference> schoolReferences) {
        return schoolReferences.collect { schoolReference ->  new SchoolReferenceDto(schoolReference) };
    }
}
