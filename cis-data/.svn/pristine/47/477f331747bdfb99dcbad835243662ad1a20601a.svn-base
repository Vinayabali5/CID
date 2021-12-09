package uk.ac.reigate.domain.ilr

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntityNoIdentity

@Entity
@Table(name="lldd_health_problem_category")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "lldd_health_problem_category_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class LLDDHealthProblemCategory extends CodedEntityNoIdentity {
    
    @Column(name="short_description")
    String shortDescription
    
    @Column(name='valid_from',columnDefinition="smalldatetime")
    Date validFrom
    
    @Column(name='valid_to',columnDefinition="smalldatetime")
    Date validTo
    
    LLDDHealthProblemCategory(){}
    
    String toString() {
        return code + ' - ' + shortDescription
    }
}
