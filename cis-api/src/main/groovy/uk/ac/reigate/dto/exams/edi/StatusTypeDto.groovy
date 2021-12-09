package uk.ac.reigate.dto.exams.edi

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.exams.edi.StatusType

import groovy.transform.EqualsAndHashCode

/**
 *
 * JSON serializable DTO containing StatusType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StatusTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public StatusTypeDto() {
    }
    
    /**
     * Constructor to create a StatusTypeDto object
     *
     * @param id the Id for the StatusType
     * @param code the code for the StatusType
     * @param description the description for the StatusType
     */
    public StatusTypeDto(StatusType statusType) {
        this.id = statusType.id;
        this.code = statusType.code;
        this.description = statusType.description;
    }
    
    /**
     * This static method is used to create a StatusTypeDto from a StatusType data object.
     *
     * @param StatusType the StatusType data object to use for the creation.
     * @return a StatusTypeDto object based on the StatusType data object supplied.
     */
    public static StatusTypeDto mapFromEntity(StatusType statusType) {
        return new StatusTypeDto(statusType);
    }
    
    /**
     * This static method is used to create a List of StatusTypeDto from a List of StatusType data object.
     *
     * @param StatusTypes the List of StatusType data object to use for the creation.
     * @return a List of StatusTypeDto object based on the List of StatusType data object supplied.
     */
    public static List<StatusTypeDto> mapFromList(List<StatusType> statusTypes) {
        return statusTypes.collect { statusType ->  mapFromEntity(statusType) };
    }
}
