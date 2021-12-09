package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity

@Entity
@Table(name="subject")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "subject_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Subject extends CodedEntity implements Serializable {
    
    Subject() {}
    
    String toString() {
        return description
    }
}
