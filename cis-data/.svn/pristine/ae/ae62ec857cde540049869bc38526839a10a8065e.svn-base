package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntityNoIdentity
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "referral_reason_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ReferralReason extends BaseEntityNoIdentity {
    
    @Column(name = 'referral_reason')
    String reason
    
    @OneToOne
    @JoinColumn(name = 'lldd_health_problem_category_id')
    LLDDHealthProblemCategory llddHealthProblemCategory
    
    /**
     * Default No Args constructor
     */
    ReferralReason() {}
    
    String toString() {
        return reason
    }
}
