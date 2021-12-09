package uk.ac.reigate.repositories.exams

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.exams.CourseSyllabus
import uk.ac.reigate.domain.exams.CourseSyllabusPk

@Transactional
public interface CourseSyllabusRepository extends PagingAndSortingRepository<CourseSyllabus, CourseSyllabusPk> {
    
    CourseSyllabus findByCourse_IdAndSyllabus_Id(Integer courseId, Integer syllabusId)
}

