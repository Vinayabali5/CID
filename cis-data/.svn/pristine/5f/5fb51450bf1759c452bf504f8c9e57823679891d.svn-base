package uk.ac.reigate.repositories.lookup

import java.util.List;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.Title

interface TitleRepository extends CrudRepository<Title, Integer> {
    
    Title findByCode(String code)
    
    Title findByDescription(String description)
}

