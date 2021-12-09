package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity

/**
 * This is a database entity used to store the lookup values for a Persons title. <br/>
 * i.e. Mr., Mrs., etc.
 * 
 * @author Michael Horgan
 *
 */
@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "title_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Title extends CodedEntity implements Serializable {
    
    Title(){}
    
    String toString() {
        return description
    }
}
