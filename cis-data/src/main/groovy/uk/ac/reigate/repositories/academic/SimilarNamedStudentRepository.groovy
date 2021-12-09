package uk.ac.reigate.repositories.academic

import javax.transaction.Transactional

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.academic.SimilarNamedStudent
import uk.ac.reigate.domain.academic.SimilarNamedStudentPk


@Transactional
public interface SimilarNamedStudentRepository extends PagingAndSortingRepository<SimilarNamedStudent, SimilarNamedStudentPk> {
    
    List<SimilarNamedStudent> findByStudent_Id(Integer studentId)
}
