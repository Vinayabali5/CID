package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.RoomType
import uk.ac.reigate.dto.RoomDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.RoomRepository
import uk.ac.reigate.services.lookup.RoomTypeService

@Service
class RoomService implements ICoreDataService<Room, Integer>, IDtoCreateUpdateService<RoomDto, Room>{
    
    @Autowired
    RoomRepository roomRepository
    
    @Autowired
    RoomTypeService roomTypeService
    
    /**
     * Default NoArgs constructor
     */
    RoomService() {}
    
    /**
     * Autowired Constructor
     *
     * @param roomRepository
     */
    RoomService(RoomRepository roomRepository, RoomTypeService roomTypeService) {
        this.roomRepository = roomRepository;
        this.roomTypeService = roomTypeService;
    }
    
    /**
     * Find an individual Room using the Room ID fields
     *
     * @param id the ID fields to search for
     * @return the Room object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Room findById(Integer id) {
        return roomRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of Room objects
     * @return a List of Rooms
     */
    @Override
    @Transactional(readOnly = true)
    List<Room> findAll() {
        return roomRepository.findAll();
    }
    
    /**
     *  Function call without defaultRows and defaultCols retained for backwards compatibility
     * @param id
     * @param code
     * @param description
     * @param roomType
     * @param capacity
     * @return
     */
    
    @Transactional
    public Room saveRoom(Integer id, String code, String description, RoomType roomType, Integer capacity) {
        return saveRoom(id, code, description, roomType, capacity, null, null);
    }
    
    /**
     * This service method is used to save a complete Room object in the database
     *
     * @param room the new Room object to be saved
     * @return the saved version of the Room object
     */
    @Override
    @Transactional
    public Room save(Room room) {
        return roomRepository.save(room)
    }
    
    /**
     * This service method is used to update an Room object in the database from a partial or complete Room object.
     *
     * @param room the partial or complete Room object to be saved
     * @return the saved version of the Room object
     */
    
    @Transactional
    public Room createFromDto(RoomDto room) {
        if (room == null) {
            throw new InvalidDataException("Cannot create roomDto from null object.")
        }
        Room roomToSave = new Room()
        roomToSave.code = room.code
        roomToSave.description = room.description
        if(room.roomTypeId != null) {
            roomToSave.roomType = roomTypeService.findById(room.roomTypeId)
        }
        roomToSave.capacity = room.capacity
        roomToSave.codeNLZ = room.codeNLZ
        roomToSave.newCode = room.newCode
        roomToSave.defaultRows = room.defaultRows
        roomToSave.defaultCols = room.defaultCols
        return save(roomToSave)
    }
    
    /**
     * This service method is used to update an Room object in the database from a partial or complete Room object.
     *
     * @param room the partial or complete Room object to be saved
     * @return the saved version of the Room object
     */
    
    @Transactional
    public Room updateFromDto(RoomDto room) {
        if (room == null) {
            throw new InvalidDataException("Cannot update roomDto from null object.")
        }
        if(room.id == null) {
            throw new InvalidDataException("Cannot update roomDto from null Id.")
        }
        Room roomToSave = findById(room.id)
        if(room.roomTypeId != null) {
            roomToSave.roomType = roomTypeService.findById(room.roomTypeId)
        }
        roomToSave.code = room.code
        roomToSave.description = room.description
        roomToSave.capacity = room.capacity
        roomToSave.codeNLZ = room.codeNLZ
        roomToSave.newCode = room.newCode
        roomToSave.defaultRows = room.defaultRows
        roomToSave.defaultCols = room.defaultCols
        return save(roomToSave)
    }
    
    /**
     * Saves a list of Room objects to the database
     *
     * @param rooms a list of Rooms to be saved to the database
     * @return the list of save Room objects
     */
    
    @Transactional
    public List<Room> saveRooms(List<Room> rooms) {
        return rooms.collect { room -> save(room) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Room should not be deleted.
     */
    @Override
    public void delete(Room obj) {
        throw new InvalidOperationException("Room should not be deleted")
    }
}
