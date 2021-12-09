package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.StudentType

/**
 *
 * JSON serializable DTO containing StudentType data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentTypeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public StudentTypeDto() {
    }
    
    /**
     * Constructor to create a StudentTypeDto object from a StudentType object
     *
     * @param studentType the StudentType object to use for construction
     */
    StudentTypeDto(StudentType studentType) {
        if(studentType != null) {
            this.id = studentType.id;
            this.code = studentType.code;
            this.description = studentType.description;
        }
    }
    
    /**
     * This static method is used to create a StudentTypeDto from a StudentType data object.
     *
     * @param studentType the StudentType data object to use for the creation.
     * @return a StudentTypeDto object based on the StudentType data object supplied.
     */
    public static StudentTypeDto mapFromEntity(StudentType studentType) {
        return new StudentTypeDto(studentType);
    }
    
    /**
     * This static method is used to create a List of StudentTypeDto from a List of StudentType data object.
     *
     * @param studentTypes the List of StudentType data object to use for the creation.
     * @return a List of StudentTypeDto object based on the List of StudentType data object supplied.
     */
    public static List<StudentTypeDto> mapFromList(List<StudentType> studentTypes) {
        return studentTypes.collect { studentType ->  new StudentTypeDto(studentType) };
    }
}
