package uk.ac.reigate.dto.exams.seatingplan;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatingPlan
import uk.ac.reigate.domain.exams.seatingplan.ExamSession
import uk.ac.reigate.dto.RoomDto;;;;

/**
 *
 * JSON serializable DTO containing Room data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ExamSeatingPlanDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer examSessionId;
    
    @JsonProperty
    private ExamSessionDto examSession;
    
    @JsonProperty
    private Integer roomId;
    
    @JsonProperty
    private RoomDto room;
    
    @JsonProperty
    private Integer rows;
    
    @JsonProperty
    private Integer cols;
    
    /**
     * Default No Args constructor
     */
    public ExamSeatingPlanDto() {
    }
    
    /**
     * Constructor to create a ExamSeatingPlanDto object from a ExamSeatingPlan object
     *
     * @param examSeatingPlan the ExamSeatingPlan object to use for construction
     */
    ExamSeatingPlanDto(ExamSeatingPlan examSeatingPlan) {
        if(examSeatingPlan != null) {
            this.id = examSeatingPlan.id;
            this.examSessionId = examSeatingPlan.examSession != null ? examSeatingPlan.examSession.id : null;
            this.examSession = examSeatingPlan.examSession != null ? ExamSessionDto.mapFromEntity(examSeatingPlan.examSession) : null;
            this.roomId = examSeatingPlan.room != null ? examSeatingPlan.room.id : null;
            this.room = examSeatingPlan.room != null ? RoomDto.mapFromEntity(examSeatingPlan.room) : null;
            this.rows = examSeatingPlan.rows;
            this.cols = examSeatingPlan.cols;
        }
    }
    
    /**
     * This static method is used to create a ExamSeatingPlanDto from a ExamSeatingPlan data object.
     *
     * @param examSeatingPlan the ExamSeatingPlan data object to use for the creation.
     * @return a ExamSeatingPlanDto object based on the ExamSeatingPlan data object supplied.
     */
    public static ExamSeatingPlanDto mapFromEntity(ExamSeatingPlan examSeatingPlan) {
        return new ExamSeatingPlanDto(examSeatingPlan)
    }
    
    /**
     * This static method is used to create a List of ExamSeatingPlanDto from a List of ExamSeatingPlan data object.
     *
     * @param examSeatingPlans the List of ExamSeatingPlan data object to use for the creation.
     * @return a List of ExamSeatingPlanDto object based on the List of ExamSeatingPlan data object supplied.
     */
    public static List<ExamSeatingPlanDto> mapFromList(List<ExamSeatingPlan> examSeatingPlans) {
        return examSeatingPlans.collect {  examSeatingPlan -> mapFromEntity(examSeatingPlan) };
    }
}
