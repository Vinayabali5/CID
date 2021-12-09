package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.ilr.AimType
import uk.ac.reigate.domain.ilr.CompletionStatus
import uk.ac.reigate.domain.ilr.FundingModel
import uk.ac.reigate.domain.ilr.Outcome
import uk.ac.reigate.domain.ilr.SourceOfFunding
import uk.ac.reigate.domain.ilr.WithdrawalReason
import uk.ac.reigate.domain.lookup.CentralMonitoring

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "enrolment_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Enrolment extends BaseEntity {
    
    /**
     * The student object associate with the enrolment.
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='student_id')
    Student student
    
    /**
     * The academic year object associate with the enrolment.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='academic_year_id')
    AcademicYear year
    
    /**
     * The course object associate with the enrolment.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='course_id')
    Course course
    
    /**
     * The course group object associate with the enrolment.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name='course_group_id')
    CourseGroup courseGroup
    
    /**
     * The start date of the enrolment.
     */
    @Column(name="start_date")
    Date startDate
    
    /**
     * The end date of the enrolment.
     */
    @Column(name="end_date")
    Date endDate
    
    /**
     * This is the ILR field Learning Delivery > Qualification Start Date
     */
    @Column(name="qualification_start_date")
    Date qualificationStartDate
    
    /**
     * This is the ILR field Learning Delivery > Learning Planned End Date
     */
    @Column(name="planned_end_date")
    Date plannedEndDate
    
    /**
     * This is the ILR field Learning Delivery > Aim Type
     */
    @ManyToOne
    @JoinColumn(name='aim_type_id')
    AimType aimType
    
    /**
     * This is the ILR field Learning Delivery > Completion Status
     */
    @ManyToOne
    @JoinColumn(name='completion_status_id')
    CompletionStatus completionStatus
    
    /**
     * This is the ILR field Learning Delivery > Withdrawal Reason
     */
    @ManyToOne
    @JoinColumn(name='withdrawal_reason_id')
    WithdrawalReason withdrawalReason
    
    /**
     * This is the ILR field Learning Delivery > Outcome
     */
    @ManyToOne
    @JoinColumn(name='outcome_id')
    Outcome outcome
    
    /**
     * This is the ILR field Learning Delivery > Outcome Grade
     */
    @Column(name="grade")
    String grade
    
    /**
     * This column is used to determine if the enrolment is returned on the ILR.
     */
    @Column(name = 'ilr_return')
    Boolean ilr
    
    @ManyToOne
    @JoinColumn(name='central_monitoring_id')
    CentralMonitoring centralMonitoring
    
    @Column(name="plh")
    Integer plh
    
    @Column(name="peeph")
    Integer peeph
    
    @ManyToOne
    @JoinColumn(name='funding_model_id')
    FundingModel fundingModel
    
    @ManyToOne
    @JoinColumn(name='source_of_funding_id')
    SourceOfFunding sourceOfFunding
    
    /**
     * The notes of the enrolment
     */
    @Column(name='notes')
    String notes
    
    @Column(name="learning_aim_reference_override")
    String learningAimReferenceOverride
    
    @OneToOne(fetch=FetchType.LAZY, optional = true)
    @JoinColumns([
        @JoinColumn(name = "student_id", insertable = false, updatable = false, referencedColumnName = "student_id"),
        @JoinColumn(name = "course_id", insertable = false, updatable = false, referencedColumnName = "course_id")
    ])
    PreReference reference
    
    /**
     * Default No Args constructor
     */
    Enrolment(){}
    
    Enrolment(Integer id, Student student, AcademicYear year, Course course, CourseGroup courseGroup, Date startDate, Date endDate, Date qualificationStartDate, Date plannedEndDate, AimType aimType, CompletionStatus completionStatus, WithdrawalReason withdrawalReason, Outcome outcome, String grade, Boolean ilr, CentralMonitoring centralMonitoring, Integer plh, Integer peeph, FundingModel fundingModel, SourceOfFunding sourceOfFunding, String notes, String learningAimReferenceOverride){
        this.id = id;
        this.student = student;
        this.year = year;
        this.course= course;
        this.courseGroup = courseGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.qualificationStartDate = qualificationStartDate;
        this.plannedEndDate = plannedEndDate;
        this.aimType = aimType;
        this.completionStatus = completionStatus;
        this.withdrawalReason = withdrawalReason;
        this.outcome = outcome;
        this.grade = grade;
        this.ilr = ilr;
        this.centralMonitoring = centralMonitoring;
        this.plh = plh;
        this.peeph = peeph;
        this.fundingModel = fundingModel;
        this.sourceOfFunding = sourceOfFunding;
        this.notes = notes;
        this.learningAimReferenceOverride = learningAimReferenceOverride;
    }
    
    Enrolment(Student student, AcademicYear year, Course course, CourseGroup courseGroup, Date startDate, Date endDate, Date qualificationStartDate, Date plannedEndDate, AimType aimType, CompletionStatus completionStatus, WithdrawalReason withdrawalReason, Outcome outcome, String grade, Boolean ilr, CentralMonitoring centralMonitoring, Integer plh, Integer peeph, FundingModel fundingModel, SourceOfFunding sourceOfFunding, String notes, String learningAimReferenceOverride){
        this(null, student, year, course, courseGroup, startDate, endDate, qualificationStartDate, plannedEndDate, aimType, completionStatus, withdrawalReason, outcome, grade, ilr, centralMonitoring, plh, peeph, fundingModel, sourceOfFunding, notes, learningAimReferenceOverride)
    }
    
    /**
     * The default toString method
     */
    String toString() {
        return student
    }
}




