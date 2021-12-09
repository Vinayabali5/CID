package uk.ac.reigate.domain.exams
import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.domain.exams.edi.StatusType

@Entity
@Table(name = "student_option_entry", schema = "Exams")
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@IdClass(StudentOptionEntryPk.class)
class StudentOptionEntry  implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = "exam_option_id")
    ExamOption examOption
    
    @OneToOne
    @JoinColumn(name='status_type_id')
    StatusType statusType
    
    @OneToOne
    @JoinColumn(name='edi_status_type_id')
    EdiStatusType ediStatusType
    
    @Column(name='resit')
    Boolean resit
    
    @Column(name='private_student')
    Boolean privateStudent
    
    StudentOptionEntry() {}
    
    StudentOptionEntry(Student student, ExamOption examOption, StatusType statusType, EdiStatusType ediStatusType, Boolean resit, Boolean privateStudent){
        this.student = student;
        this.examOption = examOption;
        this.statusType = statusType;
        this.ediStatusType = ediStatusType;
        this.resit = resit;
        this.privateStudent = privateStudent;
    }
    
    String toString() {
        return student
    }
}

