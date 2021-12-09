package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Holiday
import uk.ac.reigate.dto.HolidayDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.HolidayRepository;


class HolidayServiceTest {
    
    @Mock
    private HolidayRepository holidayRepository;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @InjectMocks
    private HolidayService holidayService;
    
    private Holiday holiday;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Holiday createHoliday() {
        return new Holiday(
                id: 1,
                description: 'Academic Year 15/16',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                halfTerm: true
                )
    }
    
    HolidayDto createDto() {
        Holiday sampleData = createHoliday()
        return new HolidayDto(
                id: sampleData.id,
                description: sampleData.description,
                startDate: sampleData.startDate,
                endDate: sampleData.endDate,
                halfTerm: sampleData.halfTerm
                )
    }
    
    @Before
    public void setup() {
        holidayRepository = mock(HolidayRepository.class);
        academicYearService = mock(AcademicYearService.class);
        this.holidayService = new HolidayService(holidayRepository, academicYearService);
        
        holiday = createHoliday()
        
        when(holidayRepository.findById(1)).thenReturn(new Optional(holiday));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        HolidayService service = new HolidayService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Holiday> result = holidayService.findAll();
        verify(holidayRepository, times(1)).findAll()
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testFindById() {
        Holiday result = holidayService.findById(1);
        verify(holidayRepository, times(1)).findById(1)
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testSave() {
        holiday.id = null
        holidayService.save(holiday);
        verify(holidayRepository, times(1)).save(holiday)
        verifyNoMoreInteractions(holidayRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Holiday> savedHolidays = holidayService.saveHolidays([holiday, holiday]);
        verify(holidayRepository, times(2)).save(holiday)
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testSaveHoliday() {
        holidayService.save(holiday);
        verify(holidayRepository, times(1)).save(holiday)
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        HolidayDto dto = new HolidayDto(id: 1, description: 'Academic Year 15/16', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'))
        holidayService.createFromDto(dto)
        verify(holidayRepository, times(1)).save(any(Holiday.class))
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create holidayDto from null object.")
        HolidayDto dto = null
        holidayService.createFromDto(dto)
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearId() {
        HolidayDto dto = createDto()
        dto.yearId = 19
        when(academicYearService.findById(dto.yearId)).thenReturn(null)
        holidayService.createFromDto(dto)
        verify(holidayRepository, times(1)).save(any(Holiday.class))
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        HolidayDto dto = createDto()
        dto.yearId = null
        holidayService.updateFromDto(dto)
        verify(holidayRepository, times(1)).findById(holiday.id)
        verify(holidayRepository, times(1)).save(any(Holiday.class))
        verifyNoMoreInteractions(holidayRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithYearId() {
        HolidayDto dto = createDto()
        dto.yearId = 19
        when(academicYearService.findById(dto.yearId)).thenReturn(null)
        holidayService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.yearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update holidayDto from null object.")
        HolidayDto dto = new HolidayDto(description: 'Academic Year 15/16', startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'))
        holidayService.updateFromDto(dto)
        verifyNoMoreInteractions(holidayRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        holidayService.delete(holiday)
        verifyNoMoreInteractions(holidayRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

