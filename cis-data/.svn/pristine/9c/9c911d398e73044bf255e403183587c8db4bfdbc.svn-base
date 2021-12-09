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

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "external_result_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ExternalResultsArchive extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Column(name="course_spec")
    String courseSpec
    
    @Column(name="level_description")
    String levelDescription
    
    @Column(name="subject_description")
    String subjectDescription
    
    @Column(name="syllabus")
    String syllabus
    
    @Column(name="grade")
    String grade
    
    @Column(name="mark")
    String mark
    
    @Column(name="max_mark")
    String maxMark
    
    @Column(name="date_achieved")
    Date dateAchieved
    
    @Column(name="series")
    String series
    
    @Column(name="year")
    String year
    
    @Column(name="exam_type")
    String examType
    
    /**
     * Default No Args constructor
     */
    ExternalResultsArchive() {}
    
    /**
     * The default toString method
     */
    String toString() {
        return student
    }
}

