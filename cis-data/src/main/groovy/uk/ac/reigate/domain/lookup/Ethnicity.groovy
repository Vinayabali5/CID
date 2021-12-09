package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.ilr.ILREntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ethnicity_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Ethnicity extends ILREntity implements Serializable {
    
    Ethnicity(){}
}

