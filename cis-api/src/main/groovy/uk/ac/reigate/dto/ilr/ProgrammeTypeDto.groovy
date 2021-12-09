package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.ProgrammeType

/**
 *
 * JSON serializable DTO containing ProgrammeType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ProgrammeTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String shortDescription;
    
    @JsonProperty
    private Date validFrom;
    
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public ProgrammeTypeDto() {
    }
    
    /**
     * Constructor to create a ProgrammeTypeDto object from a ProgrammeType object
     *
     * @param programmeType the ProgrammeType object to use for construction
     */
    ProgrammeTypeDto(ProgrammeType programmeType) {
        if(programmeType != null) {
            this.id = programmeType.id;
            this.code = programmeType.code;
            this.description = programmeType.description;
            this.shortDescription = programmeType.shortDescription;
            this.validFrom = programmeType.validFrom;
            this.validTo = programmeType.validTo;
        }
    }
    
    /**
     * This static method is used to create a ProgrammeTypeDto from a ProgrammeType data object.
     *
     * @param programmeType the ProgrammeType data object to use for the creation.
     * @return a ProgrammeTypeDto object based on the ProgrammeType data object supplied.
     */
    public static ProgrammeTypeDto mapFromEntity(ProgrammeType programmeType) {
        return new ProgrammeTypeDto(programmeType);
    }
    
    /**
     * This static method is used to create a List of ProgrammeTypeDto from a List of ProgrammeType data object.
     *
     * @param programmeTypes the List of ProgrammeType data object to use for the creation.
     * @return a List of ProgrammeTypeDto object based on the List of ProgrammeType data object supplied.
     */
    public static List<ProgrammeTypeDto> mapFromList(List<ProgrammeType> programmeTypes) {
        return programmeTypes.collect { programmeType ->  new ProgrammeTypeDto(programmeType) };
    }
}
