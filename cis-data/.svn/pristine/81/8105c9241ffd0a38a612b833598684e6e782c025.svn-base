package uk.ac.reigate.domain.register

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.CodedEntityNoIdentity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "attendance_code_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class AttendanceCode extends CodedEntityNoIdentity {
    
    @Column(name = 'register_mark', length = 1)
    String registerMark
    
    @Column(name = 'absence')
    Boolean absence
    
    @Column(name = 'authorised_absence')
    Boolean authorisedAbsence
    
    @Column(name = 'late')
    Boolean late
    
    @Column(name = 'authorised_late')
    Boolean authorisedLate
    
    @Column(name = 'included')
    Boolean included
    
    @Column(name = 'last_date_of_attendance')
    Boolean lastDateOfAttendance
    
    @Column(name = 'html_colour' )
    String htmlColour
    
    @Column(name = 'access_colour')
    String accessColour
    
    AttendanceCode() {}
}
