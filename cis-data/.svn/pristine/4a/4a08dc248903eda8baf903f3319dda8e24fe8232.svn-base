package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.admissions.ApplicationStatus

interface ApplicationStatusRepository extends CrudRepository<ApplicationStatus, Integer>{
    
    ApplicationStatus findByCode(String code)
    
    ApplicationStatus findByDescription(String description)
}
