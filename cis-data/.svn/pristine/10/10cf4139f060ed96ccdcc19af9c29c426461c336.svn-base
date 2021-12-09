package uk.ac.reigate.repositories.exams.edi

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.exams.edi.EdiStatusType

interface EdiStatusTypeRepository extends CrudRepository<EdiStatusType, Integer> {
    
    List<EdiStatusType> findAll()
    
    EdiStatusType findByCode(String code)
}
