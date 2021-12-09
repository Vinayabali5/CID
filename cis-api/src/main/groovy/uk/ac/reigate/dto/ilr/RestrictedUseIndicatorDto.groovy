package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.RestrictedUseIndicator

/**
 *
 * JSON serializable DTO containing RestrictedUseIndicator data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RestrictedUseIndicatorDto implements Serializable {
    
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
    public RestrictedUseIndicatorDto() {
    }
    
    /**
     * Constructor to create a RestrictedUseIndicatorDto object from a RestrictedUseIndicator object
     *
     * @param restrictedUseIndicator the RestrictedUseIndicator object to use for construction
     */
    RestrictedUseIndicatorDto(RestrictedUseIndicator restrictedUseIndicator) {
        if(restrictedUseIndicator != null) {
            this.id = restrictedUseIndicator.id;
            this.code = restrictedUseIndicator.code;
            this.description = restrictedUseIndicator.description;
            this.shortDescription = restrictedUseIndicator.shortDescription;
            this.validFrom = restrictedUseIndicator.validFrom;
            this.validTo = restrictedUseIndicator.validTo;
        }
    }
    
    /**
     * This static method is used to create a RestrictedUseIndicatorDto from a RestrictedUseIndicator data object.
     *
     * @param restrictedUseIndicator the RestrictedUseIndicator data object to use for the creation.
     * @return a RestrictedUseIndicatorDto object based on the RestrictedUseIndicator data object supplied.
     */
    public static RestrictedUseIndicatorDto mapFromEntity(RestrictedUseIndicator restrictedUseIndicator) {
        return new RestrictedUseIndicatorDto(restrictedUseIndicator);
    }
    
    /**
     * This static method is used to create a List of RestrictedUseIndicatorDto from a List of RestrictedUseIndicator data object.
     *
     * @param restrictedUseIndicators the List of RestrictedUseIndicator data object to use for the creation.
     * @return a List of RestrictedUseIndicatorDto object based on the List of RestrictedUseIndicator data object supplied.
     */
    public static List<RestrictedUseIndicatorDto> mapFromList(List<RestrictedUseIndicator> restrictedUseIndicators) {
        return restrictedUseIndicators.collect { restrictedUseIndicator ->  new RestrictedUseIndicatorDto(restrictedUseIndicator) };
    }
}