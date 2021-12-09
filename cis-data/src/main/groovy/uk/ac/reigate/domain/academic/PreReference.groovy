package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import uk.ac.reigate.domain.lookup.PossibleGrade


@Entity
@Table(name = "pre_reference", schema = "Reference")
@EqualsAndHashCode(includeFields=true)
@IdClass(PreReferencePk.class)
class PreReference implements Serializable {
    
    @Id
    @OneToOne(fetch=FetchType.LAZY, optional = true)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    Student student
    
    @Id
    @OneToOne(fetch=FetchType.LAZY, optional = true)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    Course course
    
    @OneToOne
    @JoinColumn(name = "predicted_grade_id")
    PossibleGrade predictedGrade
    
    PreReference() {}
}
