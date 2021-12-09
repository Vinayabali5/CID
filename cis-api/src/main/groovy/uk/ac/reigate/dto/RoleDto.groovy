package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.security.Role

/**
 *
 * JSON serializable DTO containing Role data
 *
 */

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class RoleDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String roleName;
    
    @JsonProperty
    private String roleDescription
    
    /**
     * Default No Args constructor
     */
    public RoleDto() {
    }
    
    /**
     * Constructor to create a RoleDto object from a Role object
     *
     * @param role the Role object to use for construction
     */
    RoleDto(Role role) {
        this.id = role.id;
        this.roleName = role.roleName;
        this.roleDescription = role.roleDescription;
    }
    
    /**
     * This static method is used to create a RoleDto from a Role data object.
     *
     * @param role the Role data object to use for the creation.
     * @return a RoleDto object based on the Role data object supplied.
     */
    public static RoleDto mapFromEntity(Role role) {
        return new RoleDto(role);
    }
    
    /**
     * This static method is used to create a List of RoleDto from a List of Role data object.
     *
     * @param roles the List of Role data object to use for the creation.
     * @return a List of RoleDto object based on the List of Role data object supplied.
     */
    public static List<RoleDto> mapFromList(List<Role> roles) {
        List<RoleDto> output = roles.collect { role ->  new RoleDto(role) };
        return output
    }
}