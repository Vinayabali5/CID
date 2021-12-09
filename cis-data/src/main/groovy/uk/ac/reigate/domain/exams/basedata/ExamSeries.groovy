package uk.ac.reigate.domain.exams.basedata

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.ExamBoard

@Entity
@Table(name = "exam_series", schema = "Exams")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "exam_series_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ExamSeries extends BaseEntity implements Serializable {
    
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "academic_year_id")
    AcademicYear academicYear
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_board_id")
    ExamBoard examBoard
    
    @Column(name = "exam_year", length = 4)
    String examYear
    
    @Column(name = "exam_series", length = 2)
    String examSeries
    
    @Column(name = "entry_submitted")
    Boolean entrySubmitted
    
    @Column(name = "next_sequence_no")
    Integer nextSequenceNo
    
    @OneToMany(mappedBy = "examSeries")
    List<Syllabus> syllabi
    
    /**
     * Default noArgs constructor
     */
    ExamSeries() {}
    
    /**
     * The toString function for the ExamBoard object returns the name as specified.
     */
    @Override
    public String toString() {
        return this.examYear + " - " + this.examSeries
    }
}
