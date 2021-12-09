package uk.ac.reigate.dto.lookup;

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.RoomType
import uk.ac.reigate.dto.lookup.RoomTypeDto

import static org.junit.Assert.*

public class RoomTypeDtoTest {
    
    private RoomType roomType1
    
    private RoomType roomType2
    
    
    private List<RoomType> roomTypes
    
    @Before
    public void setup() {
        roomType1 = new RoomType(
                id: 1,
                code:'1',
                description:'RoomType1',
                timetableable: null
                
                );
        roomType2 = new RoomType(
                id: 2,
                code:'2',
                description:'RoomType2',
                timetableable: null
                );
        roomTypes = Arrays.asList(roomType1, roomType2);
    }
    
    @Test
    public void testMapFromRoomTypeEntity(){
        RoomTypeDto roomTypeTest = RoomTypeDto.mapFromEntity( roomType1 )
        assertEquals( roomTypeTest.id, roomType1.id );
        assertEquals( roomTypeTest.code, roomType1.code);
        assertEquals( roomTypeTest.description, roomType1.description);
    }
    
    @Test
    public void testMapFromRoomTypesEntities(){
        List<RoomTypeDto> roomTypesDtoTest = RoomTypeDto.mapFromList( roomTypes )
        assertEquals( roomTypesDtoTest[0].id, roomType1.id );
        assertEquals( roomTypesDtoTest[0].code, roomType1.code);
        assertEquals( roomTypesDtoTest[0].description, roomType1.description);
        assertEquals( roomTypesDtoTest[1].id, roomType2.id );
        assertEquals( roomTypesDtoTest[1].code, roomType2.code);
        assertEquals( roomTypesDtoTest[1].description, roomType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        RoomTypeDto roomTypeDto1 = new RoomTypeDto(roomType1)
        RoomTypeDto roomTypeDto2 = new RoomTypeDto(roomType1)
        assertEquals(roomTypeDto1, roomTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        RoomTypeDto roomTypeDto1 = new RoomTypeDto(roomType1)
        RoomTypeDto roomTypeDto2 = new RoomTypeDto(roomType2)
        assertNotEquals(roomTypeDto1, roomTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        RoomTypeDto roomTypeDto1 = new RoomTypeDto(roomType1)
        RoomTypeDto roomTypeDto2 = new RoomTypeDto(roomType1)
        assertEquals(roomTypeDto1.hashCode(), roomTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        RoomTypeDto roomTypeDto1 = new RoomTypeDto(roomType1)
        RoomTypeDto roomTypeDto2 = new RoomTypeDto(roomType2)
        assertNotEquals(roomTypeDto1.hashCode(), roomTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_RoomType() {
        RoomTypeDto roomTypeDto = new RoomTypeDto(roomType1)
        assertEquals( roomTypeDto.code, roomType1.code )
        assertEquals( roomTypeDto.description, roomType1.description )
    }
}
