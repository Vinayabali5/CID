package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Student

@Embeddable
@EqualsAndHashCode(includeFields=true)
class StudentConcessionTypePk implements Serializable {
    
    Integer student
    
    Integer concessionType
    
    StudentConcessionTypePk() {}
    
    StudentConcessionTypePk(Integer studentId, Integer concessionTypeId) {
        super();
        this.student = studentId;
        this.concessionType = concessionTypeId;
    }
    
    StudentConcessionTypePk(Student student, ConcessionType concessionType) {
        super();
        this.student = student.id;
        this.concessionType = concessionType.id;
    }
    
    StudentConcessionTypePk(StudentConcessionType studentConcessionType){
        this.student = studentConcessionType.student.id
        this.concessionType = studentConcessionType.concessionType.id
    }
}
