package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.academic.Student

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@IdClass(StudentConcessionTypePk.class)
class StudentConcessionType implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = 'student_id')
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = 'concession_type_id')
    ConcessionType concessionType
    
    @Column(name = 'extra_time_percentage')
    Integer extraTimePercentage
    
    /**
     * Default noArgs constructor
     */
    StudentConcessionType() {}
    
    StudentConcessionType(Student student, ConcessionType concessionType, Integer extraTimePercentage){
        this.student = student;
        this.concessionType = concessionType;
        this.extraTimePercentage = extraTimePercentage;
    }
    
    String toString() {
        return student
    }
}
