package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.EnglishConditionOfFunding

/**
 *
 * JSON serializable DTO containing EnglishConditionOfFunding data
 *
 */
@ApiModel
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EnglishConditionOfFundingDto implements Serializable {
    
    @ApiModelProperty(position = 1, required = false, value = "The ID of the EnglishConditionOfFunding object stored in the database. This must be provided for any PUT operations but omitted for POST opertions.")
    @JsonProperty
    private Integer id;
    
    @ApiModelProperty(position = 2, required = true, value = "The code of the EnglishConditionOfFunding object stored in the database")
    @JsonProperty
    private String code;
    
    @ApiModelProperty(position = 3, required = true, value = "The description of the EnglishConditionOfFunding object stored in the database")
    @JsonProperty
    private String description;
    
    @ApiModelProperty(position = 4, required = true, value = "The short description of the EnglishConditionOfFunding object stored in the database")
    @JsonProperty
    private String shortDescription;
    
    @ApiModelProperty(position = 5, required = true, value = "The valid from date of the EnglishConditionOfFunding object stored in the database", dataType = "string date")
    @JsonProperty
    private Date validFrom;
    
    @ApiModelProperty(position = 6, required = true, value = "The valid to date of the EnglishConditionOfFunding object stored in the database")
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public EnglishConditionOfFundingDto() {
    }
    
    /**
     * Constructor to create an EnglishConditionOfFundingDto object from a EnglishConditionOfFunding object
     *
     * @param englishConditionOfFunding the EnglishConditionOfFunding object to use for construction
     */
    EnglishConditionOfFundingDto(EnglishConditionOfFunding englishConditionOfFunding) {
        this.id = englishConditionOfFunding.id;
        this.code = englishConditionOfFunding.code;
        this.description = englishConditionOfFunding.description;
        this.shortDescription = englishConditionOfFunding.shortDescription;
        this.validFrom = englishConditionOfFunding.validFrom;
        this.validTo = englishConditionOfFunding.validTo;
    }
    
    /**
     * This static method is used to create a EnglishConditionOfFundingDto from a EnglishConditionOfFunding data object.
     *
     * @param englishConditionOfFunding the EnglishConditionOfFunding data object to use for the creation.
     * @return a EnglishConditionOfFundingDto object based on the EnglishConditionOfFunding data object supplied.
     */
    public static EnglishConditionOfFundingDto mapFromEntity(EnglishConditionOfFunding englishConditionOfFunding) {
        return new EnglishConditionOfFundingDto(englishConditionOfFunding);
    }
    
    /**
     * This static method is used to create a List of EnglishConditionOfFundingDto from a List of EnglishConditionOfFunding data object.
     *
     * @param englishConditionOfFundings the List of EnglishConditionOfFunding data object to use for the creation.
     * @return a List of EnglishConditionOfFundingDto object based on the List of EnglishConditionOfFunding data object supplied.
     */
    public static List<EnglishConditionOfFundingDto> mapFromList(List<EnglishConditionOfFunding> englishConditionOfFundings) {
        return englishConditionOfFundings.collect { englishConditionOfFunding ->  new EnglishConditionOfFundingDto(englishConditionOfFunding) };
    }
}