package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.StudentRemarkPermission

/**
 *
 * JSON serializable DTO containing StudentRemarkPermission data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentRemarkPermissionDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public StudentRemarkPermissionDto() {
    }
    
    /**
     * Constructor to create a StudentRemarkPermissionDto object from a StudentRemarkPermission object
     *
     * @param studentRemarkPermission the StudentRemarkPermission object to use for construction
     */
    StudentRemarkPermissionDto(StudentRemarkPermission studentRemarkPermission) {
        if(studentRemarkPermission != null) {
            this.id = studentRemarkPermission.id;
            this.code = studentRemarkPermission.code;
            this.description = studentRemarkPermission.description;
        }
    }
    
    /**
     * This static method is used to create a StudentRemarkPermissionDto from a StudentRemarkPermission data object.
     *
     * @param studentRemarkPermission the StudentRemarkPermission data object to use for the creation.
     * @return a StudentRemarkPermissionDto object based on the StudentRemarkPermission data object supplied.
     */
    public static StudentRemarkPermissionDto mapFromEntity(StudentRemarkPermission studentRemarkPermission) {
        return new StudentRemarkPermissionDto(studentRemarkPermission);
    }
    
    /**
     * This static method is used to create a List of StudentRemarkPermissionDto from a List of StudentRemarkPermission data object.
     *
     * @param studentRemarkPermissions the List of StudentRemarkPermission data object to use for the creation.
     * @return a List of StudentRemarkPermissionDto object based on the List of StudentRemarkPermission data object supplied.
     */
    public static List<StudentRemarkPermissionDto> mapFromList(List<StudentRemarkPermission> studentRemarkPermissions) {
        return studentRemarkPermissions.collect { studentRemarkPermission ->  new StudentRemarkPermissionDto(studentRemarkPermission) };
    }
}
