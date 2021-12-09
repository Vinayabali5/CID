package uk.ac.reigate.dto.interimreport

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.CourseGroupBasicDto
import uk.ac.reigate.dto.CourseGroupSummaryDto
import uk.ac.reigate.dto.StudentSummaryDto
import uk.ac.reigate.dto.attendance.StudentCourseGroupAttendanceDto

/**
 * This class is used to transmit Interim Report data for a specific student and course group combination. The object 
 * should be constructed using the current and previous interim report data. 
 * 
 * @author Michael Horgan
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields = true)
class StudentCourseGroupInterimReportDto {
    
    @JsonProperty
    StudentSummaryDto student
    
    @JsonProperty
    CourseGroupBasicDto courseGroup
    
    @JsonProperty
    StudentInterimReportDto studentInterimReport
    
    @JsonProperty
    StudentInterimReportSummaryDto studentPreviousInterimReport
    
    @JsonProperty
    StudentCourseGroupAttendanceDto attendance
    
    /**
     * This constructor is used to create the DTO using the Student and CourseGroup data objects, along with
     * StudentInterimReport data for the current and previous interim reports. In addition the student attendance
     * data for the specific period should be supplied. 
     * 
     * @param student The Student data object to use for the creation
     * @param courseGroup The CourseGroup data object used for the creation
     * @param studentInterimReport The current StudentInterimReport data object 
     * @param studentPreviousInterimReport The previous StudentInterimReport data object
     * @param attendance The StudentCourseGroupAttendance data 
     */
    StudentCourseGroupInterimReportDto(Student student, CourseGroup courseGroup, StudentInterimReport studentInterimReport, StudentInterimReport studentPreviousInterimReport, StudentCourseGroupAttendance attendance) {
        this.student = new StudentSummaryDto(student)
        this.courseGroup = new CourseGroupSummaryDto(courseGroup)
        this.studentInterimReport = new StudentInterimReportDto(studentInterimReport)
        this.studentPreviousInterimReport = new StudentInterimReportSummaryDto(studentPreviousInterimReport)
        this.attendance = new StudentCourseGroupAttendanceDto(attendance)
    }
    
    /**
     * This constructor is used to create the DTO using the Enrolment data objects, containing both Student and CourseGroup,
     * along with StudentInterimReport data for the current and previous interim reports. In addition the student attendance
     * data for the specific period should be supplied. 
     * 
     * @param enrolment The Enrolment data object to use for the creation
     * @param studentInterimReport The current StudentInterimReport data object 
     * @param studentPreviousInterimReport The previous StudentInterimReport data object
     * @param attendance The StudentCourseGroupAttendance data 
     */
    StudentCourseGroupInterimReportDto(Enrolment enrolment, StudentInterimReport studentInterimReport, StudentInterimReport studentPreviousInterimReport, StudentCourseGroupAttendance attendance) {
        this.student = new StudentSummaryDto(enrolment.student)
        this.courseGroup = new CourseGroupSummaryDto(enrolment.courseGroup)
        this.studentInterimReport = new StudentInterimReportDto(studentInterimReport)
        this.studentPreviousInterimReport = new StudentInterimReportSummaryDto(studentPreviousInterimReport)
        this.attendance = new StudentCourseGroupAttendanceDto(attendance)
    }
}
