package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@Table(name = "text_lookup", schema = "Data")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class TextLookup extends BaseEntity implements Serializable  {
    
    
    @Column(name="Name", columnDefinition = "nvarchar")
    String name
    
    @Column(name="Text",  columnDefinition = "nvarchar")
    String text
    
    
    @Column(name="Description", columnDefinition = "nvarchar")
    String description
    
    
    TextLookup(){
    }
    
    
    TextLookup(Integer id, String name, String text, String description){
        this.id = id
        this.name = name
        this.text = text
        this.description = description
    }
}
