package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.SpecialCategory;
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory

/**
 *
 * JSON serializable DTO containing StudentSpecialCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentSpecialCategoryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Date requestDate
    
    @JsonProperty
    private Integer specialCategoryId
    
    @JsonProperty
    private Boolean specialConfirmed
    
    @JsonProperty
    private Date classificationDate
    
    @JsonProperty
    private Date closedDate
    
    @JsonProperty
    private String monitoringNotes
    
    @JsonProperty
    private Integer staffRequestingId
    
    @JsonProperty
    private Boolean riskAssessmentRequired
    
    @JsonProperty
    private Integer riskAssessmentToBeCompletedById
    
    @JsonProperty
    private Boolean informationConfidential
    
    @JsonProperty
    private Boolean writtenEvidence
    
    @JsonProperty
    private Boolean passToStaffConcerned
    
    @JsonProperty
    private Integer staffConcernedId
    
    @JsonProperty
    private String riskToStudentOrOthers
    
    @JsonProperty
    private String emergencyContactNos
    
    @JsonProperty
    private String outsideAgenciesInvolved
    
    @JsonProperty
    private String toBeInformedPotentialRisks
    
    @JsonProperty
    private Integer riskAssessmentRaisedById
    
    @JsonProperty
    private Date riskAssessmentRaisedDate
    
    @JsonProperty
    private Integer riskAssessmentCarriedOutById
    
    @JsonProperty
    private Date riskAssessmentCarriedOutDate
    
    @JsonProperty
    private String inEventEmergency
    
    /**
     * Default No Args constructor
     */
    public StudentSpecialCategoryDto() {
    }
    
    /**
     * Constructor to create a StudentSpecialCategoryDto object from a StudentSpecialCategory object
     *
     * @param studentSpecialCategory the StudentSpecialCategory object to use for construction
     */
    StudentSpecialCategoryDto(StudentSpecialCategory studentSpecialCategory) {
        if(studentSpecialCategory != null) {
            this.id = studentSpecialCategory.id;
            this.studentId = studentSpecialCategory.student != null ? studentSpecialCategory.student.id : null;
            this.requestDate = studentSpecialCategory.requestDate;
            this.specialCategoryId = studentSpecialCategory.specialCategory != null ? studentSpecialCategory.specialCategory.id : null;
            this.specialConfirmed = studentSpecialCategory.specialConfirmed;
            this.classificationDate = studentSpecialCategory.classificationDate;
            this.closedDate = studentSpecialCategory.closedDate;
            this.monitoringNotes = studentSpecialCategory.monitoringNotes;
            this.staffRequestingId = studentSpecialCategory.staffRequesting != null ? studentSpecialCategory.staffRequesting.id : null;
            this.riskAssessmentRequired = studentSpecialCategory.riskAssessmentRequired;
            this.riskAssessmentToBeCompletedById = studentSpecialCategory.riskAssessmentToBeCompletedBy != null ? studentSpecialCategory.riskAssessmentToBeCompletedBy.id : null;
            this.informationConfidential = studentSpecialCategory.informationConfidential;
            this.writtenEvidence = studentSpecialCategory.writtenEvidence;
            this.passToStaffConcerned = studentSpecialCategory.passToStaffConcerned;
            this.staffConcernedId = studentSpecialCategory.staffConcerned != null ? studentSpecialCategory.staffConcerned.id : null;;
            this.riskToStudentOrOthers = studentSpecialCategory.riskToStudentOrOthers;
            this.emergencyContactNos = studentSpecialCategory.emergencyContactNos;
            this.outsideAgenciesInvolved = studentSpecialCategory.outsideAgenciesInvolved;
            this.toBeInformedPotentialRisks = studentSpecialCategory.toBeInformedPotentialRisks;
            this.riskAssessmentRaisedById = studentSpecialCategory.riskAssessmentRaisedBy != null ? studentSpecialCategory.riskAssessmentRaisedBy.id : null;
            this.riskAssessmentRaisedDate = studentSpecialCategory.riskAssessmentRaisedDate;
            this.riskAssessmentCarriedOutById = studentSpecialCategory.riskAssessmentCarriedOutBy != null ? studentSpecialCategory.riskAssessmentCarriedOutBy.id : null;
            this.riskAssessmentCarriedOutDate = studentSpecialCategory.riskAssessmentCarriedOutDate;
            this.inEventEmergency = studentSpecialCategory.inEventEmergency;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentSpecialCategoryDto from a StudentSpecialCategory data object.
     *
     * @param studentSpecialCategory the StudentSpecialCategory data object to use for the creation.
     * @return a StudentSpecialCategoryDto object based on the StudentSpecialCategory data object supplied.
     */
    public static StudentSpecialCategoryDto mapFromEntity(StudentSpecialCategory studentSpecialCategory) {
        return new StudentSpecialCategoryDto(studentSpecialCategory)
    }
    
    /**
     * This static method is used to create a List of StudentSpecialCategoryDto from a List of StudenSpecialCategory data object.
     *
     * @param studentSpecialCategories the List of StudentSpecialCategory data object to use for the creation.
     * @return a List of StudentSpecialCategoryDto object based on the List of StudentSpecialCategory data object supplied.
     */
    public static List<StudentSpecialCategoryDto> mapFromList(List<StudentSpecialCategory> studentSpecialCategories) {
        return studentSpecialCategories.collect { studentSpecialCategory ->  new StudentSpecialCategoryDto(studentSpecialCategory) };
    }
}
