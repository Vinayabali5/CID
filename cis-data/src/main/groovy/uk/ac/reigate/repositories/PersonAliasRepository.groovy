package uk.ac.reigate.repositories

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.PersonAlias

interface PersonAliasRepository extends PagingAndSortingRepository<PersonAlias, String> {
    
    PersonAlias findByPersonUsername(String username)
    
    PersonAlias findByAliasUsername(String username)
}
