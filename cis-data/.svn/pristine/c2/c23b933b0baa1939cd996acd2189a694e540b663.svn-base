package uk.ac.reigate.domain.exams

import javax.persistence.CascadeType;
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id;
import javax.persistence.IdClass
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

import com.querydsl.core.annotations.QueryInit

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.basedata.ExamOption

@Entity
@Table(name = "course_option", schema = "Exams")
@IdClass(CourseOptionPk.class)
class CourseOption implements Serializable {
    
    @Id
    @NotNull
    @ManyToOne(cascade=[CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @QueryInit("syllabus.code")
    Course course
    
    @Id
    @NotNull
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "exam_option_id", updatable = false, insertable = false, referencedColumnName = "exam_option_id")
    @QueryInit("syllabus.examSeries.academicYear")
    ExamOption examOption
    
    @Column(name="lower_entry")
    Boolean lowerEntry
    
    @Column(name="upper_entry")
    Boolean upperEntry
    
    @Column(name="intermediate_entry")
    Boolean intermediateEntry
    
    public CourseOption() {}
    
    public CourseOption(Course course, ExamOption examOption, Boolean lowerEntry, Boolean upperEntry, Boolean intermediateEntry) {
        this.course = course;
        this.examOption = examOption;
        this.lowerEntry = lowerEntry;
        this.upperEntry = upperEntry;
        this.intermediateEntry = intermediateEntry;
    }
}
