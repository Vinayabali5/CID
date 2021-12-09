package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.dto.PeriodDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.PeriodRepository;


class PeriodServiceTest {
    
    @Mock
    private PeriodRepository periodRepository;
    
    @Mock
    private BlockService blockService
    
    @InjectMocks
    private PeriodService periodService;
    
    private Period period
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    Period createPeriod() {
        return new Period(
                id: 1,
                code:'A',
                description:'A Period',
                startTime: null,
                endTime: null,
                day: 11,
                dayPeriod: 1
                )
    }
    
    PeriodDto createDto() {
        Period samplePeriod = createPeriod();
        return new PeriodDto(
                id: samplePeriod.id,
                code:samplePeriod.code,
                description:samplePeriod.description,
                startTime: samplePeriod.startTime,
                endTime: samplePeriod.endTime,
                day: samplePeriod.day,
                dayPeriod: samplePeriod.dayPeriod
                )
    }
    
    @Before
    public void setup() {
        periodRepository = mock(PeriodRepository.class);
        blockService = mock(BlockService.class);
        periodService = new PeriodService(periodRepository, blockService);
        
        period = createPeriod()
        
        when(periodRepository.findById(1)).thenReturn(new Optional(period));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        PeriodService service = new PeriodService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindPeriod() {
        List<Period> result = periodService.findAll();
        verify(periodRepository, times(1)).findAll()
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testFindPeriodById() {
        Period result = periodService.findById(1);
        verify(periodRepository, times(1)).findById(1)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testSaveNewPeriod() {
        period.id = null
        periodService.save(period);
        verify(periodRepository, times(1)).save(period)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testSaveList() {
        List<Period> savedPeriods = periodService.savePeriods([period, period]);
        verify(periodRepository, times(2)).save(period)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testSavePeriod() {
        periodService.save(period);
        verify(periodRepository, times(1)).save(period)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        PeriodDto dto = new PeriodDto(id: 1, code: 'A')
        periodService.createFromDto(dto)
        verify(periodRepository, times(1)).save(any(Period.class))
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testCreateFromDto_blockId() {
        PeriodDto dto = createDto()
        dto.blockId = 1
        when(blockService.findById(dto.blockId)).thenReturn(null);
        periodService.createFromDto(dto)
        verify(periodRepository, times(1)).save(any(Period.class))
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create periodDto from null object.")
        PeriodDto dto = null
        periodService.createFromDto(dto)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        PeriodDto dto = new PeriodDto(id: 1, code: 'A')
        periodService.updateFromDto(dto)
        verify(periodRepository, times(1)).findById(period.id)
        verify(periodRepository, times(1)).save(any(Period.class))
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testUpdateFromDto_blockId() {
        PeriodDto dto = createDto()
        dto.blockId = 1
        when(blockService.findById(dto.blockId)).thenReturn(null);
        periodService.updateFromDto(dto)
        verify(blockService, times(1)).findById(dto.blockId)
        verifyNoMoreInteractions(blockService)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update periodDto from null Id.")
        PeriodDto dto = new PeriodDto(code: 'A')
        periodService.updateFromDto(dto)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update periodDto from null object.")
        Period dto = null
        periodService.updateFromDto(dto)
        verifyNoMoreInteractions(periodRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        periodService.delete(period)
        verifyNoMoreInteractions(periodRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}