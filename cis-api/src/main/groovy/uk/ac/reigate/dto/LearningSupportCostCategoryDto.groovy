package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.learning_support.LearningSupportCostCategory
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing LearningSupportCostCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LearningSupportCostCategoryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String category;
    
    /**
     * Default No Args constructor
     */
    public LearningSupportCostCategoryDto() {
    }
    
    /**
     * Constructor to create a LearningSupportCostCategoryDto object from a LearningSupportCostCategory object
     *
     * @param learningSupportCostCategory the LearningSupportCostCategory object to use for construction
     */
    LearningSupportCostCategoryDto(LearningSupportCostCategory learningSupportCostCategory) {
        if(learningSupportCostCategory != null) {
            this.id = learningSupportCostCategory.id;
            this.category = learningSupportCostCategory.category;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a LearningSupportCostCategoryDto from a LearningSupportCostCategory data object.
     *
     * @param learningSupportCostCategory the LearningSupportCostCategory data object to use for the creation.
     * @return a LearningSupportCostCategoryDto object based on the LearningSupportCostCategory data object supplied.
     */
    public static LearningSupportCostCategoryDto mapFromEntity(LearningSupportCostCategory learningSupportCostCategory) {
        return new LearningSupportCostCategoryDto(learningSupportCostCategory);
    }
    
    /**
     * This static method is used to create a List of LearningSupportCostCategoryDto from a List of LearningSupportCostCategory data object.
     *
     * @param learningSupportCostCategories the List of LearningSupportCostCategory data object to use for the creation.
     * @return a List of LearningSupportCostCategoryDto object based on the List of LearningSupportCostCategory data object supplied.
     */
    public static List<LearningSupportCostCategoryDto> mapFromList(List<LearningSupportCostCategory> learningSupportCostCategories) {
        return learningSupportCostCategories.collect { learningSupportCostCategory ->  new LearningSupportCostCategoryDto(learningSupportCostCategory) };
    }
}
