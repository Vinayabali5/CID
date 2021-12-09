package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.Nationality

interface NationalityRepository extends CrudRepository<Nationality, Integer> {
    
    Nationality findByDescription(String description)
}
