package uk.ac.reigate.domain.admissions

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.Student;;


@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "college_fund_payment_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class CollegeFundPayment extends BaseEntity {
    
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name='student_id')
    Student student
    
    @Column(name="payment_date")
    Date paymentDate
    
    @Column(name="amount")
    float amount
    
    @Column(name="payee")
    String payee
    
    @Column(name="gift_aid")
    boolean giftAid
    
    @Column(name="cash")
    boolean cash
    
    @Column(name="cheque_date")
    Date chequeDate
    
    /**
     * Default No Args constructor
     */
    CollegeFundPayment() {
        giftAid = true
        cash = true
    }
    
    Integer getStudentId() {
        return student.id
    }
    
    String toString() {
        return payee
    }
}
