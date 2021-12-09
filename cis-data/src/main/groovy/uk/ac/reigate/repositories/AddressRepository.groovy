package uk.ac.reigate.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.Address

interface AddressRepository extends CrudRepository<Address, Integer> {
}
