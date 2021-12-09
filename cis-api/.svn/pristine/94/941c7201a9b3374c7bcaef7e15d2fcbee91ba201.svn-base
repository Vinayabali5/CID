package uk.ac.reigate.dto.exams.seatingplan

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.exams.seatingplan.ExamSession

import groovy.transform.EqualsAndHashCode;

/**
 *
 * JSON serializable DTO containing ExamBoard data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class ExamSessionDto {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Date date;
    
    @JsonProperty
    private String session;
    
    /**
     * default No Args constructor
     */
    public ExamSessionDto(){}
    
    /**
     * Constructor to create an ExamSessionDto object
     *     
     * @param id
     * @param date
     * @param session
     */
    public ExamSessionDto(ExamSession examSession) {
        if(examSession != null) {
            this.id = examSession.id;
            this.date = examSession.date;
            this.session = examSession.session;
        }
    }
    
    /**
     * This static method is used to create a ExamSessionDto from a ExamSession data object.
     *
     * @param examSession the ExamSession data object to use for the creation.
     * @return a ExamSessionDto object based on the ExamSession data object supplied.
     */
    public static ExamSessionDto mapFromEntity(ExamSession examSession) {
        return new ExamSessionDto(examSession);
    }
    
    /**
     * This static method is used to create a List of ExamSessionDto from a List of ExamSession data object.
     *
     * @param examSessions the List of ExamSession data object to use for the creation.
     * @return a List of ExamSessionDto object based on the List of ExamSession data object supplied.
     */
    public static List<ExamSessionDto> mapFromList(List<ExamSession> examSessions) {
        return examSessions.collect { examSession -> mapFromEntity(examSession) };
    }
}
