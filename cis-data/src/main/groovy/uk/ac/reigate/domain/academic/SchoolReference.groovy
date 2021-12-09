package uk.ac.reigate.domain.academic

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.Table

/**
 * This entity store the details for a specific application to the college. 
 *
 */
@Entity
@Table(name = "school_reference", schema = "dbo")
class SchoolReference {
    
    @Id
    @Column(name="student_id")
    int studentId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="student_id", referencedColumnName="student_id")
    Student student
    
    @Column(name="meeting_targets")
    Integer meetingTargets
    
    @Column(name="effort")
    Integer effort
    
    @Column(name="work_ethic")
    Integer workEthic
    
    @Column(name="homework_completion")
    Integer homeworkCompletion
    
    @Column(name="behaviour")
    Integer behaviour
    
    @Column(name="organisation")
    Integer organisation
    
    @Column(name="attainment_potential")
    Integer attainmentPotential
    
    @Column(name="year_10_attendance")
    Double year10Attendance
    
    @Column(name="year_10_attendance_comment")
    String year10AttendanceComment
    
    @Column(name="year_11_attendance")
    Double year11Attendance
    
    @Column(name="year_11_attendance_comment")
    String year11AttendanceComment
    
    @Column(name="reliability")
    Integer reliability
    
    @Column(name="independence")
    Integer independence
    
    @Column(name="sociability")
    Integer sociability
    
    @Column(name="relationship_with_staff")
    Integer relationshipWithStaff
    
    @Column(name="recommend")
    Boolean recommend;
    
    @Column(name="recommend_comment")
    String recommendComment
    
    @Column(name="behavioural_issues")
    Boolean behaviouralIssues
    
    @Column(name="behavioural_issues_comment")
    String behaviouralIssuesComment
    
    @Column(name = "responsibilities_extra_curricular")
    String responsibilitiesExtraCurricular
    
    @Column(name = "senco")
    Boolean senco
    
    @Column(name="areas_of_need")
    String areasOfNeed
    
    @Column(name = "ehcp")
    Boolean ehcp
    
    @Column(name = "sen_plan")
    Boolean senPlan
    
    @Column(name = "details_of_support")
    String detailsOfSupport
    
    @Column(name = "external_agencies")
    String externalAgencies
    
    @Column(name = "safeguarding_issues")
    Boolean safeguardingIssues
    
    @Column(name="literacy_level")
    String literacyLevel
    
    @Column(name="exam_access")
    Boolean examAccess
    
    @Column(name="exam_access_details")
    String examAccessDetails
    
    @Column(name = "date_of_last_report")
    Date dateOfLastReport
}
