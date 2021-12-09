package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.Outcome

/**
 *
 * JSON serializable DTO containing Outcome data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class OutcomeDto implements Serializable {
    
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
    public OutcomeDto() {
    }
    
    /**
     * Constructor to create an OutcomeDto object from a Outcome object
     *
     * @param outcome the Outcome object to use for construction
     */
    OutcomeDto(Outcome outcome) {
        if(outcome != null) {
            this.id = outcome.id;
            this.code = outcome.code;
            this.description = outcome.description;
            this.shortDescription = outcome.shortDescription;
            this.validFrom = outcome.validFrom;
            this.validTo = outcome.validTo;
        }
    }
    
    /**
     * This static method is used to create a OutcomeDto from a Outcome data object.
     *
     * @param outcome the Outcome data object to use for the creation.
     * @return a OutcomeDto object based on the Outcome data object supplied.
     */
    public static OutcomeDto mapFromEntity(Outcome outcome) {
        return new OutcomeDto(outcome);
    }
    
    /**
     * This static method is used to create a List of OutcomeDto from a List of Outcome data object.
     *
     * @param outcomes the List of Outcome data object to use for the creation.
     * @return a List of OutcomeDto object based on the List of Outcome data object supplied.
     */
    public static List<OutcomeDto> mapFromList(List<Outcome> outcomes) {
        return outcomes.collect { outcome ->  new OutcomeDto(outcome) };
    }
}
