package uk.ac.reigate.domain.interimreport

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.AcademicYear



@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "interim_report_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class InterimReport extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    AcademicYear year
    
    @Column
    String description
    
    @Column(name="start_date")
    Date startDate
    
    @Column(name="end_date")
    Date endDate
    
    @Column(name="publish_date")
    Date publishDate
    
    @Column(name="active")
    Boolean active
    
    /**
     * Default No Args constructor
     */
    InterimReport() {}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}

