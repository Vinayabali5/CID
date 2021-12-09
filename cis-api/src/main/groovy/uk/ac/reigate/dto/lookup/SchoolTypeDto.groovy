package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.lookup.SchoolType

/**
 *
 * JSON serializable DTO containing SchoolType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SchoolTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public SchoolTypeDto() {
    }
    
    /**
     * Constructor to create a SchoolTypeDto object from a SchoolType object
     *
     * @param schoolType the SchoolType object to use for construction
     */
    SchoolTypeDto(SchoolType schoolType) {
        if(schoolType != null) {
            this.id = schoolType.id;
            this.code = schoolType.code;
            this.description = schoolType.description;
        }
    }
    
    /**
     * This static method is used to create a SchoolTypeDto from a SchoolType data object.
     *
     * @param schoolType the SchoolType data object to use for the creation.
     * @return a SchoolTypeDto object based on the SchoolType data object supplied.
     */
    public static SchoolTypeDto mapFromEntity(SchoolType schoolType) {
        return new SchoolTypeDto(schoolType);
    }
    
    /**
     * This static method is used to create a List of SchoolTypeDto from a List of SchoolType data object.
     *
     * @param schoolTypes the List of SchoolType data object to use for the creation.
     * @return a List of SchoolTypeDto object based on the List of SchoolType data object supplied.
     */
    public static List<SchoolTypeDto> mapFromList(List<SchoolType> schoolTypes) {
        return schoolTypes.collect { schoolType ->  new SchoolTypeDto(schoolType) };
    }
}
