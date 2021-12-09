package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.SchoolReportStatus;

interface SchoolReportStatusRepository extends CrudRepository<SchoolReportStatus, Integer> {
    
    List<SchoolReportStatus> findAll()
    
    SchoolReportStatus findByCode(String code)
    
    SchoolReportStatus findByDescription(String description)
}
