package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.PossibleGradeSet;

interface PossibleGradeSetRepository extends CrudRepository<PossibleGradeSet, Integer> {
    
    PossibleGradeSet findByCode(String code)
}
