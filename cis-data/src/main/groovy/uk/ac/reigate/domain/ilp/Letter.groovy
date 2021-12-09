package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student

@Entity
@Table(name="ilp_letter", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ilp_letter_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields = true)
class Letter extends BaseEntity{
    
    @OneToOne
    @JoinColumn(name = "academic_year_id")
    AcademicYear year
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ilp_interview_id")
    ILPInterview interview
    
    @Column(name = "requested_date")
    Date requestedDate
    
    @Column(name = "authorised_date")
    Date authorisedDate
    
    @Column(name = "letter_date")
    Date letterDate
    
    @Column(name = "printed_date")
    Date printedDate
    
    @OneToOne
    @JoinColumn(name = "written_by")
    Staff writtenBy
    
    @OneToOne
    @JoinColumn(name = "requested_by")
    Staff requestedBy
    
    @Column(name = "student_copied_in")
    Boolean studentCopiedIn
    
    @Column(name = "subject", columnDefinition = "nvarchar")
    String subject
    
    @Column(name = "re", columnDefinition = "nvarchar")
    String regarding
    
    @Column(name = "review_meeting")
    Boolean reviewMeeting
    
    @Column(name = "attendance")
    Boolean attendance
    
    @Column(name = "behaviour")
    Boolean behaviour
    
    @Column(name = "homework")
    Boolean homework
    
    @Column(name = "punctuality")
    Boolean punctuality
    
    @Column(name = "focus")
    Boolean focus
    
    @Column(name = "deadlines")
    Boolean deadlines
    
    @Column(name = "incomplete_coursework")
    Boolean incompleteCoursework
    
    @Column(name = "insufficient_progress")
    Boolean insufficientProgress
    
    @OneToOne
    @JoinColumn(name = "non_entry_warning", columnDefinition = "tinyint")
    LetterWarningParagraph nonEntryWarning
    
    @Column(name = "ir_will_address")
    Boolean irWillAddress
    
    @Column(name = "ir_improve_attendance")
    Boolean irImproveAttendance
    
    @Column(name = "ir_improve_effort")
    Boolean irImproveEffort
    
    @OneToOne
    @JoinColumn(name = "letter_type_id")
    LetterType letterType
    
    @OneToOne
    @JoinColumn(name = "correspondence_type_id")
    CorrespondenceType correspondenceType
    
    @OneToOne
    @JoinColumn(name = "pending")
    Staff pending
    
    @Column(name = "send_after")
    Date sendAfter
    
    /**
     * The processing flag determines at what state of processing a specific letter is at:
     * <ul>
     *  <li>0 = DoNot Process Yet.</li> 
     *  <li>1 = Ready to Process </li>
     *  <li>2 = Process Started </li>
     *  <li>3 = Process Complete </li>
     *  <li>4 = Added to Correspondence Table</li>
     *  </ul>
     */
    @Column(name = "processing_flag")
    Integer processingFlag
    
    Letter() {}
}
