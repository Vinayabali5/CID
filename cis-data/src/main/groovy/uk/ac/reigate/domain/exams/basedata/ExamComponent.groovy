package uk.ac.reigate.domain.exams.basedata

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonFormat;;

import uk.ac.reigate.domain.BaseEntity

@Entity
@Table(name = "exam_component", schema = "Exams")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "exam_component_id"))
])
class ExamComponent extends BaseEntity implements Serializable {
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "exam_series_id")
    private ExamSeries examSeries
    
    @OneToMany(mappedBy = "examComponent")
    private List<OptionComponent> optionComponents
    
    @Column(name = "code", length = 12)
    private String code
    
    @Column(name = "title", length = 36)
    private String title
    
    @Column(name = "teacher_marks", length = 1)
    private String teacherMarks
    
    @Column(name = "maximum_mark")
    private Integer maximumMark
    
    @Column(name = "gradeset", length = 4)
    private String gradeset
    
    @Column(name = "due_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate
    
    @Column(name = "timetabled", length = 1)
    private String timetabled
    
    @Column(name = "timetable_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date timetableDate
    
    @Column(name = "timetable_session", length = 1)
    private String timetableSession
    
    @Column(name = "time_allowed")
    private Integer timeAllowed
    
    /**
     * Default noArgs constructor
     */
    public ExamComponent() {}
    
    /**
     * The toString function for the ExamComponent object returns the name as specified.
     */
    @Override
    public String toString() {
        return code
    }
}
