package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.lookup.Subject

interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer> {
    
    Subject findByCode(String code)
}
