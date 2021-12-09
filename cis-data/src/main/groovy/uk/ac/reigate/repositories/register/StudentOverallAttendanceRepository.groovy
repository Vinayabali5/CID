package uk.ac.reigate.repositories.register

import org.springframework.data.jpa.repository.JpaRepository

import uk.ac.reigate.domain.register.StudentOverallAttendance
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYearPk

interface StudentOverallAttendanceRepository extends JpaRepository<StudentOverallAttendance, StudentYearPk> {
    
    StudentOverallAttendance findByStudent(Student student)
    
    StudentOverallAttendance findByStudent_IdAndYear_Id(Integer studentId, Integer academicYearId)
}
