package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.Disability

interface DisabilityRepository extends CrudRepository<Disability, Integer> {
}
