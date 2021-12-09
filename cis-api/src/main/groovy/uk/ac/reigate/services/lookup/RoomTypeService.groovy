package uk.ac.reigate.services.lookup

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.RoomType
import uk.ac.reigate.dto.lookup.RoomTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.RoomTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class RoomTypeService implements ICoreDataService<RoomType, Integer>, IDtoCreateUpdateService<RoomTypeDto, RoomType>{
    
    @Autowired
    RoomTypeRepository roomTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    RoomTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param roomTypeRepository
     */
    RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }
    
    /**
     * Find an individual RoomType using the RoomType ID fields
     *
     * @param id the ID fields to search for
     * @return the RoomType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    RoomType findById(Integer id) {
        return roomTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of RoomType objects
     * @return a SearchResult set with the list of RoomTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete RoomType object in the database
     *
     * @param roomType the new RoomType object to be saved
     * @return the saved version of the RoomType object
     */
    @Override
    @Transactional
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType)
    }
    
    /**
     * This service method is used to update an RoomType object in the database from a partial or complete RoomType object.
     *
     * @param roomType the partial or complete RoomType object to be saved
     * @return the saved version of the RoomType object
     */
    @Transactional
    public RoomType createFromDto(RoomTypeDto roomType) {
        if (roomType == null) {
            throw new InvalidDataException("Cannot create roomType from null object.")
        }
        RoomType roomTypeToSave = new RoomType()
        roomTypeToSave.id = roomType.id
        roomTypeToSave.code = roomType.code
        roomTypeToSave.description = roomType.description
        roomTypeToSave.timetableable = roomType.timetableable
        return save(roomTypeToSave)
    }
    /**
     * This service method is used to update an RoomType object in the database from a partial or complete RoomType object.
     *
     * @param roomType the partial or complete RoomType object to be saved
     * @return the saved version of the RoomType object
     */
    @Transactional
    public RoomType updateFromDto(RoomTypeDto roomType) {
        if (roomType == null) {
            throw new InvalidDataException("Cannot update roomType from null object.")
        }
        RoomType roomTypeToSave = findById(roomType.id)
        roomTypeToSave.code = roomType.code
        roomTypeToSave.description = roomType.description
        roomTypeToSave.timetableable = roomType.timetableable
        return save(roomTypeToSave)
    }
    
    /**
     * Saves a list of RoomType objects to the database
     *
     * @param roomTypes a list of RoomTypes to be saved to the database
     * @return the list of save RoomType objects
     */
    @Transactional
    public List<RoomType> saveRoomTypes(List<RoomType> roomTypes) {
        return roomTypes.collect { roomType -> save(roomType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. RoomType should not be deleted.
     */
    @Override
    public void delete(RoomType obj) {
        throw new InvalidOperationException("RoomType should not be deleted")
        
    }
    
    
    
}
