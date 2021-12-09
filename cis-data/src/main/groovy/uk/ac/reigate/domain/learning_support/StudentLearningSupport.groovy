package uk.ac.reigate.domain.learning_support

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
import uk.ac.reigate.domain.academic.Student



@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_id"))
])
//@Immutable
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@Table(name = "student_learning_support")
class StudentLearningSupport extends BaseEntityNoIdentity implements Serializable {
    
    @OneToOne
    @PrimaryKeyJoinColumn(name="id", referencedColumnName="student_id")
    Student student
    
    @Column(name = 'referral_notes')
    String referralNotes
    
    @OneToOne
    @JoinColumn(name = 'support_type_id')
    SupportType supportType
    
    @Column(name = 'support_notes')
    String supportNotes
    
    @Column(name = 'assessment_date')
    Date assessmentDate
    
    @Column(name = 'previous_concession')
    String previousConcession
    
    @Column(name = 'concession_application')
    Boolean concessionApplication
    
    @Column(name = 'exam_concession_approved')
    Boolean examConcessionApproved
    
    @Column(name = 'btec_concession_approved')
    Boolean btecConcessionApproved
    
    @Column(name = 'fs_concession_approved')
    Boolean fsConcessionApproved
    
}
