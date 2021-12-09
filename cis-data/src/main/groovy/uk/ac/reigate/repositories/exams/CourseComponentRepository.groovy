package uk.ac.reigate.repositories.exams

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.exams.CourseComponent
import uk.ac.reigate.domain.exams.CourseComponentPk

@Transactional
public interface CourseComponentRepository extends PagingAndSortingRepository<CourseComponent, CourseComponentPk> {
    
    CourseComponent findByCourse_IdAndExamOption_IdAndExamComponent_Id(Integer courseId, Integer examOptionId, Integer examComponentId)
}
