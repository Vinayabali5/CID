package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.register.Register;
import uk.ac.reigate.dto.RegisterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.register.RegisterRepository


class RegisterServiceTest {
    
    private RegisterRepository registerRepository
    
    private RegisteredSessionService registeredSessionService
    
    private CourseGroupService courseGroupService
    
    private StaffService staffService
    
    private RegisterService registerService;
    
    private Register register;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    Register createRegister() {
        return new Register(
                id: 1,
                completed: true,
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2016/11/11')
                )
    }
    
    RegisterDto createDto() {
        Register sampleData = createRegister()
        return new RegisterDto(
                id: sampleData.id,
                completed: sampleData.completed,
                dateCompleted: sampleData.dateCompleted
                )
    }
    
    @Before
    public void setup() {
        registerRepository = mock(RegisterRepository.class);
        registeredSessionService = mock(RegisteredSessionService.class);
        courseGroupService = mock(CourseGroupService.class);
        staffService = mock(StaffService.class);
        
        this.registerService = new RegisterService(registerRepository, registeredSessionService, courseGroupService, staffService);
        
        register = createRegister()
        
        when(registerRepository.findById(1)).thenReturn(new Optional(register));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        RegisterService service = new RegisterService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindRegister() {
        List<Register> result = registerService.findAll();
        verify(registerRepository, times(1)).findAll()
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testFindRegisterById() {
        Register result = registerService.findById(1);
        verify(registerRepository, times(1)).findById(1)
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testSaveNewRegister() {
        register.id = null
        registerService.save(register);
        verify(registerRepository, times(1)).save(register)
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testSaveRegisters() {
        List<Register> savedAcademicYears = registerService.saveRegisters([
            new Register(id: 1),
            new Register(id: 2)
        ]);
        verify(registerRepository, times(2)).save(any(Register.class))
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testSaveRegister() {
        registerService.save(register);
        verify(registerRepository, times(1)).save(register)
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        RegisterDto dto = new RegisterDto(id: 1, dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'))
        registerService.createFromDto(dto)
        verify(registerRepository, times(1)).save(any(Register.class))
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testCreateFromDto_sessionId() {
        RegisterDto dto = createDto()
        dto.sessionId = 1
        when(registeredSessionService.findById(dto.sessionId)).thenReturn(null)
        registerService.createFromDto(dto)
        verify(registerRepository, times(1)).save(any(Register.class))
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testCreateFromDto_courseGroupId() {
        RegisterDto dto = createDto()
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null)
        registerService.createFromDto(dto)
        verify(registerRepository, times(1)).save(any(Register.class))
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testCreateFromDto_staffCompletedId() {
        RegisterDto dto = createDto()
        dto.staffCompletedId = 1
        when(staffService.findById(dto.staffCompletedId)).thenReturn(null)
        registerService.createFromDto(dto)
        verify(registerRepository, times(1)).save(any(Register.class))
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        RegisterDto dto = new RegisterDto(id: 1, dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'))
        registerService.updateFromDto(dto)
        verify(registerRepository, times(1)).findById(register.id)
        verify(registerRepository, times(1)).save(register)
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testUpdateFromDto_sessionId() {
        RegisterDto dto = createDto()
        dto.sessionId = 1
        when(registeredSessionService.findById(dto.sessionId)).thenReturn(null)
        registerService.updateFromDto(dto)
        verify(registeredSessionService, times(1)).findById(dto.sessionId)
        verifyNoMoreInteractions(registeredSessionService)
    }
    
    @Test
    public void testUpdateFromDto_courseGroupId() {
        RegisterDto dto = createDto()
        dto.courseGroupId = 1
        when(courseGroupService.findById(dto.courseGroupId)).thenReturn(null)
        registerService.updateFromDto(dto)
        verify(courseGroupService, times(1)).findById(dto.courseGroupId)
        verifyNoMoreInteractions(courseGroupService)
    }
    
    @Test
    public void testUpdateFromDto_staffCompletedId() {
        RegisterDto dto = createDto()
        dto.staffCompletedId = 1
        when(staffService.findById(dto.staffCompletedId)).thenReturn(null)
        registerService.updateFromDto(dto)
        verify(staffService, times(1)).findById(dto.staffCompletedId)
        verifyNoMoreInteractions(staffService)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create registerDto from null object.")
        RegisterDto dto = null
        registerService.createFromDto(dto)
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update registerDto from null object.")
        RegisterDto dto = null
        registerService.updateFromDto(dto)
        verifyNoMoreInteractions(registerRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        registerService.delete(register)
        verifyNoMoreInteractions(registerRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

