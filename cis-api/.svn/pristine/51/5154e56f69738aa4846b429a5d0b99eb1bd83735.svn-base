package uk.ac.reigate.services

import static org.mockito.Mockito.*

import static org.mockito.Mockito.*

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AlternativePeriod
import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.dto.AlternativePeriodDto
import uk.ac.reigate.dto.lookup.BlockDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.AlternativePeriodRepository

class AlternativePeriodServiceTest {
    
    @Mock
    private AlternativePeriodRepository alternativePeriodRepository
    
    @Mock
    private BlockService blockService
    
    @InjectMocks
    private AlternativePeriodService alternativePeriodService;
    
    private AlternativePeriod alternativePeriod
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample AlternativePeriod data object to use for the testing
     *
     * @return a sample AlternativePeriod data object
     */
    AlternativePeriod createAlternativePeriod() {
        return new AlternativePeriod(
                id: 99,
                code: 'A',
                description: 'Absent',
                day: 3,
                dayPeriod: 4,
                LviStartTime: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                LviEndTime: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                UviStartTime: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                UviEndTime: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                boxNo: 3,
                cristalPeriod: 4,
                defaultPeriodText : 'Test'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample AlternativePeriod created at setup
     *
     * @return a AlternativePeriodDto object based on the sample AlternativePeriod
     */
    AlternativePeriodDto createDto() {
        return new AlternativePeriodDto(
                id: alternativePeriod.id,
                code: alternativePeriod.code,
                description: alternativePeriod.description,
                day: alternativePeriod.day,
                dayPeriod: alternativePeriod.dayPeriod,
                LviStartTime: alternativePeriod.LviStartTime,
                LviEndTime: alternativePeriod.LviEndTime,
                UviStartTime: alternativePeriod.UviStartTime,
                UviEndTime: alternativePeriod.UviEndTime,
                boxNo: alternativePeriod.boxNo,
                cristalPeriod: alternativePeriod.cristalPeriod,
                defaultPeriodText : alternativePeriod.defaultPeriodText
                )
    }
    
    /**
     * This method is used to set up the tests for the AttendanceService
     */
    @Before
    public void setup() {
        this.alternativePeriodRepository = mock(AlternativePeriodRepository.class);
        this.blockService = mock(BlockService.class);
        this.alternativePeriodService = new AlternativePeriodService(alternativePeriodRepository, blockService);
        
        alternativePeriod = createAlternativePeriod()
        
        when(alternativePeriodRepository.save(any(AlternativePeriod.class))).thenReturn(alternativePeriod);
        when(alternativePeriodRepository.findById(alternativePeriod.id)).thenReturn(new Optional(alternativePeriod));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        AlternativePeriodService service = new AlternativePeriodService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<AlternativePeriod> result = alternativePeriodService.findAll();
        verify(alternativePeriodRepository, times(1)).findAll()
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        AlternativePeriod result = alternativePeriodService.findById(1);
        verify(alternativePeriodRepository, times(1)).findById(1)
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        AlternativePeriod savedAlternativePeriod = alternativePeriodService.save(new AlternativePeriod(id:1));
        verify(alternativePeriodRepository, times(1)).save(any())
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test the save service method with null values
     */
    @Test
    public void testSave_withNull() {
        AlternativePeriod savedAlternativePeriod = alternativePeriodService.save(null);
        verify(alternativePeriodRepository, times(1)).save(any())
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test the save all service method
     */
    @Test
    public void testSaveAlternativePeriods() {
        List<AlternativePeriod> savedAlternativePeriods = alternativePeriodService.saveAlternativePeriods([
            new AlternativePeriod(id:1),
            new AlternativePeriod(id:2)
        ]);
        verify(alternativePeriodRepository, times(2)).save(any(AlternativePeriod.class))
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        AlternativePeriodDto dto = createDto()
        AlternativePeriod alternativePeriodSaved = alternativePeriodService.createFromDto(dto)
        verify(alternativePeriodRepository, times(1)).save(any(AlternativePeriod.class))
        verifyNoMoreInteractions(alternativePeriodRepository)
        assertEquals(dto.id, alternativePeriod.id)
        assertEquals(dto.code, alternativePeriod.code)
        assertEquals(dto.description, alternativePeriod.description)
        assertEquals(dto.day, alternativePeriod.day)
        assertEquals(dto.dayPeriod, alternativePeriod.dayPeriod)
        assertEquals(dto.LviStartTime, alternativePeriod.LviStartTime)
        assertEquals(dto.LviEndTime, alternativePeriod.LviEndTime)
        assertEquals(dto.UviStartTime, alternativePeriod.UviStartTime)
        assertEquals(dto.UviEndTime, alternativePeriod.UviEndTime)
    }
    
    @Test
    public void testCreateFromDto_dtoWithBlockId() {
        AlternativePeriodDto dto = createDto()
        dto.blockId = 1
        when(blockService.findById(dto.blockId)).thenReturn(null);
        AlternativePeriod alternativePeriodSaved = alternativePeriodService.createFromDto(dto)
        verify(alternativePeriodRepository, times(1)).save(any(AlternativePeriod.class))
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create alternativePeriodDto from null object.")
        AlternativePeriodDto dto = null
        alternativePeriodService.createFromDto(dto)
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    /**
     * This method is used to test theupdateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        AlternativePeriodDto dto = createDto()
        AlternativePeriod alternativePeriodSaved = alternativePeriodService.updateFromDto(dto)
        verify(alternativePeriodRepository, times(1)).findById(alternativePeriod.id)
        verify(alternativePeriodRepository, times(1)).save(any(AlternativePeriod.class))
        verifyNoMoreInteractions(alternativePeriodRepository)
        assertEquals(dto.id, alternativePeriod.id)
        assertEquals(dto.code, alternativePeriod.code)
        assertEquals(dto.description, alternativePeriod.description)
        assertEquals(dto.day, alternativePeriod.day)
        assertEquals(dto.dayPeriod, alternativePeriod.dayPeriod)
        assertEquals(dto.LviStartTime, alternativePeriod.LviStartTime)
        assertEquals(dto.LviEndTime, alternativePeriod.LviEndTime)
        assertEquals(dto.UviStartTime, alternativePeriod.UviStartTime)
        assertEquals(dto.UviEndTime, alternativePeriod.UviEndTime)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AlternativePeriodDto from null object.")
        AlternativePeriodDto dto = null
        alternativePeriodService.updateFromDto(dto)
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithBlockId() {
        AlternativePeriodDto dto = createDto()
        dto.blockId = 1
        when(blockService.findById(dto.blockId)).thenReturn(null);
        AlternativePeriod alternativePeriodSaved = alternativePeriodService.updateFromDto(dto)
        verify(blockService, times(1)).findById(dto.blockId)
        verifyNoMoreInteractions(blockService)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null Id
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AlternativePeriodDto from null Id.")
        AlternativePeriodDto dto = new AlternativePeriodDto(code: '123', description: 'cane hill')
        alternativePeriodService.updateFromDto(dto)
        verifyNoMoreInteractions(alternativePeriodRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        alternativePeriodService.delete(alternativePeriod)
        verifyNoMoreInteractions(alternativePeriodRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}