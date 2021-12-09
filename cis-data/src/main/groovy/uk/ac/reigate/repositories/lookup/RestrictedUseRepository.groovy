package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.RestrictedUseIndicator

interface RestrictedUseRepository extends CrudRepository<RestrictedUseIndicator, Integer> {
}
