package uk.ac.reigate.repositories.academic

import org.springframework.data.jpa.repository.JpaRepository

import uk.ac.reigate.domain.academic.SchoolReference
import uk.ac.reigate.domain.academic.Student

interface SchoolReferenceRepository extends JpaRepository<SchoolReference, Integer> {
    
    SchoolReference findByStudent(Student student)
    
    SchoolReference findByStudentId(Integer studentId)
}
