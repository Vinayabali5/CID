package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.StudentRole

/**
 *
 * JSON serializable DTO containing StudentRole data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentRoleDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public StudentRoleDto() {
    }
    
    /**
     * Constructor to create a StudentRoleDto object from a StudentRole object
     *
     * @param studentRole the StudentRole object to use for construction
     */
    StudentRoleDto(StudentRole studentRole) {
        if(studentRole != null) {
            this.id = studentRole.id;
            this.code = studentRole.code;
            this.description = studentRole.description;
        }
    }
    
    /**
     * This static method is used to create a StudentRoleDto from a StudentRole data object.
     *
     * @param studentRole the StudentRole data object to use for the creation.
     * @return a StudentRoleDto object based on the StudentRole data object supplied.
     */
    public static StudentRoleDto mapFromEntity(StudentRole studentRole) {
        return new StudentRoleDto(studentRole);
    }
    
    /**
     * This static method is used to create a List of StudentRoleDto from a List of StudentRole data object.
     *
     * @param studentRoles the List of StudentRole data object to use for the creation.
     * @return a List of StudentRoleDto object based on the List of StudentRole data object supplied.
     */
    public static List<StudentRoleDto> mapFromList(List<StudentRole> studentRoles) {
        return studentRoles.collect { studentRole ->  new StudentRoleDto(studentRole) };
    }
}
