package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity
import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Faculty

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "tutor_group_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode
class TutorGroup extends CodedEntity implements Serializable {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='faculty_id')
    Faculty faculty
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='tutor_id')
    Staff tutor
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='senior_tutor_id')
    Staff seniorTutor
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='room_id')
    Room room
    
    @Column(name = "in_use")
    Boolean inUse;
    
    TutorGroup(){}
    
    String toString() {
        return code
    }
}

