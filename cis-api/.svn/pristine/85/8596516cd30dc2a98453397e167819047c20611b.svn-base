package uk.ac.reigate.services

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

import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.dto.AttendanceMonitoringDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.AttendanceMonitoringRepository
import uk.ac.reigate.util.exception.IdMissingException


class AttendanceMonitoringServiceTest {
    
    @Mock
    private AttendanceMonitoringRepository attendanceMonitoringRepository;
    
    @InjectMocks
    private AttendanceMonitoringService attendanceMonitoringService;
    
    private AttendanceMonitoring attendanceMonitoring
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample AttendanceMonitoring data object to use for the testing
     *
     * @return a sample AttendanceMonitoring data object
     */
    AttendanceMonitoring createAttendanceMonitoring() {
        return new AttendanceMonitoring(
                id: 99,
                code: 'G',
                description: 'Good',
                warningColour: 'red'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample attendanceMonitoring created at setup
     *
     * @return a attendanceMonitoringDto object based on the sample attendanceMonitoring
     */
    AttendanceMonitoringDto createDto() {
        return new AttendanceMonitoringDto(
                id: attendanceMonitoring.id,
                code: attendanceMonitoring.code,
                description: attendanceMonitoring.description,
                warningColour: attendanceMonitoring.warningColour
                )
    }
    
    /**
     * This method is used to set up the tests for the AttendanceMonitoringService
     */
    @Before
    public void setup() {
        this.attendanceMonitoringRepository = Mockito.mock(AttendanceMonitoringRepository.class);
        this.attendanceMonitoringService = new AttendanceMonitoringService(attendanceMonitoringRepository);
        
        attendanceMonitoring = createAttendanceMonitoring()
        
        when(attendanceMonitoringRepository.save(any(AttendanceMonitoring.class))).thenReturn(attendanceMonitoring);
        when(attendanceMonitoringRepository.findById(attendanceMonitoring.id)).thenReturn(new Optional(attendanceMonitoring));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        AttendanceMonitoringService service = new AttendanceMonitoringService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<AttendanceMonitoring> result = attendanceMonitoringService.findAll();
        verify(attendanceMonitoringRepository, times(1)).findAll()
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        AttendanceMonitoring result = attendanceMonitoringService.findById(1);
        verify(attendanceMonitoringRepository, times(1)).findById(1)
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        AttendanceMonitoring savedAttendanceMonitoring = attendanceMonitoringService.save(new AttendanceMonitoring());
        verify(attendanceMonitoringRepository, times(1)).save(any())
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveAttendanceMonitorings() {
        List<AttendanceMonitoring> savedAttendanceMonitorings = attendanceMonitoringService.saveAttendanceMonitorings([
            new AttendanceMonitoring(id: 1),
            new AttendanceMonitoring(id: 2)
        ]);
        verify(attendanceMonitoringRepository, times(2)).save(any(AttendanceMonitoring.class))
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create AttendanceMonitoring from null object.")
        AttendanceMonitoringDto dto = null
        attendanceMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        AttendanceMonitoringDto dto = new AttendanceMonitoringDto(id: 1, code: '123', description: 'Year 123')
        attendanceMonitoringService.createFromDto(dto)
        verify(attendanceMonitoringRepository, times(1)).findById(1)
        verify(attendanceMonitoringRepository, times(1)).save(any(AttendanceMonitoring.class))
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoForExisting() {
        thrown.expect(IdMissingException.class)
        thrown.expectMessage("An AttendanceMonitoring already exist with this ID.")
        AttendanceMonitoringDto dto = new AttendanceMonitoringDto(id: 99, code: '99', description: 'Year 99')
        attendanceMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        AttendanceMonitoringDto dto = createDto()
        attendanceMonitoringService.updateFromDto(dto)
        verify(attendanceMonitoringRepository, times(1)).findById(attendanceMonitoring.id)
        verify(attendanceMonitoringRepository, times(1)).save(any(AttendanceMonitoring.class))
        verifyNoMoreInteractions(attendanceMonitoringRepository)
        assertEquals(dto.id, attendanceMonitoring.id)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AttendanceMonitoring from null object.")
        AttendanceMonitoringDto dto = null
        attendanceMonitoringService.updateFromDto(dto)
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method with null Id
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AttendanceMonitoring when ID is null.")
        AttendanceMonitoringDto dto = new AttendanceMonitoringDto(code: '123', description: 'cane hill')
        attendanceMonitoringService.updateFromDto(dto)
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method for existing
     */
    @Test
    public void testUpdateFromDto_dtoForExisting() {
        thrown.expect(IdMissingException.class)
        thrown.expectMessage("An AttendanceMonitoring already exist with this ID.")
        AttendanceMonitoringDto dto = new AttendanceMonitoringDto(id: 99, code: "99", description: "Year 99")
        attendanceMonitoringService.createFromDto(dto)
        verifyNoMoreInteractions(attendanceMonitoringRepository)
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("AttendanceMonitoring should not be deleted.")
        attendanceMonitoringService.delete(new AttendanceMonitoring(id: 1))
    }
}

