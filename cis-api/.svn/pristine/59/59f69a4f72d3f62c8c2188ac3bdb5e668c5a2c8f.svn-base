package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.VolunteeringType

/**
 *
 * JSON serializable DTO containing VolunteeringType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class VolunteeringTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public VolunteeringTypeDto() {
    }
    
    /**
     * Constructor to create a VolunteeringTypeDto object from a VolunteeringType object
     *
     * @param volunteeringType the VolunteeringType object to use for construction
     */
    VolunteeringTypeDto(VolunteeringType volunteeringType) {
        if(volunteeringType != null) {
            this.id = volunteeringType.id;
            this.code = volunteeringType.code;
            this.description = volunteeringType.description;
        }
    }
    
    /**
     * This static method is used to create a VolunteeringTypeDto from a VolunteeringType data object.
     *
     * @param volunteeringType the VolunteeringType data object to use for the creation.
     * @return a VolunteeringTypeDto object based on the VolunteeringType data object supplied.
     */
    public static VolunteeringTypeDto mapFromEntity(VolunteeringType volunteeringType) {
        return new VolunteeringTypeDto(volunteeringType);
    }
    
    /**
     * This static method is used to create a List of VolunteeringTypeDto from a List of VolunteeringType data object.
     *
     * @param volunteeringTypes the List of VolunteeringType data object to use for the creation.
     * @return a List of VolunteeringTypeDto object based on the List of VolunteeringType data object supplied.
     */
    public static List<VolunteeringTypeDto> mapFromList(List<VolunteeringType> volunteeringTypes) {
        return volunteeringTypes.collect { volunteeringType ->  new VolunteeringTypeDto(volunteeringType) };
    }
}
