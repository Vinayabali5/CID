package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.FundingModel


interface FundingModelRepository extends CrudRepository<FundingModel, Integer> {
}
