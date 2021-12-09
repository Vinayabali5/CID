package uk.ac.reigate.repositories.lookup

import java.util.List

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.lookup.ReportingPeriod

interface ReportingPeriodRepository extends PagingAndSortingRepository<ReportingPeriod, Integer> {
    List<ReportingPeriod> findByAcademicYear(AcademicYear academicYear)
}
