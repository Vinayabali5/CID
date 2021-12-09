package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentLLDDHealthProblemCategory

interface StudentLLDDHealthProblemCategoryRepository extends CrudRepository<StudentLLDDHealthProblemCategory, Integer> {
    
    List<StudentLLDDHealthProblemCategory> findByStudent(Student student)
    
    List<StudentLLDDHealthProblemCategory> findByStudent_Id(Integer studentId)
}
