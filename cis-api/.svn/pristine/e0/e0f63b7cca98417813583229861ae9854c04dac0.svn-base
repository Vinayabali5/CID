package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.WithdrawalReason

/**
 *
 * JSON serializable DTO containing WithdrawalReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class WithdrawalReasonDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String shortDescription;
    
    @JsonProperty
    private Date validFrom;
    
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public WithdrawalReasonDto() {
    }
    
    /**
     * Constructor to create a WithdrawalReasonDto object from a WithdrawalReason object
     *
     * @param withdrawalReason the WithdrawalReason object to use for construction
     */
    WithdrawalReasonDto(WithdrawalReason withdrawalReason) {
        if(withdrawalReason != null) {
            this.id = withdrawalReason.id;
            this.code = withdrawalReason.code;
            this.description = withdrawalReason.description;
            this.shortDescription = withdrawalReason.shortDescription;
            this.validFrom = withdrawalReason.validFrom;
            this.validTo = withdrawalReason.validTo;
        }
    }
    
    /**
     * This static method is used to create a WithdrawalReasonDto from a WithdrawalReason data object.
     *
     * @param withdrawalReason the WithdrawalReason data object to use for the creation.
     * @return a WithdrawalReasonDto object based on the WithdrawalReason data object supplied.
     */
    public static WithdrawalReasonDto mapFromEntity(WithdrawalReason withdrawalReason) {
        return new WithdrawalReasonDto(withdrawalReason);
    }
    
    /**
     * This static method is used to create a List of WithdrawalReasonDto from a List of WithdrawalReason data object.
     *
     * @param withdrawalReasons the List of WithdrawalReason data object to use for the creation.
     * @return a List of WithdrawalReasonDto object based on the List of WithdrawalReason data object supplied.
     */
    public static List<WithdrawalReasonDto> mapFromList(List<WithdrawalReason> withdrawalReasons) {
        return withdrawalReasons.collect { withdrawalReason ->  new WithdrawalReasonDto(withdrawalReason) };
    }
}