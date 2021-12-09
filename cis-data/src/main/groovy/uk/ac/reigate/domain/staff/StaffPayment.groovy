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
@Table(name = "staff_payment", schema = "Staff")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "staff_payment_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StaffPayment extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staff
    
    @Column(name = "start_date")
    Date startDate
    
    @Column(name = "end_date")
    Date endDate
    
    @OneToOne
    @JoinColumn(name = "payment_reason_id")
    PaymentReason paymentReason
    
    @Column(name = "sessions")
    Double sessions
    
    @Column(name = "rate_per_session")
    Double ratePerSession
    
    StaffPayment(){}
}

