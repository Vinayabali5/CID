package uk.ac.reigate.dto.careers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.CareersRecordType

/**
 *
 * JSON serializable DTO containing CareersRecordType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CareersRecordTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public CareersRecordTypeDto() {
    }
    
    /**
     * Constructor to create a CareersRecordTypeDto object from a CareersRecordType object
     *
     * @param careersRecordType the CareersRecordType object to use for construction
     */
    CareersRecordTypeDto(CareersRecordType careersRecordType) {
        if(careersRecordType != null) {
            this.id = careersRecordType.id;
            this.code = careersRecordType.code;
            this.description = careersRecordType.description;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a CareersRecordTypeDto from a CareersRecordType data object.
     *
     * @param careersRecordType the CareersRecordType data object to use for the creation.
     * @return a CareersRecordTypeDto object based on the CareersRecordType data object supplied.
     */
    public static CareersRecordTypeDto mapFromEntity(CareersRecordType careersRecordType) {
        return new CareersRecordTypeDto(careersRecordType);
    }
    
    /**
     * This static method is used to create a List of CareersRecordTypeDto from a List of CareersRecordType data object.
     *
     * @param careersRecordTypes the List of CareersRecordType data object to use for the creation.
     * @return a List of CareersRecordTypeDto object based on the List of CareersRecordType data object supplied.
     */
    public static List<CareersRecordTypeDto> mapFromList(List<CareersRecordType> careersRecordTypes) {
        return careersRecordTypes.collect { careersRecordType ->  new CareersRecordTypeDto(careersRecordType) };
    }
}
