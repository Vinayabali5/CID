package uk.ac.reigate.domain.exams

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id;
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.basedata.Syllabus

@Entity
@Table(name = "course_syllabus", schema = "Exams")
@IdClass(CourseSyllabusPk.class)
class CourseSyllabus implements Serializable {
    
    @Id
    @NotNull
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "course_id", updatable = false, insertable = false, referencedColumnName = "course_id")
    Course course
    
    @Id
    @NotNull
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "syllabus_id", insertable = false, updatable = false, referencedColumnName = "syllabus_id")
    Syllabus syllabus
    
    public CourseSyllabus() {}
    
    public CourseSyllabus(Course course, Syllabus syllabus) {
        this.course = course;
        this.syllabus = syllabus;
    }
}
