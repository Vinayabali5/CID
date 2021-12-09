package uk.ac.reigate.repositories.risk_assessment

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentRiskAssessment

interface StudentRiskAssessmentRepository extends CrudRepository<StudentRiskAssessment, Integer> {
    
    StudentRiskAssessment findByStudent(Student student)
    
    StudentRiskAssessment findByStudent_Id(Integer studentId)
}
