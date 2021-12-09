package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.learning_support.ConcessionType

/**
 *
 * JSON serializable DTO containing ConcessionType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ConcessionTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Boolean inUse;
    
    @JsonProperty
    private Boolean onExamTimetable
    
    /**
     * Default No Args constructor
     */
    public ConcessionTypeDto() {
    }
    
    /**
     * Constructor to create a ConcessionTypeDto object from a ConcessionType object
     * 
     * @param concessionType the ConcessionType object to use for construction
     */
    ConcessionTypeDto(ConcessionType concessionType) {
        if(concessionType != null) {
            this.id = concessionType.id;
            this.code = concessionType.code;
            this.description = concessionType.description;
            this.inUse = concessionType.inUse;
            this.onExamTimetable = concessionType.onExamTimetable;
        }
    }
    
    /**
     * This static method is used to create a ConcessionTypeDto from a ConcessionType data object.
     *
     * @param concessionType the ConcessionType data object to use for the creation.
     * @return a ConcessionTypeDto object based on the ConcessionType1 data object supplied.
     */
    public static ConcessionTypeDto mapFromEntity(ConcessionType concessionType){
        return new ConcessionTypeDto(concessionType)
    }
    
    /**
     * This static method is used to create a List of ConcessionTypeDto from a List of ConcessionType data object.
     *
     * @param concessionTypes the List of ConcessionType data object to use for the creation.
     * @return a List of ConcessionTypeDto object based on the List of ConcessionType data object supplied.
     */
    public static List<ConcessionTypeDto> mapFromList(List<ConcessionType> concessionTypes) {
        return concessionTypes.collect { concessionType ->  new ConcessionTypeDto(concessionType) };
    }
}
