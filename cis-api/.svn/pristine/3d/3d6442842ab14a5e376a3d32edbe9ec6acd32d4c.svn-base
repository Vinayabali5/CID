package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.Room
import uk.ac.reigate.dto.RoomDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.RoomRepository
import uk.ac.reigate.services.lookup.RoomTypeService


class RoomServiceTest {
    
    @Mock
    private RoomRepository roomRepository;
    
    @Mock
    private RoomTypeService roomTypeService;
    
    @InjectMocks
    private RoomService roomService;
    
    private Room room
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Room data object to use for the testing
     * 
     * @return a sample Room data object
     */
    Room createRoom() {
        return new Room(
                id: 1,
                code: 'N',
                description: 'Room'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Room created at setup
     * 
     * @return a RoomDto object based on the sample Room
     */
    RoomDto createDto() {
        return new RoomDto(
                id: room.id,
                code: room.code,
                description: room.description
                )
    }
    
    /**
     * This method is used to set up the tests for the RoomService
     */
    @Before
    public void setup() {
        this.roomRepository = Mockito.mock(RoomRepository.class);
        this.roomTypeService = mock(RoomTypeService.class)
        this.roomService = new RoomService(roomRepository, roomTypeService);
        
        room = createRoom()
        
        when(roomRepository.save(any(Room.class))).thenReturn(room);
        when(roomRepository.findById(1)).thenReturn(new Optional(room));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        RoomService service = new RoomService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Room> result = roomService.findAll();
        verify(roomRepository, times(1)).findAll()
        verifyNoMoreInteractions(roomRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Room result = roomService.findById(1);
        verify(roomRepository, times(1)).findById(1)
        verifyNoMoreInteractions(roomRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Room savedRoom = roomService.save(room);
        verify(roomRepository, times(1)).save(any())
        verifyNoMoreInteractions(roomRepository)
    }
    
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Room> savedRooms = roomService.saveRooms([room, room]);
        verify(roomRepository, times(2)).save(room)
        verifyNoMoreInteractions(roomRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        RoomDto dto = createDto()
        Room roomSaved = roomService.createFromDto(dto)
        verify(roomRepository, times(1)).save(any(Room.class))
        verifyNoMoreInteractions(roomRepository)
        assertEquals(dto.id, room.id)
        assertEquals(dto.code, room.code)
        assertEquals(dto.description, room.description)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        RoomDto dto = createDto()
        dto.roomTypeId = null
        Room roomSaved = roomService.createFromDto(dto)
        verify(roomRepository, times(1)).save(any(Room.class))
        verifyNoMoreInteractions(roomRepository)
        assertEquals(room.id, roomSaved.id)
        assertEquals(room.code, roomSaved.code)
        assertEquals(room.description, roomSaved.description)
    }
    
    @Test
    public void testCreateFromDto_dtoWithNRoomTypeId() {
        RoomDto dto = createDto()
        dto.roomTypeId = 1
        when(roomTypeService.findById(dto.roomTypeId)).thenReturn(null);
        roomService.createFromDto(dto)
        verify(roomRepository, times(1)).save(any(Room.class))
        verifyNoMoreInteractions(roomRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create roomDto from null object.")
        RoomDto dto = null
        roomService.createFromDto(dto)
        verifyNoMoreInteractions(roomRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        RoomDto dto = createDto()
        Room roomSaved = roomService.updateFromDto(dto)
        verify(roomRepository, times(1)).findById(room.id)
        verify(roomRepository, times(1)).save(room)
        verifyNoMoreInteractions(roomRepository)
        assertEquals(room.id, roomSaved.id)
        assertEquals(room.code, roomSaved.code)
        assertEquals(room.description, roomSaved.description)
    }
    
    @Test
    public void testUpdateFromDto_RoomTypeId() {
        RoomDto dto = createDto()
        dto.roomTypeId = 1
        when(roomTypeService.findById(dto.roomTypeId)).thenReturn(null);
        roomService.updateFromDto(dto)
        verify(roomTypeService, times(1)).findById(dto.roomTypeId)
        verifyNoMoreInteractions(roomTypeService)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        RoomDto dto = createDto()
        dto.code = null
        dto.description = null
        Room roomSaved = roomService.updateFromDto(dto)
        verify(roomRepository, times(1)).findById(room.id)
        verify(roomRepository, times(1)).save(room)
        verifyNoMoreInteractions(roomRepository)
        assertEquals(room.id, roomSaved.id)
        assertEquals(room.code, roomSaved.code)
        assertEquals(room.description, roomSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update roomDto from null object.")
        RoomDto dto = null
        roomService.updateFromDto(dto)
        verifyNoMoreInteractions(roomRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update roomDto from null Id.")
        RoomDto dto = new RoomDto()
        dto.id = null
        roomService.updateFromDto(dto)
        verifyNoMoreInteractions(roomRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        roomService.delete(room)
        verifyNoMoreInteractions(roomRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}