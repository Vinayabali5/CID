package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.MaritalStatus


/**
 *
 * JSON serializable DTO containing MaritalStatus data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class MaritalStatusDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String maritalStatus;
    
    /**
     * Default No Args constructor
     */
    public MaritalStatusDto() {
    }
    
    /**
     * Constructor to create a MaritalStatusDto object from a MaritalStatus object
     *
     * @param maritalStatus the MaritalStatus object to use for construction
     */
    MaritalStatusDto(MaritalStatus maritalStatus) {
        if(maritalStatus != null) {
            this.id = maritalStatus.id;
            this.maritalStatus = maritalStatus.maritalStatus;
        }
    }
    
    /**
     * This static method is used to create a MaritalStatusDto from a MaritalStatus data object.
     *
     * @param maritalStatus the MaritalStatus data object to use for the creation.
     * @return a MaritalStatusDto object based on the MaritalStatus data object supplied.
     */
    public static MaritalStatusDto mapFromEntity(MaritalStatus maritalStatus) {
        return new MaritalStatusDto(maritalStatus);
    }
    
    /**
     * This static method is used to create a List of MaritalStatusDto from a List of MaritalStatus data object.
     *
     * @param maritalStatuses the List of MaritalStatus data object to use for the creation.
     * @return a List of LetterDto object based on the List of MaritalStatus data object supplied.
     */
    public static List<MaritalStatusDto> mapFromList(List<MaritalStatus> maritalStatuses) {
        return maritalStatuses.collect { maritalStatus ->  new MaritalStatusDto(maritalStatus) };
    }
}
