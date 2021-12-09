package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.exams.ExamBoard

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_predicted_grade_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StudentPredictedGrade extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name = "predicted_grade_id")
    EntryQualification predictedGrade
    
    @Column(name="grade")
    String grade
    
    @OneToOne
    @JoinColumn(name = "exam_board_id")
    ExamBoard examBoard
}
