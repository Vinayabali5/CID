package uk.ac.reigate.domain.academic

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
import uk.ac.reigate.domain.lookup.StudentRole
import uk.ac.reigate.domain.lookup.VolunteeringExperience
import uk.ac.reigate.domain.lookup.VolunteeringType

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_volunteering_log_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@Table(name = "student_volunteering_log")
class StudentVolunteeringLog extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name="volunteering_type_id")
    VolunteeringType volunteeringType
    
    @OneToOne
    @JoinColumn(name="volunteering_experience_id")
    VolunteeringExperience volunteeringExperience
    
    @Column(name="date")
    Date date
    
    @Column(name="hours")
    Double hours
    
    @Column(name="note")
    String note
    
    @OneToOne
    @JoinColumn(name="student_role_id")
    StudentRole studentRole
    
    StudentVolunteeringLog(){}
    
    String toString() {
        return student
    }
}
