package uk.ac.reigate.domain.admissions

import groovy.transform.EqualsAndHashCode;

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "interview_category_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class InterviewCategory extends BaseEntity {
    
    @Column(name = 'category')
    String category
    
    @Column(name = 'description')
    String description
    
    InterviewCategory(){}
    
    String toString() {
        return this.description
    }
}
