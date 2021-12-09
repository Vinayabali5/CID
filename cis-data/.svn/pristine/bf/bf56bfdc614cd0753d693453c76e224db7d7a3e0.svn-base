package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.admissions.InterviewCategory

interface InterviewCategoryRepository extends CrudRepository<InterviewCategory, Integer>{
    
    InterviewCategory findByDescription(String description)
}
