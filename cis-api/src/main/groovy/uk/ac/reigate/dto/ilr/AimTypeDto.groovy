package uk.ac.reigate.dto.ilr;


import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.AimType

/**
 *
 * JSON serializable DTO containing AimType data
 *
 */
//@ApiModel
@JsonSerialize
@EqualsAndHashCode(includeFields = true)
public class AimTypeDto implements Serializable {
    
    //@ApiModelProperty(position = 1, required = false, value = "The ID of the AimType object stored in the database. This must be provided for any PUT operations but omitted for POST opertions.")
    @JsonProperty
    private Integer id;
    
    //@ApiModelProperty(position = 2, required = true, value = "The code of the AimType object stored in the database")
    @NotNull
    @JsonProperty
    private String code;
    
    //@ApiModelProperty(position = 3, required = true, value = "The description of the AimType object stored in the database")
    @NotNull
    @JsonProperty
    private String description;
    
    //@ApiModelProperty(position = 4, required = true, value = "The short description of the AimType object stored in the database")
    @NotNull
    @JsonProperty
    private String shortDescription;
    
    //@ApiModelProperty(position = 5, required = true, value = "The valid from date of the AimType object stored in the database", dataType = "string date")
    @JsonProperty
    private Date validFrom;
    
    //@ApiModelProperty(position = 6, required = true, value = "The valid to date of the AimType object stored in the database")
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public AimTypeDto() {
    }
    
    /**
     * Constructor to create an AimTypeDto object from an AimType object
     *
     * @param aimType the AimType object to use for construction
     */
    public AimTypeDto(AimType aimType) {
        if(aimType != null) {
            this.id = aimType.id;
            this.code = aimType.code;
            this.description = aimType.description;
            this.shortDescription = aimType.shortDescription;
            this.validFrom = aimType.validFrom;
            this.validTo = aimType.validTo;
        }
    }
    
    /**
     * This static method is used to create a AimTypeDto from a AimType data object.
     *
     * @param aimType the AimType data object to use for the creation.
     * @return a AimTypeDto object based on the AimType data object supplied.
     */
    public static AimTypeDto mapFromEntity(AimType aimType) {
        return new AimTypeDto(aimType);
    }
    
    /**
     * This static method is used to create a List of AimTypeDto from a List of AimType data object.
     *
     * @param aimTypes the List of AimType data object to use for the creation.
     * @return a List of AimTypeDto object based on the List of AimType data object supplied.
     */
    public static List<AimTypeDto> mapFromList(List<AimType> aimTypes) {
        return aimTypes.collect { aimType ->  new AimTypeDto(aimType) };
    }
}
