package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "similar_named_student", schema = "dbo")
@EqualsAndHashCode(includeFields=true)
@IdClass(SimilarNamedStudentPk.class)
class SimilarNamedStudent implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    Student student
    
    @Id
    @ManyToOne
    @JoinColumn(name = "academic_year_id", insertable = false, updatable = false)
    AcademicYear academicYear
    
    @Column(name= "number_similar_names")
    Integer numberSimilarNames
    
    SimilarNamedStudent() {}
}
