package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.lookup.SchoolPriority

interface SchoolPriorityRepository extends PagingAndSortingRepository<SchoolPriority, Integer> {
    
    SchoolPriority findByCode(String code)
}
