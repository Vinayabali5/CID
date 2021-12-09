package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.learning_support.LearningSupportCost
import uk.ac.reigate.domain.learning_support.LearningSupportVisit

interface LearningSupportVisitRepository extends CrudRepository<LearningSupportVisit, Integer> {
    
    List<LearningSupportVisit> findByStudent_Id(Integer studentId)
}
