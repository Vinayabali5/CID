package uk.ac.reigate.domain.interimreport

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup

@Entity
@Table(name = "[InterimReportsDue]", schema = "InterimReport")
@IdClass(InterimReportsDuePk.class)
class InterimReportsDue implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "interim_report_id", insertable = false, updatable = false)
    InterimReport interimReport
    
    @Id
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    Course course
    
    @Id
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "course_group_id", insertable = false, updatable = false)
    CourseGroup courseGroup
    
    @Column(name = "[CourseGroupSpec]")
    String CourseGroupSpec
    
    @Column(name = "Complete")
    Boolean complete
    
    InterimReportsDue() {}
    
    InterimReportsDue(InterimReport interimReport, Course course, CourseGroup courseGroup) {
        this.interimReport = interimReport;
        this.course = course;
        this.courseGroup = courseGroup;
    }
}
