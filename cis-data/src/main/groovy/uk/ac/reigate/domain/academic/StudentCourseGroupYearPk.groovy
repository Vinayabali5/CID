package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Embeddable
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StudentCourseGroupYearPk implements Serializable {
    
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='student_id')
    Student student
    
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='course_group_id')
    CourseGroup courseGroup
    
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='academic_year_id')
    AcademicYear year
}
