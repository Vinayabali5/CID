package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.PunctualityMonitoring
import uk.ac.reigate.dto.PunctualityMonitoringDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.PunctualityMonitoringRepository


class PunctualityMonitoringServiceTest {
    
    private PunctualityMonitoringRepository punctualityMonitoringRepository;
    
    private PunctualityMonitoringService punctualityMonitoringService;
    
    private PunctualityMonitoring punctualityMonitoring;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        this.punctualityMonitoringRepository = Mockito.mock(PunctualityMonitoringRepository.class);
        this.punctualityMonitoringService = new PunctualityMonitoringService(punctualityMonitoringRepository);
        
        punctualityMonitoring = new PunctualityMonitoring(
                id: 1,
                code: 'G',
                description: 'Good',
                warningColour: 'red'
                )
        
        when(punctualityMonitoringRepository.findById(1)).thenReturn(new Optional(punctualityMonitoring));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        PunctualityMonitoringService service = new PunctualityMonitoringService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindPunctualityMonitorings() {
        List<PunctualityMonitoring> result = punctualityMonitoringService.findAll();
        verify(punctualityMonitoringRepository, times(1)).findAll()
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testFindPunctualityMonitoring() {
        PunctualityMonitoring result = punctualityMonitoringService.findById(1);
        verify(punctualityMonitoringRepository, times(1)).findById(1)
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testSaveNewPunctualityMonitoring() {
        PunctualityMonitoring savedPunctualityMonitoring = punctualityMonitoringService.save(punctualityMonitoring);
        verify(punctualityMonitoringRepository, times(1)).save(any())
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testSavePunctualityMonitoring() {
        PunctualityMonitoring savedPunctualityMonitoring = punctualityMonitoringService.save(punctualityMonitoring);
        verify(punctualityMonitoringRepository, times(1)).save(any())
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testSavePunctualityMonitorings() {
        List<PunctualityMonitoring> savedPunctualityMonitorings = punctualityMonitoringService.savePunctualityMonitorings([
            new PunctualityMonitoring(id: 1),
            new PunctualityMonitoring(id: 2)
        ]);
        verify(punctualityMonitoringRepository, times(2)).save(any(PunctualityMonitoring.class))
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testSavePunctualityMonitoringByFields() {
        PunctualityMonitoring savedPunctualityMonitoring = punctualityMonitoringService.save(punctualityMonitoring);
        verify(punctualityMonitoringRepository, times(1)).save(any())
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        PunctualityMonitoringDto dto = new PunctualityMonitoringDto(id: 1, code: 'Test')
        punctualityMonitoringService.createFromDto(dto)
        verify(punctualityMonitoringRepository, times(1)).save(any(PunctualityMonitoring.class))
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        PunctualityMonitoringDto dto = new PunctualityMonitoringDto(id: 1, code: 'Test')
        punctualityMonitoringService.updateFromDto(dto)
        verify(punctualityMonitoringRepository, times(1))findById(punctualityMonitoring.id)
        verify(punctualityMonitoringRepository, times(1)).save(punctualityMonitoring)
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create punctualityMonitoringDto from null object.")
        PunctualityMonitoringDto dto = null
        punctualityMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update punctualityMonitoringDto from null object.")
        PunctualityMonitoring dto = null
        punctualityMonitoringService.updateFromDto(dto)
        verifyNoMoreInteractions(punctualityMonitoringRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        punctualityMonitoringService.delete(punctualityMonitoring)
        verifyNoMoreInteractions(punctualityMonitoringRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

