package uk.ac.reigate.domain.exams.basedata

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint;

import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Entity
@Table(name = "exam_type", schema = "Exams", uniqueConstraints = @UniqueConstraint(columnNames = ["exam_type_id", "qualification", "level"]))
class ExamType implements Serializable {
    
    private final static Logger log = LoggerFactory.getLogger(ExamType.class.getName())
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_type_id")
    private long examTypeId
    
    @Column(name = "qualification", length = 4)
    private String qualification
    
    @Column(name = "level", length = 3)
    private String level
    
    /**
     * Default noArgs constructor
     */
    public ExamType() {}
    
    /**
     * The toString function for the ExamType object returns the name as specified.
     */
    @Override
    public String toString() {
        return this.qualification
    }
}
