package uk.ac.reigate.services

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

import uk.ac.reigate.domain.security.Role
import uk.ac.reigate.dto.RoleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.security.RoleRepository


class RoleServiceTest {
    
    @Mock
    private RoleRepository roleRepository;
    
    @InjectMocks
    private RoleService roleService;
    
    private Role role
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Role data object to use for the testing
     * 
     * @return a sample Role data object
     */
    Role createRole() {
        return new Role(
                id: 1,
                roleName: 'Staff',
                
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Role created at setup
     * 
     * @return a RoleDto object based on the sample Role
     */
    RoleDto createDto() {
        return new RoleDto(
                id: role.id,
                roleName: role.roleName
                )
    }
    
    /**
     * This method is used to set up the tests for the RoleService
     */
    @Before
    public void setup() {
        this.roleRepository = Mockito.mock(RoleRepository.class);
        this.roleService = new RoleService(roleRepository);
        
        role = createRole()
        
        when(roleRepository.save(any(Role.class))).thenReturn(role);
        when(roleRepository.findById(1)).thenReturn(new Optional(role));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        RoleService service = new RoleService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Role> result = roleService.findAll();
        verify(roleRepository, times(1)).findAll()
        verifyNoMoreInteractions(roleRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Role result = roleService.findById(1);
        verify(roleRepository, times(1)).findById(1)
        verifyNoMoreInteractions(roleRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Role savedRole = roleService.save(role);
        verify(roleRepository, times(1)).save(any())
        verifyNoMoreInteractions(roleRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Role> savedRoles = roleService.saveRoles([role, role]);
        verify(roleRepository, times(2)).save(role)
        verifyNoMoreInteractions(roleRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        RoleDto dto = createDto()
        Role roleSaved = roleService.createFromDto(dto)
        verify(roleRepository, times(1)).save(any(Role.class))
        verifyNoMoreInteractions(roleRepository)
        assertEquals(dto.id, role.id)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create roleDto from null object.")
        RoleDto dto = null
        roleService.createFromDto(dto)
        verifyNoMoreInteractions(roleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        RoleDto dto = createDto()
        Role roleSaved = roleService.updateFromDto(dto)
        verify(roleRepository, times(1)).findById(role.id)
        verify(roleRepository, times(1)).save(role)
        verifyNoMoreInteractions(roleRepository)
        assertEquals(role.id, roleSaved.id)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        RoleDto dto = createDto()
        Role roleSaved = roleService.updateFromDto(dto)
        verify(roleRepository, times(1)).findById(role.id)
        verify(roleRepository, times(1)).save(role)
        verifyNoMoreInteractions(roleRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update roleDto from null object.")
        RoleDto dto = null
        roleService.updateFromDto(dto)
        verifyNoMoreInteractions(roleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        roleService.delete(role)
        verifyNoMoreInteractions(roleRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}