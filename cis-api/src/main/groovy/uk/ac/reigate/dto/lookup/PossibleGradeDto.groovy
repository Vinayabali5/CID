package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.PossibleGrade

/**
 *
 * JSON serializable DTO containing PossibleGrades data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PossibleGradeDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer gradeSetId;
    
    //@JsonProperty
    //private PossibleGradeSetDto _possibleGradeSet;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String grade;
    
    @JsonProperty
    private Integer ucasPoints;
    
    @JsonProperty
    private boolean useForKeyAssessment;
    
    @JsonProperty
    private Float alisPoints;
    
    @JsonProperty
    private Float alpsPoints;
    
    /**
     * Default No Args constructor
     */
    public PossibleGradeDto() {
    }
    
    /**
     * Constructor to create a PossibleGradeDto object from a PossibleGrade object
     *
     * @param possibleGrade the PossibleGrade object to use for construction
     */
    PossibleGradeDto(PossibleGrade possibleGrade) {
        if(possibleGrade != null) {
            this.id = possibleGrade.id;
            this.gradeSetId= possibleGrade.gradeSet != null ? possibleGrade.gradeSet.id : null;
            this.code = possibleGrade.code;
            this.description = possibleGrade.description;
            this.grade = possibleGrade.grade;
            this.ucasPoints = possibleGrade.ucasPoints;
            this.useForKeyAssessment = possibleGrade.useForKeyAssessment;
            //this._possibleGradeSet =  new PossibleGradeSetDto(possibleGrade.gradeSet)
            this.alisPoints = possibleGrade.alisPoints;
            this.alpsPoints = possibleGrade.alpsPoints;
        }
    }
    
    /**
     * This static method is used to create a PossibleGradeDto from a PossibleGrade data object.
     * 
     * @param possibleGrade the PossibleGrade data object to use for the creation.
     * @return a PossibleGradeDto object based on the PossibleGrade data object supplied.
     */
    public static PossibleGradeDto mapFromEntity(PossibleGrade possibleGrade) {
        return new PossibleGradeDto(possibleGrade)
    }
    
    /**
     * This static method is used to create a List of PossibleGradeDto from a List of PossibleGrade data object.
     *
     * @param possibleGrades the List of PossibleGrade data object to use for the creation.
     * @return a List of PossibleGradeDto object based on the List of PossibleGrade data object supplied.
     */
    public static List<PossibleGradeDto> mapFromList(List<PossibleGrade> possibleGrades) {
        return possibleGrades.collect { possibleGrade ->  new PossibleGradeDto(possibleGrade) };
    }
}
