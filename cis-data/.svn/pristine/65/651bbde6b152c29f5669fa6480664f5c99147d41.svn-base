package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.LLDDHealthProblem


interface LLDDHealthProblemRepository extends CrudRepository<LLDDHealthProblem, Integer> {
    
    LLDDHealthProblem findByShortDescription(String description)
}
