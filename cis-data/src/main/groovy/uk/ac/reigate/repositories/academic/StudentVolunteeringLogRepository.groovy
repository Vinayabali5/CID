package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentVolunteeringLog

interface StudentVolunteeringLogRepository extends CrudRepository<StudentVolunteeringLog, Integer> {
    
    StudentVolunteeringLog findByStudent(Student student)
    
    List<StudentVolunteeringLog> findByStudent_Id(Integer studentId)
    
    List<StudentVolunteeringLog> findByVolunteeringType_Id(Integer volunteeringTypeId)
}
