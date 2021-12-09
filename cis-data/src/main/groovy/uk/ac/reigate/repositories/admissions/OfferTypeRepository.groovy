package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.admissions.OfferType

interface OfferTypeRepository extends CrudRepository<OfferType, Integer>{
    
    OfferType findByDescription(String description)
    
    OfferType findByCode(String code)
}
