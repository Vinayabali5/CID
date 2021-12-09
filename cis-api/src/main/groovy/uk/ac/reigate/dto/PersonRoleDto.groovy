package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.PersonRole

/**
 *
 * JSON serializable DTO containing Person data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PersonRoleDto implements Serializable {
    
    @JsonProperty
    private Integer personId;
    
    @JsonProperty
    private Integer roleId;
    
    @JsonProperty
    private RoleDto role;
    
    
    /**
     * Default No Args constructor
     */
    public PersonRoleDto() {
    }
    
    /**
     * Constructor to create a PersonDto object from a Person object
     *
     * @param person the Person object to use for construction
     */
    PersonRoleDto(PersonRole personRole){
        if(personRole != null) {
            this.personId = personRole.person != null ? personRole.person.id : null;
            this.roleId = personRole.role != null ? personRole.role.id : null;
            this.role = personRole.role != null ? RoleDto.mapFromEntity(personRole.role) : null;
        }
    }
    
    /**
     * This static method is used to create a PersonRoleDto from a Person data object.
     *
     * @param person the PersonRole data object to use for the creation.
     * @return a PersonDto object based on the Person data object supplied.
     */
    public static PersonRoleDto mapFromEntity(PersonRole person) {
        return new PersonRoleDto(person)
    }
    
    /**
     * This static method is used to create a List of PersonRoleDto from a List of PersonRole data object.
     *
     * @param People the List of PersonRole data object to use for the creation.
     * @return a List of PersonRoleDto object based on the List of PersonRole data object supplied.
     */
    public static List<PersonRoleDto> mapFromList(List<PersonRole> people) {
        return people.collect { person ->  mapFromEntity(person) };
    }
}
