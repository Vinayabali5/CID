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
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear

@Entity
@Table(name = "staff_inset_course", schema = "Staff")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "staff_inset_course_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StaffInsetCourse extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staff
    
    @OneToOne
    @JoinColumn(name = "inset_course_id")
    InsetCourse insetCourse
    
    @Column(name = "hours")
    Double hours
    
    @Column(name = "start_date")
    Date startDate
    
    @Column(name = "end_date")
    Date endDate
    
    StaffInsetCourse(){}
}

