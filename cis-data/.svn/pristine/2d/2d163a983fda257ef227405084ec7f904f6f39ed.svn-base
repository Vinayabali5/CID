package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.NamedEntity
import uk.ac.reigate.domain.Staff

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "department_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Department extends NamedEntity {
    
    /**
     * The faculty of the department.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='faculty_id')
    Faculty faculty
    
    /**
     * The hod is the Head Of Department
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='hod_id')
    Staff hod
    
    /**
     * The hod2 of the department.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='hod_2_id')
    Staff hod2
    
    /**
     * This field determines academic or not
     */
    @Column(name="academic")
    private Boolean academic;
    
    /**
     * Default No Args constructor
     */
    Department(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}
