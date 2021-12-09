package uk.ac.reigate.domain.admissions

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "offer_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class OfferType extends CodedEntity {
    
    @Column(name = 'consider_as_enrolling')
    Boolean considerAsEnrolling
    
    OfferType(){}
    
    String toString() {
        return this.description + ' (' + this.code + ')'
    }
}
