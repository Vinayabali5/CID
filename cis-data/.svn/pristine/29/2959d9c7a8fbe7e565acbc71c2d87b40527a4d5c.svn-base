package uk.ac.reigate.domain.register

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYearPk


@Entity
@Table(name = "[StudentOverallAttendance]", schema = "[Attendance]")
@IdClass(StudentYearPk.class)
class StudentOverallAttendance implements Serializable {
    
    @Id
    @OneToOne(fetch=FetchType.EAGER, cascade=[CascadeType.ALL])
    @JoinColumn(name='Student_Ref')
    Student student
    
    @Id
    @OneToOne(fetch=FetchType.EAGER, cascade=[CascadeType.ALL])
    @JoinColumn(name='academic_year_id')
    AcademicYear year
    
    @Column(name="TOTALSESSIONS")
    Integer totalSessions
    
    @Column(name="TOTALABSENCE")
    Integer totalAbsence
    
    @Column(name="TOTALAUTHORISEDABSENCE")
    Integer totalAuthorisedAbsence
    
    @Column(name="TOTALADJUSTED")
    Integer totalAdjusted
    
    @Column(name="TOTALLATE")
    Integer totalLate
    
    @Column(name="TOTALAUTHORISEDLATE")
    Integer totalAuthorisedLate
    
    @Column(name="ATTENDANCE", columnDefinition = "numeric")
    Double attendance
    
    @Column(name="ADJUSTEDATTENDANCE", columnDefinition = "numeric")
    Double adjustedAttendance
    
    @Column(name="PUNCTUALITY", columnDefinition = "numeric")
    Double punctuality
    
    @Column(name="ADJUSTEDPUNCTUALITY", columnDefinition = "numeric")
    Double adjustedPunctuality
}
