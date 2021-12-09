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
class Period extends CodedEntity{
    
    @OneToOne
    @JoinColumn(name='block_id')
    Block block
    
    @Column(name="start_time")
    Date startTime
    
    @Column(name="end_time")
    Date endTime
    
    @Column(name="day")
    Integer day
    
    @Column(name="day_period")
    Integer dayPeriod
    
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
    Period(){}
    
    String toString() {
        return description
    }
}
