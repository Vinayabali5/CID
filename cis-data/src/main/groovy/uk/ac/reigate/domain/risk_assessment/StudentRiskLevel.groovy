package uk.ac.reigate.domain.risk_assessment

import groovy.transform.EqualsAndHashCode

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
import uk.ac.reigate.domain.academic.Student

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_risk_level_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StudentRiskLevel extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name = "risk_level_id")
    RiskLevel riskLevel
    
    @OneToOne
    @JoinColumn(name = "staff_requesting_id")
    Staff staffRequesting
    
    @Column(name="date_requested")
    Date dateRequested
    
    @Column(name="confidential")
    Boolean confidential
    
    @Column(name="evidence")
    Boolean evidence
    
    @Column(name="risk_assessment_required")
    Boolean riskAssessmentRequired
    
    @Column(name="safety_plan_required")
    Boolean safetyPlanRequired
    
    @Column(name="date_for_review")
    Date dateForReview
    
    @Column(name="risk_notes")
    String riskNotes
    
    StudentRiskLevel(){}
    
    String toString() {
        return student
    }
}
