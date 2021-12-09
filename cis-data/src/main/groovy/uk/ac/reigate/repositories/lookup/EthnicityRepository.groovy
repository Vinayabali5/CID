package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.Ethnicity

interface EthnicityRepository extends CrudRepository<Ethnicity, Integer> {
    Ethnicity findByCode(String code)
    
    Ethnicity findByDescription(String description)
}
