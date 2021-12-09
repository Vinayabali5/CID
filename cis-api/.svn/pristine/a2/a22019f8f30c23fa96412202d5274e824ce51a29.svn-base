package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.PossibleGrade

/**
 * This DTO object is used to provide a summarised version of the possible grade data object.
 * 
 * @author Michael Horgan
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PossibleGradeSummaryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer gradeSetId;
    
    @JsonProperty
    private String grade;
    
    /**
     * Default No Args constructor
     */
    public PossibleGradeSummaryDto() {
    }
    
    /**
     * Constructor to create a PossibleGradeSummaryDto object from a PossibleGrade object
     *
     * @param possibleGrade the PossibleGrade object to use for construction
     */
    PossibleGradeSummaryDto(PossibleGrade possibleGrade) {
        if (possibleGrade != null) {
            this.id = possibleGrade.id;
            this.gradeSetId= possibleGrade.gradeSet != null ? possibleGrade.gradeSet.id : null;
            this.grade = possibleGrade.grade;
        }
    }
    
    /**
     * This static method is used to create a PossibleGradeSummaryDto from a PossibleGrade data object.
     * 
     * @param possibleGrade the PossibleGrade data object to use for the creation.
     * @return a PossibleGradeSummaryDto object based on the PossibleGrade data object supplied.
     */
    public static PossibleGradeSummaryDto mapFromEntity(PossibleGrade possibleGrade) {
        return new PossibleGradeSummaryDto(possibleGrade)
    }
    
    /**
     * This static method is used to create a List of PossibleGradeSummaryDto from a List of PossibleGrade data object.
     *
     * @param possibleGrades the List of PossibleGrade data object to use for the creation.
     * @return a List of PossibleGradeSummaryDto object based on the List of PossibleGrade data object supplied.
     */
    public static List<PossibleGradeSummaryDto> mapFromList(List<PossibleGrade> possibleGrades) {
        return possibleGrades.collect { possibleGrade ->  new PossibleGradeSummaryDto(possibleGrade) };
    }
}
