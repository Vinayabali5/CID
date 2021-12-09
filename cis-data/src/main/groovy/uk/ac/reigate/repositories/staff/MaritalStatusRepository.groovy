package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.MaritalStatus

interface MaritalStatusRepository extends CrudRepository<MaritalStatus, Integer> {
}
