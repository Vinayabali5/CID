package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentLearningSupport
import uk.ac.reigate.dto.learningsupport.StudentCourseConcessionDto
import uk.ac.reigate.dto.lookup.SupportTypeDto

/**
 *
 * JSON serializable DTO containing LearningSupport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentLearningSupportDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private String _readingInitialAssessmentDescirption;
    
    @JsonProperty
    private String _writingInitialAssessmentDescirption
    
    @JsonProperty
    private String _spellingInitialAssessmentDescirption;
    
    @JsonProperty
    List<StudentConcessionTypeDto> concessions;
    
    @JsonProperty
    List<StudentCourseConcessionDto> courseConcessions;
    
    @JsonProperty
    List<StudentReferralReasonDto> referralReasons;
    
    @JsonProperty
    private String referralNotes
    
    @JsonProperty
    private Integer supportTypeId;
    
    @JsonProperty
    private SupportTypeDto supportType;
    
    @JsonProperty
    private String supportNotes
    
    @JsonProperty
    private Date assessmentDate
    
    @JsonProperty
    private String previousConcession
    
    @JsonProperty
    private Boolean concessionApplication
    
    @JsonProperty
    private Boolean examConcessionApproved
    
    @JsonProperty
    private Boolean btecConcessionApproved
    
    @JsonProperty
    private Boolean fsConcessionApproved
    
    
    /**
     * Default No Args constructor
     */
    public StudentLearningSupportDto() {
    }
    
    /**
     * Constructor to create a StudentLearningSupportDto object from a Student, StudentLearningSupport object
     *
     * @param student, studentLearningSupport the Student, StudentLearningSupport object to use for construction
     */
    public StudentLearningSupportDto(StudentLearningSupport studentLearningSupport) {
        if (studentLearningSupport != null) {
            this.referralNotes = studentLearningSupport.referralNotes;
            this.supportTypeId = studentLearningSupport.supportType != null ? studentLearningSupport.supportType.id : null;
            this.supportType = studentLearningSupport.supportType != null ? SupportTypeDto.mapFromSupportTypeEntity(studentLearningSupport.supportType) : null
            this.supportNotes = studentLearningSupport.supportNotes;
            this.assessmentDate = studentLearningSupport.assessmentDate;
            this.previousConcession = studentLearningSupport.previousConcession;
            this.concessionApplication = studentLearningSupport.concessionApplication;
            this.examConcessionApproved = studentLearningSupport.examConcessionApproved;
            this.btecConcessionApproved = studentLearningSupport.btecConcessionApproved;
            this.fsConcessionApproved = studentLearningSupport.fsConcessionApproved;
            
            Student student = studentLearningSupport.student
            if (student != null) {
                this.studentId = student.id
                
                this._readingInitialAssessmentDescirption = student.readingInitialAssessment != null ? student.readingInitialAssessment.initialAssessmentLevel : ''
                this._writingInitialAssessmentDescirption = student.writingInitialAssessment != null ? student.writingInitialAssessment.initialAssessmentLevel : ''
                this._spellingInitialAssessmentDescirption = student.spellingInitialAssessment != null ? student.spellingInitialAssessment.initialAssessmentLevel : ''
                
                this.concessions = student.concessions.collect { it ->
                    return new StudentConcessionTypeDto(it)
                }
                
                this.courseConcessions = student.courseConcessions.collect { it ->
                    return new StudentCourseConcessionDto(it)
                }
                
                this.referralReasons = student.referralReasons.collect { it ->
                    return new StudentReferralReasonDto(it)
                }
            }
        }
    }
    /**
     * Constructor to create a StudentLearningSupportDto object from a Student, StudentLearningSupport object
     *
     * @param student, studentLearningSupport the Student, StudentLearningSupport object to use for construction
     */
    public StudentLearningSupportDto(Student student, StudentLearningSupport studentLearningSupport) {
        this._readingInitialAssessmentDescirption = student.readingInitialAssessment != null ? student.readingInitialAssessment.initialAssessmentLevel : ''
        this._writingInitialAssessmentDescirption = student.writingInitialAssessment != null ? student.writingInitialAssessment.initialAssessmentLevel : ''
        this._spellingInitialAssessmentDescirption = student.spellingInitialAssessment != null ? student.spellingInitialAssessment.initialAssessmentLevel : ''
        
        this.concessions = student.concessions.collect { it ->
            return new StudentConcessionTypeDto(it)
        }
        
        this.referralReasons = student.referralReasons.collect { it ->
            return new StudentReferralReasonDto(it)
        }
        
        if (studentLearningSupport != null) {
            this.studentId = studentLearningSupport.student.id
            this.referralNotes = studentLearningSupport.referralNotes;
            this.supportTypeId = studentLearningSupport.supportType != null ? studentLearningSupport.supportType.id : null;
            this.supportType = SupportTypeDto.mapFromSupportTypeEntity(studentLearningSupport.supportType)
            this.supportNotes = studentLearningSupport.supportNotes;
            this.assessmentDate = studentLearningSupport.assessmentDate;
            this.previousConcession = studentLearningSupport.previousConcession;
            this.concessionApplication = studentLearningSupport.concessionApplication;
            this.examConcessionApproved = studentLearningSupport.examConcessionApproved;
            this.btecConcessionApproved = studentLearningSupport.btecConcessionApproved;
            this.fsConcessionApproved = studentLearningSupport.fsConcessionApproved;
        }
    }
    
    /**
     * This static method is used to create a StudentLearningSupportDto from a StudentLearningSupport data object.
     *
     * @param studentLearningSupport the StudentLearningSupport data object to use for the creation.
     * @return a StudentLearningSupportDto object based on the StudentLearningSupport data object supplied.
     */
    public static StudentLearningSupportDto mapFromEntity(StudentLearningSupport studentLearningSupport) {
        return new StudentLearningSupportDto(studentLearningSupport);
    }
    
    /**
     * This static method is used to create a List of StudentLearningSupportDto from a List of StudentLearningSupport data object.
     *
     * @param studentLearningSupports the List of StudentLearningSupport data object to use for the creation.
     * @return a List of StudentLearningSupportDto object based on the List of StudentLearningSupport data object supplied.
     */
    public static List<StudentLearningSupportDto> mapFromList(List<StudentLearningSupport> studentLearningSupports) {
        return studentLearningSupports.collect { studentLearningSupport ->  new StudentLearningSupportDto(studentLearningSupport) };
    }
    
    /**
     * This method is used to return the supportType description for the StudentLearningSupport object
     *
     * @return the SupportType description for the StudentLearningSupport object
     */
    @JsonProperty(value = "_supportTypeDescription")
    public String get_SupportTypeDescription() {
        return this.supportType != null ? this.supportType.support : null
    }
}
