package uk.ac.reigate.repositories.academic

import javax.transaction.Transactional

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.PreReferencePk


@Transactional
public interface PreReferenceRepository extends PagingAndSortingRepository<PreReference, PreReferencePk> {
    
    List<PreReference> findByCourseId(Integer courseId)
    
    PreReference findByStudentIdAndCourseId(Integer studentId, Integer courseId)
}
