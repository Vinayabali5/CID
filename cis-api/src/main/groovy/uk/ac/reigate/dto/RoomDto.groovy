package uk.ac.reigate.dto


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.Room
import uk.ac.reigate.dto.lookup.RoomTypeDto

/**
 *
 * JSON serializable DTO containing Room data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields = true)
public class RoomDto implements Serializable {
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private String code
    
    @JsonProperty
    private String description
    
    @JsonProperty
    private Integer roomTypeId
    
    @JsonProperty
    private RoomTypeDto roomType
    
    @JsonProperty
    private Integer capacity
    
    @JsonProperty
    private String codeNLZ
    
    @JsonProperty
    private String newCode
    
    @JsonProperty
    private Integer defaultRows
    
    @JsonProperty
    private Integer defaultCols
    
    
    /**
     * Default No Args constructor
     */
    public RoomDto() {
    }
    
    /**
     * Constructor to create a RoomDto object from a Room object
     *
     * @param room the Room object to use for construction
     */
    RoomDto(Room room) {
        if (room != null) {
            this.id = room.id
            this.code = room.code
            this.description = room.description
            this.roomTypeId = room.roomType != null ? room.roomType.id : null
            this.roomType = room.roomType != null ? RoomTypeDto.mapFromEntity(room.roomType) : null
            this.capacity = room.capacity
            this.defaultRows = room.defaultRows
            this.defaultCols = room.defaultCols
            this.codeNLZ = room.codeNLZ
            this.newCode = room.newCode
        }
    }
    
    /**
     * This static method is used to create a RoomDto from a Room data object.
     *
     * @param room the Room data object to use for the creation.
     * @return a RoomDto object based on the Room data object supplied.
     */
    public static RoomDto mapFromEntity(Room room) {
        return new RoomDto(room)
    }
    
    /**
     * This static method is used to create a List of RoomDto from a List of Room data object.
     *
     * @param rooms the List of Room data object to use for the creation.
     * @return a List of RoomDto object based on the List of Room data object supplied.
     */
    public static List<RoomDto> mapFromList(List<Room> rooms) {
        return rooms.collect { room ->  new RoomDto(room) }
    }
    
    /**
     * This method is used to return the RoomType description for the Room object
     *
     * @return the RoomType description for the Room object
     */
    @JsonProperty(value = "_roomTypeDescription")
    public String get_RoomTypeDescription() {
        return this.roomType != null ? this.roomType.description : null
    }
}
