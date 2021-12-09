package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.Gender

/**
 *
 * JSON serializable DTO containing Gender data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class GenderDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String sonDaughter;
    
    @JsonProperty
    private String heShe;
    
    @JsonProperty
    private String himHer;
    
    @JsonProperty
    private String hisHer;
    
    /**
     * Default No Args constructor
     */
    public GenderDto() {
    }
    
    /**
     * Constructor to create a GenderDto object from a Gender object
     *
     * @param gender the Gender object to use for construction
     */
    GenderDto(Gender gender) {
        if(gender != null) {
            this.id = gender.id;
            this.code = gender.code;
            this.description = gender.description;
            this.sonDaughter = gender.sonDaughter;
            this.heShe = gender.heShe;
            this.himHer = gender.himHer;
            this.hisHer = gender.hisHer;
        }
    }
    
    /**
     * This static method is used to create a GenderDto from a Gender data object.
     *
     * @param gender the Gender data object to use for the creation.
     * @return a GenderDto object based on the Gender data object supplied.
     */
    public static GenderDto mapFromEntity(Gender gender) {
        return new GenderDto(gender);
    }
    
    /**
     * This static method is used to create a GenderDto from a Gender data object.
     *
     * @param gender the Gender data object to use for the creation.
     * @return a GenderDto object based on the Gender data object supplied.
     */
    public static List<GenderDto> mapFromList(List<Gender> genders) {
        return genders.collect { gender ->  new GenderDto(gender) };
    }
}
