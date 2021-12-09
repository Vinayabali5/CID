package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.learning_support.StudentReferralReason

/**
 *
 * JSON serializable DTO containing ReferralReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentReferralReasonDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer referralReasonId;
    
    @JsonProperty
    private ReferralReasonDto referralReason;
    
    @JsonProperty
    private Boolean primary;
    
    /**
     * Default No Args constructor
     */
    public StudentReferralReasonDto() {
    }
    
    /**
     * Constructor to create a StudentReferralReasonDto object from a StudentReferralReason object
     *
     * @param studentReferralReason the StudentReferralReason object to use for construction
     */
    public StudentReferralReasonDto(StudentReferralReason studentReferralReason) {
        if(studentReferralReason != null) {
            this.id = studentReferralReason.id;
            this.studentId = studentReferralReason.student != null ? studentReferralReason.student.id : null;
            this.referralReasonId = studentReferralReason.referralReason != null ? studentReferralReason.referralReason.id : null;
            this.referralReason = studentReferralReason.referralReason != null ? ReferralReasonDto.mapFromEntity(studentReferralReason.referralReason) : null
            this.primary = studentReferralReason.primary;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentReferralReasonDto from a StudentReferralReason data object.
     *
     * @param studentReferralReason the StudentReferralReason data object to use for the creation.
     * @return a StudentReferralReasonDto object based on the StudentReferralReason data object supplied.
     */
    public static StudentReferralReasonDto mapFromEntity(StudentReferralReason studentReferralReason) {
        return new StudentReferralReasonDto(studentReferralReason);
    }
    
    /**
     * This static method is used to create a List of StudentReferralReasonto from a List of StudentReferralReason data object.
     *
     * @param studentReferralReasons the List of StudentReferralReason data object to use for the creation.
     * @return a List of StudentReferralReasonDto object based on the List of StudentReferralReason data object supplied.
     */
    public static List<StudentReferralReasonDto> mapFromList(List<StudentReferralReason> studentReferralReasons) {
        return studentReferralReasons.collect { studentReferralReason ->  new StudentReferralReasonDto(studentReferralReason) };
    }
    
    /**
     * This method is used to return the ReferralReason Reason for the StudentReferralReason object
     *
     * @return the ReferralReason Reason for the StudentReferralReason object
     */
    @JsonProperty(value = "_referralReasonDescription")
    public String get_ReferralReasonDescription() {
        return this.referralReason != null ? this.referralReason.reason : null
    }
}
