package uk.ac.reigate.domain.staffsignin

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
import uk.ac.reigate.domain.Staff

@Entity
@Table(name = "staff_signin", schema = "Staff")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "staff_signin_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class StaffSignin extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    Staff staff
    
    @Column(name = "signin_time")
    Date signinTime
    
    @Column(name = "signout_time")
    Date signoutTime
}
