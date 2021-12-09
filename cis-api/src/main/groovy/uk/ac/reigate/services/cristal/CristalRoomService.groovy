package uk.ac.reigate.services.cristal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.cristal.CristalRoom
import uk.ac.reigate.dto.cristal.CristalRoomDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.RoomRepository
import uk.ac.reigate.repositories.cristal.CristalRoomRepository
import uk.ac.reigate.services.ICoreDataService

@Service
class CristalRoomService implements ICoreDataService<CristalRoom, Integer> {
    
    @Autowired
    CristalRoomRepository cristalRoomRepository
    
    @Autowired
    RoomRepository roomRepository
    
    /**
     * Default NoArgs constructor
     */
    CristalRoomService() {}
    
    /**
     * Autowired Constructor
     *
     * @param cristalRoomRepository
     */
    CristalRoomService(CristalRoomRepository cristalRoomRepository) {
        this.cristalRoomRepository = cristalRoomRepository;
    }
    
    /**
     * Find an individual CristalRoom using the CristalRoom ID fields
     *
     * @param id the ID fields to search for
     * @return the CristalRoom object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    CristalRoom findById(Integer roomId) {
        return cristalRoomRepository.findByRoomId(roomId)
    }
    
    /**
     * Find a single page of CristalRoom objects
     * @return a List of CristalRooms
     */
    @Transactional(readOnly = true)
    List<CristalRoom> findAll() {
        return cristalRoomRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete CristalRoom object in the database
     *
     * @param cristalRoom the new CristalRoom object to be saved
     * @return the saved version of the CristalRoom object
     */
    @Transactional
    public CristalRoom save(CristalRoom cristalRoom) {
        return cristalRoomRepository.save(cristalRoom)
    }
    
    /**
     * This service method is used to update an CristalRoom object in the database from a partial or complete CristalRoom object.
     *
     * @param cristalRoom the partial or complete CristalRoom object to be saved
     * @return the saved version of the CristalRoom object
     */
    
    @Transactional
    public CristalRoom createFromDto(CristalRoomDto cristalRoom) {
        if (cristalRoom == null) {
            throw new InvalidDataException("Cannot create cristalRoomDto from null object.")
        }
        CristalRoom cristalRoomToSave = new CristalRoom()
        cristalRoomToSave.roomName = cristalRoom.roomName;
        cristalRoomToSave.computerName = cristalRoom.computerName;
        cristalRoomToSave.mayPrint = cristalRoom.mayPrint
        cristalRoomToSave.autoStart = cristalRoom.autoStart
        cristalRoomToSave.securityCodeNotRequired = cristalRoom.securityCodeNotRequired
        cristalRoomToSave.confirmRoomChange = cristalRoom.confirmRoomChange
        cristalRoomToSave.confirmStaffChange = cristalRoom.confirmStaffChange
        cristalRoomToSave.confirmTimeChange = cristalRoom.confirmTimeChange
        cristalRoomToSave.tutorOffice = cristalRoom.tutorOffice;
        return save(cristalRoomToSave)
    }
    
    /**
     * This service method is used to update an CristalRoom object in the database from a partial or complete CristalRoom object.
     *
     * @param cristalRoom the partial or complete CristalRoom object to be saved
     * @return the saved version of the CristalRoom object
     */
    
    @Transactional
    public CristalRoom updateFromDto(CristalRoomDto cristalRoom) {
        if (cristalRoom == null) {
            throw new InvalidDataException("Cannot update cristalRoomDto from null object.")
        }
        CristalRoom cristalRoomToSave = findById(cristalRoom.roomId)
        cristalRoomToSave.roomName = cristalRoom.roomName;
        cristalRoomToSave.computerName = cristalRoom.computerName;
        cristalRoomToSave.mayPrint = cristalRoom.mayPrint
        cristalRoomToSave.autoStart = cristalRoom.autoStart
        cristalRoomToSave.securityCodeNotRequired = cristalRoom.securityCodeNotRequired
        cristalRoomToSave.confirmRoomChange = cristalRoom.confirmRoomChange
        cristalRoomToSave.confirmStaffChange = cristalRoom.confirmStaffChange
        cristalRoomToSave.confirmTimeChange = cristalRoom.confirmTimeChange
        cristalRoomToSave.tutorOffice = cristalRoom.tutorOffice;
        return save(cristalRoomToSave)
    }
    
    /**
     * Saves a list of CristalRoom objects to the database
     *
     * @param cristalRooms a list of CristalRooms to be saved to the database
     * @return the list of save CristalRoom objects
     */
    
    @Transactional
    public List<CristalRoom> saveCristalRooms(List<CristalRoom> cristalRooms) {
        return cristalRooms.collect { cristalRoom -> save(cristalRoom) };
    }
    
    @Override
    public void delete(CristalRoom obj) {
        // TODO Auto-generated method stub
        
    }
}
