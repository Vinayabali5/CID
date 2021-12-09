package uk.ac.reigate.repositories.academic

import java.util.List;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.ExternalResultsArchive


interface ExternalResultsArchiveRepository extends CrudRepository<ExternalResultsArchive, Integer> {
    
    List<ExternalResultsArchive> findByStudent_Id(Integer studentId)
    
    ExternalResultsArchive findByStudent_IdAndId(Integer studentId, Integer Id)
}
