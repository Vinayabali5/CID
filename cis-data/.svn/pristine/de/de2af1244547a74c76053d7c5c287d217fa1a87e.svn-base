package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntityNoIdentity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "academic_year_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields = true, excludes = ["holidays"])
class AcademicYear extends CodedEntityNoIdentity {
    
    /**
     * The end date of the academic year.
     */
    @Column(name="end_date")
    Date endDate
    
    /**
     * The start sate of the academic year.
     */
    @Column(name="start_date")
    Date startDate
    
    /**
     * The start year  of the academic year.
     */
    @Column(name = "start_year", columnDefinition = "smallint")
    Integer startYear
    
    @OneToMany(mappedBy='year', fetch = FetchType.LAZY)
    Set<Holiday> holidays
    
    /**
     * The enumeration date of the academic year.
     */
    @Column(name = "enumeration_date")
    Date enumerationDate
    
    /**
     * The teaching start date of the academic year.
     */
    @Column(name = "teaching_start_date")
    Date teachingStartDate
    
    /**
     * The teaching end date of the academic year.
     */
    @Column(name = "teaching_end_date")
    Date teachingEndDate
    
    /**
     * Default NoArgs constructor
     */
    AcademicYear(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return this.description + ' (' + this.code + ')'
    }
}
