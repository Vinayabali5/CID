package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.lookup.Level

interface LevelRepository extends PagingAndSortingRepository<Level, Integer> {
    
    Level findByCode(String code)
}
