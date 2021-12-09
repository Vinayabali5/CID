package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.LegalSex;

interface LegalSexRepository extends CrudRepository<LegalSex, Integer> {
    
    LegalSex findByCode(String code)
}
