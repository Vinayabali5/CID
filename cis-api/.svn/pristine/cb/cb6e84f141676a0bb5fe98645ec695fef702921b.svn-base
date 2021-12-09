package uk.ac.reigate.dto.attendance

import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.dto.StudentSummaryDto

/**
 * This class is used as a DTO for the attendance figures for a specific student in a specific course group. 
 * 
 * @author Michael Horgan
 *
 */
class StudentCourseGroupAttendanceDto {
    
    //AcademicYearDto year
    
    StudentSummaryDto student
    
    //CourseSummaryDto course
    
    //CourseGroupSummaryDto courseGroup
    
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
    
    public StudentCourseGroupAttendanceDto(StudentCourseGroupAttendance studentCourseGroupAttendance) {
        if(studentCourseGroupAttendance != null) {
            //this.year = AcademicYearDto.mapFromEntity(studentCourseGroupAttendance.year)
            this.student = StudentSummaryDto.mapFromEntity(studentCourseGroupAttendance.student)
            //this.course = CourseSummaryDto.mapFromEntity(studentCourseGroupAttendance.course)
            //this.courseGroup = CourseGroupSummaryDto.mapFromEntity(studentCourseGroupAttendance.courseGroup)
            this.courseSpec = studentCourseGroupAttendance.courseSpec
            this.overallTotal = studentCourseGroupAttendance.overallTotal
            this.overallIncluded = studentCourseGroupAttendance.overallIncluded
            this.overallPresent = studentCourseGroupAttendance.overallPresent
            this.overallAbsent = studentCourseGroupAttendance.overallAbsent
            this.overallAuthorisedAbsent = studentCourseGroupAttendance.overallAuthorisedAbsent
            this.overallLate = studentCourseGroupAttendance.overallLate
            this.overallAuthorisedLate = studentCourseGroupAttendance.overallAuthorisedLate
            this.periodStartDate = studentCourseGroupAttendance.periodStartDate
            this.periodEndDate = studentCourseGroupAttendance.periodEndDate
            this.total = studentCourseGroupAttendance.total
            this.included = studentCourseGroupAttendance.included
            this.present = studentCourseGroupAttendance.present
            this.absent = studentCourseGroupAttendance.absent
            this.authorisedAbsent = studentCourseGroupAttendance.authorisedAbsent
            this.late = studentCourseGroupAttendance.late
            this.authorisedLate = studentCourseGroupAttendance.authorisedLate
        }
    }
    
    public static StudentCourseGroupAttendanceDto mapFromEntity(StudentCourseGroupAttendance studentCourseGroupAttendance) {
        return new StudentCourseGroupAttendanceDto(studentCourseGroupAttendance)
    }
    
    public static List<StudentCourseGroupAttendanceDto> mapFromList(List<StudentCourseGroupAttendance> studentCourseGroupAttendances) {
        return studentCourseGroupAttendances.collect { studentCourseGroupAttendance ->  mapFromEntity(studentCourseGroupAttendance) }
    }
}
