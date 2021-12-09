package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilr.SourceOfFunding

/**
 *
 * JSON serializable DTO containing SourceOfFunding data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SourceOfFundingDto implements Serializable {
    
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
    public SourceOfFundingDto() {
    }
    
    /**
     * Constructor to create a SourceOfFundingDto object from a SourceOfFunding object
     *
     * @param sourceOfFunding the SourceOfFunding object to use for construction
     */
    SourceOfFundingDto(SourceOfFunding sourceOfFunding) {
        if(sourceOfFunding != null) {
            this.id = sourceOfFunding.id;
            this.code = sourceOfFunding.code;
            this.description = sourceOfFunding.description;
            this.shortDescription = sourceOfFunding.shortDescription;
            this.validFrom = sourceOfFunding.validFrom;
            this.validTo = sourceOfFunding.validTo;
        }
    }
    
    /**
     * This static method is used to create a SourceOfFundingDto from a SourceOfFunding data object.
     *
     * @param sourceOfFunding the SourceOfFunding data object to use for the creation.
     * @return a SourceOfFundingDto object based on the SourceOfFunding data object supplied.
     */
    public static SourceOfFundingDto mapFromEntity(SourceOfFunding sourceOfFunding) {
        return new SourceOfFundingDto(sourceOfFunding);
    }
    
    /**
     * This static method is used to create a List of SourceOfFundingDto from a List of SourceOfFunding data object.
     *
     * @param sourceOfFundings the List of SourceOfFunding data object to use for the creation.
     * @return a List of SourceOfFundingDto object based on the List of SourceOfFunding data object supplied.
     */
    public static List<SourceOfFundingDto> mapFromList(List<SourceOfFunding> sourceOfFundings) {
        return sourceOfFundings.collect { sourceOfFunding ->  new SourceOfFundingDto(sourceOfFunding) };
    }
}
