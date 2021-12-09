package uk.ac.reigate.domain.register

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "register_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Register extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name='session_id')
    RegisteredSession session
    
    @OneToOne
    @JoinColumn(name='course_group_id')
    CourseGroup courseGroup
    
    @Column(name='completed')
    Boolean completed
    
    @OneToOne
    @JoinColumn(name='staff_completed_id')
    Staff staffCompleted
    
    Date dateCompleted
    
    Register(){}
    
    String toString() {
        return session.id
    }
}
