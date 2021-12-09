package uk.ac.reigate.domain.interimreport

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student

/**
 * <p>This class can be used as a composite key for Student Interim Report based data sets.</p>
 *  
 * <p>The fields in this composite key are:<ul>
 * <li>student_id</li>
 * <li>interim_report_id</li>
 * <li>course_id</li>
 * <li>course_group_id</li>
 * </ul></p>
 *  
 * @author Michael Horgan
 *
 */
@Embeddable
@EqualsAndHashCode(includeFields = true)
class StudentInterimReportPk implements Serializable {
    
    @Column(name = "student_id")
    Integer student
    
    @Column(name = "interim_report_id")
    Integer interimReport
    
    @Column(name = "course_id")
    Integer course
    
    @Column(name = "course_group_id")
    Integer courseGroup
    
    /**
     * NoArgs constructor
     */
    StudentInterimReportPk() {}
    
    /**
     * A constructor using the raw data,
     * 
     * @param student Integer value
     * @param interimReport Integer value
     * @param course Integer value
     * @param courseGroup Integer value
     */
    StudentInterimReportPk(Integer student, Integer interimReport, Integer course, Integer courseGroup){
        this.student = student;
        this.interimReport = interimReport;
        this.course = course;
        this.courseGroup = courseGroup
    }
    
    /**
     * A constructor using the object based data,
     * 
     * @param student Student data object
     * @param interimReport InterimReport data object
     * @param course Course data object
     * @param courseGroup CourseGroup data object
     */
    StudentInterimReportPk(Student student, InterimReport interimReport, Course course, CourseGroup courseGroup){
        this.student = student.id;
        this.interimReport = interimReport.id;
        this.course = course.id;
        this.courseGroup = courseGroup.id
    }
}