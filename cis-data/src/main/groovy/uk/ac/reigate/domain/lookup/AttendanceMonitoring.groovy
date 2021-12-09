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
    @AttributeOverride(name = "id", column = @Column(name = "attendance_monitoring_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class AttendanceMonitoring extends CodedEntityNoIdentity{
    
    @Column(name='warning_colour')
    String warningColour
    
    @Column(name='html_colour')
    String htmlColour
    
    @Column(name='in_use')
    Boolean inUse
    
    @Column(name = 'consider_non_entry')
    Boolean nonEntry
    
    AttendanceMonitoring(){}
    
    String toString() {
        return description
    }
}
