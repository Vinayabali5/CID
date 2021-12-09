package uk.ac.reigate.domain.staff

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Staff

@Entity
@Table(name = "staff_absence", schema = "Staff")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "staff_absence_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StaffAbsence extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staff
    
    @Column(name = "start_date")
    Date startDate
    
    @Column(name = "end_date")
    Date endDate
    
    @OneToOne
    @JoinColumn(name = "reason_id")
    AbsenceReason absenceReason
    
    @Column(name = "reason")
    String reason
    
    //	@OneToOne
    //	@JoinColumn(name = "illness_code")
    //	IllnessCode illnessCode
    
    @Column(name="days_absence")
    Double daysAbsence
    
    @Column(name="comment")
    String comment
    
}

