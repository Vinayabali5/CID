package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.BaseEntityNoIdentity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "support_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class SupportType extends BaseEntityNoIdentity {
    
    @Column(name = 'support_type')
    String support
    
    SupportType() {}
    
    SupportType(Integer id, String support) {
        this.id = id;
        this.support = support;
    }
    
    SupportType(String support) {
        this(null, support)
    }
    
    String toString() {
        return support
    }
}
