package uk.ac.reigate.domain.interimreport

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

@Embeddable
@EqualsAndHashCode(includeFields = true)
class CourseGroupInterimReportPk implements Serializable {
    
    Integer courseGroup
    
    Integer interimReport
    
    /**
     * Default NoArgs constructor
     */
    CourseGroupInterimReportPk() {}
    
    /**
     * Default fields based constructor
     * 
     * @param courseGroup the courseGroupId to use to create the object
     * @param interimReport the interimReportId to use to create the object
     */
    CourseGroupInterimReportPk(Integer courseGroup, Integer interimReport){
        super();
        this.courseGroup = courseGroup;
        this.interimReport = interimReport;
    }
    
    CourseGroupInterimReportPk(CourseGroupInterimReport courseGroupInterimReport) {
        this.courseGroup = courseGroupInterimReport.courseGroup.id
        this.interimReport = courseGroupInterimReport.interimReport.id
    }
}
