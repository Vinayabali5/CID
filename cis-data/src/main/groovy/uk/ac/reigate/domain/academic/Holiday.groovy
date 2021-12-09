package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity


@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "holiday_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Holiday extends BaseEntity {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='academic_year_id')
    AcademicYear year
    
    @Column(name="description")
    String description
    
    @Column(name="start_date")
    Date startDate
    
    @Column(name="end_date")
    Date endDate
    
    @Column(name="half_term")
    Boolean halfTerm
    
    /**
     * Default No Args constructor
     */
    Holiday(){}
    
    /**
     * The default toString method
     */
    String toString(){
        return description;
    }
}
