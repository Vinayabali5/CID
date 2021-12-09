package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentPredictedGrade


interface StudentPredictedGradeRepository extends CrudRepository<StudentPredictedGrade, Integer> {
    
    List<StudentPredictedGrade> findByStudent(Student student)
    
    List<StudentPredictedGrade> findByStudent_Id(Integer studentId)
    
    StudentPredictedGrade findByStudent_IdAndId(Integer studentId, Integer Id)
}