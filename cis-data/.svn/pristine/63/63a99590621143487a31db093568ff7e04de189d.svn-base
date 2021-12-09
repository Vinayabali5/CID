package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student

@Entity
@Table(name = "ilp_interview", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ilp_interview_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields = true, excludes = "letter")
class ILPInterview extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name="academic_year_id")
    AcademicYear academicYear
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name = "ilp_interview_type_id")
    ILPInterviewType type
    
    @OneToOne
    @JoinColumn(name = "course_group_id")
    CourseGroup courseGroup
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staff
    
    @Column(name = "discussion", columnDefinition = "nvarchar")
    String discussion
    
    @Column(name = "ilp_interview_date")
    Date interviewDate
    
    @Column(name = "ilp_interview_time")
    Date interviewTime
    
    @Column(name= "target", columnDefinition = "nvarchar")
    String target
    
    @Deprecated
    @Column(name =  "target_by_when",columnDefinition = "nvarchar")
    String targetByWhen
    
    @Column(name =  "target_by_date", columnDefinition = "date")
    Date targetByDate
    
    @Column(name = "letter_sent", nullable = false, columnDefinition = "bit DEFAULT 0")
    Boolean letterSent = false
    
    @Column(name = "refer_lip")
    Boolean referLip
    
    @Column(name = "lip_referral_date")
    Date lipReferDate
    
    @Column(name = "private")
    Boolean privateEntry
    
    @OneToOne
    @JoinColumn(name = "office_action_id")
    OfficeAction officeAction
    
    @Column(name = "office_action", columnDefinition = "nvarchar")
    String officeActionString
    
    @Column(name = "office_notes", columnDefinition = "nvarchar")
    String officeNotes
    
    @Column(name = "to_file")
    Boolean toFile
    
    @Column(name = "target_progress")
    Integer targetProgress
    
    @Column(name = "target_progress_date")
    Date targetProgressDate
    
    @OneToOne(fetch=FetchType.EAGER, mappedBy = 'interview', cascade = CascadeType.MERGE)
    Letter letter
    
    ILPInterview() {}
}