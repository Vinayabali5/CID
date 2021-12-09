package uk.ac.reigate.repositories.interimreport

import javax.transaction.Transactional

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.interimreport.InterimReportsDue
import uk.ac.reigate.domain.interimreport.InterimReportsDuePk

@Transactional
interface InterimReportsDueRepository extends PagingAndSortingRepository<InterimReportsDue, InterimReportsDuePk> {
    
    InterimReportsDue findByCourseGroup_Id(Integer courseGroupId)
}
