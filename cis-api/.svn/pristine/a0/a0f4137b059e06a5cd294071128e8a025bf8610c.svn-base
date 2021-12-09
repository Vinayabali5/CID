package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.learning_support.ReferralReason

/**
 *
 * JSON serializable DTO containing ReferralReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ReferralReasonDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String reason;
    
    @JsonProperty
    private Integer llddHealthProblemCategoryId;
    
    @JsonProperty
    private LLDDHealthProblemCategoryDto llddHealthProblemCategory;
    
    /**
     * Default No Args constructor
     */
    public ReferralReasonDto() {
    }
    
    /**
     * Constructor to create a ReferralReasonDto object from a ReferralReason object
     *
     * @param referralReason the ReferralReason object to use for construction
     */
    ReferralReasonDto(ReferralReason referralReason) {
        if(referralReason != null) {
            this.id = referralReason.id;
            this.reason = referralReason.reason;
            this.llddHealthProblemCategoryId = referralReason.llddHealthProblemCategory != null ? referralReason.llddHealthProblemCategory.id : null;
            this.llddHealthProblemCategory =  referralReason.llddHealthProblemCategory != null ? LLDDHealthProblemCategoryDto.mapFromEntity(referralReason.llddHealthProblemCategory) : null;
        }
    }
    
    /**
     * This static method is used to create a ReferralReasonDto from a ReferralReason data object.
     *
     * @param referralReason the ReferralReason data object to use for the creation.
     * @return a ReferralReasonDto object based on the ReferralReason data object supplied.
     */
    public static ReferralReasonDto mapFromEntity(ReferralReason referralReason) {
        return new ReferralReasonDto(referralReason);
    }
    
    /**
     * This static method is used to create a List of ReferralReasonDto from a List of ReferralReason data object.
     *
     * @param referralReasons the List of ReferralReason data object to use for the creation.
     * @return a List of ReferralReasonDto object based on the List of ReferralReason data object supplied.
     */
    public static List<ReferralReasonDto> mapFromList(List<ReferralReason> referralReasons) {
        return referralReasons.collect { referralReason ->  mapFromEntity(referralReason) };
    }
    
    /**
     * This method is used to return the llddHealthProblemCategory Description for the ReferralReason object
     *
     * @return the llddHealthProblemCategory Description for the ReferralReason object
     */
    @JsonProperty(value = "_llddHealthProblemCategoryDescription")
    public String get_LLDDHealthProblemCategoryDescription() {
        return this.llddHealthProblemCategory != null ? this.llddHealthProblemCategory.description : null
    }
}
