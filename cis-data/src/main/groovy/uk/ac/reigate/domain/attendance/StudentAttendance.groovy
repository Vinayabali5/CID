package uk.ac.reigate.domain.attendance

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student

@Entity
@Table(name = "[StudentAttendance]", schema = "Attendance")
@IdClass(StudentAttendancePk.class)
class StudentAttendance {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    Course course
    
    @Id
    @OneToOne
    @JoinColumn(name = "academic_year_id", insertable = false, updatable = false)
    AcademicYear academicYear
    
    @Column(name = '[SumOfPeriods]')
    Integer sumOfPeriods
    
    @Column(name = '[SumOfAbsences]')
    Integer sumOfAbsences
    
    @Column(name = '[SumOfAdjAbs]')
    Integer sumOfAdjAbs
    
    @Column(name = '[SumOfLates]')
    Integer sumOfLates
}
