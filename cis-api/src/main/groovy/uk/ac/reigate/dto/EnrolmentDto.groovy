package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.dto.ilr.AimTypeDto
import uk.ac.reigate.dto.ilr.CompletionStatusDto
import uk.ac.reigate.dto.ilr.OutcomeDto
import uk.ac.reigate.dto.ilr.SourceOfFundingDto
import uk.ac.reigate.dto.ilr.WithdrawalReasonDto

/**
 *
 * JSON serializable DTO containing Department data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class EnrolmentDto implements Serializable {
    
    @JsonProperty
    Integer enrolmentId
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    StudentSummaryDto student
    
    @JsonProperty
    Integer yearId
    
    @JsonProperty
    AcademicYearDto academicYear
    
    @JsonProperty
    Integer courseId
    
    @JsonProperty
    Integer courseGroupId
    
    @JsonProperty
    CourseSummaryDto course
    
    /**
     * The course group reference e.g. 1B
     */
    @JsonProperty
    CourseGroupSummaryDto courseGroup
    
    @JsonProperty
    Date startDate
    
    @JsonProperty
    Date endDate
    
    /**
     * The qualification start date according to the ILR
     */
    @JsonProperty
    Date qualificationStartDate
    
    /**
     * The planned end date according to the ILR
     */
    @JsonProperty
    Date plannedEndDate
    
    @JsonProperty
    Integer aimTypeId
    
    @JsonProperty
    AimTypeDto _aimType;
    
    @JsonProperty
    Integer completionStatusId
    
    @JsonProperty
    CompletionStatusDto _completionStatus
    
    @JsonProperty
    Integer outcomeId
    
    @JsonProperty
    OutcomeDto _outcome
    
    @JsonProperty
    String grade
    
    @JsonProperty
    Integer withdrawalReasonId
    
    @JsonProperty
    WithdrawalReasonDto _withdrawalReason
    
    @JsonProperty
    Boolean ilr
    
    @JsonProperty
    Integer centralMonitoringId
    
    @JsonProperty
    CentralMonitoringDto _centralMonitoring
    
    @JsonProperty
    Integer plh
    
    @JsonProperty
    Integer peeph
    
    @JsonProperty
    Integer fundingModelId
    
    @JsonProperty
    FundingModelDto fundingModel
    
    @JsonProperty
    Integer sourceOfFundingId
    
    @JsonProperty
    SourceOfFundingDto sourceOfFunding
    
    @JsonProperty
    String notes
    
    @JsonProperty
    String learningAimReferenceOverride
    
    //	@JsonProperty
    //	PreReferenceDto reference
    
    
    /**
     * Default No Args constructor
     */
    EnrolmentDto() {}
    
    /**
     * Constructor to create an EnrolmentDto object from a Enrolment object
     *
     * @param enrolment the Enrolment object to use for construction
     */
    EnrolmentDto(Enrolment enrolment) {
        this.enrolmentId = enrolment.id;
        this.studentId = enrolment.student.id;
        this.student = new StudentSummaryDto(enrolment.student)
        this.yearId = enrolment.year != null ? enrolment.year.id : null
        this.academicYear = enrolment.year != null ? AcademicYearDto.mapFromEntity(enrolment.year) : null
        this.courseId = enrolment.course != null ? enrolment.course.id : null
        this.courseGroupId = enrolment.courseGroup != null ? enrolment.courseGroup.id : null
        this.course = enrolment.course != null ? CourseSummaryDto.mapFromEntity(enrolment.course) : null
        this.courseGroup = enrolment.courseGroup != null ? CourseGroupSummaryDto.mapFromEntity(enrolment.courseGroup) : null
        this.startDate = enrolment.startDate
        this.endDate = enrolment.endDate
        this.qualificationStartDate = enrolment.qualificationStartDate
        this.plannedEndDate = enrolment.plannedEndDate
        this._aimType = enrolment.aimType != null ? AimTypeDto.mapFromEntity(enrolment.aimType) : null
        this.aimTypeId = enrolment.aimType != null ? enrolment.aimType.id : null
        this._completionStatus = enrolment.completionStatus != null ? CompletionStatusDto.mapFromEntity(enrolment.completionStatus) : null
        this.completionStatusId = enrolment.completionStatus != null ? enrolment.completionStatus.id : null
        this._outcome = enrolment.outcome != null ? OutcomeDto.mapFromEntity(enrolment.outcome) : null
        this.outcomeId = enrolment.outcome != null ? enrolment.outcome.id : null
        this._withdrawalReason = enrolment.withdrawalReason != null ? WithdrawalReasonDto.mapFromEntity(enrolment.withdrawalReason) : null
        this.withdrawalReasonId = enrolment.withdrawalReason != null ? enrolment.withdrawalReason.id : null
        this._centralMonitoring = enrolment.centralMonitoring != null ? CentralMonitoringDto.mapFromEntity(enrolment.centralMonitoring) : null
        this.centralMonitoringId = enrolment.centralMonitoring != null ? enrolment.centralMonitoring.id : null
        this.grade = enrolment.grade
        this.ilr = enrolment.ilr
        this.plh = enrolment.plh
        this.peeph = enrolment.peeph
        this.fundingModelId = enrolment.fundingModel != null ? enrolment.fundingModel.id : null
        this.fundingModel = enrolment.fundingModel != null ? FundingModelDto.mapFromEntity(enrolment.fundingModel) : null
        this.sourceOfFundingId = enrolment.sourceOfFunding != null ? enrolment.sourceOfFunding.id : null
        this.sourceOfFunding = enrolment.sourceOfFunding != null ? SourceOfFundingDto.mapFromEntity(enrolment.sourceOfFunding) : null
        this.notes = enrolment.notes
        this.learningAimReferenceOverride = enrolment.learningAimReferenceOverride
        //	this.reference = enrolment.reference != null && enrolment.reference.student != null && enrolment.reference.course != null ? PreReferenceDto.mapFromEntity(enrolment.reference) : null;
    }
    
    /**
     * This method is used to map an Enrolment object to an EnrolmentDto object
     * 
     * @param enrolment an Enrolment object
     * @return an EnrolmentDto object
     */
    public static EnrolmentDto mapFromEntity(Enrolment enrolment){
        return new EnrolmentDto(enrolment)
    }
    
    /**
     * This method is used to map a List of Enrolment objects to a List of EnrolmentDto objects.
     * 
     * @param enrolmentList a List of Enrolment objects
     * @return a List of EnrolmentDto objects
     */
    public static List<EnrolmentDto> mapFromList(List<Enrolment> enrolmentList) {
        return enrolmentList.collect { enrolment ->  new EnrolmentDto(enrolment) };
    }
    
    /**
     * This method is used to return the Course spec for the Enrolment object
     *
     * @return the Course spec for the Enrolment object
     */
    @JsonProperty(value = "_courseReference")
    public String get_CourseReference() {
        return this.course != null ? this.course.spec : null
    }
    
    /**
     * This method is used to return the AcademicYear code for the Enrolment object
     *
     * @return the AcademicYear code for the Enrolment object
     */
    @JsonProperty(value = "_academicYearCode")
    public String get_AcademicYearCode() {
        return this.academicYear != null ? this.academicYear.code : null
    }
    
    /**
     * This method is used to return the CourseGroup spec for the Enrolment object
     *
     * @return the CourseGroup spec for the Enrolment object
     */
    @JsonProperty(value = "_courseGroupReference")
    public String get_CourseGroupReference() {
        return this.courseGroup != null ? this.courseGroup.spec : null
    }
    
    /**
     * This method is used to return the FundingModel code for the Enrolment object
     *
     * @return the FundingModel code for the Enrolment object
     */
    @JsonProperty(value = "_fundingModelCode")
    public String get_FundingModelCode() {
        return this.fundingModel != null ? this.fundingModel.code : null
    }
    
    /**
     * This method is used to return the FundingModel description for the Enrolment object
     *
     * @return the FundingModel description for the Enrolment object
     */
    @JsonProperty(value = "_fundingModelDescription")
    public String get_FundingModelDescription() {
        return this.fundingModel != null ? this.fundingModel.description : null
    }
    
    /**
     * This method is used to return the SourceOfFunding code for the Enrolment object
     *
     * @return the SourceOfFunding code for the Enrolment object
     */
    @JsonProperty(value = "_sourceOfFundingCode")
    public String get_SourceOfFundingCode() {
        return this.sourceOfFunding != null ? this.sourceOfFunding.code : null
    }
    
    /**
     * This method is used to return the SourceOfFunding description for the Enrolment object
     *
     * @return the SourceOfFunding description for the Enrolment object
     */
    @JsonProperty(value = "_sourceOfFundingDescription")
    public String get_SourceOfFundingDescription() {
        return this.sourceOfFunding != null ? this.sourceOfFunding.description : null
    }
    
    /**
     * This method is used to return the Course subject description for the Enrolment object
     *
     * @return the Course subject description for the Enrolment object
     */
    @JsonProperty(value = "_subjectDescription")
    public String get_SubjectDescription() {
        return this.course != null & this.course.subject != null ? this.course.subject.description : null
    }
    
    /**
     * This method is used to return the Course Level description for the Enrolment object
     *
     * @return theCourse Level description for the Enrolment object
     */
    @JsonProperty(value = "_levelDescription")
    public String get_LevelDescription() {
        return this.course != null & this.course.level != null ? this.course.level.description : null
    }
}
