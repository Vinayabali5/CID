package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.IdentificationViolation

interface IdentificationViolationRepository extends CrudRepository<IdentificationViolation, Integer> {
    
    List<IdentificationViolation> findByStudentId(Integer studentId)
}
