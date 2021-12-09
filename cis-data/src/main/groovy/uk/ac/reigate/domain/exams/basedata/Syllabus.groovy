package uk.ac.reigate.domain.exams.basedata

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonManagedReference

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@Table(name = "syllabus", schema = "Exams")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "syllabus_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Syllabus extends BaseEntity implements Serializable {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_series_id")
    private ExamSeries examSeries
    
    @Column(name = "code", length = 6)
    private String code
    
    @Column(name = "title", length = 36)
    private String title
    
    @JsonManagedReference
    @OneToMany(mappedBy = 'syllabus')
    List<ExamOption> examOptions
    
    
    /**
     * Default No Args constructor
     */
    public Syllabus() {}
    
    /**
     * The default toString method
     */
    String toString() {
        return code
    }
}
