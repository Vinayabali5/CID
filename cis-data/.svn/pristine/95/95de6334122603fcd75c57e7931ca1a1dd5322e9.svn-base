package uk.ac.reigate.domain.ilr

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = 'mcf')
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "mcf_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class MathsConditionOfFunding extends ILREntityNoIdentity {
    
    MathsConditionOfFunding() {}
    
    String toString() {
        return description
    }
}
