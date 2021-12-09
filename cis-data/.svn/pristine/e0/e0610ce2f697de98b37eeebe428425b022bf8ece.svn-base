package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentReferralReason

interface StudentReferralReasonRepository extends CrudRepository<StudentReferralReason, Integer> {
    
    List<StudentReferralReason> findByStudent(Student student)
    
    List<StudentReferralReason> findByStudent_Id(Integer studentId)
    
    StudentReferralReason findByStudent_IdAndReferralReason_Id(Integer studentId, Integer referralReasonId)
}
