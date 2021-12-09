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
    @AttributeOverride(name = "id", column = @Column(name = "application_status_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ApplicationStatus extends CodedEntity implements Serializable {
    
    @Column(name = 'consider_withdrawn')
    Boolean considerWithdrawn
    /**
     * Default No Args constructor
     */
    ApplicationStatus(){}
    
    String toString() {
        return this.description
    }
}
