package uk.ac.reigate.repositories.risk_assessment

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentRiskLevel

interface StudentRiskLevelRepository extends CrudRepository<StudentRiskLevel, Integer> {
    
    StudentRiskLevel findByStudent(Student student)
    
    List<StudentRiskLevel> findByStudent_Id(Integer studentId)
}
