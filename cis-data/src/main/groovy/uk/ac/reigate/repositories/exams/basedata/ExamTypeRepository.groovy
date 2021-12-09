package uk.ac.reigate.repositories.exams.basedata

import javax.transaction.Transactional

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.exams.basedata.ExamType

@Transactional
public interface ExamTypeRepository extends CrudRepository<ExamType, Integer> {
    
    List<ExamType> findByQualificationAndLevel(String qualification, String level);
}
