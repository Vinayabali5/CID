package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory

/**
 *
 * JSON serializable DTO containing LLDDHealthProblemCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LLDDHealthProblemCategoryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String shortDescription;
    
    @JsonProperty
    private Date validFrom;
    
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public LLDDHealthProblemCategoryDto() {
    }
    
    /**
     * Constructor to create a LLDDHealthProblemCategoryDto object from a LLDDHealthProblemCategory object
     *
     * @param lLDDHealthProblemCategory the LLDDHealthProblemCategory object to use for construction
     */
    LLDDHealthProblemCategoryDto(LLDDHealthProblemCategory lLDDHealthProblemCategory) {
        if(lLDDHealthProblemCategory != null) {
            this.id = lLDDHealthProblemCategory.id;
            this.code = lLDDHealthProblemCategory.code;
            this.description = lLDDHealthProblemCategory.description;
            this.shortDescription = lLDDHealthProblemCategory.shortDescription;
            this.validFrom = lLDDHealthProblemCategory.validFrom;
            this.validTo = lLDDHealthProblemCategory.validTo;
        }
    }
    
    
    /**
     * This static method is used to create a LLDDHealthProblemCategoryDto from a LLDDHealthProblemCategory data object.
     *
     * @param lLDDHealthProblemCategory the LLDDHealthProblemCategory data object to use for the creation.
     * @return a LLDDHealthProblemCategoryDto object based on the LLDDHealthProblemCategory data object supplied.
     */
    public static LLDDHealthProblemCategoryDto mapFromEntity(LLDDHealthProblemCategory lLDDHealthProblemCategory) {
        return new LLDDHealthProblemCategoryDto(lLDDHealthProblemCategory);
    }
    
    /**
     * This static method is used to create a List of LLDDHealthProblemCategoryDto from a List of LLDDHealthProblemCategory data object.
     *
     * @param lLDDHealthProblemCategorys the List of LLDDHealthProblemCategory data object to use for the creation.
     * @return a List of LLDDHealthProblemCategoryDto object based on the List of LLDDHealthProblemCategory data object supplied.
     */
    public static List<LLDDHealthProblemCategoryDto> mapFromList(List<LLDDHealthProblemCategory> lLDDHealthProblemCategories) {
        List<LLDDHealthProblemCategoryDto> output = lLDDHealthProblemCategories.collect { lLDDHealthProblemCategory ->  new LLDDHealthProblemCategoryDto(lLDDHealthProblemCategory) };
        return output
    }
}