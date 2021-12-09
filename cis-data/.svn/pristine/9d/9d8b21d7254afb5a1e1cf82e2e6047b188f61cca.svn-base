package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

/**
 * The Note object is used to add extra information and comments to a Person object. Each note will have a NoteType that categorises the note.
 *   
 * @author Michael Horgan
 *
 */
@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "note_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Note extends BaseEntity {
    
    /**
     * The Person object to associate the Note with
     */
    @JsonIgnore
    @OneToOne
    @JoinColumn(name='person_id')
    Person person
    
    /**
     * The note 
     */
    @Column(name="note")
    String note
    
    /**
     * The type of note 
     */
    @OneToOne
    @JoinColumn(name='note_type_id')
    NoteType type
    
    /**
     * This fields determines pastoral or not 
     */
    @Column(name = "pastoral")
    Boolean pastoral
    
    /**
     * Default No Args constructor
     */
    Note(){}
    
    /**
     * The default toString method
     */
    String toString(){
        return note;
    }
}
