package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.AttendanceMonitoring;

interface AttendanceMonitoringRepository extends CrudRepository<AttendanceMonitoring, Integer> {
}
