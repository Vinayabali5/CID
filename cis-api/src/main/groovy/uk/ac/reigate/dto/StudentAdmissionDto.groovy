package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.admissions.ApplicationStatusDto
import uk.ac.reigate.dto.admissions.OfferTypeDto
import uk.ac.reigate.dto.ilr.EthnicityDto
import uk.ac.reigate.dto.ilr.RestrictedUseIndicatorDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class StudentAdmissionDto {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    AcademicYearDto yearApplied
    
    @JsonProperty
    String admissionsNotes
    
    @JsonProperty
    Date refRequested
    
    @JsonProperty
    Date refReceived
    
    @JsonProperty
    Date interviewDate
    
    @JsonProperty
    Integer interviewerId
    
    @JsonProperty
    StaffDto interviewer
    
    @JsonProperty
    Date received
    
    @JsonProperty
    Date schoolReportReceived
    
    @JsonProperty
    Date schoolReportRequested
    
    @JsonProperty
    Integer schoolReportStatusId
    
    @JsonProperty
    SchoolReportStatusDto schoolReportStatus
    
    @JsonProperty
    Date blueCard
    
    @JsonProperty
    Boolean learningSupportOnIntro
    
    @JsonProperty
    Boolean cannotAttendIntroDay
    
    @JsonProperty
    Boolean cannotAttendInductionDay
    
    @JsonProperty
    Date inductionDate
    
    @JsonProperty
    Date enrolmentInterviewDate
    
    @JsonProperty
    Date enrolmentInterviewTime
    
    @JsonProperty
    Date acceptanceReceived
    
    @JsonProperty
    Boolean ehcp
    
    @JsonProperty
    Boolean lookedAfterChildOrAdopted
    
    @JsonProperty
    Boolean childrenServicesInvolvedAtSchool
    
    @JsonProperty
    Boolean otherSocialSupportIssues
    
    @JsonProperty
    Integer restrictedUseIndicatorId
    
    @JsonProperty
    RestrictedUseIndicatorDto restrictedUseIndicator
    
    @JsonProperty
    Boolean contactByPost
    
    @JsonProperty
    Boolean contactByPhone
    
    @JsonProperty
    Boolean contactByEmail
    
    @JsonProperty
    Boolean lrsOptOut
    
    @JsonProperty
    Integer collegeFundPaidId
    
    @JsonProperty
    Integer collegeFundPaidYears
    
    @JsonProperty
    Integer ethnicityId
    
    @JsonProperty
    EthnicityDto ethnicity
    
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
    Integer statusId
    
    @JsonProperty
    Integer offerTypeId
    
    @JsonProperty
    ApplicationStatusDto status;
    
    @JsonProperty
    OfferTypeDto offerType
    
    @JsonProperty
    String interviewBy
    
    @JsonProperty
    String otherSchoolCollegeAppliedFor
    
    @JsonProperty
    String learningSupportNeedsDetails
    
    /**
     * Default NoArgs constructor
     */
    StudentAdmissionDto() {}
    
    /**
     * Constructor to create a StudentAdmissionDto object from a Student and StudentYear object
     *
     * @param student, studentYear the Student, StudentYear object to use for construction
     */
    StudentAdmissionDto(Student student) {
        this.id = student.id
        this.yearApplied = AcademicYearDto.mapFromEntity(student.academicYear)
        this.admissionsNotes = student.admissionsNotes
        this.refRequested = student.refRequested
        this.refReceived = student.refReceived
        this.interviewDate = student.interviewDate
        this.interviewerId = student.interviewer != null ? student.interviewer.id : null
        this.interviewer = student.interviewer != null ? StaffDto.mapFromEntity(student.interviewer) : null
        this.received = student.received
        this.schoolReportReceived = student.reportReceived
        this.schoolReportRequested = student.reportRequested
        this.schoolReportStatusId = student.schoolReportStatus != null ? student.schoolReportStatus.id : null
        this.schoolReportStatus = student.schoolReportStatus != null ? SchoolReportStatusDto.mapFromEntity(student.schoolReportStatus) : null
        this.blueCard = student.blueCard
        this.learningSupportOnIntro = student.learningSupportOnIntro
        this.cannotAttendIntroDay = student.cannotAttendIntro
        this.cannotAttendInductionDay = student.cannotAttendInduction
        this.inductionDate = student.inductionDate
        this.enrolmentInterviewDate = student.enrolmentInterviewDate
        this.enrolmentInterviewTime = student.enrolmentInterviewTime
        this.acceptanceReceived = student.acceptanceReceived
        this.ehcp = student.ehcp
        this.lookedAfterChildOrAdopted = student.lookedAfterChildOrAdopted
        this.childrenServicesInvolvedAtSchool = student.childrenServicesInvolvedAtSchool
        this.otherSocialSupportIssues = student.otherSocialSupportIssues
        this.restrictedUseIndicatorId = student.restrictedUseIndicator != null ? student.restrictedUseIndicator.id : null
        this.restrictedUseIndicator = student.restrictedUseIndicator != null ? RestrictedUseIndicatorDto.mapFromEntity(student.restrictedUseIndicator) : null
        this.contactByPost = student.contactByPost
        this.contactByPhone = student.contactByPhone
        this.contactByEmail = student.contactByEmail
        this.lrsOptOut = student.lrsOptOut
        this.collegeFundPaidId = student.collegeFundPaid != null ? student.collegeFundPaid.id : null
        this.collegeFundPaidYears = student.collegeFundPaidYears
        this.ethnicityId = student.ethnicity != null ? student.ethnicity.id : null
        this.ethnicity = student.ethnicity != null ? EthnicityDto.mapFromEntity(student.ethnicity) : null
        this.possibleAspire = student.possibleAspire
        this.schoolReportNotSeen = student.schoolReportNotSeen
        this.freeMealsWhileAtSchool = student.freeMealsWhileAtSchool
        this.parentsUniversityEducated = student.parentsUniversityEducated
        this.statusId = student.status != null ? student.status.id : null;
        this.status = student.status != null ? ApplicationStatusDto.mapFromEntity(student.status) : null
        this.offerTypeId = student.offerType != null ? student.offerType.id : null;
        this.offerType = student.offerType != null ? OfferTypeDto.mapFromEntity(student.offerType) : null
        this.noShowAtInterview = student.noShowAtInterview
        this.interviewBy = student.interviewBy
        this.learningSupportNeedsDetails = student.learningSupportNeedsDetails
    }
    
    /**
     * This static method is used to create a StudentAdmissionDto from a Student data object.
     *
     * @param student the Student data object to use for the creation.
     * @return a StudentAdmissionDto object based on the Student data object supplied.
     */
    public static StudentAdmissionDto mapFromEntity(Student student) {
        return new StudentAdmissionDto(student)
    }
    
    /**
     * This static method is used to create a List of StudentAdmissionDto from a List of Student data object.
     *
     * @param students the List of Student data object to use for the creation.
     * @return a List of StudentAdmissionDto object based on the List of Student data object supplied.
     */
    public static List<StudentAdmissionDto> mapFromList(List<Student> students) {
        return students.collect { student ->  mapFromEntity(student) };
    }
    
    /**
     * This method is used to return the Interviewer Name for the Student object
     *
     * @return the Interviewer Name for the Student object
     */
    @JsonProperty(value = "_interviewerName")
    public String get_InterviewerName() {
        return this.interviewer != null ? this.interviewer.knownAs : null
    }
    
    /**
     * This method is used to return the SchoolReportStatus Description for the Student object
     *
     * @return the SchoolReportStatus Description for the Student object
     */
    @JsonProperty(value = "_schoolReportStatusDescription")
    public String get_SchoolReportStatusDescription() {
        return this.schoolReportStatus != null ? this.schoolReportStatus.description : null
    }
    
    /**
     * This method is used to return the RestrictedUseIndicator Description for the Student object
     *
     * @return the RestrictedUseIndicator Description for the Student object
     */
    @JsonProperty(value = "_restrictedUseIndicatorDescription")
    public String get_RestrictedUseIndicatorDescription() {
        return this.restrictedUseIndicator != null ? this.restrictedUseIndicator.description : null
    }
    
    /**
     * This method is used to return the Ethnicity Short Description for the Student object
     *
     * @return the Ethnicity Short Description for the Student object
     */
    @JsonProperty(value = "_ethnicityShortDescription")
    public String get_EthnicityShortDescription() {
        return this.ethnicity != null ? this.ethnicity.shortDescription : null
    }
    
    /**
     * This method is used to return the ApplicationStatus Description for the Student object
     *
     * @return the ApplicationStatus Description for the Student object
     */
    @JsonProperty(value = "_statusDescription")
    public String get_StatusDescription() {
        return this.status != null ? this.status.description : null
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
}
