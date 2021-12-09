package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory

/**
 *
 * JSON serializable DTO containing StudentSpecialCategoryPublic data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentSpecialCategoryPublicDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer specialCategoryId
    
    @JsonProperty
    private SpecialCategoryDto specialCategory
    
    @JsonProperty
    private Boolean specialConfirmed
    
    @JsonProperty
    private Date classificationDate
    
    @JsonProperty
    private Date closedDate
    
    @JsonProperty
    private String monitoringNotes
    
    
    /**
     * Default No Args constructor
     */
    public StudentSpecialCategoryPublicDto() {
    }
    
    /**
     * Constructor to create a StudentSpecialCategoryDto object from a StudentSpecialCategory object
     *
     * @param studentSpecialCategory the StudentSpecialCategory object to use for construction
     */
    public StudentSpecialCategoryPublicDto(StudentSpecialCategory studentSpecialCategory) {
        if(studentSpecialCategory != null) {
            this.id = studentSpecialCategory.id
            this.studentId = studentSpecialCategory.student.id
            this.specialCategoryId =  studentSpecialCategory.specialCategory != null ? studentSpecialCategory.specialCategory.id : null
            this.specialCategory = studentSpecialCategory.specialCategory != null ? SpecialCategoryDto.mapFromEntity(studentSpecialCategory.specialCategory) : null
            this.specialConfirmed = studentSpecialCategory.specialConfirmed;
            this.classificationDate= studentSpecialCategory.classificationDate;
            this.closedDate = studentSpecialCategory.closedDate;
            this.monitoringNotes = studentSpecialCategory.monitoringNotes;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentSpecialCategoryDto from a StudentSpecialCategory data object.
     *
     * @param studentSpecialCategory the StudentSpecialCategory data object to use for the creation.
     * @return a StudentSpecialCategoryDto object based on the StudentSpecialCategory data object supplied.
     */
    public static StudentSpecialCategoryPublicDto mapFromEntity(StudentSpecialCategory studentSpecialCategory) {
        return new StudentSpecialCategoryPublicDto(studentSpecialCategory)
    }
    
    /**
     * This static method is used to create a List of StudentSpecialCategoryDto from a List of StudentSpecialCategory data object.
     *
     * @param studentSpecialCategories the List of StudentSpecialCategory data object to use for the creation.
     * @return a List of StudentSpecialCategoryDto object based on the List of StudentSpecialCategory data object supplied.
     */
    public static List<StudentSpecialCategoryPublicDto> mapFromList(List<StudentSpecialCategory> studentSpecialCategories) {
        return studentSpecialCategories.collect { studentSpecialCategory ->  new StudentSpecialCategoryPublicDto(studentSpecialCategory) };
    }
    
    /**
     * This method is used to return the SpecialCategory Code for the StudentSpecialCategory object
     *
     * @return the SpecialCategory Code for the StudentSpecialCategory object
     */
    @JsonProperty(value = "_specialCategoryCode")
    public String get_SpecialCategoryCode() {
        return this.specialCategory != null ? this.specialCategory.code : null
    }
}
