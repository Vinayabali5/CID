package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentWorkPlacement

interface StudentWorkPlacementRepository extends CrudRepository<StudentWorkPlacement, Integer> {
    
    StudentWorkPlacement findByStudent(Student student)
    
    List<StudentWorkPlacement> findByStudent_Id(Integer studentId)
    
    List<StudentWorkPlacement> findByWorkPlacementMode_Id(Integer workPlacementModeId)
}
