package uk.ac.reigate.domain.attendance

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

@Embeddable
@EqualsAndHashCode(includeFields = true)
class StudentAttendancePk implements Serializable {
    
    Integer student
    
    Integer course
    
    Integer academicYear
    
    /**
     * Default NoArgs constructor
     */
    StudentAttendancePk() {}
    
    /**
     * Default fields based constructor
     * 
     * @param courseGroup the courseGroupId to use to create the object
     * @param interimReport the interimReportId to use to create the object
     */
    StudentAttendancePk(Integer student, Integer course, Integer academicYear){
        super();
        this.student = student;
        this.course = course;
        this.academicYear = academicYear;
    }
    
    StudentAttendancePk(StudentAttendance studentAttendance) {
        this.student = studentAttendance.student.id
        this.course = studentAttendance.course.id
        this.academicYear = studentAttendance.academicYear.id
    }
}
