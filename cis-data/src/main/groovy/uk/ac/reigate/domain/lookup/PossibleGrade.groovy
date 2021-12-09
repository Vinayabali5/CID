package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "possible_grade_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class PossibleGrade extends CodedEntity {
    
    @ManyToOne
    @JoinColumn(name = 'possible_grade_set_id')
    PossibleGradeSet gradeSet
    
    @Column(name='grade')
    String grade
    
    @Column(name='ucas_points')
    Integer ucasPoints
    
    @Column(name = 'key_assessment_grade')
    Boolean useForKeyAssessment
    
    @Column(name = 'alis_points')
    Float alisPoints
    
    @Column(name = 'alps_points')
    Float alpsPoints
    
    PossibleGrade(){}
    
    String toString() {
        return description
    }
}
