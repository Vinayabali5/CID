package uk.ac.reigate.domain.risk_assessment

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
    @AttributeOverride(name = "id", column = @Column(name = "risk_level_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class RiskLevel extends CodedEntityNoIdentity implements Serializable {
    
    @Column(name = 'priority')
    Integer priority
    
    @Column(name = 'send_email')
    Boolean sendEmail
    
    @Column(name = 'send_email_safeguarding')
    Boolean sendEmailSafeguarding
    
    RiskLevel(){}
    
    String toString() {
        return description
    }
}
