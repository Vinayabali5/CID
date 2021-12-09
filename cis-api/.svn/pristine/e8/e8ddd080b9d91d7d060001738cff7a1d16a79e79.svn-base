package uk.ac.reigate.dto.admissions;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.admissions.InterviewCategory

/**
 *
 * JSON  DTO containing InterviewCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InterviewCategoryDto {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String category;
    
    @JsonProperty
    private String description;
    /**
     * Default No Args constructor
     */
    public InterviewCategoryDto() {
    }
    
    /**
     * Constructor to create an InterviewCategoryDto object from a InterviewCategory object
     *
     * @param interviewCategory the InterviewCategory object to use for construction
     */
    InterviewCategoryDto(InterviewCategory interviewCategory) {
        if(interviewCategory != null) {
            this.id = interviewCategory.id;
            this.category = interviewCategory.category;
            this.description = interviewCategory.description;
        }
    }
    
    /**
     * This static method is used to create a InterviewCategoryDto from a InterviewCategory data object.
     *
     * @param interviewCategory the InterviewCategory data object to use for the creation.
     * @return a InterviewCategoryDto object based on the InterviewCategory data object supplied.
     */
    public static InterviewCategoryDto mapFromEntity(InterviewCategory interviewCategory) {
        return new InterviewCategoryDto(interviewCategory);
    }
    
    /**
     * This static method is used to create a List of InterviewCategoryDto from a List of InterviewCategory data object.
     *
     * @param interviewCategorys the List of InterviewCategory data object to use for the creation.
     * @return a List of InterviewCategoryDto object based on the List of InterviewCategory data object supplied.
     */
    public static List<InterviewCategoryDto> mapFromList(List<InterviewCategory> interviewCategories) {
        return interviewCategories.collect { interviewCategory ->  new InterviewCategoryDto(interviewCategory) };
    }
}
