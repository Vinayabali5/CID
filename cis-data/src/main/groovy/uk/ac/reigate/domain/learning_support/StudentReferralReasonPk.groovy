package uk.ac.reigate.domain.learning_support

import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.Student

@Embeddable
@EqualsAndHashCode(includeFields=true)
class StudentReferralReasonPk implements Serializable {
    
    Integer student
    
    Integer referralReason
    
    StudentReferralReasonPk(){}
    
    StudentReferralReasonPk(Integer student, Integer referralReason){
        super();
        this.student = student;
        this.referralReason = referralReason;
    }
    
    StudentReferralReasonPk(Student student, ReferralReason referralReason){
        super();
        this.student = student.id;
        this.referralReason = referralReason.id;
    }
    
    StudentReferralReasonPk(StudentReferralReason studentReferralReason){
        super();
        this.student = studentReferralReason.student.id;
        this.referralReason = studentReferralReason.referralReason.id;
    }
}