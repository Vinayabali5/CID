package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Holiday

interface HolidayRepository extends CrudRepository<Holiday, Integer> {
}
