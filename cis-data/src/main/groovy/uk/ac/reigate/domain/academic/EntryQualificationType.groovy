package uk.ac.reigate.domain.academic

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity
import uk.ac.reigate.domain.lookup.PossibleGradeSet

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "entry_qualification_type_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class EntryQualificationType extends CodedEntity implements Serializable{
    
    @Column(name="size")
    float size;
    
    @OneToOne
    @JoinColumn(name="possible_grade_set_id")
    PossibleGradeSet possibleGradeSet
    
    @Column(name="use_for_roe")
    Boolean useOfRoe
    /**
     * Default No Args constructor
     */
    EntryQualificationType() {}
    
    /**
     * The default toString method
     */
    String toString() {
        return description
    }
}
