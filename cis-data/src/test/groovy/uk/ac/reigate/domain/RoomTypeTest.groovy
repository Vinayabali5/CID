package uk.ac.reigate.domain;

import org.junit.Test

import static org.junit.Assert.*


public class RoomTypeTest {
    
    @Test
    void testMethod_ToString() {
        RoomType roomType = new RoomType()
        roomType.description = 'TEST'
        
        assertEquals(roomType.description, roomType.toString())
    }
}
