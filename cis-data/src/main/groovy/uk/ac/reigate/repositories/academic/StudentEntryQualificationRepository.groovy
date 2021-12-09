package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentEntryQualification


interface StudentEntryQualificationRepository extends CrudRepository<StudentEntryQualification, Integer> {
    
    StudentEntryQualification findByQualification_Id(Integer qualificationId)
    
    List<StudentEntryQualification> findByStudent(Student student)
    
    List<StudentEntryQualification> findByStudent_Id(Integer studentId)
    
    List<StudentEntryQualification> findByQualification(EntryQualification qualificationId)
    
    StudentEntryQualification findByStudent_IdAndId(Integer studentId, Integer Id)
}