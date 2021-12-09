package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntityNoIdentity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "central_monitoring_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class CentralMonitoring extends CodedEntityNoIdentity {
    
    @Column(name='warning_colour')
    String warningColour
    
    @Column(name = 'consider_non_entry')
    Boolean nonEntry
    
    CentralMonitoring(){}
    
    String toString() {
        return description
    }
}
