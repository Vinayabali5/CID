package uk.ac.reigate.repositories.exams.edi

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.exams.edi.StatusType

interface StatusTypeRepository extends CrudRepository<StatusType, Integer> {
    
    List<StatusType> findAll()
    
    StatusType findByCode(String code)
}
