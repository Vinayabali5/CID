package uk.ac.reigate.domain.attendance

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student

/**
 * This Data Object is used to retrieve data from a table return user defined function on the SQL server. The data
 * returned is attendance figures for a specific student and course group combination for a given period. 
 * 
 * @author Michael Horgan
 *
 */
@Entity
@IdClass(StudentCourseGroupPk.class)
@EqualsAndHashCode
class StudentCourseGroupAttendance implements Serializable {
    
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'academic_year_id')
    AcademicYear year
    
    @Id
    @OneToOne
    @JoinColumn(name = 'student_id')
    Student student
    
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'course_id')
    Course course
    
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'course_group_id')
    CourseGroup courseGroup
    
    @Column(name = '[CourseSpec]')
    String courseSpec
    
    @Column(name = '[OverallTotal]')
    Integer overallTotal
    
    @Column(name = '[OverallIncluded]')
    Integer overallIncluded
    
    @Column(name = '[OverallPresent]')
    Integer overallPresent
    
    @Column(name = '[OverallAbsent]')
    Integer overallAbsent
    
    @Column(name = '[OverallAuthorisedAbsent]')
    Integer overallAuthorisedAbsent
    
    @Column(name = '[OverallLate]')
    Integer overallLate
    
    @Column(name = '[OverallAuthorisedLate]')
    Integer overallAuthorisedLate
    
    @Column(name = '[PeriodStartDate]')
    Date periodStartDate
    
    @Column(name = '[PeriodEndDate]')
    Date periodEndDate
    
    @Column(name = '[Total]')
    Integer total
    
    @Column(name = '[Included]')
    Integer included
    
    @Column(name = '[Present]')
    Integer present
    
    @Column(name = '[Absent]')
    Integer absent
    
    @Column(name = '[AuthorisedAbsent]')
    Integer authorisedAbsent
    
    @Column(name = '[Late]')
    Integer late
    
    @Column(name = '[AuthorisedLate]')
    Integer authorisedLate
}
