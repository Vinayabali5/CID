package uk.ac.reigate.services

import static org.mockito.Mockito.*

import static org.mockito.Mockito.*

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

import uk.ac.reigate.exceptions.InvalidOperationException

import uk.ac.reigate.domain.register.AttendanceCode;
import uk.ac.reigate.dto.AttendanceCodeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.register.AttendanceCodeRepository

class AttendanceCodeServiceTest {
    
    @Mock
    private AttendanceCodeRepository attendanceCodeRepository
    
    @InjectMocks
    private AttendanceCodeService attendanceCodeService;
    
    private AttendanceCode attendanceCode
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample AttendanceCode data object to use for the testing
     *
     * @return a sample AttendanceCode data object
     */
    AttendanceCode createAttendanceCode() {
        return new AttendanceCode(
                id: 99,
                code: 'A',
                description: 'Absent',
                registerMark: 'A',
                absence: true,
                authorisedAbsence: false,
                late: true,
                included: true,
                authorisedLate: false,
                lastDateOfAttendance: true,
                htmlColour: "red",
                accessColour: "r"
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample AttendanceCode created at setup
     *
     * @return a AttendanceCodeDto object based on the sample AttendanceCode
     */
    AttendanceCodeDto createDto() {
        return new AttendanceCodeDto(
                id: attendanceCode.id,
                code: attendanceCode.code,
                description: attendanceCode.description,
                registerMark: attendanceCode.registerMark,
                absence: attendanceCode.absence,
                authorisedAbsence: attendanceCode.authorisedAbsence,
                late: attendanceCode.late,
                included: attendanceCode.included,
                authorisedLate: attendanceCode.authorisedLate,
                lastDateOfAttendance: attendanceCode.lastDateOfAttendance,
                htmlColour: attendanceCode.htmlColour,
                accessColour: attendanceCode.accessColour
                )
    }
    
    /**
     * This method is used to set up the tests for the AttendanceService
     */
    @Before
    public void setup() {
        this.attendanceCodeRepository = mock(AttendanceCodeRepository.class);
        this.attendanceCodeService = new AttendanceCodeService(attendanceCodeRepository);
        
        attendanceCode = createAttendanceCode()
        
        when(attendanceCodeRepository.save(any(AttendanceCode.class))).thenReturn(attendanceCode);
        when(attendanceCodeRepository.findById(attendanceCode.id)).thenReturn(new Optional(attendanceCode));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        AttendanceCodeService service = new AttendanceCodeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<AttendanceCode> result = attendanceCodeService.findAll();
        verify(attendanceCodeRepository, times(1)).findAll()
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        AttendanceCode result = attendanceCodeService.findById(1);
        verify(attendanceCodeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        AttendanceCode savedAttendanceCode = attendanceCodeService.save(new AttendanceCode(id:1));
        verify(attendanceCodeRepository, times(1)).save(any())
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test the save service method with null values
     */
    @Test
    public void testSave_withNull() {
        AttendanceCode savedAttendanceCode = attendanceCodeService.save(null);
        verify(attendanceCodeRepository, times(1)).save(any())
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test the save all service method
     */
    @Test
    public void testSaveAttendanceCodes() {
        List<AttendanceCode> savedAttendanceCodes = attendanceCodeService.saveAttendanceCodes([
            new AttendanceCode(id:1),
            new AttendanceCode(id:2)
        ]);
        verify(attendanceCodeRepository, times(2)).save(any(AttendanceCode.class))
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        AttendanceCodeDto dto = createDto()
        AttendanceCode attendanceCodeSaved = attendanceCodeService.createFromDto(dto)
        verify(attendanceCodeRepository, times(1)).save(any(AttendanceCode.class))
        verifyNoMoreInteractions(attendanceCodeRepository)
        assertEquals(dto.id, attendanceCode.id)
        assertEquals(dto.code, attendanceCode.code)
        assertEquals(dto.description, attendanceCode.description)
        assertEquals(dto.registerMark, attendanceCode.registerMark)
        assertEquals(dto.absence, attendanceCode.absence)
        assertEquals(dto.authorisedAbsence, attendanceCode.authorisedAbsence)
        assertEquals(dto.late, attendanceCode.late)
        assertEquals(dto.authorisedLate, attendanceCode.authorisedLate)
        assertEquals(dto.included, attendanceCode.included)
        assertEquals(dto.lastDateOfAttendance, attendanceCode.lastDateOfAttendance)
        assertEquals(dto.htmlColour, attendanceCode.htmlColour)
        assertEquals(dto.accessColour, attendanceCode.accessColour)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create AttendanceCode from null object.")
        AttendanceCodeDto dto = null
        attendanceCodeService.createFromDto(dto)
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test theupdateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        AttendanceCodeDto dto = createDto()
        AttendanceCode attendanceCodeSaved = attendanceCodeService.updateFromDto(dto)
        verify(attendanceCodeRepository, times(1)).findById(attendanceCode.id)
        verify(attendanceCodeRepository, times(1)).save(any(AttendanceCode.class))
        verifyNoMoreInteractions(attendanceCodeRepository)
        assertEquals(dto.id, attendanceCode.id)
        assertEquals(dto.code, attendanceCode.code)
        assertEquals(dto.description, attendanceCode.description)
        assertEquals(dto.registerMark, attendanceCode.registerMark)
        assertEquals(dto.absence, attendanceCode.absence)
        assertEquals(dto.authorisedAbsence, attendanceCode.authorisedAbsence)
        assertEquals(dto.late, attendanceCode.late)
        assertEquals(dto.authorisedLate, attendanceCode.authorisedLate)
        assertEquals(dto.included, attendanceCode.included)
        assertEquals(dto.lastDateOfAttendance, attendanceCode.lastDateOfAttendance)
        assertEquals(dto.htmlColour, attendanceCode.htmlColour)
        assertEquals(dto.accessColour, attendanceCode.accessColour)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AttendanceCode from null object.")
        AttendanceCodeDto dto = null
        attendanceCodeService.updateFromDto(dto)
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null Id
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AttendanceCode from null object.")
        AttendanceCodeDto dto = new AttendanceCodeDto(code: '123', description: 'cane hill')
        attendanceCodeService.updateFromDto(dto)
        verifyNoMoreInteractions(attendanceCodeRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        attendanceCodeService.delete(attendanceCode)
        verifyNoMoreInteractions(attendanceCodeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}