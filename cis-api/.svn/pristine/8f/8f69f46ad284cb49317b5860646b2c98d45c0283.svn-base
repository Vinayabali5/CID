package uk.ac.reigate.dto.interimreport

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.CourseGroupSummaryDto
import uk.ac.reigate.dto.StudentMasterReviewDto
import uk.ac.reigate.dto.attendance.StudentAttendanceByCourseGroupForPeriodDto


/**
 *
 * JSON serializable DTO containing Holiday data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class InterimReportDataCollectionDto {
    
    @JsonProperty
    Integer studentInterimReportId;
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    StudentMasterReviewDto student
    
    @JsonProperty
    InterimReportSummaryDto interimReport
    
    @JsonProperty
    Integer interimReportId
    
    @JsonProperty
    CourseGroupSummaryDto courseGroup
    
    @JsonProperty
    Integer courseId
    
    @JsonProperty
    Integer courseGroupId
    
    @JsonProperty
    Integer totalPossible
    
    @JsonProperty
    Integer absence
    
    @JsonProperty
    Integer authorisedAbsence
    
    @JsonProperty
    Integer late
    
    @JsonProperty
    Integer motivationId
    
    @JsonProperty
    Integer classEthicId
    
    @JsonProperty
    Integer timeManagementId
    
    @JsonProperty
    Integer keyAssessment1Id
    
    @JsonProperty
    Integer keyAssessment2Id
    
    @JsonProperty
    Integer keyAssessment3Id
    
    @JsonProperty
    Integer overallTotal
    
    @JsonProperty
    Integer overallIncluded
    
    @JsonProperty
    Integer overallPresent
    
    @JsonProperty
    Integer overallAbsent
    
    @JsonProperty
    Integer overallAuthorisedAbsent
    
    @JsonProperty
    Integer overallLate
    
    @JsonProperty
    Integer overallAuthorisedLate
    
    @JsonProperty
    Integer total
    
    @JsonProperty
    Integer included
    
    @JsonProperty
    Integer present
    
    @JsonProperty
    Integer absent
    
    @JsonProperty
    Integer authorisedAbsent
    
    @JsonProperty
    Integer totalLate
    
    @JsonProperty
    Integer authorisedLate
    
    
    /**
     * Default No Args constructor
     */
    InterimReportDataCollectionDto() {}
    
    /**
     * Constructor to create a StudentInterimReportDto object from a StudentInterimReport object
     *
     * @param studentInterimReport the StudentInterimReport object to use for construction
     */
    InterimReportDataCollectionDto(StudentInterimReport studentInterimReport, StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod) {
        if (studentInterimReport != null && studentAttendanceByCourseGroupForPeriod != null) {
            this.studentInterimReportId = studentInterimReport.id
            this.studentId = studentInterimReport.student != null ? studentInterimReport.student.id : null;
            this.student = studentInterimReport.student != null ? StudentMasterReviewDto.mapFromEntity(studentInterimReport.student) : null;
            this.interimReportId = studentInterimReport.interimReport != null ? studentInterimReport.interimReport.id : null;
            this.interimReport = studentInterimReport.interimReport != null ? InterimReportSummaryDto.mapFromEntity(studentInterimReport.interimReport) : null;
            this.courseGroup = studentInterimReport.courseGroup != null ? CourseGroupSummaryDto.mapFromEntity(studentInterimReport.courseGroup) : null
            this.courseGroupId = studentInterimReport.courseGroup != null ? studentInterimReport.courseGroup.id : null;
            this.courseId = studentInterimReport.course != null ? studentInterimReport.course.id : null;
            this.totalPossible = studentInterimReport.totalPossible != null ? studentInterimReport.totalPossible : null;
            this.absence = studentInterimReport.absence != null ? studentInterimReport.absence : null;
            this.authorisedAbsence = studentInterimReport.authorisedAbsence != null ? studentInterimReport.authorisedAbsence : null;
            this.late = studentInterimReport.late != null ? studentInterimReport.late : null;
            this.motivationId = studentInterimReport.motivation != null ? studentInterimReport.motivation.id : null;
            this.classEthicId = studentInterimReport.classEthic != null ? studentInterimReport.classEthic.id : null;
            this.timeManagementId = studentInterimReport.timeManagement != null ? studentInterimReport.timeManagement.id : null;
            this.keyAssessment1Id = studentInterimReport.keyAssessment1 != null ? studentInterimReport.keyAssessment1.id : null;
            this.keyAssessment2Id = studentInterimReport.keyAssessment2 != null ? studentInterimReport.keyAssessment2.id : null;
            this.keyAssessment3Id = studentInterimReport.keyAssessment3 != null ? studentInterimReport.keyAssessment3.id : null;
            this.overallTotal = studentAttendanceByCourseGroupForPeriod.overallTotal
            this.overallIncluded = studentAttendanceByCourseGroupForPeriod.overallIncluded
            this.overallPresent = studentAttendanceByCourseGroupForPeriod.overallPresent
            this.overallAbsent = studentAttendanceByCourseGroupForPeriod.overallAbsent
            this.overallAuthorisedAbsent = studentAttendanceByCourseGroupForPeriod.overallAuthorisedAbsent
            this.overallLate = studentAttendanceByCourseGroupForPeriod.overallLate
            this.overallAuthorisedLate = studentAttendanceByCourseGroupForPeriod.overallAuthorisedLate
            this.total = studentAttendanceByCourseGroupForPeriod.total
            this.included = studentAttendanceByCourseGroupForPeriod.included
            this.present = studentAttendanceByCourseGroupForPeriod.present
            this.absent = studentAttendanceByCourseGroupForPeriod.absent
            this.authorisedAbsent = studentAttendanceByCourseGroupForPeriod.authorisedAbsent
            this.totalLate = studentAttendanceByCourseGroupForPeriod.late
            this.authorisedLate = studentAttendanceByCourseGroupForPeriod.authorisedLate
        }
    }
    
    /**
     * This static method is used to create a StudentInterimReportDto from a StudentInterimReport data object.
     * 
     * @param studentInterimReport the StudentInterimReport data object to use for the creation.
     * @return a StudentInterimReportDto object based on the StudentInterimReport data object supplied.
     */
    public static InterimReportDataCollectionDto mapFromEntity(StudentInterimReport studentInterimReport, StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod) {
        return new InterimReportDataCollectionDto(studentInterimReport, studentAttendanceByCourseGroupForPeriod);
    }
    
    /**
     * This static method is used to create a List of StudentInterimReportDto from a List of StudentInterimReport data object.
     *
     * @param studentInterimReports the List of StudentInterimReport data object to use for the creation.
     * @return a List of StudentInterimReportDto object based on the List of StudentInterimReport data object supplied.
     */
    public static List<InterimReportDataCollectionDto> mapFromList(List<StudentInterimReport> studentInterimReports) {
        return studentInterimReports.collect { studentInterimReport ->  new InterimReportDataCollectionDto(studentInterimReport) };
    }
    
    @JsonProperty(value = "_YAdjAtt")
    public Float get_YAdjAtt() {
        if (this.overallIncluded != null && this.overallAbsent != null && this.overallAuthorisedAbsent != null && this.overallIncluded != 0) {
            return (this.overallIncluded - (this.overallAbsent - this.overallAuthorisedAbsent)) / this.overallIncluded
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_YActAtt")
    public Float get_YActAtt() {
        if (this.overallIncluded != null && this.overallAbsent != null && this.overallIncluded != 0) {
            return (this.overallIncluded - this.overallAbsent) / this.overallIncluded
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_YPunc")
    public Float get_YPunc() {
        if (this.overallIncluded != null && this.overallAbsent != null && this.overallLate != null && this.overallIncluded != 0) {
            return ((this.overallIncluded - this.overallAbsent) - this.overallLate) / (this.overallIncluded - this.overallAbsent)
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_YAdjPunc")
    public Float get_YAdjPunc() {
        if (this.overallIncluded != null && this.overallAbsent != null && this.overallLate != null && this.overallAuthorisedLate != null && this.overallIncluded != 0) {
            return ((this.overallIncluded - this.overallAbsent) - (this.overallLate - this.overallAuthorisedLate)) / (this.overallIncluded - this.overallAbsent)
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_PeriodAdjAtt")
    public Float get_PeriodAdjAtt() {
        if (this.included != null && this.absent != null && this.authorisedAbsent != null && this.included != 0) {
            return (this.included - (this.absent - this.authorisedAbsent)) / this.included
        } else {
            return null
        }
    }
    
    
    @JsonProperty(value = "_PeriodActAtt")
    public Float get_PeriodActAtt() {
        if (this.included != null && this.absent != null && this.included != 0) {
            return (this.included - this.absent) / this.included
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_PeriodPunc")
    public Float get_PeriodPunc() {
        if (this.included != null && this.absent != null && this.totalLate != null && this.included != 0) {
            return ((this.included - this.absent) - this.totalLate) / (this.included - this.absent)
        } else {
            return null
        }
    }
    
    @JsonProperty(value = "_PeriodAdjPunc")
    public Float get_PeriodAdjPunc() {
        if (this.included != null && this.absent != null && this.totalLate != null && this.authorisedLate != null && this.included != 0) {
            return ((this.included - this.absent) - (this.totalLate - this.authorisedLate)) / (this.included - this.absent)
        } else {
            return null
        }
    }
}