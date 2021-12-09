package uk.ac.reigate.domain.interimreport

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.domain.cristal.InterimReportEffortGrade
import uk.ac.reigate.domain.lookup.PossibleGrade

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_interim_report_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StudentInterimReport extends BaseEntity {
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    Student student
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interim_report_id")
    InterimReport interimReport
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    Course course
    
    @OneToOne
    @JoinColumn(name = "course_group_id")
    CourseGroup courseGroup
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    Staff staff
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motivation", referencedColumnName = "interim_report_effort_grade_id")
    InterimReportEffortGrade motivation
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'class_ethic', referencedColumnName = "interim_report_effort_grade_id")
    InterimReportEffortGrade classEthic
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_management", referencedColumnName = "interim_report_effort_grade_id")
    InterimReportEffortGrade timeManagement
    
    @Column(name = "total_possible", columnDefinition = "smallint")
    Integer totalPossible
    
    @Column(name = "absence", columnDefinition = "smallint")
    Integer absence
    
    @Column(name = "authorised_absence", columnDefinition = "smallint")
    Integer authorisedAbsence
    
    @Column(name = "late", columnDefinition = "smallint")
    Integer late
    
    @OneToOne
    @JoinColumn(name="current_predicted_grade_id")
    PossibleGrade currentPredictedGrade
    
    @OneToOne
    @JoinColumn(name="key_assessment_1_id")
    PossibleGrade keyAssessment1
    
    @OneToOne
    @JoinColumn(name="key_assessment_2_id")
    PossibleGrade keyAssessment2
    
    @OneToOne
    @JoinColumn(name="key_assessment_3_id")
    PossibleGrade keyAssessment3
    
    @Column(name = "[Attendance]")
    Double Attendance
    
    @Column(name = "[AdjustedAttendance]")
    Double AdjustedAttendance
    
    @Column(name = "[Punctuality]")
    Double Punctuality
}


