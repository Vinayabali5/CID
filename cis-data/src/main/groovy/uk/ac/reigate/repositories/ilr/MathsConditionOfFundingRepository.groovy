package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.MathsConditionOfFunding


interface MathsConditionOfFundingRepository extends CrudRepository<MathsConditionOfFunding, Integer> {
}
