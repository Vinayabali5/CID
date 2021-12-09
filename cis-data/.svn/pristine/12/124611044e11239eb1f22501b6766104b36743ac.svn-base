package uk.ac.reigate.domain.learning_support

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
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_course_concession_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StudentCourseConcession extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = 'student_id')
    Student student
    
    @OneToOne
    @JoinColumn(name = 'course_id')
    Course course
    
    @OneToOne
    @JoinColumn(name = 'concession_type_id')
    ConcessionType concessionType
    
    @Column(name = 'extra_time_percentage')
    Integer extraTimePercentage
    
    StudentCourseConcession() {}
}
