package uk.ac.reigate.domain.system

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "letter_template_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class LetterTemplate extends BaseEntity implements Serializable {
    
    @Column(name= 'name')
    String name
    
    @Column(name = 'description')
    String description
    
    @Column(name = 'template_text')
    String templateText
    
    @Column(name = 'in_use')
    Boolean inUse
    
    /**
     * Default NoArgs constructor
     */
    LetterTemplate(){
    }
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}