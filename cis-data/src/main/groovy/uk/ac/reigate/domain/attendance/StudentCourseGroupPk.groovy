package uk.ac.reigate.domain.attendance

import groovy.transform.EqualsAndHashCode

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student

/**
 * This class is used to define a Composite Primary key that includes the AcademicYear, Student, Course and
 * CourseGroup.
 * 
 * @author Michael Horgan
 *
 */
@EqualsAndHashCode
class StudentCourseGroupPk implements Serializable {
    
    AcademicYear year
    
    Student student
    
    Course course
    
    CourseGroup courseGroup
}
