package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.VolunteeringExperience

/**
 *
 * JSON serializable DTO containing VolunteeringExperience data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class VolunteeringExperienceDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public VolunteeringExperienceDto() {
    }
    
    /**
     * Constructor to create a VolunteeringExperienceDto object from a VolunteeringExperience object
     *
     * @param volunteeringExperience the VolunteeringExperience object to use for construction
     */
    VolunteeringExperienceDto(VolunteeringExperience volunteeringExperience) {
        if(volunteeringExperience != null) {
            this.id = volunteeringExperience.id;
            this.code = volunteeringExperience.code;
            this.description = volunteeringExperience.description;
        }
    }
    
    /**
     * This static method is used to create a VolunteeringExperienceDto from a VolunteeringExperience data object.
     *
     * @param volunteeringExperience the VolunteeringExperience data object to use for the creation.
     * @return a VolunteeringExperienceDto object based on the VolunteeringExperience data object supplied.
     */
    public static VolunteeringExperienceDto mapFromEntity(VolunteeringExperience volunteeringExperience) {
        return new VolunteeringExperienceDto(volunteeringExperience);
    }
    
    /**
     * This static method is used to create a List of VolunteeringExperienceDto from a List of VolunteeringExperience data object.
     *
     * @param volunteeringExperiences the List of VolunteeringExperience data object to use for the creation.
     * @return a List of VolunteeringExperienceDto object based on the List of VolunteeringExperience data object supplied.
     */
    public static List<VolunteeringExperienceDto> mapFromList(List<VolunteeringExperience> volunteeringExperiences) {
        return volunteeringExperiences.collect { volunteeringExperience ->  new VolunteeringExperienceDto(volunteeringExperience) };
    }
}
