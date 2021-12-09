package uk.ac.reigate.domain.exams

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption

@Embeddable
@EqualsAndHashCode(includeFields=true)
class StudentOptionEntryPk implements Serializable {
    
    Integer student;
    
    Integer examOption;
    
    /**
     * Default NoArgs constructor
     */
    StudentOptionEntryPk() {}
    
    /**
     * Default fields based constructor
     * 
     * @param student the studentId to use to create the object
     * @param option the academicYearId to use to create the object
     */
    StudentOptionEntryPk(Integer studentId, Integer examOptionId) {
        super();
        this.student = studentId;
        this.examOption = examOptionId;
    }
    
    /**
     * Default fields based constructor
     * 
     * @param student the Student object to use to create the object
     * @param option the AcademicYear object to use to create the object
     */
    StudentOptionEntryPk(Student student, ExamOption examOption) {
        super();
        this.student = student.id;
        this.examOption = examOption.id;
    }
    
    
    StudentOptionEntryPk(StudentOptionEntry studentOptionEntry){
        super();
        this.student =  studentOptionEntry.student.id
        this.examOption = studentOptionEntry.examOption.id
    }
}
