package uk.ac.reigate.repositories.risk_assessment

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.risk_assessment.StudentSafetyPlan

interface StudentSafetyPlanRepository extends CrudRepository<StudentSafetyPlan, Integer> {
    
    StudentSafetyPlan findByStudent(Student student)
    
    StudentSafetyPlan findByStudent_Id(Integer studentId)
}
