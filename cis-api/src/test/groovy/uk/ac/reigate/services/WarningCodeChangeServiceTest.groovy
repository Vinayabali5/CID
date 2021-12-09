package uk.ac.reigate.services

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
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

import uk.ac.reigate.domain.lookup.WarningCodeChange
import uk.ac.reigate.dto.WarningCodeChangeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.WarningCodeChangeRepository
import uk.ac.reigate.services.student.StudentService


class WarningCodeChangeServiceTest {
    
    @Mock
    private WarningCodeChangeRepository warningCodeChangeRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @Mock
    private AttendanceMonitoringService attendanceMonitoringService;
    
    @Mock
    private PunctualityMonitoringService punctualityMonitoringService;
    
    @InjectMocks
    private WarningCodeChangeService warningCodeChangeService;
    
    private WarningCodeChange warningCodeChange
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample WarningCodeChange data object to use for the testing
     * 
     * @return a sample WarningCodeChange data object
     */
    WarningCodeChange createWarningCodeChange() {
        return new WarningCodeChange(
                id: 1,
                changeDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample WarningCodeChange created at setup
     * 
     * @return a WarningCodeChangeDto object based on the sample WarningCodeChange
     */
    WarningCodeChangeDto createDto() {
        return new WarningCodeChangeDto(
                id: warningCodeChange.id,
                changeDate: warningCodeChange.changeDate
                )
    }
    
    /**
     * This method is used to set up the tests for the WarningCodeChangeService
     */
    @Before
    public void setup() {
        warningCodeChangeRepository = mock(WarningCodeChangeRepository.class);
        studentService = mock(StudentService.class);
        academicYearService = mock(AcademicYearService.class);
        attendanceMonitoringService = mock(AttendanceMonitoringService.class);
        punctualityMonitoringService = mock(PunctualityMonitoringService.class);
        
        this.warningCodeChangeService = new WarningCodeChangeService(warningCodeChangeRepository, studentService, academicYearService, attendanceMonitoringService, punctualityMonitoringService);
        
        warningCodeChange = createWarningCodeChange()
        
        when(warningCodeChangeRepository.save(any(WarningCodeChange.class))).thenReturn(warningCodeChange);
        when(warningCodeChangeRepository.findById(1)).thenReturn(new Optional(warningCodeChange));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        WarningCodeChangeService service = new WarningCodeChangeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<WarningCodeChange> result = warningCodeChangeService.findAll();
        verify(warningCodeChangeRepository, times(1)).findAll()
        verifyNoMoreInteractions(warningCodeChangeRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<WarningCodeChange> result = warningCodeChangeService.findByStudentId(19001);
        verify(warningCodeChangeRepository, times(1)).findByStudent_Id(19001)
        verifyNoMoreInteractions(warningCodeChangeRepository)
    }
    
    @Test
    public void testGetByStudentAndYear() {
        List<WarningCodeChange> result = warningCodeChangeService.getByStudentAndYear(19001, 19);
        verify(warningCodeChangeRepository, times(1)).findByStudent_IdAndYear_Id(19001, 19)
        verifyNoMoreInteractions(warningCodeChangeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        WarningCodeChange result = warningCodeChangeService.findById(1);
        verify(warningCodeChangeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(warningCodeChangeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        WarningCodeChange savedWarningCodeChange = warningCodeChangeService.save(warningCodeChange);
        verify(warningCodeChangeRepository, times(1)).save(any())
        verifyNoMoreInteractions(warningCodeChangeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        WarningCodeChangeDto dto = createDto()
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        WarningCodeChangeDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    @Test
    public void testCreateFromDto_dtoWithYearId() {
        WarningCodeChangeDto dto = createDto()
        dto.yearId = 19001
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    @Test
    public void testCreateFromDto_dtoWithPreviousAmId() {
        WarningCodeChangeDto dto = createDto()
        dto.previousAmId = 19001
        when(attendanceMonitoringService.findById(dto.previousAmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    @Test
    public void testCreateFromDto_dtoWithcurrentAmId() {
        WarningCodeChangeDto dto = createDto()
        dto.currentAmId = 19001
        when(attendanceMonitoringService.findById(dto.currentAmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    @Test
    public void testCreateFromDto_dtoWithPreviousPmId() {
        WarningCodeChangeDto dto = createDto()
        dto.previousPmId = 19001
        when(punctualityMonitoringService.findById(dto.previousPmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    @Test
    public void testCreateFromDto_dtoWithcurrentPmId() {
        WarningCodeChangeDto dto = createDto()
        dto.currentPmId = 19001
        when(punctualityMonitoringService.findById(dto.currentPmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.createFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).save(any(WarningCodeChange.class))
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(dto.id, warningCodeChange.id)
        assertEquals(dto.changeDate, warningCodeChange.changeDate)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create warningCodeChangeDto from null object.")
        WarningCodeChangeDto dto = null
        warningCodeChangeService.createFromDto(dto)
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        WarningCodeChangeDto dto = createDto()
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).findById(warningCodeChange.id)
        verify(warningCodeChangeRepository, times(1)).save(warningCodeChange)
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertEquals(warningCodeChange.id, warningCodeChangeSaved.id)
        assertEquals(warningCodeChange.changeDate, warningCodeChangeSaved.changeDate)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        WarningCodeChangeDto dto = createDto()
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(warningCodeChangeRepository, times(1)).findById(warningCodeChange.id)
        verify(warningCodeChangeRepository, times(1)).save(warningCodeChange)
        verifyNoMoreInteractions(warningCodeChangeRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update warningCodeChangeDto from null object.")
        WarningCodeChangeDto dto = null
        warningCodeChangeService.updateFromDto(dto)
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    
    @Test
    public void testUpdateFromDto_dtoWithStudentId() {
        WarningCodeChangeDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithYearId() {
        WarningCodeChangeDto dto = createDto()
        dto.yearId = 19001
        when(academicYearService.findById(dto.yearId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.yearId)
        verifyNoMoreInteractions(academicYearService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithPreviousAmId() {
        WarningCodeChangeDto dto = createDto()
        dto.previousAmId = 19001
        when(attendanceMonitoringService.findById(dto.previousAmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(attendanceMonitoringService, times(1)).findById(dto.previousAmId)
        verifyNoMoreInteractions(attendanceMonitoringService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithcurrentAmId() {
        WarningCodeChangeDto dto = createDto()
        dto.currentAmId = 19001
        when(attendanceMonitoringService.findById(dto.currentAmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(attendanceMonitoringService, times(1)).findById(dto.currentAmId)
        verifyNoMoreInteractions(attendanceMonitoringService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithPreviousPmId() {
        WarningCodeChangeDto dto = createDto()
        dto.previousPmId = 19001
        when(punctualityMonitoringService.findById(dto.previousPmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(punctualityMonitoringService, times(1)).findById(dto.previousPmId)
        verifyNoMoreInteractions(punctualityMonitoringService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithPCurrentPmId() {
        WarningCodeChangeDto dto = createDto()
        dto.currentPmId = 19001
        when(punctualityMonitoringService.findById(dto.currentPmId)).thenReturn(null);
        WarningCodeChange warningCodeChangeSaved = warningCodeChangeService.updateFromDto(dto)
        verify(punctualityMonitoringService, times(1)).findById(dto.currentPmId)
        verifyNoMoreInteractions(punctualityMonitoringService)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        warningCodeChangeService.delete(warningCodeChange)
        verifyNoMoreInteractions(warningCodeChangeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}