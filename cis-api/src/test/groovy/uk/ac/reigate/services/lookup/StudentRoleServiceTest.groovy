package uk.ac.reigate.services.lookup

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
import org.mockito.Mockito

import uk.ac.reigate.domain.lookup.StudentRole
import uk.ac.reigate.dto.lookup.StudentRoleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StudentRoleRepository


class StudentRoleServiceTest {
    
    @Mock
    private StudentRoleRepository studentRoleRepository;
    
    @InjectMocks
    private StudentRoleService studentRoleService;
    
    private StudentRole studentRole
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample StudentRole data object to use for the testing
     * 
     * @return a sample StudentRole data object
     */
    StudentRole createStudentRole() {
        return new StudentRole(
                id: 1,
                code: 'SM',
                description: 'Student Mentor'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample StudentRole created at setup
     * 
     * @return a StudentRoleDto object based on the sample StudentRole
     */
    StudentRoleDto createDto() {
        return new StudentRoleDto(
                id: studentRole.id,
                code: studentRole.code,
                description: studentRole.description
                )
    }
    
    /**
     * This method is used to set up the tests for the StudentRoleService
     */
    @Before
    public void setup() {
        this.studentRoleRepository = Mockito.mock(StudentRoleRepository.class);
        this.studentRoleService = new StudentRoleService(studentRoleRepository);
        
        studentRole = createStudentRole()
        
        when(studentRoleRepository.save(any(StudentRole.class))).thenReturn(studentRole);
        when(studentRoleRepository.findById(1)).thenReturn(new Optional(studentRole));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentRoleService service = new StudentRoleService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<StudentRole> result = studentRoleService.findAll();
        verify(studentRoleRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentRoleRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        StudentRole result = studentRoleService.findById(1);
        verify(studentRoleRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentRoleRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StudentRole savedStudentRole = studentRoleService.save(studentRole);
        verify(studentRoleRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentRoleRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<StudentRole> savedStudentRoles = studentRoleService.saveStudentRoles([studentRole, studentRole]);
        verify(studentRoleRepository, times(2)).save(studentRole)
        verifyNoMoreInteractions(studentRoleRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        StudentRoleDto dto = createDto()
        StudentRole studentRoleSaved = studentRoleService.createFromDto(dto)
        verify(studentRoleRepository, times(1)).save(any(StudentRole.class))
        verifyNoMoreInteractions(studentRoleRepository)
        assertEquals(dto.id, studentRole.id)
        assertEquals(dto.code, studentRole.code)
        assertEquals(dto.description, studentRole.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentRole from null object.")
        StudentRoleDto dto = null
        studentRoleService.createFromDto(dto)
        verifyNoMoreInteractions(studentRoleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StudentRoleDto dto = createDto()
        StudentRole studentRoleSaved = studentRoleService.updateFromDto(dto)
        verify(studentRoleRepository, times(1)).findById(studentRole.id)
        verify(studentRoleRepository, times(1)).save(studentRole)
        verifyNoMoreInteractions(studentRoleRepository)
        assertEquals(studentRole.id, studentRoleSaved.id)
        assertEquals(studentRole.code, studentRoleSaved.code)
        assertEquals(studentRole.description, studentRoleSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StudentRoleDto dto = createDto()
        StudentRole studentRoleSaved = studentRoleService.updateFromDto(dto)
        verify(studentRoleRepository, times(1)).findById(studentRole.id)
        verify(studentRoleRepository, times(1)).save(studentRole)
        verifyNoMoreInteractions(studentRoleRepository)
        assertEquals(studentRole.id, studentRoleSaved.id)
        assertEquals(studentRole.code, studentRoleSaved.code)
        assertEquals(studentRole.description, studentRoleSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentRole from null object.")
        StudentRoleDto dto = null
        studentRoleService.updateFromDto(dto)
        verifyNoMoreInteractions(studentRoleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentRoleService.delete(studentRole)
        verifyNoMoreInteractions(studentRoleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}