package uk.ac.reigate.dto.cristal;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.cristal.CristalRoom

public class CristalRoomDtoTest {
    
    private CristalRoom cristalRoom1
    
    private CristalRoom cristalRoom2
    
    
    private List<CristalRoom> cristalRooms
    
    @Before
    public void setup() {
        cristalRoom1 = new CristalRoom(
                roomId: 1,
                roomName:'1',
                computerName:'CristalRoom1',
                mayPrint: false,
                autoStart: true,
                securityCodeNotRequired: true,
                confirmRoomChange: false,
                confirmStaffChange: true,
                confirmTimeChange: true,
                tutorOffice: false
                );
        cristalRoom2 = new CristalRoom(
                roomId: 2,
                roomName:'2',
                computerName:'CristalRoom2',
                mayPrint: true,
                autoStart: true,
                securityCodeNotRequired: true,
                confirmRoomChange: true,
                confirmStaffChange: true,
                confirmTimeChange: false,
                tutorOffice: true
                );
        cristalRooms = Arrays.asList(cristalRoom1, cristalRoom2);
    }
    
    @Test
    public void testMapFromCristalRoomEntity(){
        CristalRoomDto cristalRoomTest = CristalRoomDto.mapFromEntity( cristalRoom1 )
        assertEquals( cristalRoomTest.roomName, cristalRoom1.roomName);
        assertEquals( cristalRoomTest.computerName, cristalRoom1.computerName);
        assertEquals( cristalRoomTest.mayPrint, cristalRoom1.mayPrint);
        assertEquals( cristalRoomTest.autoStart, cristalRoom1.autoStart);
        assertEquals( cristalRoomTest.securityCodeNotRequired, cristalRoom1.securityCodeNotRequired);
        assertEquals( cristalRoomTest.confirmRoomChange, cristalRoom1.confirmRoomChange);
        assertEquals( cristalRoomTest.confirmStaffChange, cristalRoom1.confirmStaffChange);
        assertEquals( cristalRoomTest.confirmTimeChange, cristalRoom1.confirmTimeChange);
    }
    
    @Test
    public void testMapFromCristalRoomsEntities(){
        List<CristalRoomDto> cristalRoomTest = CristalRoomDto.mapFromList( cristalRooms )
        assertEquals( cristalRoomTest[0].roomName, cristalRoom1.roomName);
        assertEquals( cristalRoomTest[0].computerName, cristalRoom1.computerName);
        assertEquals( cristalRoomTest[0].mayPrint, cristalRoom1.mayPrint);
        assertEquals( cristalRoomTest[0].autoStart, cristalRoom1.autoStart);
        assertEquals( cristalRoomTest[0].securityCodeNotRequired, cristalRoom1.securityCodeNotRequired);
        assertEquals( cristalRoomTest[0].confirmRoomChange, cristalRoom1.confirmRoomChange);
        assertEquals( cristalRoomTest[0].confirmStaffChange, cristalRoom1.confirmStaffChange);
        assertEquals( cristalRoomTest[0].confirmTimeChange, cristalRoom1.confirmTimeChange);
        assertEquals( cristalRoomTest[1].roomName, cristalRoom2.roomName);
        assertEquals( cristalRoomTest[1].computerName, cristalRoom2.computerName);
        assertEquals( cristalRoomTest[1].mayPrint, cristalRoom2.mayPrint);
        assertEquals( cristalRoomTest[1].autoStart, cristalRoom2.autoStart);
        assertEquals( cristalRoomTest[1].securityCodeNotRequired, cristalRoom2.securityCodeNotRequired);
        assertEquals( cristalRoomTest[1].confirmRoomChange, cristalRoom2.confirmRoomChange);
        assertEquals( cristalRoomTest[1].confirmStaffChange, cristalRoom2.confirmStaffChange);
        assertEquals( cristalRoomTest[1].confirmTimeChange, cristalRoom2.confirmTimeChange);
    }
    
    @Test
    public void testEquals_Same() {
        CristalRoomDto cristalRoomDto1 = new CristalRoomDto(cristalRoom1)
        CristalRoomDto cristalRoomDto2 = new CristalRoomDto(cristalRoom1)
        assertEquals(cristalRoomDto1, cristalRoomDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CristalRoomDto cristalRoomDto1 = new CristalRoomDto(cristalRoom1)
        CristalRoomDto cristalRoomDto2 = new CristalRoomDto(cristalRoom2)
        assertNotEquals(cristalRoomDto1, cristalRoomDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CristalRoomDto cristalRoomDto1 = new CristalRoomDto(cristalRoom1)
        CristalRoomDto cristalRoomDto2 = new CristalRoomDto(cristalRoom1)
        assertEquals(cristalRoomDto1.hashCode(), cristalRoomDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CristalRoomDto cristalRoomDto1 = new CristalRoomDto(cristalRoom1)
        CristalRoomDto cristalRoomDto2 = new CristalRoomDto(cristalRoom2)
        assertNotEquals(cristalRoomDto1.hashCode(), cristalRoomDto2.hashCode())
    }
    
    @Test
    public void testConstructor_CristalRoom() {
        CristalRoomDto cristalRoomTest = new CristalRoomDto(cristalRoom1)
        assertEquals( cristalRoomTest.roomName, cristalRoom1.roomName);
        assertEquals( cristalRoomTest.computerName, cristalRoom1.computerName);
        assertEquals( cristalRoomTest.mayPrint, cristalRoom1.mayPrint);
        assertEquals( cristalRoomTest.autoStart, cristalRoom1.autoStart);
        assertEquals( cristalRoomTest.securityCodeNotRequired, cristalRoom1.securityCodeNotRequired);
        assertEquals( cristalRoomTest.confirmRoomChange, cristalRoom1.confirmRoomChange);
        assertEquals( cristalRoomTest.confirmStaffChange, cristalRoom1.confirmStaffChange);
        assertEquals( cristalRoomTest.confirmTimeChange, cristalRoom1.confirmTimeChange);
    }
}
