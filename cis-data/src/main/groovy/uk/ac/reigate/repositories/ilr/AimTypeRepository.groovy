package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.AimType

interface AimTypeRepository extends CrudRepository<AimType, Integer> {
}
