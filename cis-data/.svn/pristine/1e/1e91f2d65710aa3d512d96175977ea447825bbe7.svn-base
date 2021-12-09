package uk.ac.reigate.domain.academic

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "identification_violation_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
class IdentificationViolation extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name="student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name="academic_year_id")
    AcademicYear year
    
    Date date
    
    Boolean returned
    
    Boolean lost
    
    Boolean printed
    
    Boolean replacementPaidFor
    
    Integer id_number
}
