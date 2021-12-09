package uk.ac.reigate.dto;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel

/**
 *
 * JSON serializable DTO containing InitialAssessmentLevel data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InitialAssessmentLevelDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String initialAssessmentLevel;
    
    @JsonProperty
    private String abbrv;
    
    /**
     * Default No Args constructor
     */
    public InitialAssessmentLevelDto() {
    }
    
    /**
     * Constructor to create an InitialAssessmentLevelDto object from a InitialAssessmentLevel object
     *
     * @param initialAssessmentLevel the InitialAssessmentLevel object to use for construction
     */
    InitialAssessmentLevelDto(InitialAssessmentLevel initialAssessmentLevel) {
        if(initialAssessmentLevel != null) {
            this.id = initialAssessmentLevel.id;
            this.initialAssessmentLevel = initialAssessmentLevel.initialAssessmentLevel;
            this.abbrv = initialAssessmentLevel.abbrv;
        }
    }
    
    /**
     * This static method is used to create a InitialAssessmentLevelDto from a InitialAssessmentLevel data object.
     *
     * @param initialAssessmentLevel the InitialAssessmentLevel data object to use for the creation.
     * @return a InitialAssessmentLevelDto object based on the InitialAssessmentLevel data object supplied.
     */
    public static InitialAssessmentLevelDto mapFromEntity(InitialAssessmentLevel initialAssessmentLevel) {
        return new InitialAssessmentLevelDto(initialAssessmentLevel);
    }
    
    /**
     * This static method is used to create a List of InitialAssessmentLevelDto from a List of InitialAssessmentLevel data object.
     *
     * @param initialAssessmentLevels the List of InitialAssessmentLevel data object to use for the creation.
     * @return a List of InitialAssessmentLevelDto object based on the List of InitialAssessmentLevel data object supplied.
     */
    public static List<InitialAssessmentLevelDto> mapFromList(List<InitialAssessmentLevel> initialAssessmentLevels) {
        return initialAssessmentLevels.collect { initialAssessmentLevel ->  new InitialAssessmentLevelDto(initialAssessmentLevel) };
    }
}
