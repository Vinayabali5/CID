package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.security.Role

public class RoleDtoTest {
    
    private Role role1
    
    private Role role2
    
    private List<Role> roles
    
    @Before
    public void setup() {
        role1 = new Role(
                id: 1,
                roleName:'Staff'
                );
        role2 = new Role(
                id: 2,
                roleName:'MIS Developer'
                );
        roles = Arrays.asList(role1, role2);
    }
    
    @Test
    public void testMapFromRoleEntity(){
        RoleDto roleTest = RoleDto.mapFromEntity( role1 )
        assertEquals( roleTest.id, role1.id );
        assertEquals( roleTest.roleName, role1.roleName);
    }
    
    @Test
    public void testMapFromRolesEntities(){
        List<RoleDto> roleDtoTest = RoleDto.mapFromList( roles )
        assertEquals( roleDtoTest[0].id, role1.id );
        assertEquals( roleDtoTest[0].roleName, role1.roleName);
        assertEquals( roleDtoTest[1].id, role2.id );
        assertEquals( roleDtoTest[1].roleName, role2.roleName);
    }
    
    @Test
    public void testEquals_Same() {
        RoleDto roleDto1 = new RoleDto(role1)
        RoleDto roleDto2 = new RoleDto(role1)
        assertEquals(roleDto1, roleDto2)
    }
    
    @Test
    public void testEquals_Different() {
        RoleDto roleDto1 = new RoleDto(role1)
        RoleDto roleDto2 = new RoleDto(role2)
        assertNotEquals(roleDto1, roleDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        RoleDto roleDto1 = new RoleDto(role1)
        RoleDto roleDto2 = new RoleDto(role1)
        assertEquals(roleDto1.hashCode(), roleDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        RoleDto roleDto1 = new RoleDto(role1)
        RoleDto roleDto2 = new RoleDto(role2)
        assertNotEquals(roleDto1.hashCode(), roleDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Role() {
        RoleDto roleDto = new RoleDto(role1)
        assertEquals( roleDto.roleName, role1.roleName )
    }
}