package uk.ac.reigate.repositories.academic

import org.springframework.data.jpa.repository.JpaRepository

import uk.ac.reigate.domain.academic.GCSEScore
import uk.ac.reigate.domain.academic.Student

interface GCSEScoreRepository extends JpaRepository<GCSEScore, Integer> {
    
    GCSEScore findByStudent(Student student)
    
    GCSEScore findByStudentId(Integer studentId)
}
