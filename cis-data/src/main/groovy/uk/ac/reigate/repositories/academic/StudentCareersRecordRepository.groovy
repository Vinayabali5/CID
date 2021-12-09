package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentCareersRecord

interface StudentCareersRecordRepository extends CrudRepository<StudentCareersRecord, Integer> {
    
    StudentCareersRecord findByStudent(Student student)
    
    List<StudentCareersRecord> findByStudent_Id(Integer studentId)
    
    List<StudentCareersRecord> findByCareersRecordType_Id(Integer careersRecordTypeId)
}
