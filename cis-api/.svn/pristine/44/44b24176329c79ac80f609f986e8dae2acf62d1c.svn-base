package uk.ac.reigate.dto;

import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentEntryQualification
import uk.ac.reigate.dto.exams.ExamBoardDto


/**
 *
 * JSON serializable DTO containing EntryQualification data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentEntryQualificationDto implements Serializable {
    
    @JsonProperty
    private Integer studentEntryQualificationId;
    
    @NotNull
    @JsonProperty
    private Integer studentId;
    
    @NotNull
    @JsonProperty
    private Integer entryQualificationId;
    
    @NotNull
    @JsonProperty
    private Date date;
    
    @JsonProperty
    private String grade
    
    @JsonProperty
    private boolean checked;
    
    @JsonProperty
    private Integer examBoardId;
    
    @JsonProperty
    private ExamBoardDto examBoard;
    
    @JsonProperty
    private EntryQualificationDto _entryQualification;
    
    
    /**
     * Default No Args constructor
     */
    public StudentEntryQualificationDto() {
    }
    
    /**
     * Constructor to create a StudentEntryQualificationDto object from a StudentEntryQualification object
     *
     * @param studentEntryQualification the StudentEntryQualification object to use for construction
     */
    StudentEntryQualificationDto(StudentEntryQualification studentEntryQualification) {
        if(studentEntryQualification != null) {
            this.studentEntryQualificationId = studentEntryQualification.id
            this.studentId = studentEntryQualification.student != null ? studentEntryQualification.student.id : null;
            this.entryQualificationId = studentEntryQualification.qualification != null ? studentEntryQualification.qualification.id : null;
            this.date = studentEntryQualification.date;
            this.grade = studentEntryQualification.grade;
            this.checked = studentEntryQualification.checked;
            this.examBoardId = studentEntryQualification.examBoard != null ? studentEntryQualification.examBoard.id : null;
            this.examBoard = studentEntryQualification.examBoard != null ? ExamBoardDto.mapFromEntity(studentEntryQualification.examBoard) : null
            this._entryQualification = studentEntryQualification.qualification != null ? EntryQualificationDto.mapFromEntity(studentEntryQualification.qualification) : null
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentEntryQualificationDto from a StudentEntryQualification data object.
     *
     * @param studentEntryQualification the StudentEntryQualification data object to use for the creation.
     * @return a StudentEntryQualificationDto object based on the StudentEntryQualification data object supplied.
     */
    public static StudentEntryQualificationDto mapFromEntity(StudentEntryQualification studentEntryQualification) {
        return new StudentEntryQualificationDto(studentEntryQualification)
    }
    
    /**
     * This static method is used to create a List of StudentEntryQualificationDto from a List of StudentEntryQualification data object.
     *
     * @param studentEntryQualifications the List of StudentEntryQualification data object to use for the creation.
     * @return a List of StudentEntryQualificationDto object based on the List of StudentEntryQualification data object supplied.
     */
    public static List<StudentEntryQualificationDto> mapFromList(List<StudentEntryQualification> studentEntryQualifications) {
        return studentEntryQualifications.collect { studentEntryQualification ->  new StudentEntryQualificationDto(studentEntryQualification) };
    }
    
    /**
     * This method is used to return the Exam Board name for the StudentEntryQualification object
     *
     * @return the Exam Board name for the StudentEntryQualification object
     */
    @JsonProperty(value = "_examBoardName")
    public String get_ExamBoardName() {
        return this.examBoard != null ? this.examBoard.name : null
    }
}
