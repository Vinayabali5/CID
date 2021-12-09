package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.ProgrammeType


interface ProgrammeTypeRepository extends CrudRepository<ProgrammeType, Integer> {
}
