package uk.ac.reigate.domain.lookup

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.CodedEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "gender_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Gender extends CodedEntity implements Serializable {
    
    @Column(name = "son_daughter", columnDefinition = "varchar")
    String sonDaughter
    
    @Column(name = "he_she", columnDefinition = "varchar")
    String heShe
    
    @Column(name = "his_her", columnDefinition = "varchar")
    String hisHer
    
    @Column(name = "him_her", columnDefinition = "varchar")
    String himHer
    
    Gender(){}
    
    String toString() {
        return description
    }
}
