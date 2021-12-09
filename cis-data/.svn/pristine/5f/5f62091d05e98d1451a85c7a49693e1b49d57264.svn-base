package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

/**
 * Primary Key class for the StaffInterestedInStudent view
 */
@EqualsAndHashCode(includeFields=true)
class PreReferencePk implements Serializable {
    
    Integer student
    
    Integer course
    
    public PreReferencePk() {}
    
    public PreReferencePk(Integer student, Integer course) {
        this.student = student;
        this.course = course;
    }
    
    public PreReferencePk(Student student, Course course) {
        this.student = student.id;
        this.course = course.id;
    }
    
    public PreReferencePk(PreReference preReference) {
        this.student = preReference.student.id;
        this.course = preReference.course.id;
    }
}
