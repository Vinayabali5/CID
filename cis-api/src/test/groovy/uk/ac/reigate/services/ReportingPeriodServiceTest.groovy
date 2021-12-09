package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.lookup.ReportingPeriod
import uk.ac.reigate.dto.ReportingPeriodDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.ReportingPeriodRepository

class ReportingPeriodServiceTest {
    
    private ReportingPeriodRepository reportingPeriodRepository
    
    private AcademicYearService academicYearService
    
    private ReportingPeriodService reportingPeriodService;
    
    private ReportingPeriod reportingPeriod
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    ReportingPeriod createReportingPeriod() {
        return new ReportingPeriod(
                id: 1,
                name: 'A'
                )
    }
    
    ReportingPeriodDto createDto() {
        ReportingPeriod sampleData = createReportingPeriod()
        return new ReportingPeriodDto(
                id: sampleData.id,
                name: sampleData.name
                )
    }
    @Before
    public void setup() {
        reportingPeriodRepository = mock(ReportingPeriodRepository.class);
        academicYearService = mock(AcademicYearService.class);
        
        this.reportingPeriodService = new ReportingPeriodService(reportingPeriodRepository, academicYearService);
        
        reportingPeriod = createReportingPeriod()
        
        when(reportingPeriodRepository.findById(1)).thenReturn(new Optional(reportingPeriod));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ReportingPeriodService service = new ReportingPeriodService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindReportingPeriods() {
        List<ReportingPeriod> result = reportingPeriodService.findAll();
        verify(reportingPeriodRepository, times(1)).findAll()
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testSearchByAcademicYear() {
        AcademicYear academicYear = new AcademicYear(id: 19)
        List<ReportingPeriod> result = reportingPeriodService.searchByAcademicYear(academicYear);
        verify(reportingPeriodRepository, times(1)).findByAcademicYear(academicYear)
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testFindReportingPeriod() {
        ReportingPeriod result = reportingPeriodService.findById(1);
        verify(reportingPeriodRepository, times(1)).findById(1)
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testSaveNewReportingPeriod() {
        ReportingPeriod savedReportingPeriod = reportingPeriodService.save(reportingPeriod);
        verify(reportingPeriodRepository, times(1)).save(any())
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testSaveReportingPeriod() {
        ReportingPeriod savedReportingPeriod = reportingPeriodService.save(reportingPeriod);
        verify(reportingPeriodRepository, times(1)).save(any())
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testSaveReportingPeriodByFields() {
        ReportingPeriod savedReportingPeriod = reportingPeriodService.save(reportingPeriod);
        verify(reportingPeriodRepository, times(1)).save(any())
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        ReportingPeriodDto dto = new ReportingPeriodDto(id: 1, name: 'A')
        reportingPeriodService.createFromDto(dto)
        verify(reportingPeriodRepository, times(1)).save(any(ReportingPeriod.class))
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testCreateFromDto_academicYearId() {
        ReportingPeriodDto dto = createDto()
        dto.academicYearId = 18
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null)
        reportingPeriodService.createFromDto(dto)
        verify(reportingPeriodRepository, times(1)).save(any(ReportingPeriod.class))
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        ReportingPeriodDto dto = new ReportingPeriodDto(id: 1, name: 'A')
        reportingPeriodService.updateFromDto(dto)
        verify(reportingPeriodRepository, times(1)).findById(reportingPeriod.id)
        verify(reportingPeriodRepository, times(1)).save(reportingPeriod)
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testUpdateFromDto_academicYearId() {
        ReportingPeriodDto dto = createDto()
        dto.academicYearId = 18
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null)
        reportingPeriodService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.academicYearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create reportingPeriodDto from null object.")
        ReportingPeriodDto dto = null
        reportingPeriodService.createFromDto(dto)
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update reportingPeriodDto from null object.")
        ReportingPeriodDto dto = null
        reportingPeriodService.updateFromDto(dto)
        verifyNoMoreInteractions(reportingPeriodRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        reportingPeriodService.delete(reportingPeriod)
        verifyNoMoreInteractions(reportingPeriodRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

