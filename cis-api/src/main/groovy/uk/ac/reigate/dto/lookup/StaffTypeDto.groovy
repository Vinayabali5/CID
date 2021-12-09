package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.StaffType

/**
 *
 * JSON serializable DTO containing StaffType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StaffTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Boolean needInitials
    
    /**
     * Default No Args constructor
     */
    public StaffTypeDto() {
    }
    
    /**
     * Constructor to create a StaffTypeDto object from a StaffType object
     *
     * @param staffType the StaffType object to use for construction
     */
    StaffTypeDto(StaffType staffType) {
        if(staffType != null) {
            this.id = staffType.id;
            this.code = staffType.code;
            this.description = staffType.description;
            this.needInitials = staffType.needInitials;
        }
    }
    
    /**
     * This static method is used to create a StaffTypeDto from a StaffType data object.
     *
     * @param staffType the StaffType data object to use for the creation.
     * @return a StaffTypeDto object based on the StaffType data object supplied.
     */
    public static StaffTypeDto mapFromEntity(StaffType staffType) {
        return new StaffTypeDto(staffType);
    }
    
    /**
     * This static method is used to create a List of StaffTypeDto from a List of StaffType data object.
     *
     * @param staffTypes the List of StaffType data object to use for the creation.
     * @return a List of StaffTypeDto object based on the List of StaffType data object supplied.
     */
    public static List<StaffTypeDto> mapFromList(List<StaffType> staffTypes) {
        return staffTypes.collect { staffType ->  new StaffTypeDto(staffType) };
    }
}
