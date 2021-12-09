package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory

@Entity
@Table(name = "student_lldd_health_problem_category")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_lldd_health_problem_category_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode
class StudentLLDDHealthProblemCategory extends BaseEntity implements Serializable {
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'student_id')
    Student student
    
    @OneToOne
    @JoinColumn(name = 'lldd_health_problem_category_id')
    LLDDHealthProblemCategory lLDDHealthProblemCategory
    
    @Column(name = '`primarylldd`')
    Boolean primarylldd
    
    StudentLLDDHealthProblemCategory() {}
}

