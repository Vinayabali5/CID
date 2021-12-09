package uk.ac.reigate.dto.admissions;

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.RequestDto
import uk.ac.reigate.dto.lookup.StudentTypeDto

/**
 *
 * JSON serializable DTO containing Interview data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class InterviewDto implements Serializable {
    
    @JsonProperty
    private String studentRef
    
    @JsonProperty
    private Integer personId
    
    @JsonProperty
    private String surname
    
    @JsonProperty
    private String firstName
    
    @JsonProperty
    private String legalSurname
    
    @JsonProperty
    private String middleNames
    
    @JsonProperty
    private Date dob
    
    @JsonProperty
    private String email
    
    @JsonProperty
    private String mobile
    
    @JsonProperty
    private School school
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    @JsonFormat(pattern='dd/MM/yyyy HH:mm')
    private Date interviewDate
    
    @JsonProperty
    private Integer interviewerId
    
    @JsonProperty
    private String interviewNotes
    
    @JsonProperty
    private Integer offerTypeId
    
    @JsonProperty
    private OfferTypeDto offerType
    
    @JsonProperty
    private Integer studentTypeId
    
    @JsonProperty
    private StudentTypeDto studentType
    
    @JsonProperty
    private Boolean possibleAspire
    
    @JsonProperty
    private Boolean possibleMvd
    
    @JsonProperty
    private Boolean learningSupportOnIntro
    
    @JsonProperty
    private Boolean learningSupportNeeds
    
    @JsonProperty
    private Boolean schoolReportNotSeen
    
    @JsonProperty
    private Boolean noShowAtInterview
    
    @JsonProperty
    private List<RequestDto> requests
    
    @JsonProperty
    private List<ContactDto> contacts
    
    @JsonProperty
    private String careerAims
    
    @JsonProperty
    private String workVoluntaryExperience
    
    @JsonProperty
    private String hobbiesInterestsOtherAchievements
    
    @JsonProperty
    private String favoriteSubject
    
    @JsonProperty
    private String courseworkOrExams
    
    @JsonProperty
    private String reasonsForReigateCollege
    
    @JsonProperty
    private String interviewBy
    
    @JsonProperty
    private String otherSchoolCollegeAppliedFor
    
    @JsonProperty
    String learningSupportNeedsDetails
    
    /**
     * Default No Args constructor
     */
    public InterviewDto() {
    }
    
    /**
     * Constructor to create a InterviewDto object from a Student and StudentYear object
     *
     * @param student and studentYear the Student and StudentYear object to use for construction
     */
    InterviewDto(Student student, StudentYear studentYear){
        this.studentRef = student.referenceNo
        this.studentId = student.id
        this.personId = student.person.id
        this.surname = student.person.surname
        this.firstName = student.person.firstName
        this.legalSurname = student.person.legalSurname
        this.middleNames = student.person.middleNames
        this.dob = student.person.dob
        this.email = student.person.email
        this.mobile = student.person.mobile
        this.school = student.school
        this.interviewerId = student.interviewer != null ? student.interviewer.id : null
        this.interviewDate = student.interviewDate
        this.offerTypeId = student.offerType != null ? student.offerType.id : null
        this.offerType = student.offerType != null ? OfferTypeDto.mapFromEntity(student.offerType) : null
        this.studentTypeId = studentYear.studentType != null ? studentYear.studentType.id : null
        this.studentType = studentYear.studentType != null ? StudentTypeDto.mapFromEntity(studentYear.studentType) : null
        this.possibleAspire = student.possibleAspire
        this.possibleMvd = student.possibleMvd
        this.learningSupportOnIntro = student.learningSupportOnIntro
        this.schoolReportNotSeen = student.schoolReportNotSeen
        this.noShowAtInterview = student.noShowAtInterview
        this.requests = RequestDto.mapFromList(student.requests)
        this.contacts = ContactDto.mapFromList(student.person.contacts)
        this.careerAims = student.careerAims
        this.workVoluntaryExperience = student.workVoluntaryExperience
        this.hobbiesInterestsOtherAchievements = student.hobbiesInterestsOtherAchievements
        this.favoriteSubject = student.favoriteSubject
        this.courseworkOrExams = student.courseworkOrExams
        this.reasonsForReigateCollege = student.reasonsForReigateCollege
        this.interviewBy = student.interviewBy
        this.otherSchoolCollegeAppliedFor = student.otherSchoolCollegeAppliedFor
        this.learningSupportNeeds = student.learningSupportNeeds
        this.learningSupportNeedsDetails = student.learningSupportNeedsDetails
    }
    
    /**
     * This method is used to return the OfferType Description for the Student object
     *
     * @return the OfferType Description for the Student object
     */
    @JsonProperty(value = "_offerTypeDescription")
    public String get_OfferTypeDescription() {
        return this.offerType != null ? this.offerType.description : null
    }
    
    /**
     * This method is used to return the StudentType Description for the StudentYear object
     *
     * @return the StudentType Description for the StudentYear object
     */
    @JsonProperty(value = "_studentTypeDescription")
    public String get_StudentTypeDescription() {
        return this.studentType != null ? this.studentType.description : null
    }
}