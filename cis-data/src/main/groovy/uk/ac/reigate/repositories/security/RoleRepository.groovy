package uk.ac.reigate.repositories.security

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.security.Role

interface RoleRepository extends CrudRepository<Role, Integer> {
    
    List<Role> findAllByUsers(Person person)
}
