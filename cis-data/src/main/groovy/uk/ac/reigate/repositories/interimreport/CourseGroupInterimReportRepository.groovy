package uk.ac.reigate.repositories.interimreport

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.interimreport.CourseGroupInterimReport
import uk.ac.reigate.domain.interimreport.CourseGroupInterimReportPk
import uk.ac.reigate.domain.interimreport.InterimReport

interface CourseGroupInterimReportRepository extends CrudRepository<CourseGroupInterimReport, CourseGroupInterimReportPk> {
    
    List<CourseGroupInterimReport> findByCourseGroupId(Integer courseGroupId)
    
    List<CourseGroupInterimReport> findByInterimReport(InterimReport interimReport)
    
    CourseGroupInterimReport findByInterimReportIdAndCourseGroupId(Integer interimReportId, Integer courseGroupId)
}
