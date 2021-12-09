package uk.ac.reigate.domain.exams

import javax.persistence.CascadeType;
import javax.persistence.Entity
import javax.persistence.Id;
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne;
import javax.persistence.Table;;;
import javax.validation.constraints.NotNull

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption

@Entity
@Table(name = "course_component", schema = "Exams")
@IdClass(CourseComponentPk.class)
class CourseComponent implements Serializable {
    
    @Id
    @NotNull
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "course_id", updatable = false, insertable = false, referencedColumnName = "course_id")
    Course course
    
    @Id
    @NotNull
    @ManyToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "exam_option_id", updatable = false, insertable = false, referencedColumnName = "exam_option_id")
    ExamOption examOption
    
    @Id
    @NotNull
    @OneToOne(cascade=[CascadeType.MERGE])
    @JoinColumn(name = "exam_component_id", updatable = false, insertable = false, referencedColumnName = "exam_component_id")
    ExamComponent examComponent
    
    /**
     * Default No Args constructor
     */
    public CourseComponent() {}
    
    public CourseComponent(Course course, ExamOption examOption, ExamComponent examComponent) {
        this.course = course;
        this.examOption = examOption;
        this.examComponent = examComponent;
    }
}
