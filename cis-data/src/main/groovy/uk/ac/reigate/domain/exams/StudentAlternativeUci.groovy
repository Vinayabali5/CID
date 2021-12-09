package uk.ac.reigate.domain.exams


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
@IdClass(StudentAlternativeUciPk.class)
class StudentAlternativeUci {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = "exam_board_id")
    ExamBoard examBoard
    
    @Column(name = "alternative_uci")
    String alternativeUci
    
    StudentAlternativeUci(){
    }
    
    StudentAlternativeUci(Student student, ExamBoard examboard, String alternativeUci){
        this.student = student
        this.examBoard=examboard
        this.alternativeUci=alternativeUci
    }
}


