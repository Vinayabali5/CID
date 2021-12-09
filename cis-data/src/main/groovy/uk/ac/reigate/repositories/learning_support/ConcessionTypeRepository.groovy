package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.learning_support.ConcessionType

interface ConcessionTypeRepository extends CrudRepository<ConcessionType, Integer> {
}
