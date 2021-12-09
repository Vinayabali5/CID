package uk.ac.reigate.dto.ilp

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.dto.CourseGroupSummaryDto
import uk.ac.reigate.dto.LetterDto
import uk.ac.reigate.dto.StudentSummaryDto

/**
 * This class is used for most actions for ILP Interview DTO tasks. This represents a full and 
 * deep look at the ILP Interview data. Including embedded objects for Student, Interview Type, 
 * Course Group.
 * 
 * @author Michael Horgan
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields = true, callSuper = true)
public class ILPInterviewDto extends ILPInterviewBaseDto {
    
    @JsonProperty
    private StudentSummaryDto _student;
    
    @JsonProperty
    private ILPInterviewTypeDto interviewType;
    
    @JsonProperty
    private String _ilpInterviewTypeDescription
    
    @JsonProperty
    private CourseGroupSummaryDto _courseGroup
    
    @JsonProperty
    private String _staffName;
    
    @JsonProperty
    private String _staffSignature;
    
    @JsonProperty
    private LetterDto letter
    
    /**
     * Default No Args constructor
     */
    public ILPInterviewDto() {
    }
    
    /**
     * Constructor to create an ILPInterviewDto object from a ILPInterview object
     *
     * @param ilpInterview the ILPInterview object to use for construction
     */
    ILPInterviewDto(ILPInterview ilpInterview) {
        super(ilpInterview)
        this._student = ilpInterview.student != null ? StudentSummaryDto.mapFromEntity(ilpInterview.student) : null;
        this.interviewType = ilpInterview.type != null ? ILPInterviewTypeDto.mapFromEntity(ilpInterview.type) : null
        this._ilpInterviewTypeDescription = ilpInterview.type != null ? ilpInterview.type.type : ''
        this._courseGroup = ilpInterview.courseGroup != null ? CourseGroupSummaryDto.mapFromEntity(ilpInterview.courseGroup) : null;
        this._staffName = ilpInterview.staff != null && ilpInterview.staff.person != null ? ilpInterview.staff.person.firstName + ' ' + ilpInterview.staff.person.surname : null
        this._staffSignature = ilpInterview.staff != null  ? ilpInterview.staff.signature : null
        this.letter = ilpInterview.letter != null ? LetterDto.mapFromEntity(ilpInterview.letter) : null
    }
    
    /**
     * This static method is used to create a ILPInterviewDto from a ILPInterview data object.
     *
     * @param iLPInterview the ILPInterview data object to use for the creation.
     * @return a ILPInterviewDto object based on the ILPInterview data object supplied.
     */
    public static ILPInterviewDto mapFromEntity(ILPInterview ilpInterview) {
        return new ILPInterviewDto(ilpInterview)
    }
    
    /**
     * This static method is used to create a List of ILPInterviewDto from a List of ILPInterview data object.
     *
     * @param iLPInterviews the List of ILPInterview data object to use for the creation.
     * @return a List of ILPInterviewDto object based on the List of ILPInterview data object supplied.
     */
    public static List<ILPInterviewDto> mapFromList(List<ILPInterview> ilpInterviews) {
        return ilpInterviews.collect { ilpInterview ->  new ILPInterviewDto(ilpInterview) };
    }
}
