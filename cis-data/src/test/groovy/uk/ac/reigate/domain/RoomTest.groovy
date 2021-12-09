package uk.ac.reigate.domain;

import org.junit.Test

import static org.junit.Assert.*


public class RoomTest {
    
    Person createPerson() {
        Person person = new Person()
    }
    
    RoomType createRoomType() {
        RoomType roomType = new RoomType()
    }
    
    @Test
    void testMethod_ToString() {
        Room room = new Room()
        
        assertEquals(room.description, room.toString())
    }
}
