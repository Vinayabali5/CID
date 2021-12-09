package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.SourceOfFunding


interface SourceOfFundingRepository extends CrudRepository<SourceOfFunding, Integer> {
}
