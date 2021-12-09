package uk.ac.reigate.domain.lookup

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

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "level_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Level extends CodedEntity {
    
    @OneToOne
    @JoinColumn(name = "possible_grade_set_id")
    PossibleGradeSet possibleGradeSet
    
    @Column(name="progression_to")
    Integer progressionTo
    
    @Column(name = "alis_qual_code", columnDefinition = "nvarchar")
    String alisQualCode
    
    @Column(name="academic")
    Boolean academic
    
    @Column(name="core_aim_priority")
    Integer coreAimPriority
    
    @Column(name="sar_include")
    Boolean sarInclude
    
    @Column(name="rqf_level")
    Integer rqfLevel
    
    @Column(name = "qualification_framework")
    String qualificationFramework
    
    @Column(name = "DfE_qual_name")
    String dfeQualName
    
    @Column(name = "in_use")
    Boolean inUse
    
    Level() {}
    
    String toString() {
        return this.description + ' (' + this.code + ')'
    }
}
