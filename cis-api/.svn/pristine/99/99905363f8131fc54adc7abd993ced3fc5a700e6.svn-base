package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.SpecialCategory

/**
 *
 * JSON serializable DTO containing SpecialCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class SpecialCategoryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String details;
    
    @JsonProperty
    private Integer priority
    
    @JsonProperty
    private Boolean sendEmail
    
    /**
     * Default No Args constructor
     */
    public SpecialCategoryDto() {
    }
    
    /**
     * Constructor to create a SpecialCategoryDto object from a SpecialCategory object
     *
     * @param specialCategory the SpecialCategory object to use for construction
     */
    public SpecialCategoryDto(SpecialCategory specialCategory) {
        if(specialCategory != null) {
            this.id = specialCategory.id;
            this.code = specialCategory.code;
            this.description = specialCategory.description;
            this.details = specialCategory.details;
            this.priority = specialCategory.priority;
            this.sendEmail = specialCategory.sendEmail;
        }
    }
    
    /**
     * This static method is used to create a SpecialCategoryDto from a SpecialCategory data object.
     *
     * @param specialCategory the SpecialCategory data object to use for the creation.
     * @return a SpecialCategoryDto object based on the SpecialCategory data object supplied.
     */
    public static SpecialCategoryDto mapFromEntity(SpecialCategory specialCategory) {
        return new SpecialCategoryDto(specialCategory);
    }
    
    /**
     * This static method is used to create a List of SpecialCategoryDto from a List of SpecialCategory data object.
     *
     * @param specialCategories the List of SpecialCategory data object to use for the creation.
     * @return a List of SpecialCategoryDto object based on the List of SpecialCategory data object supplied.
     */
    public static List<SpecialCategoryDto> mapFromList(List<SpecialCategory> specialCategories) {
        return specialCategories.collect { specialCategory ->  new SpecialCategoryDto(specialCategory) };
    }
}
