package uk.ac.reigate.dto.exams;

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.exams.ExamBoard

/**
 *
 * JSON serializable DTO containing ExamBoard data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ExamBoardDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String boardCode;
    
    @JsonProperty
    private String boardCentreNumber;
    
    @JsonProperty
    private String boardIdentifier;
    
    @JsonProperty
    private String telephoneNo
    
    /**
     * Default No Args constructor
     */
    ExamBoardDto() {}
    
    /**
     * Constructor that uses the ExamBoard object from the cis-data project
     * 
     * @param examBoard The ExamBoard object to use for the DTO 
     */
    ExamBoardDto(ExamBoard examBoard) {
        if (examBoard != null) {
            this.id = examBoard.id;
            this.name = examBoard.name;
            this.description = examBoard.description;
            this.boardCode = examBoard.boardCode;
            this.boardCentreNumber = examBoard.boardCentreNumber;
            this.boardIdentifier = examBoard.boardIdentifier;
            this.telephoneNo = examBoard.telephoneNo;
        }
    }
    
    /**
     * This static method is used to create a ExamBoardDto from a ExamBoard data object.
     *
     * @param examBoard the ExamBoard data object to use for the creation.
     * @return a ExamBoardDto object based on the ExamBoard data object supplied.
     */
    public static ExamBoardDto mapFromEntity(ExamBoard examBoard) {
        return new ExamBoardDto(examBoard);
    }
    
    /**
     * This static method is used to create a List of ExamBoardDto from a List of ExamBoard data object.
     *
     * @param examBoards the List of ExamBoard data object to use for the creation.
     * @return a List of ExamBoardDto object based on the List of ExamBoard data object supplied.
     */
    public static List<ExamBoardDto> mapFromList(List<ExamBoard> examBoards) {
        return examBoards.collect { examBoard ->  new ExamBoardDto(examBoard) };
    }
}
