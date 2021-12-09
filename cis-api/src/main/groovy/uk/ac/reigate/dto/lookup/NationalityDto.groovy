package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.Nationality

/**
 *
 * JSON serializable DTO containing Nationality data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class NationalityDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public NationalityDto() {
    }
    
    /**
     * Constructor to create a NationalityDto object from a Nationality object
     *
     * @param nationality the Nationality object to use for construction
     */
    NationalityDto(Nationality nationality) {
        if(nationality != null) {
            this.id = nationality.id;
            this.name = nationality.name;
            this.description = nationality.description;
        }
    }
    
    /**
     * This static method is used to create a NationalityDto from a Nationality data object.
     *
     * @param nationality the Nationality data object to use for the creation.
     * @return a NationalityDto object based on the Nationality data object supplied.
     */
    public static NationalityDto mapFromEntity(Nationality nationality) {
        return new NationalityDto(nationality);
    }
    
    /**
     * This static method is used to create a List of NationalityDto from a List of Nationality data object.
     *
     * @param nationalities the List of Nationality data object to use for the creation.
     * @return a List of LetterDto object based on the List of Nationality data object supplied.
     */
    public static List<NationalityDto> mapFromList(List<Nationality> nationalities) {
        return nationalities.collect { nationality ->  new NationalityDto(nationality) };
    }
}
