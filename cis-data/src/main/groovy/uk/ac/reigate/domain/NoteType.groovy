package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

/**
 * This is a lookup table that describes different types of Note object that can be created.
 * 
 * @author Michael Horgan
 *
 */
@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "note_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class NoteType extends CodedEntity {
    
    /**
     * Default No Args constructor
     */
    NoteType(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}
