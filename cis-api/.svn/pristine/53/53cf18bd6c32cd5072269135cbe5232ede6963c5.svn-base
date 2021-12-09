package uk.ac.reigate.dto.admissions

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import org.springframework.format.annotation.DateTimeFormat

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.AddressDto
import uk.ac.reigate.dto.LLDDHealthProblemCategoryDto
import uk.ac.reigate.dto.RequestDto

/**
 * The ApplicationForm object is a form backing object that is used to create new applications only.
 *
 * @author Michael Horgan, Vinaya Bali
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class ApplicationFormDto implements Serializable{
    
    /*
     * Phase 1 Fields
     */
    
    @JsonProperty
    Integer id
    
    /**
     * This fields represents the year the student initially applied to the College.
     */
    @JsonProperty
    Integer academicYearId
    
    @JsonProperty
    String referenceNo
    
    @JsonProperty
    Integer statusId
    
    @JsonProperty
    @NotNull
    Date received
    
    @JsonProperty
    Date endDate
    
    /**
     * This field represents the year of the current application.
     */
    @JsonProperty
    Integer yearId
    
    @JsonProperty
    Integer personId
    
    @JsonProperty
    @NotEmpty
    @Size(min=2, max=50)
    String firstName
    
    @JsonProperty
    @NotEmpty
    @Size(min=2, max=50)
    String surname
    
    @JsonProperty
    String legalSurname
    
    @JsonProperty
    String middleNames
    
    @JsonProperty
    String preferredName
    
    @JsonProperty
    String previousSurname
    
    @JsonProperty
    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date dob
    
    @JsonProperty
    @NotNull
    Integer legalSexId
    
    @JsonProperty
    Integer genderId
    
    @JsonProperty
    Integer titleId
    
    @JsonProperty
    String home
    
    @JsonProperty
    String mobile
    
    @JsonProperty
    String email
    
    @JsonProperty
    String countryOfResidence
    
    @JsonProperty
    Boolean resident
    
    @JsonProperty
    AddressDto address
    
    @JsonProperty
    Integer addressId
    
    @JsonProperty
    @NotEmpty
    String line1
    
    @JsonProperty
    String line2
    
    @JsonProperty
    String line3
    
    @JsonProperty
    String line4
    
    @JsonProperty
    String line5
    
    @JsonProperty
    String buildingName
    
    @JsonProperty
    String subBuilding
    
    @JsonProperty
    String udprn
    
    @JsonProperty
    String street
    
    @JsonProperty
    String town
    
    @JsonProperty
    String county
    
    @JsonProperty
    @NotEmpty
    String postcode
    
    @JsonProperty
    Boolean sibling
    
    @JsonProperty
    String siblingName
    
    @JsonProperty
    Integer siblingYear
    
    @JsonProperty
    String siblingAdmNo
    
    @JsonProperty
    @NotNull
    Integer schoolId
    
    @JsonProperty
    Integer schoolReportStatusId
    
    @JsonProperty
    List<ContactDto> contacts
    
    @JsonProperty
    List<AddressDto> addresses
    
    @JsonProperty
    List<RequestDto> requests
    
    @JsonProperty
    Integer collegeFundPaidId
    
    @JsonProperty
    Integer collegeFundPaidYears
    
    /*
     * Phase 2 Fields
     */
    
    @JsonProperty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date refRequested
    
    @JsonProperty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date refReceived
    
    @JsonProperty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date reportRequested
    
    @JsonProperty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date reportReceived
    
    @JsonProperty
    Integer tutorGroupId
    
    @JsonProperty
    Date acceptanceReceived
    
    @JsonProperty
    Integer ethnicityId
    
    @JsonProperty
    Integer restrictedUseIndicatorId
    
    @JsonProperty
    Integer llddHealthProblemId
    
    @JsonProperty
    List<LLDDHealthProblemCategoryDto> llddHealthProblemCategories
    
    @JsonProperty
    Integer studentTypeId
    
    @JsonProperty
    String uln
    
    @JsonProperty
    String uci
    
    @JsonProperty
    String admissionsNotes
    
    @JsonProperty
    Integer interviewId
    
    @JsonProperty
    Integer interviewerId
    
    @JsonProperty
    Integer interviewCategoryId
    
    @JsonProperty
    @JsonFormat(pattern='dd/MM/yyyy HH:mm', timezone = "Europe/London")
    Date interviewDate
    
    @JsonProperty
    Integer offerTypeId
    
    @JsonProperty
    Date offerSent
    
    @JsonProperty
    Boolean ehcp
    
    @JsonProperty
    Boolean lookedAfterChildOrAdopted
    
    @JsonProperty
    Boolean childrenServicesInvolvedAtSchool
    
    @JsonProperty
    Boolean otherSocialSupportIssues
    
    @JsonProperty
    String medicalNote
    
    @JsonProperty
    Boolean contactByPost
    
    @JsonProperty
    Boolean contactByPhone
    
    @JsonProperty
    Boolean contactByEmail
    
    @JsonProperty
    Boolean lrsOptOut
    
    @JsonProperty
    Boolean cannotAttendIntro
    
    @JsonProperty
    Boolean learningSupportOnIntro
    
    @JsonProperty
    Boolean learningSupportNeeds
    
    @JsonProperty
    Boolean cannotAttendInduction
    
    @JsonProperty
    Date inductionDate
    
    @JsonProperty
    Date blueCard
    
    @JsonProperty
    @JsonFormat(pattern='dd/MM/yyyy HH:mm', timezone = "Europe/London")
    Date enrolmentInterviewDate
    
    @JsonProperty
    Date enrolmentInterviewTime
    
    @JsonProperty
    Integer specialCategoryId
    
    @JsonProperty
    Date withdrawnDate
    
    @JsonProperty
    Boolean possibleAspire
    
    @JsonProperty
    Boolean schoolReportNotSeen
    
    @JsonProperty
    Boolean noShowAtInterview
    
    @JsonProperty
    Boolean freeMealsWhileAtSchool
    
    @JsonProperty
    Boolean parentsUniversityEducated
    
    @JsonProperty
    String schoolName
    
    @JsonProperty
    Boolean interviewNeedsRescheduling
    
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
     * Default noargs constructor for new blank ApplicationForm
     */
    ApplicationFormDto() {
    }
    
    /**
     * A constructor that uses an Application object to populate the required fields.
     *
     * @param app an Application object, typically retrieved from the database
     */
    ApplicationFormDto(Student student, StudentYear studentYear) {
        this.id = student.id
        this.referenceNo = student.referenceNo
        this.statusId = student.status != null ? student.status.id : null
        // endDate is using studentYear table
        this.endDate = studentYear.endDate
        this.received = student.received
        this.academicYearId = student.academicYear != null ? student.academicYear.id : null
        this.yearId = studentYear.year != null ? studentYear.year.id : null
        
        // Load Person fields
        this.personId = student.person.id
        this.firstName = student.person.firstName
        this.surname = student.person.surname
        this.middleNames = student.person.middleNames
        this.preferredName = student.person.preferredName
        this.previousSurname = student.person.previousSurname
        this.legalSurname = student.person.legalSurname
        this.dob = student.person.dob
        this.legalSexId = student.person.legalSex != null ? student.person.legalSex.id : null
        this.genderId = student.person.gender != null ? student.person.gender.id : null
        this.titleId = student.person.title != null ? student.person.title.id : null
        this.home = student.person.home
        this.mobile = student.person.mobile
        this.email = student.person.email
        this.countryOfResidence = student.countryOfResidence
        this.resident = student.resident
        
        // Load Person.Address fields
        this.address = AddressDto.mapFromEntity(student.person.address)
        this.addressId = student.person.address.id
        this.line1 = student.person.address.line1
        this.line2 = student.person.address.line2
        this.line3 = student.person.address.line3
        this.line4 = student.person.address.line4
        this.line5 = student.person.address.line5
        this.buildingName = student.person.address.buildingName
        this.subBuilding = student.person.address.subBuilding
        this.postcode = student.person.address.postcode
        this.town = student.person.address.town
        this.county = student.person.address.county
        this.postcode = student.person.address.postcode
        
        // Load Contacts
        this.contacts = ContactDto.mapFromList(student.person.contacts)
        
        // Load sibling fields
        this.sibling = student.sibling
        this.siblingName = student.siblingName
        this.siblingYear = student.siblingYear
        this.siblingAdmNo = student.siblingAdmNo
        
        //load school field
        this.schoolId = student.school != null ? student.school.id : null
        this.schoolName = student.school != null ? student.school.name : ''
        this.schoolReportStatusId = student.schoolReportStatus != null ? student.schoolReportStatus.id : null
        this.refRequested = student.refRequested
        this.refReceived = student.refReceived
        this.reportRequested = student.reportRequested
        this.reportReceived = student.reportReceived
        this.blueCard  = student.blueCard
        
        //load student details
        this.studentTypeId = studentYear.type != null ? studentYear.type.id : null
        this.uln = student.uln
        this.uci = student.uci
        this.tutorGroupId = studentYear.tutorGroup != null ? studentYear.tutorGroup.id : null
        this.offerTypeId = student.offerType != null ? student.offerType.id : null
        this.offerSent = student.offerSent
        
        //load interview fields
        this.interviewerId = student.interviewer != null ? student.interviewer.id : null
        this.interviewDate = student.interviewDate
        this.possibleAspire = student.possibleAspire
        this.noShowAtInterview = student.noShowAtInterview
        this.interviewNeedsRescheduling = student.interviewNeedsRescheduling
        this.schoolReportNotSeen = student.schoolReportNotSeen
        this.interviewCategoryId = student.interviewCategory != null ? student.interviewCategory.id : null
        //load acceptance field
        this.acceptanceReceived = student.acceptanceReceived
        this.ethnicityId = student.ethnicity != null ? student.ethnicity.id : null
        
        
        //load disability field
        this.llddHealthProblemId = student.llddHealthProblem != null ? student.llddHealthProblem.id : null
        this.llddHealthProblemCategories = student.llddHealthProblemCategory.collect { it ->
            return new LLDDHealthProblemCategoryDto(it)
        }
        
        // Load LLDD and Health Problem Category
        this.ehcp = student.ehcp
        this.lookedAfterChildOrAdopted = student.lookedAfterChildOrAdopted
        this.childrenServicesInvolvedAtSchool = student.childrenServicesInvolvedAtSchool
        this.otherSocialSupportIssues = student.otherSocialSupportIssues
        this.medicalNote = student.medicalNote
        this.specialCategoryId = student.specialCategory != null ? student.specialCategory.id : null
        
        //load data sharing fields
        this.restrictedUseIndicatorId = student.restrictedUseIndicator != null ? student.restrictedUseIndicator.id : null
        this.contactByPost = student.contactByPost
        this.contactByPhone = student.contactByPhone
        this.contactByEmail = student.contactByEmail
        this.lrsOptOut = student.lrsOptOut
        
        // load Admissions Notes
        this.admissionsNotes = student.admissionsNotes
        
        // load intro and induction day fields
        this.learningSupportOnIntro = student.learningSupportOnIntro
        this.cannotAttendIntro = student.cannotAttendIntro
        this.cannotAttendInduction = student.cannotAttendInduction
        this.inductionDate = student.inductionDate
        this.enrolmentInterviewDate = student.enrolmentInterviewDate
        
        // load College Fund Entry
        this.collegeFundPaidId = student.collegeFundPaid != null ? student.collegeFundPaid.id : null
        this.collegeFundPaidYears = student.collegeFundPaidYears
        this.requests = RequestDto.mapFromList(student.requests)
        
        this.withdrawnDate = studentYear.withdrawnDate
        this.freeMealsWhileAtSchool = student.freeMealsWhileAtSchool
        this.parentsUniversityEducated = student.parentsUniversityEducated
        this.learningSupportNeeds = student.learningSupportNeeds
        
        //load interview information
        this.careerAims = student.careerAims
        this.workVoluntaryExperience = student.workVoluntaryExperience
        this.hobbiesInterestsOtherAchievements = student.hobbiesInterestsOtherAchievements
        this.favoriteSubject = student.favoriteSubject
        this.courseworkOrExams = student.courseworkOrExams
        this.reasonsForReigateCollege = student.reasonsForReigateCollege
        this.interviewBy = student.interviewBy
        this.otherSchoolCollegeAppliedFor = student.otherSchoolCollegeAppliedFor
        this.learningSupportNeedsDetails = student.learningSupportNeedsDetails
    }
    
}
