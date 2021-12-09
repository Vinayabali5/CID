package uk.ac.reigate.domain.exams.edi
import groovy.transform.EqualsAndHashCode

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

@Entity
@Table(name = "edi_audit_entry_log", schema = "Exams")
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@IdClass(EdiAuditEntryLogPk.class)
class EdiAuditEntryLog  implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Id
    @OneToOne
    @JoinColumn(name = "exam_option_id")
    ExamOption examOption
    
    @Id
    @OneToOne
    @JoinColumn(name = "edi_audit_file_log_id")
    EdiAuditFileLog ediAuditFileLog
    
    
    EdiAuditEntryLog() {}
    
    EdiAuditEntryLog(Student student, ExamOption examOption, EdiAuditFileLog ediAuditFileLog){
        this.student = student;
        this.examOption = examOption;
        this.ediAuditFileLog = ediAuditFileLog
    }
    
    String toString() {
        return "EdiAuditEntryLog [student: " + student.toString() +
                ", examOption: " + examOption.toString() +
                ", ediAuditFileLog: " + ediAuditFileLog.toString();
    }
}

