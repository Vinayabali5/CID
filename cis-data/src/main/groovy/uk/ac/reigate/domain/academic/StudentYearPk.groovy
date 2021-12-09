package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

/**
 * StudentYear composite key definition
 * 
 * @author Michael Horgan
 *
 */
@Embeddable
@EqualsAndHashCode
class StudentYearPk implements Serializable {
    
    Integer student
    
    Integer year
    
    /**
     * Default NoArgs constructor
     */
    StudentYearPk() {}
    
    /**
     * Default fields based constructor
     * 
     * @param student the studentId to use to create the object
     * @param year the academicYearId to use to create the object
     */
    StudentYearPk(Integer student, Integer year) {
        super();
        this.student = student;
        this.year = year;
    }
    
    /**
     * Default fields based constructor
     * 
     * @param student the Student object to use to create the object
     * @param year the AcademicYear object to use to create the object
     */
    StudentYearPk(Student student, AcademicYear year) {
        super();
        this.student = student.id;
        this.year = year.id;
    }
}
