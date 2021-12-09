package uk.ac.reigate.repositories.attendance

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriodPk
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance


/**
 * This repository class is used to access data from various table-valued functions to calculate student attendance figures. The 
 * following functions are used: 
 *
 */
interface StudentAttendanceByCourseGroupForPeriodRepository extends Repository<StudentAttendanceByCourseGroupForPeriod, StudentAttendanceByCourseGroupForPeriodPk> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM [Attendance].[StudentAttendanceByCourseGroupForPeriod](:studentId, :startDate, :endDate) WHERE course_group_id = :courseGroupId")
    StudentAttendanceByCourseGroupForPeriod findByStudentIdAndCourseGroupIdForDateRange(@Param('studentId') Integer studentId, @Param('courseGroupId') Integer courseGroupId, @Param('startDate') Date startDate, @Param('endDate') Date endDate)
}
