package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel

interface InitialAssessmentLevelRepository extends CrudRepository<InitialAssessmentLevel, Integer> {
}
