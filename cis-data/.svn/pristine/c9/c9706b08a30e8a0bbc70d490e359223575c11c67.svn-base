package uk.ac.reigate.domain.risk_assessment

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntityNoIdentity
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@Table(name = "student_risk_assessment")
class StudentRiskAssessment extends BaseEntityNoIdentity implements Serializable {
    
    @OneToOne
    @PrimaryKeyJoinColumn(name="id", referencedColumnName="student_id")
    Student student
    
    @Column(name = 'risk_to_student')
    String riskToStudent
    
    @Column(name="actions_to_minimise_risk")
    String actionsToMinimiseRisk
    
    @Column(name="risk_to_other_students")
    String riskToOtherStudents
    
    @Column(name="risk_to_staff")
    String riskToStaff
    
    @Column(name="who_to_inform")
    String whoToInform
    
    @Column(name="other_agencies_involved")
    String otherAgenciesInvolved
    
    @Column(name="agency_contact_details")
    String agencyContactDetails
    
    @OneToOne
    @JoinColumn(name="complete_by_staff_id")
    Staff completeByStaff
    
    StudentRiskAssessment(){}
    
    String toString() {
        return student
    }
}
