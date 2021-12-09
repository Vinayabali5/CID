package uk.ac.reigate.domain.ilr

import javax.persistence.JoinColumn
import javax.persistence.MappedSuperclass
import javax.persistence.OneToOne

import uk.ac.reigate.domain.CodedEntity
import uk.ac.reigate.domain.CodedEntityNoIdentity
import uk.ac.reigate.domain.academic.AcademicYear

@MappedSuperclass
abstract class ILREntityNoIdentity extends CodedEntityNoIdentity {
    
    String shortDescription
    
    Date validFrom
    
    Date validTo
    
    String toString() {
        return code + ' - ' + description
    }
}
