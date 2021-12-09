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
@Table(name = 'ecf')
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ecf_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class EnglishConditionOfFunding extends ILREntityNoIdentity {
    
    EnglishConditionOfFunding() {}
    
    String toString() {
        return description
    }
}
