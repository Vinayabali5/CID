package uk.ac.reigate.domain.staff

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.AcademicYear

@Entity
@Table(name = "inset_course", schema = "Staff")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "inset_course_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class InsetCourse extends BaseEntity implements Serializable {
    
    @Column(name = "course_title")
    String courseTitle
    
    @Column(name = "course_notes")
    String courseNotes
    
    @Column(name = "start_date")
    Date startDate
    
    @Column(name = "end_date")
    Date endDate
    
    @OneToOne
    @JoinColumn(name = "academic_year_id")
    AcademicYear academicYear
    
    InsetCourse(){}
}

