package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.SchoolPriority

/**
 *
 * JSON serializable DTO containing SchoolPriority data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SchoolPriorityDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public SchoolPriorityDto() {
    }
    
    /**
     * Constructor to create a SchoolPriorityDto object from a SchoolPriority object
     *
     * @param schoolPriority the SchoolPriority object to use for construction
     */
    SchoolPriorityDto(SchoolPriority schoolPriority) {
        if(schoolPriority != null) {
            this.id = schoolPriority.id;
            this.code = schoolPriority.code;
            this.description = schoolPriority.description;
        }
    }
    
    /**
     * This static method is used to create a SchoolPriorityDto from a SchoolPriority data object.
     *
     * @param schoolPriority the SchoolPriority data object to use for the creation.
     * @return a SchoolPriorityDto object based on the SchoolPriority data object supplied.
     */
    public static SchoolPriorityDto mapFromEntity(SchoolPriority schoolPriority) {
        return new SchoolPriorityDto(schoolPriority);
    }
    
    /**
     * This static method is used to create a List of SchoolPriorityDto from a List of SchoolPriority data object.
     *
     * @param schoolPriorities the List of SchoolPriority data object to use for the creation.
     * @return a List of SchoolPriorityDto object based on the List of SchoolPriority data object supplied.
     */
    public static List<SchoolPriorityDto> mapFromList(List<SchoolPriority> schoolPriorities) {
        return schoolPriorities.collect { schoolPriority ->  new SchoolPriorityDto(schoolPriority) };
    }
}
