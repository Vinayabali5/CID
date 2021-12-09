package uk.ac.reigate.repositories.exams

import javax.transaction.Transactional

import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.CourseOptionPk

@Transactional
public interface CourseOptionRepository extends PagingAndSortingRepository<CourseOption, CourseOptionPk>, QuerydslPredicateExecutor<CourseOption> {
    
    List<CourseOption> findByCourseId(Integer courseId)
    
    List<CourseOption> findByExamOptionId(Integer examOptionId)
    
    CourseOption findByCourse_IdAndExamOptionId(Integer courseId, Integer examOptionId)
}
