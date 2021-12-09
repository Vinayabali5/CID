package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.learning_support.StudentLLDDHealthProblemCategory

/**
 *
 * JSON serializable DTO containing lLDDHealthProblemCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentLLDDHealthProblemCategoryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer lLDDHealthProblemCategoryId;
    
    @JsonProperty
    private LLDDHealthProblemCategoryDto lLDDHealthProblemCategory;
    
    @JsonProperty
    private Boolean primarylldd;
    
    /**
     * Default No Args constructor
     */
    public StudentLLDDHealthProblemCategoryDto() {
    }
    
    /**
     * Constructor to create a StudentlLDDHealthProblemCategoryDto object from a StudentlLDDHealthProblemCategory object
     *
     * @param studentlLDDHealthProblemCategory the StudentlLDDHealthProblemCategory object to use for construction
     */
    public StudentLLDDHealthProblemCategoryDto(StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory) {
        if(studentLLDDHealthProblemCategory != null) {
            this.id = studentLLDDHealthProblemCategory.id;
            this.studentId = studentLLDDHealthProblemCategory.student != null ? studentLLDDHealthProblemCategory.student.id : null;
            this.lLDDHealthProblemCategoryId = studentLLDDHealthProblemCategory.lLDDHealthProblemCategory != null ? studentLLDDHealthProblemCategory.lLDDHealthProblemCategory.id : null;
            this.lLDDHealthProblemCategory = studentLLDDHealthProblemCategory.lLDDHealthProblemCategory != null ? LLDDHealthProblemCategoryDto.mapFromEntity(studentLLDDHealthProblemCategory.lLDDHealthProblemCategory) : null
            this.primarylldd = studentLLDDHealthProblemCategory.primarylldd;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentLLDDHealthProblemCategoryDto from a StudentLLDDHealthProblemCategory data object.
     *
     * @param studentLLDDHealthProblemCategory the StudentLLDDHealthProblemCategory data object to use for the creation.
     * @return a StudentLLDDHealthProblemCategoryDto object based on the StudentLLDDHealthProblemCategory data object supplied.
     */
    public static StudentLLDDHealthProblemCategoryDto mapFromEntity(StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory) {
        return new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory);
    }
    
    /**
     * This static method is used to create a List of StudentLLDDHealthProblemCategoryDto from a List of StudentLLDDHealthProblemCategory data object.
     *
     * @param studentLLDDHealthProblemCategories the List of StudentLLDDHealthProblemCategory data object to use for the creation.
     * @return a List of StudentLLDDHealthProblemCategoryDto object based on the List of StudentLLDDHealthProblemCategory data object supplied.
     */
    public static List<StudentLLDDHealthProblemCategoryDto> mapFromList(List<StudentLLDDHealthProblemCategory> studentLLDDHealthProblemCategories) {
        return studentLLDDHealthProblemCategories.collect { studentLLDDHealthProblemCategory ->  new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory) };
    }
    
    /**
     * This method is used to return the lLDDHealthProblemCategory description for the StudentLLDDHealthProblemCategory object
     *
     * @return the lLDDHealthProblemCategory description for the StudentLLDDHealthProblemCategory object
     */
    @JsonProperty(value = "_lLDDHealthProblemCategoryDescription")
    public String get_LLDDHealthProblemCategoryDescription() {
        return this.lLDDHealthProblemCategory != null ? this.lLDDHealthProblemCategory.description : null
    }
}
