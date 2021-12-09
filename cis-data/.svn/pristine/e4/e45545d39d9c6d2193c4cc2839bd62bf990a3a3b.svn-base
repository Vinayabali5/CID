package uk.ac.reigate.repositories.ilp

import java.util.List;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilp.Correspondence


interface CorrespondenceRepository extends CrudRepository<Correspondence, Integer> {
    
    List<Correspondence> findByStudent_Id(Integer studentId)
    
    Correspondence findByStudent_IdAndId(Integer studentId, Integer Id)
}
