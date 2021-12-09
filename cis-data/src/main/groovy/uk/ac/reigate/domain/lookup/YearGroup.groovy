package uk.ac.reigate.domain.lookup

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
    @AttributeOverride(name = "id", column = @Column(name = "year_group_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class YearGroup extends CodedEntity implements Serializable {
    
    @Column(name='exclude_tt_check')
    Boolean excludeTTCheck
    
    YearGroup(){}
    
    String toString() {
        return description
    }
}
