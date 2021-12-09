package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Period

interface PeriodRepository extends CrudRepository<Period, Integer> {
    Period findByCode(String code)
}
