package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.SpecialCategory


interface SpecialCategoryRepository extends CrudRepository<SpecialCategory, Integer> {
    
    SpecialCategory findByCode(String code)
}


