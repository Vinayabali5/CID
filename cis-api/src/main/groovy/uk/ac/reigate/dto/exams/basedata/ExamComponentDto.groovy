package uk.ac.reigate.dto.exams.basedata

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.ExamComponent

/**
 *
 * JSON serializable DTO containing ExamBoard data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class ExamComponentDto {
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private Integer examSeriesId
    
    @JsonProperty
    private ExamSeriesDto examSeries
    
    @JsonProperty
    private String code
    
    @JsonProperty
    private String title
    
    @JsonProperty
    private String teacherMarks
    
    @JsonProperty
    private Integer maximumMark
    
    @JsonProperty
    private String gradeset
    
    @JsonProperty
    private Date dueDate
    
    @JsonProperty
    private String timetabled
    
    @JsonProperty
    private Date timetableDate
    
    @JsonProperty
    private String timetableSession
    
    @JsonProperty
    private Integer timeAllowed
    
    /**
     * default No Args constructor
     */
    public ExamComponentDto(){}
    
    /**
     * Constructor to create a ExamComponentDto object from an ExamComponent object
     *
     * @param examComponent the ExamComponent object to use for construction
     */
    public ExamComponentDto(ExamComponent examComponent) {
        this.id = examComponent.id
        this.examSeriesId = examComponent.examSeries != null ? examComponent.examSeries.id : null
        this.examSeries = ExamSeriesDto.mapFromEntity(examComponent.examSeries)
        this.code = examComponent.code
        this.title = examComponent.title
        this.teacherMarks = examComponent.teacherMarks
        this.maximumMark = examComponent.maximumMark
        this.gradeset = examComponent.gradeset
        this.dueDate = examComponent.dueDate
        this.timetabled = examComponent.timetabled
        this.timetableDate = examComponent.timetableDate
        this.timetableSession = examComponent.timetableSession
        this.timeAllowed = examComponent.timeAllowed
    }
    
    /**
     * This static method is used to create a ExamComponentDto from a ExamComponent data object.
     *
     * @param examComponent the ExamComponent data object to use for the creation.
     * @return an ExamComponentDto object based on the ExamComponent data object supplied.
     */
    public static ExamComponentDto mapFromEntity(ExamComponent examComponent) {
        return new ExamComponentDto(examComponent)
    }
    
    /**
     * This static method is used to create a List of ExamComponentDto from a List of ExamComponent data object.
     *
     * @param examComponents the List of ExamComponent data object to use for the creation.
     * @return a List of ExamComponentDto object based on the List of ExamComponent data object supplied.
     */
    public static List<ExamComponentDto> mapFromList(List<ExamComponent> examComponents) {
        return examComponents.collect {  examComponent -> mapFromEntity(examComponent) };
    }
}