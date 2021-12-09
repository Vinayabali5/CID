package uk.ac.reigate.dto.attendance

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.dto.AcademicYearDto
import uk.ac.reigate.dto.CourseGroupSummaryDto
import uk.ac.reigate.dto.CourseSummaryDto
import uk.ac.reigate.dto.StudentSummaryDto

/**
 * This class is used as a DTO for the attendance figures for a specific student in a specific course group. 
 * 
 *
 */
class StudentAttendanceByCourseGroupForPeriodDto {
    
    AcademicYearDto year
    
    StudentSummaryDto student
    
    CourseSummaryDto course
    
    CourseGroupSummaryDto courseGroup
    
    String courseSpec
    
    Integer overallTotal
    
    Integer overallIncluded
    
    Integer overallPresent
    
    Integer overallAbsent
    
    Integer overallAuthorisedAbsent
    
    Integer overallLate
    
    Integer overallAuthorisedLate
    
    Date periodStartDate
    
    Date periodEndDate
    
    Integer total
    
    Integer included
    
    Integer present
    
    Integer absent
    
    Integer authorisedAbsent
    
    Integer late
    
    Integer authorisedLate
    
    public StudentAttendanceByCourseGroupForPeriodDto(StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod) {
        if(studentAttendanceByCourseGroupForPeriod != null) {
            this.year = AcademicYearDto.mapFromEntity(studentAttendanceByCourseGroupForPeriod.year)
            this.student = StudentSummaryDto.mapFromEntity(studentAttendanceByCourseGroupForPeriod.student)
            this.course = CourseSummaryDto.mapFromEntity(studentAttendanceByCourseGroupForPeriod.course)
            this.courseGroup = CourseGroupSummaryDto.mapFromEntity(studentAttendanceByCourseGroupForPeriod.courseGroup)
            this.courseSpec = studentAttendanceByCourseGroupForPeriod.courseSpec
            this.overallTotal = studentAttendanceByCourseGroupForPeriod.overallTotal
            this.overallIncluded = studentAttendanceByCourseGroupForPeriod.overallIncluded
            this.overallPresent = studentAttendanceByCourseGroupForPeriod.overallPresent
            this.overallAbsent = studentAttendanceByCourseGroupForPeriod.overallAbsent
            this.overallAuthorisedAbsent = studentAttendanceByCourseGroupForPeriod.overallAuthorisedAbsent
            this.overallLate = studentAttendanceByCourseGroupForPeriod.overallLate
            this.overallAuthorisedLate = studentAttendanceByCourseGroupForPeriod.overallAuthorisedLate
            this.periodStartDate = studentAttendanceByCourseGroupForPeriod.periodStartDate
            this.periodEndDate = studentAttendanceByCourseGroupForPeriod.periodEndDate
            this.total = studentAttendanceByCourseGroupForPeriod.total
            this.included = studentAttendanceByCourseGroupForPeriod.included
            this.present = studentAttendanceByCourseGroupForPeriod.present
            this.absent = studentAttendanceByCourseGroupForPeriod.absent
            this.authorisedAbsent = studentAttendanceByCourseGroupForPeriod.authorisedAbsent
            this.late = studentAttendanceByCourseGroupForPeriod.late
            this.authorisedLate = studentAttendanceByCourseGroupForPeriod.authorisedLate
        }
    }
    
    public static StudentAttendanceByCourseGroupForPeriodDto mapFromEntity(StudentAttendanceByCourseGroupForPeriod studentAttendanceByCourseGroupForPeriod) {
        return new StudentAttendanceByCourseGroupForPeriodDto(studentAttendanceByCourseGroupForPeriod)
    }
    
    public static List<StudentAttendanceByCourseGroupForPeriodDto> mapFromList(List<StudentAttendanceByCourseGroupForPeriod> studentAttendanceByCourseGroupForPeriods) {
        return studentAttendanceByCourseGroupForPeriods.collect { studentAttendanceByCourseGroupForPeriod ->  mapFromEntity(studentAttendanceByCourseGroupForPeriod) }
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
        if (this.included != null && this.absent != null && this.late != null && this.included != 0) {
            return ((this.included - this.absent) - this.late) / (this.included - this.absent)
        } else {
            return null
        }
    }
}
