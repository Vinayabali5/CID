package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.ilr.EthnicityDto
import uk.ac.reigate.dto.ilr.RestrictedUseIndicatorDto
import uk.ac.reigate.dto.lookup.StudentTypeDto
import uk.ac.reigate.dto.risk_assessment.RiskLevelDto

/**
 *
 * JSON serializable DTO containing Student data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class StudentDto {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    String referenceNo
    
    @JsonProperty
    AcademicYearDto yearApplied
    
    @JsonProperty
    PersonDto person
    
    @JsonProperty
    Integer previousSchoolId
    
    @JsonProperty
    SchoolDto previousSchool
    
    @JsonProperty
    String uln
    
    @JsonProperty
    String uci
    
    @JsonProperty
    Integer ethnicityId
    
    @JsonProperty
    EthnicityDto ethnicity
    
    @JsonProperty
    Integer llddHealthProblemId
    
    @JsonProperty
    List<LLDDHealthProblemCategoryDto> llddHealthProblemCategories
    
    @JsonProperty
    Integer studentTypeId
    
    @JsonProperty
    StudentTypeDto studentType
    
    @JsonProperty
    Date startDate
    
    @JsonProperty
    Date endDate
    
    @JsonProperty
    List<AcademicYearDto> _years
    
    @JsonProperty
    AcademicYearDto currentYear
    
    @JsonProperty
    Integer specialCategoryId
    
    @JsonProperty
    Integer riskLevelId
    
    @JsonProperty
    RiskLevelDto riskLevel
    
    @JsonProperty
    Boolean specialConfirmed
    
    @JsonProperty
    Integer readingInitialAssessmentId
    
    @JsonProperty
    InitialAssessmentLevelDto readingInitialAssessment
    
    @JsonProperty
    Integer writingInitialAssessmentId
    
    @JsonProperty
    Integer spellingInitialAssessmentId
    
    @JsonProperty
    List<StudentConcessionTypeDto> concessions
    
    @JsonProperty
    List<StudentReferralReasonDto> referralReasons
    
    @JsonProperty
    GCSEScoreDto gcseScore
    
    @JsonProperty
    SpecialCategoryDto specialCategory
    
    @JsonProperty
    String medicalNote
    
    @JsonProperty
    String studentEmail
    
    @JsonProperty
    Boolean monitorable
    
    @JsonProperty
    Boolean resident
    
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
    Integer studentRemarkPermissionId
    
    @JsonProperty
    Boolean mathsDisadvantageFunding
    
    @JsonProperty
    Boolean englishDisadvantageFunding
    
    @JsonProperty
    Integer destinationId
    
    @JsonProperty
    String destinationCollegeEmployer
    
    @JsonProperty
    String destinationCourseCareer
    
    @JsonProperty
    DestinationDto destination
    
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
    Boolean _similarNamedStudent = false
    
    @JsonProperty
    String learningSupportNeedsDetails
    /**
     * Default NoArgs constructor
     */
    StudentDto() {}
    
    /**
     * Constructor to create a StudentDto object from a Student and StudentYear object
     *
     * @param student, studentYear the Student, StudentYear object to use for construction
     */
    StudentDto(Student student) {
        this.id = student.id
        this.referenceNo = student.referenceNo
        this.yearApplied = student.academicYear != null ? new AcademicYearDto(student.academicYear) : null
        this.person = student.person != null ? new PersonDto(student.person) : null
        
        this.previousSchoolId = student.school != null ? student.school.id : null
        this.previousSchool = student.school != null ? SchoolDto.mapFromEntity(student.school) : null
        this.specialConfirmed = student.specialConfirmed;
        this.uln = student.uln
        this.uci = student.uci
        this.specialConfirmed = student.specialConfirmed;
        this.ethnicityId = student.ethnicity != null ? student.ethnicity.id : null
        this.ethnicity = student.ethnicity != null ? EthnicityDto.mapFromEntity(student.ethnicity) : null
        
        
        this._years = student.studentYears.collect { it ->
            return AcademicYearDto.mapFromEntity(it.year)
        }
        
        this.llddHealthProblemId = student.llddHealthProblem != null ? student.llddHealthProblem.id : null
        this.llddHealthProblemCategories = student.llddHealthProblemCategory.collect { it ->
            return new LLDDHealthProblemCategoryDto(it)
        }
        
        this.concessions = student.concessions.collect { it ->
            return new StudentConcessionTypeDto(it)
        }
        
        this.referralReasons = student.referralReasons.collect { it ->
            return new StudentReferralReasonDto(it)
        }
        this.gcseScore = student.gcseScore != null ? new GCSEScoreDto(student.gcseScore) : null
        
        this.specialCategoryId = student.specialCategory != null ? student.specialCategory.id : null
        this.specialCategory = student.specialCategory != null ? SpecialCategoryDto.mapFromEntity(student.specialCategory) : null
        
        this.riskLevelId = student.riskLevel != null ? student.riskLevel.id : null
        this.riskLevel = student.riskLevel != null ? RiskLevelDto.mapFromEntity(student.riskLevel) : null
        
        this.readingInitialAssessmentId = student.readingInitialAssessment != null ? student.readingInitialAssessment.id : null
        this.readingInitialAssessment = student.readingInitialAssessment != null ? InitialAssessmentLevelDto.mapFromEntity(student.readingInitialAssessment) : null
        this.writingInitialAssessmentId = student.writingInitialAssessment != null ? student.writingInitialAssessment.id : null
        this.spellingInitialAssessmentId = student.spellingInitialAssessment != null ? student.spellingInitialAssessment.id : null
        this.medicalNote = student.medicalNote;
        this.studentEmail = student.studentEmail;
        this.monitorable = student.monitorable;
        this.resident = student.resident;
        this.contactByPost = student.contactByPost;
        this.contactByPhone = student.contactByPhone;
        this.contactByEmail = student.contactByEmail;
        this.mathsDisadvantageFunding = student.mathsDisadvantageFunding;
        this.englishDisadvantageFunding = student.englishDisadvantageFunding;
        this.restrictedUseIndicatorId = student.restrictedUseIndicator != null ? student.restrictedUseIndicator.id : null
        this.restrictedUseIndicator = student.restrictedUseIndicator != null ? RestrictedUseIndicatorDto.mapFromEntity(student.restrictedUseIndicator) : null
        this.studentRemarkPermissionId = student.studentRemarkPermission != null ? student.studentRemarkPermission.id : null
        this.destinationId = student.destination != null ? student.destination.id : null
        this.destination = student.destination != null ? DestinationDto.mapFromEntity(student.destination) : null
        this.destinationCollegeEmployer = student.destinationCollegeEmployer
        this.destinationCourseCareer = student.destinationCourseCareer
        this.possibleAspire = student.possibleAspire
        this.schoolReportNotSeen = student.schoolReportNotSeen
        this.freeMealsWhileAtSchool = student.freeMealsWhileAtSchool
        this.noShowAtInterview = student.noShowAtInterview
        this.parentsUniversityEducated = student.parentsUniversityEducated
        this.learningSupportNeedsDetails = student.learningSupportNeedsDetails
    }
    
    /**
     * Constructor to create a StudentDto object from a Student and similarNamedStudent
     *
     * @param student, similarNamedStudent the Student, similarNamedStudent  to use for construction
     */
    StudentDto(Student student, Boolean similarNamedStudent) {
        this(student)
        this._similarNamedStudent = similarNamedStudent
    }
    
    /**
     * This static method is used to create a StudentDto from a Student data object.
     *
     * @param student the Student data object to use for the creation.
     * @return a StudentDto object based on the Student data object supplied.
     */
    public static StudentDto mapFromEntity(Student student) {
        return new StudentDto(student)
    }
    
    /**
     * This static method is used to create a List of StudentDto from a List of Student data object.
     *
     * @param students the List of Student data object to use for the creation.
     * @return a List of StudentDto object based on the List of Student data object supplied.
     */
    public static List<StudentDto> mapFromList(List<Student> students){
        List<Student> output = students.collect { student -> new StudentDto(student) };
    }
    
    /**
     * This method is used to return the PreviousSchool Name for the Student object
     *
     * @return the PreviousSchool Name for the Student object
     */
    @JsonProperty(value = "_previousSchoolName")
    public String get_PreviousSchoolName() {
        return this.previousSchool != null ? this.previousSchool.name : null
    }
    
    /**
     * This method is used to return the Ethnicity Description for the Student object
     *
     * @return the Ethnicity Description for the Student object
     */
    @JsonProperty(value = "_ethnicityDescription")
    public String get_EthnicityDescription() {
        return this.ethnicity != null ? this.ethnicity.shortDescription : null
    }
    
    /**
     * This method is used to return the specialCategory Code for the Student object
     *
     * @return the specialCategory Code for the Student object
     */
    @JsonProperty(value = "_specialCategoryCode")
    public String get_SpecialCategoryCode() {
        return this.specialCategory != null ? this.specialCategory.code : null
    }
    
    /**
     * This method is used to return the specialCategory Description for the Student object
     *
     * @return the specialCategory Description for the Student object
     */
    @JsonProperty(value = "_specialCategoryDescription")
    public String get_SpecialCategoryDescription() {
        return this.specialCategory != null ? this.specialCategory.description : null
    }
    
    /**
     * This method is used to return the specialCategory Details for the Student object
     *
     * @return the specialCategory Details for the Student object
     */
    @JsonProperty(value = "_specialCategoryDetails")
    public String get_SpecialCategoryDetails() {
        return this.specialCategory != null ? this.specialCategory.details : null
    }
    
    /**
     * This method is used to return the riskLevel Code for the Student object
     *
     * @return the riskLevel Code for the Student object
     */
    @JsonProperty(value = "_riskLevelCode")
    public String get_RiskLevelCode() {
        return this.riskLevel != null ? this.riskLevel.code : null
    }
    
    /**
     * This method is used to return the riskLevel Description for the Student object
     *
     * @return the riskLevel description for the Student object
     */
    @JsonProperty(value = "_riskLevelDescription")
    public String get_RiskLevelDescription() {
        return this.riskLevel != null ? this.riskLevel.description : null
    }
    
    /**
     * This method is used to return the readingInitialAssessment Descirption for the Student object
     *
     * @return the readingInitialAssessment Descirption for the Student object
     */
    @JsonProperty(value = "_readingInitialAssessmentDescirption")
    public String get_ReadingInitialAssessmentDescirption() {
        return this.readingInitialAssessment != null ? this.readingInitialAssessment.initialAssessmentLevel : null
    }
    
    /**
     * This method is used to return the RestrictedUseIndicator code for the Student object
     *
     * @return the restrictedUseIndicator Code for the Student object
     */
    @JsonProperty(value = "_restrictedUseIndicatorCode")
    public String get_RestrictedUseIndicatorCode() {
        return this.restrictedUseIndicator != null ? this.restrictedUseIndicator.code : null
    }
    
    /**
     * This method is used to return the RestrictedUseIndicator Description for the Student object
     *
     * @return the restrictedUseIndicator Description for the Student object
     */
    @JsonProperty(value = "_restrictedUseIndicatorDescription")
    public String get_RestrictedUseIndicatorDescription() {
        return this.restrictedUseIndicator != null ? this.restrictedUseIndicator.description : null
    }
    
    /**
     * This method is used to return the Destination Description for the Student object
     *
     * @return the Destination Description for the Student object
     */
    @JsonProperty(value = "_destinationDescription")
    public String get_DestinationDescription() {
        return this.destination != null ? this.destination.description : null
    }
}