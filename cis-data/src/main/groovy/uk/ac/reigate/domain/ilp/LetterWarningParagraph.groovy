package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntityNoIdentity

@Entity
@Table(name="ilp_letter_warning_paragraph", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ilp_letter_warning_paragraph_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class LetterWarningParagraph extends BaseEntityNoIdentity{
    
    @Column(name = "description", columnDefinition = "nvarchar")
    String description
    
    LetterWarningParagraph() {}
    
    String toString(){
        return description;
    }
}
