package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import javax.persistence.Column

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGradeSet

/**
 *
 * JSON serializable DTO containing Level data
 *
 */

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LevelDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer possibleGradeSetId;
    
    @JsonProperty
    private Integer progressionTo
    
    @JsonProperty
    private String alisQualCode
    
    @JsonProperty
    private Boolean academic
    
    @JsonProperty
    private Integer coreAimPriority
    
    @JsonProperty
    private Boolean sarInclude
    
    @JsonProperty
    private Integer rqfLevel
    
    @JsonProperty
    private String qualificationFramework
    
    @JsonProperty
    private String dfeQualName
    
    @JsonProperty
    private Boolean inUse
    
    /**
     * Default No Args constructor
     */
    public LevelDto() {
    }
    
    /**
     * Constructor to create a LevelDto object from a Level object
     *
     * @param level the Level object to use for construction
     */
    LevelDto(Level level) {
        if(level != null) {
            this.id = level.id;
            this.code = level.code;
            this.description = level.description;
            this.possibleGradeSetId = level.possibleGradeSet != null ? level.possibleGradeSet.id : null;
            this.progressionTo = level.progressionTo;
            this.alisQualCode = level.alisQualCode;
            this.academic = level.academic
            this.coreAimPriority = level.coreAimPriority
            this.sarInclude = level.sarInclude
            this.rqfLevel = level.rqfLevel
            this.qualificationFramework = level.qualificationFramework
            this.dfeQualName = level.dfeQualName
            this.inUse = level.inUse
        }
    }
    
    /**
     * This static method is used to create a LevelDto from a Level data object.
     *
     * @param level the Level data object to use for the creation.
     * @return a LevelDto object based on the Level data object supplied.
     */
    public static LevelDto mapFromEntity(Level level) {
        return new LevelDto(level);
    }
    
    /**
     * This static method is used to create a List of LevelDto from a List of Level data object.
     *
     * @param levels the List of Level data object to use for the creation.
     * @return a List of LevelDto object based on the List of Level data object supplied.
     */
    public static List<LevelDto> mapFromList(List<Level> levels) {
        return levels.collect { level ->  new LevelDto(level) };
    }
}
