package uk.ac.reigate.dto.ilp;

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.ilp.ILPInterview

/**
 * This class is used as a Base representation of an ILP Interview DTO objects. This allows for
 * all the common ILP Interview fields to be represented in the DTO object used for various forms 
 * of processing.   
 *  
 * @author Michael Horgan
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ILPInterviewBaseDto implements Serializable {
    
    @JsonProperty
    public Integer id;
    
    @JsonProperty
    public Integer academicYearId;
    
    @JsonProperty
    public Integer studentId;
    
    @JsonProperty
    @Deprecated
    public Integer typeId;
    
    @JsonProperty
    private String _letterType
    
    @JsonProperty
    public Integer courseGroupId;
    
    @JsonProperty
    public Integer staffId;
    
    @JsonProperty
    public String discussion;
    
    @JsonProperty
    public Date interviewDate;
    
    @JsonProperty
    public Date interviewTime;
    
    @JsonProperty
    public String target;
    
    @JsonProperty
    public String targetByWhen;
    
    @JsonProperty
    public Date targetByDate;
    
    @JsonProperty
    public Boolean referLip;
    
    @JsonProperty
    public Date lipReferDate;
    
    @JsonProperty
    public Boolean privateEntry;
    
    @JsonProperty
    public Integer officeAction
    
    @JsonProperty
    public String officeActionString;
    
    @JsonProperty
    public String officeNotes;
    
    @JsonProperty
    public Boolean toFile;
    
    @JsonProperty
    public Integer targetProgress;
    
    @JsonProperty
    public Date targetProgressDate;
    
    @JsonProperty
    public Integer letterId;
    
    /**
     * This fields is a boolean value that looks to see if there was a letter linked to the ILP Interview. If so 
     * then this will return as true else it will be false
     */
    @JsonProperty
    public Boolean letterSent;
    
    
    public ILPInterviewBaseDto() {
    }
    
    /**
     * Constructor to create an ILPInterviewDto object from a ILPInterview object
     *
     * @param ilpInterview the ILPInterview object to use for construction
     */
    ILPInterviewBaseDto(ILPInterview ilpInterview) {
        this.id = ilpInterview.id
        this.academicYearId =  ilpInterview.academicYear != null? ilpInterview.academicYear.id: null
        this.studentId = ilpInterview.student != null ? ilpInterview.student.id : null
        this.typeId = ilpInterview.type != null ? ilpInterview.type.id : null
        this._letterType = ilpInterview.letter != null && ilpInterview.letter.letterType != null ? ilpInterview.letter.letterType.type : ''
        this.courseGroupId = ilpInterview.courseGroup != null ? ilpInterview.courseGroup.id : null
        this.staffId = ilpInterview.staff != null ? ilpInterview.staff.id : null
        this.discussion = ilpInterview.discussion
        this.interviewDate = ilpInterview.interviewDate
        this.interviewTime = ilpInterview.interviewTime
        this.target = ilpInterview.target != null ? ilpInterview.target : null
        this.targetByWhen =  ilpInterview.targetByWhen != null ?  ilpInterview.targetByWhen : ''
        this.targetByDate = ilpInterview.targetByDate
        this.referLip = ilpInterview.referLip
        this.lipReferDate = ilpInterview.lipReferDate
        this.privateEntry = ilpInterview.privateEntry
        this.officeAction = ilpInterview.officeAction != null ? ilpInterview.officeAction.id : null
        this.officeActionString = ilpInterview.officeActionString
        this.officeNotes= ilpInterview.officeNotes
        this.toFile = ilpInterview.toFile
        this.letterSent = ilpInterview.letterSent
        this.targetProgress = ilpInterview.targetProgress
        this.targetProgressDate = ilpInterview.targetProgressDate
        this.letterId = ilpInterview.letter != null ? ilpInterview.letter.id : null
    }
}