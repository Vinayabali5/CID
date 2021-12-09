package uk.ac.reigate.dto.lookup

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.RoomType
/**
 *
 * JSON serializable DTO containing RoomType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RoomTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Boolean timetableable
    
    /**
     * Default No Args constructor
     */
    public RoomTypeDto() {
    }
    
    /**
     * Constructor to create a RoomTypeDto object from a RoomType object
     *
     * @param roomType the RoomType object to use for construction
     */
    RoomTypeDto(RoomType roomType) {
        if(roomType != null) {
            this.id = roomType.id;
            this.code = roomType.code;
            this.description = roomType.description;
            this.timetableable = roomType.timetableable;
        }
    }
    
    /**
     * This static method is used to create a RoomTypeDto from a RoomType data object.
     *
     * @param roomType the RoomType data object to use for the creation.
     * @return a RoomTypeDto object based on the RoomType data object supplied.
     */
    public static RoomTypeDto mapFromEntity(RoomType roomType) {
        return new RoomTypeDto(roomType);
    }
    
    /**
     * This static method is used to create a List of RoomTypeDto from a List of RoomType data object.
     *
     * @param roomTypes the List of RoomType data object to use for the creation.
     * @return a List of RoomTypeDto object based on the List of RoomType data object supplied.
     */
    public static List<RoomTypeDto> mapFromList(List<RoomType> roomTypes) {
        List<RoomTypeDto> output = roomTypes.collect { roomType ->  new RoomTypeDto(roomType) };
        return output
    }
}
