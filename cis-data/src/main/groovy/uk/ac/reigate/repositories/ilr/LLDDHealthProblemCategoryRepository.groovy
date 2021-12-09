package uk.ac.reigate.repositories.ilr

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory

interface LLDDHealthProblemCategoryRepository extends CrudRepository<LLDDHealthProblemCategory, Integer> {
    
    LLDDHealthProblemCategory findByCode(String code)
}
