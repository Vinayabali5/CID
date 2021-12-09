package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import java.util.Date;

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne


@Embeddable
@EqualsAndHashCode(includeFields=true)
class StudentEntryQualificationPk implements Serializable {
    
    Integer student
    
    Integer qualification
    
    Date date
    
    /**
     * Default No ARgs constructor
     */
    StudentEntryQualificationPk() {}
    
    /**
     * Default field based constructor
     *  
     * @param student the ID for the student
     * @param qualification the ID for the qualification
     * @param date the date for the student entry qualification
     */
    StudentEntryQualificationPk(Integer student, Integer qualification, Date date) {
        super();
        this.student = student;
        this.qualification = qualification;
        this.date = date;
    }
    
    StudentEntryQualificationPk(Student student, EntryQualification qualification, Date date) {
        super();
        this.student = student;
        this.qualification = qualification;
        this.date = date;
    }
}