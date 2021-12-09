package uk.ac.reigate.domain.ilp

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@Table(name="ilp_statement_bank", schema = "ILP")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "ilp_statement_bank_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StatementBank extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name="ilp_statement_bank_type_id")
    StatementBankType statementBankType
    
    @Column(name = "letter", columnDefinition="nvarchar")
    String letterType
    
    @Column(name = "topic", columnDefinition="nvarchar")
    String topic
    
    @Column(name = "discussion", columnDefinition="nvarchar")
    String discussion
    
    @Column(name = "target", columnDefinition="nvarchar")
    String target
    
    @Column(name = "in_use")
    Boolean inUse
    
    @Column(name = "use_for_mass_letters")
    Boolean useForMassLetters
}
