package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student

@Embeddable
@EqualsAndHashCode(includeFields=true)
class StudentCourseSupportTypePk implements Serializable {
    
    Integer student
    
    Integer course
    
    Integer supportType
    
    /**
     * Default NoArgs constructor
     */
    public StudentCourseSupportTypePk() {}
    
    /**
     * Constructor for the main data object.
     * 
     * @param studentCourseSupportType the data object to use for the PK.
     */
    public StudentCourseSupportTypePk(StudentCourseSupportType studentCourseSupportType) {
        this.student = studentCourseSupportType.student.id
        this.course = studentCourseSupportType.course.id
        this.supportType = studentCourseSupportType.supportType.id
    }
    
    /**
     * Constructor for the Primary Key elements.
     * 
     * @param student the student for the PK.
     * @param course the course for the PK.
     * @param supportType the supportType for the PK.
     */
    public StudentCourseSupportTypePk(Student student, Course course, SupportType supportType) {
        this.student = student.id
        this.course = course.id
        this.supportType = supportType.id
    }
    
    /**
     * Constructor for the Primary Key elements.
     * 
     * @param student the student for the PK.
     * @param course the course for the PK.
     * @param supportType the supportType for the PK.
     */
    public StudentCourseSupportTypePk(Integer student, Integer course, Integer supportType) {
        this.student = student
        this.course = course
        this.supportType = supportType
    }
}
