package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.register.RegisterMark
import uk.ac.reigate.dto.RegisterMarkDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.register.RegisterMarkRepository
import uk.ac.reigate.services.student.StudentService


class RegisterMarkServiceTest {
    
    private RegisterMarkRepository registerMarkRepository
    
    private RegisterService registerService
    
    private CourseGroupService courseGroupService
    
    private CourseService courseService
    
    private StudentService studentService
    
    private StaffService staffService
    
    private AttendanceCodeService attendanceCodeService
    
    private RegisterMarkService registerMarkService;
    
    private RegisterMark registerMark;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    RegisterMark createRegisterMark() {
        return new RegisterMark(
                id: 1
                )
    }
    
    RegisterMarkDto createDto() {
        RegisterMark sampleData = createRegisterMark()
        return new RegisterMarkDto(
                id: sampleData.id
                )
    }
    
    @Before
    public void setup() {
        registerMarkRepository = mock(RegisterMarkRepository.class);
        registerService= mock(RegisterService.class);
        courseGroupService = mock(CourseGroupService.class);
        courseService = mock(CourseService.class);
        studentService= mock(StudentService.class)
        staffService = mock(StaffService.class);
        attendanceCodeService = mock(AttendanceCodeService.class)
        
        this.registerMarkService = new RegisterMarkService(registerMarkRepository, registerService, courseGroupService, courseService, studentService, staffService, attendanceCodeService);
        
        registerMark = createRegisterMark()
        
        when(registerMarkRepository.findById(1)).thenReturn(new Optional(new RegisterMark()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        RegisterMarkService service = new RegisterMarkService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindRegisterMark() {
        List<RegisterMark> result = registerMarkService.findAll();
        verify(registerMarkRepository, times(1)).findAll()
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testFindRegisterMarkById() {
        RegisterMark result = registerMarkService.findById(1);
        verify(registerMarkRepository, times(1)).findById(1)
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testSaveNewRegisterMark() {
        registerMark.id = null
        registerMarkService.save(registerMark);
        verify(registerMarkRepository, times(1)).save(registerMark)
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testSaveRegisterMark() {
        registerMarkService.save(registerMark);
        verify(registerMarkRepository, times(1)).save(registerMark)
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testSaveList() {
        List<RegisterMark> savedRegisterMarks = registerMarkService.saveRegisterMarks([registerMark, registerMark]);
        verify(registerMarkRepository, times(2)).save(registerMark)
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        registerMarkService.createFromDto(dto)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_withCourseId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.courseId = 1
        when(courseService.findById(dto.courseId)).thenReturn(null)
        registerMarkService.createFromDto(dto)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_withCourseGroupId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null)
        registerMarkService.createFromDto(dto)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_withRegisterId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.registerId = 1
        when(registerService.findById(dto.registerId)).thenReturn(null)
        registerMarkService.createFromDto(dto)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_withStudentId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null)
        registerMarkService.createFromDto(dto)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_withAttendanceCodeId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.attendanceCodeId = 1
        when(attendanceCodeService.findById(dto.attendanceCodeId)).thenReturn(null)
        registerMarkService.createFromDto(dto)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        registerMarkService.updateFromDto(dto)
        verify(registerMarkRepository, times(1)).findById(registerMark.id)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testUpdateFromDto_withCourseId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.courseId = 1
        when(courseService.findById(dto.courseId)).thenReturn(null)
        registerMarkService.updateFromDto(dto)
        verify(courseService, times(1)).findById(dto.courseId)
        verifyNoMoreInteractions(courseService)
    }
    
    @Test
    public void testUpdateFromDto_withCourseGroupId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null)
        registerMarkService.updateFromDto(dto)
        verify(courseGroupService, times(1)).findById(dto.courseGroupId)
        verifyNoMoreInteractions(courseGroupService)
    }
    
    @Test
    public void testUpdateFromDto_withRegisterId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.registerId = 1
        when(registerService.findById(dto.registerId)).thenReturn(null)
        registerMarkService.updateFromDto(dto)
        verify(registerService, times(1)).findById(dto.registerId)
        verifyNoMoreInteractions(registerService)
    }
    
    @Test
    public void testUpdateFromDto_withStudentId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.studentId = 1
        when(studentService.findById(dto.studentId)).thenReturn(null)
        registerMarkService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withAttendanceCodeId() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.attendanceCodeId = 1
        when(attendanceCodeService.findById(dto.attendanceCodeId)).thenReturn(null)
        registerMarkService.updateFromDto(dto)
        verify(attendanceCodeService, times(1)).findById(dto.attendanceCodeId)
        verifyNoMoreInteractions(attendanceCodeService)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        RegisterMarkDto dto = new RegisterMarkDto(id: 1)
        dto.courseId = null
        registerMarkService.updateFromDto(dto)
        verify(registerMarkRepository, times(1)).findById(registerMark.id)
        verify(registerMarkRepository, times(1)).save(any(RegisterMark.class))
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create regiaterMarkDto from null object.")
        RegisterMarkDto dto = null
        registerMarkService.createFromDto(dto)
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update regiaterMarkDto from null object.")
        RegisterMarkDto dto = null
        registerMarkService.updateFromDto(dto)
        verifyNoMoreInteractions(registerMarkRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        registerMarkService.delete(registerMark)
        verifyNoMoreInteractions(registerMarkRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

