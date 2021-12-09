package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentDukeOfEdinburgh

interface StudentDukeOfEdinburghRepository extends CrudRepository<StudentDukeOfEdinburgh, Integer> {
    
    StudentDukeOfEdinburgh findByStudent(Student student)
    
    List<StudentDukeOfEdinburgh> findByStudent_Id(Integer studentId)
}
