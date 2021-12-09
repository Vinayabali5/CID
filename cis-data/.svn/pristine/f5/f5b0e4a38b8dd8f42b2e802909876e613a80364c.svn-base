package uk.ac.reigate.domain.security

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

import com.fasterxml.jackson.annotation.JsonIgnore

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import org.springframework.security.core.GrantedAuthority

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.Person

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "role_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(excludes = "users")
class Role extends BaseEntity implements GrantedAuthority {
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    name='person_role',
    joinColumns=@JoinColumn(name="role_id", referencedColumnName="role_id"),
    inverseJoinColumns=@JoinColumn(name="person_id", referencedColumnName="person_id")
    )
    @JsonIgnore
    Set<Person> users
    
    @Column(name='role_name')
    String roleName
    
    @Column(name='description')
    String roleDescription
    
    /**
     * No Args constructor, required for Spring Data JPA
     */
    Role() {}
    
    
    String toString() {
        return roleName
    }
    
    @Override
    public String getAuthority() {
        return roleName
    }
}
