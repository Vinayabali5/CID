package uk.ac.reigate.repositories.system

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.system.LetterTemplate

interface LetterTemplateRepository extends CrudRepository<LetterTemplate, Integer>{
    
    @Query("select c from LetterTemplate c WHERE inUse = 1 ")
    List<LetterTemplate> findValidTemplate()
}
