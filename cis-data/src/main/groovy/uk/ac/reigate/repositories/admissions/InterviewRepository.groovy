package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.admissions.Interview

interface InterviewRepository extends CrudRepository<Interview, Integer>{
    
    Interview findByStudentId(Integer id)
    
    // Interview findByApplication(Student application)
    
    List<Interview> findByStudent(Student student)
    
    List<Interview> findByStudent_Id(Integer id)
}