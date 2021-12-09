package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntityNoIdentity


@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "careers_record_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class CareersRecordType extends CodedEntityNoIdentity {
    
    /**
     * Default No Args constructor
     */
    CareersRecordType(){}
}
