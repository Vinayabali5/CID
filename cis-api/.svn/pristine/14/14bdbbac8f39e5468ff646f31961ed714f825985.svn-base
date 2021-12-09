package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilr.FundingModel

/**
 *
 * JSON serializable DTO containing FundingModel data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class FundingModelDto implements Serializable {
    
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
    public FundingModelDto() {
    }
    
    /**
     * Constructor to create an FundingModelDto object from a FundingModel object
     *
     * @param fundingModel the FundingModel object to use for construction
     */
    FundingModelDto(FundingModel fundingModel) {
        if(fundingModel != null) {
            this.id = fundingModel.id;
            this.code = fundingModel.code;
            this.description = fundingModel.description;
            this.shortDescription = fundingModel.shortDescription;
            this.validFrom = fundingModel.validFrom;
            this.validTo = fundingModel.validTo;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a FundingModelDto from a FundingModel data object.
     *
     * @param fundingModel the FundingModel data object to use for the creation.
     * @return a FundingModelDto object based on the FundingModel data object supplied.
     */
    public static FundingModelDto mapFromEntity(FundingModel fundingModel) {
        return new FundingModelDto(fundingModel);
    }
    
    /**
     * This static method is used to create a List of FundingModelDto from a List of FundingModel data object.
     *
     * @param FundingModels the List of FundingModel data object to use for the creation.
     * @return a List of FundingModelDto object based on the List of FundingModel data object supplied.
     */
    public static List<FundingModelDto> mapFromList(List<FundingModel> fundingModels) {
        List<FundingModelDto> output = fundingModels.collect { fundingModel ->  new FundingModelDto(fundingModel) };
        return output
    }
}
