package uk.ac.reigate.domain.interimreport

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup

@Entity
@Table(name = "course_group_interim_report", schema = "InterimReport")
@IdClass(CourseGroupInterimReportPk.class)
class CourseGroupInterimReport {
    
    @Id
    @OneToOne
    @JoinColumn(name = "course_group_id", insertable = false, updatable = false)
    CourseGroup courseGroup
    
    @Id
    @OneToOne
    @JoinColumn(name = "interim_report_id", insertable = false, updatable = false)
    InterimReport interimReport
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staffCompleted
    
    @Column(name = "complete")
    Boolean complete
}
