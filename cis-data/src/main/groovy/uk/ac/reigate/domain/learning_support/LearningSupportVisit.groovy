package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.Student

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "learning_support_visit_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class LearningSupportVisit extends BaseEntity {
    
    @NotNull
    @OneToOne
    @JoinColumn(name = 'student_id')
    Student student
    
    @Column(name='date')
    Date date
    
    @Column(name='duration')
    Integer duration
    
    @Column(name='details')
    String details
    
    @Column(name='time')
    Date time
    
    
    /**
     * Default No Args constructor
     */
    LearningSupportVisit() {}
    
    String toString() {
        return student
    }
}
