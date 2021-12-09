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

import uk.ac.reigate.domain.CodedEntity
import uk.ac.reigate.domain.Staff

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "faculty_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Faculty extends CodedEntity {
    
    /**
     * The hof is the Head of the Faculty
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='hof_id')
    Staff hof
    
    /**
     * The dol is the Director of Learning
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='dol_id')
    Staff dol
    
    /**
     * The adol is the Associate Director of Learning
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='adol_id')
    Staff adol
    
    /**
     * The pd is the Principal Director 
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='pd_id')
    Staff pd
    
    /**
     * The apd is the Associate Principal Director 
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name='apd_id')
    Staff apd
    
    /**
     * The valid from date of the faculty.
     */
    @Column(name="valid_from")
    Date validFrom
    
    /**
     * The valid to date of the faculty.
     */
    @Column(name="valid_to")
    Date validTo
    
    /**
     * Default No Args constructor
     */
    Faculty(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}
