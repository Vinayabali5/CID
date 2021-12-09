package uk.ac.reigate.dto.exams

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.exams.Results
import uk.ac.reigate.dto.AcademicYearDto
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class ResultsDto {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    Integer academicYearId
    
    @JsonProperty
    AcademicYearDto academicYear
    
    @JsonProperty
    Integer candidateNo
    
    @JsonProperty
    String boardIdentifier
    
    @JsonProperty
    Integer examBoardId
    
    @JsonProperty
    ExamBoardDto examBoard
    
    @JsonProperty
    String examSeries
    
    @JsonProperty
    String examYear
    
    @JsonProperty
    String resultCode
    
    @JsonProperty
    Integer examOptionId
    
    @JsonProperty
    ExamOptionDto examOption
    
    @JsonProperty
    String score
    
    @JsonProperty
    String grade
    
    @JsonProperty
    Date importDate
    
    @JsonProperty
    Date examDate
    
    /**
     * Default NoArgs constructor.
     */
    ResultsDto(){}
    
    /**
     * Constructor to create ResultsDto from a Results data object.
     * 
     * @param results the Results data object to use to create the ResultsDto 
     */
    ResultsDto(Results results){
        this.id = results.id
        this.studentId = results.student.id
        this.academicYearId = results.academicYear != null ? results.academicYear.id : null
        this.candidateNo = results.candidateNo
        this.boardIdentifier= results.examBoard != null ? results.examBoard.boardIdentifier : null
        this.examSeries = results.examSeries
        this.examYear = results.examYear
        this.resultCode = results.resultsCode
        this.score = results.score
        this.grade = results.grade
        this.examDate =  results.examDate
        this.importDate =  results.importDate
        this.academicYear = results.academicYear != null ? AcademicYearDto.mapFromEntity(results.academicYear) : null
        this.examBoard = results.examBoard != null ? ExamBoardDto.mapFromEntity(results.examBoard) : null
        this.examOptionId = results.examOption != null ? results.examOption.id : null
        this.examOption = results.examOption != null ? ExamOptionDto.mapFromEntity(results.examOption) : null
    }
    
    /**
     * This static method is used to create a ResultsDto from a Results data object.
     *
     * @param results the Results data object to use for the creation.
     * @return a ResultsDto object based on the Results data object supplied.
     */
    public static ResultsDto mapFromEntity(Results results) {
        return new ResultsDto(results)
    }
    
    /**
     * This method is used to create a List of ResultsDto object from a List of Results data objects.
     * 
     * @param resultList a List of Results data objects.
     * @return a List of ResultsDto data objects.
     */
    public static List<ResultsDto> mapFromList(List<Results> resultList){
        return resultList.collect { result ->  new ResultsDto(result) };
    }
    
    /**
     * This method is used to return the academicYear code for the Results object.
     */
    @JsonProperty(value = "_academicYearCode")
    public String get_AcademicYearCode() {
        return this.academicYear != null ? this.academicYear.code : null
    }
    
    /**
     * This method is used to return the board name for the Results object.
     */
    @JsonProperty(value = "_boardName")
    public String get_BoardName() {
        return this.examBoard != null ? this.examBoard.name : null
    }
    
    /**
     * This method is used to return the option title for the Results object.
     */
    @JsonProperty(value = "_examOptionTitle")
    public String get_examOptionTitle() {
        return this.examOption != null ? this.examOption.optionTitle : null
    }
}
