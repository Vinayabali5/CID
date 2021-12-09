package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.StaffType

interface StaffTypeRepository extends CrudRepository<StaffType, Integer> {
    
    List<StaffType> findByNeedInitialsTrue()
}
