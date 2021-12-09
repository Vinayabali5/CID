package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity


@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "period_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class AlternativePeriod extends CodedEntity{
    
    @Column(name="day")
    Integer day
    
    @Column(name="day_period")
    Integer dayPeriod
    
    @Column(name="LVI_start_time")
    Date LviStartTime
    
    @Column(name="LVI_end_time")
    Date LviEndTime
    
    @Column(name="UVI_start_time")
    Date UviStartTime
    
    @Column(name="UVI_end_time")
    Date UviEndTime
    
    @OneToOne
    @JoinColumn(name='block_id')
    Block block
    
    @Column(name="box_no")
    Integer boxNo
    
    @Column(name="cristal_period")
    Integer cristalPeriod
    
    @Column(name="length", insertable=false, updatable=false)
    Integer length
    
    @Column(name="default_period_text")
    String defaultPeriodText
    
    /**
     * Default No Args constructor
     */
    AlternativePeriod(){}
    
    String toString() {
        return description
    }
}
