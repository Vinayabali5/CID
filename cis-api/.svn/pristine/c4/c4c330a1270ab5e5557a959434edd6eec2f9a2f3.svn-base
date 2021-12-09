package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.GCSEScore
import uk.ac.reigate.domain.academic.Student

/**
 *
 * JSON serializable DTO containing GCSEScore data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class GCSEScoreDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer countOfQualifications;
    
    @JsonProperty
    private Integer countOfGCSEs;
    
    @JsonProperty
    private Integer passes;
    
    @JsonProperty
    private Integer passesAToC;
    
    @JsonProperty
    private Double score;
    
    @JsonProperty
    private Double average
    
    /**
     * Default No Args constructor
     */
    public GCSEScoreDto() {
    }
    
    /**
     * Constructor to create a GCSEScoreDto object from a GCSEScore object
     *
     * @param gCSEScore the GCSEScore object to use for construction
     */
    GCSEScoreDto(GCSEScore gCSEScore) {
        this.studentId = gCSEScore.student != null ? gCSEScore.student.id : null;
        this.countOfQualifications = gCSEScore.countOfQualifications;
        this.countOfGCSEs = gCSEScore.countOfGCSEs;
        this.passes = gCSEScore.passes;
        this.score = gCSEScore.score;
        this.average = gCSEScore.average;
        this.passesAToC = gCSEScore.passesAToC;
    }
    
    /**
     * This static method is used to create a GCSEScoreDto from a GCSEScore data object.
     *
     * @param gCSEScore the GCSEScore data object to use for the creation.
     * @return a GCSEScoreDto object based on the GCSEScore data object supplied.
     */
    public static GCSEScoreDto mapFromGCSEScoreEntity(GCSEScore gCSEScore) {
        GCSEScoreDto output
        if (gCSEScore != null) {
            output = new GCSEScoreDto(gCSEScore);
        } else {
            output = null
        }
        return output
    }
    
    /**
     * This static method is used to create a List of GCSEScoreDto from a List of GCSEScore data object.
     *
     * @param gCSEScores the List of GCSEScore data object to use for the creation.
     * @return a List of GCSEScoreDto object based on the List of GCSEScore data object supplied.
     */
    public static List<GCSEScoreDto> mapFromGCSEScoresEntities(List<GCSEScore> gCSEScores) {
        return gCSEScores.collect { gCSEScore ->  new GCSEScoreDto(gCSEScore) };
    }
}
