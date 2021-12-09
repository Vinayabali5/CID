package uk.ac.reigate.repositories

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.academic.School

interface SchoolRepository extends PagingAndSortingRepository<School, Integer> {
    
    School findByName(String name)
    
    School findByUrn(String urn)
    
    School findByUkprn(String ukprn)
    
    List<School> findByNameLikeIgnoreCase(String name)
    
    List<School> findByNameContainingIgnoreCase(String name)
}
