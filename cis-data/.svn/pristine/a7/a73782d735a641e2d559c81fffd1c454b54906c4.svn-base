package uk.ac.reigate.repositories.risk_assessment

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.risk_assessment.RiskLevel


interface RiskLevelRepository extends CrudRepository<RiskLevel, Integer> {
    
    RiskLevel findByCode(String code)
}
