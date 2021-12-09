package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionTypePk

interface StudentConcessionTypeRepository extends CrudRepository<StudentConcessionType, StudentConcessionTypePk> {
    
    List<StudentConcessionType> findByStudent(Student student)
    
    List<StudentConcessionType> findByStudent_Id(Integer studentId)
    
    StudentConcessionType findByStudent_IdAndConcessionType_Id(Integer studentId, Integer concessionType)
}
