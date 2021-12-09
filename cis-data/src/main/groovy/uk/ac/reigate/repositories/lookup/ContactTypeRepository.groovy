package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.ContactType;

interface ContactTypeRepository extends CrudRepository<ContactType, Integer> {
    
    List<ContactType> findAll()
    
    ContactType findByName(String name)
    
    ContactType findByDescription(String description)
}
