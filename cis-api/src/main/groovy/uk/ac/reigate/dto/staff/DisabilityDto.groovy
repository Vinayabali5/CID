package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.Disability


/**
 *
 * JSON serializable DTO containing Disability data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class DisabilityDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String disability;
    
    /**
     * Default No Args constructor
     */
    public DisabilityDto() {
    }
    
    /**
     * Constructor to create a DisabilityDto object from a Disability object
     *
     * @param disability the Disability object to use for construction
     */
    DisabilityDto(Disability disability) {
        if(disability != null) {
            this.id = disability.id;
            this.disability = disability.disability;
        }
    }
    
    /**
     * This static method is used to create a DisabilityDto from a Disability data object.
     *
     * @param disability the Disability data object to use for the creation.
     * @return a DisabilityDto object based on the Disability data object supplied.
     */
    public static DisabilityDto mapFromEntity(Disability disability) {
        return new DisabilityDto(disability);
    }
    
    /**
     * This static method is used to create a List of DisabilityDto from a List of Disability data object.
     *
     * @param disabilities the List of Disability data object to use for the creation.
     * @return a List of LetterDto object based on the List of Disability data object supplied.
     */
    public static List<DisabilityDto> mapFromList(List<Disability> disabilities) {
        return disabilities.collect { disability ->  new DisabilityDto(disability) };
    }
}
