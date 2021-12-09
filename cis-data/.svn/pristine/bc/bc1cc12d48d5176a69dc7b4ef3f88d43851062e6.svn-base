package uk.ac.reigate.domain.register

import groovy.transform.EqualsAndHashCode;

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
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student;

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "register_mark_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class RegisterMark extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name='course_id')
    Course course
    
    @OneToOne
    @JoinColumn(name='course_group_id')
    CourseGroup courseGroup
    
    @OneToOne
    @JoinColumn(name='register_id')
    Register register
    
    @OneToOne
    @JoinColumn(name='student_id')
    Student student
    
    @OneToOne
    @JoinColumn(name='attendance_code_id')
    AttendanceCode attendanceCode
    
    RegisterMark(){}
    
    String toString() {
        return register.id;
    }
}
