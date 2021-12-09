package uk.ac.reigate.dto.exams

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.exams.StudentAlternativeUci


@JsonSerialize
@EqualsAndHashCode(includeFields=true)

class StudentAlternativeUciDto {
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    Integer examBoardId
    
    @JsonProperty
    ExamBoardDto examBoard
    
    @JsonProperty
    String alternativeUci
    
    /**
     * Default No Args constructor
     */
    StudentAlternativeUciDto() {}
    
    /**
     * Constructor to create a StudentAlternativeUciDto object from a StudentAlternativeUci object
     *
     * @param StudentAlternativeUci object to use for construction
     */
    StudentAlternativeUciDto(StudentAlternativeUci studentAlternativeUci){
        this.studentId = studentAlternativeUci.student.id
        this.examBoardId = studentAlternativeUci.examBoard.id
        this.alternativeUci = studentAlternativeUci.alternativeUci
        this.examBoard = ExamBoardDto.mapFromEntity(studentAlternativeUci.examBoard)
    }
    
    /**
     * This static method is used to create a StudentAlternativeUciDto from a StudentAlternativeUci data object.
     *
     * @param studentAlternativeUci the StudentAlternativeUci data object to use for the creation.
     * @return a StudentAlternativeUciDto object based on the StudentAlternativeUci data object supplied.
     */
    public static List<StudentAlternativeUciDto> mapFromList(List<StudentAlternativeUciDto> studentAlternativeUcis) {
        return studentAlternativeUcis.collect { studentAlternativeUci ->  new StudentAlternativeUciDto(studentAlternativeUci) };
    }
    
    /**
     * This static method is used to create a List of StudentAlternativeUciDto from a List of StudentAlternativeUci data object.
     *
     * @param studentAlternativeUcis the List of StudentAlternativeUci data object to use for the creation.
     * @return a List of StudentAlternativeUciDto object based on the List of StudentAlternativeUci data object supplied.
     */
    public static StudentAlternativeUciDto mapFromEntity(StudentAlternativeUci studentAlternativeUci) {
        return new StudentAlternativeUciDto(studentAlternativeUci)
    }
    
    /**
     * This method is used to return the Exam Board BroardIdentifier description for the StudentAlternativeUci object
     *
     * @return the Exam Board BoardIdentifier for the StudentAlternativeUci object
     */
    @JsonProperty(value = "_examBoardIdentifier")
    public String get_ExamBoardIdentifier() {
        return this.examBoard.boardIdentifier
    }
    
    /**
     * This method is used to return the Exam Board name for the StudentAlternativeUci object.
     * 
     * @return the Exam Board name for the StudentAlternativeUci object.
     */
    @JsonProperty(value = "_examBoardName")
    public String get_ExamBoardName() {
        return this.examBoard.name
    }
    
    /**
     * This method is used to return the Exam Board description for the StudentAlternativeUci object
     * 
     * @return the Exam Board description for the StudentAlternativeUci object.
     */
    @JsonProperty(value = "_examBoardDescription")
    public String get_ExamBoardDescription() {
        return this.examBoard.description
    }
}
