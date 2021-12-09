package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.lookup.WarningCodeChange;

interface WarningCodeChangeRepository extends CrudRepository<WarningCodeChange, Integer> {
    
    List<WarningCodeChange> findByStudent_IdAndYear_Id(Integer studentId, Integer academicYearId)
    
    List<WarningCodeChange>  findByStudent_Id(Integer studentId)
}
