package uk.ac.reigate.dto.interimreport

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.CourseGroupBasicDto
import uk.ac.reigate.dto.CourseGroupSummaryDto
import uk.ac.reigate.dto.CourseSummaryDto
import uk.ac.reigate.dto.lookup.PossibleGradeSummaryDto


/**
 *
 * JSON serializable DTO containing Holiday data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class StudentInterimReportSummaryDto {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    InterimReportSummaryDto interimReport
    
    @JsonProperty
    Integer interimReportId
    
    @JsonProperty
    CourseSummaryDto course
    
    @JsonProperty
    CourseGroupBasicDto courseGroup
    
    @JsonProperty
    Integer courseId
    
    @JsonProperty
    Integer courseGroupId
    
    @JsonProperty
    Integer staffId
    
    @JsonProperty
    Integer motivationId
    
    @JsonProperty
    Integer classEthicId
    
    @JsonProperty
    Integer timeManagementId
    
    @JsonProperty
    Integer totalPossible
    
    @JsonProperty
    Integer absence
    
    @JsonProperty
    Integer authorisedAbsence
    
    @JsonProperty
    Integer late
    
    @JsonProperty
    PossibleGradeSummaryDto currentPredictedGrade
    
    @JsonProperty
    PossibleGradeSummaryDto keyAssessment1
    
    @JsonProperty
    PossibleGradeSummaryDto keyAssessment2
    
    @JsonProperty
    Integer currentPredictedGradeId
    
    @JsonProperty
    Integer keyAssessment1Id
    
    @JsonProperty
    Integer keyAssessment2Id
    
    /**
     * Default No Args constructor
     */
    StudentInterimReportSummaryDto() {}
    
    /**
     * Constructor to create a StudentInterimReportDto object from a StudentInterimReport object
     *
     * @param studentInterimReport the StudentInterimReport object to use for construction
     */
    StudentInterimReportSummaryDto(StudentInterimReport studentInterimReport){
        if (studentInterimReport != null) {
            this.id = studentInterimReport.id
            this.studentId = studentInterimReport.student != null ? studentInterimReport.student.id : null;
            this.interimReportId = studentInterimReport.interimReport != null ? studentInterimReport.interimReport.id : null;
            
            this.interimReport = studentInterimReport.interimReport != null ? InterimReportSummaryDto.mapFromEntity(studentInterimReport.interimReport) : null;
            
            this.course = studentInterimReport.course != null ? CourseSummaryDto.mapFromEntity(studentInterimReport.course) : null;
            this.courseGroup = studentInterimReport.courseGroup != null ? CourseGroupSummaryDto.mapFromEntity(studentInterimReport.courseGroup) : null
            
            this.courseId = studentInterimReport.course != null ? studentInterimReport.course.id : null;
            this.courseGroupId = studentInterimReport.courseGroup != null ? studentInterimReport.courseGroup.id : null;
            
            this.staffId = studentInterimReport.staff != null ? studentInterimReport.staff.id : null;
            
            this.motivationId = studentInterimReport.motivation != null ? studentInterimReport.motivation.id : null;
            this.classEthicId = studentInterimReport.classEthic != null ? studentInterimReport.classEthic.id : null;
            this.timeManagementId = studentInterimReport.timeManagement != null ? studentInterimReport.timeManagement.id : null;
            
            this.totalPossible = studentInterimReport.totalPossible != null ? studentInterimReport.totalPossible : null;
            this.absence = studentInterimReport.absence != null ? studentInterimReport.absence : null;
            this.authorisedAbsence = studentInterimReport.authorisedAbsence != null ? studentInterimReport.authorisedAbsence : null;
            this.late = studentInterimReport.late != null ? studentInterimReport.late : null;
            
            this.currentPredictedGrade = studentInterimReport.currentPredictedGrade != null ? PossibleGradeSummaryDto.mapFromEntity(studentInterimReport.currentPredictedGrade) : null
            this.keyAssessment1 = studentInterimReport.keyAssessment1 != null ? PossibleGradeSummaryDto.mapFromEntity(studentInterimReport.keyAssessment1) : null
            this.keyAssessment2 = studentInterimReport.keyAssessment2 != null ? PossibleGradeSummaryDto.mapFromEntity(studentInterimReport.keyAssessment2) : null
            
            this.currentPredictedGradeId = studentInterimReport.currentPredictedGrade != null ? studentInterimReport.currentPredictedGrade.id : null;
            this.keyAssessment1Id = studentInterimReport.keyAssessment1 != null ? studentInterimReport.keyAssessment1.id : null;
            this.keyAssessment2Id = studentInterimReport.keyAssessment2 != null ? studentInterimReport.keyAssessment2.id : null;
        }
    }
    
    /**
     * This static method is used to create a StudentInterimReportDto from a StudentInterimReport data object.
     * 
     * @param studentInterimReport the StudentInterimReport data object to use for the creation.
     * @return a StudentInterimReportDto object based on the StudentInterimReport data object supplied.
     */
    public static StudentInterimReportSummaryDto mapFromEntity(StudentInterimReport studentInterimReport) {
        return new StudentInterimReportSummaryDto(studentInterimReport);
    }
    
    /**
     * This static method is used to create a List of StudentInterimReportDto from a List of StudentInterimReport data object.
     *
     * @param studentInterimReports the List of StudentInterimReport data object to use for the creation.
     * @return a List of StudentInterimReportDto object based on the List of StudentInterimReport data object supplied.
     */
    public static List<StudentInterimReportSummaryDto> mapFromList(List<StudentInterimReport> studentInterimReports) {
        return studentInterimReports.collect { studentInterimReport ->  new StudentInterimReportSummaryDto(studentInterimReport) };
    }
    
    @JsonProperty(value = "_interimReportDescription")
    public String get_InterimReportDescription() {
        return this.interimReport != null ? this.interimReport.description : null
    }
    
    @JsonProperty(value = "_courseDescription")
    public String get_CourseDescription() {
        return this.course != null ? this.course.spec : null;
    }
    
    @JsonProperty(value = "_courseGroupDescription")
    public String get_CourseGroupDescription() {
        return this.courseGroup != null ? this.courseGroup.spec : null;
    }
    
    @JsonProperty(value = "_currentPredictedGrade")
    public String get_CurrentPredictedGrade() {
        return this.currentPredictedGrade != null ? this.currentPredictedGrade.grade : null
    }
    
    @JsonProperty(value = "_keyAssessment1Grade")
    public String get_KeyAssessment1Grade() {
        return this.keyAssessment1 != null ? this.keyAssessment1.grade : null
    }
    
    @JsonProperty(value = "_keyAssessment2Grade")
    public String get_KeyAssessment2Grade() {
        return this.keyAssessment2 != null ? this.keyAssessment2.grade : null
    }
    
    @JsonProperty(value = "_averageEffort")
    public Float get_AverageEffort() {
        if (this.motivationId != null && this.classEthicId != null && this.timeManagementId != null) {
            return (this.motivationId + this.classEthicId + this.timeManagementId) / 3
        }
    }
    
    @JsonProperty(value = "_attendancePercentage")
    public Float get_AttendancePercentage() {
        if (this.totalPossible != null && this.absence != null && this.authorisedAbsence != null && this.totalPossible != 0) {
            return (this.totalPossible - this.absence) / this.totalPossible
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_adjustedAttendancePercentage")
    public Float get_AdjustedAttendancePercentage() {
        if (this.totalPossible != null && this.absence != null && this.authorisedAbsence != null && this.totalPossible != 0) {
            return (this.totalPossible - (this.absence - this.authorisedAbsence)) / this.totalPossible
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_punctualityPercentage")
    public Float get_PunctualityPercentage() {
        if (this.totalPossible != null && this.absence != null && this.late != null && this.totalPossible - this.absence != 0) {
            return ((this.totalPossible - this.absence) - this.late) / (this.totalPossible - this.absence)
        } else {
            return null
        }
    }
}

