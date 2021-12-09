package uk.ac.reigate.repositories.attendance

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.attendance.StudentAttendance
import uk.ac.reigate.domain.attendance.StudentAttendancePk

interface StudentAttendanceRepository extends CrudRepository<StudentAttendance, StudentAttendancePk> {
    
    List<StudentAttendance> findByCourseId(Integer courseId)
    
    @Query(nativeQuery = true, value = "SELECT * FROM [Attendance].[StudentAttendance](:academicYear, :studentId, :startDate, :endDate) WHERE course_id = :courseId")
    StudentAttendance findByAcademicYearStudentIdAndCourseIdForDateRange(@Param('academicYear')AcademicYear academicYear, @Param('studentId') Integer studentId, @Param('courseId') Integer courseId, @Param('startDate') Date startDate, @Param('endDate') Date endDate)
    
    
    StudentAttendance findByStudentIdAndCourseId(Integer interimReport, Integer courseId)
}
