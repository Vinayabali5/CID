package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Transient
import javax.validation.constraints.NotNull

import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.domain.ilr.EnglishConditionOfFunding
import uk.ac.reigate.domain.ilr.MathsConditionOfFunding
import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.domain.lookup.PunctualityMonitoring
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.domain.lookup.TutorGroup

@Entity
@Table(name = "student_year")
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@IdClass(StudentYearPk.class)
class StudentYear implements Serializable {
    
    /**
     * Composite Primary Key - student
     */
    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'student_id')
    @JsonIgnore
    Student student
    
    /**
     * Composite Primary Key - year
     */
    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'academic_year_id')
    AcademicYear year
    
    /**
     * Student Type
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'student_type_id')
    StudentType studentType
    
    @Column(name = 'start_date')
    Date startDate
    
    @Column(name = 'end_date')
    Date endDate
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='tutor_group_id')
    TutorGroup tutorGroup
    
    @Column(name = 'ilr_return')
    Boolean ilr
    
    /**
     * ILR Field: Learning Support Costs (ALSCost)
     */
    @Column(name="learning_support_cost")
    Integer learningSupportCost
    
    /**
     * ILR Field: Planned Learning Hours
     */
    @Column(name = 'plh')
    Integer plh
    
    /**
     * ILR field: Planned Employablility, Enrichment and Pastoral Hours (PEEPH) 
     */
    @Column(name = 'peeph')
    Integer peeph
    
    /**
     * ILR field: GCSE Maths Qualification Grade
     */
    @Column(name = 'gcse_maths_grade')
    String gcseMathsGrade
    
    /**
     * ILR field: GCSE English Qualification Grade
     */
    @Column(name = 'gcse_english_grade')
    String gcseEnglishGrade
    
    /**
     * ILR field: Learning Difficulty Assessment (LDA)
     * 
     * The learner has an Section 139A LDA  
     */
    @Column(name = 'lda')
    Boolean lda
    
    /**
     * ILR field: Education Health Care plan (EHC)
     * 
     * The learner has an EHC plan.
     */
    @Column(name = 'ehc')
    Boolean ehc
    
    /**
     * ILR field: High Needs Student (HNS)
     * 
     * The learner is a high need student, element 3 has been claimed and paid for this learner.
     */
    @Column(name = 'hns')
    Boolean hns
    
    /**
     * ILR field: Special Educational Needs (SEN)
     * 
     * The learner is has special educational needs
     */
    @Column(name = 'sen')
    Boolean sen
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'bursary_type_id')
    BursaryType bursaryType
    
    /**
     * This field is used to determine if the student is on the Guaranteed Bursary (GB)
     */
    @Column(name = 'gb')
    Boolean gb
    
    /**
     * This field is used to determine if the student is on the Discretionary Bursary (DB)
     */
    @Column(name = 'db')
    Boolean db
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'mcf_id')
    MathsConditionOfFunding mathsConditionOfFunding
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'ecf_id')
    EnglishConditionOfFunding englishConditionOfFunding
    
    /**
     * This field is used to determine if the student is eligible for free school meals
     */
    @Column(name = 'free_meals_eligibility')
    Boolean freeMealsEligibility
    
    /**
     * This fields is used to determine if the student is in receipt of free school meals/
     */
    @Column(name = 'receiving_free_meals')
    Boolean receivingFreeMeals
    
    @Column(name = 'removed_from_free_meals')
    Boolean removedFromFreeMeals
    
    /**
     * This fields is used to store the student candidate number for a specific academic year
     */
    @Column(name = 'candidate_no')
    Integer candidateNo
    
    @Column(name = 'star_advice_given')
    Boolean starAdviceGiven
    
    @Column(name = 'contract_required')
    Boolean contractRequired
    
    @Column(name = 'larger_than_advised_programme')
    Boolean largerThanAdvisedProgramme
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'induction_interviewer_id')
    Staff inductionInterviewer
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='am_id')
    AttendanceMonitoring attendanceMonitoring
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='pm_id')
    PunctualityMonitoring punctualityMonitoring
    
    @Column(name = 'attendance_monitorable')
    Boolean attendanceMonitorable
    
    @Column(name = 'punctuality_monitorable')
    Boolean punctualityMonitorable
    
    @Column(name = 'on_contract')
    Boolean onContract
    
    @Column(name="initial_postcode")
    String initialPostcode
    
    @Column(name = 'external_candidate')
    Boolean externalCandidate
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='destination_id')
    Destination destination
    
    @Column(name = 'destination_college_employer')
    String destinationCollegeEmployer
    
    @Column(name = 'destination_course_career')
    String destinationCourseCareer
    
    @Column(name = 'break_in_learning')
    Boolean breakInLearning
    
    @Column(name = 'withdrawn_date')
    Date withdrawnDate
    
    @Column(name = 'social_worker')
    Boolean socialWorker
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'pastoral_monitor_id')
    Staff pastoralMonitor
    
    @Column(name = 'on_mentoring')
    Boolean onMentoring
    /**
     * Default NoArgs constructor
     */
    StudentYear() {}
    
    /**
     * This method was introduce to reduce the pain of renaming the type field to studentType
     * 
     * @return the newly named studentType field
     */
    @Transient
    StudentType getType() {
        return this.studentType;
    }
}
