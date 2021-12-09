package uk.ac.reigate.domain.learning_support

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
    @AttributeOverride(name = "id", column = @Column(name = "concession_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode
class ConcessionType extends CodedEntityNoIdentity {
    
    @Column(name = 'in_use')
    Boolean inUse;
    
    @Column(name = 'on_exam_timetable')
    Boolean onExamTimetable
    
    /**
     * Default No Args constructor
     */
    ConcessionType() {}
}
