package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate


@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "room_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class RoomType extends CodedEntityNoIdentity {
    
    /**
     * This field determines timetableable or not
     */
    @Column(name="timetableable")
    Boolean timetableable
    
    /**
     * Default No Args constructor
     */
    RoomType() {}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}
