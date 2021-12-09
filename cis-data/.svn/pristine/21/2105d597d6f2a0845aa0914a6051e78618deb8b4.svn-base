package uk.ac.reigate.domain.register

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.Period;

@Entity
@Table(name="session")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "session_id"))
])
@EqualsAndHashCode(includeFields=true)
@DynamicInsert(true)
@DynamicUpdate(true)
class RegisteredSession extends BaseEntity {
    
    @Column(name='date')
    Date date
    
    @OneToOne
    @JoinColumn(name='period_id')
    Period period
    
    /**
     * Default No Args constructor
     */
    RegisteredSession(){}
    
    String toString(){
        return date
    }
}
