package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.SexualOrientation


/**
 *
 * JSON serializable DTO containing SexualOrientation data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SexualOrientationDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String sexualOrientation;
    
    /**
     * Default No Args constructor
     */
    public SexualOrientationDto() {
    }
    
    /**
     * Constructor to create a SexualOrientationDto object from a SexualOrientation object
     *
     * @param sexualOrientation the SexualOrientation object to use for construction
     */
    SexualOrientationDto(SexualOrientation sexualOrientation) {
        if(sexualOrientation != null) {
            this.id = sexualOrientation.id;
            this.sexualOrientation = sexualOrientation.sexualOrientation;
        }
    }
    
    /**
     * This static method is used to create a SexualOrientationDto from a SexualOrientation data object.
     *
     * @param sexualOrientation the SexualOrientation data object to use for the creation.
     * @return a SexualOrientationDto object based on the SexualOrientation data object supplied.
     */
    public static SexualOrientationDto mapFromEntity(SexualOrientation sexualOrientation) {
        return new SexualOrientationDto(sexualOrientation);
    }
    
    /**
     * This static method is used to create a List of SexualOrientationDto from a List of SexualOrientation data object.
     *
     * @param disabilities the List of SexualOrientation data object to use for the creation.
     * @return a List of LetterDto object based on the List of SexualOrientation data object supplied.
     */
    public static List<SexualOrientationDto> mapFromList(List<SexualOrientation> disabilities) {
        return disabilities.collect { sexualOrientation ->  new SexualOrientationDto(sexualOrientation) };
    }
}
