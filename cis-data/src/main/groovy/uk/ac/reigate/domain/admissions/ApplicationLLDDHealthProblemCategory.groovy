package uk.ac.reigate.domain.admissions

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name="application_lldd_health_problem_category")
class ApplicationLLDDHealthProblemCategory {
    
    @EmbeddedId
    ApplicationLLDDHealthProblemCategoryPk id
    
    Boolean primaryLLDD
}

