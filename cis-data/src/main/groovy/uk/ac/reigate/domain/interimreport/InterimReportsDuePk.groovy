package uk.ac.reigate.domain.interimreport

import javax.persistence.Embeddable

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup

@Embeddable
@EqualsAndHashCode(includeFields = true)
class InterimReportsDuePk implements Serializable {
    
    Integer course
    
    Integer courseGroup
    
    Integer interimReport
    
    /**
     * Default NoArgs constructor
     */
    InterimReportsDuePk() {}
    
    /**
     * Default fields based constructor
     * 
     * @param courseGroup the courseGroupId to use to create the object
     * @param interimReport the interimReportId to use to create the object
     */
    InterimReportsDuePk( Integer interimReport,  Integer course, Integer courseGroup){
        super();
        this.interimReport = interimReport;
        this.courseGroup = courseGroup;
        this.course = course;
    }
    
    InterimReportsDuePk( InterimReport interimReport,  Course course, CourseGroup courseGroup){
        super();
        this.interimReport = interimReport.id;
        this.courseGroup = courseGroup.id;
        this.course = course.id;
    }
    
    InterimReportsDuePk(InterimReportsDue interimReportsDue) {
        this.course = interimReportsDue.course.id
        this.courseGroup = interimReportsDue.courseGroup.id
        this.interimReport = interimReportsDue.interimReport.id
    }
}
