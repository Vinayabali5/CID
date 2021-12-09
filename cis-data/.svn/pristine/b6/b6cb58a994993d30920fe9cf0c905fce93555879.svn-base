package uk.ac.reigate.domain

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.validation.Constraint
import javax.validation.constraints.NotNull

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.constraints.CodeRequiredConstraint

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "room_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Room extends CodedEntity implements Serializable {
    
    /**
     * The RoomType of this particular room
     */
    @OneToOne
    @JoinColumn(name='room_type_id')
    @NotNull
    RoomType roomType
    
    /**
     * The capacity for the room.
     */
    @Column(name="capacity")
    Integer capacity
    
    @Column(name="CodeNLZ")
    String codeNLZ
    
    @Column(name="NEW_CODE")
    String newCode
    
    /**
     * The default rows for the room.
     */
    @Column(name="default_rows")
    Integer defaultRows
    
    /**
     * The default columns for the room
     */
    @Column(name="default_cols")
    Integer defaultCols
    
    /**
     * Default No Args constructor
     */
    Room(){}
    
    /**
     * The default toString method    
     */
    String toString() {
        return description
    }
}
