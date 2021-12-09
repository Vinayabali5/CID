package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.lookup.SchoolType

interface SchoolTypeRepository extends PagingAndSortingRepository<SchoolType, Integer> {
    
    SchoolType findByCode(String code)
}
