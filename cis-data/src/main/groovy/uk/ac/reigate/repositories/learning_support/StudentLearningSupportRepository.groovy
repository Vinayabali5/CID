package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentLearningSupport

interface StudentLearningSupportRepository extends CrudRepository<StudentLearningSupport, Integer> {
    
    StudentLearningSupport findByStudent(Student student)
    
    StudentLearningSupport findByStudent_Id(Integer studentId)
}
