package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.lookup.PunctualityMonitoring;

interface PunctualityMonitoringRepository extends CrudRepository<PunctualityMonitoring, Integer> {
}
