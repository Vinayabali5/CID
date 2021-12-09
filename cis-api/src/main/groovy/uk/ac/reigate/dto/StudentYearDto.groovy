package uk.ac.reigate.dto

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.lookup.StudentTypeDto

/**
 *
 * JSON serializable DTO containing StudentYear data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields = true)
class StudentYearDto implements Serializable {
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    StudentDto student
    
    @JsonProperty
    Integer yearId
    
    @JsonProperty
    AcademicYearDto year
    
    @JsonProperty
    Integer typeId
    
    @JsonProperty
    StudentTypeDto studentType
    
    @JsonProperty
    Integer tutorGroupId
    
    @JsonProperty
    TutorGroupDto tutorGroup
    
    @JsonProperty
    Date startDate
    
    @JsonProperty
    Date endDate
    
    @JsonProperty
    Date withdrawnDate
    
    @JsonProperty
    Boolean ilr
    
    @JsonProperty
    Integer plh
    
    @JsonProperty
    Integer peeph
    
    @JsonProperty
    String gcseMathsGrade
    
    @JsonProperty
    String gcseEnglishGrade
    
    @JsonProperty
    Integer candidateNo
    
    @JsonProperty
    Boolean lda
    
    @JsonProperty
    Boolean ehc
    
    @JsonProperty
    Boolean hns
    
    @JsonProperty
    Boolean sen
    
    @JsonProperty
    Integer mathsConditionOfFundingId
    
    @JsonProperty
    Integer englishConditionOfFundingId
    
    @JsonProperty
    Integer learningSupportCost
    
    @JsonProperty
    Boolean onContract
    
    @JsonProperty
    String initialPostcode
    
    @JsonProperty
    Boolean externalCandidate
    
    @JsonProperty
    Integer destinationId
    
    @JsonProperty
    DestinationDto destination
    
    @JsonProperty
    String destinationCollegeEmployer
    
    @JsonProperty
    String destinationCourseCareer
    
    @JsonProperty
    Boolean breakInLearning
    
    @JsonProperty
    Integer bursaryTypeId
    
    @JsonProperty
    Boolean removedFromFreeMeals
    
    @JsonProperty
    Boolean socialWorker
    
    @JsonProperty
    Integer pastoralMonitorId
    
    @JsonProperty
    StaffDto pastoralMonitor
    
    @JsonProperty
    Boolean onMentoring
    
    /**
     * Default No Args constructor
     */
    StudentYearDto() {}
    
    /**
     * Constructor to create a StudentYearDto object from a StudentYear object
     *
     * @param studentYear the StudentYear object to use for construction
     */
    StudentYearDto(StudentYear studentYear){
        if(studentYear != null) {
            this.studentId = studentYear.student.id;
            this.student = StudentDto.mapFromEntity(studentYear.student)
            this.yearId = studentYear.year != null ? studentYear.year.id : null;
            this.year = studentYear.year != null ? AcademicYearDto.mapFromEntity(studentYear.year) : null
            this.typeId = studentYear.studentType != null ? studentYear.studentType.id : null;
            this.studentType = studentYear.studentType != null ? StudentTypeDto.mapFromEntity(studentYear.studentType) : null
            this.tutorGroupId = studentYear.tutorGroup != null ? studentYear.tutorGroup.id : null;
            this.tutorGroup = studentYear.tutorGroup != null ? TutorGroupDto.mapFromEntity(studentYear.tutorGroup) : null
            this.startDate = studentYear.startDate != null ? studentYear.startDate : null;
            this.endDate = studentYear.endDate != null ? studentYear.endDate : null;
            this.withdrawnDate = studentYear.withdrawnDate != null ? studentYear.withdrawnDate : null;
            this.ilr = studentYear.ilr != null ? studentYear.ilr : null;
            this.plh = studentYear.plh != null ? studentYear.plh : null;
            this.peeph = studentYear.peeph != null ? studentYear.peeph : null;
            this.gcseMathsGrade = studentYear.gcseMathsGrade != null ? studentYear.gcseMathsGrade : null;
            this.gcseEnglishGrade = studentYear.gcseEnglishGrade != null ? studentYear.gcseEnglishGrade : null;
            this.candidateNo = studentYear.candidateNo != null ? studentYear.candidateNo : null;
            this.lda = studentYear.lda != null ? studentYear.lda : null;
            this.ehc = studentYear.ehc != null ? studentYear.ehc : null;
            this.hns = studentYear.hns != null ? studentYear.hns : null;
            this.sen = studentYear.sen != null ? studentYear.sen : null;
            this.mathsConditionOfFundingId = studentYear.mathsConditionOfFunding != null ? studentYear.mathsConditionOfFunding.id : null;
            this.englishConditionOfFundingId = studentYear.englishConditionOfFunding != null ? studentYear.englishConditionOfFunding.id : null;
            this.learningSupportCost = studentYear.learningSupportCost != null ? studentYear.learningSupportCost : null;
            this.onContract = studentYear.onContract != null ? studentYear.onContract : null;
            this.initialPostcode = studentYear.initialPostcode != null ? studentYear.initialPostcode : null;
            this.externalCandidate = studentYear.externalCandidate != null ? studentYear.externalCandidate : null;
            this.destinationId = studentYear.destination != null ? studentYear.destination.id : null;
            this.destination = studentYear.destination != null ? DestinationDto.mapFromEntity(studentYear.destination) : null
            this.destinationCollegeEmployer = studentYear.destinationCollegeEmployer;
            this.destinationCourseCareer = studentYear.destinationCourseCareer;
            this.breakInLearning = studentYear.breakInLearning;
            this.removedFromFreeMeals = studentYear.removedFromFreeMeals
            this.bursaryTypeId = studentYear.bursaryType != null ? studentYear.bursaryType.id : null;
            this.socialWorker = studentYear.socialWorker
            this.pastoralMonitorId = studentYear.pastoralMonitor != null ? studentYear.pastoralMonitor.id : null;
            this.pastoralMonitor = studentYear.pastoralMonitor != null ? StaffDto.mapFromEntity(studentYear.pastoralMonitor) : null
            this.onMentoring = studentYear.onMentoring
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentYearDto from a StudentYear data object.
     *
     * @param studentYear the StudentYear data object to use for the creation.
     * @return a StudentYearDto object based on the StudentYear data object supplied.
     */
    public static StudentYearDto mapFromStudentYearEntity(StudentYear studentYear) {
        return new StudentYearDto(studentYear);
    }
    
    /**
     * This static method is used to create a List of StudentYearDto from a List of StudentYear data object.
     *
     * @param studentYears the List of StudentYear data object to use for the creation.
     * @return a List of StudentYearDto object based on the List of StudentYear data object supplied.
     */
    public static List<StudentYearDto> mapFromStudentYearEntities(List<StudentYear> studentYears) {
        return studentYears.collect { studentYear -> new StudentYearDto(studentYear) };
    }
    
    /**
     * This method is used to return the Year Code for the StudentYear object
     *
     * @return the Year Code for the StudentYear object
     */
    @JsonProperty(value = "_yearCode")
    public String get_YearCode() {
        return this.year != null ? this.year.code : null
    }
    
    
    
    /**
     * This method is used to return the studentType Code for the StudentYear object
     *
     * @return the studentType Code for the StudentYear object
     */
    @JsonProperty(value = "_studentTypeCode")
    public String get_StudentTypeCode() {
        return this.studentType != null ? this.studentType.code : null
    }
    
    /**
     * This method is used to return the studentType description for the StudentYear object
     *
     * @return the studentType descriptionCode for the StudentYear object
     */
    @JsonProperty(value = "_studentTypeDescription")
    public String get_StudentTypeDescription() {
        return this.studentType != null ? this.studentType.description : null
    }
    
    /**
     * This method is used to return the destination description for the StudentYear object
     *
     * @return the studentType descriptionCode for the StudentYear object
     */
    @JsonProperty(value = "_destinationDescription")
    public String get_DestinationDescription() {
        return this.destination != null ? this.destination.description : null
    }
    
    /**
     * This method is used to return the tutorGroup code for the StudentYear object
     *
     * @return the tutorGroup Code for the StudentYear object
     */
    @JsonProperty(value = "_tutorGroupCode")
    public String get_TutorGroupCode() {
        return this.tutorGroup != null ? this.tutorGroup.code : null
    }
    
    /**
     * This method is used to return the tutorGroup description for the StudentYear object
     *
     * @return the tutorGroup description for the StudentYear object
     */
    @JsonProperty(value = "_tutorGroupDescription")
    public String get_TutorGroupDescription() {
        return this.tutorGroup != null ? this.tutorGroup.description : null
    }
    
    /**
     * This method is used to return the tutorGroup tutor name for the StudentYear object
     *
     * @return the tutorGroup tutor name for the StudentYear object
     */
    @JsonProperty(value = "_tutorName")
    public String get_TutorName() {
        return this.tutorGroup != null && this.tutorGroup.tutor != null ? this.tutorGroup.tutor.knownAs : null
    }
    
    /**
     * This method is used to return the tutorGroup senior tutor Initials for the StudentYear object
     *
     * @return the tutorGroup tutor senior initials for the StudentYear object
     */
    @JsonProperty(value = "_seniorTutorInitials")
    public String get_SeniorTutorInitials() {
        return this.tutorGroup != null && this.tutorGroup.seniorTutor != null ? this.tutorGroup.seniorTutor.initials : null
    }
    
    /**
     * This method is used to return the tutorGroup senior tutor name for the StudentYear object
     *
     * @return the tutorGroup senior tutor name for the StudentYear object
     */
    @JsonProperty(value = "_seniorTutorName")
    public String get_SeniorTutorName() {
        return this.tutorGroup != null && this.tutorGroup.seniorTutor != null ? this.tutorGroup.seniorTutor.knownAs : null
    }
    
    /**
     * This method is used to return the tutorGroup  faculty Pastoral Director initials for the StudentYear object
     *
     * @return the tutorGroup faculty Pastoral Director initials for the StudentYear object
     */
    @JsonProperty(value = "_pastoralDirectorInitials")
    public String get_PastoralDirectorInitials() {
        return this.tutorGroup != null && this.tutorGroup.faculty != null && this.tutorGroup.faculty.pd != null ? this.tutorGroup.faculty.pd.initials : null
    }
    
    /**
     * This method is used to return the tutorGroup  faculty Pastoral Director Name for the StudentYear object
     *
     * @return the tutorGroup faculty Pastoral Director Name for the StudentYear object
     */
    @JsonProperty(value = "_pastoralDirectorName")
    public String get_PastoralDirectorName() {
        return this.tutorGroup != null && this.tutorGroup.faculty != null && this.tutorGroup.faculty.pd != null ? this.tutorGroup.faculty.pd.knownAs : null
    }
    
    /**
     * This method is used to return the tutorGroup  faculty Associate Pastoral Director Name for the StudentYear object
     *
     * @return the tutorGroup faculty Associate Pastoral Director Name for the StudentYear object
     */
    @JsonProperty(value = "_associatePastoralDirectorInitials")
    public String get_AssociatePastoralDirectorInitials() {
        return this.tutorGroup != null && this.tutorGroup.faculty != null && this.tutorGroup.faculty.apd != null ? this.tutorGroup.faculty.apd.initials : null
    }
    
    /**
     * This method is used to return the tutorGroup  faculty Associate Pastoral Director Name for the StudentYear object
     *
     * @return the tutorGroup faculty Associate Pastoral Director Name for the StudentYear object
     */
    @JsonProperty(value = "_associatePastoralDirectorName")
    public String get_AssociatePastoralDirectorName() {
        return this.tutorGroup != null && this.tutorGroup.faculty != null && this.tutorGroup.faculty.apd != null ? this.tutorGroup.faculty.apd.knownAs : null
    }
    
    /**
     * This method is used to return the tutorGroup tutor initials for the StudentYear object
     *
     * @return the tutorGroup tutor initials for the StudentYear object
     */
    @JsonProperty(value = "_tutorInitials")
    public String get_TutorInitials() {
        return this.tutorGroup != null && this.tutorGroup.tutor != null ? this.tutorGroup.tutor.initials : null
    }
    
    /**
     * This method is used to return the yearApplied for the StudentYear object
     *
     * @return the yearApplied for the StudentYear object
     */
    @JsonProperty(value = "_yearApplied")
    public String get_YearApplied() {
        return this.student.yearApplied != null ? this.student.yearApplied.code : null
    }
    
    /**
     * This method is used to return the tutorGroup  faculty Associate Pastoral Director Name for the StudentYear object
     *
     * @return the tutorGroup faculty Associate Pastoral Director Name for the StudentYear object
     */
    @JsonProperty(value = "_pastoralMonitor")
    public String get_PastoralMonitor() {
        return this.pastoralMonitor != null ? this.pastoralMonitor.knownAs : null
    }
}