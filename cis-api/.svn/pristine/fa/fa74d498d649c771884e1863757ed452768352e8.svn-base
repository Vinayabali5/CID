package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.Religion


/**
 *
 * JSON serializable DTO containing Religion data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ReligionDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String religion;
    
    /**
     * Default No Args constructor
     */
    public ReligionDto() {
    }
    
    /**
     * Constructor to create a ReligionDto object from a Religion object
     *
     * @param religion the Religion object to use for construction
     */
    ReligionDto(Religion religion) {
        if(religion != null) {
            this.id = religion.id;
            this.religion = religion.religion;
        }
    }
    
    /**
     * This static method is used to create a ReligionDto from a Religion data object.
     *
     * @param religion the Religion data object to use for the creation.
     * @return a ReligionDto object based on the Religion data object supplied.
     */
    public static ReligionDto mapFromEntity(Religion religion) {
        return new ReligionDto(religion);
    }
    
    /**
     * This static method is used to create a List of ReligionDto from a List of Religion data object.
     *
     * @param religions the List of Religion data object to use for the creation.
     * @return a List of LetterDto object based on the List of Religion data object supplied.
     */
    public static List<ReligionDto> mapFromList(List<Religion> religions) {
        return religions.collect { religion ->  new ReligionDto(religion) };
    }
}
