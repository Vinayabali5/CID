package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotNull

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.Destination

/**
 *
 * JSON serializable DTO containing Destination data
 *
 */
@ApiModel
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class DestinationDto implements Serializable {
    
    @ApiModelProperty(position = 1, required = false, value = "The ID of the Destination object stored in the database. This must be provided for any PUT operations but omitted for POST opertions.")
    @JsonProperty
    private Integer id;
    
    @ApiModelProperty(position = 2, required = true, value = "The code of the Destination object stored in the database")
    @NotNull
    @JsonProperty
    private String type;
    
    @ApiModelProperty(position = 3, required = true, value = "The code of the Destination object stored in the database")
    @NotNull
    @JsonProperty
    private String code;
    
    @ApiModelProperty(position = 4, required = true, value = "The description of the Destination object stored in the database")
    @NotNull
    @JsonProperty
    private String description;
    
    @ApiModelProperty(position = 5, required = true, value = "The short description of the Destination object stored in the database")
    @NotNull
    @JsonProperty
    private String shortDescription;
    
    @ApiModelProperty(position = 6, required = true, value = "The valid from date of the Destination object stored in the database", dataType = "string date")
    @JsonProperty
    private Date validFrom;
    
    @ApiModelProperty(position = 7, required = true, value = "The valid to date of the Destination object stored in the database")
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public DestinationDto() {
    }
    
    /**
     * Constructor to create a DestinationDto object
     *
     * @param destination the Destination object to use to create the DestinationDto
     */
    public DestinationDto(Destination destination) {
        if(destination != null) {
            this.id = destination.id;
            this.type = destination.type;
            this.code = destination.code;
            this.description = destination.description;
            this.shortDescription = destination.shortDescription;
            this.validFrom = destination.validFrom;
            this.validTo = destination.validTo;
        }
    }
    
    /**
     * This static method is used to create a DestinationDto from a Destination data object.
     *
     * @param destination the Destination data object to use for the creation.
     * @return a DestinationDto object based on the Destination data object supplied.
     */
    public static DestinationDto mapFromEntity(Destination destination){
        return new DestinationDto(destination);
    }
    
    /**
     * This static method is used to create a List of DestinationDto from a List of Destination data object.
     *
     * @param destinations the List of Destination data object to use for the creation.
     * @return a List of DestinationDto object based on the List of Destination data object supplied.
     */
    public static List<DestinationDto> mapFromList(List<Destination> destinations) {
        return destinations.collect { destination ->  new DestinationDto(destination) };
    }
}
