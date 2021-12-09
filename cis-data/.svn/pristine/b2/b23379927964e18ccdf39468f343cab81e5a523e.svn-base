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
@Table(name = "student_safety_plan")
class StudentSafetyPlan extends BaseEntityNoIdentity implements Serializable {
    
    @OneToOne
    @PrimaryKeyJoinColumn(name="id", referencedColumnName="student_id")
    Student student
    
    @Column(name = 'how_to_reduce_risk_at_home')
    String howToReduceRiskAtHome
    
    @Column(name="warning_signs_or_triggers")
    String warningSignsOrTriggers
    
    @Column(name="past_actions_to_help")
    String pastActionsToHelp
    
    @Column(name="actions_to_calm_and_soothe")
    String actionsToCalmAndSoothe
    
    @Column(name="what_to_tell_self")
    String whatToTellSelf
    
    @Column(name="what_would_be_said_to_friend")
    String whoWouldbeSaidToFriend
    
    @Column(name="what_could_others_do")
    String whatCouldOthersDo
    
    @Column(name="who_can_i_call")
    String whoCanICall
    
    @OneToOne
    @JoinColumn(name="completed_with_id")
    Staff completedWith
    
    @Column(name="date_completed")
    Date dateCompleted
    
    StudentSafetyPlan(){}
    
    String toString() {
        return student
    }
}
