package uk.ac.reigate.repositories.register

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.register.RegisterMark


interface RegisterMarkRepository extends CrudRepository<RegisterMark, Integer> {
}
