package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.security.Role
import uk.ac.reigate.dto.RoleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.security.RoleRepository
import uk.ac.reigate.utils.ValidationUtils

@Service
class RoleService implements ICoreDataService<Role, Integer>{
    
    @Autowired
    RoleRepository roleRepository
    
    /**
     * Default NoArgs constructor
     */
    RoleService() {}
    
    /**
     * Autowired Constructor
     *
     * @param roleRepository
     */
    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    /**
     * Find an individual role using the roles ID fields
     *
     * @param id the ID fields to search for
     * @return the Role object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all roles
     *
     * @return a SearchResult set with the list of Roles
     */
    @Override
    @Transactional(readOnly = true)
    List<Role> findAll() {
        return roleRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Role object in the database
     *
     * @param role the new Role object to be saved
     * @return the saved version of the Role object
     */
    @Override
    @Transactional
    public Role save(Role role) {
        return roleRepository.save(role)
    }
    
    /**
     * This service method is used to create a Role object in the database from a partial or complete Role object.
     *
     * @param role the partial or complete Role object to be saved
     * @return the saved version of the Role object
     */
    @Transactional
    public Role createFromDto(RoleDto roleDto) {
        if (roleDto == null) {
            throw new InvalidDataException("Cannot create roleDto from null object.")
        }
        Role role = new Role()
        role.roleName = roleDto.roleName
        role.roleDescription = roleDto.roleDescription
        return save(role)
    }
    
    /**
     * This service method is used to update an Role object in the database from a partial or complete Role object.
     *
     * @param role the partial or complete Role object to be saved
     * @return the saved version of the Role object
     */
    @Transactional
    public Role updateFromDto(RoleDto roleDto) {
        if (roleDto == null) {
            throw new InvalidDataException("Cannot update roleDto from null object.")
        }
        Role role = findById(roleDto.id);
        role.roleName = roleDto.roleName
        role.roleDescription = roleDto.roleDescription
        return save(role)
    }
    
    /**
     * Saves a list of Role objects to the database
     *
     * @param roles a list of Roles to be saved to the database
     * @return the list of save Role objects
     */
    @Transactional
    public List<Role> saveRoles(List<Role> roles) {
        return roles.collect { role -> save(role) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Role should not be deleted.
     */
    @Override
    public void delete(Role obj) {
        throw new InvalidOperationException("Role should not be deleted")
    }
}
