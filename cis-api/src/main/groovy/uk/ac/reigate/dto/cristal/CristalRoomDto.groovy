package uk.ac.reigate.dto.cristal;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.cristal.CristalRoom


/**
 *
 * JSON serializable DTO containing CristalRoom data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CristalRoomDto implements Serializable {
    
    @JsonProperty
    Integer roomId;
    
    @JsonProperty
    String roomName
    
    @JsonProperty
    String computerName
    
    @JsonProperty
    boolean mayPrint
    
    @JsonProperty
    boolean autoStart
    
    @JsonProperty
    boolean securityCodeNotRequired
    
    @JsonProperty
    boolean confirmRoomChange
    
    @JsonProperty
    boolean confirmStaffChange
    
    @JsonProperty
    boolean confirmTimeChange
    
    @JsonProperty
    boolean tutorOffice
    
    /**
     * Default No Args constructor
     */
    public CristalRoomDto() {
    }
    
    /**
     * Constructor to create a CristalRoomDto object from a CristalRoom object
     *
     * @param cristalRoom the CristalRoom object to use for construction
     */
    CristalRoomDto(CristalRoom cristalRoom) {
        this.roomId = cristalRoom.roomId;
        this.roomName = cristalRoom.roomName;
        this.computerName = cristalRoom.computerName;
        this.mayPrint = cristalRoom.mayPrint
        this.autoStart = cristalRoom.autoStart
        this.securityCodeNotRequired = cristalRoom.securityCodeNotRequired
        this.confirmRoomChange = cristalRoom.confirmRoomChange
        this.confirmStaffChange = cristalRoom.confirmStaffChange
        this.confirmTimeChange = cristalRoom.confirmTimeChange
        this.tutorOffice = cristalRoom.tutorOffice;
    }
    
    /**
     * This static method is used to create a CristalRoomDto from a CristalRoom data object.
     *
     * @param cristalRoom the CristalRoom data object to use for the creation.
     * @return a CristalRoomDto object based on the CristalRoom data object supplied.
     */
    public static CristalRoomDto mapFromEntity(CristalRoom cristalRoom) {
        return new CristalRoomDto(cristalRoom)
    }
    
    /**
     * This static method is used to create a List of CristalRoomDto from a List of CristalRoom data object.
     *
     * @param cristalRooms the List of CristalRoom data object to use for the creation.
     * @return a List of CristalRoomDto object based on the List of CristalRoom data object supplied.
     */
    public static List<CristalRoomDto> mapFromList(List<CristalRoom> cristalRooms) {
        return cristalRooms.collect { cristalRoom ->  new CristalRoomDto(cristalRoom) };
    }
}