package uk.ac.reigate.dto.exams;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.domain.exams.edi.StatusType
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto
import uk.ac.reigate.dto.exams.basedata.ExamSeriesDto
import uk.ac.reigate.dto.exams.edi.EdiStatusTypeDto
import uk.ac.reigate.dto.exams.edi.StatusTypeDto

/**
 *
 * JSON serializable DTO containing ReferralReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentOptionEntryDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer examOptionId;
    
    @JsonProperty
    private ExamOptionDto examOption
    
    @JsonProperty
    private Integer statusTypeId
    
    @JsonProperty
    private StatusTypeDto statusType
    
    @JsonProperty
    private Integer ediStatusTypeId
    
    @JsonProperty
    private EdiStatusTypeDto ediStatusType
    
    @JsonProperty
    private Boolean resit;
    
    @JsonProperty
    private Boolean privateStudent
    
    @JsonProperty
    private Integer _optionYearId;
    
    @JsonProperty
    private ExamBoardDto _examBoard
    
    @JsonProperty
    private ExamSeriesDto _examSeries
    
    /**
     * Default No Args constructor
     */
    public StudentOptionEntryDto() {
    }
    
    /**
     * Constructor to create a StudentOptionEntryDto object from a StudentOptionEntry object
     *
     */
    public StudentOptionEntryDto(Student student, ExamOption examOption, StatusType statusType, EdiStatusType ediStatusType, Boolean resit, Boolean privateStudent) {
        this.studentId = student.id;
        this.examOptionId = examOption.id;
        this.statusTypeId = statusType.id;
        this.ediStatusType = ediStatusType.id;
        this.resit = resit;
        this.privateStudent = privateStudent;
    }
    
    /**
     * Constructor to create a StudentOptionEntryDto object from a StudentOptionEntry object
     *
     * @param StudentOptionEntry object to use for construction
     */
    public StudentOptionEntryDto(StudentOptionEntry studentOptionEntry) {
        this.studentId = studentOptionEntry.student.id;
        this.examOptionId = studentOptionEntry.examOption.id;
        this.examOption = ExamOptionDto.mapFromEntity(studentOptionEntry.examOption)
        this.statusTypeId = studentOptionEntry.statusType != null ? studentOptionEntry.statusType.id : null
        this.statusType = studentOptionEntry.statusType != null ? StatusTypeDto.mapFromEntity(studentOptionEntry.statusType) : null
        this.ediStatusTypeId = studentOptionEntry.ediStatusType != null ? studentOptionEntry.ediStatusType.id : null;
        this.ediStatusType = studentOptionEntry.ediStatusType != null ? EdiStatusTypeDto.mapFromEntity(studentOptionEntry.ediStatusType) : null
        this.resit = studentOptionEntry.resit;
        this.privateStudent = studentOptionEntry.privateStudent;
        this._examBoard = studentOptionEntry.examOption.syllabus != null && studentOptionEntry.examOption.syllabus.examSeries != null && studentOptionEntry.examOption.syllabus.examSeries.examBoard != null ? ExamBoardDto.mapFromEntity(studentOptionEntry.examOption.syllabus.examSeries.examBoard) : null;
        this._optionYearId = studentOptionEntry.examOption.syllabus != null && studentOptionEntry.examOption.syllabus.examSeries != null && studentOptionEntry.examOption.syllabus.examSeries.academicYear != null ? studentOptionEntry.examOption.syllabus.examSeries.academicYear.id : null;
        this._examSeries = studentOptionEntry.examOption.syllabus != null && studentOptionEntry.examOption.syllabus.examSeries != null ? ExamSeriesDto.mapFromEntity(studentOptionEntry.examOption.syllabus.examSeries) : null
    }
    
    /**
     * This static method is used to create a StudentOptionEntryDto from a StudentOptionEntry data object.
     *
     * @param studentOptionEntry the StudentOptionEntry data object to use for the creation.
     * @return a StudentOptionEntryDto object based on the StudentOptionEntry data object supplied.
     */
    public static StudentOptionEntryDto mapFromEntity(StudentOptionEntry studentOptionEntry) {
        return new StudentOptionEntryDto(studentOptionEntry)
    }
    
    /**
     * This static method is used to create a List of StudentOptionEntryDto from a List of StudentOptionEntry data object.
     *
     * @param studentOptionEntry the List of StudentOptionEntry data object to use for the creation.
     * @return a List of StudentOptionentryDto object based on the List of StudentOptionEntry data object supplied.
     */
    public static List<StudentOptionEntryDto> mapFromList(List<StudentOptionEntry> studentOptionEntries) {
        return studentOptionEntries.collect { studentOptionEntry ->  new StudentOptionEntryDto(studentOptionEntry) };
    }
    
    /**
     * This method is used to return the option entry code for the StudentOptionEntry object
     *
     * @return the Faculty description for the StudentOptionEntry object
     */
    @JsonProperty(value = "_optionEntryCode")
    public String get_OptionEntryCode() {
        return this.examOption.optionEntryCode
    }
    
    /**
     * This method is used to return the option title for the StudentOptionentry object
     * 
     * @return the option title for the StudentOptionEntry object
     */
    @JsonProperty(value = "_optionTitle")
    public String get_OptionTitle() {
        return this.examOption.optionTitle
    }
    
    /**
     * This method is used to return the statusTypeDescription for the StudentOptionEntry object.
     * 
     * @return the statusTypeDescription for the StudentOptionEntry object.
     */
    @JsonProperty(value="_statusTypeDescription")
    public String get_StatusTypeDescription() {
        this.statusType != null ? this.statusType.description : null
    }
    
    /**
     * This method is used to return the ediStatusTypeDescription for the StudentOptionEntry object.
     * 
     * @return the ediStatusTypeDescription for the StudentOptionEntry object.
     */
    @JsonProperty(value = "_ediStatusTypeDescription")
    public String get_EdiStatusTypeDescription() {
        this.ediStatusType != null ? this.ediStatusType.description : null;
    }
}
