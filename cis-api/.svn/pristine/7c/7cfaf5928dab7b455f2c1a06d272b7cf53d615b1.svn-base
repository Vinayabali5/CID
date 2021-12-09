package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.BursaryType

/**
 *
 * JSON serializable DTO containing BursaryType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class BursaryTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public BursaryTypeDto() {
    }
    
    /**
     * Constructor to create a BursaryTypeDto object from a BursaryType object
     *
     * @param bursaryType the BursaryType object to use for construction
     */
    BursaryTypeDto(BursaryType bursaryType) {
        if(bursaryType != null) {
            this.id = bursaryType.id;
            this.code = bursaryType.code;
            this.description = bursaryType.description;
        }
    }
    
    /**
     * This static method is used to create a BursaryTypeDto from a BursaryType data object.
     *
     * @param bursaryType the BursaryType data object to use for the creation.
     * @return a BursaryTypeDto object based on the BursaryType data object supplied.
     */
    public static BursaryTypeDto mapFromEntity(BursaryType bursaryType) {
        return new BursaryTypeDto(bursaryType);
    }
    
    /**
     * This static method is used to create a List of BursaryTypeDto from a List of BursaryType data object.
     *
     * @param bursaryTypes the List of BursaryType data object to use for the creation.
     * @return a List of BursaryTypeDto object based on the List of BursaryType data object supplied.
     */
    public static List<BursaryTypeDto> mapFromList(List<BursaryType> bursaryTypes) {
        return bursaryTypes.collect { bursaryType ->  new BursaryTypeDto(bursaryType) };
    }
}
