package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.BursaryType;

interface BursaryTypeRepository extends CrudRepository<BursaryType, Integer> {
    
    BursaryType findByCode(String code)
}
