package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.PriorAttainment


interface PriorAttainmentRepository extends CrudRepository<PriorAttainment, Integer> {
}
