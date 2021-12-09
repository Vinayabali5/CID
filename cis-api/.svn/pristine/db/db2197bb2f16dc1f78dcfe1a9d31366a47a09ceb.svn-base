package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.cristal.MasterRegister
import uk.ac.reigate.dto.MasterRegisterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.cristal.MasterRegisterRepository
import uk.ac.reigate.services.student.StudentService

@RunWith(MockitoJUnitRunner.class)
class MasterRegisterServiceTest {
    
    @Mock
    private MasterRegisterRepository masterRegisterRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private AttendanceCodeService attendanceCodeService;
    
    @Mock
    private AcademicYearService academicYearService
    
    @InjectMocks
    private MasterRegisterService masterRegisterService;
    
    private MasterRegister masterRegister
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample MasterRegister data object to use for the testing
     * 
     * @return a sample MasterRegister data object
     */
    MasterRegister createMasterRegister() {
        return new MasterRegister(
                id: 1,
                notes: 'Test',
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample MasterRegister created at setup
     * 
     * @return a MasterRegisterDto object based on the sample MasterRegister
     */
    MasterRegisterDto createDto() {
        MasterRegister sampleData = createMasterRegister()
        return new MasterRegisterDto(
                id: sampleData.id,
                notes: sampleData.notes
                )
    }
    
    /**
     * This method is used to set up the tests for the MasterRegisterService
     */
    @Before
    public void setup() {
        masterRegisterRepository = mock(MasterRegisterRepository.class);
        studentService = mock(StudentService.class);
        attendanceCodeService = mock(AttendanceCodeService.class);
        academicYearService = mock(AcademicYearService.class);
        masterRegisterService = new MasterRegisterService(masterRegisterRepository, studentService, attendanceCodeService, academicYearService);
        
        masterRegister = createMasterRegister()
        
        when(masterRegisterRepository.findById(masterRegister.id)).thenReturn(new Optional(new MasterRegister()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        MasterRegisterService service = new MasterRegisterService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<MasterRegister> result = masterRegisterService.findAll();
        verify(masterRegisterRepository, times(1)).findAll()
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testStudentById() {
        List<MasterRegister> result = masterRegisterService.getByStudent(190001);
        verify(masterRegisterRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testGetByStudentAndYear() {
        List<MasterRegister> result = masterRegisterService.getByStudentAndYear(190001, 19);
        verify(masterRegisterRepository, times(1)).findByStudentIdAndAcademicYearId(190001, 19)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testSaveLists() {
        List<MasterRegister> savedAimTypes = masterRegisterService.saveMasterRegisters([
            masterRegister,
            masterRegister
        ]);
        verify(masterRegisterRepository, times(2)).save(masterRegister)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        MasterRegister result = masterRegisterService.findById(1);
        verify(masterRegisterRepository, times(1)).findById(1)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        MasterRegister savedMasterRegister = masterRegisterService.save(masterRegister);
        verify(masterRegisterRepository, times(1)).save(any())
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<MasterRegister> savedMasterRegisters = masterRegisterService.saveMasterRegisters([
            masterRegister,
            masterRegister
        ]);
        verify(masterRegisterRepository, times(2)).save(masterRegister)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        MasterRegisterDto dto = createDto()
        MasterRegister masterRegisterSaved = masterRegisterService.createFromDto(dto)
        verify(masterRegisterRepository, times(1)).save(any(MasterRegister.class))
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoStudentId() {
        MasterRegisterDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        MasterRegister masterRegisterSaved = masterRegisterService.createFromDto(dto)
        verify(masterRegisterRepository, times(1)).save(any(MasterRegister.class))
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoAttendanceId() {
        MasterRegisterDto dto = createDto()
        dto.attendanceId = 1
        when(attendanceCodeService.findById(dto.attendanceId)).thenReturn(null);
        MasterRegister masterRegisterSaved = masterRegisterService.createFromDto(dto)
        verify(masterRegisterRepository, times(1)).save(any(MasterRegister.class))
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoYearId() {
        MasterRegisterDto dto = createDto()
        dto.academicYearId = 1
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null);
        MasterRegister masterRegisterSaved = masterRegisterService.createFromDto(dto)
        verify(masterRegisterRepository, times(1)).save(any(MasterRegister.class))
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create masterRegister from null object.")
        MasterRegisterDto dto = null
        masterRegisterService.createFromDto(dto)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        MasterRegisterDto dto = createDto()
        MasterRegister masterRegisterSaved = masterRegisterService.updateFromDto(dto)
        verify(masterRegisterRepository, times(1)).findById(masterRegister.id)
        verify(masterRegisterRepository, times(1)).save(any(MasterRegister.class))
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoStudentId() {
        MasterRegisterDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        MasterRegister masterRegisterSaved = masterRegisterService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_dtoAttendanceId() {
        MasterRegisterDto dto = createDto()
        dto.attendanceId = 1
        when(attendanceCodeService.findById(dto.attendanceId)).thenReturn(null);
        MasterRegister masterRegisterSaved = masterRegisterService.updateFromDto(dto)
        verify(attendanceCodeService, times(1)).findById(dto.attendanceId)
        verifyNoMoreInteractions(attendanceCodeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoYearId() {
        MasterRegisterDto dto = createDto()
        dto.academicYearId = 1
        when(academicYearService.findById(dto.academicYearId)).thenReturn(null);
        MasterRegister masterRegisterSaved = masterRegisterService.updateFromDto(dto)
        verify(academicYearService, times(1)).findById(dto.academicYearId)
        verifyNoMoreInteractions(academicYearService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update masterRegister from null object.")
        MasterRegisterDto dto = null
        masterRegisterService.updateFromDto(dto)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update masterRegister from null Id.")
        MasterRegisterDto dto = new MasterRegisterDto(notes: 'test')
        masterRegisterService.updateFromDto(dto)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        masterRegisterService.delete(masterRegister)
        verifyNoMoreInteractions(masterRegisterRepository)
    }
}