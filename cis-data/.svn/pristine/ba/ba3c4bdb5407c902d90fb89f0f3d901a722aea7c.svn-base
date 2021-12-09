package uk.ac.reigate.domain.learning_support

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity



@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "learning_support_cost_category_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class LearningSupportCostCategory extends BaseEntity {
    
    @Column(name = 'learning_support_cost_category')
    String category
    
    /**
     * Default No Args constructor
     */
    LearningSupportCostCategory() {}
    
    String toString() {
        return category
    }
}
