package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.StudentRole


interface StudentRoleRepository extends CrudRepository<StudentRole, Integer> {
    
    StudentRole findByCode(String code)
}
