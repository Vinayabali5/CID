package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.dto.ilp.ILPInterviewUpdateDto
import uk.ac.reigate.dto.ilp.LetterTypeDto
import uk.ac.reigate.dto.lookup.CorrespondenceTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
/**
 *
 * JSON serializable DTO containing Letter data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class LetterDto implements Serializable{
    
    @JsonProperty
    private Integer id
    
    @JsonProperty
    private Integer yearId
    
    @JsonProperty
    AcademicYearDto year
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    private StudentSummaryDto student
    
    @JsonProperty
    private Integer interviewId
    
    @JsonProperty
    private ILPInterviewUpdateDto interview
    
    @JsonProperty
    private Date requestedDate
    
    @JsonProperty
    private Date authorisedDate
    
    @JsonProperty
    private Date letterDate
    
    @JsonProperty
    private Date printedDate
    
    @JsonProperty
    private Integer writtenById
    
    @JsonProperty
    private Integer requestedById
    
    @JsonProperty
    private Boolean studentCopiedIn
    
    @JsonProperty
    private String subject
    
    @JsonProperty
    private String regarding
    
    @JsonProperty
    private Boolean reviewMeeting
    
    @JsonProperty
    private Boolean attendance
    
    @JsonProperty
    private Boolean behaviour
    
    @JsonProperty
    private Boolean homework
    
    @JsonProperty
    private Boolean punctuality
    
    @JsonProperty
    private Boolean focus
    
    @JsonProperty
    private Boolean deadlines
    
    @JsonProperty
    private Boolean incompleteCoursework
    
    @JsonProperty
    private Boolean insufficientProgress
    
    @JsonProperty
    private Integer nonEntryWarning
    
    @JsonProperty
    private LetterWarningParagraphDto letterWarningParagraph
    
    @JsonProperty
    private Boolean irWillAddress
    
    @JsonProperty
    private Boolean irImproveAttendance
    
    @JsonProperty
    private Boolean irImproveEffort
    
    @JsonProperty
    private Integer letterTypeId
    
    @JsonProperty
    private LetterTypeDto letterType
    
    @JsonProperty
    private Integer correspondenceTypeId
    
    @JsonProperty
    private CorrespondenceTypeDto correspondenceType
    
    @JsonProperty
    private Integer pendingId
    
    @JsonProperty
    private StaffDto pending
    
    @JsonProperty
    private Date sendAfter
    
    @JsonProperty
    private Integer processingFlag
    
    /**
     * Default No Args constructor
     */
    public LetterDto() {
    }
    
    /**
     * Constructor to create a LetterDto object from a Letter object
     *
     * @param letter the Letter object to use for construction
     */
    LetterDto(Letter letter) {
        if(letter != null) {
            this.id = letter.id;
            this.yearId = letter.year != null ? letter.year.id : null
            this.year = letter.year != null ? AcademicYearDto.mapFromEntity(letter.year) : null
            this.studentId = letter.student != null ? letter.student.id : null
            this.student = StudentSummaryDto.mapFromEntity(letter.student)
            this.interviewId = letter.interview != null ? letter.interview.id : null
            this.interview = letter.interview != null ? ILPInterviewUpdateDto.mapFromEntity(letter.interview) : null
            this.requestedDate = letter.requestedDate
            this.authorisedDate = letter.authorisedDate
            this.letterDate = letter.letterDate
            this.printedDate = letter.printedDate
            this.writtenById = letter.writtenBy != null ? letter.writtenBy.id : null
            this.requestedById = letter.requestedBy != null ? letter.requestedBy.id : null
            this.studentCopiedIn = letter.studentCopiedIn
            this.subject = letter.subject
            this.regarding = letter.regarding
            this.reviewMeeting = letter.reviewMeeting
            this.attendance = letter.attendance
            this.behaviour = letter.behaviour
            this.homework = letter.homework
            this.punctuality = letter.punctuality
            this.focus = letter.focus
            this.deadlines = letter.deadlines
            this.incompleteCoursework = letter.incompleteCoursework
            this.insufficientProgress = letter.insufficientProgress
            this.nonEntryWarning = letter.nonEntryWarning != null ? letter.nonEntryWarning.id : null
            this.letterWarningParagraph = letter.nonEntryWarning != null ? LetterWarningParagraphDto.mapFromEntity(letter.nonEntryWarning) : null
            this.irWillAddress = letter.irWillAddress
            this.irImproveAttendance = letter.irImproveAttendance
            this.irImproveEffort = letter.irImproveEffort
            this.letterTypeId = letter.letterType != null ? letter.letterType.id : null
            this.letterType = letter.letterType != null ? LetterTypeDto.mapFromEntity(letter.letterType) : null
            this.correspondenceTypeId = letter.correspondenceType != null ? letter.correspondenceType.id : null
            this.correspondenceType = letter.correspondenceType != null ? CorrespondenceTypeDto.mapFromEntity(letter.correspondenceType) : null
            this.pendingId = letter.pending != null ? letter.pending.id : null
            this.pending = letter.pending != null ? StaffDto.mapFromEntity(letter.pending) : null
            this.sendAfter = letter.sendAfter
            this.processingFlag = letter.processingFlag
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a LetterDto from a Letter data object.
     *
     * @param letter the Letter data object to use for the creation.
     * @return a LetterDto object based on the Letter data object supplied.
     */
    public static LetterDto mapFromEntity(Letter letter) {
        return  new LetterDto(letter)
    }
    
    /**
     * This static method is used to create a List of LetterDto from a List of Letter data object.
     *
     * @param letters the List of Letter data object to use for the creation.
     * @return a List of LetterDto object based on the List of Letter data object supplied.
     */
    public static List<LetterDto> mapFromList(List<Letter> letters) {
        return letters.collect { letter ->  new LetterDto(letter) };
    }
    
    /**
     * This method is used to return the AcademicYear Code for the Letter object
     *
     * @return the AcademicYear Code for the Letter object
     */
    @JsonProperty(value = "_academicYearCode")
    public String get_AcademicYearCode() {
        return this.year != null ? this.year.code : null
    }
    
    /**
     * This method is used to return the LetterWarningParagraph Description for the Letter object
     *
     * @return the LetterWarningParagraph Description for the Letter object
     */
    @JsonProperty(value = "_nonEntryWarningDescription")
    public String get_NonEntryWarningDescription() {
        return this.letterWarningParagraph != null ? this.letterWarningParagraph.description : null
    }
    
    /**
     * This method is used to return the LetterType for the Letter object
     *
     * @return the LetterType for the Letter object
     */
    @JsonProperty(value = "_letterType")
    public String get_LetterType() {
        return this.letterType != null ? this.letterType.type : null
    }
    
    /**
     * This method is used to return the correspondenceType for the Letter object
     *
     * @return the correspondenceType for the Letter object
     */
    @JsonProperty(value = "_correspondenceType")
    public String get_CorrespondenceType() {
        return this.correspondenceType != null ? this.correspondenceType.type : null
    }
    
    /**
     * This method is used to return the pendingName i.e Staff initials for the Letter object
     *
     * @return the pendingName i.e Staff initials for the Letter object
     */
    @JsonProperty(value = "_pendingName")
    public String get_PendingName() {
        return this.pending != null ? this.pending.initials : null
    }
}
