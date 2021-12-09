package uk.ac.reigate.repositories.attendance

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.domain.attendance.StudentCourseGroupPk

/**
 * This repository class is used to access data from various table-valued functions to calculate student attendance figures. The 
 * following functions are used: 
 * <ul>
 * <li>[Attendance].[AllStudentAttendanceByCourseGroupForPeriod]</li>
 * <li>[Attendance].[StudentAttendanceByCourseGroupForPeriod]</li>
 * </ul>
 * 
 * @author Michael Horgan
 *
 */
interface StudentCourseGroupAttendanceRepository extends Repository<StudentCourseGroupAttendance, StudentCourseGroupPk> {
    
    /**
     * This method is used to retrieve a List of StudentCourseGroupAttendance figures for all students and course groups, using the data range 
     * supplied to calculate the attendance figure.
     * 
     * @param startDate the start date for the date range to use for the attendance calculations.
     * @param endDate the end date for the date range to use for the attendance calculations.
     * @return a List of StudentCourseGroupAttendance matching the desired search range.
     */
    @Query(nativeQuery = true, value = "SELECT * FROM [Attendance].[AllStudentAttendanceByCourseGroupForPeriod](:startDate, :endDate)")
    List<StudentCourseGroupAttendance> findAllByDateRange(@Param('startDate') Date startDate, @Param('endDate') Date endDate)
    
    /**
     * This method is used to retrieve a List of StudentCourseGroupAttendance figures for a specific student, using the data range 
     * supplied to calculate the attendance figure.
     * 
     * @param studentId the student ID for the specific student.
     * @param startDate the start date for the date range to use for the attendance calculations.
     * @param endDate the end date for the date range to use for the attendance calculations.
     * @return a List of StudentCourseGroupAttendance matching the desired student and search range.
     */
    @Query(nativeQuery = true, value = "SELECT * FROM [Attendance].[StudentAttendanceByCourseGroupForPeriod](:studentId, :startDate, :endDate)")
    List<StudentCourseGroupAttendance> findByStudentIdForDateRange(@Param('studentId') Integer studentId, @Param('startDate') Date startDate, @Param('endDate') Date endDate)
    
    /**
     * This method is used to retrieve a List of StudentCourseGroupAttendance figures for a specific student and course group, using the data range 
     * supplied to calculate the attendance figure.
     *     
     * @param studentId the student ID for the specific student.
     * @param courseGroupId the course group ID for the specific course group.
     * @param startDate the start date for the date range to use for the attendance calculations.
     * @param endDate the end date for the date range to use for the attendance calculations.
     * @return a StudentCourseGroupAttendance matching the desired student, course group and search range.
     */
    @Query(nativeQuery = true, value = "SELECT * FROM [Attendance].[StudentAttendanceByCourseGroupForPeriod](:studentId, :startDate, :endDate) WHERE course_group_id = :courseGroupId")
    StudentCourseGroupAttendance findByStudentIdAndCourseGroupIdForDateRange(@Param('studentId') Integer studentId, @Param('courseGroupId') Integer courseGroupId, @Param('startDate') Date startDate, @Param('endDate') Date endDate)
}
