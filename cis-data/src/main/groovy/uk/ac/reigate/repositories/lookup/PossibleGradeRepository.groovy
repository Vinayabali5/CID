package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.lookup.PossibleGrade

interface PossibleGradeRepository extends PagingAndSortingRepository<PossibleGrade, Integer> {
    
    PossibleGrade findByCode(String code)
    
    List<PossibleGrade> findByGradeSet_Id(Integer PossibleGradeSetId)
}
