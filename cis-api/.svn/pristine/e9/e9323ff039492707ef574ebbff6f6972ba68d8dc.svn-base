package uk.ac.reigate.dto.exams.edi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.exams.edi.EdiStatusType

import groovy.transform.EqualsAndHashCode;

/**
 *
 * JSON serializable DTO containing EdiStatusType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EdiStatusTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public EdiStatusTypeDto() {
    }
    
    /**
     * Constructor to create a EdiStatusTypeDto object
     *
     * @param id the Id for the EdiStatusType
     * @param code the code for the EdiStatusType
     * @param description the description for the EdiStatusType
     */
    public EdiStatusTypeDto(EdiStatusType ediStatusType) {
        this.id = ediStatusType.id;
        this.code = ediStatusType.code;
        this.description = ediStatusType.description;
    }
    
    /**
     * This static method is used to create a EdiStatusTypeDto from a EdiStatusType data object.
     *
     * @param ediStatusType the EdiStatusType data object to use for the creation.
     * @return a EdiStatusTypeDto object based on the EdiStatusType data object supplied.
     */
    public static EdiStatusTypeDto mapFromEntity(EdiStatusType ediStatusType) {
        return new EdiStatusTypeDto(ediStatusType);
    }
    
    /**
     * This static method is used to create a List of EdiStatusTypeDto from a List of EdiStatusType data object.
     *
     * @param ediStatusTypes the List of EdiStatusType data object to use for the creation.
     * @return a List of EdiStatusTypeDto object based on the List of EdiStatusType data object supplied.
     */
    public static List<EdiStatusTypeDto> mapFromList(List<EdiStatusType> ediStatusTypes) {
        return ediStatusTypes.collect { ediStatusType ->  mapFromEntity(ediStatusType) };
    }
}
