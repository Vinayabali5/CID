package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.ilp.CorrespondenceType

/**
 *
 * JSON  DTO containing CorrespondenceType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CorrespondenceTypeDto  {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String type;
    
    /**
     * Default No Args constructor
     */
    public CorrespondenceTypeDto() {
    }
    
    /**
     * Constructor to create a CorrespondenceTypeDto object from a CorrespondenceType object
     *
     * @param correspondenceType the CorrespondenceType object to use for construction
     */
    CorrespondenceTypeDto(CorrespondenceType correspondenceType) {
        if(correspondenceType != null) {
            this.id = correspondenceType.id;
            this.type = correspondenceType.type;
        }
    }
    
    /**
     * This static method is used to create a CorrespondenceTypeDto from a Contact data object.
     *
     * @param correspondenceType the CorrespondenceType data object to use for the creation.
     * @return a CorrespondenceTypeDto object based on the CorrespondenceType data object supplied.
     */
    public static CorrespondenceTypeDto mapFromEntity(CorrespondenceType correspondenceType) {
        return new CorrespondenceTypeDto(correspondenceType);
    }
    
    /**
     * This static method is used to create a List of CorrespondenceTypeDto from a List of CorrespondenceType data object.
     *
     * @param correspondenceTypes the List of CorrespondenceType data object to use for the creation.
     * @return a List of CorrespondenceTypeDto object based on the List of CorrespondenceType data object supplied.
     */
    public static List<CorrespondenceTypeDto> mapFromList(List<CorrespondenceType> correspondenceTypes) {
        return correspondenceTypes.collect { correspondenceType ->  new CorrespondenceTypeDto(correspondenceType) };
    }
}