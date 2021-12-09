package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.RoomType
import uk.ac.reigate.dto.lookup.RoomTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.RoomTypeRepository


class RoomTypeServiceTest {
    
    @Mock
    private RoomTypeRepository roomTypeRepository;
    
    @InjectMocks
    private RoomTypeService roomTypeService;
    
    private RoomType roomType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample RoomType data object to use for the testing
     * 
     * @return a sample RoomType data object
     */
    RoomType createRoomType() {
        return new RoomType(
                id: 1,
                code: 'L1004',
                description: 'MIS',
                timetableable: true
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample RoomType created at setup
     * 
     * @return a RoomTypeDto object based on the sample RoomType
     */
    RoomTypeDto createDto() {
        return new RoomTypeDto(
                id: roomType.id,
                code: roomType.code,
                description: roomType.description,
                timetableable: roomType.timetableable
                )
    }
    
    /**
     * This method is used to set up the tests for the RoomTypeService
     */
    @Before
    public void setup() {
        this.roomTypeRepository = Mockito.mock(RoomTypeRepository.class);
        this.roomTypeService = new RoomTypeService(roomTypeRepository);
        
        roomType = createRoomType()
        
        when(roomTypeRepository.save(any(RoomType.class))).thenReturn(roomType);
        when(roomTypeRepository.findById(1)).thenReturn(new Optional(roomType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        RoomTypeService service = new RoomTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<RoomType> result = roomTypeService.findAll();
        verify(roomTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(roomTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        RoomType result = roomTypeService.findById(1);
        verify(roomTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(roomTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        RoomType savedRoomType = roomTypeService.save(roomType);
        verify(roomTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(roomTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<RoomType> savedRoomTypes = roomTypeService.saveRoomTypes([roomType, roomType]);
        verify(roomTypeRepository, times(2)).save(roomType)
        verifyNoMoreInteractions(roomTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        RoomTypeDto dto = createDto()
        RoomType roomTypeSaved = roomTypeService.createFromDto(dto)
        verify(roomTypeRepository, times(1)).save(any(RoomType.class))
        verifyNoMoreInteractions(roomTypeRepository)
        assertEquals(dto.id, roomType.id)
        assertEquals(dto.code, roomType.code)
        assertEquals(dto.description, roomType.description)
        assertEquals(dto.timetableable, roomType.timetableable)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create roomType from null object.")
        RoomTypeDto dto = null
        roomTypeService.createFromDto(dto)
        verifyNoMoreInteractions(roomTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        RoomTypeDto dto = createDto()
        RoomType roomTypeSaved = roomTypeService.updateFromDto(dto)
        verify(roomTypeRepository, times(1)).findById(roomType.id)
        verify(roomTypeRepository, times(1)).save(roomType)
        verifyNoMoreInteractions(roomTypeRepository)
        assertEquals(roomType.id, roomTypeSaved.id)
        assertEquals(roomType.code, roomTypeSaved.code)
        assertEquals(roomType.description, roomTypeSaved.description)
        assertEquals(roomType.timetableable, roomTypeSaved.timetableable)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        RoomTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        RoomType roomTypeSaved = roomTypeService.updateFromDto(dto)
        verify(roomTypeRepository, times(1)).findById(roomType.id)
        verify(roomTypeRepository, times(1)).save(roomType)
        verifyNoMoreInteractions(roomTypeRepository)
        assertEquals(roomType.id, roomTypeSaved.id)
        assertEquals(roomType.code, roomTypeSaved.code)
        assertEquals(roomType.description, roomTypeSaved.description)
        assertEquals(roomType.timetableable, roomTypeSaved.timetableable)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update roomType from null object.")
        RoomTypeDto dto = null
        roomTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(roomTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        roomTypeService.delete(roomType)
        verifyNoMoreInteractions(roomTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}