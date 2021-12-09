package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student

@Embeddable
@EqualsAndHashCode(includeFields=true)
class StudentCourseConcessionPk implements Serializable {
    
    Integer student
    
    Integer course
    
    Integer concessionType
    
    /**
     * Default NoArgs constructor
     */
    public StudentCourseConcessionPk() {}
    
    /**
     * Constructor for the main data object.
     * 
     * @param studentCourseConcession the data object to use for the PK.
     */
    public StudentCourseConcessionPk(StudentCourseConcession studentCourseConcession) {
        this.student = studentCourseConcession.student.id
        this.course = studentCourseConcession.course.id
        this.concessionType = studentCourseConcession.concessionType.id
    }
    
    /**
     * Constructor for the Primary Key elements.
     * 
     * @param student the student for the PK.
     * @param course the course for the PK.
     * @param concessionType the concessionType for the PK.
     */
    public StudentCourseConcessionPk(Student student, Course course, ConcessionType concessionType) {
        this.student = student.id
        this.course = course.id
        this.concessionType = concessionType.id
    }
    
    /**
     * Constructor for the Primary Key elements.
     * 
     * @param student the student for the PK.
     * @param course the course for the PK.
     * @param concessionType the concessionType for the PK.
     */
    public StudentCourseConcessionPk(Integer student, Integer course, Integer concessionType) {
        this.student = student
        this.course = course
        this.concessionType = concessionType
    }
}
