package uk.ac.reigate.dto.lookup;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.lookup.PossibleGradeSet

/**
 *
 * JSON serializable DTO containing PossibleGradeSet data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PossibleGradeSetDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private List<PossibleGradeDto> grades;
    
    /**
     * Default No Args constructor
     */
    public PossibleGradeSetDto() {
    }
    
    /**
     * Constructor to create a PossibleGradeSetDto object from a PossibleGradeSet object
     *
     * @param possibleGradeSet the PossibleGradeSet object to use for construction
     */
    PossibleGradeSetDto(PossibleGradeSet possibleGradeSet) {
        if(possibleGradeSet != null) {
            this.id = possibleGradeSet.id;
            this.code = possibleGradeSet.code;
            this.description = possibleGradeSet.description;
            this.grades = possibleGradeSet.grades.collect { return new PossibleGradeDto(it) };
        }
    }
    
    /**
     * This static method is used to create a PossibleGradeSetDto from a PossibleGradeSet data object.
     *
     * @param possibleGradeSet the PossibleGradeSet data object to use for the creation.
     * @return a PossibleGradeSetDto object based on the PossibleGradeSet data object supplied.
     */
    public static PossibleGradeSetDto mapFromEntity(PossibleGradeSet possibleGradeSet) {
        return new PossibleGradeSetDto(possibleGradeSet);
    }
    
    /**
     * This static method is used to create a List of PossibleGradeSetDto from a List of PossibleGradeSet data object.
     *
     * @param possibleGradeSets the List of PossibleGradeSet data object to use for the creation.
     * @return a List of PossibleGradeSetDto object based on the List of PossibleGradeSet data object supplied.
     */
    public static List<PossibleGradeSetDto> mapFromList(List<PossibleGradeSet> possibleGradeSets) {
        return possibleGradeSets.collect { possibleGradeSet ->  new PossibleGradeSetDto(possibleGradeSet) };
    }
}
