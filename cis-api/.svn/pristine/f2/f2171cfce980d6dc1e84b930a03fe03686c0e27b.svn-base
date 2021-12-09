package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.Ethnicity

/**
 *
 * JSON serializable DTO containing Ethnicity data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EthnicityDto implements Serializable {
    
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
    public EthnicityDto() {
    }
    
    /**
     * Constructor to create an EthnicityDto object from a Ethnicity object
     *
     * @param ethnicity the Ethnicity object to use for construction
     */
    EthnicityDto(Ethnicity ethnicity) {
        if(ethnicity != null) {
            this.id = ethnicity.id;
            this.code = ethnicity.code;
            this.description = ethnicity.description;
            this.shortDescription = ethnicity.shortDescription;
            this.validFrom = ethnicity.validFrom;
            this.validTo = ethnicity.validTo;
        }
    }
    
    /**
     * This static method is used to create a EthnicityDto from a Ethnicity data object.
     *
     * @param ethnicity the Ethnicity data object to use for the creation.
     * @return a EthnicityDto object based on the Ethnicity data object supplied.
     */
    public static EthnicityDto mapFromEntity(Ethnicity ethnicity) {
        return new EthnicityDto(ethnicity);
    }
    
    /**
     * This static method is used to create a List of EthnicityDto from a List of Ethnicity data object.
     *
     * @param ethnicities the List of Ethnicity data object to use for the creation.
     * @return a List of EthnicityDto object based on the List of Ethnicity data object supplied.
     */
    public static List<EthnicityDto> mapFromList(List<Ethnicity> ethnicities) {
        return ethnicities.collect { ethnicity ->  new EthnicityDto(ethnicity) };
    }
}
