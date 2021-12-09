package uk.ac.reigate.repositories

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.PersonRole
import uk.ac.reigate.domain.PersonRolePk

interface PersonRoleRepository extends CrudRepository<PersonRole, PersonRolePk> {
    
    PersonRole findByPerson_IdAndRole_Id(Integer personId, Integer roleId)
    
    List<PersonRole> findByPerson_Id(Integer personId)
}
