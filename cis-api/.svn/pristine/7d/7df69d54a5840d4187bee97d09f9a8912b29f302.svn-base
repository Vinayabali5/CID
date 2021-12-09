package uk.ac.reigate.services.cristal

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

import uk.ac.reigate.domain.cristal.CristalRoom
import uk.ac.reigate.dto.cristal.CristalRoomDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.cristal.CristalRoomRepository


class CristalRoomServiceTest {
    
    @Mock
    private CristalRoomRepository cristalRoomRepository;
    
    @InjectMocks
    private CristalRoomService cristalRoomService;
    
    private CristalRoom cristalRoom
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample CristalRoom data object to use for the testing
     * 
     * @return a sample CristalRoom data object
     */
    CristalRoom createCristalRoom() {
        return new CristalRoom(
                roomId: 1,
                roomName: 'L105',
                computerName: 'CL1004',
                mayPrint: true,
                autoStart: true,
                securityCodeNotRequired: true,
                confirmRoomChange: true,
                confirmStaffChange: true,
                confirmTimeChange: true,
                tutorOffice: false
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample CristalRoom created at setup
     * 
     * @return a CristalRoomDto object based on the sample CristalRoom
     */
    CristalRoomDto createDto() {
        return new CristalRoomDto(
                roomId: cristalRoom.roomId,
                roomName: cristalRoom.roomName,
                computerName: cristalRoom.computerName,
                mayPrint: cristalRoom.mayPrint,
                autoStart: cristalRoom.autoStart,
                securityCodeNotRequired: cristalRoom.securityCodeNotRequired,
                confirmRoomChange: cristalRoom.confirmRoomChange,
                confirmStaffChange: cristalRoom.confirmStaffChange,
                confirmTimeChange: cristalRoom.confirmTimeChange,
                tutorOffice: cristalRoom.tutorOffice
                )
    }
    
    /**
     * This method is used to set up the tests for the CristalRoomService
     */
    @Before
    public void setup() {
        this.cristalRoomRepository = Mockito.mock(CristalRoomRepository.class);
        this.cristalRoomService = new CristalRoomService(cristalRoomRepository);
        
        cristalRoom = createCristalRoom()
        
        when(cristalRoomRepository.save(any(CristalRoom.class))).thenReturn(cristalRoom);
        when(cristalRoomRepository.findByRoomId(cristalRoom.roomId)).thenReturn(cristalRoom);
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        CristalRoomService service = new CristalRoomService();
        assertNotNull(service)
    }
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<CristalRoom> result = cristalRoomService.findAll();
        verify(cristalRoomRepository, times(1)).findAll()
        verifyNoMoreInteractions(cristalRoomRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindByRoomName() {
        CristalRoom result = cristalRoomService.findById(1);
        verify(cristalRoomRepository, times(1)).findByRoomId(1)
        verifyNoMoreInteractions(cristalRoomRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        CristalRoom savedCristalRoom = cristalRoomService.save(cristalRoom);
        verify(cristalRoomRepository, times(1)).save(any())
        verifyNoMoreInteractions(cristalRoomRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<CristalRoom> savedCristalRooms = cristalRoomService.saveCristalRooms([cristalRoom, cristalRoom]);
        verify(cristalRoomRepository, times(2)).save(cristalRoom)
        verifyNoMoreInteractions(cristalRoomRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CristalRoomDto dto = createDto()
        CristalRoom cristalRoomSaved = cristalRoomService.createFromDto(dto)
        verify(cristalRoomRepository, times(1)).save(any(CristalRoom.class))
        verifyNoMoreInteractions(cristalRoomRepository)
        assertEquals(dto.roomName, cristalRoom.roomName)
        assertEquals(dto.computerName, cristalRoom.computerName)
        assertEquals(dto.mayPrint, cristalRoom.mayPrint)
        assertEquals(dto.autoStart, cristalRoom.autoStart)
        assertEquals(dto.securityCodeNotRequired, cristalRoom.securityCodeNotRequired)
        assertEquals(dto.confirmRoomChange, cristalRoom.confirmRoomChange)
        assertEquals(dto.autoStart, cristalRoom.autoStart)
        assertEquals(dto.autoStart, cristalRoom.autoStart)
        assertEquals(dto.autoStart, cristalRoom.autoStart)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create cristalRoomDto from null object.")
        CristalRoomDto dto = null
        cristalRoomService.createFromDto(dto)
        verifyNoMoreInteractions(cristalRoomRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CristalRoomDto dto = createDto()
        CristalRoom cristalRoomSaved = cristalRoomService.updateFromDto(dto)
        verify(cristalRoomRepository, times(1)).findByRoomId(cristalRoom.roomId)
        verify(cristalRoomRepository, times(1)).save(cristalRoom)
        verifyNoMoreInteractions(cristalRoomRepository)
        assertEquals(cristalRoom.roomId, cristalRoomSaved.roomId)
        assertEquals(cristalRoom.roomName, cristalRoomSaved.roomName)
        assertEquals(cristalRoom.computerName, cristalRoomSaved.computerName)
        assertEquals(cristalRoom.mayPrint, cristalRoomSaved.mayPrint)
        assertEquals(cristalRoom.autoStart, cristalRoomSaved.autoStart)
        assertEquals(cristalRoom.securityCodeNotRequired, cristalRoomSaved.securityCodeNotRequired)
        assertEquals(cristalRoom.confirmRoomChange, cristalRoomSaved.confirmRoomChange)
        assertEquals(cristalRoom.confirmStaffChange, cristalRoomSaved.confirmStaffChange)
        assertEquals(cristalRoom.confirmTimeChange, cristalRoomSaved.confirmTimeChange)
        assertEquals(cristalRoom.tutorOffice, cristalRoomSaved.tutorOffice)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update cristalRoomDto from null object.")
        CristalRoomDto dto = null
        cristalRoomService.updateFromDto(dto)
        verifyNoMoreInteractions(cristalRoomRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}