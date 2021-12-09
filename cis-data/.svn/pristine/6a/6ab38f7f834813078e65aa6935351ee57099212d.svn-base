package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "block_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Block extends CodedEntity {
    
    /**
     * The html colour of the block
     */
    @Column(name = 'html_colour')
    String htmlColour
    
    /**
     * The access colour of the block
     */
    @Column(name = 'access_colour')
    String accessColour
    
    /**
     * Default No Args constructor
     */
    Block(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}
