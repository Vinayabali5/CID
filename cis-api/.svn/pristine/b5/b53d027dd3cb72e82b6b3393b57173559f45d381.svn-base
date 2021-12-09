package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import uk.ac.reigate.domain.ilr.MathsConditionOfFunding
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing MathsConditionOfFunding data
 *
 */
@ApiModel
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class MathsConditionOfFundingDto implements Serializable {
    
    @ApiModelProperty(position = 1, required = false, value = "The ID of the MathsConditionOfFunding object stored in the database. This must be provided for any PUT operations but omitted for POST opertions.")
    @JsonProperty
    private Integer id;
    
    @ApiModelProperty(position = 2, required = true, value = "The code of the MathsConditionOfFunding object stored in the database")
    @JsonProperty
    private String code;
    
    @ApiModelProperty(position = 3, required = true, value = "The description of the MathsConditionOfFunding object stored in the database")
    @JsonProperty
    private String description;
    
    @ApiModelProperty(position = 4, required = true, value = "The short description of the MathsConditionOfFunding object stored in the database")
    @JsonProperty
    private String shortDescription;
    
    @ApiModelProperty(position = 5, required = true, value = "The valid from date of the MathsConditionOfFunding object stored in the database", dataType = "string date")
    @JsonProperty
    private Date validFrom;
    
    @ApiModelProperty(position = 6, required = true, value = "The valid to date of the MathsConditionOfFunding object stored in the database")
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public MathsConditionOfFundingDto() {
    }
    
    /**
     * Constructor to create a MathsConditionOfFundingDto object from a MathsConditionOfFunding object
     *
     * @param mathsConditionOfFunding the MathsConditionOfFunding object to use for construction
     */
    MathsConditionOfFundingDto(MathsConditionOfFunding mathsConditionOfFunding) {
        if(mathsConditionOfFunding != null) {
            this.id = mathsConditionOfFunding.id;
            this.code = mathsConditionOfFunding.code;
            this.description = mathsConditionOfFunding.description;
            this.shortDescription = mathsConditionOfFunding.shortDescription;
            this.validFrom = mathsConditionOfFunding.validFrom;
            this.validTo = mathsConditionOfFunding.validTo;
        } else {
            throw new InvalidDataException("Cannot create MathsConditionOfFundingDto from null object.")
        }
    }
    
    /**
     * This static method is used to create a MathsConditionOfFundingDto from a MathsConditionOfFunding data object.
     *
     * @param mathsConditionOfFunding the MathsConditionOfFunding data object to use for the creation.
     * @return a MathsConditionOfFundingDto object based on the MathsConditionOfFunding data object supplied.
     */
    public static MathsConditionOfFundingDto mapFromEntity(MathsConditionOfFunding mathsConditionOfFunding) {
        return new MathsConditionOfFundingDto(mathsConditionOfFunding);
    }
    
    /**
     * This static method is used to create a List of MathsConditionOfFundingDto from a List of MathsConditionOfFunding data object.
     *
     * @param mathsConditionOfFundings the List of MathsConditionOfFunding data object to use for the creation.
     * @return a List of MathsConditionOfFundingDto object based on the List of MathsConditionOfFunding data object supplied.
     */
    public static List<MathsConditionOfFundingDto> mapFromList(List<MathsConditionOfFunding> mathsConditionOfFundings) {
        List<MathsConditionOfFundingDto> output = mathsConditionOfFundings.collect { mathsConditionOfFunding ->  new MathsConditionOfFundingDto(mathsConditionOfFunding) };
        return output
    }
}
