package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.learning_support.LearningSupportVisit
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing LearningSupportVisit data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LearningSupportVisitDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Date date;
    
    @JsonProperty
    private Integer duration
    
    @JsonProperty
    private String details
    
    @JsonProperty
    private Date time;
    
    
    /**
     * Default No Args constructor
     */
    public LearningSupportVisitDto() {
    }
    
    /**
     * Constructor to create a LearningSupportVisitDto object from a LearningSupportVisit object
     *
     * @param learningSupportVisit the LearningSupportVisit object to use for construction
     */
    LearningSupportVisitDto(LearningSupportVisit learningSupportVisit) {
        if(learningSupportVisit != null) {
            this.id = learningSupportVisit.id;
            this.studentId = learningSupportVisit.student != null ? learningSupportVisit.student.id : null;
            this.date = learningSupportVisit.date;
            this.duration = learningSupportVisit.duration;
            this.details = learningSupportVisit.details;
            this.time = learningSupportVisit.time;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a LearningSupportVisitDto from a LearningSupportVisit data object.
     *
     * @param learningSupportVisit the LearningSupportVisit data object to use for the creation.
     * @return a LearningSupportVisitDto object based on the LearningSupportVisit data object supplied.
     */
    public static LearningSupportVisitDto mapFromEntity(LearningSupportVisit learningSupportVisit) {
        return new LearningSupportVisitDto(learningSupportVisit)
    }
    
    /**
     * This static method is used to create a List of LearningSupportVisitDto from a List of LearningSupportVisit data object.
     *
     * @param learningSupportVisits the List of LearningSupportVisit data object to use for the creation.
     * @return a List of LearningSupportVisitDto object based on the List of LearningSupportVisit data object supplied.
     */
    public static List<LearningSupportVisitDto> mapFromList(List<LearningSupportVisit> learningSupportVisits) {
        List<LearningSupportVisitDto> output = learningSupportVisits.collect { learningSupportVisit ->  new LearningSupportVisitDto(learningSupportVisit) };
        return output
    }
}