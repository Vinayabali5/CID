package uk.ac.reigate.repositories.interimreport

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.interimreport.InterimReport

interface InterimReportRepository extends CrudRepository<InterimReport, Integer> {
    
    InterimReport findTopByActiveIsTrueOrderByStartDateDesc()
    
    InterimReport findTopByStartDateLessThanOrderByStartDateDesc(Date startDate)
}
