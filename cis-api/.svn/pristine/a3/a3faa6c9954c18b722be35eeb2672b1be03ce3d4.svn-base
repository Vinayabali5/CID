package uk.ac.reigate.dto.exams.basedata

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.dto.AcademicYearDto
import uk.ac.reigate.dto.exams.ExamBoardDto

/**
 *
 * JSON serializable DTO containing ExamBoard data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ExamSeriesDto implements Serializable{
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer examBoardId;
    
    @JsonProperty
    private ExamBoardDto examBoard;
    
    @JsonProperty
    private String examYear;
    
    @JsonProperty
    private String examSeries;
    
    @JsonProperty
    private Boolean entrySubmitted;
    
    @JsonProperty
    private Integer nextSequenceNo;
    
    @JsonProperty
    private Integer academicYearId;
    
    @JsonProperty
    private AcademicYearDto academicYear
    
    @JsonProperty
    private String _academicYearDesc;
    
    /**
     * Default No Args constructor    
     */
    public ExamSeriesDto(){}
    
    /**
     * Constructor to create an Exam ExamSeriesDto object
     * 
     * @param examSeries
     */
    public ExamSeriesDto(ExamSeries examSeries) {
        if(examSeries != null) {
            this.id = examSeries.id;
            this.examBoardId = examSeries.examBoard != null ? examSeries.examBoard.id : null;
            this.examBoard = examSeries.examBoard != null ? ExamBoardDto.mapFromEntity(examSeries.examBoard) : null;
            this.examYear = examSeries.examYear;
            this.examSeries = examSeries.examSeries;
            this.entrySubmitted = examSeries.entrySubmitted;
            this.academicYearId =  examSeries.academicYear != null ? examSeries.academicYear.id : null;
            this.academicYear = examSeries.academicYear != null ? AcademicYearDto.mapFromEntity(examSeries.academicYear) : null;
            this.nextSequenceNo = examSeries.nextSequenceNo;
        } else {
            return null
        }
    }
    
    /**
     * This method is used to convert a single ExamSeries object into and ExamSeriesDto object.
     * 
     * @param examSeries An ExamSeries object
     * @return An ExamSeriesDto object
     */
    public static ExamSeriesDto mapFromEntity(ExamSeries examSeries) {
        return new ExamSeriesDto(examSeries)
    }
    
    /**
     * This method is used to convert a List of ExamSeries objects into a List of ExamSeriesDto
     * objects.
     *
     * @param examSeriesList A List of ExamSeries objects
     * @return A List of ExamSeriesDto objects
     */
    public static List<ExamSeriesDto> mapFromList(List<ExamSeries> examSeriesList) {
        return examSeriesList.collect { examSeries -> new ExamSeriesDto(examSeries) };
    }
    
    /**
     * This method is used to return the Exam board description for the Course object
     *
     * @return the Exam board description for the Course object
     */
    @JsonProperty(value = "_academicYearDesc")
    public String get_AcademicYearDesc() {
        return this.academicYear != null ? this.academicYear.description : null
    }
}
