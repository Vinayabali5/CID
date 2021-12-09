package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.learning_support.LearningSupportCost

interface LearningSupportCostRepository extends CrudRepository<LearningSupportCost, Integer> {
    
    List<LearningSupportCost> findByStudent_Id(Integer studentId)
}
