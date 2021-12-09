package uk.ac.reigate.domain.admissions

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.StudentType

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "interview_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Interview extends BaseEntity{
    
    @JsonIgnore
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name='student_id')
    Student student
    
    @Column(name='interview_date')
    Date interviewDate
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name='interviewer_id')
    Staff interviewer
    
    /**
     * The notes from the interview 
     */
    
    @Column(name="interview_notes")
    String interviewNotes
    
    /**
     * The proposed offer type as selected by the interviewer
     */
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name='proposed_offer_type_id')
    OfferType offerType
    
    /**
     * The proposed student type for the applicant on enrolment
     */
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name='proposed_student_type_id')
    StudentType studentType
    
    /**
     * No args constructor
     */
    Interview() {}
    
    /**
     * Constructor that takes an existing Application
     * 
     * @param student
     */
    Interview(Student student) {
        this.student = student
    }
}
