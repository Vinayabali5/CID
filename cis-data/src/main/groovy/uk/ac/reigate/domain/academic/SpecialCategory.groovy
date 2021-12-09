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
    @AttributeOverride(name = "id", column = @Column(name = "special_category_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class SpecialCategory extends CodedEntity {
    
    @Column(name="details")
    String details
    
    @Column(name="priority")
    Integer priority
    
    @Column(name="send_email")
    Boolean sendEmail
    
    /**
     * Default No Args constructor
     */
    SpecialCategory(){}
    
    String toString() {
        return description
    }
}
