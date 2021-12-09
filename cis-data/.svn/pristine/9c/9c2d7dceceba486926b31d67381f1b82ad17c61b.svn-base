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
@Table(name="correspondence_type", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "correspondence_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class CorrespondenceType extends BaseEntityNoIdentity {
    
    @Column(name = "correspondence_type", columnDefinition = "nvarchar")
    String type
    
    CorrespondenceType() {}
    
    String toString(){
        return type;
    }
}
