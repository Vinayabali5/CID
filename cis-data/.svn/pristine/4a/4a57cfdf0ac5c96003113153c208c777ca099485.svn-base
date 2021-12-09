package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.GenericGenerator

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.admissions.InterviewCategory
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.admissions.Request
import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.domain.ilr.LLDDHealthProblem
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.domain.learning_support.InitialAssessmentLevel
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.domain.learning_support.StudentReferralReason
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.domain.risk_assessment.RiskLevel

/**
 * This entity store the details for a specific application to the college. 
 * 
 * @author Michael Horgan
 *
 */
@Entity
@Table(name = 'student')
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includes = ['id', 'person', 'uln'])
class Student {
    
    @Id
    @GenericGenerator(name = 'StudentIdGenerator', strategy = 'uk.ac.reigate.utils.StudentIdGenerator' )
    @GeneratedValue(generator = 'StudentIdGenerator' )
    @Column(name = 'student_id')
    Integer id
    
    /* 
     * Phase 1 Fields
     */
    
    /**
     * The year that the student initially applied for the college
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'academic_year_id')
    AcademicYear academicYear
    
    /**
     * The reference number for the individual application.
     */
    @Column(name = 'reference_no', unique=true)
    String referenceNo
    
    /**
     * The current status of the application.
     */
    @OneToOne
    @JoinColumn(name = 'application_status_id')
    ApplicationStatus status
    
    /**
     * The date the application was received
     */
    @Column(name = 'received')
    Date received
    
    /**
     * The date the application was submitted.
     */
    @Column(name = 'submitted')
    Date submitted
    
    /**
     * The person that is applying.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = 'person_id')
    Person person
    
    /**
     * This is to store the normal country of residence.
     */
    @Column(name = 'country_of_residence')
    String countryOfResidence
    
    /**
     * This is to determine if the applicant has been resident in the UK for the past three years
     */
    @Column(name = 'resident')
    Boolean resident
    
    /**
     * This determine if the applicant has had a sibling at the college in a previous year
     */
    @Column(name = 'sibling')
    Boolean sibling
    
    /**
     * This is to store the name of the sibling if provided.
     */
    @Column(name = 'sibling_name')
    String siblingName
    
    /**
     * Used to specify the year the applicant had a sibling at the college
     */
    @Column(name = 'sibling_year')
    Integer siblingYear
    
    /**
     * Used to specify the admission number or student reference for the sibling (if known). 
     */
    @Column(name = 'sibling_adm_no')
    String siblingAdmNo
    
    /**
     * The previous school of the applicant
     */
    @OneToOne
    @JoinColumn(name = 'school_id')
    School school
    
    /**
     * A list of the courses the student is interested in
     */
    @OneToMany(mappedBy = 'student', cascade = [CascadeType.ALL])
    List<Request> requests
    
    /**
     * The date the school reference was requested	
     */
    @Column(name = 'ref_requested')
    Date refRequested
    
    /**
     * The date the school reference was received
     */
    @Column(name = 'ref_received')
    Date refReceived
    
    /**
     * The date the school report was requested
     */
    @Column(name = 'report_requested')
    Date reportRequested
    
    /**
     * The date the school report was received
     */
    @Column(name = 'report_received')
    Date reportReceived
    
    /*
     * Phase 2 Fields
     */
    
    /**
     * The date the acceptance was received
     */
    @Column(name = 'acceptance_received')
    Date acceptanceReceived
    
    /**
     * The ethnicity of the applicant.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'ethnicity_id')
    Ethnicity ethnicity
    
    /**
     * The date the student was interviewed for a place.
     */
    @Column(name = 'interview_date')
    Date interviewDate
    
    /**
     * The member of staff that interviewer the applicant
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'interviewer_id')
    Staff interviewer
    
    /**
     * The type of offer that this application has recieved.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'offer_type_id')
    OfferType offerType
    
    /** 
     * The date that the offer was sent to the applicant.
     */
    @Column(name = 'offer_sent')
    Date offerSent
    
    /**
     * The student type for the applicant on enrolment 
     */
    @Deprecated
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'student_type_id')
    StudentType studentType
    
    /**
     * Used to specify the unique learner name of the applicant. This is loaded in from the Learner Record Service (LRS).
     */
    @Column(name = 'uln')
    String uln
    
    /**
     * Used to specify the unique candidate Identifier of the applicant. This is loaded in from the Learner Record Service (LRS).
     */
    @Column(name = 'uci', length = 13)
    String uci
    
    /**
     * Used to store general notes about the application. 
     * 
     * #TODO This field has been added as a temporary way to store notes for the admissions process. 
     */
    @Column(name = 'admissions_notes')
    String admissionsNotes
    
    /**
     * ILR field to determine if the applicant considers themselves to have a learning difficulty, disability or health problem.
     * 
     * This is collected when the applicant returns their acceptance forms.	
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'lldd_health_problem_id')
    LLDDHealthProblem llddHealthProblem
    
    /**
     * ILR fields to record the LLDD and health problem categories that a student declares they have.
     * 
     * This is collected when the applicant returns their acceptance forms.
     */
    @OneToMany
    @JoinTable(name = 'application_lldd_health_problem_category',
    joinColumns = [ @JoinColumn(name = 'student_id', referencedColumnName = 'student_id') ],
    inverseJoinColumns = [ @JoinColumn(name = 'lldd_health_problem_category_id', referencedColumnName = 'lldd_health_problem_category_id', unique = true) ]
    )
    List<LLDDHealthProblemCategory> llddHealthProblemCategory
    
    /**
     * The general medical notes for a students that all staff need to know about.
     */
    @Column(name = 'medical_note')
    String medicalNote
    
    /**
     * This field is used to determine if the applicant has an Education, Health and Care plan
     */
    @Column(name = 'ehcp')
    Boolean ehcp
    
    /**
     * ILR Fields: Learner FAM - Disabled Learner Allowance (DLA)
     * 
     * This fields is used to determine if the student is in receipt of the disabled leaner allowance
     */
    @Column(name = 'disabled_learner_allowance')
    Boolean disabledLearnerAllowance
    
    /**
     * This is collected during the admissions process as a special category is identified.  
     */
    @OneToOne
    @JoinColumn(name = 'special_category_id')
    SpecialCategory specialCategory
    
    /**
     * This is collected during the admissions process as a special category is identified.
     */
    @OneToOne
    @JoinColumn(name = 'risk_level_id')
    RiskLevel riskLevel
    
    /**
     * This is used to determine if the special category set above is a confirmed special category or not.
     */
    @Column(name = 'special_confirmed')
    Boolean specialConfirmed
    
    /**
     * ILR field to determine the restrictions on the use of the learner record.
     * 
     * This is collected when the applicant returns their acceptance forms.	
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'restricted_use_indicator_id')
    RestrictedUseIndicator restrictedUseIndicator
    
    /**
     * This fields is used to determine if the student/parents have paid (or want to pay) a college fund donation.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = 'college_fund_paid_id')
    CollegeFundPaid collegeFundPaid
    
    
    /**
     * This fields is used to determine how many years the college fund has been paid for.
     */
    @Column(name = 'college_fund_paid_years')
    Integer collegeFundPaidYears
    
    
    /**
     * ILR field: Preferred Method of Contact - Contact By Post
     * 
     * This is used to determine if the student minds being contacted by post	
     */
    @Column(name = 'contact_by_post')
    Boolean contactByPost
    
    /**
     * ILR field: Preferred Method of Contact - Contact By Phone
     * 
     * This is used to determine if the student minds being contacted by phone   
     */
    @Column(name = 'contact_by_phone')
    Boolean contactByPhone
    
    /**
     * ILR field: Preferred Method of Contact - Contact By Email
     * 
     * This is used to determine if the student minds being contacted by email   
     */
    @Column(name = 'contact_by_email')
    Boolean contactByEmail
    
    /**
     * This field is used if the student decides to opt out of data sharing of their LRS data.
     */
    @Column(name = 'lrs_opt_out')
    Boolean lrsOptOut
    
    @Column(name = 'cannot_attend_intro')
    Boolean cannotAttendIntro
    
    @Column(name = 'cannot_attend_induction')
    Boolean cannotAttendInduction
    
    @Column(name = 'learning_support_on_intro')
    Boolean learningSupportOnIntro
    
    @Column(name = 'learning_support_needs')
    Boolean learningSupportNeeds
    
    @Column(name = 'induction_date')
    Date inductionDate
    
    @Column(name = 'enrolment_interview_date')
    Date enrolmentInterviewDate
    
    @Column(name = 'enrolment_interview_time')
    Date enrolmentInterviewTime
    
    /**
     * A list of the courses the student is interested in
     */
    @OneToMany(mappedBy = 'student', cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    List<StudentYear> studentYears
    
    /**
     * The Learner Reference No Override
     */
    @Column(name = 'learner_reference_override', length = 12)
    String learnerReferenceNoOverride
    
    /**
     * The School Report Status
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'school_report_status_id')
    SchoolReportStatus schoolReportStatus
    
    /**
     * The date field for blue card
     */
    @Column(name = 'blue_card')
    Date blueCard
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'destination_id')
    Destination destination
    
    @Column(name = 'destination_college_employer')
    String destinationCollegeEmployer
    
    @Column(name = 'destination_course_career')
    String destinationCourseCareer
    
    @Column(name = 'STUDENTEMAIL')
    String studentEmail
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'reading_initial_assessment_id')
    InitialAssessmentLevel readingInitialAssessment
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'writing_initial_assessment_id')
    InitialAssessmentLevel writingInitialAssessment
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'spelling_initial_assessment_id')
    InitialAssessmentLevel spellingInitialAssessment
    
    @OneToMany(mappedBy = 'student', cascade = [CascadeType.ALL])
    List<StudentConcessionType> concessions
    
    @OneToMany(mappedBy = 'student', cascade = [CascadeType.ALL])
    List<StudentCourseConcession> courseConcessions
    
    @OneToMany(mappedBy = 'student', cascade = [CascadeType.ALL])
    List<StudentReferralReason> referralReasons
    
    @OneToOne(mappedBy = 'student', fetch = FetchType.LAZY)
    GCSEScore gcseScore
    
    @Column(name = 'monitorable')
    Boolean monitorable
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'student_remark_permission_id')
    StudentRemarkPermission studentRemarkPermission
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'interview_category_id')
    InterviewCategory interviewCategory
    
    @Column(name = 'maths_disadvantage_funding')
    Boolean mathsDisadvantageFunding
    
    @Column(name = 'english_disadvantage_funding')
    Boolean englishDisadvantageFunding
    
    @Column(name = 'looked_after_child_or_adopted')
    Boolean lookedAfterChildOrAdopted
    
    @Column(name = 'children_services_involved_at_school')
    Boolean childrenServicesInvolvedAtSchool
    
    @Column(name = 'other_social_support_issues')
    Boolean otherSocialSupportIssues
    
    @Column(name = 'possible_mvd')
    Boolean possibleMvd
    
    @Column(name = 'possible_aspire')
    Boolean possibleAspire
    
    @Column(name = 'school_report_not_seen')
    Boolean schoolReportNotSeen
    
    @Column(name = 'free_meals_while_at_school')
    Boolean freeMealsWhileAtSchool
    
    @Column(name = 'parents_university_educated')
    Boolean parentsUniversityEducated
    
    @Column(name = 'no_show_at_interview')
    Boolean noShowAtInterview
    
    @Column(name = 'interview_needs_rescheduling')
    Boolean interviewNeedsRescheduling
    
    @Column(name = 'career_aims')
    String careerAims
    
    @Column(name = 'work_voluntary_experience')
    String workVoluntaryExperience
    
    @Column(name = 'hobbies_interests_other_achievements')
    String hobbiesInterestsOtherAchievements
    
    @Column(name = 'favorite_subject')
    String favoriteSubject
    
    @Column(name = 'coursework_or_exams')
    String courseworkOrExams
    
    @Column(name = 'reasons_for_reigate_college')
    String reasonsForReigateCollege
    
    @Column(name = 'interview_by')
    String interviewBy
    
    @Column(name = 'employed_10_hours_plus')
    Boolean employed10HoursPlus
    
    @Column(name = 'other_school_college_applied_for')
    String otherSchoolCollegeAppliedFor
    
    @Column(name = 'learning_support_needs_details')
    String learningSupportNeedsDetails
    /**
     * Default no args constructor
     */
    Student() {
        this.submitted = new Date()
    }
    
    /**
     * Constructor used with a Person object
     * 
     * @param person the person to use to create the application form
     */
    Student(Person person) {
        this()
        this.person = person
    }
    
    /**
     * Generated toString method
     */
    @Override
    public String toString() {
        return "$id: $person (Applied: $academicYear, Status: $status, ULN: $uln)"
    }
}
