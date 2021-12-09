package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "student_work_placement_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@Table(name = "student_work_placement")
class StudentWorkPlacement extends BaseEntity implements Serializable {
    
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student
    
    @Column(name="start_date")
    Date startDate
    
    @Column(name="end_date")
    Date endDate
    
    @Column(name="placement_hours")
    Float placementHours
    
    @OneToOne
    @JoinColumn(name="work_placement_mode_id")
    WorkPlacementMode workPlacementMode
    
    @Column(name="employer")
    String employer
    
    @Column(name="extra_details")
    String extraDetails
    
    StudentWorkPlacement(){}
    
    String toString() {
        return student
    }
}
