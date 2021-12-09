package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.PriorAttainment

/**
 *
 * JSON serializable DTO containing PriorAttainment data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PriorAttainmentDto implements Serializable {
    
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
    public PriorAttainmentDto() {
    }
    
    /**
     * Constructor to create a PriorAttainmentDto object from a PriorAttainment object
     *
     * @param priorAttainment the PriorAttainment object to use for construction
     */
    PriorAttainmentDto(PriorAttainment priorAttainment) {
        if(priorAttainment != null) {
            this.id = priorAttainment.id;
            this.code = priorAttainment.code;
            this.description = priorAttainment.description;
            this.shortDescription = priorAttainment.shortDescription;
            this.validFrom = priorAttainment.validFrom;
            this.validTo = priorAttainment.validTo;
        }
    }
    
    /**
     * This static method is used to create a PriorAttainmentDto from a PriorAttainment data object.
     *
     * @param priorAttainment the PriorAttainment data object to use for the creation.
     * @return a PriorAttainmentDto object based on the PriorAttainment data object supplied.
     */
    public static PriorAttainmentDto mapFromEntity(PriorAttainment priorAttainment) {
        return new PriorAttainmentDto(priorAttainment);
    }
    
    /**
     * This static method is used to create a List of PriorAttainmentDto from a List of PriorAttainment data object.
     *
     * @param priorAttainments the List of PriorAttainment data object to use for the creation.
     * @return a List of PriorAttainmentDto object based on the List of PriorAttainment data object supplied.
     */
    public static List<PriorAttainmentDto> mapFromList(List<PriorAttainment> priorAttainments) {
        return priorAttainments.collect { priorAttainment ->  new PriorAttainmentDto(priorAttainment) };
    }
}