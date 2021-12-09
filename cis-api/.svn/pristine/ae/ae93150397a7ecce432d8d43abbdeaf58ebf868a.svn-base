package uk.ac.reigate.services.interimreport

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.dto.interimreport.InterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.interimreport.InterimReportRepository
import uk.ac.reigate.services.AcademicYearService

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*


class InterimReportServiceTest {
    
    @Mock
    private InterimReportRepository interimReportRepository;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @InjectMocks
    private InterimReportService interimReportService;
    
    private InterimReport interimReport
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample InterimReport data object to use for the testing
     * 
     * @return a sample InterimReport data object
     */
    InterimReport createInterimReport() {
        return new InterimReport(
                id: 1,
                description: 'Aim Type',
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample InterimReport created at setup
     * 
     * @return a InterimReportDto object based on the sample InterimReport
     */
    InterimReportDto createDto() {
        return new InterimReportDto(
                id: interimReport.id,
                description: interimReport.description
                )
    }
    
    /**
     * This method is used to set up the tests for the InterimReportService
     */
    @Before
    public void setup() {
        this.interimReportRepository = Mockito.mock(InterimReportRepository.class);
        this.academicYearService = Mockito.mock(AcademicYearService.class);
        this.interimReportService = new InterimReportService(interimReportRepository, academicYearService);
        
        interimReport = createInterimReport()
        
        when(interimReportRepository.save(any(InterimReport.class))).thenReturn(interimReport);
        when(interimReportRepository.findById(1)).thenReturn(new Optional(interimReport));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        InterimReportService service = new InterimReportService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<InterimReport> result = interimReportService.findAll();
        verify(interimReportRepository, times(1)).findAll()
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        InterimReport result = interimReportService.findById(1);
        verify(interimReportRepository, times(1)).findById(1)
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    @Test
    public void testGetCurrent() {
        InterimReport result = interimReportService.getCurrent();
        verify(interimReportRepository, times(1)).findTopByActiveIsTrueOrderByStartDateDesc()
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        InterimReport savedInterimReport = interimReportService.save(interimReport);
        verify(interimReportRepository, times(1)).save(any())
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<InterimReport> savedInterimReports = interimReportService.saveInterimReports([interimReport, interimReport]);
        verify(interimReportRepository, times(2)).save(interimReport)
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        InterimReportDto dto = createDto()
        InterimReport interimReportSaved = interimReportService.createFromDto(dto)
        verify(interimReportRepository, times(1)).save(any(InterimReport.class))
        verifyNoMoreInteractions(interimReportRepository)
        assertEquals(dto.id, interimReport.id)
        assertEquals(dto.description, interimReport.description)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearId() {
        InterimReportDto dto = createDto()
        //dto.yearId = 18
        //when(academicYearService.findById(dto.yearId)).thenReturn(null);
        interimReportService.createFromDto(dto)
        verify(interimReportRepository, times(1)).save(any(InterimReport.class))
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dtoWithYearId() {
        InterimReportDto dto = createDto()
        //dto.yearId = 18
        //when(academicYearService.findById(dto.yearId)).thenReturn(null);
        interimReportService.updateFromDto(dto)
        verify(interimReportRepository, times(1)).findById(dto.id)
        verify(interimReportRepository, times(1)).save(any(InterimReport.class))
        verifyNoMoreInteractions(interimReportRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create interimReportDto from null object.")
        InterimReportDto dto = null
        interimReportService.createFromDto(dto)
        verifyNoMoreInteractions(interimReportRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        InterimReportDto dto = createDto()
        InterimReport interimReportSaved = interimReportService.updateFromDto(dto)
        verify(interimReportRepository, times(1)).findById(interimReport.id)
        verify(interimReportRepository, times(1)).save(interimReport)
        verifyNoMoreInteractions(interimReportRepository)
        assertEquals(interimReport.id, interimReportSaved.id)
        assertEquals(interimReport.description, interimReportSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        InterimReportDto dto = createDto()
        dto.yearId = null
        InterimReport interimReportSaved = interimReportService.updateFromDto(dto)
        verify(interimReportRepository, times(1)).findById(interimReport.id)
        verify(interimReportRepository, times(1)).save(interimReport)
        verifyNoMoreInteractions(interimReportRepository)
        assertEquals(interimReport.id, interimReportSaved.id)
        assertEquals(interimReport.description, interimReportSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update interimReportDto from null object.")
        InterimReportDto dto = null
        interimReportService.updateFromDto(dto)
        verifyNoMoreInteractions(interimReportRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        interimReportService.delete(interimReport)
        verifyNoMoreInteractions(interimReportRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}