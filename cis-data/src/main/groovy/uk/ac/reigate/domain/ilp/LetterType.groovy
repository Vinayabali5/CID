package uk.ac.reigate.domain.ilp

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
@Table(name="ilp_letter_type", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ilp_letter_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class LetterType extends BaseEntity{
    
    @Column(name = "ilp_letter_type", columnDefinition = "nvarchar")
    String type
    
    @Column(name = "require_target", columnDefinition = "bit DEFAULT (0)")
    Boolean requireTarget
    
    @Column(name = "require_authorisation", columnDefinition = "bit DEFAULT (0)")
    Boolean requireAuthorisation
    
    LetterType() {}
    
    String toString(){
        return type;
    }
}
