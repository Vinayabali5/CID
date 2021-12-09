package uk.ac.reigate.domain.exams.edi

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption

@Embeddable
@EqualsAndHashCode(includeFields=true)
//@Canonical
class EdiAuditEntryLogPk implements Serializable {
    
    Integer student
    
    Integer examOption
    
    Integer ediAuditFileLog
    
    /**
     * Default NoArgs constructor
     */
    EdiAuditEntryLogPk() {}
    
    /**
     * Default fields based constructor
     * 
     * @param student the studentId to use to create the object
     * @param examOption the academicYearId to use to create the object
     */
    EdiAuditEntryLogPk(Integer studentId, Integer examOptionId, Integer ediAuditFileLogId) {
        super();
        this.student = studentId;
        this.examOption = examOptionId;
        this.ediAuditFileLog = ediAuditFileLogId;
    }
    
    EdiAuditEntryLogPk(Student student, ExamOption examOption) {
        super();
        this.student = student.id;
        this.examOption = examOption.id;
    }
    
    /**
     * Default fields based constructor
     * 
     * @param student the Student object to use to create the object
     * @param examOption the AcademicYear object to use to create the object
     */
    EdiAuditEntryLogPk(Student student, ExamOption examOption, EdiAuditFileLog ediAuditFileLog) {
        super();
        this.student = student.id;
        this.examOption = examOption.id;
        this.ediAuditFileLog = ediAuditFileLog.id
    }
    
    /**
     * Default fields based constructor
     *
     * @param ediAuditEntryLog the ediAuditEntryLog object to use to create the object
     */
    EdiAuditEntryLogPk(EdiAuditEntryLog ediAuditEntryLog) {
        super();
        this.student = ediAuditEntryLog.student.id;
        this.examOption = ediAuditEntryLog.examOption.id;
        this.ediAuditFileLog = ediAuditEntryLog.ediAuditFileLog.id
    }
}
