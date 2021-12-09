package uk.ac.reigate.dto;

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentPredictedGrade
import uk.ac.reigate.dto.exams.ExamBoardDto
import uk.ac.reigate.dto.lookup.PossibleGradeDto


/**
 *
 * JSON serializable DTO containing EntryQualification data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentPredictedGradeDto implements Serializable {
    
    @JsonProperty
    private Integer studentPredictedGradeId;
    
    @NotNull
    @JsonProperty
    private Integer studentId;
    
    @NotNull
    @JsonProperty
    private Integer predictedGradeId;
    
    @JsonProperty
    private String grade
    
    @JsonProperty
    private Integer examBoardId;
    
    @JsonProperty
    private ExamBoardDto examBoard;
    
    @JsonProperty
    private EntryQualificationDto _entryQualification
    
    
    /**
     * Default No Args constructor
     */
    public StudentPredictedGradeDto() {
    }
    
    /**
     * Constructor to create a StudentPredictedGradeDto object from a StudentPredictedGrade object
     *
     * @param studentPredictedGrade the StudentPredictedGrade object to use for construction
     */
    StudentPredictedGradeDto(StudentPredictedGrade studentPredictedGrade) {
        if(studentPredictedGrade != null) {
            this.studentPredictedGradeId = studentPredictedGrade.id
            this.studentId = studentPredictedGrade.student != null ? studentPredictedGrade.student.id : null;
            this.predictedGradeId = studentPredictedGrade.predictedGrade != null ? studentPredictedGrade.predictedGrade.id : null;
            this.grade = studentPredictedGrade.grade;
            this.examBoardId = studentPredictedGrade.examBoard != null ? studentPredictedGrade.examBoard.id : null;
            this.examBoard = studentPredictedGrade.examBoard != null ? ExamBoardDto.mapFromEntity(studentPredictedGrade.examBoard) : null
            this._entryQualification = studentPredictedGrade.predictedGrade != null ? EntryQualificationDto.mapFromEntity(studentPredictedGrade.predictedGrade) : null
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentPredictedGradeDto from a StudentPredictedGrade data object.
     *
     * @param studentPredictedGrade the StudentPredictedGrade data object to use for the creation.
     * @return a StudentPredictedGradeDto object based on the StudentPredictedGrade data object supplied.
     */
    public static StudentPredictedGradeDto mapFromEntity(StudentPredictedGrade studentPredictedGrade) {
        return new StudentPredictedGradeDto(studentPredictedGrade)
    }
    
    /**
     * This static method is used to create a List of StudentPredictedGradeDto from a List of StudentPredictedGrade data object.
     *
     * @param studentPredictedGrades the List of StudentPredictedGrade data object to use for the creation.
     * @return a List of StudentPredictedGradeDto object based on the List of StudentPredictedGrade data object supplied.
     */
    public static List<StudentPredictedGradeDto> mapFromList(List<StudentPredictedGrade> studentPredictedGrades) {
        return studentPredictedGrades.collect { studentPredictedGrade ->  new StudentPredictedGradeDto(studentPredictedGrade) };
    }
    
    /**
     * This method is used to return the Exam Board name for the StudentPredictedGrade object
     *
     * @return the Exam Board name for the StudentPredictedGrade object
     */
    @JsonProperty(value = "_examBoardName")
    public String get_ExamBoardName() {
        return this.examBoard != null ? this.examBoard.name : null
    }
}
